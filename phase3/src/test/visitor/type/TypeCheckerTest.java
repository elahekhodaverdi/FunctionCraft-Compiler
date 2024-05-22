package test.visitor.type;

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
}
