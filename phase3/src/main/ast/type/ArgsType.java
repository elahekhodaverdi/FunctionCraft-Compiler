package main.ast.type;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ArgsType extends Type {
    private ArrayList<Type> argsType;

    public ArgsType(ArrayList<Type> argsType) {
        this.argsType = argsType;
    }

    @Override
    public String toString() {
        return "ArgsType";
    }
}
