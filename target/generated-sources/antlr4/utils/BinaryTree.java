package utils;

import java.util.List;

public class BinaryTree<T> {

	public class Node {
	    T value;
	    Node left;
	    Node right;
	 
	    public Node(T value) {
	        this.value = value;
	        right = null;
	        left = null;
	    }
	}
	
	Node root = new Node(null);
	boolean canAddRight = false;

	// Constructor
	public BinaryTree() 	{
	}

	public BinaryTree(T value) 	{
		root = new Node(value);
	}
	
	@Deprecated
	public Node addLeft(Node node, T value) {
		// Creates a new node to put the value
		Node n = new Node(value);
		node.left = n;
		return n;
	}

	@Deprecated
	public Node addRight(Node node, T value) {
		// Creates a new node to put the value
		Node n = new Node(value);
		node.right = n;
		return n;
	}
	
	public void add(T parent, T value, String type) {
		Node node = null;
		clearVisited();
		do {
			node = search(parent);
			canAddRight = false;
			if(node != null) {
				addRecursive(node, value, type); // <---
			}
		} while(node != null);
	}

	public void add(T parent, List<T> value, String type) {
		Node node = null;
		clearVisited();
		for(int i=0; i<value.size(); i++) {
			node = search(parent);
			canAddRight = false;
			if(node != null) {
				addRecursive(node, value.get(i), type); // <---
			}
		}
	}

	/*
	 * addRecursive - Add a new node for all leafs in the last level
	 */
	private void addRecursive(Node parent, T value, String type) {
		if(parent.left == null && parent.right == null && type.equals("right")) {
			canAddRight = true; // must add in the prior level
			return;
		}
		if(parent.left == null) {
			parent.left = new Node(value);
			return;
		}
		if(parent.left != null) {
			addRecursive(parent.left, value, type);
		}
		if(canAddRight) {
			canAddRight = false;
			parent.right = new Node(value);
			return;
		}
		if(parent.right != null) {
			addRecursive(parent.right, value, type);
		}
		return;
	}

	public Node search(T value) {
		return searchRecursive(root, value);
	}
	
	private Node searchRecursive(Node node, T value) {
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
	
    // Must be overriden in implementation
	public boolean compare(T v1, T v2) {
		return v1.equals(v2);
	}
	
	public boolean getVisited(T v1) {
       return false;
	}
	
	public void setVisited(T v1, boolean value) {
		
	}
	
    public void tableau() {
    	tableauRecursive(root, 0, "");
    }

    private void tableauRecursive(Node r, int i, String s) {
        if (r != null)
        {
        	i++;
            print(r.value, i, s);
        	tableauRecursive(r.left, i, s + "   ");
        	tableauRecursive(r.right, i, s + "   ");
        }
    }
    
    // Must be overriden in implementation
    public void print(T value, int i, String s) {
        System.out.println(i + ": " + value);
    }

	/**
	 * @param root the root to set
	 */
	public Node setRoot(T value) {
		this.root.value = value;
		return root;
	}
	
	/*
	 * searchAndUpdate - for all occurrences of a given T value 
	 */
	public void searchAndUpdate(T value) {
		searchAndUpdateRecursive(root, value);
	}
	
	public void searchAndUpdateRecursive(Node parent, T value) {
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
	
    // Must be overriden in implementation
	public void update(T value) {
	}
	
	int idx;
	
	public void getPairs() {
		getPairsRecursive(root, 0);
		idx = 0;
	}
	
	public void getPairsRecursive(Node node, int i) {
		if(node == null) {
			return;
		}
		if(node.left != null) {
			addPairs(node.value, node.left.value, i++);
			getPairsRecursive(node.left, i);
		}
		if(node.right != null) {
			addPairs(node.value, node.right.value, i++);
			getPairsRecursive(node.right, i);
		}
	}
	
    // Must be overriden in implementation
	public void addPairs(T source, T target, int idx) {
	}
	
}
