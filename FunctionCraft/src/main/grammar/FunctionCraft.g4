grammar FunctionCraft;


program
    : (function | pattern_matching)* main
    ;

main
    : DEF MAIN { System.out.println("MAIN");}
     LPAR RPAR block END
    ;

function
    : function_prototype block END
    ;

function_prototype
    : DEF (name = IDENTIFIER )  { System.out.println($name.text);}
     LPAR parameters RPAR
    ;

block
    : statement* return_statement?
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

for_statement
    : FOR IDENTIFIER IN (list | range) loop_body END
    ;

loop_body
    : (statement | jump_statement)* return_statement?
    ;

assignment
    : IDENTIFIER ASSIGN expr
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
    : RARROW LPAR parameters RPAR LCB block RCB
    ;

function_call
    : (IDENTIFIER | lambda_function) LPAR arguments RPAR
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
    : or_expr APPEND append_expr
    | or_expr
    ;

or_expr
    : LPAR or_expr RPAR OR LPAR or_expr RPAR 
    | and_expr
    ;

and_expr
    : LPAR and_expr RPAR AND LPAR and_expr RPAR
    | eq_expr
    ;

eq_expr
    : comp_expr (EQUAL | NOT_EQUAL) eq_expr
    | comp_expr
    ;

comp_expr
    : plus_minus_expr 
    (GREATER_THAN | LESS_THAN | LESS_EQUAL |GREATER_EQUAL) 
    comp_expr
    | plus_minus_expr
    ;

plus_minus_expr
    : divide_mult_expr (PLUS | MINUS) plus_minus_expr 
    | divide_mult_expr
    ;

divide_mult_expr
    : unary_prefix_operator_expr (DIVIDE | MULTIPLY | REMAINDER) divide_mult_expr
    | unary_prefix_operator_expr
    ;

unary_prefix_operator_expr
    : NOT LPAR unary_postfix_operator_expr RPAR
    | MINUS unary_postfix_operator_expr
    | unary_postfix_operator_expr
    ;

unary_postfix_operator_expr
    : other_expr (DOUNLE_PLUS | DOUNLE_MINUS)
    ;

other_expr
    :(LPAR expr RPAR
    | function_call
    | function_pointer
    | pattern_call
    | lambda_function
    | IDENTIFIER) list_access
    | literal
    ;

list_access
    : LSB expr RSB
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
    : (expr (COMMA expr)*)?
    ;

range
    : LPAR (INTEGER | IDENTIFIER) DOUBLE_DOT (INTEGER RPAR | IDENTIFIER)  RPAR
    ;

list
    : LSB (expr (COMMA expr)*)? RSB
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
PATTERN_CONDITION: '    |' | [\t]'|';

MULTILINE_COMMENT: '=begin' .*? '=end' -> skip;
SINGLELINE_COMMENT : '#' ~[\r\n]* -> skip ;

WS: [ \t\r\n]+ -> skip;
