package main.ast.type;

import java.util.ArrayList;

public class VoidType extends Type {

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        return 4;
    }

    @Override
    public String toString() {
        return "VoidType";
    }
}