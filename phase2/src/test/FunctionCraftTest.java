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
    private String[] args;
    private ByteArrayOutputStream outputStream;
    private String expectedOutputPath;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void assertEqualErrors() throws IOException {
        FunctionCraft.main(args);

        Path path = Paths.get(expectedOutputPath);
        String actualOutput = outputStream.toString().trim();
        String expectedOutput = Files.readString(path).trim();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void redefinition_of_function_with_same_arguments() {
        args = new String[]{"samples/sample1.fl"};
        expectedOutputPath = "samples/out1.txt";
    }

    @Test
    public void redefinition_of_function_with_different_arguments() {
        args = new String[]{"samples/sample2.fl"};
        expectedOutputPath = "samples/out2.txt";
    }

    @Test
    public void variable_not_declared_in_assignment() {
        args = new String[]{"samples/sample3.fl"};
        expectedOutputPath = "samples/out3.txt";
    }

    @Test
    public void variable_not_declared_in_assignment_to_itself() {
        args = new String[]{"samples/sample4.fl"};
        expectedOutputPath = "samples/out4.txt";
    }

    @Test
    public void variable_not_declared_when_assign_to_an_element_of_not_declared_list() {
        args = new String[]{"samples/sample5.fl"};
        expectedOutputPath = "samples/out5.txt";
    }

    @Test
    public void variable_not_declared_in_return_statement() {
        args = new String[]{"samples/sample6.fl"};
        expectedOutputPath = "samples/out6.txt";
    }

    @Test
    public void function_not_declared_in_nested_call_functions() {
        args = new String[]{"samples/sample7.fl"};
        expectedOutputPath = "samples/out7.txt";
    }

    @Test
    public void function_not_declared_when_if_condition_is_a_function_call() {
        args = new String[]{"samples/sample8.fl"};
        expectedOutputPath = "samples/out8.txt";
    }

    @Test
    public void argument_has_same_name_with_function() {
        args = new String[]{"samples/sample9.fl"};
        expectedOutputPath = "samples/out9.txt";
    }

    @Test
    public void argument_has_same_name_with_function_and_it_is_used() {
        args = new String[]{"samples/sample10.fl"};
        expectedOutputPath = "samples/out10.txt";
    }

    @Test
    public void incorrect_number_of_arguments_in_function_call_when_the_function_has_default_arguments() {
        args = new String[]{"samples/sample11.fl"};
        expectedOutputPath = "samples/out11.txt";
    }

    @Test
    public void incorrect_number_of_arguments_in_function_call_when_the_function_does_not_have_default_arguments() {
        args = new String[]{"samples/sample12.fl"};
        expectedOutputPath = "samples/out12.txt";
    }

    @Test
    public void circular_dependency() {
        args = new String[]{"samples/sample13.fl"};
        expectedOutputPath = "samples/out13.txt";
    }

    @Test
    public void direct_circular_dependency() {
        args = new String[]{"samples/sample14.fl"};
        expectedOutputPath = "samples/out14.txt";
    }

    @Test
    public void circular_dependency_in_return_value() {
        args = new String[]{"samples/sample15.fl"};
        expectedOutputPath = "samples/out15.txt";
    }

    @Test
    public void circular_dependency_in_binary_expression() {
        args = new String[]{"samples/sample16.fl"};
        expectedOutputPath = "samples/out16.txt";
    }

    @Test
    public void circular_dependency_in_unary_expression() {
        args = new String[]{"samples/sample17.fl"};
        expectedOutputPath = "samples/out17.txt";
    }

    @Test
    public void circular_dependency_in_append_expression() {
        args = new String[]{"samples/sample18.fl"};
        expectedOutputPath = "samples/out18.txt";
    }

    @Test
    public void circular_dependency_in_function_call_argument() {
        args = new String[]{"samples/sample19.fl"};
        expectedOutputPath = "samples/out19.txt";
    }

    @Test
    public void circular_dependency_in_primitive_function_call_argument() {
        args = new String[]{"samples/sample20.fl"};
        expectedOutputPath = "samples/out20.txt";
    }

    @Test
    public void circular_dependency_in_list_indexing() {
        args = new String[]{"samples/sample21.fl"};
        expectedOutputPath = "samples/out21.txt";
    }

    @Test
    public void circular_dependency_in_pattern_matching() {
        args = new String[]{"samples/sample22.fl"};
        expectedOutputPath = "samples/out22.txt";
    }

    @Test
    public void circular_dependency_in_assignment() {
        args = new String[]{"samples/sample23.fl"};
        expectedOutputPath = "samples/out23.txt";
    }

    @Test
    public void variable_not_declared_in_range_statement() {
        args = new String[]{"samples/sample24.fl"};
        expectedOutputPath = "samples/out24.txt";
    }

    @Test
    public void circular_dependency_in_list_value() {
        args = new String[]{"samples/sample25.fl"};
        expectedOutputPath = "samples/out25.txt";
    }

    @Test
    public void circular_dependency_in_function_declaration_argument() {
        args = new String[]{"samples/sample26.fl"};
        expectedOutputPath = "samples/out26.txt";
    }

    @Test
    public void circular_dependency_in_if_conditions() {
        args = new String[]{"samples/sample27.fl"};
        expectedOutputPath = "samples/out27.txt";
    }

    @Test
    public void circular_dependency_in_loop() {
        args = new String[]{"samples/sample28.fl"};
        expectedOutputPath = "samples/out28.txt";
    }

    @Test
    public void circular_dependency_in_for_loop() {
        args = new String[]{"samples/sample29.fl"};
        expectedOutputPath = "samples/out29.txt";
    }

    @Test
    public void variable_not_declared_after_for_loop_scope() {
        args = new String[]{"samples/sample30.fl"};
        expectedOutputPath = "samples/out30.txt";
    }

    @Test
    public void variable_not_declared_after_loop_scope() {
        args = new String[]{"samples/sample31.fl"};
        expectedOutputPath = "samples/out31.txt";
    }

    @Test
    public void variable_not_declared_after_if_scope() {
        args = new String[]{"samples/sample32.fl"};
        expectedOutputPath = "samples/out32.txt";
    }

    @Test
    public void circular_dependency_in_lambda_function_call() {
        args = new String[]{"samples/sample33.fl"};
        expectedOutputPath = "samples/out33.txt";
    }
}