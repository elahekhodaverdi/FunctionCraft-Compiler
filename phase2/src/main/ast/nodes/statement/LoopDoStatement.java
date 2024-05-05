package main.ast.nodes.statement;

import lombok.Getter;
import lombok.Setter;
import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

import java.util.ArrayList;

@Getter
@Setter
public class LoopDoStatement extends Statement{
    private ArrayList<Statement> loopBodyStmts = new ArrayList<>();
    private ArrayList<Expression> loopConditions = new ArrayList<>();
    private ReturnStatement loopRetStmt;

    public LoopDoStatement(ArrayList<Statement>loopBodyStmts, ArrayList<Expression>loopConditions,
                           ReturnStatement loopRetStmt){
        this.loopBodyStmts = loopBodyStmts;
        this.loopConditions = loopConditions;
        this.loopRetStmt = loopRetStmt;
    }

    @Override
    public String toString(){return "LoopDoStatement";}
    @Override
    public <T> T accept(IVisitor<T>visitor){return visitor.visit(this);}
}
