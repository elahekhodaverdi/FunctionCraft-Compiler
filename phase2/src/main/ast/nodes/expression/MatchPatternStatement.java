package main.ast.nodes.expression;

import lombok.Getter;
import lombok.Setter;
import main.visitor.IVisitor;

@Getter
@Setter
public class MatchPatternStatement extends Expression{
    private Identifier patternId;
    Expression matchArgument;
    public MatchPatternStatement(Identifier patternId, Expression matchArgument){
        this.matchArgument = matchArgument;
        this.patternId = patternId;
    }

    @Override
    public String toString(){return "MatchPattern:"+patternId.getName();}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
