# FOLParser
A parser for first-order logic reasoning.

The main purpose in developing a first-order logic reasoner involves the modelling of a learning tool, aiming to cover some contents of classical Artificial Intelligence related to the Logic studies. The resolution by tableau method is one of such topics which helps to understand the concepts behind the logical reasoning. To achieve such tool, a parser is needed to analyse the logical expressions and it should be able to interpretate semantically the sentences along the reasoning process. <BR>
FOLParser was developed in Java using the ANTLR 4.0 framework (https://www.antlr.org/). The semantic layer uses the tableau method for resolution. At the moment, this version is working fine with propositional logic and some aspects of FOL, requiring improvements for both universal and existential quantifiers. Some kind of sentences with quantifiers were tested, giving correct results. A test case with 18 propositional formulas was implemented in JUnit, printing in console the formal reasoning using the tableau method. A graph of each resolution by tableau is generated using dot (Graphviz).

Some representation definitions:
- Variables starting with underline (e.g. _A, _B, etc)
- Predicate symbols (e.g. _P(#a), _Q(#b), with constants #a, #b, etc)
- Functions (e.g. _F(?x), _G(?y), with variables ?x, ?y, etc)
- Logic operations use the commonplace symbols (AND as &, OR as |, NOT as ~). 
- Logical implication (->)
- Logical equivalence (<->)
- Quantifiers (FORALL and EXISTS)

A FOL endpoint using the parser is available <A HREF="http://professorfrontino.com.br/fol/" TARGET=_blank>here</A>.

<HR>
<H2>Versions</H2>
1.01 - 16/11/2021<BR>
Printing of sentences and resolution by tableaux in LaTex is also available.<BR>
<HR>
<H2>Examples</H2>
<B>(_A | _B) -> _B</B><BR><BR>
1: (_A|_B)->_B = false (F)<BR>
2:    (_A|_B) = true (F)<BR>
3:       _B = false (T)<BR>
4:          _A = true (T)<BR>
4:          _B = true (T)<BR>
<BR>

LaTex:<BR>
![image](https://user-images.githubusercontent.com/10674874/142086989-8ef32142-1fc8-44bc-8ee5-c656c20c2d7f.png)


The generated graph for this resolution is:<BR>

![image](https://user-images.githubusercontent.com/10674874/141703088-d91629ae-c604-4893-9e99-ce5fa5b3319c.png)
<HR>
<B>((_A -> _Q(#b)) & ~_Q(#b)) -> ~_A</B><BR><BR>
  
1: ((_A->_Q(#b))\&\~_Q(#b))->~_A = false (F)<BR>
2:    ((_A->_Q(#b))\&\~_Q(#b)) = true (F)<BR>
3:       ~_A = false (F)<BR>
4:          (_A->_Q(#b)) = true (F)<BR>
5:             ~_Q(#b) = true (F)<BR>
6:                _A = false (T)<BR>
7:                   _Q(#b) = false (T)<BR>
8:                      _A = true (T)<BR>
6:                _Q(#b) = true (T)<BR>
7:                   _Q(#b) = false (T)<BR>
8:                      _A = true (T)<BR>
<BR>
 
![image](https://user-images.githubusercontent.com/10674874/141703746-11a6fe17-77df-403d-8c54-b15756042cd7.png)
<HR>
<B>FORALL(?x)(_F(?x)->_G(?x)) -> _F(#a)</B><BR><BR>
  
1: FORALL(?x)(_F(?x)->_G(?x))->_F(#a) = false (F)<BR>
2:    FORALL(?x)(_F(?x)->_G(?x)) = true (F)<BR>
3:       _F(#a) = false (T)<BR>
4:          _F(?x)->_G(?x) = true (F)<BR>
5:             _F(?x) = false (T)<BR>
5:             _G(?x) = true (T)<BR>
  

![image](https://user-images.githubusercontent.com/10674874/141704307-b132c12c-0106-4b2d-9a87-84c210c06d48.png)
<HR>
<B>FORALL(?x)(_A(?x) & _B(?x)) -> (FORALL(?x)(_A(?x)) & FORALL(?x)(_B(?x)))</B><BR><BR>

1: FORALL(?x)(_A(?x)&_B(?x))->(FORALL(?x)(_A(?x))&FORALL(?x)(_B(?x))) = false (F)<BR>
2:    FORALL(?x)(_A(?x)&_B(?x)) = true (F)<BR>
3:       (FORALL(?x)(_A(?x))&FORALL(?x)(_B(?x))) = false (F)<BR>
4:          _A(?x)&_B(?x) = true (F)<BR>
5:             _A(?x) = true (T)<BR>
6:                _B(?x) = true (T)<BR>
7:                   FORALL(?x)(_A(?x)) = false (F)<BR>
8:                      _A(?x) = false (T)<BR>
7:                   FORALL(?x)(_B(?x)) = false (F)<BR>
8:                      _B(?x) = false (T)<BR>

![image](https://user-images.githubusercontent.com/10674874/141704472-d02cd57b-c894-4bb3-98cb-54c4f01f88fb.png)
<HR>

<B>EXISTS(?y)(FORALL(?x)(_R(?x?y))) -> FORALL(?x)(EXISTS(?y)(_R(?x?y)))</B><BR>
  
1: EXISTS(?y)(FORALL(?x)(_R(?x?y)))->FORALL(?x)(EXISTS(?y)(_R(?x?y))) = false (F)<BR>
2:    EXISTS(?y)(FORALL(?x)(_R(?x?y))) = true (F)<BR>
3:       FORALL(?x)(EXISTS(?y)(_R(?x?y))) = false (F)<BR>
4:          FORALL(?x)(_R(?x?y)) = true (F)<BR>
5:             _R(?x?y) = true (T)<BR>
6:                EXISTS(?y)(_R(?x?y)) = false (F)<BR>
7:                   _R(?x?y) = false (T)<BR>
  
![image](https://user-images.githubusercontent.com/10674874/141704597-e9bbbb8c-bb63-4b68-9a44-93a0ccf8bfbd.png)

Obs.: Test cases were based on the sentences of Mortari's book (2001), exercise 12.1.<BR><BR>
  
<H2>References</H2>
MORTARI, C. A. Introdu????o ?? L??gica (Introduction to Logic). S. Paulo: Ed. UNESP, 2001 (Published in portuguese).<BR>
PARR, T. The Definitive ANTLR 4 Reference. Dallas, Texas: The Pragmatic Programmers, LLC, 2012. <BR>
RUSSELL, S.; NORVIG, P. Intelig??ncia Artificial (Artificial Intelligence). R. de Janeiro: Elsevier, 2004.<BR>
<BR>

(Author: Luciano F. de Medeiros)
