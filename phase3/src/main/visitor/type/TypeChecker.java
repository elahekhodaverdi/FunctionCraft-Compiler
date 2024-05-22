package main.visitor.type;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.*;
import main.ast.nodes.expression.value.*;
import main.ast.nodes.expression.value.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.type.*;
import main.ast.type.primitiveType.*;
import main.compileError.CompileError;
import main.compileError.typeErrors.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.*;
import main.symbolTable.item.*;
import main.visitor.Visitor;

import java.util.*;
import java.util.stream.Collectors;

public class TypeChecker extends Visitor<Type> {
    public ArrayList<CompileError> typeErrors = new ArrayList<>();
    private static LinkedList<ArrayList<Type>> returnStack = new LinkedList<>();
    @Override
    public Type visit(Program program){
        SymbolTable.root = new SymbolTable();
        SymbolTable.top = new SymbolTable();
        for(FunctionDeclaration functionDeclaration : program.getFunctionDeclarations()){
            FunctionItem functionItem = new FunctionItem(functionDeclaration);
            try {
                SymbolTable.root.put(functionItem);
            }catch (ItemAlreadyExists ignored){}
        }
        for(PatternDeclaration patternDeclaration : program.getPatternDeclarations()){
            PatternItem patternItem = new PatternItem(patternDeclaration);
            try{
                SymbolTable.root.put(patternItem);
            }catch (ItemAlreadyExists ignored){}
        }
        program.getMain().accept(this);
        return null;
    }
    @Override
    public Type visit(FunctionDeclaration functionDeclaration){
        SymbolTable.push(new SymbolTable());
        returnStack.push(new ArrayList<>());
        try {
            FunctionItem functionItem = (FunctionItem) SymbolTable.root.getItem(FunctionItem.START_KEY +
                    functionDeclaration.getFunctionName().getName());
            ArrayList<Type> currentArgTypes = functionItem.getArgumentTypes();
            for (int i = 0; i < functionDeclaration.getArgs().size(); i++) {
                VarItem argItem = new VarItem(functionDeclaration.getArgs().get(i).getName());
                argItem.setType(currentArgTypes.get(i));
                try {
                    SymbolTable.top.put(argItem);
                }catch (ItemAlreadyExists ignored){}
            }
        }catch (ItemNotFound ignored){}
        for(Statement statement : functionDeclaration.getBody())
            statement.accept(this);

        HashSet<Type> uniqueReturnTypes = new HashSet<>(returnStack.getLast());
        if (uniqueReturnTypes.size() > 1) {
            typeErrors.add(new FunctionIncompatibleReturnTypes(functionDeclaration.getLine(), functionDeclaration.getFunctionName().getName()));
            returnStack.pop();
            return new NoType();
        }
        Type returnType = returnStack.getLast().isEmpty() ? null : returnStack.getLast().get(0);

        returnStack.pop();
        SymbolTable.pop();
        return returnType;
    }
    @Override
    public Type visit(PatternDeclaration patternDeclaration){
        SymbolTable.push(new SymbolTable());
        Type returnType = null;
        try {
            returnStack.push(new ArrayList<>());
            PatternItem patternItem = (PatternItem) SymbolTable.root.getItem(PatternItem.START_KEY +
                    patternDeclaration.getPatternName().getName());
            VarItem varItem = new VarItem(patternDeclaration.getTargetVariable());
            varItem.setType(patternItem.getTargetVarType());
            try {
                SymbolTable.top.put(varItem);
            }catch (ItemAlreadyExists ignored){}
            for(Expression expression : patternDeclaration.getConditions()){
                if(!(expression.accept(this) instanceof BoolType)){
                    typeErrors.add(new ConditionIsNotBool(expression.getLine()));
                    SymbolTable.pop();
                    return new NoType();
                }
            }
            for (Expression expression: patternDeclaration.getReturnExp())
                returnStack.getLast().add(expression.accept(this));

            HashSet<Type> uniqueReturnTypes = new HashSet<>(returnStack.getLast());
            if (uniqueReturnTypes.size() > 1) {
                typeErrors.add(new FunctionIncompatibleReturnTypes(patternDeclaration.getLine(), patternDeclaration.getPatternName().getName()));
                returnStack.pop();
                return new NoType();
            }
            returnType = returnStack.getLast().isEmpty() ? null : returnStack.getLast().get(0);
            returnStack.pop();
        }catch (ItemNotFound ignored){}

        SymbolTable.pop();
        return returnType;
    }
    @Override
    public Type visit(MainDeclaration mainDeclaration){
        //TODO:visit main
        mainDeclaration.getBody().forEach(statement -> statement.accept(this));
        return null;
    }
    @Override
    public Type visit(AccessExpression accessExpression){
        if(accessExpression.isFunctionCall()){
            List<Type> argTypes = new ArrayList<>();
            for (Expression arg : accessExpression.getArguments()) {
                Type result = arg.accept(this);
                argTypes.add(result);
            }
            if (accessExpression.getAccessedExpression() instanceof Identifier identifier) {
                FunctionItem functionItem = (FunctionItem) SymbolTable.root.getItem(FunctionItem.START_KEY + identifier);
                functionItem.setArgumentTypes(argTypes);
                functionItem.getFunctionDeclaration().accept(this)
            }
            //TODO:function is called here.set the arguments type and visit its declaration
        }
        else{
            Type accessedType = accessExpression.getAccessedExpression().accept(this);
            if(!(accessedType instanceof StringType) && !(accessedType instanceof ListType)){
                typeErrors.add(new IsNotIndexable(accessExpression.getLine()));
                return new NoType();
            }
            for (Expression expr: accessExpression.getDimentionalAccess()){
                if (!(expr.accept(this) instanceof IntType)){
                    typeErrors.add(new AccessIndexIsNotInt(accessExpression.getLine()));
                    return new NoType();
                }
            }
            //TODO:index of access list must be int
        }
        return null;
    }

    @Override
    public Type visit(ReturnStatement returnStatement){
        // TODO:Visit return statement.Note that return type of functions are specified here
        Type returnType = new NoType();
        if (returnStatement.hasRetExpression())
            returnType = returnStatement.getReturnExp().accept(this);

        returnStack.getLast().add(returnType);
        return returnType;
    }
    @Override
    public Type visit(ExpressionStatement expressionStatement){
        return expressionStatement.getExpression().accept(this);

    }
    @Override
    public Type visit(ForStatement forStatement){
        SymbolTable.push(SymbolTable.top.copy());
        forStatement.getRangeExpression().accept(this);
        VarItem varItem = new VarItem(forStatement.getIteratorId());
        try{
            SymbolTable.top.put(varItem);
        }catch (ItemAlreadyExists ignored){}

        for(Statement statement : forStatement.getLoopBodyStmts())
            statement.accept(this);
        SymbolTable.pop();
        return null;
    }
    @Override
    public Type visit(IfStatement ifStatement){
        SymbolTable.push(SymbolTable.top.copy());
        for(Expression expression : ifStatement.getConditions())
            if(!(expression.accept(this) instanceof BoolType))
                typeErrors.add(new ConditionIsNotBool(expression.getLine()));
        for(Statement statement : ifStatement.getThenBody())
            statement.accept(this);
        for(Statement statement : ifStatement.getElseBody())
            statement.accept(this);
        SymbolTable.pop();
        return new NoType();
    }
    @Override
    public Type visit(LoopDoStatement loopDoStatement){
        SymbolTable.push(SymbolTable.top.copy());
        for(Statement statement : loopDoStatement.getLoopBodyStmts())
            statement.accept(this);
        SymbolTable.pop();
        return new NoType();
    }
    @Override
    public Type visit(AssignStatement assignStatement){
        Type assignType = assignStatement.getAssignExpression().accept(this);

        if(assignStatement.isAccessList()){
            // TODO:assignment to list
            Type indexType = assignStatement.getAccessListExpression().accept(this);

            if (!(indexType instanceof IntType))
                typeErrors.add(new AccessIndexIsNotInt(assignStatement.getLine()));
        }
        else{
            // TODO:maybe new type for a variable
            VarItem varItem = new VarItem(assignStatement.getAssignedId());
            try {
                varItem = SymbolTable.top.getVarItem(assignStatement.getAssignedId().getName());
            }catch (ItemNotFound ex) {
                try {
                    SymbolTable.top.put(varItem);
                }catch (ItemAlreadyExists ignored) {}
            }
            varItem.setType(assignType);
        }
        return new NoType();
    }
    @Override
    public Type visit(BreakStatement breakStatement){
        for(Expression expression : breakStatement.getConditions())
            if(!((expression.accept(this)) instanceof BoolType))
                typeErrors.add(new ConditionIsNotBool(expression.getLine()));

        return null;
    }
    @Override
    public Type visit(NextStatement nextStatement){
        for(Expression expression : nextStatement.getConditions())
            if(!((expression.accept(this)) instanceof BoolType))
                typeErrors.add(new ConditionIsNotBool(expression.getLine()));

        return null;
    }
    @Override
    public Type visit(PushStatement pushStatement){
        //TODO:visit push statement
        Type initialType = pushStatement.getInitial().accept(this);
        Type toBeAddedType = pushStatement.getToBeAdded().accept(this);
        if (!(initialType instanceof StringType) && !(initialType instanceof ListType)){
            typeErrors.add(new PushArgumentsTypesMisMatch(pushStatement.getLine()));
            return new NoType();
        }
        if ((initialType instanceof StringType) && !toBeAddedType.sameType(initialType)){
            typeErrors.add(new PushArgumentsTypesMisMatch(pushStatement.getLine()));
            return new NoType();
        }

        if (initialType instanceof ListType listType){
            if (!listType.getType().sameType(new NoType())) {
                if (!listType.getType().sameType(toBeAddedType)) {
                    typeErrors.add(new PushArgumentsTypesMisMatch(pushStatement.getLine()));
                    return new NoType();
                }
            }
            if (listType.getType().sameType(new NoType()))
                listType.setType(toBeAddedType);
        }
        return new NoType();
    }
    @Override
    public Type visit(PutStatement putStatement){
        //TODO:visit putStatement

        return new NoType();

    }
    @Override
    public Type visit(BoolValue boolValue){
        return new BoolType();
    }
    @Override
    public Type visit(IntValue intValue){
        return new IntType();
    }
    @Override
    public Type visit(FloatValue floatValue){return new FloatType();}
    @Override
    public Type visit(StringValue stringValue){
        return new StringType();
    }
    @Override
    public Type visit(ListValue listValue){
        // TODO:visit listValue
        var types = new ArrayList<>(listValue.getElements().stream()
                .map(e -> e.accept(this))
                .collect(Collectors.toSet()));

        if (types.size() > 1) {
            typeErrors.add(new ListElementsTypesMisMatch(listValue.getLine()));
            return new NoType();
        }

        types.add(new NoType());
        return new ListType(types.getFirst());
    }
    @Override
    public Type visit(FunctionPointer functionPointer){
        return new FptrType(functionPointer.getId().getName());
    }
    @Override
    public Type visit(AppendExpression appendExpression){
        Type appendeeType = appendExpression.getAppendee().accept(this);
        if(!(appendeeType instanceof ListType) && !(appendeeType instanceof StringType)){
            typeErrors.add(new IsNotAppendable(appendExpression.getLine()));
            return new NoType();
        }
        return appendeeType;
    }
    @Override
    public Type visit(BinaryExpression binaryExpression){
        Type firstOperandType = binaryExpression.getFirstOperand().accept(this);
        Type secondOpenrandType = binaryExpression.getSecondOperand().accept(this);
        if (!firstOperandType.sameType(secondOpenrandType)) {
            typeErrors.add(new NonSameOperands(binaryExpression.getLine(), binaryExpression.getOperator()));
            return new NoType();
        }
        if (!BinaryOperator.isEqualityOperator(binaryExpression.getOperator()) &&
            (!firstOperandType.isNumericType() || !secondOpenrandType.isNumericType())) {
                typeErrors.add(new UnsupportedOperandType(binaryExpression.getLine(), binaryExpression.getOperator().toString()));
                return new NoType();
            }
        if (BinaryOperator.isArithmeticOperator(binaryExpression.getOperator()))
            return firstOperandType;
        return new BoolType();
    }
    @Override
    public Type visit(UnaryExpression unaryExpression){
        //TODO:visit unaryExpression
        UnaryOperator op = unaryExpression.getOperator();
        Type exprType = unaryExpression.getExpression().accept(this);
        if (op == UnaryOperator.NOT && !(exprType instanceof BoolType)) {
            typeErrors.add(new UnsupportedOperandType(unaryExpression.getLine(), op.toString()));
            return new NoType();
        }
        else if (!(exprType instanceof IntType)){
            typeErrors.add(new UnsupportedOperandType(unaryExpression.getLine(), op.toString()));
            return new NoType();
        }
        return null;
    }
    @Override
    public Type visit(ChompStatement chompStatement){
        if (!(chompStatement.getChompExpression().accept(this) instanceof StringType)) {
            typeErrors.add(new ChompArgumentTypeMisMatch(chompStatement.getLine()));
            return new NoType();
        }

        return new StringType();
    }
    @Override
    public Type visit(ChopStatement chopStatement){
        return new StringType();
    }
    @Override
    public Type visit(Identifier identifier){
        try {
            return SymbolTable.top.getVarItem(identifier.getName()).getType();
        } catch (ItemNotFound ignored) {}
        return null;
    }
    @Override
    public Type visit(LenStatement lenStatement){
        //TODO:visit LenStatement.Be carefull about the return type of LenStatement.
        Type argumentType = lenStatement.getExpression().accept(this);
        if (!(argumentType instanceof StringType || argumentType instanceof ListType))  {
            typeErrors.add(new LenArgumentTypeMisMatch(lenStatement.getLine()));
            return new NoType();
        }
        return new IntType();
    }
    @Override
    public Type visit(MatchPatternStatement matchPatternStatement){
        try{
            PatternItem patternItem = (PatternItem)SymbolTable.root.getItem(PatternItem.START_KEY +
                    matchPatternStatement.getPatternId().getName());
            patternItem.setTargetVarType(matchPatternStatement.getMatchArgument().accept(this));
            return patternItem.getPatternDeclaration().accept(this);
        }catch (ItemNotFound ignored){}
        return new NoType();
    }
    @Override
    public Type visit(RangeExpression rangeExpression){
        RangeType rangeType = rangeExpression.getRangeType();

        return switch (rangeType) {
            case RangeType.IDENTIFIER -> {
                Identifier identifier = (Identifier) rangeExpression.getRangeExpressions().getFirst();
                yield identifier.accept(this);
            }
            case RangeType.LIST -> {
                var listValue = new ListValue(rangeExpression.getRangeExpressions());
                yield listValue.accept(this);
            }
            case RangeType.DOUBLE_DOT -> new ListType(
                    rangeExpression.getRangeExpressions().getFirst().accept(this)
            );
        };
    }

    @Override
    public Type visit(IndexExpression indexExpression) {
        Type indexType = indexExpression.getIndex().accept(this);
        if(!(indexType instanceof IntType))
            typeErrors.add(new AccessIndexIsNotInt(indexExpression.getLine()));
        return indexType;
    }

    @Override
    public Type visit(ArgExpression argExpression) {
        return new ArgsType(
                argExpression.getArgs().stream()
                .map(arg -> arg.accept(this))
                .collect(Collectors.toCollection(ArrayList::new))
        );
    }
}
