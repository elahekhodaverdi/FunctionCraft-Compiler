package main.visitor.codeGenerator;

import java.util.List;

public class Jasmin {
    public static final String INVOKE_OBJECT_INIT = "invokespecial java/lang/Object/<init>()V";

    public static final String GET_PRINT_STREAM = "getstatic java/lang/System/out Ljava/io/PrintStream;";
    public static final String INVOKE_PRINTLN = "invokevirtual java/io/PrintStream/println(%s)V";

    public static final String INT_TO_INTEGER = "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;";
    public static final String INTEGER_TO_INT = "invokevirtual java/lang/Integer/intValue()I";
    public static final String BOOL_TO_BOOLEAN = "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;";

    public static final String NEW_LIST = "new List";
    public static final String INVOKE_LIST_ININT = "invokespecial List/<init>(Ljava/util/ArrayList;)V";
    public static final String NEW_ARRAY_LIST = "new java/util/ArrayList";
    public static final String INVOKE_ARRAY_LIST_ININT = "invokespecial java/util/ArrayList/<init>()V";
    public static final String INVOKE_ARRAY_LIST_ADD = "invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z";
    public static final String INVOKE_ARRAY_LIST_GET = "invokevirtual java/util/ArrayList/get(I)Ljava/lang/Object;";
    public static final String INVOKE_ARRAY_LIST_SET = "invokevirtual java/util/ArrayList/set(ILjava/lang/Object;)Ljava/lang/Object;";
    public static final String INVOKE_ARRAY_LIST_SIZE = "invokevirtual java/util/ArrayList/size()I";

    public static final String INVOKE_STRING_LENGTH = "invokevirtual java/lang/String/length()I";
    public static final String INVOKE_STRING_SUBSTRING ="invokevirtual java/lang/String/substring(II)Ljava/lang/String;";

    public static final String DUP = "dup";
    public static final String POP = "pop";
    public static final String SWAP = "swap";
    public static final String ALOAD = "aload ";
    public static final String ILOAD = "iload ";
    public static final String ASTORE = "astore ";
    public static final String ISTORE = "istore ";
    public static final String ISUB = "isub";
    public static final String IADD = "iadd";
    public static final String ICONST_0 = "iconst_0";
    public static final String ICONST_1 = "iconst_1";
    public static final String CHECKCAST = "checkcast ";
    public static final String RETURN = "return";
    public static final String GOTO = "goto ";

    public static final String LABEL = "%s:";

    public static final String REF = "L%s;";
    public static final String STRING_TYPE = "java/lang/String";
    public static final String INTEGER_TYE = "java/lang/Integer";
    public static final String OBJECT_TYPE = "java/lang/Object";
    public static final String INT_TYPE = "I";
    public static final String BOOLEAN_TYPE = "Z";
    public static final String VOID_TYPE = "V";

    public static final String BEGIN_METHOD = ".method public static  %s(%s)%s";
    public static final String DEFAULT_LIMIT_STACK = ".limit stack 128";
    public static final String DEFAULT_LIMIT_LOCALS = ".limit locals 128";
    public static final String END_METHOD = ".end method";

    public static final String EMPTY = "";

    public static String join(List<String> commands) {
        return String.join("\n", commands) ;
    }
    public static String refOf(String type) {
        return String.format(REF, type);
    }
}
