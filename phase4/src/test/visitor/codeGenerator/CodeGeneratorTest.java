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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

//    @After
//    public void assertEqualErrors() throws IOException {
//
//        String[] args = new String[]{"samples/" + folderName + "/sample" + testCaseNumber + ".fl"};
//        String expectedOutputPath = "samples/" + folderName + "/out" + testCaseNumber + ".txt";
//
//        FunctionCraft.main(args);
//
//        Path path = Paths.get(expectedOutputPath);
//        String actualOutput = outputStream.toString().trim();
//        String expectedOutput = Files.readString(path).trim();
//
//        assertEquals(expectedOutput, actualOutput.lines());
//    }
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
        testCaseNumber = 1;
    }
}

