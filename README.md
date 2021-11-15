# FOLParser
A parser for first-order logic.

FOLParser was developed in Java using ANTLR 4.0. This version is working fine with FOL, requiring improvements for both universal and existential quantifiers. Some sentences using quantifiers were tested, giving correct results. A test case with 18 propositional formulas was implemented in JUnit, printing in console the formal reasoning using the tableaux method. A graph of each resolution by tableaux is generated using dot (Graphviz).

Some representation features:
- Variables start with underline (e.g. _A, _B, etc)
- Predicate symbols (e.g. _P(#a), _Q(#b), with constants #a, #b, etc)
- Functions (e.g. _F(?x), _G(?y), with variables ?x, ?y, etc)
- Logic operations use the commonplace symbols (AND as &, OR as |, NOT as ~). 
- Logical implication (->)
- Logical equivalence (<->)
- Quantifiers (FORALL and EXISTS)
<HR>
<H2>Examples</H2>
<B>(_A | _B) -> _B</B><BR><BR>
1: (_A|_B)->_B = false (F)<BR>
2:    (_A|_B) = true (F)<BR>
3:       _B = false (T)<BR>
4:          _A = true (T)<BR>
4:          _B = true (T)<BR>
<BR>
The generated graph for this resolution is:<BR>

![image](https://user-images.githubusercontent.com/10674874/141703088-d91629ae-c604-4893-9e99-ce5fa5b3319c.png)
<HR>
<B>((_A -> _Q(#b)) & ~_Q(#b)) -> ~_A</B><BR>
  
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
<B>FORALL(?x)(_F(?x)->_G(?x)) -> _F(#a)</B><BR>
  
1: FORALL(?x)(_F(?x)->_G(?x))->_F(#a) = false (F)<BR>
2:    FORALL(?x)(_F(?x)->_G(?x)) = true (F)<BR>
3:       _F(#a) = false (T)<BR>
4:          _F(?x)->_G(?x) = true (F)<BR>
5:             _F(?x) = false (T)<BR>
5:             _G(?x) = true (T)<BR>
 
![image](https://user-images.githubusercontent.com/10674874/141704307-b132c12c-0106-4b2d-9a87-84c210c06d48.png)
<HR>
<B>FORALL(?x)(_A(?x) & _B(?x)) -> (FORALL(?x)(_A(?x)) & FORALL(?x)(_B(?x)))</B><BR>

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



  
