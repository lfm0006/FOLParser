import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

public class FOLTestCase {

	public String runSPARQLParser(String code, String FOLQuery) throws FileNotFoundException {

	    String content = FOLQuery + "\n";
	    
		header(code, FOLQuery);

		ANTLRInputStream input = new ANTLRInputStream( content );
		
		FOLLexer lexer = new FOLLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		FOLParser parser = new FOLParser(tokens);
		
		parser.removeErrorListeners();
		FOLErrorListener errorListener = new FOLErrorListener();
		parser.addErrorListener(errorListener);
	
		ParseTree tree = parser.prog();
		//System.out.println(tree.toStringTree(parser));
		//System.out.println(errorListener.errorMessage);
		
		ArrayList<FOLAtom> folAtom = new ArrayList<FOLAtom>();
		FOLTree folTree = new FOLTree();
		
		FOLEvalVisitor folEval = new FOLEvalVisitor(false, folTree);
		folEval.visit(tree);
		System.out.println();
		for(int i=0; i < folAtom.size(); i++) {
			System.out.println(folAtom.get(i).atom + " = " + folAtom.get(i).value);
		}
		
		//assertTrue(folTree.isValid());
		// Print the tree
		//System.out.println();
		//System.out.println();
		folTree.tableau(FOLTree.TYPE_FOL);
		//System.out.println(folTree.graph.toDOT());
		return errorListener.errorMessage;

	}
	
	private void header(String code, String query) {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("-- " + code + ": " + query);
		System.out.println("--------------------------------------------------------------------------");
	}

	private void footer() {
		System.out.println();
	}

	@Test
	public void test001() throws FileNotFoundException {
		String query = "(_A | _B) -> _B";
		String msg = runSPARQLParser("12.1a", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}
	
	@Test
	public void test002() throws FileNotFoundException {
		String query = "_B -> (~_A | _B)";
		String msg = runSPARQLParser("12.1b", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}
	
	@Test
	public void test003() throws FileNotFoundException {
		String query = "(_F(#a) | ~_F(#a)) -> ~_Q(#b)";
		String msg = runSPARQLParser("12.1c", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test004() throws FileNotFoundException {
		String query = "(_A & _B) -> ~~_B";
		String msg = runSPARQLParser("12.1d", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test005() throws FileNotFoundException {
		String query = "~~_A & (_A -> _B)";
		String msg = runSPARQLParser("12.1e", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test006() throws FileNotFoundException {
		String query = "~~_P(#a) <-> (_P(#a) | _P(#a))";
		String msg = runSPARQLParser("12.1f", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test007() throws FileNotFoundException {
		String query = "_L(#c) | (~_L(#c) & _T(#s))";
		String msg = runSPARQLParser("12.1g", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}
	
	@Test
	public void test008() throws FileNotFoundException {
		String query = "(_A & _A) <-> _A";
		String msg = runSPARQLParser("12.1h", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test009() throws FileNotFoundException {
		String query = "_A -> (_B -> ~~_A)";
		String msg = runSPARQLParser("12.1i", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test010() throws FileNotFoundException {
		String query = "((_A -> _Q(#b)) & ~_Q(#b)) -> ~_A";
		String msg = runSPARQLParser("12.1j", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test011() throws FileNotFoundException {
		String query = "~(_A | _P(#b)) <-> (~_A | ~_P(#b))";
		String msg = runSPARQLParser("12.1k", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test012() throws FileNotFoundException {
		String query = "(~(_B -> _B)) | (_A & ~_A)";
		String msg = runSPARQLParser("12.1l", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test013() throws FileNotFoundException {
		String query = "~(~_A -> _B) -> (~_B | ~_A)";
		String msg = runSPARQLParser("12.1m", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test014() throws FileNotFoundException {
		String query = "(_A -> (_B -> _C)) <-> ((_A -> _B) -> _C)";
		String msg = runSPARQLParser("12.1n", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test015() throws FileNotFoundException {
		String query = "(_A -> (_B -> _C)) -> ((_B & _A) -> _C)";
		String msg = runSPARQLParser("12.1o", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test016() throws FileNotFoundException {
		String query = "~_P(#a) -> (~_P(#a) | _Q(#b))";
		String msg = runSPARQLParser("12.1p", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test017() throws FileNotFoundException {
		String query = "(~(_A | _B) & (_C <-> _A)) -> ~_C";
		String msg = runSPARQLParser("12.1q", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

	@Test
	public void test018() throws FileNotFoundException {
		String query = "(_A | (_B & _C)) -> ((_A | _B) & (_A | _C))";
		String msg = runSPARQLParser("12.1r", query);
		footer();
		if(msg == "") {
			System.out.println(query + ": OK");
		} else {
			System.out.println(query + ":" + msg);
		}
		assertTrue(msg, msg == "");
	}

}
