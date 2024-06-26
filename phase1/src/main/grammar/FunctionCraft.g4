grammar FunctionCraft;


program
    : (function | pattern_matching)* main
    ;

main
    : DEF MAIN                      { System.out.println("MAIN"); }
     LPAR RPAR block END
    ;

function
    : function_prototype block END
    ;

function_prototype
    : DEF (name = IDENTIFIER )      { System.out.println("FuncDec: " + $name.text); }
     LPAR parameters RPAR
    ;

block
    : statement* return_statement?
    ;

return_statement
    : RETURN { System.out.println("RETURN"); } expr[""]? SEMICOLON
    ;

pattern_matching
    : PATTERN (name = IDENTIFIER)   { System.out.println("PatternDec: " + $name.text); }
     LPAR parameters RPAR pattern_body SEMICOLON
    ;

pattern_body
    : (PATTERN_CONDITION condition ASSIGN expr[""])+
    ;

pattern_call
    : IDENTIFIER SINGLE_DOT MATCH { System.out.println("Built-In: MATCH"); } LPAR arguments RPAR
    ;

statement
    : if_statement
    | loop_statement
    | for_statement
    | (pattern_call | assignment | expr[""]) SEMICOLON
    ;

if_statement
    : IF                            { System.out.println("Decision: IF"); }
    condition               
    block
    elseif_statement*       
    else_statement?
    END
    ;

elseif_statement
    : ELSEIF                        { System.out.println("Decision: ELSE IF"); }
    condition
    block
    ;

else_statement
    : ELSE                          { System.out.println("Decision: ELSE"); }
    block
    ;

loop_statement
    : LOOP DO                       { System.out.println("Loop: DO"); }
    loop_body END
    ;

for_statement
    : FOR                           { System.out.println("Loop: FOR"); }
    IDENTIFIER IN (expr[""] | range) loop_body END
    ;

loop_body
    : (statement | jump_statement)* return_statement?
    ;

assignment
    : (name = IDENTIFIER)
    (ASSIGN | MINUS_EQUAL | MULTIPLY_EQUAL | DIVIDE_EQUAL | REMAINDER_EQUAL | PLUS_EQUAL)
     expr[""] { System.out.println("Assignment: " + $name.text); }
    ;

literal
    : INTEGER
    | FLOAT
    | STRING
    | boolean
    | list
    ;

jump_statement
    : break
    | break_if
    | next
    | next_if
    ;

break
    : BREAK                 { System.out.println("Control: BREAK"); }
    SEMICOLON
    ;

next
    : NEXT                  { System.out.println("Control: NEXT"); }
    SEMICOLON
    ;

break_if
    : BREAK IF              { System.out.println("Control: BREAK"); }
    condition SEMICOLON
    ;

next_if
    : NEXT IF               { System.out.println("Control: NEXT"); }
    condition SEMICOLON
    ;

lambda_function
    : RARROW                { System.out.println("Structure: LAMBDA"); }
     LPAR parameters RPAR LCB block RCB
    ;

function_call
    :                       { System.out.println("FunctionCall"); }
    LPAR arguments RPAR
    ;

function_pointer
    : METHOD LPAR COLON IDENTIFIER RPAR
    | lambda_function
    ;

primitive_function_call
    : puts
    | push
    | len
    | chop
    | chomp
    ;

condition
    : ( NOT? LPAR expr[""]  RPAR) (AND ( NOT? LPAR expr[""]  RPAR))*
    | ( NOT? LPAR expr[""]  RPAR) (OR ( NOT? LPAR expr[""]  RPAR))*
    ;

expr [String prev]
    @init {$prev = "";}
    : append_expr[$prev]
    ;

append_expr [String prev]
    : or_expr  { System.out.print($prev); } APPEND append_expr["Operator: <<\n"]
    | or_expr  { System.out.print($prev); }
    ;

or_expr
    : LPAR (expr[""]) RPAR OR LPAR (expr[""]) RPAR              { System.out.println("Operator: ||"); }
    | and_expr
    ;

and_expr
    : LPAR (expr[""]) RPAR AND LPAR (expr[""]) RPAR                     { System.out.println("Operator: &&"); }
    | eq_expr[""]
    ;

eq_expr [String prev]
    : comp_expr[""] { System.out.print($prev); } NOT_EQUAL eq_expr["Operator: !=\n"]
    | comp_expr[""] { System.out.print($prev); } EQUAL eq_expr["Operator: ==\n"]
    | comp_expr[""] { System.out.print($prev); }
    ;

comp_expr [String prev]
    : plus_minus_expr[""] { System.out.print($prev); } GREATER_THAN comp_expr["Operator: >\n"]
    | plus_minus_expr[""] { System.out.print($prev); } LESS_THAN comp_expr["Operator: <\n"]
    | plus_minus_expr[""] { System.out.print($prev); } LESS_EQUAL comp_expr["Operator: <=\n"]
    | plus_minus_expr[""] { System.out.print($prev); } GREATER_EQUAL comp_expr["Operator: >=\n"]
    | plus_minus_expr[""] { System.out.print($prev); }
    ;

plus_minus_expr [String prev]
    : divide_mult_expr[""] { System.out.print($prev); } PLUS plus_minus_expr["Operator: +\n"]
    | divide_mult_expr[""] { System.out.print($prev); } MINUS plus_minus_expr["Operator: -\n"]
    | divide_mult_expr[""] { System.out.print($prev); }
    ;

divide_mult_expr [String prev]
    : unary_prefix_operator_expr { System.out.print($prev); } DIVIDE  divide_mult_expr["Operator: /\n"]
    | unary_prefix_operator_expr { System.out.print($prev); } MULTIPLY  divide_mult_expr["Operator: *\n"]
    | unary_prefix_operator_expr { System.out.print($prev); } REMAINDER divide_mult_expr["Operator: %\n"]
    | unary_prefix_operator_expr { System.out.print($prev); }
    ;

unary_prefix_operator_expr
    : NOT LPAR unary_postfix_operator_expr RPAR                 { System.out.println("Operator: !"); }
    | MINUS unary_postfix_operator_expr                         { System.out.println("Operator: -"); }
    | unary_postfix_operator_expr
    ;

unary_postfix_operator_expr
    : other_expr DOUNLE_PLUS                                    { System.out.println("Operator: ++"); }
    | other_expr DOUNLE_MINUS                                   { System.out.println("Operator: --"); }
    | other_expr
    ;

other_expr
    :(LPAR expr[""] RPAR
    | function_call
    | function_pointer
    | primitive_function_call
    | pattern_call
    | IDENTIFIER
    | literal) (list_indexing | function_call)*
    ;

list_indexing
    : LSB expr[""] RSB
    ;

puts
    : PUTS                  { System.out.println("Built-In: PUTS"); }
    LPAR expr[""] RPAR
    ;

push
    : PUSH                  { System.out.println("Built-In: PUSH"); }
    LPAR expr[""] COMMA expr[""] RPAR
    ;

len
    : LEN                   { System.out.println("Built-In: LEN"); }
    LPAR expr[""] RPAR
    ;

chop
    : CHOP                  { System.out.println("Built-In: CHOP"); }
    LPAR expr[""] RPAR
    ;

chomp
    : CHOMP                 { System.out.println("Built-In: CHOMP"); }
    LPAR expr[""] RPAR
    ;

parameters
    : IDENTIFIER ( COMMA IDENTIFIER)* (COMMA default_parameters)?
    | default_parameters?
    ;

default_parameters
    : LSB (default_parameter (COMMA default_parameter)*)? RSB
    ;

default_parameter
    : IDENTIFIER ASSIGN value_literal
    ;

arguments
    : (expr[""] (COMMA expr[""])*)?
    ;

range
    : LPAR (INTEGER | IDENTIFIER) DOUBLE_DOT (INTEGER | IDENTIFIER)  RPAR
    ;

list
    : LSB (expr[""] (COMMA expr[""])*)? RSB
    ;

value_list
    : LSB (value (COMMA value)*)? RSB
    ;

value
    : INTEGER
    | FLOAT
    | STRING
    |boolean
    ;

value_literal
    : INTEGER
    | FLOAT
    | STRING
    | boolean
    | value_list
    ;

boolean
    : TRUE
    | FALSE
    ;

LPAR: '(';
RPAR: ')';
LSB: '[';
RSB: ']';
LCB: '{';
RCB: '}';
DQUATE: '"';
RARROW: '->';
COLON: ':';
SEMICOLON: ';';
COMMA: ',';

DEF: 'def';
END : 'end';
MAIN: 'main';
RETURN: 'return';
IF: 'if';
ELSE : 'else';
ELSEIF : 'elseif';
TRUE : 'true';
FALSE : 'false';
CHOP : 'chop';
CHOMP  : 'chomp';
PUSH : 'push';
PUTS : 'puts';
METHOD : 'method';
LEN: 'len';
PATTERN : 'pattern';
MATCH : 'match';
NEXT: 'next'    ;
BREAK : 'break';
LOOP : 'loop';
DO : 'do';
FOR : 'for';
IN : 'in';

PLUS: '+';
MINUS: '-';
MULTIPLY: '*';
DIVIDE: '/';
REMAINDER: '%';
DOUNLE_MINUS : '--';
DOUNLE_PLUS: '++';
ASSIGN: '=';
GREATER_THAN: '>';
LESS_THAN: '<';
LESS_EQUAL: '<=';
GREATER_EQUAL: '>=';
AND: '&&';
OR: '||';
NOT: '!';
DOUBLE_DOT: '..';
SINGLE_DOT: '.';

APPEND: '<<';
PLUS_EQUAL: '+=';
MINUS_EQUAL: '-=';
MULTIPLY_EQUAL: '*=';
DIVIDE_EQUAL :  '/=';
REMAINDER_EQUAL: '%=';
EQUAL: '==';
NOT_EQUAL: '!=';

IDENTIFIER: [A-Za-z_][A-Za-z_0-9]*;
FLOAT:  ([1-9][0-9]* | '0') '.' ([0-9]+);
INTEGER: [1-9][0-9]* | '0';
STRING : '"' (~'"')* '"';
PATTERN_CONDITION: ('\n'|'\r\n') ('    ' | '\t') '|';

MULTILINE_COMMENT: '=begin' .*? '=end' -> skip;
SINGLELINE_COMMENT : '#' ~[\r\n]* -> skip ;

WS: [ \t\r\n]+ -> skip;
