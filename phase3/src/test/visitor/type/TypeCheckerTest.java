package test.visitor.type;

import main.FunctionCraft;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

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
}
