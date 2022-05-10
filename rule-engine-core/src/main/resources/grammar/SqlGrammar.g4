grammar SqlGrammar;

//keywords, comparisons, and other tokens

OR_		: 'OR' | 'or' ;
AND_	: 'AND' | 'and' ;
NOT_	: 'NOT' | 'not' ;
IN_		: 'IN' | 'in' ;
HAS_	: 'HAS' | 'has' | 'CONTAINS' | 'contains' ;
LIKE_	: 'LIKE' | 'like' ;
GT_		: '>';
LT_		: '<';
GE_		: '>=';
LE_		: '<=';
NE_		: '<>';
EQ_		: '=';

LP_		: '(' ;
RP_		: ')' ;

TRUE_		: 'TRUE' | 'true' ;
FALSE_		: 'FALSE' | 'false' ;
NULL_		: 'NULL' | 'null' ;

IDENTIFIER
	: ([a-zA-Z]|'_') ([a-zA-Z0-9]|'_'|'.')*
	| '`' ( ~'`' )+ '`'
	;
	
columnName
	: IDENTIFIER
	| '#' IDENTIFIER '#'
	| funcCall
	;
	
fragment DIGIT : [0-9] ;

ISO_DATE
	: 'ISO_DATE' '(' DIGIT DIGIT DIGIT DIGIT  '-' DIGIT DIGIT '-' DIGIT DIGIT ')'
	;
	
ISO_DATE_TIME
	: 'ISO_DATE_TIME' '('DIGIT DIGIT DIGIT DIGIT  '-' DIGIT DIGIT '-' DIGIT DIGIT 'T' DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ')'
	;
	
Number
	: DIGIT+ ('.' DIGIT+)?
	;

String
	: '\'' ( ~'\'' )* '\''
	;

COMMA : ',' ;

DOT : '.' ;

literalValue
	: ISO_DATE | ISO_DATE_TIME | Number | String | TRUE_ | FALSE_ | NULL_
	;
	

//Restriction is on expression followed by nothing
restriction
	: expr EOF
	;
	
// Expression is a sequence of one or more tems connected by OR
expr
	: logicalTerm ( OR_ logicalTerm )*
	;
	
// Term is a sequence of one or more factors connected by AND
logicalTerm
	: logicalFactor ( AND_ logicalFactor )*
	;

// Factor is an optional NOT followed by a predicate
logicalFactor
	: ( NOT_ )? predicate
	;

// Predicate is a col in (...) or col like 'regex' or x <compared to> y, or an expression surrounded by parenthesis
predicate
	: inList
	| like
	| has
	| comparison
	| TRUE_
	| FALSE_
	| validation
	| '(' expr ')'
	;
	
inList
	: columnName IN_ LP_ literalValue ( ',' literalValue )* RP_
	;
	
like
	: columnName LIKE_ String
	;


has
	: columnName HAS_ String
	;
	
comparison
	: columnName GT_ literalValue
	| columnName LT_ literalValue
	| columnName GE_ literalValue
	| columnName LE_ literalValue
	| columnName NE_ literalValue
	| columnName EQ_ literalValue
	;
	
validation
	: IDENTIFIER ( LP_ argList RP_ )
	| IDENTIFIER ( LP_ RP_ )
	;

funcCall
	: IDENTIFIER ( LP_ argList RP_ )
	| IDENTIFIER ( LP_ RP_ )
	;
	
argList
	: methodArg
	  ( COMMA methodArg ) *
	;
	
methodArg
	: literalValue
	| objectProperty
	;
	
objectProperty
	: IDENTIFIER
	 ( DOT IDENTIFIER ) *
	;
	
SPACE : ' ' -> channel(HIDDEN) ;
WHITESPACES : '\n\r\t' -> channel(HIDDEN) ;