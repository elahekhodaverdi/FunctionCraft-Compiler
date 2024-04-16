// Generated from /home/mehdi/elearn/PLC/CAs/FunctionCraft/src/main/grammar/FunctionCraft.g4 by ANTLR 4.13.1
package main.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FunctionCraftParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAR=1, RPAR=2, LSB=3, RSB=4, LCB=5, RCB=6, DQUATE=7, RARROW=8, COLON=9, 
		SEMICOLON=10, COMMA=11, DEF=12, END=13, MAIN=14, RETURN=15, IF=16, ELSE=17, 
		ELSEIF=18, TRUE=19, FALSE=20, CHOP=21, CHOMP=22, PUSH=23, PUTS=24, METHOD=25, 
		LEN=26, PATTERN=27, MATCH=28, NEXT=29, BREAK=30, LOOP=31, DO=32, FOR=33, 
		IN=34, PLUS=35, MINUS=36, MULTIPLY=37, DIVIDE=38, REMAINDER=39, DOUNLE_MINUS=40, 
		DOUNLE_PLUS=41, ASSIGN=42, GREATER_THAN=43, LESS_THAN=44, LESS_EQUAL=45, 
		GREATER_EQUAL=46, AND=47, OR=48, NOT=49, DOUBLE_DOT=50, SINGLE_DOT=51, 
		APPEND=52, PLUS_EQUAL=53, MINUS_EQUAL=54, MULTIPLY_EQUAL=55, DIVIDE_EQUAL=56, 
		REMAINDER_EQUAL=57, EQUAL=58, NOT_EQUAL=59, IDENTIFIER=60, FLOAT=61, INTEGER=62, 
		STRING=63, PATTERN_CONDITION=64, MULTILINE_COMMENT=65, SINGLELINE_COMMENT=66, 
		WS=67;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_function = 2, RULE_function_prototype = 3, 
		RULE_block = 4, RULE_return_statement = 5, RULE_pattern_matching = 6, 
		RULE_pattern_body = 7, RULE_pattern_call = 8, RULE_statement = 9, RULE_if_statement = 10, 
		RULE_elseif_statement = 11, RULE_else_statement = 12, RULE_loop_statement = 13, 
		RULE_for_statement = 14, RULE_loop_body = 15, RULE_assignment = 16, RULE_literal = 17, 
		RULE_jump_statement = 18, RULE_break = 19, RULE_next = 20, RULE_break_if = 21, 
		RULE_next_if = 22, RULE_lambda_function = 23, RULE_function_call = 24, 
		RULE_function_pointer = 25, RULE_primitive_function_call = 26, RULE_condition = 27, 
		RULE_expr = 28, RULE_append_expr = 29, RULE_or_expr = 30, RULE_and_expr = 31, 
		RULE_eq_expr = 32, RULE_comp_expr = 33, RULE_plus_minus_expr = 34, RULE_divide_mult_expr = 35, 
		RULE_unary_prefix_operator_expr = 36, RULE_unary_postfix_operator_expr = 37, 
		RULE_other_expr = 38, RULE_list_indexing = 39, RULE_puts = 40, RULE_push = 41, 
		RULE_len = 42, RULE_chop = 43, RULE_chomp = 44, RULE_parameters = 45, 
		RULE_default_parameters = 46, RULE_default_parameter = 47, RULE_arguments = 48, 
		RULE_range = 49, RULE_list = 50, RULE_value_list = 51, RULE_value = 52, 
		RULE_value_literal = 53, RULE_boolean = 54;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "function", "function_prototype", "block", "return_statement", 
			"pattern_matching", "pattern_body", "pattern_call", "statement", "if_statement", 
			"elseif_statement", "else_statement", "loop_statement", "for_statement", 
			"loop_body", "assignment", "literal", "jump_statement", "break", "next", 
			"break_if", "next_if", "lambda_function", "function_call", "function_pointer", 
			"primitive_function_call", "condition", "expr", "append_expr", "or_expr", 
			"and_expr", "eq_expr", "comp_expr", "plus_minus_expr", "divide_mult_expr", 
			"unary_prefix_operator_expr", "unary_postfix_operator_expr", "other_expr", 
			"list_indexing", "puts", "push", "len", "chop", "chomp", "parameters", 
			"default_parameters", "default_parameter", "arguments", "range", "list", 
			"value_list", "value", "value_literal", "boolean"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'\"'", "'->'", "':'", 
			"';'", "','", "'def'", "'end'", "'main'", "'return'", "'if'", "'else'", 
			"'elseif'", "'true'", "'false'", "'chop'", "'chomp'", "'push'", "'puts'", 
			"'method'", "'len'", "'pattern'", "'match'", "'next'", "'break'", "'loop'", 
			"'do'", "'for'", "'in'", "'+'", "'-'", "'*'", "'/'", "'%'", "'--'", "'++'", 
			"'='", "'>'", "'<'", "'<='", "'>='", "'&&'", "'||'", "'!'", "'..'", "'.'", 
			"'<<'", "'+='", "'-='", "'*='", "'/='", "'%='", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAR", "RPAR", "LSB", "RSB", "LCB", "RCB", "DQUATE", "RARROW", 
			"COLON", "SEMICOLON", "COMMA", "DEF", "END", "MAIN", "RETURN", "IF", 
			"ELSE", "ELSEIF", "TRUE", "FALSE", "CHOP", "CHOMP", "PUSH", "PUTS", "METHOD", 
			"LEN", "PATTERN", "MATCH", "NEXT", "BREAK", "LOOP", "DO", "FOR", "IN", 
			"PLUS", "MINUS", "MULTIPLY", "DIVIDE", "REMAINDER", "DOUNLE_MINUS", "DOUNLE_PLUS", 
			"ASSIGN", "GREATER_THAN", "LESS_THAN", "LESS_EQUAL", "GREATER_EQUAL", 
			"AND", "OR", "NOT", "DOUBLE_DOT", "SINGLE_DOT", "APPEND", "PLUS_EQUAL", 
			"MINUS_EQUAL", "MULTIPLY_EQUAL", "DIVIDE_EQUAL", "REMAINDER_EQUAL", "EQUAL", 
			"NOT_EQUAL", "IDENTIFIER", "FLOAT", "INTEGER", "STRING", "PATTERN_CONDITION", 
			"MULTILINE_COMMENT", "SINGLELINE_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FunctionCraft.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FunctionCraftParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<Pattern_matchingContext> pattern_matching() {
			return getRuleContexts(Pattern_matchingContext.class);
		}
		public Pattern_matchingContext pattern_matching(int i) {
			return getRuleContext(Pattern_matchingContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(112);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case DEF:
						{
						setState(110);
						function();
						}
						break;
					case PATTERN:
						{
						setState(111);
						pattern_matching();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(117);
			main();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(FunctionCraftParser.DEF, 0); }
		public TerminalNode MAIN() { return getToken(FunctionCraftParser.MAIN, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(FunctionCraftParser.END, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(DEF);
			setState(120);
			match(MAIN);
			 System.out.println("MAIN"); 
			setState(122);
			match(LPAR);
			setState(123);
			match(RPAR);
			setState(124);
			block();
			setState(125);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public Function_prototypeContext function_prototype() {
			return getRuleContext(Function_prototypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(FunctionCraftParser.END, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			function_prototype();
			setState(128);
			block();
			setState(129);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_prototypeContext extends ParserRuleContext {
		public Token name;
		public TerminalNode DEF() { return getToken(FunctionCraftParser.DEF, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public Function_prototypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_prototype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterFunction_prototype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitFunction_prototype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitFunction_prototype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_prototypeContext function_prototype() throws RecognitionException {
		Function_prototypeContext _localctx = new Function_prototypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function_prototype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(DEF);
			{
			setState(132);
			((Function_prototypeContext)_localctx).name = match(IDENTIFIER);
			}
			 System.out.println("FuncDec: " + (((Function_prototypeContext)_localctx).name!=null?((Function_prototypeContext)_localctx).name.getText():null)); 
			setState(134);
			match(LPAR);
			setState(135);
			parameters();
			setState(136);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1152358475062771446L) != 0)) {
				{
				{
				setState(138);
				statement();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(144);
				return_statement();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_statementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(FunctionCraftParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(FunctionCraftParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterReturn_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitReturn_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitReturn_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(RETURN);
			 System.out.println("RETURN"); 
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1152358485800255222L) != 0)) {
				{
				setState(149);
				expr("");
				}
			}

			setState(152);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pattern_matchingContext extends ParserRuleContext {
		public Token name;
		public TerminalNode PATTERN() { return getToken(FunctionCraftParser.PATTERN, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public Pattern_bodyContext pattern_body() {
			return getRuleContext(Pattern_bodyContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(FunctionCraftParser.SEMICOLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public Pattern_matchingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_matching; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPattern_matching(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPattern_matching(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPattern_matching(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pattern_matchingContext pattern_matching() throws RecognitionException {
		Pattern_matchingContext _localctx = new Pattern_matchingContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_pattern_matching);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(PATTERN);
			{
			setState(155);
			((Pattern_matchingContext)_localctx).name = match(IDENTIFIER);
			}
			 System.out.println("PatternDec: " + (((Pattern_matchingContext)_localctx).name!=null?((Pattern_matchingContext)_localctx).name.getText():null)); 
			setState(157);
			match(LPAR);
			setState(158);
			parameters();
			setState(159);
			match(RPAR);
			setState(160);
			pattern_body();
			setState(161);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pattern_bodyContext extends ParserRuleContext {
		public List<TerminalNode> PATTERN_CONDITION() { return getTokens(FunctionCraftParser.PATTERN_CONDITION); }
		public TerminalNode PATTERN_CONDITION(int i) {
			return getToken(FunctionCraftParser.PATTERN_CONDITION, i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(FunctionCraftParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(FunctionCraftParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Pattern_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPattern_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPattern_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPattern_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pattern_bodyContext pattern_body() throws RecognitionException {
		Pattern_bodyContext _localctx = new Pattern_bodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pattern_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(163);
				match(PATTERN_CONDITION);
				setState(164);
				condition();
				setState(165);
				match(ASSIGN);
				setState(166);
				expr("");
				}
				}
				setState(170); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PATTERN_CONDITION );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pattern_callContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public TerminalNode SINGLE_DOT() { return getToken(FunctionCraftParser.SINGLE_DOT, 0); }
		public TerminalNode MATCH() { return getToken(FunctionCraftParser.MATCH, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public Pattern_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPattern_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPattern_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPattern_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pattern_callContext pattern_call() throws RecognitionException {
		Pattern_callContext _localctx = new Pattern_callContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pattern_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(IDENTIFIER);
			setState(173);
			match(SINGLE_DOT);
			setState(174);
			match(MATCH);
			 System.out.println("Built-In: MATCH"); 
			setState(176);
			match(LPAR);
			setState(177);
			arguments();
			setState(178);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Loop_statementContext loop_statement() {
			return getRuleContext(Loop_statementContext.class,0);
		}
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(FunctionCraftParser.SEMICOLON, 0); }
		public Pattern_callContext pattern_call() {
			return getRuleContext(Pattern_callContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<Function_callContext> function_call() {
			return getRuleContexts(Function_callContext.class);
		}
		public Function_callContext function_call(int i) {
			return getRuleContext(Function_callContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		int _la;
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				if_statement();
				}
				break;
			case LOOP:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				loop_statement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				for_statement();
				}
				break;
			case LPAR:
			case LSB:
			case RARROW:
			case TRUE:
			case FALSE:
			case CHOP:
			case CHOMP:
			case PUSH:
			case PUTS:
			case METHOD:
			case LEN:
			case MINUS:
			case NOT:
			case IDENTIFIER:
			case FLOAT:
			case INTEGER:
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(191);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(183);
					pattern_call();
					}
					break;
				case 2:
					{
					setState(184);
					assignment();
					}
					break;
				case 3:
					{
					setState(185);
					expr("");
					setState(187); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(186);
						function_call();
						}
						}
						setState(189); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==LPAR );
					}
					break;
				}
				setState(193);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(FunctionCraftParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(FunctionCraftParser.END, 0); }
		public List<Elseif_statementContext> elseif_statement() {
			return getRuleContexts(Elseif_statementContext.class);
		}
		public Elseif_statementContext elseif_statement(int i) {
			return getRuleContext(Elseif_statementContext.class,i);
		}
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(IF);
			 System.out.println("Decision: IF"); 
			setState(199);
			condition();
			setState(200);
			block();
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(201);
				elseif_statement();
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(207);
				else_statement();
				}
			}

			setState(210);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Elseif_statementContext extends ParserRuleContext {
		public TerminalNode ELSEIF() { return getToken(FunctionCraftParser.ELSEIF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Elseif_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseif_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterElseif_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitElseif_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitElseif_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Elseif_statementContext elseif_statement() throws RecognitionException {
		Elseif_statementContext _localctx = new Elseif_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_elseif_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(ELSEIF);
			 System.out.println("Decision: ELSE IF"); 
			setState(214);
			condition();
			setState(215);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Else_statementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(FunctionCraftParser.ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitElse_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitElse_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(ELSE);
			 System.out.println("Decision: ELSE"); 
			setState(219);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Loop_statementContext extends ParserRuleContext {
		public TerminalNode LOOP() { return getToken(FunctionCraftParser.LOOP, 0); }
		public TerminalNode DO() { return getToken(FunctionCraftParser.DO, 0); }
		public Loop_bodyContext loop_body() {
			return getRuleContext(Loop_bodyContext.class,0);
		}
		public TerminalNode END() { return getToken(FunctionCraftParser.END, 0); }
		public Loop_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterLoop_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitLoop_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitLoop_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_statementContext loop_statement() throws RecognitionException {
		Loop_statementContext _localctx = new Loop_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_loop_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(LOOP);
			setState(222);
			match(DO);
			 System.out.println("Loop: DO"); 
			setState(224);
			loop_body();
			setState(225);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_statementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(FunctionCraftParser.FOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public TerminalNode IN() { return getToken(FunctionCraftParser.IN, 0); }
		public Loop_bodyContext loop_body() {
			return getRuleContext(Loop_bodyContext.class,0);
		}
		public TerminalNode END() { return getToken(FunctionCraftParser.END, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterFor_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitFor_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitFor_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_for_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(FOR);
			 System.out.println("Loop: FOR"); 
			setState(229);
			match(IDENTIFIER);
			setState(230);
			match(IN);
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LSB:
				{
				setState(231);
				list();
				}
				break;
			case LPAR:
				{
				setState(232);
				range();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(235);
			loop_body();
			setState(236);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Loop_bodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<Jump_statementContext> jump_statement() {
			return getRuleContexts(Jump_statementContext.class);
		}
		public Jump_statementContext jump_statement(int i) {
			return getRuleContext(Jump_statementContext.class,i);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public Loop_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterLoop_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitLoop_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitLoop_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_bodyContext loop_body() throws RecognitionException {
		Loop_bodyContext _localctx = new Loop_bodyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_loop_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1152358473452158710L) != 0)) {
				{
				setState(240);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LPAR:
				case LSB:
				case RARROW:
				case IF:
				case TRUE:
				case FALSE:
				case CHOP:
				case CHOMP:
				case PUSH:
				case PUTS:
				case METHOD:
				case LEN:
				case LOOP:
				case FOR:
				case MINUS:
				case NOT:
				case IDENTIFIER:
				case FLOAT:
				case INTEGER:
				case STRING:
					{
					setState(238);
					statement();
					}
					break;
				case NEXT:
				case BREAK:
					{
					setState(239);
					jump_statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(245);
				return_statement();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public Token name;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(FunctionCraftParser.ASSIGN, 0); }
		public TerminalNode MINUS_EQUAL() { return getToken(FunctionCraftParser.MINUS_EQUAL, 0); }
		public TerminalNode MULTIPLY_EQUAL() { return getToken(FunctionCraftParser.MULTIPLY_EQUAL, 0); }
		public TerminalNode DIVIDE_EQUAL() { return getToken(FunctionCraftParser.DIVIDE_EQUAL, 0); }
		public TerminalNode REMAINDER_EQUAL() { return getToken(FunctionCraftParser.REMAINDER_EQUAL, 0); }
		public TerminalNode PLUS_EQUAL() { return getToken(FunctionCraftParser.PLUS_EQUAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(248);
			((AssignmentContext)_localctx).name = match(IDENTIFIER);
			}
			setState(249);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 279227574943481856L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(250);
			expr("");
			 System.out.println("Assignment: " + (((AssignmentContext)_localctx).name!=null?((AssignmentContext)_localctx).name.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(FunctionCraftParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(FunctionCraftParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(FunctionCraftParser.STRING, 0); }
		public BooleanContext boolean_() {
			return getRuleContext(BooleanContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_literal);
		try {
			setState(258);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				match(INTEGER);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(FLOAT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
				match(STRING);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(256);
				boolean_();
				}
				break;
			case LSB:
				enterOuterAlt(_localctx, 5);
				{
				setState(257);
				list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Jump_statementContext extends ParserRuleContext {
		public BreakContext break_() {
			return getRuleContext(BreakContext.class,0);
		}
		public Break_ifContext break_if() {
			return getRuleContext(Break_ifContext.class,0);
		}
		public NextContext next() {
			return getRuleContext(NextContext.class,0);
		}
		public Next_ifContext next_if() {
			return getRuleContext(Next_ifContext.class,0);
		}
		public Jump_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jump_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterJump_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitJump_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitJump_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jump_statementContext jump_statement() throws RecognitionException {
		Jump_statementContext _localctx = new Jump_statementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_jump_statement);
		try {
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				break_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				break_if();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(262);
				next();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(263);
				next_if();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(FunctionCraftParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(FunctionCraftParser.SEMICOLON, 0); }
		public BreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakContext break_() throws RecognitionException {
		BreakContext _localctx = new BreakContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_break);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(BREAK);
			 System.out.println("Control: BREAK"); 
			setState(268);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NextContext extends ParserRuleContext {
		public TerminalNode NEXT() { return getToken(FunctionCraftParser.NEXT, 0); }
		public TerminalNode SEMICOLON() { return getToken(FunctionCraftParser.SEMICOLON, 0); }
		public NextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_next; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterNext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitNext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitNext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NextContext next() throws RecognitionException {
		NextContext _localctx = new NextContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_next);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(NEXT);
			 System.out.println("Control: NEXT"); 
			setState(272);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Break_ifContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(FunctionCraftParser.BREAK, 0); }
		public TerminalNode IF() { return getToken(FunctionCraftParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(FunctionCraftParser.SEMICOLON, 0); }
		public Break_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterBreak_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitBreak_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitBreak_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Break_ifContext break_if() throws RecognitionException {
		Break_ifContext _localctx = new Break_ifContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_break_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(BREAK);
			setState(275);
			match(IF);
			 System.out.println("Control: BREAK"); 
			setState(277);
			condition();
			setState(278);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Next_ifContext extends ParserRuleContext {
		public TerminalNode NEXT() { return getToken(FunctionCraftParser.NEXT, 0); }
		public TerminalNode IF() { return getToken(FunctionCraftParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(FunctionCraftParser.SEMICOLON, 0); }
		public Next_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_next_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterNext_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitNext_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitNext_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Next_ifContext next_if() throws RecognitionException {
		Next_ifContext _localctx = new Next_ifContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_next_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(NEXT);
			setState(281);
			match(IF);
			 System.out.println("Control: NEXT"); 
			setState(283);
			condition();
			setState(284);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lambda_functionContext extends ParserRuleContext {
		public TerminalNode RARROW() { return getToken(FunctionCraftParser.RARROW, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public TerminalNode LCB() { return getToken(FunctionCraftParser.LCB, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RCB() { return getToken(FunctionCraftParser.RCB, 0); }
		public Lambda_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterLambda_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitLambda_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitLambda_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_functionContext lambda_function() throws RecognitionException {
		Lambda_functionContext _localctx = new Lambda_functionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_lambda_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(RARROW);
			 System.out.println("Structure: LAMBDA"); 
			setState(288);
			match(LPAR);
			setState(289);
			parameters();
			setState(290);
			match(RPAR);
			setState(291);
			match(LCB);
			setState(292);
			block();
			setState(293);
			match(RCB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_function_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 System.out.println("FunctionCall"); 
			setState(296);
			match(LPAR);
			setState(297);
			arguments();
			setState(298);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_pointerContext extends ParserRuleContext {
		public TerminalNode METHOD() { return getToken(FunctionCraftParser.METHOD, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public TerminalNode COLON() { return getToken(FunctionCraftParser.COLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public Lambda_functionContext lambda_function() {
			return getRuleContext(Lambda_functionContext.class,0);
		}
		public Function_pointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_pointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterFunction_pointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitFunction_pointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitFunction_pointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_pointerContext function_pointer() throws RecognitionException {
		Function_pointerContext _localctx = new Function_pointerContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_function_pointer);
		try {
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case METHOD:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				match(METHOD);
				setState(301);
				match(LPAR);
				setState(302);
				match(COLON);
				setState(303);
				match(IDENTIFIER);
				setState(304);
				match(RPAR);
				}
				break;
			case RARROW:
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				lambda_function();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Primitive_function_callContext extends ParserRuleContext {
		public PutsContext puts() {
			return getRuleContext(PutsContext.class,0);
		}
		public PushContext push() {
			return getRuleContext(PushContext.class,0);
		}
		public LenContext len() {
			return getRuleContext(LenContext.class,0);
		}
		public ChopContext chop() {
			return getRuleContext(ChopContext.class,0);
		}
		public ChompContext chomp() {
			return getRuleContext(ChompContext.class,0);
		}
		public Primitive_function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPrimitive_function_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPrimitive_function_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPrimitive_function_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primitive_function_callContext primitive_function_call() throws RecognitionException {
		Primitive_function_callContext _localctx = new Primitive_function_callContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_primitive_function_call);
		try {
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PUTS:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				puts();
				}
				break;
			case PUSH:
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
				push();
				}
				break;
			case LEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(310);
				len();
				}
				break;
			case CHOP:
				enterOuterAlt(_localctx, 4);
				{
				setState(311);
				chop();
				}
				break;
			case CHOMP:
				enterOuterAlt(_localctx, 5);
				{
				setState(312);
				chomp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public List<TerminalNode> LPAR() { return getTokens(FunctionCraftParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(FunctionCraftParser.LPAR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RPAR() { return getTokens(FunctionCraftParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(FunctionCraftParser.RPAR, i);
		}
		public List<TerminalNode> AND() { return getTokens(FunctionCraftParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(FunctionCraftParser.AND, i);
		}
		public List<TerminalNode> NOT() { return getTokens(FunctionCraftParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(FunctionCraftParser.NOT, i);
		}
		public List<TerminalNode> OR() { return getTokens(FunctionCraftParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(FunctionCraftParser.OR, i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_condition);
		int _la;
		try {
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(315);
					match(NOT);
					}
				}

				setState(318);
				match(LPAR);
				setState(319);
				expr("");
				setState(320);
				match(RPAR);
				}
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND) {
					{
					{
					setState(322);
					match(AND);
					{
					setState(324);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NOT) {
						{
						setState(323);
						match(NOT);
						}
					}

					setState(326);
					match(LPAR);
					setState(327);
					expr("");
					setState(328);
					match(RPAR);
					}
					}
					}
					setState(334);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(335);
					match(NOT);
					}
				}

				setState(338);
				match(LPAR);
				setState(339);
				expr("");
				setState(340);
				match(RPAR);
				}
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OR) {
					{
					{
					setState(342);
					match(OR);
					{
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NOT) {
						{
						setState(343);
						match(NOT);
						}
					}

					setState(346);
					match(LPAR);
					setState(347);
					expr("");
					setState(348);
					match(RPAR);
					}
					}
					}
					setState(354);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public String prev;
		public Append_exprContext append_expr() {
			return getRuleContext(Append_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, String prev) {
			super(parent, invokingState);
			this.prev = prev;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(String prev) throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState(), prev);
		enterRule(_localctx, 56, RULE_expr);
		((ExprContext)_localctx).prev =  "";
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			append_expr(_localctx.prev);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Append_exprContext extends ParserRuleContext {
		public String prev;
		public Or_exprContext or_expr() {
			return getRuleContext(Or_exprContext.class,0);
		}
		public TerminalNode APPEND() { return getToken(FunctionCraftParser.APPEND, 0); }
		public Append_exprContext append_expr() {
			return getRuleContext(Append_exprContext.class,0);
		}
		public Append_exprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Append_exprContext(ParserRuleContext parent, int invokingState, String prev) {
			super(parent, invokingState);
			this.prev = prev;
		}
		@Override public int getRuleIndex() { return RULE_append_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterAppend_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitAppend_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitAppend_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Append_exprContext append_expr(String prev) throws RecognitionException {
		Append_exprContext _localctx = new Append_exprContext(_ctx, getState(), prev);
		enterRule(_localctx, 58, RULE_append_expr);
		try {
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(359);
				or_expr();
				 System.out.print(_localctx.prev); 
				setState(361);
				match(APPEND);
				setState(362);
				append_expr("Operator: <<\n");
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				or_expr();
				 System.out.print(_localctx.prev); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Or_exprContext extends ParserRuleContext {
		public List<TerminalNode> LPAR() { return getTokens(FunctionCraftParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(FunctionCraftParser.LPAR, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(FunctionCraftParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(FunctionCraftParser.RPAR, i);
		}
		public TerminalNode OR() { return getToken(FunctionCraftParser.OR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public And_exprContext and_expr() {
			return getRuleContext(And_exprContext.class,0);
		}
		public Or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterOr_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitOr_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitOr_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Or_exprContext or_expr() throws RecognitionException {
		Or_exprContext _localctx = new Or_exprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_or_expr);
		try {
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				match(LPAR);
				{
				setState(370);
				expr("");
				}
				setState(371);
				match(RPAR);
				setState(372);
				match(OR);
				setState(373);
				match(LPAR);
				{
				setState(374);
				expr("");
				}
				setState(375);
				match(RPAR);
				 System.out.println("Operator: ||"); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(378);
				and_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class And_exprContext extends ParserRuleContext {
		public List<TerminalNode> LPAR() { return getTokens(FunctionCraftParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(FunctionCraftParser.LPAR, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(FunctionCraftParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(FunctionCraftParser.RPAR, i);
		}
		public TerminalNode AND() { return getToken(FunctionCraftParser.AND, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Eq_exprContext eq_expr() {
			return getRuleContext(Eq_exprContext.class,0);
		}
		public And_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterAnd_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitAnd_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitAnd_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_exprContext and_expr() throws RecognitionException {
		And_exprContext _localctx = new And_exprContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_and_expr);
		try {
			setState(391);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(381);
				match(LPAR);
				{
				setState(382);
				expr("");
				}
				setState(383);
				match(RPAR);
				setState(384);
				match(AND);
				setState(385);
				match(LPAR);
				{
				setState(386);
				expr("");
				}
				setState(387);
				match(RPAR);
				 System.out.println("Operator: &&"); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(390);
				eq_expr("");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Eq_exprContext extends ParserRuleContext {
		public String prev;
		public Comp_exprContext comp_expr() {
			return getRuleContext(Comp_exprContext.class,0);
		}
		public TerminalNode NOT_EQUAL() { return getToken(FunctionCraftParser.NOT_EQUAL, 0); }
		public Eq_exprContext eq_expr() {
			return getRuleContext(Eq_exprContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(FunctionCraftParser.EQUAL, 0); }
		public Eq_exprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Eq_exprContext(ParserRuleContext parent, int invokingState, String prev) {
			super(parent, invokingState);
			this.prev = prev;
		}
		@Override public int getRuleIndex() { return RULE_eq_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterEq_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitEq_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitEq_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Eq_exprContext eq_expr(String prev) throws RecognitionException {
		Eq_exprContext _localctx = new Eq_exprContext(_ctx, getState(), prev);
		enterRule(_localctx, 64, RULE_eq_expr);
		try {
			setState(406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(393);
				comp_expr("");
				 System.out.print(_localctx.prev); 
				setState(395);
				match(NOT_EQUAL);
				setState(396);
				eq_expr("Operator: !=\n");
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				comp_expr("");
				 System.out.print(_localctx.prev); 
				setState(400);
				match(EQUAL);
				setState(401);
				eq_expr("Operator: ==\n");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(403);
				comp_expr("");
				 System.out.print(_localctx.prev); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Comp_exprContext extends ParserRuleContext {
		public String prev;
		public Plus_minus_exprContext plus_minus_expr() {
			return getRuleContext(Plus_minus_exprContext.class,0);
		}
		public TerminalNode GREATER_THAN() { return getToken(FunctionCraftParser.GREATER_THAN, 0); }
		public Comp_exprContext comp_expr() {
			return getRuleContext(Comp_exprContext.class,0);
		}
		public TerminalNode LESS_THAN() { return getToken(FunctionCraftParser.LESS_THAN, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(FunctionCraftParser.LESS_EQUAL, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(FunctionCraftParser.GREATER_EQUAL, 0); }
		public Comp_exprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Comp_exprContext(ParserRuleContext parent, int invokingState, String prev) {
			super(parent, invokingState);
			this.prev = prev;
		}
		@Override public int getRuleIndex() { return RULE_comp_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterComp_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitComp_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitComp_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_exprContext comp_expr(String prev) throws RecognitionException {
		Comp_exprContext _localctx = new Comp_exprContext(_ctx, getState(), prev);
		enterRule(_localctx, 66, RULE_comp_expr);
		try {
			setState(431);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				plus_minus_expr("");
				 System.out.print(_localctx.prev); 
				setState(410);
				match(GREATER_THAN);
				setState(411);
				comp_expr("Operator: >\n");
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(413);
				plus_minus_expr("");
				 System.out.print(_localctx.prev); 
				setState(415);
				match(LESS_THAN);
				setState(416);
				comp_expr("Operator: <\n");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(418);
				plus_minus_expr("");
				 System.out.print(_localctx.prev); 
				setState(420);
				match(LESS_EQUAL);
				setState(421);
				comp_expr("Operator: <=\n");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(423);
				plus_minus_expr("");
				 System.out.print(_localctx.prev); 
				setState(425);
				match(GREATER_EQUAL);
				setState(426);
				comp_expr("Operator: >=\n");
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(428);
				plus_minus_expr("");
				 System.out.print(_localctx.prev); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Plus_minus_exprContext extends ParserRuleContext {
		public String prev;
		public Divide_mult_exprContext divide_mult_expr() {
			return getRuleContext(Divide_mult_exprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(FunctionCraftParser.PLUS, 0); }
		public Plus_minus_exprContext plus_minus_expr() {
			return getRuleContext(Plus_minus_exprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(FunctionCraftParser.MINUS, 0); }
		public Plus_minus_exprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Plus_minus_exprContext(ParserRuleContext parent, int invokingState, String prev) {
			super(parent, invokingState);
			this.prev = prev;
		}
		@Override public int getRuleIndex() { return RULE_plus_minus_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPlus_minus_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPlus_minus_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPlus_minus_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Plus_minus_exprContext plus_minus_expr(String prev) throws RecognitionException {
		Plus_minus_exprContext _localctx = new Plus_minus_exprContext(_ctx, getState(), prev);
		enterRule(_localctx, 68, RULE_plus_minus_expr);
		try {
			setState(446);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(433);
				divide_mult_expr("");
				 System.out.print(_localctx.prev); 
				setState(435);
				match(PLUS);
				setState(436);
				plus_minus_expr("Operator: +\n");
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
				divide_mult_expr("");
				 System.out.print(_localctx.prev); 
				setState(440);
				match(MINUS);
				setState(441);
				plus_minus_expr("Operator: -\n");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(443);
				divide_mult_expr("");
				 System.out.print(_localctx.prev); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Divide_mult_exprContext extends ParserRuleContext {
		public String prev;
		public Unary_prefix_operator_exprContext unary_prefix_operator_expr() {
			return getRuleContext(Unary_prefix_operator_exprContext.class,0);
		}
		public TerminalNode DIVIDE() { return getToken(FunctionCraftParser.DIVIDE, 0); }
		public Divide_mult_exprContext divide_mult_expr() {
			return getRuleContext(Divide_mult_exprContext.class,0);
		}
		public TerminalNode MULTIPLY() { return getToken(FunctionCraftParser.MULTIPLY, 0); }
		public TerminalNode REMAINDER() { return getToken(FunctionCraftParser.REMAINDER, 0); }
		public Divide_mult_exprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Divide_mult_exprContext(ParserRuleContext parent, int invokingState, String prev) {
			super(parent, invokingState);
			this.prev = prev;
		}
		@Override public int getRuleIndex() { return RULE_divide_mult_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterDivide_mult_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitDivide_mult_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitDivide_mult_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Divide_mult_exprContext divide_mult_expr(String prev) throws RecognitionException {
		Divide_mult_exprContext _localctx = new Divide_mult_exprContext(_ctx, getState(), prev);
		enterRule(_localctx, 70, RULE_divide_mult_expr);
		try {
			setState(466);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(448);
				unary_prefix_operator_expr();
				 System.out.print(_localctx.prev); 
				setState(450);
				match(DIVIDE);
				setState(451);
				divide_mult_expr("Operator: /\n");
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(453);
				unary_prefix_operator_expr();
				 System.out.print(_localctx.prev); 
				setState(455);
				match(MULTIPLY);
				setState(456);
				divide_mult_expr("Operator: *\n");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(458);
				unary_prefix_operator_expr();
				 System.out.print(_localctx.prev); 
				setState(460);
				match(REMAINDER);
				setState(461);
				divide_mult_expr("Operator: %\n");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(463);
				unary_prefix_operator_expr();
				 System.out.print(_localctx.prev); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_prefix_operator_exprContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(FunctionCraftParser.NOT, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public Unary_postfix_operator_exprContext unary_postfix_operator_expr() {
			return getRuleContext(Unary_postfix_operator_exprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public TerminalNode MINUS() { return getToken(FunctionCraftParser.MINUS, 0); }
		public Unary_prefix_operator_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_prefix_operator_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterUnary_prefix_operator_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitUnary_prefix_operator_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitUnary_prefix_operator_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_prefix_operator_exprContext unary_prefix_operator_expr() throws RecognitionException {
		Unary_prefix_operator_exprContext _localctx = new Unary_prefix_operator_exprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_unary_prefix_operator_expr);
		try {
			setState(479);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(468);
				match(NOT);
				setState(469);
				match(LPAR);
				setState(470);
				unary_postfix_operator_expr();
				setState(471);
				match(RPAR);
				 System.out.println("Operator: !"); 
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(474);
				match(MINUS);
				setState(475);
				unary_postfix_operator_expr();
				 System.out.println("Operator: -"); 
				}
				break;
			case LPAR:
			case LSB:
			case RARROW:
			case TRUE:
			case FALSE:
			case CHOP:
			case CHOMP:
			case PUSH:
			case PUTS:
			case METHOD:
			case LEN:
			case IDENTIFIER:
			case FLOAT:
			case INTEGER:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(478);
				unary_postfix_operator_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_postfix_operator_exprContext extends ParserRuleContext {
		public Other_exprContext other_expr() {
			return getRuleContext(Other_exprContext.class,0);
		}
		public TerminalNode DOUNLE_PLUS() { return getToken(FunctionCraftParser.DOUNLE_PLUS, 0); }
		public TerminalNode DOUNLE_MINUS() { return getToken(FunctionCraftParser.DOUNLE_MINUS, 0); }
		public Unary_postfix_operator_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_postfix_operator_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterUnary_postfix_operator_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitUnary_postfix_operator_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitUnary_postfix_operator_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_postfix_operator_exprContext unary_postfix_operator_expr() throws RecognitionException {
		Unary_postfix_operator_exprContext _localctx = new Unary_postfix_operator_exprContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_unary_postfix_operator_expr);
		try {
			setState(490);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(481);
				other_expr();
				setState(482);
				match(DOUNLE_PLUS);
				 System.out.println("Operator: ++"); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(485);
				other_expr();
				setState(486);
				match(DOUNLE_MINUS);
				 System.out.println("Operator: --"); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(489);
				other_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Other_exprContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public List<Function_callContext> function_call() {
			return getRuleContexts(Function_callContext.class);
		}
		public Function_callContext function_call(int i) {
			return getRuleContext(Function_callContext.class,i);
		}
		public Function_pointerContext function_pointer() {
			return getRuleContext(Function_pointerContext.class,0);
		}
		public Primitive_function_callContext primitive_function_call() {
			return getRuleContext(Primitive_function_callContext.class,0);
		}
		public Pattern_callContext pattern_call() {
			return getRuleContext(Pattern_callContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public List<List_indexingContext> list_indexing() {
			return getRuleContexts(List_indexingContext.class);
		}
		public List_indexingContext list_indexing(int i) {
			return getRuleContext(List_indexingContext.class,i);
		}
		public Other_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_other_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterOther_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitOther_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitOther_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Other_exprContext other_expr() throws RecognitionException {
		Other_exprContext _localctx = new Other_exprContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_other_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(492);
				match(LPAR);
				setState(493);
				expr("");
				setState(494);
				match(RPAR);
				}
				break;
			case 2:
				{
				setState(496);
				function_call();
				}
				break;
			case 3:
				{
				setState(497);
				function_pointer();
				}
				break;
			case 4:
				{
				setState(498);
				primitive_function_call();
				}
				break;
			case 5:
				{
				setState(499);
				pattern_call();
				}
				break;
			case 6:
				{
				setState(500);
				match(IDENTIFIER);
				}
				break;
			case 7:
				{
				setState(501);
				literal();
				}
				break;
			}
			setState(508);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(506);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LSB:
						{
						setState(504);
						list_indexing();
						}
						break;
					case LPAR:
						{
						setState(505);
						function_call();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(510);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_indexingContext extends ParserRuleContext {
		public TerminalNode LSB() { return getToken(FunctionCraftParser.LSB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSB() { return getToken(FunctionCraftParser.RSB, 0); }
		public List_indexingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_indexing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterList_indexing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitList_indexing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitList_indexing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_indexingContext list_indexing() throws RecognitionException {
		List_indexingContext _localctx = new List_indexingContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_list_indexing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			match(LSB);
			setState(512);
			expr("");
			setState(513);
			match(RSB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PutsContext extends ParserRuleContext {
		public TerminalNode PUTS() { return getToken(FunctionCraftParser.PUTS, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public PutsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_puts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPuts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPuts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPuts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PutsContext puts() throws RecognitionException {
		PutsContext _localctx = new PutsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_puts);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			match(PUTS);
			 System.out.println("Built-In: PUTS"); 
			setState(517);
			match(LPAR);
			setState(518);
			expr("");
			setState(519);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PushContext extends ParserRuleContext {
		public TerminalNode PUSH() { return getToken(FunctionCraftParser.PUSH, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(FunctionCraftParser.COMMA, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public PushContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_push; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterPush(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitPush(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitPush(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PushContext push() throws RecognitionException {
		PushContext _localctx = new PushContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_push);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			match(PUSH);
			 System.out.println("Built-In: PUSH"); 
			setState(523);
			match(LPAR);
			setState(524);
			expr("");
			setState(525);
			match(COMMA);
			setState(526);
			expr("");
			setState(527);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LenContext extends ParserRuleContext {
		public TerminalNode LEN() { return getToken(FunctionCraftParser.LEN, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public LenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_len; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterLen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitLen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitLen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LenContext len() throws RecognitionException {
		LenContext _localctx = new LenContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_len);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			match(LEN);
			 System.out.println("Built-In: LEN"); 
			setState(531);
			match(LPAR);
			setState(532);
			expr("");
			setState(533);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChopContext extends ParserRuleContext {
		public TerminalNode CHOP() { return getToken(FunctionCraftParser.CHOP, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public ChopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterChop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitChop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitChop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChopContext chop() throws RecognitionException {
		ChopContext _localctx = new ChopContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_chop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			match(CHOP);
			 System.out.println("Built-In: CHOP"); 
			setState(537);
			match(LPAR);
			setState(538);
			expr("");
			setState(539);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChompContext extends ParserRuleContext {
		public TerminalNode CHOMP() { return getToken(FunctionCraftParser.CHOMP, 0); }
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public ChompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterChomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitChomp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitChomp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChompContext chomp() throws RecognitionException {
		ChompContext _localctx = new ChompContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_chomp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			match(CHOMP);
			 System.out.println("Built-In: CHOMP"); 
			setState(543);
			match(LPAR);
			setState(544);
			expr("");
			setState(545);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(FunctionCraftParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FunctionCraftParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunctionCraftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionCraftParser.COMMA, i);
		}
		public Default_parametersContext default_parameters() {
			return getRuleContext(Default_parametersContext.class,0);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_parameters);
		int _la;
		try {
			int _alt;
			setState(562);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(547);
				match(IDENTIFIER);
				setState(552);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(548);
						match(COMMA);
						setState(549);
						match(IDENTIFIER);
						}
						} 
					}
					setState(554);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				}
				setState(557);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(555);
					match(COMMA);
					setState(556);
					default_parameters();
					}
				}

				}
				break;
			case RPAR:
			case LSB:
				enterOuterAlt(_localctx, 2);
				{
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSB) {
					{
					setState(559);
					default_parameters();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Default_parametersContext extends ParserRuleContext {
		public TerminalNode LSB() { return getToken(FunctionCraftParser.LSB, 0); }
		public TerminalNode RSB() { return getToken(FunctionCraftParser.RSB, 0); }
		public List<Default_parameterContext> default_parameter() {
			return getRuleContexts(Default_parameterContext.class);
		}
		public Default_parameterContext default_parameter(int i) {
			return getRuleContext(Default_parameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunctionCraftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionCraftParser.COMMA, i);
		}
		public Default_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterDefault_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitDefault_parameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitDefault_parameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Default_parametersContext default_parameters() throws RecognitionException {
		Default_parametersContext _localctx = new Default_parametersContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_default_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			match(LSB);
			setState(573);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(565);
				default_parameter();
				setState(570);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(566);
					match(COMMA);
					setState(567);
					default_parameter();
					}
					}
					setState(572);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(575);
			match(RSB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Default_parameterContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FunctionCraftParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(FunctionCraftParser.ASSIGN, 0); }
		public Value_literalContext value_literal() {
			return getRuleContext(Value_literalContext.class,0);
		}
		public Default_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterDefault_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitDefault_parameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitDefault_parameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Default_parameterContext default_parameter() throws RecognitionException {
		Default_parameterContext _localctx = new Default_parameterContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_default_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			match(IDENTIFIER);
			setState(578);
			match(ASSIGN);
			setState(579);
			value_literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunctionCraftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionCraftParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1152358485800255222L) != 0)) {
				{
				setState(581);
				expr("");
				setState(586);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(582);
					match(COMMA);
					setState(583);
					expr("");
					}
					}
					setState(588);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RangeContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(FunctionCraftParser.LPAR, 0); }
		public TerminalNode DOUBLE_DOT() { return getToken(FunctionCraftParser.DOUBLE_DOT, 0); }
		public TerminalNode RPAR() { return getToken(FunctionCraftParser.RPAR, 0); }
		public List<TerminalNode> INTEGER() { return getTokens(FunctionCraftParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(FunctionCraftParser.INTEGER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(FunctionCraftParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FunctionCraftParser.IDENTIFIER, i);
		}
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_range);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			match(LPAR);
			setState(592);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==INTEGER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(593);
			match(DOUBLE_DOT);
			setState(594);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==INTEGER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(595);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ParserRuleContext {
		public TerminalNode LSB() { return getToken(FunctionCraftParser.LSB, 0); }
		public TerminalNode RSB() { return getToken(FunctionCraftParser.RSB, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunctionCraftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionCraftParser.COMMA, i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			match(LSB);
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1152358485800255222L) != 0)) {
				{
				setState(598);
				expr("");
				setState(603);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(599);
					match(COMMA);
					setState(600);
					expr("");
					}
					}
					setState(605);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(608);
			match(RSB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Value_listContext extends ParserRuleContext {
		public TerminalNode LSB() { return getToken(FunctionCraftParser.LSB, 0); }
		public TerminalNode RSB() { return getToken(FunctionCraftParser.RSB, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunctionCraftParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionCraftParser.COMMA, i);
		}
		public Value_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterValue_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitValue_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitValue_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_listContext value_list() throws RecognitionException {
		Value_listContext _localctx = new Value_listContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			match(LSB);
			setState(619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2305843009212121088L) != 0)) {
				{
				setState(611);
				value();
				setState(616);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(612);
					match(COMMA);
					setState(613);
					value();
					}
					}
					setState(618);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(621);
			match(RSB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(FunctionCraftParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(FunctionCraftParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(FunctionCraftParser.STRING, 0); }
		public BooleanContext boolean_() {
			return getRuleContext(BooleanContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_value);
		try {
			setState(627);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(623);
				match(INTEGER);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(624);
				match(FLOAT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(625);
				match(STRING);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(626);
				boolean_();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Value_literalContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(FunctionCraftParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(FunctionCraftParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(FunctionCraftParser.STRING, 0); }
		public BooleanContext boolean_() {
			return getRuleContext(BooleanContext.class,0);
		}
		public Value_listContext value_list() {
			return getRuleContext(Value_listContext.class,0);
		}
		public Value_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterValue_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitValue_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitValue_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_literalContext value_literal() throws RecognitionException {
		Value_literalContext _localctx = new Value_literalContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_value_literal);
		try {
			setState(634);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(629);
				match(INTEGER);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(630);
				match(FLOAT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(631);
				match(STRING);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(632);
				boolean_();
				}
				break;
			case LSB:
				enterOuterAlt(_localctx, 5);
				{
				setState(633);
				value_list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(FunctionCraftParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FunctionCraftParser.FALSE, 0); }
		public BooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FunctionCraftListener ) ((FunctionCraftListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionCraftVisitor ) return ((FunctionCraftVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanContext boolean_() throws RecognitionException {
		BooleanContext _localctx = new BooleanContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_boolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001C\u027f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0001"+
		"\u0000\u0001\u0000\u0005\u0000q\b\u0000\n\u0000\f\u0000t\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0005\u0004\u008c\b\u0004\n"+
		"\u0004\f\u0004\u008f\t\u0004\u0001\u0004\u0003\u0004\u0092\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0097\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0004\u0007\u00a9\b\u0007\u000b\u0007\f"+
		"\u0007\u00aa\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u00bc"+
		"\b\t\u000b\t\f\t\u00bd\u0003\t\u00c0\b\t\u0001\t\u0001\t\u0003\t\u00c4"+
		"\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00cb\b\n\n\n\f\n"+
		"\u00ce\t\n\u0001\n\u0003\n\u00d1\b\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00ea\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00f1\b\u000f\n\u000f\f\u000f\u00f4\t\u000f\u0001\u000f\u0003\u000f\u00f7"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0103"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0109"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0133"+
		"\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u013a\b\u001a\u0001\u001b\u0003\u001b\u013d\b\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u0145\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b"+
		"\u014b\b\u001b\n\u001b\f\u001b\u014e\t\u001b\u0001\u001b\u0003\u001b\u0151"+
		"\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0003\u001b\u0159\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0005\u001b\u015f\b\u001b\n\u001b\f\u001b\u0162\t\u001b\u0003\u001b"+
		"\u0164\b\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d"+
		"\u0170\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e"+
		"\u017c\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u0188\b\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u0197\b \u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0003!\u01b0\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u01bf\b\"\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u01d3\b#\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0003$\u01e0\b$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0003%\u01eb\b%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0003&\u01f7\b&\u0001&\u0001&\u0005&\u01fb\b&\n"+
		"&\f&\u01fe\t&\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001-\u0001"+
		"-\u0001-\u0005-\u0227\b-\n-\f-\u022a\t-\u0001-\u0001-\u0003-\u022e\b-"+
		"\u0001-\u0003-\u0231\b-\u0003-\u0233\b-\u0001.\u0001.\u0001.\u0001.\u0005"+
		".\u0239\b.\n.\f.\u023c\t.\u0003.\u023e\b.\u0001.\u0001.\u0001/\u0001/"+
		"\u0001/\u0001/\u00010\u00010\u00010\u00050\u0249\b0\n0\f0\u024c\t0\u0003"+
		"0\u024e\b0\u00011\u00011\u00011\u00011\u00011\u00011\u00012\u00012\u0001"+
		"2\u00012\u00052\u025a\b2\n2\f2\u025d\t2\u00032\u025f\b2\u00012\u00012"+
		"\u00013\u00013\u00013\u00013\u00053\u0267\b3\n3\f3\u026a\t3\u00033\u026c"+
		"\b3\u00013\u00013\u00014\u00014\u00014\u00014\u00034\u0274\b4\u00015\u0001"+
		"5\u00015\u00015\u00015\u00035\u027b\b5\u00016\u00016\u00016\u0000\u0000"+
		"7\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjl\u0000\u0003\u0002"+
		"\u0000**59\u0002\u0000<<>>\u0001\u0000\u0013\u0014\u0299\u0000r\u0001"+
		"\u0000\u0000\u0000\u0002w\u0001\u0000\u0000\u0000\u0004\u007f\u0001\u0000"+
		"\u0000\u0000\u0006\u0083\u0001\u0000\u0000\u0000\b\u008d\u0001\u0000\u0000"+
		"\u0000\n\u0093\u0001\u0000\u0000\u0000\f\u009a\u0001\u0000\u0000\u0000"+
		"\u000e\u00a8\u0001\u0000\u0000\u0000\u0010\u00ac\u0001\u0000\u0000\u0000"+
		"\u0012\u00c3\u0001\u0000\u0000\u0000\u0014\u00c5\u0001\u0000\u0000\u0000"+
		"\u0016\u00d4\u0001\u0000\u0000\u0000\u0018\u00d9\u0001\u0000\u0000\u0000"+
		"\u001a\u00dd\u0001\u0000\u0000\u0000\u001c\u00e3\u0001\u0000\u0000\u0000"+
		"\u001e\u00f2\u0001\u0000\u0000\u0000 \u00f8\u0001\u0000\u0000\u0000\""+
		"\u0102\u0001\u0000\u0000\u0000$\u0108\u0001\u0000\u0000\u0000&\u010a\u0001"+
		"\u0000\u0000\u0000(\u010e\u0001\u0000\u0000\u0000*\u0112\u0001\u0000\u0000"+
		"\u0000,\u0118\u0001\u0000\u0000\u0000.\u011e\u0001\u0000\u0000\u00000"+
		"\u0127\u0001\u0000\u0000\u00002\u0132\u0001\u0000\u0000\u00004\u0139\u0001"+
		"\u0000\u0000\u00006\u0163\u0001\u0000\u0000\u00008\u0165\u0001\u0000\u0000"+
		"\u0000:\u016f\u0001\u0000\u0000\u0000<\u017b\u0001\u0000\u0000\u0000>"+
		"\u0187\u0001\u0000\u0000\u0000@\u0196\u0001\u0000\u0000\u0000B\u01af\u0001"+
		"\u0000\u0000\u0000D\u01be\u0001\u0000\u0000\u0000F\u01d2\u0001\u0000\u0000"+
		"\u0000H\u01df\u0001\u0000\u0000\u0000J\u01ea\u0001\u0000\u0000\u0000L"+
		"\u01f6\u0001\u0000\u0000\u0000N\u01ff\u0001\u0000\u0000\u0000P\u0203\u0001"+
		"\u0000\u0000\u0000R\u0209\u0001\u0000\u0000\u0000T\u0211\u0001\u0000\u0000"+
		"\u0000V\u0217\u0001\u0000\u0000\u0000X\u021d\u0001\u0000\u0000\u0000Z"+
		"\u0232\u0001\u0000\u0000\u0000\\\u0234\u0001\u0000\u0000\u0000^\u0241"+
		"\u0001\u0000\u0000\u0000`\u024d\u0001\u0000\u0000\u0000b\u024f\u0001\u0000"+
		"\u0000\u0000d\u0255\u0001\u0000\u0000\u0000f\u0262\u0001\u0000\u0000\u0000"+
		"h\u0273\u0001\u0000\u0000\u0000j\u027a\u0001\u0000\u0000\u0000l\u027c"+
		"\u0001\u0000\u0000\u0000nq\u0003\u0004\u0002\u0000oq\u0003\f\u0006\u0000"+
		"pn\u0001\u0000\u0000\u0000po\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000"+
		"\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000"+
		"\u0000\u0000tr\u0001\u0000\u0000\u0000uv\u0003\u0002\u0001\u0000v\u0001"+
		"\u0001\u0000\u0000\u0000wx\u0005\f\u0000\u0000xy\u0005\u000e\u0000\u0000"+
		"yz\u0006\u0001\uffff\uffff\u0000z{\u0005\u0001\u0000\u0000{|\u0005\u0002"+
		"\u0000\u0000|}\u0003\b\u0004\u0000}~\u0005\r\u0000\u0000~\u0003\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0003\u0006\u0003\u0000\u0080\u0081\u0003"+
		"\b\u0004\u0000\u0081\u0082\u0005\r\u0000\u0000\u0082\u0005\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0005\f\u0000\u0000\u0084\u0085\u0005<\u0000"+
		"\u0000\u0085\u0086\u0006\u0003\uffff\uffff\u0000\u0086\u0087\u0005\u0001"+
		"\u0000\u0000\u0087\u0088\u0003Z-\u0000\u0088\u0089\u0005\u0002\u0000\u0000"+
		"\u0089\u0007\u0001\u0000\u0000\u0000\u008a\u008c\u0003\u0012\t\u0000\u008b"+
		"\u008a\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d"+
		"\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e"+
		"\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090"+
		"\u0092\u0003\n\u0005\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0001\u0000\u0000\u0000\u0092\t\u0001\u0000\u0000\u0000\u0093\u0094\u0005"+
		"\u000f\u0000\u0000\u0094\u0096\u0006\u0005\uffff\uffff\u0000\u0095\u0097"+
		"\u00038\u001c\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0096\u0097\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0099\u0005"+
		"\n\u0000\u0000\u0099\u000b\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u001b"+
		"\u0000\u0000\u009b\u009c\u0005<\u0000\u0000\u009c\u009d\u0006\u0006\uffff"+
		"\uffff\u0000\u009d\u009e\u0005\u0001\u0000\u0000\u009e\u009f\u0003Z-\u0000"+
		"\u009f\u00a0\u0005\u0002\u0000\u0000\u00a0\u00a1\u0003\u000e\u0007\u0000"+
		"\u00a1\u00a2\u0005\n\u0000\u0000\u00a2\r\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0005@\u0000\u0000\u00a4\u00a5\u00036\u001b\u0000\u00a5\u00a6\u0005"+
		"*\u0000\u0000\u00a6\u00a7\u00038\u001c\u0000\u00a7\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a3\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000"+
		"\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ab\u000f\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005<\u0000\u0000"+
		"\u00ad\u00ae\u00053\u0000\u0000\u00ae\u00af\u0005\u001c\u0000\u0000\u00af"+
		"\u00b0\u0006\b\uffff\uffff\u0000\u00b0\u00b1\u0005\u0001\u0000\u0000\u00b1"+
		"\u00b2\u0003`0\u0000\u00b2\u00b3\u0005\u0002\u0000\u0000\u00b3\u0011\u0001"+
		"\u0000\u0000\u0000\u00b4\u00c4\u0003\u0014\n\u0000\u00b5\u00c4\u0003\u001a"+
		"\r\u0000\u00b6\u00c4\u0003\u001c\u000e\u0000\u00b7\u00c0\u0003\u0010\b"+
		"\u0000\u00b8\u00c0\u0003 \u0010\u0000\u00b9\u00bb\u00038\u001c\u0000\u00ba"+
		"\u00bc\u00030\u0018\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be"+
		"\u0001\u0000\u0000\u0000\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf\u00b7"+
		"\u0001\u0000\u0000\u0000\u00bf\u00b8\u0001\u0000\u0000\u0000\u00bf\u00b9"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0005\n\u0000\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3\u00b4\u0001"+
		"\u0000\u0000\u0000\u00c3\u00b5\u0001\u0000\u0000\u0000\u00c3\u00b6\u0001"+
		"\u0000\u0000\u0000\u00c3\u00bf\u0001\u0000\u0000\u0000\u00c4\u0013\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0005\u0010\u0000\u0000\u00c6\u00c7\u0006"+
		"\n\uffff\uffff\u0000\u00c7\u00c8\u00036\u001b\u0000\u00c8\u00cc\u0003"+
		"\b\u0004\u0000\u00c9\u00cb\u0003\u0016\u000b\u0000\u00ca\u00c9\u0001\u0000"+
		"\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d1\u0003\u0018"+
		"\f\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\r\u0000\u0000"+
		"\u00d3\u0015\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\u0012\u0000\u0000"+
		"\u00d5\u00d6\u0006\u000b\uffff\uffff\u0000\u00d6\u00d7\u00036\u001b\u0000"+
		"\u00d7\u00d8\u0003\b\u0004\u0000\u00d8\u0017\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0005\u0011\u0000\u0000\u00da\u00db\u0006\f\uffff\uffff\u0000\u00db"+
		"\u00dc\u0003\b\u0004\u0000\u00dc\u0019\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u0005\u001f\u0000\u0000\u00de\u00df\u0005 \u0000\u0000\u00df\u00e0\u0006"+
		"\r\uffff\uffff\u0000\u00e0\u00e1\u0003\u001e\u000f\u0000\u00e1\u00e2\u0005"+
		"\r\u0000\u0000\u00e2\u001b\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005!"+
		"\u0000\u0000\u00e4\u00e5\u0006\u000e\uffff\uffff\u0000\u00e5\u00e6\u0005"+
		"<\u0000\u0000\u00e6\u00e9\u0005\"\u0000\u0000\u00e7\u00ea\u0003d2\u0000"+
		"\u00e8\u00ea\u0003b1\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00e8"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ec"+
		"\u0003\u001e\u000f\u0000\u00ec\u00ed\u0005\r\u0000\u0000\u00ed\u001d\u0001"+
		"\u0000\u0000\u0000\u00ee\u00f1\u0003\u0012\t\u0000\u00ef\u00f1\u0003$"+
		"\u0012\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f0\u00ef\u0001\u0000"+
		"\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f7\u0003\n\u0005"+
		"\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000"+
		"\u0000\u00f7\u001f\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005<\u0000\u0000"+
		"\u00f9\u00fa\u0007\u0000\u0000\u0000\u00fa\u00fb\u00038\u001c\u0000\u00fb"+
		"\u00fc\u0006\u0010\uffff\uffff\u0000\u00fc!\u0001\u0000\u0000\u0000\u00fd"+
		"\u0103\u0005>\u0000\u0000\u00fe\u0103\u0005=\u0000\u0000\u00ff\u0103\u0005"+
		"?\u0000\u0000\u0100\u0103\u0003l6\u0000\u0101\u0103\u0003d2\u0000\u0102"+
		"\u00fd\u0001\u0000\u0000\u0000\u0102\u00fe\u0001\u0000\u0000\u0000\u0102"+
		"\u00ff\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0102"+
		"\u0101\u0001\u0000\u0000\u0000\u0103#\u0001\u0000\u0000\u0000\u0104\u0109"+
		"\u0003&\u0013\u0000\u0105\u0109\u0003*\u0015\u0000\u0106\u0109\u0003("+
		"\u0014\u0000\u0107\u0109\u0003,\u0016\u0000\u0108\u0104\u0001\u0000\u0000"+
		"\u0000\u0108\u0105\u0001\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000"+
		"\u0000\u0108\u0107\u0001\u0000\u0000\u0000\u0109%\u0001\u0000\u0000\u0000"+
		"\u010a\u010b\u0005\u001e\u0000\u0000\u010b\u010c\u0006\u0013\uffff\uffff"+
		"\u0000\u010c\u010d\u0005\n\u0000\u0000\u010d\'\u0001\u0000\u0000\u0000"+
		"\u010e\u010f\u0005\u001d\u0000\u0000\u010f\u0110\u0006\u0014\uffff\uffff"+
		"\u0000\u0110\u0111\u0005\n\u0000\u0000\u0111)\u0001\u0000\u0000\u0000"+
		"\u0112\u0113\u0005\u001e\u0000\u0000\u0113\u0114\u0005\u0010\u0000\u0000"+
		"\u0114\u0115\u0006\u0015\uffff\uffff\u0000\u0115\u0116\u00036\u001b\u0000"+
		"\u0116\u0117\u0005\n\u0000\u0000\u0117+\u0001\u0000\u0000\u0000\u0118"+
		"\u0119\u0005\u001d\u0000\u0000\u0119\u011a\u0005\u0010\u0000\u0000\u011a"+
		"\u011b\u0006\u0016\uffff\uffff\u0000\u011b\u011c\u00036\u001b\u0000\u011c"+
		"\u011d\u0005\n\u0000\u0000\u011d-\u0001\u0000\u0000\u0000\u011e\u011f"+
		"\u0005\b\u0000\u0000\u011f\u0120\u0006\u0017\uffff\uffff\u0000\u0120\u0121"+
		"\u0005\u0001\u0000\u0000\u0121\u0122\u0003Z-\u0000\u0122\u0123\u0005\u0002"+
		"\u0000\u0000\u0123\u0124\u0005\u0005\u0000\u0000\u0124\u0125\u0003\b\u0004"+
		"\u0000\u0125\u0126\u0005\u0006\u0000\u0000\u0126/\u0001\u0000\u0000\u0000"+
		"\u0127\u0128\u0006\u0018\uffff\uffff\u0000\u0128\u0129\u0005\u0001\u0000"+
		"\u0000\u0129\u012a\u0003`0\u0000\u012a\u012b\u0005\u0002\u0000\u0000\u012b"+
		"1\u0001\u0000\u0000\u0000\u012c\u012d\u0005\u0019\u0000\u0000\u012d\u012e"+
		"\u0005\u0001\u0000\u0000\u012e\u012f\u0005\t\u0000\u0000\u012f\u0130\u0005"+
		"<\u0000\u0000\u0130\u0133\u0005\u0002\u0000\u0000\u0131\u0133\u0003.\u0017"+
		"\u0000\u0132\u012c\u0001\u0000\u0000\u0000\u0132\u0131\u0001\u0000\u0000"+
		"\u0000\u01333\u0001\u0000\u0000\u0000\u0134\u013a\u0003P(\u0000\u0135"+
		"\u013a\u0003R)\u0000\u0136\u013a\u0003T*\u0000\u0137\u013a\u0003V+\u0000"+
		"\u0138\u013a\u0003X,\u0000\u0139\u0134\u0001\u0000\u0000\u0000\u0139\u0135"+
		"\u0001\u0000\u0000\u0000\u0139\u0136\u0001\u0000\u0000\u0000\u0139\u0137"+
		"\u0001\u0000\u0000\u0000\u0139\u0138\u0001\u0000\u0000\u0000\u013a5\u0001"+
		"\u0000\u0000\u0000\u013b\u013d\u00051\u0000\u0000\u013c\u013b\u0001\u0000"+
		"\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000"+
		"\u0000\u0000\u013e\u013f\u0005\u0001\u0000\u0000\u013f\u0140\u00038\u001c"+
		"\u0000\u0140\u0141\u0005\u0002\u0000\u0000\u0141\u014c\u0001\u0000\u0000"+
		"\u0000\u0142\u0144\u0005/\u0000\u0000\u0143\u0145\u00051\u0000\u0000\u0144"+
		"\u0143\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145"+
		"\u0146\u0001\u0000\u0000\u0000\u0146\u0147\u0005\u0001\u0000\u0000\u0147"+
		"\u0148\u00038\u001c\u0000\u0148\u0149\u0005\u0002\u0000\u0000\u0149\u014b"+
		"\u0001\u0000\u0000\u0000\u014a\u0142\u0001\u0000\u0000\u0000\u014b\u014e"+
		"\u0001\u0000\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d"+
		"\u0001\u0000\u0000\u0000\u014d\u0164\u0001\u0000\u0000\u0000\u014e\u014c"+
		"\u0001\u0000\u0000\u0000\u014f\u0151\u00051\u0000\u0000\u0150\u014f\u0001"+
		"\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0152\u0001"+
		"\u0000\u0000\u0000\u0152\u0153\u0005\u0001\u0000\u0000\u0153\u0154\u0003"+
		"8\u001c\u0000\u0154\u0155\u0005\u0002\u0000\u0000\u0155\u0160\u0001\u0000"+
		"\u0000\u0000\u0156\u0158\u00050\u0000\u0000\u0157\u0159\u00051\u0000\u0000"+
		"\u0158\u0157\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000"+
		"\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u015b\u0005\u0001\u0000\u0000"+
		"\u015b\u015c\u00038\u001c\u0000\u015c\u015d\u0005\u0002\u0000\u0000\u015d"+
		"\u015f\u0001\u0000\u0000\u0000\u015e\u0156\u0001\u0000\u0000\u0000\u015f"+
		"\u0162\u0001\u0000\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0160"+
		"\u0161\u0001\u0000\u0000\u0000\u0161\u0164\u0001\u0000\u0000\u0000\u0162"+
		"\u0160\u0001\u0000\u0000\u0000\u0163\u013c\u0001\u0000\u0000\u0000\u0163"+
		"\u0150\u0001\u0000\u0000\u0000\u01647\u0001\u0000\u0000\u0000\u0165\u0166"+
		"\u0003:\u001d\u0000\u01669\u0001\u0000\u0000\u0000\u0167\u0168\u0003<"+
		"\u001e\u0000\u0168\u0169\u0006\u001d\uffff\uffff\u0000\u0169\u016a\u0005"+
		"4\u0000\u0000\u016a\u016b\u0003:\u001d\u0000\u016b\u0170\u0001\u0000\u0000"+
		"\u0000\u016c\u016d\u0003<\u001e\u0000\u016d\u016e\u0006\u001d\uffff\uffff"+
		"\u0000\u016e\u0170\u0001\u0000\u0000\u0000\u016f\u0167\u0001\u0000\u0000"+
		"\u0000\u016f\u016c\u0001\u0000\u0000\u0000\u0170;\u0001\u0000\u0000\u0000"+
		"\u0171\u0172\u0005\u0001\u0000\u0000\u0172\u0173\u00038\u001c\u0000\u0173"+
		"\u0174\u0005\u0002\u0000\u0000\u0174\u0175\u00050\u0000\u0000\u0175\u0176"+
		"\u0005\u0001\u0000\u0000\u0176\u0177\u00038\u001c\u0000\u0177\u0178\u0005"+
		"\u0002\u0000\u0000\u0178\u0179\u0006\u001e\uffff\uffff\u0000\u0179\u017c"+
		"\u0001\u0000\u0000\u0000\u017a\u017c\u0003>\u001f\u0000\u017b\u0171\u0001"+
		"\u0000\u0000\u0000\u017b\u017a\u0001\u0000\u0000\u0000\u017c=\u0001\u0000"+
		"\u0000\u0000\u017d\u017e\u0005\u0001\u0000\u0000\u017e\u017f\u00038\u001c"+
		"\u0000\u017f\u0180\u0005\u0002\u0000\u0000\u0180\u0181\u0005/\u0000\u0000"+
		"\u0181\u0182\u0005\u0001\u0000\u0000\u0182\u0183\u00038\u001c\u0000\u0183"+
		"\u0184\u0005\u0002\u0000\u0000\u0184\u0185\u0006\u001f\uffff\uffff\u0000"+
		"\u0185\u0188\u0001\u0000\u0000\u0000\u0186\u0188\u0003@ \u0000\u0187\u017d"+
		"\u0001\u0000\u0000\u0000\u0187\u0186\u0001\u0000\u0000\u0000\u0188?\u0001"+
		"\u0000\u0000\u0000\u0189\u018a\u0003B!\u0000\u018a\u018b\u0006 \uffff"+
		"\uffff\u0000\u018b\u018c\u0005;\u0000\u0000\u018c\u018d\u0003@ \u0000"+
		"\u018d\u0197\u0001\u0000\u0000\u0000\u018e\u018f\u0003B!\u0000\u018f\u0190"+
		"\u0006 \uffff\uffff\u0000\u0190\u0191\u0005:\u0000\u0000\u0191\u0192\u0003"+
		"@ \u0000\u0192\u0197\u0001\u0000\u0000\u0000\u0193\u0194\u0003B!\u0000"+
		"\u0194\u0195\u0006 \uffff\uffff\u0000\u0195\u0197\u0001\u0000\u0000\u0000"+
		"\u0196\u0189\u0001\u0000\u0000\u0000\u0196\u018e\u0001\u0000\u0000\u0000"+
		"\u0196\u0193\u0001\u0000\u0000\u0000\u0197A\u0001\u0000\u0000\u0000\u0198"+
		"\u0199\u0003D\"\u0000\u0199\u019a\u0006!\uffff\uffff\u0000\u019a\u019b"+
		"\u0005+\u0000\u0000\u019b\u019c\u0003B!\u0000\u019c\u01b0\u0001\u0000"+
		"\u0000\u0000\u019d\u019e\u0003D\"\u0000\u019e\u019f\u0006!\uffff\uffff"+
		"\u0000\u019f\u01a0\u0005,\u0000\u0000\u01a0\u01a1\u0003B!\u0000\u01a1"+
		"\u01b0\u0001\u0000\u0000\u0000\u01a2\u01a3\u0003D\"\u0000\u01a3\u01a4"+
		"\u0006!\uffff\uffff\u0000\u01a4\u01a5\u0005-\u0000\u0000\u01a5\u01a6\u0003"+
		"B!\u0000\u01a6\u01b0\u0001\u0000\u0000\u0000\u01a7\u01a8\u0003D\"\u0000"+
		"\u01a8\u01a9\u0006!\uffff\uffff\u0000\u01a9\u01aa\u0005.\u0000\u0000\u01aa"+
		"\u01ab\u0003B!\u0000\u01ab\u01b0\u0001\u0000\u0000\u0000\u01ac\u01ad\u0003"+
		"D\"\u0000\u01ad\u01ae\u0006!\uffff\uffff\u0000\u01ae\u01b0\u0001\u0000"+
		"\u0000\u0000\u01af\u0198\u0001\u0000\u0000\u0000\u01af\u019d\u0001\u0000"+
		"\u0000\u0000\u01af\u01a2\u0001\u0000\u0000\u0000\u01af\u01a7\u0001\u0000"+
		"\u0000\u0000\u01af\u01ac\u0001\u0000\u0000\u0000\u01b0C\u0001\u0000\u0000"+
		"\u0000\u01b1\u01b2\u0003F#\u0000\u01b2\u01b3\u0006\"\uffff\uffff\u0000"+
		"\u01b3\u01b4\u0005#\u0000\u0000\u01b4\u01b5\u0003D\"\u0000\u01b5\u01bf"+
		"\u0001\u0000\u0000\u0000\u01b6\u01b7\u0003F#\u0000\u01b7\u01b8\u0006\""+
		"\uffff\uffff\u0000\u01b8\u01b9\u0005$\u0000\u0000\u01b9\u01ba\u0003D\""+
		"\u0000\u01ba\u01bf\u0001\u0000\u0000\u0000\u01bb\u01bc\u0003F#\u0000\u01bc"+
		"\u01bd\u0006\"\uffff\uffff\u0000\u01bd\u01bf\u0001\u0000\u0000\u0000\u01be"+
		"\u01b1\u0001\u0000\u0000\u0000\u01be\u01b6\u0001\u0000\u0000\u0000\u01be"+
		"\u01bb\u0001\u0000\u0000\u0000\u01bfE\u0001\u0000\u0000\u0000\u01c0\u01c1"+
		"\u0003H$\u0000\u01c1\u01c2\u0006#\uffff\uffff\u0000\u01c2\u01c3\u0005"+
		"&\u0000\u0000\u01c3\u01c4\u0003F#\u0000\u01c4\u01d3\u0001\u0000\u0000"+
		"\u0000\u01c5\u01c6\u0003H$\u0000\u01c6\u01c7\u0006#\uffff\uffff\u0000"+
		"\u01c7\u01c8\u0005%\u0000\u0000\u01c8\u01c9\u0003F#\u0000\u01c9\u01d3"+
		"\u0001\u0000\u0000\u0000\u01ca\u01cb\u0003H$\u0000\u01cb\u01cc\u0006#"+
		"\uffff\uffff\u0000\u01cc\u01cd\u0005\'\u0000\u0000\u01cd\u01ce\u0003F"+
		"#\u0000\u01ce\u01d3\u0001\u0000\u0000\u0000\u01cf\u01d0\u0003H$\u0000"+
		"\u01d0\u01d1\u0006#\uffff\uffff\u0000\u01d1\u01d3\u0001\u0000\u0000\u0000"+
		"\u01d2\u01c0\u0001\u0000\u0000\u0000\u01d2\u01c5\u0001\u0000\u0000\u0000"+
		"\u01d2\u01ca\u0001\u0000\u0000\u0000\u01d2\u01cf\u0001\u0000\u0000\u0000"+
		"\u01d3G\u0001\u0000\u0000\u0000\u01d4\u01d5\u00051\u0000\u0000\u01d5\u01d6"+
		"\u0005\u0001\u0000\u0000\u01d6\u01d7\u0003J%\u0000\u01d7\u01d8\u0005\u0002"+
		"\u0000\u0000\u01d8\u01d9\u0006$\uffff\uffff\u0000\u01d9\u01e0\u0001\u0000"+
		"\u0000\u0000\u01da\u01db\u0005$\u0000\u0000\u01db\u01dc\u0003J%\u0000"+
		"\u01dc\u01dd\u0006$\uffff\uffff\u0000\u01dd\u01e0\u0001\u0000\u0000\u0000"+
		"\u01de\u01e0\u0003J%\u0000\u01df\u01d4\u0001\u0000\u0000\u0000\u01df\u01da"+
		"\u0001\u0000\u0000\u0000\u01df\u01de\u0001\u0000\u0000\u0000\u01e0I\u0001"+
		"\u0000\u0000\u0000\u01e1\u01e2\u0003L&\u0000\u01e2\u01e3\u0005)\u0000"+
		"\u0000\u01e3\u01e4\u0006%\uffff\uffff\u0000\u01e4\u01eb\u0001\u0000\u0000"+
		"\u0000\u01e5\u01e6\u0003L&\u0000\u01e6\u01e7\u0005(\u0000\u0000\u01e7"+
		"\u01e8\u0006%\uffff\uffff\u0000\u01e8\u01eb\u0001\u0000\u0000\u0000\u01e9"+
		"\u01eb\u0003L&\u0000\u01ea\u01e1\u0001\u0000\u0000\u0000\u01ea\u01e5\u0001"+
		"\u0000\u0000\u0000\u01ea\u01e9\u0001\u0000\u0000\u0000\u01ebK\u0001\u0000"+
		"\u0000\u0000\u01ec\u01ed\u0005\u0001\u0000\u0000\u01ed\u01ee\u00038\u001c"+
		"\u0000\u01ee\u01ef\u0005\u0002\u0000\u0000\u01ef\u01f7\u0001\u0000\u0000"+
		"\u0000\u01f0\u01f7\u00030\u0018\u0000\u01f1\u01f7\u00032\u0019\u0000\u01f2"+
		"\u01f7\u00034\u001a\u0000\u01f3\u01f7\u0003\u0010\b\u0000\u01f4\u01f7"+
		"\u0005<\u0000\u0000\u01f5\u01f7\u0003\"\u0011\u0000\u01f6\u01ec\u0001"+
		"\u0000\u0000\u0000\u01f6\u01f0\u0001\u0000\u0000\u0000\u01f6\u01f1\u0001"+
		"\u0000\u0000\u0000\u01f6\u01f2\u0001\u0000\u0000\u0000\u01f6\u01f3\u0001"+
		"\u0000\u0000\u0000\u01f6\u01f4\u0001\u0000\u0000\u0000\u01f6\u01f5\u0001"+
		"\u0000\u0000\u0000\u01f7\u01fc\u0001\u0000\u0000\u0000\u01f8\u01fb\u0003"+
		"N\'\u0000\u01f9\u01fb\u00030\u0018\u0000\u01fa\u01f8\u0001\u0000\u0000"+
		"\u0000\u01fa\u01f9\u0001\u0000\u0000\u0000\u01fb\u01fe\u0001\u0000\u0000"+
		"\u0000\u01fc\u01fa\u0001\u0000\u0000\u0000\u01fc\u01fd\u0001\u0000\u0000"+
		"\u0000\u01fdM\u0001\u0000\u0000\u0000\u01fe\u01fc\u0001\u0000\u0000\u0000"+
		"\u01ff\u0200\u0005\u0003\u0000\u0000\u0200\u0201\u00038\u001c\u0000\u0201"+
		"\u0202\u0005\u0004\u0000\u0000\u0202O\u0001\u0000\u0000\u0000\u0203\u0204"+
		"\u0005\u0018\u0000\u0000\u0204\u0205\u0006(\uffff\uffff\u0000\u0205\u0206"+
		"\u0005\u0001\u0000\u0000\u0206\u0207\u00038\u001c\u0000\u0207\u0208\u0005"+
		"\u0002\u0000\u0000\u0208Q\u0001\u0000\u0000\u0000\u0209\u020a\u0005\u0017"+
		"\u0000\u0000\u020a\u020b\u0006)\uffff\uffff\u0000\u020b\u020c\u0005\u0001"+
		"\u0000\u0000\u020c\u020d\u00038\u001c\u0000\u020d\u020e\u0005\u000b\u0000"+
		"\u0000\u020e\u020f\u00038\u001c\u0000\u020f\u0210\u0005\u0002\u0000\u0000"+
		"\u0210S\u0001\u0000\u0000\u0000\u0211\u0212\u0005\u001a\u0000\u0000\u0212"+
		"\u0213\u0006*\uffff\uffff\u0000\u0213\u0214\u0005\u0001\u0000\u0000\u0214"+
		"\u0215\u00038\u001c\u0000\u0215\u0216\u0005\u0002\u0000\u0000\u0216U\u0001"+
		"\u0000\u0000\u0000\u0217\u0218\u0005\u0015\u0000\u0000\u0218\u0219\u0006"+
		"+\uffff\uffff\u0000\u0219\u021a\u0005\u0001\u0000\u0000\u021a\u021b\u0003"+
		"8\u001c\u0000\u021b\u021c\u0005\u0002\u0000\u0000\u021cW\u0001\u0000\u0000"+
		"\u0000\u021d\u021e\u0005\u0016\u0000\u0000\u021e\u021f\u0006,\uffff\uffff"+
		"\u0000\u021f\u0220\u0005\u0001\u0000\u0000\u0220\u0221\u00038\u001c\u0000"+
		"\u0221\u0222\u0005\u0002\u0000\u0000\u0222Y\u0001\u0000\u0000\u0000\u0223"+
		"\u0228\u0005<\u0000\u0000\u0224\u0225\u0005\u000b\u0000\u0000\u0225\u0227"+
		"\u0005<\u0000\u0000\u0226\u0224\u0001\u0000\u0000\u0000\u0227\u022a\u0001"+
		"\u0000\u0000\u0000\u0228\u0226\u0001\u0000\u0000\u0000\u0228\u0229\u0001"+
		"\u0000\u0000\u0000\u0229\u022d\u0001\u0000\u0000\u0000\u022a\u0228\u0001"+
		"\u0000\u0000\u0000\u022b\u022c\u0005\u000b\u0000\u0000\u022c\u022e\u0003"+
		"\\.\u0000\u022d\u022b\u0001\u0000\u0000\u0000\u022d\u022e\u0001\u0000"+
		"\u0000\u0000\u022e\u0233\u0001\u0000\u0000\u0000\u022f\u0231\u0003\\."+
		"\u0000\u0230\u022f\u0001\u0000\u0000\u0000\u0230\u0231\u0001\u0000\u0000"+
		"\u0000\u0231\u0233\u0001\u0000\u0000\u0000\u0232\u0223\u0001\u0000\u0000"+
		"\u0000\u0232\u0230\u0001\u0000\u0000\u0000\u0233[\u0001\u0000\u0000\u0000"+
		"\u0234\u023d\u0005\u0003\u0000\u0000\u0235\u023a\u0003^/\u0000\u0236\u0237"+
		"\u0005\u000b\u0000\u0000\u0237\u0239\u0003^/\u0000\u0238\u0236\u0001\u0000"+
		"\u0000\u0000\u0239\u023c\u0001\u0000\u0000\u0000\u023a\u0238\u0001\u0000"+
		"\u0000\u0000\u023a\u023b\u0001\u0000\u0000\u0000\u023b\u023e\u0001\u0000"+
		"\u0000\u0000\u023c\u023a\u0001\u0000\u0000\u0000\u023d\u0235\u0001\u0000"+
		"\u0000\u0000\u023d\u023e\u0001\u0000\u0000\u0000\u023e\u023f\u0001\u0000"+
		"\u0000\u0000\u023f\u0240\u0005\u0004\u0000\u0000\u0240]\u0001\u0000\u0000"+
		"\u0000\u0241\u0242\u0005<\u0000\u0000\u0242\u0243\u0005*\u0000\u0000\u0243"+
		"\u0244\u0003j5\u0000\u0244_\u0001\u0000\u0000\u0000\u0245\u024a\u0003"+
		"8\u001c\u0000\u0246\u0247\u0005\u000b\u0000\u0000\u0247\u0249\u00038\u001c"+
		"\u0000\u0248\u0246\u0001\u0000\u0000\u0000\u0249\u024c\u0001\u0000\u0000"+
		"\u0000\u024a\u0248\u0001\u0000\u0000\u0000\u024a\u024b\u0001\u0000\u0000"+
		"\u0000\u024b\u024e\u0001\u0000\u0000\u0000\u024c\u024a\u0001\u0000\u0000"+
		"\u0000\u024d\u0245\u0001\u0000\u0000\u0000\u024d\u024e\u0001\u0000\u0000"+
		"\u0000\u024ea\u0001\u0000\u0000\u0000\u024f\u0250\u0005\u0001\u0000\u0000"+
		"\u0250\u0251\u0007\u0001\u0000\u0000\u0251\u0252\u00052\u0000\u0000\u0252"+
		"\u0253\u0007\u0001\u0000\u0000\u0253\u0254\u0005\u0002\u0000\u0000\u0254"+
		"c\u0001\u0000\u0000\u0000\u0255\u025e\u0005\u0003\u0000\u0000\u0256\u025b"+
		"\u00038\u001c\u0000\u0257\u0258\u0005\u000b\u0000\u0000\u0258\u025a\u0003"+
		"8\u001c\u0000\u0259\u0257\u0001\u0000\u0000\u0000\u025a\u025d\u0001\u0000"+
		"\u0000\u0000\u025b\u0259\u0001\u0000\u0000\u0000\u025b\u025c\u0001\u0000"+
		"\u0000\u0000\u025c\u025f\u0001\u0000\u0000\u0000\u025d\u025b\u0001\u0000"+
		"\u0000\u0000\u025e\u0256\u0001\u0000\u0000\u0000\u025e\u025f\u0001\u0000"+
		"\u0000\u0000\u025f\u0260\u0001\u0000\u0000\u0000\u0260\u0261\u0005\u0004"+
		"\u0000\u0000\u0261e\u0001\u0000\u0000\u0000\u0262\u026b\u0005\u0003\u0000"+
		"\u0000\u0263\u0268\u0003h4\u0000\u0264\u0265\u0005\u000b\u0000\u0000\u0265"+
		"\u0267\u0003h4\u0000\u0266\u0264\u0001\u0000\u0000\u0000\u0267\u026a\u0001"+
		"\u0000\u0000\u0000\u0268\u0266\u0001\u0000\u0000\u0000\u0268\u0269\u0001"+
		"\u0000\u0000\u0000\u0269\u026c\u0001\u0000\u0000\u0000\u026a\u0268\u0001"+
		"\u0000\u0000\u0000\u026b\u0263\u0001\u0000\u0000\u0000\u026b\u026c\u0001"+
		"\u0000\u0000\u0000\u026c\u026d\u0001\u0000\u0000\u0000\u026d\u026e\u0005"+
		"\u0004\u0000\u0000\u026eg\u0001\u0000\u0000\u0000\u026f\u0274\u0005>\u0000"+
		"\u0000\u0270\u0274\u0005=\u0000\u0000\u0271\u0274\u0005?\u0000\u0000\u0272"+
		"\u0274\u0003l6\u0000\u0273\u026f\u0001\u0000\u0000\u0000\u0273\u0270\u0001"+
		"\u0000\u0000\u0000\u0273\u0271\u0001\u0000\u0000\u0000\u0273\u0272\u0001"+
		"\u0000\u0000\u0000\u0274i\u0001\u0000\u0000\u0000\u0275\u027b\u0005>\u0000"+
		"\u0000\u0276\u027b\u0005=\u0000\u0000\u0277\u027b\u0005?\u0000\u0000\u0278"+
		"\u027b\u0003l6\u0000\u0279\u027b\u0003f3\u0000\u027a\u0275\u0001\u0000"+
		"\u0000\u0000\u027a\u0276\u0001\u0000\u0000\u0000\u027a\u0277\u0001\u0000"+
		"\u0000\u0000\u027a\u0278\u0001\u0000\u0000\u0000\u027a\u0279\u0001\u0000"+
		"\u0000\u0000\u027bk\u0001\u0000\u0000\u0000\u027c\u027d\u0007\u0002\u0000"+
		"\u0000\u027dm\u0001\u0000\u0000\u00004pr\u008d\u0091\u0096\u00aa\u00bd"+
		"\u00bf\u00c3\u00cc\u00d0\u00e9\u00f0\u00f2\u00f6\u0102\u0108\u0132\u0139"+
		"\u013c\u0144\u014c\u0150\u0158\u0160\u0163\u016f\u017b\u0187\u0196\u01af"+
		"\u01be\u01d2\u01df\u01ea\u01f6\u01fa\u01fc\u0228\u022d\u0230\u0232\u023a"+
		"\u023d\u024a\u024d\u025b\u025e\u0268\u026b\u0273\u027a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}