import java.io.File;
import java.util.Map;

import org.antlr.v4.runtime.misc.MultiMap;

import utils.BinaryTree;
import utils.GraphViz;

public class Tree extends BinaryTree<FOLAtom>{

	public Graph graph = new Graph();
	static Map<String, String> pairs;	
	/**
	 * @param value
	 */
	public Tree(FOLAtom value) {
		super(value);
	}

	public Tree() {
	}

	@Override
	public boolean compare(FOLAtom v1, FOLAtom v2) {
		return v1.atom.equals(v2.atom);
	}

	@Override
	public boolean getVisited(FOLAtom v1) {
       return v1.visited;
	}
		
	@Override
	public void setVisited(FOLAtom v1, boolean value) {
		v1.visited = value;
	}

	@Override
	public void print(FOLAtom folAtom, int i, String s) {
		System.out.println(i + ": " + s + folAtom.atom + " = " + folAtom.value + " (" + (folAtom.isRelation ? "T" : "F") +") -- " + folAtom.hashCode());
	}

	@Override
	public void update(FOLAtom value) {
		value.isRelation = true;
	}

	public void addPairs(FOLAtom source, FOLAtom target, int idx) {
		if(!target.isRelation || !source.isRelation) {
			graph.edge((source.value ? "T" : "F") + ": " + source.atom, (target.value ? "T" : "F") + ": " + target.atom);
		}
		else {
			graph.edge((source.value ? "T" : "F") + ": " + source.atom, (target.value ? "T" : "F") + ": " + target.atom+ "(" + idx + ")");
		}
	}

	class Graph {
		GraphViz gv = new GraphViz();
		MultiMap<String, String> nodes = new MultiMap<String, String>();
		MultiMap<String, String> edges = new MultiMap<String, String>();

		public void edge(String source, String target) {
			edges.map(source, target);
		}

		public String toDOT() {
			
			getPairs();

			StringBuilder buf = new StringBuilder();
			buf.append("digraph G {\n");
			buf.append(" ranksep=.25;\n");
			buf.append(" edge [arrowsize=.5]\n");
			buf.append(" node [shape=ellipse, fontname=\"ArialNarrow\",\n");
			buf.append(" fontsize=12, fixedsize=false, height=.45];\n");
			buf.append(" ");
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
	    	File out = new File("tableau.jpg");
	        //if(!out.exists()) {
     			//System.out.println();
	    		//System.out.println("Imprimindo: tableau.jpg");
	            //gv.writeGraphToFile(gv.getGraph( gv.getDotSource(), "jpg"), out );
	        //}
			
			return buf.toString();
		}
	}

}
