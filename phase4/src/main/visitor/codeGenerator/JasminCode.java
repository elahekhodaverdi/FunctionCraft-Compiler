package main.visitor.codeGenerator;

import java.util.List;

public class JasminCode {
    public static final String GET_PRINT_STREAM = "getstatic java/lang/System/out Ljava/io/PrintStream;";
    public static final String INVOKE_PRINTLN = "invokevirtual java/io/PrintStream/println(%s)V";

    public static final String INT_TO_INTEGER = "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;";
    public static final String BOOL_TO_BOOLEAN = "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;";

    public static final String STRING_TYPE = "Ljava/lang/String;";
    public static final String INTEGER_TYPE = "I";
    public static final String BOOLEAN_TYPE = "Z";
    public static final String VOID_TYPE = "V";

    public static String join(List<String> commands) {
        return String.join("\n", commands) + "\n";
    }
}
