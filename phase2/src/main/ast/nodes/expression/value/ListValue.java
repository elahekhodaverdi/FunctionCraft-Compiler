package main.ast.nodes.expression.value;

import lombok.Getter;
import lombok.Setter;
import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

import java.util.ArrayList;

@Setter
@Getter
public class ListValue extends Value{
    private ArrayList<Expression> elements;
    public ListValue(ArrayList<Expression> elements){this.elements = elements;}

    @Override
    public String toString(){return "ListValue";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
