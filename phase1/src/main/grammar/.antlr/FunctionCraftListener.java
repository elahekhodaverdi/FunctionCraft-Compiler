// Generated from /home/mehdi/elearn/PLC/CAs/phase1/src/main/grammar/FunctionCraft.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FunctionCraftParser}.
 */
public interface FunctionCraftListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FunctionCraftParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FunctionCraftParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(FunctionCraftParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(FunctionCraftParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(FunctionCraftParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(FunctionCraftParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#function_prototype}.
	 * @param ctx the parse tree
	 */
	void enterFunction_prototype(FunctionCraftParser.Function_prototypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#function_prototype}.
	 * @param ctx the parse tree
	 */
	void exitFunction_prototype(FunctionCraftParser.Function_prototypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(FunctionCraftParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(FunctionCraftParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(FunctionCraftParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(FunctionCraftParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#pattern_matching}.
	 * @param ctx the parse tree
	 */
	void enterPattern_matching(FunctionCraftParser.Pattern_matchingContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#pattern_matching}.
	 * @param ctx the parse tree
	 */
	void exitPattern_matching(FunctionCraftParser.Pattern_matchingContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#pattern_body}.
	 * @param ctx the parse tree
	 */
	void enterPattern_body(FunctionCraftParser.Pattern_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#pattern_body}.
	 * @param ctx the parse tree
	 */
	void exitPattern_body(FunctionCraftParser.Pattern_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#pattern_call}.
	 * @param ctx the parse tree
	 */
	void enterPattern_call(FunctionCraftParser.Pattern_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#pattern_call}.
	 * @param ctx the parse tree
	 */
	void exitPattern_call(FunctionCraftParser.Pattern_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(FunctionCraftParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(FunctionCraftParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(FunctionCraftParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(FunctionCraftParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#elseif_statement}.
	 * @param ctx the parse tree
	 */
	void enterElseif_statement(FunctionCraftParser.Elseif_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#elseif_statement}.
	 * @param ctx the parse tree
	 */
	void exitElseif_statement(FunctionCraftParser.Elseif_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_statement(FunctionCraftParser.Else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_statement(FunctionCraftParser.Else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void enterLoop_statement(FunctionCraftParser.Loop_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void exitLoop_statement(FunctionCraftParser.Loop_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(FunctionCraftParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(FunctionCraftParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#loop_body}.
	 * @param ctx the parse tree
	 */
	void enterLoop_body(FunctionCraftParser.Loop_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#loop_body}.
	 * @param ctx the parse tree
	 */
	void exitLoop_body(FunctionCraftParser.Loop_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(FunctionCraftParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(FunctionCraftParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(FunctionCraftParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(FunctionCraftParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#jump_statement}.
	 * @param ctx the parse tree
	 */
	void enterJump_statement(FunctionCraftParser.Jump_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#jump_statement}.
	 * @param ctx the parse tree
	 */
	void exitJump_statement(FunctionCraftParser.Jump_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#break}.
	 * @param ctx the parse tree
	 */
	void enterBreak(FunctionCraftParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#break}.
	 * @param ctx the parse tree
	 */
	void exitBreak(FunctionCraftParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#next}.
	 * @param ctx the parse tree
	 */
	void enterNext(FunctionCraftParser.NextContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#next}.
	 * @param ctx the parse tree
	 */
	void exitNext(FunctionCraftParser.NextContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#break_if}.
	 * @param ctx the parse tree
	 */
	void enterBreak_if(FunctionCraftParser.Break_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#break_if}.
	 * @param ctx the parse tree
	 */
	void exitBreak_if(FunctionCraftParser.Break_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#next_if}.
	 * @param ctx the parse tree
	 */
	void enterNext_if(FunctionCraftParser.Next_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#next_if}.
	 * @param ctx the parse tree
	 */
	void exitNext_if(FunctionCraftParser.Next_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#lambda_function}.
	 * @param ctx the parse tree
	 */
	void enterLambda_function(FunctionCraftParser.Lambda_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#lambda_function}.
	 * @param ctx the parse tree
	 */
	void exitLambda_function(FunctionCraftParser.Lambda_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(FunctionCraftParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(FunctionCraftParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#function_pointer}.
	 * @param ctx the parse tree
	 */
	void enterFunction_pointer(FunctionCraftParser.Function_pointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#function_pointer}.
	 * @param ctx the parse tree
	 */
	void exitFunction_pointer(FunctionCraftParser.Function_pointerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#primitive_function_call}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_function_call(FunctionCraftParser.Primitive_function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#primitive_function_call}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_function_call(FunctionCraftParser.Primitive_function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(FunctionCraftParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(FunctionCraftParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(FunctionCraftParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(FunctionCraftParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#append_expr}.
	 * @param ctx the parse tree
	 */
	void enterAppend_expr(FunctionCraftParser.Append_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#append_expr}.
	 * @param ctx the parse tree
	 */
	void exitAppend_expr(FunctionCraftParser.Append_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#or_expr}.
	 * @param ctx the parse tree
	 */
	void enterOr_expr(FunctionCraftParser.Or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#or_expr}.
	 * @param ctx the parse tree
	 */
	void exitOr_expr(FunctionCraftParser.Or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expr(FunctionCraftParser.And_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expr(FunctionCraftParser.And_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#eq_expr}.
	 * @param ctx the parse tree
	 */
	void enterEq_expr(FunctionCraftParser.Eq_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#eq_expr}.
	 * @param ctx the parse tree
	 */
	void exitEq_expr(FunctionCraftParser.Eq_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#comp_expr}.
	 * @param ctx the parse tree
	 */
	void enterComp_expr(FunctionCraftParser.Comp_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#comp_expr}.
	 * @param ctx the parse tree
	 */
	void exitComp_expr(FunctionCraftParser.Comp_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#plus_minus_expr}.
	 * @param ctx the parse tree
	 */
	void enterPlus_minus_expr(FunctionCraftParser.Plus_minus_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#plus_minus_expr}.
	 * @param ctx the parse tree
	 */
	void exitPlus_minus_expr(FunctionCraftParser.Plus_minus_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#divide_mult_expr}.
	 * @param ctx the parse tree
	 */
	void enterDivide_mult_expr(FunctionCraftParser.Divide_mult_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#divide_mult_expr}.
	 * @param ctx the parse tree
	 */
	void exitDivide_mult_expr(FunctionCraftParser.Divide_mult_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#unary_prefix_operator_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_prefix_operator_expr(FunctionCraftParser.Unary_prefix_operator_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#unary_prefix_operator_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_prefix_operator_expr(FunctionCraftParser.Unary_prefix_operator_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#unary_postfix_operator_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_postfix_operator_expr(FunctionCraftParser.Unary_postfix_operator_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#unary_postfix_operator_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_postfix_operator_expr(FunctionCraftParser.Unary_postfix_operator_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#other_expr}.
	 * @param ctx the parse tree
	 */
	void enterOther_expr(FunctionCraftParser.Other_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#other_expr}.
	 * @param ctx the parse tree
	 */
	void exitOther_expr(FunctionCraftParser.Other_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#list_indexing}.
	 * @param ctx the parse tree
	 */
	void enterList_indexing(FunctionCraftParser.List_indexingContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#list_indexing}.
	 * @param ctx the parse tree
	 */
	void exitList_indexing(FunctionCraftParser.List_indexingContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#puts}.
	 * @param ctx the parse tree
	 */
	void enterPuts(FunctionCraftParser.PutsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#puts}.
	 * @param ctx the parse tree
	 */
	void exitPuts(FunctionCraftParser.PutsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#push}.
	 * @param ctx the parse tree
	 */
	void enterPush(FunctionCraftParser.PushContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#push}.
	 * @param ctx the parse tree
	 */
	void exitPush(FunctionCraftParser.PushContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#len}.
	 * @param ctx the parse tree
	 */
	void enterLen(FunctionCraftParser.LenContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#len}.
	 * @param ctx the parse tree
	 */
	void exitLen(FunctionCraftParser.LenContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#chop}.
	 * @param ctx the parse tree
	 */
	void enterChop(FunctionCraftParser.ChopContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#chop}.
	 * @param ctx the parse tree
	 */
	void exitChop(FunctionCraftParser.ChopContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#chomp}.
	 * @param ctx the parse tree
	 */
	void enterChomp(FunctionCraftParser.ChompContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#chomp}.
	 * @param ctx the parse tree
	 */
	void exitChomp(FunctionCraftParser.ChompContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(FunctionCraftParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(FunctionCraftParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#default_parameters}.
	 * @param ctx the parse tree
	 */
	void enterDefault_parameters(FunctionCraftParser.Default_parametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#default_parameters}.
	 * @param ctx the parse tree
	 */
	void exitDefault_parameters(FunctionCraftParser.Default_parametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#default_parameter}.
	 * @param ctx the parse tree
	 */
	void enterDefault_parameter(FunctionCraftParser.Default_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#default_parameter}.
	 * @param ctx the parse tree
	 */
	void exitDefault_parameter(FunctionCraftParser.Default_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(FunctionCraftParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(FunctionCraftParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(FunctionCraftParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(FunctionCraftParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(FunctionCraftParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(FunctionCraftParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#value_list}.
	 * @param ctx the parse tree
	 */
	void enterValue_list(FunctionCraftParser.Value_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#value_list}.
	 * @param ctx the parse tree
	 */
	void exitValue_list(FunctionCraftParser.Value_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(FunctionCraftParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(FunctionCraftParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#value_literal}.
	 * @param ctx the parse tree
	 */
	void enterValue_literal(FunctionCraftParser.Value_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#value_literal}.
	 * @param ctx the parse tree
	 */
	void exitValue_literal(FunctionCraftParser.Value_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link FunctionCraftParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(FunctionCraftParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link FunctionCraftParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(FunctionCraftParser.BooleanContext ctx);
}