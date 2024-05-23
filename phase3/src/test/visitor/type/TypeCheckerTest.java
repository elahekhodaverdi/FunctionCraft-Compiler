package test.visitor.type;

import main.FunctionCraft;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.type.FptrType;
import main.ast.type.primitiveType.BoolType;
import main.ast.type.primitiveType.IntType;
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

public class TypeCheckerTest {
    private int testCaseNumber;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void assertEqualErrors() throws IOException {

        String[] args = new String[]{"samples/input/sample" + testCaseNumber + ".fl"};
        String expectedOutputPath = "samples/output/out" + testCaseNumber + ".txt";

        FunctionCraft.main(args);

        Path path = Paths.get(expectedOutputPath);
        String actualOutput = outputStream.toString().trim();
        String expectedOutput = Files.readString(path).trim();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void access_index_is_not_int_in_left_value() {
        testCaseNumber = 1;
    }

    @Test
    public void operands_of_operator_must_be_the_same_in_a_function() {
        testCaseNumber = 2;
    }

    @Test
    public void access_index_is_not_int_in_right_value() {
        testCaseNumber = 3;
    }

    @Test
    public void type_of_an_identifier_change_after_assignment() {
        testCaseNumber = 4;
    }

    @Test
    public void call_function_with_function_pointer() {
        testCaseNumber = 5;
    }

    @Test
    public void call_a_function_pointer_after_a_list_indexing() {
        testCaseNumber = 6;
    }

    @Test
    public void list_with_different_element_types_gives_error() {
        testCaseNumber = 7;
    }

    @Test
    public void the_chain_of_three_operands_does_not_have_the_same_type() {
        testCaseNumber = 8;
    }

    @Test
    public void the_chain_of_five_operands_with_two_branches_in_ast_does_not_have_the_same_type() {
        testCaseNumber = 20;
    }

    @Test
    public void return_type_of_function_is_correct() {
        testCaseNumber = 9;
    }

    @Test
    public void adding_a_function_call_with_a_void_return_type_to_an_integer() {
        testCaseNumber = 10;
    }

    @Test
    public void type_check_error_in_a_expression_as_a_function_call_argument() {
        testCaseNumber = 11;
    }

    @Test
    public void function_return_type_is_no_type_as_same_as_its_argument() {
        testCaseNumber = 12;
    }

    @Test
    public void different_return_type_with_return_statement_within_if_body() {
        testCaseNumber = 14;
    }

    @Test
    public void different_return_type_with_return_statement_within_loop_body() {
        testCaseNumber = 15;
    }

    @Test
    public void different_return_type_for_main_function_with_return_statement_within_loop_body() {
        testCaseNumber = 16;
    }

    @Test
    public void return_types_are_just_no_type_and_one_another() {
        testCaseNumber = 13;
    }

    @Test
    public void different_return_type_in_function_if_body_in_main() {
        testCaseNumber = 17;
    }

    @Test
    public void more_that_two_return_types_in_function_call() {
        testCaseNumber = 18;
    }

    @Test
    public void more_that_two_return_types_in_main() {
        testCaseNumber = 19;
    }
}
