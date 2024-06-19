package main.visitor.codeGenerator;

import main.ast.nodes.Node;
import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.declaration.VarDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.value.FunctionPointer;
import main.ast.nodes.expression.value.ListValue;
import main.ast.nodes.expression.value.primitive.BoolValue;
import main.ast.nodes.expression.value.primitive.IntValue;
import main.ast.nodes.expression.value.primitive.StringValue;
import main.ast.nodes.statement.*;
import main.ast.type.FptrType;
import main.ast.type.ListType;
import main.ast.type.Type;
import main.ast.type.primitiveType.BoolType;
import main.ast.type.primitiveType.IntType;
import main.ast.type.primitiveType.StringType;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFound;
import main.symbolTable.item.FunctionItem;
import main.visitor.Visitor;
import main.visitor.type.TypeChecker;

import java.io.*;
import java.util.*;

public class CodeGenerator extends Visitor<String> {
    private final String outputPath;
    private FileWriter mainFile;
    private final TypeChecker typeChecker;
    private final Set<String> visited;
    private FunctionItem curFunction;
    private final HashMap<String, Integer> slots = new HashMap<>();
    private int curLabel = 0;

    private static LinkedList<String> breakLabels = new LinkedList<>();
    private static LinkedList<String> afterLabels = new LinkedList<>();

    public CodeGenerator(TypeChecker typeChecker) {
        this.typeChecker = typeChecker;
        this.visited = typeChecker.visited;
        outputPath = "./codeGenOutput/";
        prepareOutputFolder();
    }

    private int slotOf(String var) {
        return slots.computeIfAbsent(var, k -> slots.size());
    }


    public String getFreshLabel() {
        return "Label_" + curLabel++;
    }

    private String getJasminType(Type type) {
        if (type instanceof IntType)
            return Jasmin.INT_TYPE;
        else if (type instanceof BoolType)
            return Jasmin.BOOL_TYPE;
        else if (type instanceof StringType || type instanceof FptrType)
            return Jasmin.refOf(Jasmin.STRING_TYPE);
        else if (type instanceof ListType)
            return Jasmin.refOf(Jasmin.ARRAY_LIST_TYPE);
        return Jasmin.VOID_TYPE;
    }

    private String getJasminType(ArrayList<Type> types) {
        StringBuilder jasminTypes = new StringBuilder();
        for (Type type : types)
            jasminTypes.append(getJasminType(type));
        return jasminTypes.toString();
    }


    private void prepareOutputFolder() {
        String jasminPath = "utilities/jarFiles/jasmin.jar";
        String listClassPath = "utilities/codeGenerationUtilityClasses/List.j";
        String fptrClassPath = "utilities/codeGenerationUtilityClasses/Fptr.j";
        try {
            File directory = new File(this.outputPath);
            File[] files = directory.listFiles();
            if (files != null)
                for (File file : files)
                    file.delete();
            directory.mkdir();
        } catch (SecurityException ignored) {
        }

        copyFile(jasminPath, this.outputPath + "jasmin.jar");
        copyFile(listClassPath, this.outputPath + "List.j");
        copyFile(fptrClassPath, this.outputPath + "Fptr.j");

        try {
            String path = outputPath + "Main.j";
            File file = new File(path);
            file.createNewFile();
            mainFile = new FileWriter(path);
        } catch (IOException e) {
        }
    }

    private void copyFile(String toBeCopied, String toBePasted) {
        try {
            File readingFile = new File(toBeCopied);
            File writingFile = new File(toBePasted);
            InputStream readingFileStream = new FileInputStream(readingFile);
            OutputStream writingFileStream = new FileOutputStream(writingFile);
            byte[] buffer = new byte[1024];
            int readLength;
            while ((readLength = readingFileStream.read(buffer)) > 0)
                writingFileStream.write(buffer, 0, readLength);
            readingFileStream.close();
            writingFileStream.close();
        } catch (IOException ignored) {
        }
    }

    private String handleMainClass() {
        String commands = """
                .class public Main
                .super java/lang/Object
                .method public static main([Ljava/lang/String;)V
                .limit stack 128
                .limit locals 128
                new Main
                invokespecial Main/<init>()V
                return
                .end method
                """;
        return commands;
    }

    @Override
    public String visit(Program program) {
        List<String> commands = new LinkedList<>();
        commands.add(handleMainClass());

        for (String funcName : this.visited) {
            try {
                this.curFunction = SymbolTable.root.getFunctionItem(funcName);
                commands.add(this.curFunction.getFunctionDeclaration().accept(this));
            } catch (ItemNotFound ignored) {
            }
        }

        commands.add(program.getMain().accept(this));
        Jasmin.write(Jasmin.join(commands), mainFile);
        return null;
    }

    @Override
    public String visit(FunctionDeclaration functionDeclaration) {
        slots.clear();
        typeChecker.functionDeclarationStarted(functionDeclaration);
        List<String> commands = new LinkedList<>();
        try {
            String functionName = functionDeclaration.getFunctionName().getName();
            FunctionItem functionItem = SymbolTable.root.getFunctionItem(functionName);

            String argsType = getJasminType(functionItem.getArgumentTypes());
            String returnType = getJasminType(functionItem.getReturnType());

            for (VarDeclaration var : functionDeclaration.getArgs())
                slotOf(var.getName().getName());

            commands.add(Jasmin.BEGIN_METHOD.formatted(functionName, argsType, returnType));
            commands.add(Jasmin.DEFAULT_LIMIT_STACK);
            commands.add(Jasmin.DEFAULT_LIMIT_LOCALS);

            commands.add(acceptBody(functionDeclaration.getBody()));

            if (functionItem.isReturnTypeVoid())
                commands.add(Jasmin.RETURN);

            commands.add(Jasmin.END_METHOD);
        } catch (ItemNotFound ignored) {
        }
        typeChecker.functionDeclarationEnded();

        return Jasmin.join(commands);
    }

    @Override
    public String visit(MainDeclaration mainDeclaration) {
        slots.clear();
        slotOf("");
        List<String> commands = new LinkedList<>();
        commands.add(".method public <init>()V");
        commands.add(Jasmin.DEFAULT_LIMIT_STACK);
        commands.add(Jasmin.DEFAULT_LIMIT_LOCALS);
        commands.add("aload_0");
        commands.add(Jasmin.INVOKE_OBJECT_INIT);
        commands.add(acceptBody(mainDeclaration.getBody()));
        commands.add(Jasmin.RETURN);
        commands.add(Jasmin.END_METHOD);
        return Jasmin.join(commands);
    }

    public String visit(AccessExpression accessExpression) {
        List<String> commands = new LinkedList<>();
        if (accessExpression.isFunctionCall()) {
            try {
                Identifier accessedIdentifier = (Identifier) accessExpression.getAccessedExpression();
                FunctionItem functionItem = getFunctionItem(accessedIdentifier);
                String functionName = functionItem.getFunctionDeclaration().getFunctionName().getName();

                String argsType = getJasminType(functionItem.getArgumentTypes());
                String returnType = getJasminType(functionItem.getReturnType());
                for (Expression arg : accessExpression.getArguments())
                    commands.add(arg.accept(this));
                ArrayList<VarDeclaration> functionArgs = functionItem.getFunctionDeclaration().getArgs();
                List<VarDeclaration> defaultValues = functionArgs.subList(accessExpression.getArguments().size(), functionArgs.size());
                for (VarDeclaration arg : defaultValues)
                    commands.add(arg.getDefaultVal().accept(this));
                commands.add(Jasmin.INVOKE_MAIN_METHOD.formatted(functionName, argsType, returnType));
            } catch (ItemNotFound ignored) {
            }
        } else {

            commands.addAll(List.of(
                    accessExpression.getAccessedExpression().accept(this),
                    accessExpression.getDimentionalAccess().getFirst().accept(this),
                    Jasmin.INVOKE_ARRAY_LIST_GET
            ));

            Type accessType = getListType(accessExpression.getAccessedExpression());
            if (accessType instanceof StringType || accessType instanceof FptrType)
                commands.add(Jasmin.CHECKCAST + Jasmin.STRING_TYPE);
            else if (accessType instanceof IntType || accessType instanceof BoolType) {
                commands.add(Jasmin.CHECKCAST + Jasmin.INTEGER_TYE);
                commands.add(Jasmin.INTEGER_TO_INT);
            }
        }
        return Jasmin.join(commands);
    }

    private FunctionItem getFunctionItem(Identifier accessedIdentifier) throws ItemNotFound {
        FunctionItem functionItem;
        if (accessedIdentifier.accept(typeChecker) instanceof FptrType fptrType)
            functionItem = SymbolTable.root.getFunctionItem(fptrType.getFunctionName());
        else
            functionItem = SymbolTable.root.getFunctionItem(accessedIdentifier.getName());
        return functionItem;
    }

    private Type getListType(Expression expression) {
        var listType = (ListType) expression.accept(typeChecker);
        return listType.getType();
    }

    @Override
    public String visit(AssignStatement assignStatement) {
        List<String> commands = new LinkedList<>();
        AssignOperator op = assignStatement.getAssignOperator();
        String rightValue = assignStatement.getAssignExpression().accept(this);
        int leftSlot = slotOf(assignStatement.getAssignedId().getName());

        if (assignStatement.isAccessList()) {

            commands.add(Jasmin.ALOAD + leftSlot);
            commands.add(assignStatement.getAccessListExpression().accept(this));
            if (needToLoadAssignedExpression(op)) {
                ArrayList<Expression> indexes = new ArrayList<>();
                indexes.add(assignStatement.getAccessListExpression());
                AccessExpression access = new AccessExpression(assignStatement.getAssignedId(), null);
                access.setDimentionalAccess(indexes);
                commands.add(access.accept(this));
            }
            commands.add(rightValue);
            commands.add(getAssignOperationJasminCode(op));
            commands.add(convertToNonPrimitive(assignStatement.getAssignExpression()));
            commands.add(Jasmin.CHECKCAST + Jasmin.OBJECT_TYPE);
            commands.add(Jasmin.INVOKE_ARRAY_LIST_SET);
            commands.add(Jasmin.POP);

        } else {
            if (needToLoadAssignedExpression(op))
                commands.add(load(assignStatement.getAssignedId()) + leftSlot);
            commands.add(rightValue);
            commands.add(getAssignOperationJasminCode(assignStatement.getAssignOperator()));
            commands.add(store(assignStatement.getAssignExpression()) + leftSlot);
        }

        assignStatement.accept(typeChecker);
        return Jasmin.join(commands);
    }

    private String store(Expression leftExpr) {
        return typePrefix(leftExpr) + Jasmin.STORE;
    }

    private String load(Expression leftExpr) {
        return typePrefix(leftExpr) + Jasmin.LOAD;
    }

    private String typePrefix(Node operand) {
        Type type = operand.accept(typeChecker);
        if (isReference(type))
            return Jasmin.ADDRESS_TYPE_PREFIX;
        else
            return Jasmin.INTEGER_TYPE_PREFIX;
    }

    private boolean isReference(Type type) {
        return type instanceof StringType || type instanceof ListType || type instanceof FptrType;
    }

    @Override
    public String visit(IfStatement ifStatement) {
        typeChecker.ifStatementStarted();
        List<String> commands = new LinkedList<>();
        commands.add(ifStatement.getConditions().getFirst().accept(this));

        String nAfter = getFreshLabel();
        String nElse = null;

        if (ifStatement.getElseBody().isEmpty()) {
            commands.add(Jasmin.IF_EQ + nAfter);
        } else {
            nElse = getFreshLabel();
            commands.add(Jasmin.IF_EQ + nElse);
        }
        commands.add(acceptBody(ifStatement.getThenBody()));

        commands.add(Jasmin.GOTO + nAfter);

        if (nElse != null) {
            commands.add(Jasmin.LABEL.formatted(nElse));
            commands.add(acceptBody(ifStatement.getElseBody()));
        }
        commands.add(Jasmin.LABEL.formatted(nAfter));
        typeChecker.ifStatementEnded();
        return Jasmin.join(commands);
    }

    @Override
    public String visit(PutStatement putStatement) {
        List<String> commands = new LinkedList<>();
        commands.add(Jasmin.GET_PRINT_STREAM);
        commands.add(putStatement.getExpression().accept(this));

        Type type = putStatement.getExpression().accept(typeChecker);
        if (type instanceof IntType || type instanceof BoolType) {
            commands.add(String.format(Jasmin.INVOKE_PRINTLN, Jasmin.INT_TYPE));
        } else if (type instanceof StringType) {
            commands.add(Jasmin.INVOKE_PRINTLN.formatted(Jasmin.refOf(Jasmin.STRING_TYPE)));
        } else if (type instanceof ListType) {
            commands.add(Jasmin.INVOKE_PRINTLN.formatted(Jasmin.refOf(Jasmin.OBJECT_TYPE)));
        }
        return Jasmin.join(commands);
    }

    @Override
    public String visit(ReturnStatement returnStatement) {
        List<String> commands = new LinkedList<>();

        if (returnStatement.hasRetExpression())
            commands.addAll(List.of(
                    returnStatement.getReturnExp().accept(this),
                    typePrefix(returnStatement) + Jasmin.RETURN
            ));
        else
            commands.add(Jasmin.RETURN);

        return Jasmin.join(commands);
    }

    @Override
    public String visit(ExpressionStatement expressionStatement) {
        return expressionStatement.getExpression().accept(this);
    }

    @Override
    public String visit(BinaryExpression binaryExpression) {
        List<String> commands = new LinkedList<>();
        Expression firstOperand = binaryExpression.getFirstOperand();
        Expression secondOperand = binaryExpression.getSecondOperand();
        BinaryOperator op = binaryExpression.getOperator();

        commands.add(firstOperand.accept(this));
        commands.add(secondOperand.accept(this));

        switch (op) {
            case PLUS:
                commands.add(Jasmin.IADD);
                break;
            case MINUS:
                commands.add(Jasmin.ISUB);
                break;
            case MULT:
                commands.add(Jasmin.IMUL);
                break;
            case DIVIDE:
                commands.add(Jasmin.IDIV);
                break;
            case EQUAL:
            case NOT_EQUAL:
            case GREATER_THAN:
            case LESS_THAN:
            case LESS_EQUAL_THAN:
            case GREATER_EQUAL_THAN:
                appendConditionalCommand(commands, op);
                break;
        }

        return Jasmin.join(commands);
    }

    private void appendConditionalCommand(List<String> commands, BinaryOperator op) {
        String L1 = getFreshLabel();
        String L2 = getFreshLabel();

        switch (op) {
            case EQUAL:
                commands.add(Jasmin.IF_ICMPEQ + L1);
                break;
            case NOT_EQUAL:
                commands.add(Jasmin.IF_ICMPNE + L1);
                break;
            case GREATER_THAN:
                commands.add(Jasmin.IF_ICMPGT + L1);
                break;
            case LESS_THAN:
                commands.add(Jasmin.IF_ICMPLT + L1);
                break;
            case LESS_EQUAL_THAN:
                commands.add(Jasmin.IF_ICMPLE + L1);
                break;
            case GREATER_EQUAL_THAN:
                commands.add(Jasmin.IF_ICMPGE + L1);
                break;
        }

        commands.add(Jasmin.LOAD_CONSTANT + 0);
        commands.add(Jasmin.GOTO + L2);
        commands.add(Jasmin.LABEL.formatted(L1));
        commands.add(Jasmin.LOAD_CONSTANT + 1);
        commands.add(Jasmin.LABEL.formatted(L2));
    }

    @Override
    public String visit(UnaryExpression unaryExpression) {
        String exprCommand = unaryExpression.getExpression().accept(this);
        List<String> commands = new LinkedList<>();
        Identifier identifier;

        switch (unaryExpression.getOperator()) {
            case NOT:
                commands.addAll(List.of(
                        Jasmin.ICONST_1,
                        exprCommand,
                        Jasmin.ISUB
                ));
                break;
            case MINUS:
                commands.addAll(List.of(
                        Jasmin.ICONST_0,
                        exprCommand,
                        Jasmin.ISUB
                ));
                break;
            case DEC:
                identifier = (Identifier) unaryExpression.getExpression();
                commands.addAll(List.of(
                        exprCommand,
                        Jasmin.DUP,
                        Jasmin.ICONST_1,
                        Jasmin.ISUB,
                        Jasmin.ISTORE + slotOf(identifier.getName())
                ));
                break;
            case INC:
                identifier = (Identifier) unaryExpression.getExpression();
                commands.addAll(List.of(
                        exprCommand,
                        Jasmin.DUP,
                        Jasmin.ICONST_1,
                        Jasmin.IADD,
                        Jasmin.ISTORE + slotOf(identifier.getName())
                ));
                break;
        }
        return Jasmin.join(commands);
    }

    @Override
    public String visit(Identifier identifier) {
        return load(identifier) + slotOf(identifier.getName());
    }

    @Override
    public String visit(LoopDoStatement loopDoStatement) {
        typeChecker.loopDoStatementStarted();
        List<String> commands = new LinkedList<>();
        String nStart = getFreshLabel();
        String nAfter = getFreshLabel();
        breakLabels.push(nAfter);
        afterLabels.push(nStart);

        commands.add(Jasmin.LABEL.formatted(nStart));
        commands.add(acceptBody(loopDoStatement.getLoopBodyStmts()));
        commands.add(Jasmin.GOTO + nStart);
        commands.add(Jasmin.LABEL.formatted(nAfter));

        breakLabels.pop();
        afterLabels.pop();
        typeChecker.loopDoStatementEnded();
        return Jasmin.join(commands);
    }

    @Override
    public String visit(BreakStatement breakStatement) {
        return Jasmin.GOTO + breakLabels.getFirst();
    }

    @Override
    public String visit(NextStatement nextStatement) {
        return Jasmin.GOTO + afterLabels.getFirst();
    }

    @Override
    public String visit(LenStatement lenStatement) {
        List<String> commands = new LinkedList<>();
        Expression expr = lenStatement.getExpression();
        Type type = expr.accept(typeChecker);
        commands.add(expr.accept(this));
        if (type instanceof StringType)
            commands.add(Jasmin.INVOKE_STRING_LENGTH);
        if (type instanceof ListType)
            commands.add(Jasmin.INVOKE_ARRAY_LIST_SIZE);
        return Jasmin.join(commands);
    }

    @Override
    public String visit(ChopStatement chopStatement) {
        List<String> commands = new LinkedList<>(List.of(
                chopStatement.getChopExpression().accept(this),
                Jasmin.DUP,
                Jasmin.INVOKE_STRING_LENGTH,
                Jasmin.ICONST_1,
                Jasmin.ISUB,
                Jasmin.ICONST_0,
                Jasmin.SWAP,
                Jasmin.INVOKE_STRING_SUBSTRING
        ));
        return Jasmin.join(commands);
    }

    @Override
    public String visit(FunctionPointer functionPointer) {
        return Jasmin.LOAD_STRING.formatted("method:" + functionPointer.getId().getName());
    }

    private String convertToNonPrimitive(Expression expression) {
        Type type = expression.accept(typeChecker);
        if (type instanceof IntType || type instanceof BoolType)
            return Jasmin.INT_TO_INTEGER;

        return Jasmin.EMPTY;
    }

    @Override
    public String visit(ListValue listValue) {
        List<String> commands = new LinkedList<>(List.of(
                Jasmin.NEW_ARRAY_LIST,
                Jasmin.DUP,
                Jasmin.INVOKE_ARRAY_LIST_ININT
        ));
        for (Expression element : listValue.getElements()) {
            commands.addAll(List.of(
                    Jasmin.DUP,
                    element.accept(this),
                    convertToNonPrimitive(element),
                    Jasmin.INVOKE_ARRAY_LIST_ADD,
                    Jasmin.POP
            ));
        }
        return Jasmin.join(commands);
    }

    @Override
    public String visit(IntValue intValue) {
        return Jasmin.LOAD_CONSTANT + intValue.getIntVal();
    }

    @Override
    public String visit(BoolValue boolValue) {
        return boolValue.getBool() ? Jasmin.LOAD_CONSTANT + 1 : Jasmin.LOAD_CONSTANT + 0;
    }

    @Override
    public String visit(StringValue stringValue) {
        return Jasmin.LOAD_CONSTANT + "\"" + stringValue + "\"";
    }

    private String acceptBody(List<Statement> statements) {
        List<String> commands = new LinkedList<>();
        for (Statement stmt : statements) {
            commands.addAll(List.of(
                    stmt.accept(this),
                    popNonVoidStatement(stmt)
            ));
        }
        return Jasmin.join(commands);
    }

    private String popNonVoidStatement(Statement statement) {
        if (statement instanceof ExpressionStatement expressionStatement) {
            if (expressionStatement.getExpression() instanceof AccessExpression accessExpression
                    && accessExpression.isFunctionCall()) {
                Identifier accessedIdentifier = (Identifier) accessExpression.getAccessedExpression();
                try {
                    FunctionItem functionItem = getFunctionItem(accessedIdentifier);
                    if (functionItem.isReturnTypeVoid())
                        return Jasmin.EMPTY;
                } catch (ItemNotFound ignored) {
                }
            }
            return Jasmin.POP;
        }
        return Jasmin.EMPTY;
    }

    public boolean needToLoadAssignedExpression(AssignOperator op) {
        if (op != AssignOperator.ASSIGN)
            return true;
        return false;
    }

    public String getAssignOperationJasminCode(AssignOperator op) {
        String command = Jasmin.EMPTY;

        switch (op) {
            case PLUS_ASSIGN:
                command = Jasmin.IADD;
                break;
            case MINUS_ASSIGN:
                command = Jasmin.ISUB;
                break;
            case DIVIDE_ASSIGN:
                command = Jasmin.IDIV;
                break;
            case MULT_ASSIGN:
                command = Jasmin.IMUL;
                break;
            case MOD_ASSIGN:
                command = Jasmin.IREM;
                break;
        }
        return command;
    }
}