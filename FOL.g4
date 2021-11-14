/**
 * FOL - Grammar for First-Order Logic
 */
grammar FOL;

prog
	: COMMENT? sentence+ ENDLINE? EOF	# sentenceClause			 
	;

sentence
	: formula 					# formulaClause
	;
	
formula
	: NOT formula 						# negationClause
	| formula op=(BICOND | IMPLY | AND | OR) formula 	# connectiveClause
	| qop=(FORALL  | EXISTS) '(' variable ')' '(' formula ')'		# quantifierClause
	| relationSymb ('(' (term)+ ')')?	# relationClause
	| term '=' term						# equaltyClause
	| value								# valueClause
	| '(' formula ')' 					# parensClause
	;

term
	: functionSymb '(' (term)+ ')' 		# functionClause
	| constantSymb 						# constantClause
	| variable							# variableClause
	;

constantSymb
	: '#'CHARACTER
	;

functionSymb
	: '.'CHARACTER
	;

relationSymb
	: '_'CHARACTER
	;

variable
	: '?'CHARACTER
	;
	
value
	: TRUE | FALSE
	;
		
TRUE
	: [Tt][Rr][Uu][Ee]
	;
FALSE
	: [Ff][Aa][Ll][Ss][Ee]
	;
FORALL
	: [fF][Oo][Rr][Aa][Ll][Ll]
	;
EXISTS
	: [Ee][Xx][Ii][Ss][Tt][Ss]
	;
AND
	: '&'
	;
OR
	: '|'
	;
IMPLY
	: '->'
	;	
BICOND
	: '<->'
	;
NOT
	: '~'
	;

CHARACTER
	: [A-Za-z0-9]+
	;

ENDLINE: ('\r'|'\n')+ -> skip;


WS: [ \t]+ -> skip; 
  
COMMENT 
 	: '//' ~('\t'|'\r'|'\n')*  '\r'? '\n' -> skip
	;

