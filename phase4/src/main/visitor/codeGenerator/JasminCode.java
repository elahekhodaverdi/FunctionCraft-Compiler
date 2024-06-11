package main.visitor.codeGenerator;

public class JasminCode {
    public static final String GET_PRINT_STREAM = "getstatic java/lang/System/out Ljava/io/PrintStream;";
    public static final String INVOKE_PRINTLN = "invokevirtual java/io/PrintStream/println(%s)V";
    public static final String STRING_TYPE = "Ljava/lang/String;";
    public static final String INTEGER_TYPE = "I";
    public static final String BOOLEAN_TYPE = "Z";
    public static final String VOID_TYPE = "V";
}
