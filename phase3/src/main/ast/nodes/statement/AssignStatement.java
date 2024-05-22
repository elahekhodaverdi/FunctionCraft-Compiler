package main.ast.nodes.statement;

import lombok.Getter;
import lombok.Setter;
import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.Identifier;
import main.visitor.IVisitor;


@Setter
@Getter
public class AssignStatement extends Statement{
    private boolean accessList;
    private Identifier assignedId;
    private Expression assignExpression;
    private Expression accessListExpression;
    private AssignOperator assignOperator;
    public AssignStatement(boolean accessList, Identifier assignedId, Expression assignExpression,
                           AssignOperator assignOperator){
        this.accessList = accessList;
        this.assignedId = assignedId;
        this.assignExpression = assignExpression;
        this.assignOperator = assignOperator;
    }

    @Override
    public String toString(){return "AssignTo:"+ this.assignedId.toString();}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}

