# FOLParser
A parser for first-order logic

FOLParser was developed in Java using ANTLR 4.0. This version is working fine with FOL, requiring improvements for both universal and existential quantifiers. Some sentences using quantifiers were tested, giving correct results. A test case with 18 propositional formulas was implemented in JUnit, printing in console the formal reasoning using the tableaux method. A graph of each resolution by tableaux is generated using dot (Graphviz).

Some representation features:
- Variables start with underline (e.g. _A, _B, etc)
- Predicate symbols (e.g. _P(#a), _Q(#b), with constants #a, #b, etc)
- Functions (e.g. _F(?x), _G(?y), with variables ?x, ?y, etc)
- Logic operations use the commonplace symbols (AND as &, OR as |, NOT as ~). 
- Logical implication (->)
- Logical equivalence (<->)
- Quantifiers (FORALL and EXISTS)

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

<B>FORALL(?x)(_F(?x)->_G(?x)) -> _F(#a)</B><BR>
  
1: FORALL(?x)(_F(?x)->_G(?x))->_F(#a) = false (F)<BR>
2:    FORALL(?x)(_F(?x)->_G(?x)) = true (F)<BR>
3:       _F(#a) = false (T)<BR>
4:          _F(?x)->_G(?x) = true (F)<BR>
5:             _F(?x) = false (T)<BR>
5:             _G(?x) = true (T)<BR>
  
![image](https://user-images.githubusercontent.com/10674874/141704307-b132c12c-0106-4b2d-9a87-84c210c06d48.png)


  
