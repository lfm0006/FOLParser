import java.util.HashSet;
import java.util.Set;


public class FOLAtom {
	
	public static final int NONE = 0; 
	public static final int FORALL = 1; 
	public static final int EXISTS = 2; 
	
	String atom; // atom or complex
	boolean value; // boolean value 
	boolean isRelation; // flag for atom (relation)
	boolean visited; // if node was visited before (atoms repeated)
	boolean closed; // if branch is closed or open
	int quantifier; // type of quantifier 
	
	FOLAtom() {
		
	}
	
	FOLAtom(String atom, boolean value) {
		this.atom = atom;
		this.value = value;
		this.isRelation = false;
		this.visited = false;
		this.closed = false;
		this.quantifier = NONE;
	}
	
	FOLAtom(String atom, boolean value, boolean isRelation) {
		this.atom = atom;
		this.value = value;
		this.isRelation = isRelation;
		this.visited = false;
		this.closed = false;
		this.quantifier = NONE;
	}

	FOLAtom(String atom, boolean value, int quantifier) {
		this.atom = atom;
		this.value = value;
		this.quantifier = quantifier;
		this.isRelation = false;
		this.visited = false;
		this.closed = false;
	}

}
