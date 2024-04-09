grammar FunctionCraft;







comment 
    : oneline_comment 
    | multiline_comment
    ;

multiline_comment
    : BEGIN_COMMENT (~END_COMMENT)* END_COMMENT
    ; 

oneline_comment
    : HASH (~'\n')* '\n'
    ;

boolean
    : TRUE
    | FALSE
    ;

function_pointer
    : METHOD LCB COLON IDENTIFIER RCB
    ;

parameters
    : IDENTIFIER(,IDENTIFIER)*
    ;

BEGIN_COMMENT
    : '=begin'
    ;

END_COMMENT
    : '=end'
    ;

IDENTIFIER
    : [A-Za-z][A-Za-z0-9]*
    ;

FLOAT
    :  ([1-9][0-9]* | 0) '.' ([0-9]+)
    ;

INTEGER
    : [1-9][0-9]* | 0
    ;

STRING 
    : '"' (~'"')* '"'
    ;
    
LPAR
    : '('
    ;

RPAR
    : ')'
    ;

LSB
    : '['
    ;

RSB
    : ']'
    ;

LCB
    : '{'
    ;

RCB
    : '}'
    ;

DQUATE
    : '"'
    ;

RARROW
    : '->'
    ;

COLON
    : ':'
    ;

HASH
    : '#'
    ;

SEMICOLON
    : ';'
    ;

DEF
    : 'def'
    ;

END 
    : 'end'
    ;

MAIN
    : 'main'
    ;

RETURN
    : 'return'
    ;
IF
    : 'if'
    ;

ELSE 
    : 'else'
    ;

ELSEIF 
    : 'elseif'
    ;

TRUE 
    : 'true'
    ;

FALSE 
    : 'false'
    ;

CHOP 
    : 'chop'
    ;

CHOMP  
    : 'chomp'
    ;

PUSH 
    : 'push'
    ;

PUTS 
    : 'puts'
    ;

METHOD 
    : 'method'
    ;

LEN
    : 'len'
    ;
    
PATTERN 
    : 'pattern'
    ;

MATCH 
    : 'match'
    ;
    
NEXT
    : 'next'    
    ;

BREAK 
    : 'break'
    ;

LOOP 
    : 'loop'
    ;

DO 
    : 'do'
    ;

FOR 
    : 'for'
    ;

IN 
    : 'in'
    ;      

PLUS
    : '+'
    ;

MINUS
    : '-'
    ;

MULTIPLY
    : '*'
    ;

DIVIDE
    : '/'
    ;

DOUNLE_MINUS 
    : '--'
    ;

DOUNLE_PLUS
    : '++'
    ;

ASSIGN
    : '='
    ;

GREATER_THAN
    : '>'
    ;

LESS_THAN
    : '<'
    ;

LESS_EQUAL
    : '<='
    ;

GREATER_EQUAL
    : '>='
    ;

AND
    : '&&'
    ;

OR
    : '||'
    ;

NOT
    : '!'
    ;

APPEND
    : '<<'
    ;

PLUS_EQUAL
    : '+='
    ;

MINUS_EQUAL
    : '-='
    ;

MULTIPLY_EQUAL
    : '*='
    ;

DIVIDE_EQUAL 
    :  '/='
    ;

REMAINDER
    : '%='
    ;

EQUAL
    : '=='
    ;

NOT_EQUAL
    : '!='
    ;


