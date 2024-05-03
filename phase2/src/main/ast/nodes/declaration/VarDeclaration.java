package main.ast.nodes.declaration;

import lombok.Getter;
import lombok.Setter;
import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.Identifier;
import main.visitor.IVisitor;

@Getter
@Setter
public class VarDeclaration extends Declaration{
    private Identifier name;
    private Expression defaultVal;

    public VarDeclaration(Identifier name){
        this.name = name;
        this.defaultVal = null;
    }

    public boolean hasDefaultVal() {
        return defaultVal != null;
    }

    @Override
    public String toString(){return "VarDeclaration:" + this.name;}
    @Override
    public<T>T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
