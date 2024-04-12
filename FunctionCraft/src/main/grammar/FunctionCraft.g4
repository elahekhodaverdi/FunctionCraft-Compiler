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
    : block return_statement
    ;

return_statement
    : RETURN value SEMICOLON
    ;

pattern_matching
    : PATTERN IDENTIFIER LPAR parameters RPAR pattern_body SEMICOLON
    ;

pattern_body
    : (PATTERN_CONDITION condition ASSIGN value)+
    ;

block
    : statement*
    ;

statement
    : if_statement
    | loop_statement
    | for_statement
    | function_call
    | assignment
    | jump_statement
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

condition
    : LPAR (condition | (value rational_operator value)) RPAR (logical_operator condition)?
    ;

logical_operator
    : AND
    | OR
    ;

rational_operator
    : LESS_THAN
    | LESS_EQUAL
    | GREATER_THAN
    | GREATER_EQUAL
    | EQUAL
    | NOT_EQUAL
    ;

loop_statement
    : LOOP DO block END
    ;

for_statement
    : FOR IDENTIFIER IN (list | range) block END
    ;

assignment
    : IDENTIFIER ASSIGN value SEMICOLON
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

puts
    : PUTS LPAR value RPAR
    ;

push
    : PUSH LPAR value COMMA value RPAR
    ;

len
    : LEN LPAR value RPAR
    ;

chop
    : CHOP LPAR value RPAR
    ;

chomp
    : CHOMP LPAR value RPAR
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

