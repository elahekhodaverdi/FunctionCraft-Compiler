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
}