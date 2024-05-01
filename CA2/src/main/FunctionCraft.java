package src.main;



import src.main.ast.nodes.Program;
import src.main.compileError.CompileError;
import src.main.visitor.astPrinter.AstPrinter;
import src.main.visitor.nameAnalyzer.DependencyDetector;
import src.main.visitor.nameAnalyzer.NameAnalyzer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parsers.FunctionCraftLexer;
import parsers.FunctionCraftParser;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class FunctionCraft {
    public static void main(String[] args) throws IOException{
        CharStream reader = CharStreams.fromFileName(args[0]);
        FunctionCraftLexer flLexer = new FunctionCraftLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(flLexer);
        FunctionCraftParser flParser = new FunctionCraftParser(tokens);
        Program program = flParser.program().flProgram;
        NameAnalyzer nameAnalyzer = new NameAnalyzer();
        nameAnalyzer.visit(program);
        nameAnalyzer.nameErrors.sort(Comparator.comparingInt(CompileError::getLine));
        for(CompileError compileError : nameAnalyzer.nameErrors){
            System.out.println(compileError.getErrorMessage());
        }
        DependencyDetector dependencyDetector = new DependencyDetector();
        dependencyDetector.visit(program);
        dependencyDetector.findDependency();
        for(CompileError circularDependency : dependencyDetector.dependencyError){
            System.out.println(circularDependency.getErrorMessage());
        }
        if(nameAnalyzer.nameErrors.size() + dependencyDetector.dependencyError.size() == 0){
            AstPrinter astPrinter = new AstPrinter();
            astPrinter.visit(program);
        }
    }
}
