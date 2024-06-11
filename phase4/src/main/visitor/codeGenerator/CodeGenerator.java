package main.visitor.codeGenerator;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.*;
import java.util.stream.Collectors;

public class CodeGenerator extends Visitor<String> {
    private final String outputPath;
    private FileWriter mainFile;
    private final TypeChecker typeChecker;
    private final Set<String> visited;
    private FunctionItem curFunction;
    private final HashMap<String, Integer> slots = new HashMap<>();
    private int curLabel = 0;

    private static LinkedList<String> breakLabels = new LinkedList<>();

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

//    public void convertToPrimitive(Type type) {
//        String command = switch (type) {
//            case IntType intType ->  "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;";
//            case BoolType boolType -> "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;";
//            default -> "";
//        };
//        addCommand(command);
//    }
//
//    public void convertToNonPrimitive(Type type) {
//        String command = switch (type) {
//            case IntType intType ->  "invokevirtual java/lang/Integer/intValue()I";
//            case BoolType boolType -> "invokevirtual java/lang/Boolean/booleanValue()Z";
//            default -> "";
//        };
//        addCommand(command);
//    }

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

    public String getTypeSign(Type type) {
        if (type instanceof IntType)
            return "i";
        else
            return "a";
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
        } catch (SecurityException e) {
            // ignore
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
        } catch (IOException e) {
            // ignore
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
        } catch (IOException e) {
            // ignore
        }
    }

    private void handleMainClass() {
        String commands = """
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
        String commands = """
                .class public Main
                .super java/lang/Object
                """;
        addCommand(commands);
        handleMainClass();

        for (String funcName : this.visited) {
            try {
                this.curFunction = (FunctionItem) SymbolTable.root.getItem(FunctionItem.START_KEY +
                        funcName);
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

        String commands = "";
        String args = ""; // TODO and add to the slots
        String returnType = ""; // TODO
        commands += ".method public " + functionDeclaration.getFunctionName().getName();
        commands += args + returnType + "\n";
        // TODO headers, body and return with corresponding type

        addCommand(commands);
        return null;
    }

    @Override
    public String visit(MainDeclaration mainDeclaration) {
        slots.clear();

        String commands = "";
        commands += ".method public <init>()V\n";
        commands += ".limit stack 128\n";
        commands += ".limit locals 128\n";
        commands += "aload_0\n";
        commands += "invokespecial java/lang/Object/<init>()V\n";
        for (var statement : mainDeclaration.getBody())
            commands += statement.accept(this);
        commands += "return\n";
        commands += ".end method\n";

        addCommand(commands);
        return null;
    }

    public String visit(AccessExpression accessExpression) {
        if (accessExpression.isFunctionCall()) {
            Identifier functionName = (Identifier) accessExpression.getAccessedExpression();
            String args = ""; // TODO
            String returnType = ""; // TODO
            return "invokestatic Main/" + functionName.getName() + args + returnType + "\n";
        } else {
            // TODO
        }
        //TODO
        return null;
    }

    @Override
    public String visit(AssignStatement assignStatement) {
        return null;
    }

    @Override
    public String visit(IfStatement ifStatement) {
        //TODO
        return null;
    }

    @Override
    public String visit(PutStatement putStatement) {
        //TODO
        return null;
    }

    @Override
    public String visit(ReturnStatement returnStatement) {
        //TODO
        return null;
    }

    @Override
    public String visit(ExpressionStatement expressionStatement) {
        return expressionStatement.getExpression().accept(this);
    }

    @Override
    public String visit(BinaryExpression binaryExpression) {
        StringBuilder command = new StringBuilder();
        Expression firstOperand = binaryExpression.getFirstOperand();
        Expression secondOperand = binaryExpression.getSecondOperand();
        BinaryOperator op = binaryExpression.getOperator();

        command.append(firstOperand.accept(this));
        command.append(secondOperand.accept(this));

        switch (op) {
            case PLUS:
                command.append("iadd\n");
                break;
            case MINUS:
                command.append("isub\n");
                break;
            case MULT:
                command.append("imul\n");
                break;
            case DIVIDE:
                command.append("idiv\n");
                break;
            case EQUAL:
            case NOT_EQUAL:
            case GREATER_THAN:
            case LESS_THAN:
            case LESS_EQUAL_THAN:
            case GREATER_EQUAL_THAN:
                appendConditionalCommand(command, op);
                break;
        }

        return command.toString();
    }

    private void appendConditionalCommand(StringBuilder command, BinaryOperator op) {
        String L1 = getFreshLabel();
        String L2 = getFreshLabel();

        switch (op) {
            case EQUAL:
                command.append("if_icmpeq ").append(L1).append("\n");
                break;
            case NOT_EQUAL:
                command.append("if_icmpne ").append(L1).append("\n");
                break;
            case GREATER_THAN:
                command.append("if_icmpgt ").append(L1).append("\n");
                break;
            case LESS_THAN:
                command.append("if_icmplt ").append(L1).append("\n");
                break;
            case LESS_EQUAL_THAN:
                command.append("if_icmple ").append(L1).append("\n");
                break;
            case GREATER_EQUAL_THAN:
                command.append("if_icmpge ").append(L1).append("\n");
                break;
        }

        command.append("ldc 0\n");
        command.append("goto ").append(L2).append("\n");
        command.append(L1).append(":\n");
        command.append("ldc 1\n");
        command.append(L2).append(":\n");
    }

    @Override
    public String visit(UnaryExpression unaryExpression) {
        String exprCommand = unaryExpression.getExpression().accept(this);
        List<String> command  = new LinkedList<>();
        switch (unaryExpression.getOperator()){
            case NOT:
                command.add("iconst_1");
                command.add(exprCommand);
                command.add("isub");
                break;
            case DEC:
                command.add(exprCommand);
                command.add("iconst_0");
                command.add("isub");
                break;
            case INC:
                command.add(exprCommand);
                command.add("iconst_0");
                command.add("iadd");
                break;
            case MINUS:
                command.add("iconst_0");
                command.add(exprCommand);
                command.add("isub");
                break;
        }
        return String.join("\n", command);
    }

    @Override
    public String visit(Identifier identifier) {
        Type type = identifier.accept(typeChecker);
        String typeSign = getTypeSign(type);
        return typeSign + "load " + slotOf(identifier.getName());
    }

    @Override
    public String visit(LoopDoStatement loopDoStatement) {
        List<String> commands = new LinkedList<>();
        String nStart = getFreshLabel();
        String nAfter = getFreshLabel();
        breakLabels.push(nAfter);
        commands.add(nStart + ":");
        for (Statement stmt : loopDoStatement.getLoopBodyStmts())
            commands.add(stmt.accept(this));
        commands.add("goto " + nStart);
        commands.add(nAfter + ":");
        breakLabels.pop();
        return null;
    }

    @Override
    public String visit(BreakStatement breakStatement) {
        
        return null;
    }

    @Override
    public String visit(NextStatement nextStatement) {
        //TODO
        return null;
    }

    @Override
    public String visit(LenStatement lenStatement) {
        //TODO
        return null;
    }

    @Override
    public String visit(ChopStatement chopStatement) {
        //TODO
        return null;
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

    @Override
    public String visit(ListValue listValue) {
        //TODO
        return null;
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