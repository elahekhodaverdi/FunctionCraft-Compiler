package main.ast.nodes.statement;

import lombok.Getter;
import lombok.Setter;
import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Getter
@Setter
public class IfStatement extends Statement{
    private ArrayList<Expression> conditions = new ArrayList<>();
    //contains all conditions of if and elseIfs and break conditions inside ifBody
    private ArrayList<Statement> thenBody = new ArrayList<>();
    private ArrayList<Statement> elseBody = new ArrayList<>();

    public void addCondition(ArrayList<Expression> condition){this.conditions.addAll(condition);}
    @Override
    public String toString(){return "IfStatement";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
