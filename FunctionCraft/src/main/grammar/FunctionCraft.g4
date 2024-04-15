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
    : DEF (name = IDENTIFIER )      { System.out.println("FuncDec:" + $name.text); }
     LPAR parameters RPAR
    ;

block
    : statement* return_statement?
    ;

return_statement
    : RETURN { System.out.println("RETURN"); } expr? SEMICOLON
    ;

pattern_matching
    : PATTERN (name = IDENTIFIER)   { System.out.println("PatternDec:" + $name.text); }
     LPAR parameters RPAR pattern_body SEMICOLON
    ;

pattern_body
    : (PATTERN_CONDITION condition ASSIGN expr)+
    ;

pattern_call
    : IDENTIFIER SINGLE_DOT MATCH LPAR arguments RPAR
    ;

statement
    : if_statement
    | loop_statement
    | for_statement
    | (pattern_call | function_call | assignment | expr) SEMICOLON
    ;

if_statement
    : IF                            { System.out.println("Desicion: IF"); }
    condition               
    block
    elseif_statement*       
    else_statement?
    END
    ;

elseif_statement
    : ELSEIF                        { System.out.println("Desicion: ELSE IF"); }
    condition
    block
    ;

else_statement
    : ELSE                          { System.out.println("Desicion: ELSE"); }
    block
    ;

loop_statement
    : LOOP DO                       { System.out.println("Loop: DO"); }
    loop_body END
    ;

for_statement
    : FOR                           { System.out.println("Loop: FOR"); }
    IDENTIFIER IN (list | range) loop_body END
    ;

loop_body
    : (statement | jump_statement)* return_statement?
    ;

assignment
    : (name = IDENTIFIER)           { System.out.println("Assignment: " + $name.text); }
    (ASSIGN | MINUS_EQUAL | MULTIPLY_EQUAL | DIVIDE_EQUAL | REMAINDER_EQUAL | PLUS_EQUAL)
     expr
    ;

literal
    : INTEGER
    | FLOAT
    | STRING
    | boolean
    | list
    ;

jump_statement
    : break                 { System.out.println("Control: BREAK"); }
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
    : RARROW                { System.out.println("Control: BREAK"); }
     LPAR parameters RPAR LCB block RCB
    ;

function_call
    : (IDENTIFIER | function_pointer | list_access | lambda_function )          { System.out.println("FunctionCall"); }
     LPAR arguments RPAR // TODO
    | primitive_function_call
    ;

list_access
    : (lambda_function
    | function_pointer
    | IDENTIFIER
    | IDENTIFIER { System.out.println("FunctionCall"); }
     LPAR arguments RPAR)
     list_indexing inner_list_access
    ;

inner_list_access
    : { System.out.println("FunctionCall"); } LPAR arguments RPAR
    | primitive_function_call list_indexing inner_list_access
    |
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
    : ( NOT? LPAR expr  RPAR) (AND ( NOT? LPAR expr  RPAR))*
    | ( NOT? LPAR expr  RPAR) (OR ( NOT? LPAR expr  RPAR))*
    ;

expr
    : append_expr
    ;

append_expr
    : or_expr APPEND append_expr                                { System.out.println("Operator: <<"); }
    | or_expr
    ;

or_expr
    : LPAR (expr) RPAR OR LPAR (expr) RPAR                      { System.out.println("Operator: ||"); }
    | and_expr
    ;

and_expr
    : LPAR (expr) RPAR AND LPAR (expr) RPAR                     { System.out.println("Operator: &&"); }
    | eq_expr
    ;

eq_expr
    : comp_expr NOT_EQUAL eq_expr                               { System.out.println("Operator: !="); }
    | comp_expr EQUAL eq_expr                                   { System.out.println("Operator: =="); }
    | comp_expr
    ;

comp_expr
    : plus_minus_expr GREATER_THAN  comp_expr                   { System.out.println("Operator: >"); }
    | plus_minus_expr LESS_THAN comp_expr                       { System.out.println("Operator: <"); }
    | plus_minus_expr LESS_EQUAL comp_expr                      { System.out.println("Operator: <="); }
    | plus_minus_expr GREATER_EQUAL comp_expr                   { System.out.println("Operator: >="); }
    | plus_minus_expr
    ;

plus_minus_expr
    : divide_mult_expr PLUS  plus_minus_expr                    { System.out.println("Operator: +"); }
    | divide_mult_expr MINUS plus_minus_expr                    { System.out.println("Operator: -"); }
    | divide_mult_expr
    ;

divide_mult_expr
    : unary_prefix_operator_expr DIVIDE  divide_mult_expr       { System.out.println("Operator: /"); }
    | unary_prefix_operator_expr  MULTIPLY  divide_mult_expr    { System.out.println("Operator: *"); }
    | unary_prefix_operator_expr  REMAINDER divide_mult_expr    { System.out.println("Operator: %"); }
    | unary_prefix_operator_expr
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
    :(LPAR expr RPAR
    | function_call
    | function_pointer
    | pattern_call
    | IDENTIFIER
    | literal) list_indexing?
    ;

list_indexing
    : (LSB expr RSB)+
    ;

puts
    : PUTS                  { System.out.println("Built-In: PUTS"); }
    LPAR expr RPAR
    ;

push
    : PUSH                  { System.out.println("Built-In: PUSH"); }
    LPAR expr COMMA expr RPAR
    ;

len
    : LEN                   { System.out.println("Built-In: LEN"); }
    LPAR expr RPAR
    ;

chop
    : CHOP                  { System.out.println("Built-In: CHOP"); }
    LPAR expr RPAR
    ;

chomp
    : CHOMP                 { System.out.println("Built-In: CHOMP"); }
    LPAR expr RPAR
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
    : (expr (COMMA expr)*)?
    ;

range
    : LPAR (INTEGER | IDENTIFIER) DOUBLE_DOT (INTEGER RPAR | IDENTIFIER)  RPAR
    ;

list
    : LSB (expr (COMMA expr)*)? RSB
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
