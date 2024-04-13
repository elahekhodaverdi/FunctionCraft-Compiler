grammar FunctionCraft;


program
    : (function | pattern_matching)* main
    ;

main
    : DEF MAIN LPAR RPAR function_body END
    ;

function
    : function_prototype function_body END
    ;

function_prototype
    : DEF IDENTIFIER LPAR parameters RPAR
    ;

function_body
    : block return_statement?
    ;

return_statement
    : RETURN expr? SEMICOLON
    ;

pattern_matching
    : PATTERN IDENTIFIER LPAR parameters RPAR pattern_body SEMICOLON
    ;

pattern_body
    : (PATTERN_CONDITION condition ASSIGN expr)+
    ;

pattern_call
    : IDENTIFIER SINGLE_DOT MATCH LPAR parameters RPAR
    ;

block
    : statement*
    ;

statement
    : if_statement
    | loop_statement
    | for_statement
    | (pattern_call | function_call | assignment | expr) SEMICOLON
    ;

if_statement
    : IF condition block elseif_statement* else_statement? END
    ;

elseif_statement
    : ELSEIF condition block
    ;

else_statement
    : ELSE block
    ;

loop_statement
    : LOOP DO loop_body END
    ;

loop_body   
    : (statement | jump_statement)*
    ;

for_statement
    : FOR IDENTIFIER IN (list | range) loop_body END
    ;

assignment
    : IDENTIFIER ASSIGN expr
    ;

value
    : literal
    | function_call
    | lambda_function
    | function_pointer
    | IDENTIFIER
    | condition
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
    : BREAK SEMICOLON
    ;

next
    : NEXT SEMICOLON
    ;

break_if
    : BREAK IF condition SEMICOLON
    ;

next_if
    : NEXT IF condition SEMICOLON
    ;

lambda_function
    : RARROW LPAR parameters RPAR LCB function_body RCB
    ;

function_call
    : IDENTIFIER LPAR arguments RPAR
    | primitive_function_call
    ;

function_pointer
    : METHOD LPAR COLON IDENTIFIER RPAR
    ;

primitive_function_call
    : puts
    | push
    | len
    | chop
    | chomp
    ;

condition
    : ( NOT? LPAR expr  RPAR) (AND ( NOT? LPAR expr  RPAR))*
    | ( NOT? LPAR expr  RPAR) (OR ( NOT? LPAR expr  RPAR))*
    ;

expr
    : append_expr
    ;

append_expr
    : or_expr append_expr2
    ;

append_expr2
    : APPEND or_expr append_expr2
    |
    ;

or_expr
    : LPAR and_expr RPAR or_expr2
    | and_expr
    ;

or_expr2
    : OR LPAR and_expr RPAR or_expr2
    |
    ;

and_expr
    : LPAR eq_expr RPAR and_expr2
    | eq_expr
    ;

and_expr2
    : AND LPAR and_expr RPAR and_expr2
    |
    ;

eq_expr
    : comp_expr eq_expr2
    ;

eq_expr2
    : EQUAL comp_expr eq_expr2
    : NOT_EQUAL comp_expr eq_expr2
    |
    ;

comp_expr
    : plus_minus_expr comp_expr2
    ;

comp_expr2
    : GREATER_THAN plus_minus_expr comp_expr2
    | LESS_THAN plus_minus_expr comp_expr2
    | LESS_EQUAL  plus_minus_expr comp_expr2
    | GREATER_EQUAL  plus_minus_expr comp_expr2
    |
    ;

plus_minus_expr
    : plus_minus_expr2 divide_mult_expr
    ;

plus_minus_expr2
    : PLUS plus_minus_expr2 divide_mult_expr
    | MINUS plus_minus_expr2 divide_mult_expr
    |
    ;

divide_mult_expr
    : single_operator_prefix_expr divide_mult_expr2
    ;

divide_mult_expr2
    : DIVIDE single_operator_prefix_expr divide_mult_expr2
    | MULT single_operator_prefix_expr divide_mult_expr2
    |
    ;

single_operator_prefix_expr
    : NOT other_expr
    | MINUS other_expr
    | other_expr
    ;

other_expr
    : LPAR expr RPAR
    | function_call
    | pattern_call
    | lambda_function
    | array
    | array_access
    | IDENTIFIER
    | literal
    ;

puts
    : PUTS LPAR expr RPAR
    ;

push
    : PUSH LPAR expr COMMA expr RPAR
    ;

len
    : LEN LPAR expr RPAR
    ;

chop
    : CHOP LPAR expr RPAR
    ;

chomp
    : CHOMP LPAR expr RPAR
    ;

parameters
    : IDENTIFIER ( COMMA IDENTIFIER)* (COMMA default_parameters)?
    | default_parameters?
    ;

default_parameters
    : LSB (default_parameter (COMMA default_parameter)*)? RSB
    ;

default_parameter
    : IDENTIFIER ASSIGN literal
    ;

arguments
    : (value (COMMA value)*)?
    ;

range
    : LPAR (INTEGER | IDENTIFIER) DOUBLE_DOT (INTEGER RPAR | IDENTIFIER)  RPAR
    ;

list
    : LSB (value (COMMA value)*)? RSB
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
REMAINDER: '%=';
EQUAL: '==';
NOT_EQUAL: '!=';

IDENTIFIER: [A-Za-z_][A-Za-z_0-9]*;
FLOAT:  ([1-9][0-9]* | '0') '.' ([0-9]+);
INTEGER: [1-9][0-9]* | '0';
STRING : '"' (~'"')* '"';
PATTERN_CONDITION: '    |' | [\t]'|';

MULTILINE_COMMENT: '=begin' .*? '=end' -> skip;
SINGLELINE_COMMENT : '#' ~[\r\n]* -> skip ;

WS: [ \t\r\n]+ -> skip;
