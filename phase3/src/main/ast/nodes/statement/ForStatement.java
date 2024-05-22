package main.ast.nodes.statement;


import lombok.Getter;
import lombok.Setter;
import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.Identifier;
import main.visitor.IVisitor;

import java.util.ArrayList;

@Getter
@Setter
public class ForStatement extends Statement{
    private Identifier iteratorId;
    private ArrayList<Expression> rangeExpressions = new ArrayList<>();
    private ArrayList<Expression> loopBodyExpressions = new ArrayList<>();
    //expressions that satisfy break or continue conditions
    private ArrayList<Statement> loopBody = new ArrayList<>();
    private ReturnStatement returnStatement = null;
    public ForStatement() {}
    public ForStatement(Identifier identifierId, ArrayList<Expression> rangeExpressions
                        , ArrayList<Expression> loopBodyExpressions, ArrayList<Statement> loopBody
                        , ReturnStatement returnStatement){
        this.iteratorId = identifierId;
        this.rangeExpressions = rangeExpressions;
        this.loopBodyExpressions = loopBodyExpressions;
        this.loopBody = loopBody;
        this.returnStatement = returnStatement;

    }

    public boolean hasReturnStatement() {
        return returnStatement != null;
    }

    @Override
    public String toString(){return "ForLoop:"+iteratorId.getName();}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}

}
