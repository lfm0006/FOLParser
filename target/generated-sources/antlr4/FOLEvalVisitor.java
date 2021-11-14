import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

public class FOLEvalVisitor extends FOLBaseVisitor<Boolean> {
	
	public boolean test;
	FOLTree folTree;
	public boolean hasQuantifier = false;
	
	FOLEvalVisitor(boolean test, FOLTree folTree) {
		this.test = test;
		this.folTree = folTree;
	}

	@Override
	public Boolean visit(ParseTree tree) {
		// First, we must know which constants are in the sentence
		FOLEvalConstants folConst = new FOLEvalConstants(test, folTree);
		folConst.visit(tree);
		// Now, we can call the main visit
		super.visit(tree);
		return true;
	}
	
	@Override 
	public Boolean visitSentenceClause(@NotNull FOLParser.SentenceClauseContext ctx) {
		return visitChildren(ctx); 
	}

	@Override 
	public Boolean visitFormulaClause(@NotNull FOLParser.FormulaClauseContext ctx) {
		String f = ctx.getText();
		//memory.put(f,  test);
		folTree.setRoot(new FOLAtom(f, test));
		//System.out.println(memory);
		return visitChildren(ctx);
	}

	
	@Override
	public Boolean visitRelationClause(@NotNull FOLParser.RelationClauseContext ctx) {
		String formula = ctx.getText();
		// Last node is a relation (true)
		folTree.searchAndUpdate(new FOLAtom(formula, true));
		if(hasQuantifier) {
			folTree.clearVisited();
			String parent = ctx.getParent().getText();
			String s = ctx.relationSymb().getText();
			FOLAtom fparent = new FOLAtom(parent, false); // doens't matter know the value before the search, only the string
			FOLTree.Node node = folTree.search(fparent);
			//if(folTree.memory.get(s).size() > 0) {
			//	for(int i=0; i<folTree.memory.get(s).size(); i++) {
			//		String c = folTree.memory.get(s).get(i);
			//		folTree.add(node, formula, true, s + "(" + c + ")", true, "left");
			//	}
			//}
			/* if(formula.contains("?")) {
				if(folTree.memory.get(s).size() > 0) {
					// There is constants, so it will use them
					for(Integer j : folTree.memory.get(s).keySet()) { // Search constant for relation
						String cons = formula.replace(ctx.term(0).getText(), folTree.memory.get(s).get(j));
						folTree.add(node, formula, true, cons, true, "left", FOLAtom.FORALL);
						break;
					}
				} else {
					// There is no constants, it must peek from constants queue available
					String cons = formula.replace(s, folTree.queue.poll());  
					folTree.add(node, formula, true, cons, true, "left", FOLAtom.FORALL);
				}
			} */
		}
		return visitChildren(ctx);
	}
	
	@Override 
	public Boolean visitNegationClause(@NotNull FOLParser.NegationClauseContext ctx) {
		String formula = ctx.formula().getText();
		String parent = ctx.getText(); 
		folTree.clearVisited();
		FOLTree.Node node = null;
		do {
			FOLAtom fparent = new FOLAtom(parent, false); // doens't matter know the value before the search, it's only based on the string
			node = folTree.search(fparent);
			if(node != null) {
				boolean v = node.value.value; // the real value of the clause
				if(v) {
					// true
					//memory.put(formula, false); // ~value
					folTree.add(node, ctx.getText(), true, ctx.formula().getText(), false, "left");
				} else {
					// false
					//memory.put(formula, true); // ~value
					folTree.add(node, ctx.getText(), true, ctx.formula().getText(), true, "left");
				}
			}
		} while(node != null);
		//System.out.println(memory);
		return visitChildren(ctx); 
	}

	@Override 
	public Boolean visitConnectiveClause(@NotNull FOLParser.ConnectiveClauseContext ctx) { 
		String formula = ctx.getText();
		String parent = ctx.getParent().getText();
		if(ctx.op.getType() == FOLParser.AND) {
			//if(memory.containsKey(formula)) {
			folTree.clearVisited();
			FOLTree.Node node = null;
			do {
				FOLAtom fparent = new FOLAtom(parent, false); // doens't matter know the value before the search, it's only based on the string
				node = folTree.search(fparent);
				if(node != null) {
					boolean v = node.value.value; // the real value of the clause
					if(v) {
						// true
						//memory.put(ctx.formula(0).getText(), true);
						//memory.put(ctx.formula(1).getText(), true);
						folTree.add(node, parent, true, ctx.formula(0).getText(), true, "left");
						folTree.add(node, parent, true, ctx.formula(1).getText(), true, "left");
					} else { 
						// false
						//memory.put(ctx.formula(0).getText(), false);
						//memory.put(ctx.formula(1).getText(), false);
						folTree.add(node, parent, true, ctx.formula(0).getText(), false, "left");
						folTree.add(node, parent, true, ctx.formula(1).getText(), false, "right");
					}	
				}
			} while(node != null);
		} else
		if(ctx.op.getType() == FOLParser.OR) {
			folTree.clearVisited();
			FOLTree.Node node = null;
			do {
				FOLAtom fparent = new FOLAtom(parent, false); // doens't matter know the value before the search, it's only based on the string
				node = folTree.search(fparent);
				if(node != null) {
					boolean v = node.value.value; // the real value of the clause
					if(v) {
						// true
						//memory.put(ctx.formula(0).getText(), true);
						//memory.put(ctx.formula(1).getText(), true);
						folTree.add(node, parent, true, ctx.formula(0).getText(), true, "left");
						folTree.add(node, parent, true, ctx.formula(1).getText(), true, "right");
					} else {
						// false
						//memory.put(ctx.formula(0).getText(), false);
						//memory.put(ctx.formula(1).getText(), false);
						folTree.add(node, parent, true, ctx.formula(0).getText(), false, "left");
						folTree.add(node, parent, true, ctx.formula(1).getText(), false, "left");
					}
				}
			} while(node != null);
		} else
		if(ctx.op.getType() == FOLParser.IMPLY) {
			folTree.clearVisited();
			FOLTree.Node node = null;
			do {
				FOLAtom fparent = new FOLAtom(parent, false); // doens't matter know the value before the search, it's only based on the string
				node = folTree.search(fparent);
				if(node != null) {
					boolean v = node.value.value; // the real value of the clause
					if(v) {
						// true
						//memory.put(ctx.formula(0).getText(), false);
						//memory.put(ctx.formula(1).getText(), true);
						folTree.add(node, parent, true, ctx.formula(0).getText(), false, "left");
						folTree.add(node, parent, true, ctx.formula(1).getText(), true, "right");
					} else {
						// false
						//memory.put(ctx.formula(0).getText(), true);
						//memory.put(ctx.formula(1).getText(), false);
						folTree.add(node, parent, true, ctx.formula(0).getText(), true, "left");
						folTree.add(node, parent, true, ctx.formula(1).getText(), false, "left");
					}
				}
			} while(node != null);
		} else 
		if(ctx.op.getType() == FOLParser.BICOND) {
			folTree.clearVisited();
			FOLTree.Node node = null;
			do {
				FOLAtom fparent = new FOLAtom(parent, false); // doens't matter know the value before the search, it's only based on the string
				node = folTree.search(fparent);
				if(node != null) {
					boolean v = node.value.value; // the real value of the clause
					if(v) {
						// true
						//memory.put(ctx.formula(0).getText(), true);
						//memory.put(ctx.formula(1).getText(), false);
						folTree.add(node, parent, true, ctx.formula(0).getText(), true, "left");
						folTree.add(node, parent, true, ctx.formula(0).getText(), false, "right");
						folTree.add(node, parent, true, ctx.formula(1).getText(), true, "left", "bicond");
					} else {
						// false
						//memory.put(ctx.formula(0).getText(), true);
						//memory.put(ctx.formula(1).getText(), false);
						folTree.add(node, parent, true, ctx.formula(0).getText(), true, "left");
						folTree.add(node, parent, true, ctx.formula(0).getText(), false, "right");
						folTree.add(node, parent, true, ctx.formula(1).getText(), false, "left", "bicond");
					}
				}
			} while(node != null);
		}  
		//System.out.println(memory);
		return visitChildren(ctx);
	}

	@Override 
	public Boolean visitParensClause(@NotNull FOLParser.ParensClauseContext ctx) {
		return visitChildren(ctx); 
	}
	
	@Override 
	public Boolean visitConstantSymb(@NotNull FOLParser.ConstantSymbContext ctx) {
		return visitChildren(ctx); 
	}

	@Override 
	public Boolean visitQuantifierClause(@NotNull FOLParser.QuantifierClauseContext ctx) {
		hasQuantifier = true;
		String formula = ctx.getText();
		if(ctx.qop.getType() == FOLParser.FORALL) {
			folTree.clearVisited();
			FOLTree.Node node = null;
			do {
				// it doesn't matter to know the value before the search, only the string
				FOLAtom fformula = new FOLAtom(formula, false); 
				node = folTree.search(fformula);
				if(node != null) {
					node.value.quantifier = FOLAtom.FORALL;
					boolean v = node.value.value; // the real boolean value of the clause
					if(v) {
						// universal true
						/* String r = ctx.formula().getText();
						for(Integer i : folTree.memvar.keySet()) { // For all variables
							if(formula.contains(folTree.memvar.get(i))) { // If formula contains such variable... 
								for(String rkey : folTree.memory.keySet()) { // Search relation
									if(folTree.memory.get(rkey).size() > 0) {
										// There is constants, so it will use them
										for(Integer j : folTree.memory.get(rkey).keySet()) { // Search constant for relation
											String cons = r.replace(folTree.memvar.get(i), folTree.memory.get(rkey).get(j));
											folTree.add(node, formula, true, cons, true, "left", FOLAtom.FORALL);
											break;
										}
									} else {
										// There is no constants, it must peek from constants queue available
										String cons = r.replace(folTree.memvar.get(i), folTree.queue.poll());  
										folTree.add(node, formula, true, cons, true, "left", FOLAtom.FORALL);
										break;
									}
								}
							}
						} */
						folTree.add(node, formula, true, ctx.formula().getText(), true, "left", FOLAtom.FORALL);
					} else {
						// false
						folTree.add(node, formula, true, ctx.formula().getText(), false, "left", FOLAtom.FORALL);
					}
				}
			} while(node != null);
		} else if(ctx.qop.getType() == FOLParser.EXISTS) {
			folTree.clearVisited();
			FOLTree.Node node = null;
			do {
				// it doesn't matter to know the value before the search, only the string
				FOLAtom fformula = new FOLAtom(formula, false); 
				node = folTree.search(fformula);
				if(node != null) {
					node.value.quantifier = FOLAtom.EXISTS;
					boolean v = node.value.value; // the real boolean value of the clause
					if(v) {
						// true
						folTree.add(node, formula, true, ctx.formula().getText(), true, "left", FOLAtom.EXISTS);
					} else {
						// false
						folTree.add(node, formula, true, ctx.formula().getText(), false, "left", FOLAtom.EXISTS);
					}
				}
			} while(node != null);
		}
		return visitChildren(ctx); 
	}

}
