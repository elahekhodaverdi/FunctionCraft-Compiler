package main.ast.type;


import main.ast.type.primitiveType.IntType;

public abstract class Type {
    public boolean sameType(Type other){
        return this.getClass().equals(other.getClass()) || (this instanceof NoType) || (other instanceof NoType);
    }

    public boolean sameType(Class<?> other){
        return this.getClass() == other || other == NoType.class || this instanceof NoType;
    }

    public boolean isNumericType() {return false;}
}
