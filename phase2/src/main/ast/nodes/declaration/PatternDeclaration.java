package main.ast.nodes.declaration;

import lombok.Getter;
import lombok.Setter;
import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.Identifier;
import main.visitor.IVisitor;

import java.util.ArrayList;

@Getter
@Setter
public class PatternDeclaration extends Declaration{
    private Identifier patternName;
    private Identifier targetVariable;
    private ArrayList<Expression> conditions = new ArrayList<>();
    //Stores different condition cases
    private ArrayList<Expression> returnExp = new ArrayList<>();
    //Stores different returnExpressions associated with each condition


    public void addCondition(Expression condition){this.conditions.add(condition);}
    public void addConditions(ArrayList<Expression> condition){this.conditions.addAll(condition);}

    public void addReturnExp(Expression returnExp){this.returnExp.add(returnExp);}
    @Override
    public String toString(){return "PatternDeclaration:" + patternName + " on variable:" + targetVariable.getName();}
    @Override
    public <T> T accept(IVisitor<T>visitor){return visitor.visit(this);}

}
