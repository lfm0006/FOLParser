import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.antlr.v4.runtime.misc.MultiMap;

import utils.GraphViz;

public class FOLTree {

	// For use with tableau()
	public static int TYPE_FOL = 0;
	public static int TYPE_LATEX = 1;

	public Graph graph = new Graph();
	static Map<String, String> pairs;	
	Map<String, Boolean> branches;
	boolean removed = false;
	boolean valid = false;
	boolean op_bicond = false;

	public Map<String, Map<Integer, String>> memory = new HashMap<String,Map<Integer, String>>(); // Ex.: _P(#a#b) ---> _P, {#a, #b}
	public Map<Integer, String> memvar = new HashMap<Integer, String>(); // Ex.: _P(?x?y) ---> {0, ?x}, {1, ?y}

	public Queue<String> queue = new LinkedList<String>();
	
	public class Node {
	    FOLAtom value;
	    Node left;
	    Node right;
	    Node parent;
	 
	    public Node(FOLAtom value) {
	        this.value = value;
	        right = null;
	        left = null;
	        parent = null;
	    }
	}
	
	Node root = new Node(null);
	boolean canAddRight = false;

	// Constructor
	public FOLTree() 	{
		fillQueue();
	}

	public FOLTree(FOLAtom value) 	{
		fillQueue();
		root = new Node(value);
	}

	private void fillQueue() {
		for(int i=97; i <123; i++) {
			String c = new Character((char)i).toString();
			queue.add("#" + c);
		}
	}
	
	public void add(Node node, String sparent, boolean vparent, String schild, boolean vchild, String type) {
		canAddRight = false;
		FOLAtom value = new FOLAtom(schild, vchild);
		addRecursive(node, value, type); // <---
	}

	public void add(Node node, String sparent, boolean vparent, String schild, boolean vchild, String type, String op) {
		if(op.equals("bicond")) {
			op_bicond = true;
		}
		canAddRight = false;
		FOLAtom value = new FOLAtom(schild, vchild);
		addRecursive(node, value, type); // <---
	}

	public void add(Node node, String sparent, boolean vparent, String schild, boolean vchild, String type, int quantifier) {
		canAddRight = false;
		FOLAtom value = new FOLAtom(schild, vchild, quantifier);
		addRecursive(node, value, type); // <---
	}

	@Deprecated
	public void add(String sparent, boolean vparent, String schild, boolean vchild, String type) {
		Node node = null;
		clearVisited();
		do {
			FOLAtom parent = new FOLAtom(sparent, vparent);
			node = search(parent);
			canAddRight = false;
			if(node != null) {
				FOLAtom value = new FOLAtom(schild, vchild);
				addRecursive(node, value, type); // <---
			}
		} while(node != null);
	}

	@Deprecated
	public void add(String sparent, boolean vparent, String schild, boolean vchild, String type, String op) {
		Node node = null;
		clearVisited();
		if(op.equals("bicond")) {
			op_bicond = true;
		}
		do {
			FOLAtom parent = new FOLAtom(sparent, vparent);
			node = search(parent);
			canAddRight = false;
			if(node != null) {
				FOLAtom value = new FOLAtom(schild, vchild);
				addRecursive(node, value, type); // <---
			}
		} while(node != null);
	}
	
	/*
	 * addRecursive - Add a new node for all leafs in the last level
	 */
	private void addRecursive(Node parent, FOLAtom value, String type) {
		if(parent.left == null && parent.right == null && type.equals("right")) {
			canAddRight = true; // must add in the prior level
			return;
		}
		if(parent.left == null) {
			FOLAtom v = new FOLAtom(value.atom, value.value);
			Node n = new Node(v);
			parent.left = n;
			n.parent = parent;
			return;
		}
		if(parent.left != null) {
			addRecursive(parent.left, value, type);
		}
		if(canAddRight) {
			canAddRight = false;
			FOLAtom v = new FOLAtom(value.atom, value.value);
			Node n = new Node(v);
			parent.right = n;
			n.parent = parent;
			return;
		}
		if(parent.right != null) {
			if(op_bicond) {
				value.value = !value.value;
				op_bicond = false;
			}
			addRecursive(parent.right, value, type);
		}
		return;
	}

	public Node search(FOLAtom value) {
		return searchRecursive(root, value);
	}
	
	private Node searchRecursive(Node node, FOLAtom value) {
		Node rnode = null;
		if(node == null) {
			return null;
		}
		
		if(compare(value, node.value) && !getVisited(node.value)) {
			setVisited(node.value, true);
			return node;
		} else {
			if(node.left != null) {
				//return searchRecursive(node.left, value);
				rnode = searchRecursive(node.left, value);
			}
			if(node.right != null && rnode == null) {
				//return searchRecursive(node.right, value);
				rnode = searchRecursive(node.right, value);
			}
		}
		return rnode;
	}
	
	public boolean compare(FOLAtom v1, FOLAtom v2) {
		return v1.atom.equals(v2.atom);
	}
	
	public boolean getVisited(FOLAtom v1) {
	       return v1.visited;
	}
	
	public void setVisited(FOLAtom v1, boolean value) {
		v1.visited = value;
	}
	
    public void tableau(int type) {
    	tableauRecursive(root, 0, "", type);
    }

    private void tableauRecursive(Node r, int i, String s, int type) {
        if (r != null)
        {
        	i++;
            print(r.value, i, s, type);
        	tableauRecursive(r.left, i, s + "   ", type);
        	tableauRecursive(r.right, i, s + "   ", type);
        }
    }
    
    public void print(FOLAtom value, int i, String s, int type) {
    	if(type == TYPE_FOL) {
    		System.out.println(i + ": " + s + value.atom + " = " + value.value + " (" + (value.isRelation ? "T" : "F") +") -- " + value.hashCode());
    	} else {
    		System.out.println(i + ":" + s + " [" + (value.value ? "T" : "F") + "] \\space \\space " + value.getLaTex() + " \\\\");
    	}
    }

    /*
     * searchQuantifiers() - Search for quantifiers and process
     */
    public Node searchQuantifiers() {
    	return searchQuantifiersRecursive(root);
    }
    
    private Node searchQuantifiersRecursive(Node node) {
		Node rnode = null;
    	if(node == null) {
    		return(null);
    	}
    	if(node.value.quantifier > 0) {
			setVisited(node.value, true);
    		return node;
    	} else {
			if(node.left != null) {
				rnode = searchQuantifiersRecursive(node.left);
			}
			if(node.right != null && rnode == null) {
				rnode = searchQuantifiersRecursive(node.right);
			}
    	}
    	return rnode;
    }
    
    public boolean isValid() {
    	branches = new HashMap<String, Boolean>();
    	valid = true;
    	isValidRecursive(root);
    	return(valid);
    }
    
    private void isValidRecursive(Node r) {
    	if(r == null) {
    		return;
    	}
        if(r.value.isRelation && r.left == null && r.right == null)
        {
            // Backtracking to check if branch is a contradiction
        	branches.clear();
        	removed = false;
        	backTracking(r);
    		System.out.print(r.value.value + ":" + r.value.atom + " = ");
        	if(removed) {
        		r.value.closed = true;
            	branches.clear();
        	}
        	valid = valid & removed; 
    		System.out.println(branches);
        } else {
        	isValidRecursive(r.left);
        	isValidRecursive(r.right);
        }
    }

    private void backTracking(Node r) {
    	if(r.parent == null) {
    		return;
    	}
    	if(r.value.isRelation) {
    		if(branches.containsKey(r.value.atom)) {
    			if(branches.get(r.value.atom) != r.value.value) {
    				branches.remove(r.value.atom);
    				removed = true;
    			}
    		} else {
       			branches.put(r.value.atom, r.value.value);
    		}
    	}
    	backTracking(r.parent);
    }

	/**
	 * @param root the root to set
	 */
	public Node setRoot(FOLAtom value) {
		this.root.value = value;
		return root;
	}
	
	/*
	 * searchAndUpdate - for all occurrences of a given T value 
	 */
	public void searchAndUpdate(FOLAtom value) {
		searchAndUpdateRecursive(root, value);
	}
	
	public void searchAndUpdateRecursive(Node parent, FOLAtom value) {
		if(compare(value, parent.value)) {
			update(parent.value);
		} 
		if(parent.left != null) {
			searchAndUpdateRecursive(parent.left, value);
		}
		if(parent.right != null) {
			searchAndUpdateRecursive(parent.right, value);
		}
	}
	
	/*
	 * clearVisited -
	 */
	public void clearVisited() {
		clearVisitedRecursive(root);
	}
	
	public void clearVisitedRecursive(Node parent) {
		setVisited(parent.value, false);
		if(parent.left != null) {
			clearVisitedRecursive(parent.left);
		}
		if(parent.right != null) {
			clearVisitedRecursive(parent.right);
		}
	}
	
	public void update(FOLAtom value) {
		value.isRelation = true;
	}
	
	public void getPairs() {
		getPairsRecursive(root, 0);
	}
	
	public void getPairsRecursive(Node node, int i) {
		if(node == null) {
			return;
		}
		if(node.left != null) {
			addPairs(node, node.left, i++);
			getPairsRecursive(node.left, i);
		}
		if(node.right != null) {
			addPairs(node, node.right, i++);
			getPairsRecursive(node.right, i);
		}
	}
	
    // Must be overriden in implementation
	public void addPairs(Node source, Node target, int idx) {
		graph.edge(String.valueOf(source.value.hashCode()), String.valueOf(target.value.hashCode()));
		if((target.value.isRelation && target.left == null && target.right == null)) {
			//source.value.atom = source.value.atom.replace("FORALL", "&#8704;").replace("EXISTS", "&#8707;");
			//target.value.atom = target.value.atom.replace("FORALL", "&#8704;").replace("EXISTS", "&#8707;");
			//source.value.atom = source.value.atom.replace("FORALL", Character.toString((char)0x2200)).replace("EXISTS", Character.toString((char)0x2203));
			//target.value.atom = target.value.atom.replace("FORALL", Character.toString((char)0x2200)).replace("EXISTS", Character.toString((char)0x2203));
			graph.node(String.valueOf(source.value.hashCode()), "[label=\"" + (source.value.value ? "T" : "F") + ": " + source.value.atom + "\",style=filled," + (source.value.closed ? "color=green" : "color=red") + "]");  
			graph.node(String.valueOf(target.value.hashCode()), "[label=\"" + (target.value.value ? "T" : "F") + ": " + target.value.atom + "\",style=filled," + (target.value.closed ? "color=green" : "color=red") + "]");
		}
		else {
			//source.value.atom = source.value.atom.replace("FORALL", "&#8704;").replace("EXISTS", "&#8707;");
			//target.value.atom = target.value.atom.replace("FORALL", "&#8704;").replace("EXISTS", "&#8707;");
			//source.value.atom = source.value.atom.replace("FORALL", Character.toString((char)0x2200)).replace("EXISTS", Character.toString((char)0x2203));
			//target.value.atom = target.value.atom.replace("FORALL", Character.toString((char)0x2200)).replace("EXISTS", Character.toString((char)0x2203));
			graph.node(String.valueOf(source.value.hashCode()), "[label=\"" + (source.value.value ? "T" : "F") + ": " + source.value.atom + "\"]");  
			graph.node(String.valueOf(target.value.hashCode()), "[label=\"" + (target.value.value ? "T" : "F") + ": " + target.value.atom + "\"]");  
		}
	}

	class Graph {
		GraphViz gv = new GraphViz();
		MultiMap<String, String> nodes = new MultiMap<String, String>();
		MultiMap<String, String> edges = new MultiMap<String, String>();

		public void edge(String source, String target) {
			edges.map(source, target);
		}

		public void node(String source, String target) {
			if(!nodes.containsKey(source)) {
				nodes.map(source, target);
			}
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
			
			for(String src: nodes.keySet()) {
				for(String trg: nodes.get(src)) {
					buf.append(" ");
					buf.append(src);
					buf.append(" ");
					buf.append(trg);
					buf.append(";\n");
				}
			}
			
			for (String src2 : edges.keySet()) {
				for (String trg : edges.get(src2)) {
					buf.append(" ");
					buf.append(src2);
					buf.append(" -> ");
					buf.append(trg);
					buf.append(";\n");
				}
			}
			buf.append("}\n");
			
			// Print graph using GraphViz()
			gv.graph = buf;
	    	File out = new File("tableau.jpg");
	        if(!out.exists()) {
     			//System.out.println();
	    		System.out.println("Imprimindo: tableau.jpg");
	            gv.writeGraphToFile(gv.getGraph( gv.getDotSource(), "jpg"), out );
	        }
			
			return buf.toString();
		}
	}

}
