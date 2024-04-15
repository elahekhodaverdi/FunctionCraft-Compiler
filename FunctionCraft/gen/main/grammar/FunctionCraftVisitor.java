// Generated from E:/elahe/git/PLC/FunctionCraft/src/main/grammar/FunctionCraft.g4 by ANTLR 4.13.1
package main.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FunctionCraftParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FunctionCraftVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FunctionCraftParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(FunctionCraftParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(FunctionCraftParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#function_prototype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_prototype(FunctionCraftParser.Function_prototypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(FunctionCraftParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(FunctionCraftParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#pattern_matching}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern_matching(FunctionCraftParser.Pattern_matchingContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#pattern_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern_body(FunctionCraftParser.Pattern_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#pattern_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern_call(FunctionCraftParser.Pattern_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(FunctionCraftParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(FunctionCraftParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#elseif_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseif_statement(FunctionCraftParser.Elseif_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_statement(FunctionCraftParser.Else_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#loop_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_statement(FunctionCraftParser.Loop_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement(FunctionCraftParser.For_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#loop_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_body(FunctionCraftParser.Loop_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(FunctionCraftParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(FunctionCraftParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#jump_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_statement(FunctionCraftParser.Jump_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#break}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(FunctionCraftParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#next}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNext(FunctionCraftParser.NextContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#break_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_if(FunctionCraftParser.Break_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#next_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNext_if(FunctionCraftParser.Next_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#lambda_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_function(FunctionCraftParser.Lambda_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(FunctionCraftParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#list_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_access(FunctionCraftParser.List_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#inner_list_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInner_list_access(FunctionCraftParser.Inner_list_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#function_pointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_pointer(FunctionCraftParser.Function_pointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#primitive_function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_function_call(FunctionCraftParser.Primitive_function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(FunctionCraftParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(FunctionCraftParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#append_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppend_expr(FunctionCraftParser.Append_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_expr(FunctionCraftParser.Or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expr(FunctionCraftParser.And_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#eq_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq_expr(FunctionCraftParser.Eq_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#comp_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_expr(FunctionCraftParser.Comp_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#plus_minus_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus_minus_expr(FunctionCraftParser.Plus_minus_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#divide_mult_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide_mult_expr(FunctionCraftParser.Divide_mult_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#unary_prefix_operator_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_prefix_operator_expr(FunctionCraftParser.Unary_prefix_operator_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#unary_postfix_operator_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_postfix_operator_expr(FunctionCraftParser.Unary_postfix_operator_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#other_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOther_expr(FunctionCraftParser.Other_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#list_indexing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_indexing(FunctionCraftParser.List_indexingContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#puts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPuts(FunctionCraftParser.PutsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#push}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPush(FunctionCraftParser.PushContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#len}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLen(FunctionCraftParser.LenContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#chop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChop(FunctionCraftParser.ChopContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#chomp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChomp(FunctionCraftParser.ChompContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(FunctionCraftParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#default_parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefault_parameters(FunctionCraftParser.Default_parametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#default_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefault_parameter(FunctionCraftParser.Default_parameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(FunctionCraftParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(FunctionCraftParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(FunctionCraftParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#value_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_list(FunctionCraftParser.Value_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(FunctionCraftParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#value_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_literal(FunctionCraftParser.Value_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionCraftParser#boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(FunctionCraftParser.BooleanContext ctx);
}