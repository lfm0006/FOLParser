# FOLParser
A parser for first-order logic

FOLParser was developed in Java using ANTLR 4.0. This version is working fine with FOL without quantifiers, although the grammar is prepared to deal with. A test case with 18 propositional formulas was implemented in JUnit, printing in console the formal reasoning using the tableaux method. A graph of the tableaux is generated using dot (Graphviz).   

Some representation features:
- Variables start with underline (e.g. _A, _B, etc)
- Logic operations use the commonplace symbols (AND as &, OR as |, NOT as ~). 
- Logical implication (->)
- Logical equivalence (<->)

<H2>Example</H2>
For instance, the resolution tableaux for (_A | _B) -> _B  is
1: (_A|_B)->_B = false (F)<BR>
2:    (_A|_B) = true (F)<BR>

3:       _B = false (T)

4:          _A = true (T)

4:          _B = true (T)


