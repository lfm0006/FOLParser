import java.io.File;
import java.util.Set;

import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.OrderedHashSet;

import utils.GraphViz;

public class FOLGraphListener extends FOLBaseListener {
	
	Graph graph = new Graph();
	String currentFormulaName = null;
	String currentParensName = null;
	String currentQuantifierName = null;
	String currentConnectiveName = null;
	String currentRelationName = null;
	String currentNegationName = null;

	String currentConstantName = null;

	@Override public void enterFormulaClause(@NotNull FOLParser.FormulaClauseContext ctx) { 
		System.out.println("formula-enter " + ctx.getText());
		currentFormulaName = ctx.getText();
	}

	@Override public void exitFormulaClause(@NotNull FOLParser.FormulaClauseContext ctx) { 
		System.out.println("formula-exit " + ctx.getText());
		String name = ctx.formula().getText();
		graph.edge(currentFormulaName, name);
	}

	@Override public void enterValueClause(@NotNull FOLParser.ValueClauseContext ctx) { }

	@Override public void exitValueClause(@NotNull FOLParser.ValueClauseContext ctx) { }

	@Override public void enterParensClause(@NotNull FOLParser.ParensClauseContext ctx) {
		System.out.println("   parens-enter " + ctx.getText());
		currentParensName = ctx.getText();
	}

	@Override public void exitParensClause(@NotNull FOLParser.ParensClauseContext ctx) {
		System.out.println("   parens-exit " + ctx.formula().getText());
		String name = ctx.formula().getText(); 
		graph.edge(currentParensName, name);
	}

	@Override public void enterQuantifierClause(@NotNull FOLParser.QuantifierClauseContext ctx) {
		System.out.println("   quantifier-enter " + ctx.getText());
		currentQuantifierName = ctx.getText();
	}

	@Override public void exitQuantifierClause(@NotNull FOLParser.QuantifierClauseContext ctx) {
		System.out.println("   quantifier-exit " + ctx.getText());
		String name = ctx.qop.getText(); 
		graph.edge(currentQuantifierName, name);
		name = ctx.formula().getText(); 
		graph.edge(currentQuantifierName, name);
	}

	@Override public void enterNegationClause(@NotNull FOLParser.NegationClauseContext ctx) {
		System.out.println("   negation-enter " + ctx.getText());
		currentNegationName = ctx.getText();
	}

	@Override public void exitNegationClause(@NotNull FOLParser.NegationClauseContext ctx) {
		System.out.println("   negation-exit " + ctx.formula().getText());
		String name = ctx.formula().getText(); 
		graph.edge(currentNegationName, name);
	}

	@Override public void enterConnectiveClause(@NotNull FOLParser.ConnectiveClauseContext ctx) {
		System.out.println("   connective-enter " + ctx.getText());
		currentConnectiveName = ctx.getText();
	}

	@Override public void exitConnectiveClause(@NotNull FOLParser.ConnectiveClauseContext ctx) {
		System.out.println("   connective-exit " + ctx.formula(0).getText() + " " + ctx.op.getText() + " " + ctx.formula(1).getText());
		String name = ctx.formula(0).getText(); 
		graph.edge(currentConnectiveName, name);
		name = ctx.formula(1).getText(); 
		graph.edge(currentConnectiveName, name);
	}

	@Override public void enterRelationClause(@NotNull FOLParser.RelationClauseContext ctx) {
		//System.out.println("   relation-enter " + ctx.getText());
		//currentRelationName = ctx.getText();
	}

	@Override public void exitRelationClause(@NotNull FOLParser.RelationClauseContext ctx) {
		//System.out.println("   relation-exit " + ctx.getText());
		//String name = null;
		//for(FOLParser.TermContext t : ctx.term()) {
		//	name = t.getText(); 
		//	graph.edge(currentRelationName, name);
		//}
	}

	@Override public void enterEqualtyClause(@NotNull FOLParser.EqualtyClauseContext ctx) { }

	@Override public void exitEqualtyClause(@NotNull FOLParser.EqualtyClauseContext ctx) { }

	@Override public void enterConstantClause(@NotNull FOLParser.ConstantClauseContext ctx) { 
		//System.out.println("      constant-enter " + ctx.getText());
		//currentConstantName = ctx.getText();
	}

	@Override public void exitConstantClause(@NotNull FOLParser.ConstantClauseContext ctx) {
		//System.out.println("      constant-exit " + ctx.getText());
		//String name = ctx.constantSymb().getText(); 
		//graph.edge(currentConstantName, name);
	}
	
	@Override public void enterVariableClause(@NotNull FOLParser.VariableClauseContext ctx) {
		//System.out.println("      variable-enter " + ctx.getText());
		//currentConstantName = ctx.getText();
	}

	@Override public void exitVariableClause(@NotNull FOLParser.VariableClauseContext ctx) {
		//System.out.println("      variable-exit " + ctx.getText());
		//String name = ctx.variable().getText(); 
		//graph.edge(currentConstantName, name);
	}

	static class Graph {
		// I'm using org.antlr.v4.runtime.misc: OrderedHashSet, MultiMap
		Set<String> nodes = new OrderedHashSet<String>(); // list of functions
		MultiMap<String, String> edges = new MultiMap<String, String>();

		GraphViz gv = new GraphViz();

		public void edge(String source, String target) {
			edges.map(source, target);
		}
		
		public String toDOT() {
			StringBuilder buf = new StringBuilder();
			buf.append("digraph G {\n");
			buf.append(" ranksep=.25;\n");
			buf.append(" edge [arrowsize=.5]\n");
			buf.append(" node [shape=ellipse, fontname=\"ArialNarrow\",\n");
			buf.append(" fontsize=12, fixedsize=false, height=.45];\n");
			buf.append(" ");
			for (String node : nodes) { // print all nodes first
				buf.append(node);
				buf.append("; ");
			}
			buf.append("\n");
			for (String src : edges.keySet()) {
				for (String trg : edges.get(src)) {
					buf.append(" ");
					buf.append("\"" + src + "\"");
					buf.append(" -> ");
					buf.append("\"" + trg + "\"");
					buf.append(";\n");
				}
			}
			buf.append("}\n");
			
			// Print graph using GraphViz()
			gv.graph = buf;
	    	File out = new File("FOL.jpg");
	        //if(!out.exists()) {
	    		System.out.println("Imprimindo: FOL.jpg");
	            gv.writeGraphToFile(gv.getGraph( gv.getDotSource(), "jpg"), out );
	        //}
			
			return buf.toString();
		}
	}

}
