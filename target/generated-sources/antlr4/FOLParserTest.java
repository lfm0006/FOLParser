import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import utils.BinaryTree;

public class FOLParserTest
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception 
	{
	    //String content = new Scanner(new File("target/generated-sources/antlr4/FOLExample.txt")).useDelimiter("\\Z").next();
	    //System.out.println( "FOL File:\n" + content + "\n\n");
		//String content = "(_A | _B) -> (_A & _B)"; // OK
	    //String content = "(_F(#a) | ~_F(#a)) -> ~_Q(#b)"; // OK
	    //String content = "(_F(#a#b) | ~_F(#a#b)) -> ~_Q(#c#d)"; // OK
	    //String content = "~_P(#a) -> (~_P(#a) | _Q(#b))"; //OK **
	    //String content = "(_A | _B) -> _B"; //OK
	    //String content = "(_A & _B) -> ~~_B"; //OK
	    //String content = "~~_A & (_A -> _B)"; //OK 
	    //String content = "~~_P(#a) <-> (_P(#a) | _P(#a))"; //OK
	    //String content = "_L(#c) | (~_L(#c) & _T(#s))"; //OK
	    //String content = "_A -> (_B -> ~~_A)"; // OK
		//String content = "~(_B -> _B) | (_A & ~_A)"; // OK
		String content = "((_A -> _Q(#b)) & ~_Q(#b)) -> ~_A"; //OK
		//String content = "~(_A & _B) <-> (~_A | ~_B)"; //OK
		//String content = "(~_A & ~_B) <-> ~(_A | _B)"; //OK
		//String content = "(~(_A | _B) & (_C <-> _A))"; //OK
		//String content = "((_C <-> _A) -> ~(_A | _B))"; //OK
	    //String content = "FORALL(?x)(_P(?x)) -> _P(#a)";
	    //String content = "FORALL(?x)(_F(?x)->_G(?x)) -> _F(#a)";
	    //String content = "FORALL(?x)(_A(?x) & _B(?x)) -> (FORALL(?x)(_A(?x)) & FORALL(?x)(_B(?x)))";
	    //String content = "EXISTS(?y)(FORALL(?x)(_R(?x?y))) -> FORALL(?x)(EXISTS(?y)(_R(?x?y)))";
		ANTLRInputStream input = new ANTLRInputStream( content );
		FOLLexer lexer = new FOLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FOLParser parser = new FOLParser(tokens);
		
		parser.removeErrorListeners();
		FOLErrorListener errorListener = new FOLErrorListener();
		parser.addErrorListener(errorListener);

		ParseTree tree = parser.prog();
		System.out.println(tree.toStringTree(parser));
		System.out.println(errorListener.errorMessage);
		
		//ArrayList<FOLAtom> folAtom = new ArrayList<FOLAtom>();
		FOLTree folTree = new FOLTree();
		
		FOLEvalVisitor folEval = new FOLEvalVisitor(false, folTree);
		folEval.visit(tree);
		//System.out.println();
		//for(int i=0; i < folAtom.size(); i++) {
		//	System.out.println(folAtom.get(i).atom + " = " + folAtom.get(i).value);
		//}
		System.out.println("Memory:");
		for(String key: folTree.memory.keySet()) {
			Map<Integer,String> constants = folTree.memory.get(key);
			System.out.print(key + ": ");
			for(Integer i: constants.keySet()) {
				System.out.print("(" + i + ")=" + constants.get(i) + "; ");
			}
			System.out.println();
		}
		System.out.println();

		// Print the tree
		folTree.tableau(FOLTree.TYPE_LATEX);
		System.out.println();
		System.out.println("Checking validity:");
		if(folTree.isValid()) {
			System.out.println("--- VALID ---");
		} else {
			System.out.println("--- INVALID---");
		}
		System.out.println();
		System.out.println(folTree.graph.toDOT());

	}
	

}