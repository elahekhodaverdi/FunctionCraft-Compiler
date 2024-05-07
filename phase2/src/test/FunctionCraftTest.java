package test;

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

public class FunctionCraftTest {
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
    public void several_errors() {
        testCaseNumber = 0;
    }


    @Test
    public void redefinition_of_function_with_same_arguments() {
        testCaseNumber = 1;
    }

    @Test
    public void redefinition_of_function_with_different_arguments() {
        testCaseNumber = 2;
    }

    @Test
    public void variable_not_declared_in_assignment() {
        testCaseNumber = 3;
    }

    @Test
    public void variable_not_declared_in_assignment_to_itself() {
        testCaseNumber = 4;
    }

    @Test
    public void variable_not_declared_when_assign_to_an_element_of_not_declared_list() {
        testCaseNumber = 5;
    }

    @Test
    public void variable_not_declared_in_return_statement() {
        testCaseNumber = 6;
    }

    @Test
    public void function_not_declared_in_nested_call_functions() {
        testCaseNumber = 7;
    }

    @Test
    public void function_not_declared_when_if_condition_is_a_function_call() {
        testCaseNumber = 8;
    }

    @Test
    public void argument_has_same_name_with_function() {
        testCaseNumber = 9;
    }

    @Test
    public void argument_has_same_name_with_function_and_it_is_used() {
        testCaseNumber = 10;
    }

    @Test
    public void incorrect_number_of_arguments_in_function_call_when_the_function_has_default_arguments() {
        testCaseNumber = 11;
    }

    @Test
    public void incorrect_number_of_arguments_in_function_call_when_the_function_does_not_have_default_arguments() {
        testCaseNumber = 12;
    }

    @Test
    public void circular_dependency() {
        testCaseNumber = 13;
    }

    @Test
    public void direct_circular_dependency() {
        testCaseNumber = 14;
    }

    @Test
    public void circular_dependency_in_return_value() {
        testCaseNumber = 15;
    }

    @Test
    public void circular_dependency_in_binary_expression() {
        testCaseNumber = 16;
    }

    @Test
    public void circular_dependency_in_unary_expression() {
        testCaseNumber = 17;
    }

    @Test
    public void circular_dependency_in_append_expression() {
        testCaseNumber = 18;
    }

    @Test
    public void circular_dependency_in_function_call_argument() {
        testCaseNumber = 19;
    }

    @Test
    public void circular_dependency_in_primitive_function_call_argument() {
        testCaseNumber = 20;
    }

    @Test
    public void circular_dependency_in_list_indexing() {
        testCaseNumber = 21;
    }

    @Test
    public void circular_dependency_in_pattern_matching() {
        testCaseNumber = 22;
    }

    @Test
    public void circular_dependency_in_assignment() {
        testCaseNumber = 23;
    }

    @Test
    public void variable_not_declared_in_range_statement() {
        testCaseNumber = 24;
    }

    @Test
    public void circular_dependency_in_list_value() {
        testCaseNumber = 25;
    }

    @Test
    public void circular_dependency_in_function_declaration_argument() {
        testCaseNumber = 26;
    }

    @Test
    public void circular_dependency_in_if_conditions() {
        testCaseNumber = 27;
    }

    @Test
    public void circular_dependency_in_loop() {
        testCaseNumber = 28;
    }

    @Test
    public void circular_dependency_in_for_loop() {
        testCaseNumber = 29;
    }

    @Test
    public void variable_not_declared_after_for_loop_scope() {
        testCaseNumber = 30;
    }

    @Test
    public void variable_not_declared_after_loop_scope() {
        testCaseNumber = 31;
    }

    @Test
    public void variable_not_declared_after_if_scope() {
        testCaseNumber = 32;
    }

    @Test
    public void circular_dependency_in_lambda_function_call() {
        testCaseNumber = 33;
    }

    @Test
    public void variable_not_declared_in_lambda_function_call() {
        testCaseNumber = 34;
    }
}