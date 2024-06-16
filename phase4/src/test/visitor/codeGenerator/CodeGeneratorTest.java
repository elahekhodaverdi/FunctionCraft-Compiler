package test.visitor.codeGenerator;

import main.FunctionCraft;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class CodeGeneratorTest {
    private int testCaseNumber;
    private String folderName;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void assertEqualErrors() throws IOException {
        String[] args = new String[]{"samples/" + folderName + "/sample" + testCaseNumber + ".fl"};
        String expectedOutputPath = "samples/" + folderName + "/out" + testCaseNumber + ".txt";

        FunctionCraft.main(args);

        Path path = Paths.get(expectedOutputPath);
        String actualOutput = outputStream.toString().trim();
        String expectedOutput = Files.readString(path).trim();


        String[] actualLines = actualOutput.split("\n");
        String[] actualOutputLines = new String[actualLines.length - 1];
        System.arraycopy(actualLines, 1, actualOutputLines, 0, actualLines.length - 1);

        assertEquals(expectedOutput, String.join("\n", actualOutputLines));
    }

    @Test
    public void puts_integer() {
        folderName = "putsStatement";
        testCaseNumber = 1;
    }

    @Test
    public void puts_string() {
        folderName = "putsStatement";
        testCaseNumber = 2;
    }

    @Test
    public void puts_boolean() {
        folderName = "putsStatement";
        testCaseNumber = 3;
    }

    @Test
    public void chop() {
        folderName = "chopStatement";
        testCaseNumber = 1;
    }

    @Test
    public void not_operator() {
        folderName = "unaryExpression";
        testCaseNumber = 1;
    }

    @Test
    public void minus_operator() {
        folderName = "unaryExpression";
        testCaseNumber = 2;
    }

    @Test
    public void decrement_operator() {
        folderName = "unaryExpression";
        testCaseNumber = 3;
    }

    @Test
    public void increment_operator() {
        folderName = "unaryExpression";
        testCaseNumber = 4;
    }

    @Test
    public void true_if() {
        folderName = "ifStatement";
        testCaseNumber = 1;
    }

    @Test
    public void false_if() {
        folderName = "ifStatement";
        testCaseNumber = 2;
    }

    @Test
    public void true_else() {
        folderName = "ifStatement";
        testCaseNumber = 3;
    }

    @Test
    public void false_else() {
        folderName = "ifStatement";
        testCaseNumber = 4;
    }

    @Test
    public void multiple_if() {
        folderName = "ifStatement";
        testCaseNumber = 5;
    }

    @Test
    public void expression_in_if_condition() {
        folderName = "ifStatement";
        testCaseNumber = 6;
    }

    @Test
    public void plus_operator() {
        folderName = "binaryExpression";
        testCaseNumber = 1;
    }

    @Test
    public void binary_minus_operator() {
        folderName = "binaryExpression";
        testCaseNumber = 2;
    }

    @Test
    public void multiply_operator() {
        folderName = "binaryExpression";
        testCaseNumber = 3;
    }

    @Test
    public void divide_operator() {
        folderName = "binaryExpression";
        testCaseNumber = 4;
    }

    @Test
    public void equal_operator() {
        folderName = "binaryExpression";
        testCaseNumber = 5;
    }

    @Test
    public void not_equal_operator() {
        folderName = "binaryExpression";
        testCaseNumber = 6;
    }

    @Test
    public void greater_than_operator() {
        folderName = "binaryExpression";
        testCaseNumber = 7;
    }

    @Test
    public void less_than_operator() {
        folderName = "binaryExpression";
        testCaseNumber = 8;
    }

    @Test
    public void greater_or_equal_operator() {
        folderName = "binaryExpression";
        testCaseNumber = 9;
    }

    @Test
    public void less_or_equal_operator() {
        folderName = "binaryExpression";
        testCaseNumber = 10;
    }

    @Test
    public void assign_to_an_identifier() {
        folderName = "assignStatement";
        testCaseNumber = 1;
    }

    @Test
    public void assign_to_an_element_of_list() {
        folderName = "assignStatement";
        testCaseNumber = 2;
    }

    @Test
    public void assign_from_an_identifier_to_an_identifier() {
        folderName = "assignStatement";
        testCaseNumber = 3;
    }

    @Test
    public void only_list_pass_by_reference() {
        folderName = "assignStatement";
        testCaseNumber = 4;
    }

    @Test
    public void assign_function_pointer_to_an_identifier() {
        folderName = "assignStatement";
        testCaseNumber = 5;
    }

    @Test
    public void assign_an_element_of_function_pointer_list_to_an_identifier() {
        folderName = "assignStatement";
        testCaseNumber = 6;
    }

    @Test
    public void all_assign_operators() {
        folderName = "assignStatement";
        testCaseNumber = 7;
    }

    @Test
    public void len_statement() {
        folderName = "lenStatement";
        testCaseNumber = 1;
    }

    @Test
    public void loop_do_statement_without_next() {
        folderName = "loopDoStatement";
        testCaseNumber = 1;
    }

    @Test
    public void loop_do_statement_with_next() {
        folderName = "loopDoStatement";
        testCaseNumber = 2;
    }

    @Test
    public void integer_type_argument() {
        folderName = "functionDeclaration";
        testCaseNumber = 1;
    }

    @Test
    public void boolean_type_argument() {
        folderName = "functionDeclaration";
        testCaseNumber = 2;
    }

    @Test
    public void string_type_argument() {
        folderName = "functionDeclaration";
        testCaseNumber = 3;
    }

    @Test
    public void list_type_argument() {
        folderName = "functionDeclaration";
        testCaseNumber = 4;
    }


    @Test
    public void return_integer_type() {
        folderName = "functionDeclaration";
        testCaseNumber = 5;
    }

    @Test
    public void return_string_type() {
        folderName = "functionDeclaration";
        testCaseNumber = 8;
    }

    @Test
    public void return_list_type() {
        folderName = "functionDeclaration";
        testCaseNumber = 9;
    }

    @Test
    public void return_function_pointer_type() {
        folderName = "functionDeclaration";
        testCaseNumber = 10;
    }

    @Test
    public void return_in_do_loop_scope_of_function() {
        folderName = "functionDeclaration";
        testCaseNumber = 6;
    }

    @Test
    public void return_in_if_scope_of_function() {
        folderName = "functionDeclaration";
        testCaseNumber = 7;
    }

    @Test
    public void call_function_pointer() {
        folderName = "functionPointer";
        testCaseNumber = 1;
    }

    @Test
    public void print_a_list_recursively() {
        folderName = "integration";
        testCaseNumber = 1;
    }

    @Test
    public void calculate_power_with_loop() {
        folderName = "integration";
        testCaseNumber = 2;
    }

    @Test
    public void simple_calculator() {
        folderName = "integration";
        testCaseNumber = 3;
    }

}

