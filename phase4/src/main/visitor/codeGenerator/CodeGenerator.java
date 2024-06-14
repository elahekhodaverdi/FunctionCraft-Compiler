package main.visitor.codeGenerator;

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
        if (!slots.containsKey(var)) {
            slots.put(var, slots.size());
            return slots.size() - 1;
        }
        return slots.get(var);
    }

    public String getFreshLabel() {
        String fresh = "Label_" + curLabel;
        curLabel++;
        return fresh;
    }

    public String getType(Type element) {
        String type = "";
        switch (element) {
            case StringType stringType -> type += "Ljava/lang/String;";
            case IntType intType -> type += "Ljava/lang/Integer;";
            case FptrType fptrType -> type += "LFptr;";
            case ListType listType -> type += "LList;";
            case BoolType boolType -> type += "Ljava/lang/Boolean;";
            case null, default -> {
            }
        }
        return type;
    }

    public String getSimpleTypeSign(Type type) {
        if (type instanceof StringType || type instanceof ListType)
            return "a";
        else
            return "i";
    }

    private String getJasminType(Type type) {
        if (type instanceof IntType)
            return Jasmin.INT_TYPE;
        else if (type instanceof BoolType)
            return Jasmin.BOOLEAN_TYPE;
        else if (type instanceof StringType)
            return Jasmin.refOf(Jasmin.STRING_TYPE);
        return Jasmin.VOID_TYPE;
    }

    private String getJasminType(ArrayList<Type> types) {
        String jasminTypes = "";
        for(Type type : types)
            jasminTypes += getJasminType(type);
        return jasminTypes;
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
            // ignore
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

    private void addCommand(String command) {
        try {
            command = String.join("\n\t\t", command.split("\n"));
            if (command.startsWith("Label_"))
                mainFile.write("\t" + command + "\n");
            else if (command.startsWith("."))
                mainFile.write(command + "\n");
            else
                mainFile.write("\t\t" + command + "\n");
            mainFile.flush();
        } catch (IOException ignored) {
        }
    }

    private void handleMainClass() {
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
        addCommand(commands);
    }

    @Override
    public String visit(Program program) {
        handleMainClass();

        for (String funcName : this.visited) {
            try {
                this.curFunction = SymbolTable.root.getFunctionItem(funcName);
                this.curFunction.getFunctionDeclaration().accept(this);
            } catch (ItemNotFound ignored) {
            }
        }

        program.getMain().accept(this);
        return null;
    }

    @Override
    public String visit(FunctionDeclaration functionDeclaration) {
        slots.clear();
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

            for (Statement stmt : functionDeclaration.getBody())
                commands.add(stmt.accept(this));

            if (functionItem.getReturnType() == null)
                commands.add(Jasmin.RETURN);

            commands.add(Jasmin.END_METHOD);

            addCommand(Jasmin.join(commands));
        }catch (ItemNotFound ignored) {}
        return null;
    }

    @Override
    public String visit(MainDeclaration mainDeclaration) {
        slots.clear();
        List<String> commands = new LinkedList<>();
        commands.add(".method public <init>()V");
        commands.add(Jasmin.DEFAULT_LIMIT_STACK);
        commands.add(Jasmin.DEFAULT_LIMIT_LOCALS);
        commands.add("aload_0");
        commands.add(Jasmin.INVOKE_OBJECT_INIT);
        for (var statement : mainDeclaration.getBody())
            commands.add(statement.accept(this));
        commands.add(Jasmin.RETURN);
        commands.add(Jasmin.END_METHOD);
        addCommand(Jasmin.join(commands));
        return null;
    }

    public String visit(AccessExpression accessExpression) {
        List<String> commands = new LinkedList<>();

        if (accessExpression.isFunctionCall()) {
            Identifier functionName = (Identifier) accessExpression.getAccessedExpression();
            try {
                FunctionItem functionItem = SymbolTable.root.getFunctionItem(functionName.getName());


            for(Expression arg : accessExpression.getArguments())
                commands.add(arg.accept(this));

            String args = getType2(functionItem.getArgumentTypes());
            String returnType = getJasminType(functionItem.getReturnType());

            commands.add("invokestatic Main/" + functionName.getName() + "(" + args + ")" + returnType);
            }catch (ItemNotFound ignored) {}
        } else {
            commands.add(accessExpression.getAccessedExpression().accept(this));
            commands.add(accessExpression.getDimentionalAccess().getFirst().accept(this));
            commands.add(Jasmin.INVOKE_ARRAY_LIST_GET);
            if(getListType(accessExpression.getAccessedExpression()) instanceof StringType)
                commands.add(Jasmin.CHECKCAST + Jasmin.STRING_TYPE);
            else {
                commands.add(Jasmin.CHECKCAST + Jasmin.INTEGER_TYE);
                commands.add(Jasmin.INTEGER_TO_INT);
            }
        }
        return Jasmin.join(commands);
    }

    private String getType2(ArrayList<Type> types) {
        String commands = "";
        for (Type type : types)
            commands += getType2(type);
        return commands;
    }

    private String getType2(Type type) {
        if(type instanceof IntType)
            return Jasmin.INT_TYPE;
        if (type instanceof BoolType)
            return Jasmin.BOOLEAN_TYPE;
        if(type instanceof StringType)
            return Jasmin.STRING_TYPE;
        return Jasmin.EMPTY;
    }
    private Type getListType(Expression expression) {
        var listType = (ListType) expression.accept(typeChecker);
        return listType.getType();
    }

    @Override
    public String visit(AssignStatement assignStatement) {
        List<String> commands = new LinkedList<>();

        String rightValue = assignStatement.getAssignExpression().accept(this);
        int leftSlot = slotOf(assignStatement.getAssignedId().getName());

        if (assignStatement.isAccessList())
            commands.addAll(List.of(
                    Jasmin.ALOAD + leftSlot,
                    assignStatement.getAccessListExpression().accept(this),
                    rightValue,
                    convertToNonPrimitive(assignStatement.getAssignExpression()),
                    Jasmin.CHECKCAST + Jasmin.OBJECT_TYPE,
                    Jasmin.INVOKE_ARRAY_LIST_SET,
                    Jasmin.POP
            ));
        else
            commands.addAll(List.of(
                    rightValue,
                    store(assignStatement.getAssignExpression()) + leftSlot
            ));

        return Jasmin.join(commands);
    }

    private String store(Expression leftExpr) {
        Type type = leftExpr.accept(typeChecker);
        if (type instanceof StringType || type instanceof ListType)
            return Jasmin.ASTORE;
        else
            return Jasmin.ISTORE;
    }

    private String load(Expression leftExpr) {
        Type type = leftExpr.accept(typeChecker);
        if (type instanceof StringType || type instanceof ListType)
            return Jasmin.ALOAD;
        else
            return Jasmin.ILOAD;
    }

    @Override
    public String visit(IfStatement ifStatement) {
        List<String> commands = new LinkedList<>();
        commands.add(ifStatement.getConditions().getFirst().accept(this));

        String nAfter = getFreshLabel();
        String nElse = null;

        if (ifStatement.getElseBody().isEmpty()) {
            commands.add("ifeq " + nAfter);
        } else {
            nElse = getFreshLabel();
            commands.add("ifeq " + nElse);
        }

        ifStatement.getThenBody().forEach(statement -> commands.add(statement.accept(this)));
        commands.add("goto " + nAfter);

        if (nElse != null) {
            commands.add(nElse + ":");
            ifStatement.getElseBody().forEach(statement -> commands.add(statement.accept(this)));
        }
        commands.add(nAfter + ":");
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
        String commands = "";
        String typeSign = "";
        Type retType = null;
        if (returnStatement.hasRetExpression()) {
            retType = returnStatement.getReturnExp().accept(typeChecker);
            typeSign = getSimpleTypeSign(retType);
            commands += returnStatement.getReturnExp().accept(this);
            commands += "\n";
        }

        return commands + typeSign + "return";
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
                commands.add("iadd");
                break;
            case MINUS:
                commands.add("isub");
                break;
            case MULT:
                commands.add("imul");
                break;
            case DIVIDE:
                commands.add("idiv");
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
                commands.add("if_icmpeq " + L1);
                break;
            case NOT_EQUAL:
                commands.add("if_icmpne " + L1);
                break;
            case GREATER_THAN:
                commands.add("if_icmpgt " + L1);
                break;
            case LESS_THAN:
                commands.add("if_icmplt " + L1);
                break;
            case LESS_EQUAL_THAN:
                commands.add("if_icmple " + L1);
                break;
            case GREATER_EQUAL_THAN:
                commands.add("if_icmpge " + L1);
                break;
        }

        commands.add("ldc 0");
        commands.add("goto " + L2);
        commands.add(L1 + ":");
        commands.add("ldc 1");
        commands.add(L2 + ":");
    }

    @Override
    public String visit(UnaryExpression unaryExpression) {
        String exprCommand = unaryExpression.getExpression().accept(this);
        List<String> commands = new LinkedList<>();
        switch (unaryExpression.getOperator()) {
            case NOT:
                commands.add(Jasmin.ICONST_1);
                commands.add(exprCommand);
                commands.add(Jasmin.ISUB);
                break;
            case MINUS:
                commands.add(Jasmin.ICONST_0);
                commands.add(exprCommand);
                commands.add(Jasmin.ISUB);
                break;
            case DEC:
                commands.add(exprCommand);
                commands.add(Jasmin.DUP);
                commands.add(Jasmin.ICONST_1);
                commands.add(Jasmin.ISUB);
                Identifier identifier = (Identifier) unaryExpression.getExpression();
                commands.add("istore " + slotOf(identifier.getName()));
                break;
            case INC:
                commands.add(exprCommand);
                commands.add(Jasmin.DUP);
                commands.add(Jasmin.ICONST_1);
                commands.add(Jasmin.IADD);
                identifier = (Identifier) unaryExpression.getExpression();
                commands.add("istore " + slotOf(identifier.getName()));
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
        List<String> commands = new LinkedList<>();
        String nStart = getFreshLabel();
        String nAfter = getFreshLabel();
        breakLabels.push(nAfter);
        afterLabels.push(nStart);
        commands.add(nStart + ":");
        for (Statement stmt : loopDoStatement.getLoopBodyStmts())
            commands.add(stmt.accept(this));
        commands.add("goto " + nStart);
        commands.add(nAfter + ":");
        breakLabels.pop();
        afterLabels.pop();
        return Jasmin.join(commands);
    }

    @Override
    public String visit(BreakStatement breakStatement) {
        return "goto " + breakLabels.getLast();
    }

    @Override
    public String visit(NextStatement nextStatement) {
        return "goto " + afterLabels.getLast();
    }

    @Override
    public String visit(LenStatement lenStatement) {
        List<String> commands = new LinkedList<>();
        Expression expr = lenStatement.getExpression();
        Type type = expr.accept(typeChecker);
        commands.add(expr.accept(this));
        if (type instanceof StringType)
            commands.add("invokevirtual java/lang/String/length()I");
        if (type instanceof ListType)
            commands.add("invokeinterface java/util/List/size()I 1");
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
        FptrType fptr = (FptrType) functionPointer.accept(typeChecker);
        String commands = "";
        commands += "new Fptr\n";
        commands += "dup\n";
        commands += "aload_0\n";
        commands += "ldc " + "\"" + fptr.getFunctionName() + "\"\n";
        commands += "invokespecial Fptr/<init>(Ljava/lang/Object;Ljava/lang/String;)V\n";
        return commands;
    }

    private String convertToNonPrimitive(Expression expression) {
        Type type = expression.accept(typeChecker);
        if (type instanceof IntType)
            return Jasmin.INT_TO_INTEGER;
        if (type instanceof BoolType)
            return Jasmin.BOOL_TO_BOOLEAN;

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
        return "ldc " + intValue.getIntVal();
    }

    @Override
    public String visit(BoolValue boolValue) {
        return boolValue.getBool() ? "ldc " + 1 : "ldc " + 0;
    }

    @Override
    public String visit(StringValue stringValue) {
        return "ldc \"" + stringValue + "\"";
    }
}