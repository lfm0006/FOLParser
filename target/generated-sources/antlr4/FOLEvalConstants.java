import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;

public class FOLEvalConstants extends FOLBaseVisitor<Boolean> {

	public boolean test;
	FOLTree folTree;
	
	FOLEvalConstants(boolean test, FOLTree folTree) {
		this.test = test;
		this.folTree = folTree;
	}

	@Override
	public Boolean visitRelationClause(@NotNull FOLParser.RelationClauseContext ctx) {
			String r = ctx.getText();
			
			// Save relations and constants to the memory
			if(ctx.term().size() > 0) {
				String s = ctx.relationSymb().getText();
				Map<Integer,String> constants = new HashMap<Integer, String>();
				for(int i=0; i < ctx.term().size(); i++) {
					String cons = ctx.term().get(i).getText();
					if(cons.contains("#")){
						constants.put(i, cons);
					} else
					if(cons.contains("?")) {
						folTree.memvar.put(i, cons);
					}
				}
				folTree.memory.put(s, constants);
			}
		return visitChildren(ctx);
	}

	@Override 
	public Boolean visitVariableClause(@NotNull FOLParser.VariableClauseContext ctx) {
		return visitChildren(ctx); 
	}

}
