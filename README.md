# FOLParser
A parser for first-order logic

FOLParser was developed in Java using ANTLR 4.0. This version is working fine with FOL without quantifiers, although the grammar is prepared to deal with. A test case with 18 propositional formulas was implemented in JUnit, printing in console the formal reasoning using the tableaux method. A graph of each resolution by tableaux is generated using dot (Graphviz).

Some representation features:
- Variables start with underline (e.g. _A, _B, etc)
- Predicate symbols: (e.g _P(#a), _Q(#b), etc)
- Logic operations use the commonplace symbols (AND as &, OR as |, NOT as ~). 
- Logical implication (->)
- Logical equivalence (<->)

<H2>Examples</H2>
For instance, the resolution tableaux for (_A | _B) -> _B  is<BR><BR>
1: (_A|_B)->_B = false (F)<BR>
2:    (_A|_B) = true (F)<BR>
3:       _B = false (T)<BR>
4:          _A = true (T)<BR>
4:          _B = true (T)<BR>
<BR>
The generated graph for this resolution is:<BR>

![image](https://user-images.githubusercontent.com/10674874/141703088-d91629ae-c604-4893-9e99-ce5fa5b3319c.png)

Another example, the resolution tableaux for ((_A -> _Q(#b)) & ~_Q(#b)) -> ~_A is<BR><BR>
  
1: ((_A->_Q(#b))&~_Q(#b))->~_A = false (F)<BR>
2:    ((_A->_Q(#b))&~_Q(#b)) = true (F)<BR>
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


