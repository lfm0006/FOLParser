// Generated from FOL.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FOLParser}.
 */
public interface FOLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code parensClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterParensClause(@NotNull FOLParser.ParensClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitParensClause(@NotNull FOLParser.ParensClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equaltyClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterEqualtyClause(@NotNull FOLParser.EqualtyClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equaltyClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitEqualtyClause(@NotNull FOLParser.EqualtyClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionClause}
	 * labeled alternative in {@link FOLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterFunctionClause(@NotNull FOLParser.FunctionClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionClause}
	 * labeled alternative in {@link FOLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitFunctionClause(@NotNull FOLParser.FunctionClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negationClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNegationClause(@NotNull FOLParser.NegationClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negationClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNegationClause(@NotNull FOLParser.NegationClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterRelationClause(@NotNull FOLParser.RelationClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitRelationClause(@NotNull FOLParser.RelationClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code connectiveClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterConnectiveClause(@NotNull FOLParser.ConnectiveClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code connectiveClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitConnectiveClause(@NotNull FOLParser.ConnectiveClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantClause}
	 * labeled alternative in {@link FOLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterConstantClause(@NotNull FOLParser.ConstantClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantClause}
	 * labeled alternative in {@link FOLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitConstantClause(@NotNull FOLParser.ConstantClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableClause}
	 * labeled alternative in {@link FOLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterVariableClause(@NotNull FOLParser.VariableClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableClause}
	 * labeled alternative in {@link FOLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitVariableClause(@NotNull FOLParser.VariableClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#functionSymb}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSymb(@NotNull FOLParser.FunctionSymbContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#functionSymb}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSymb(@NotNull FOLParser.FunctionSymbContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sentenceClause}
	 * labeled alternative in {@link FOLParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterSentenceClause(@NotNull FOLParser.SentenceClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sentenceClause}
	 * labeled alternative in {@link FOLParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitSentenceClause(@NotNull FOLParser.SentenceClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterValueClause(@NotNull FOLParser.ValueClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitValueClause(@NotNull FOLParser.ValueClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code formulaClause}
	 * labeled alternative in {@link FOLParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterFormulaClause(@NotNull FOLParser.FormulaClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code formulaClause}
	 * labeled alternative in {@link FOLParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitFormulaClause(@NotNull FOLParser.FormulaClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull FOLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull FOLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quantifierClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterQuantifierClause(@NotNull FOLParser.QuantifierClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quantifierClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitQuantifierClause(@NotNull FOLParser.QuantifierClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#constantSymb}.
	 * @param ctx the parse tree
	 */
	void enterConstantSymb(@NotNull FOLParser.ConstantSymbContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#constantSymb}.
	 * @param ctx the parse tree
	 */
	void exitConstantSymb(@NotNull FOLParser.ConstantSymbContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull FOLParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull FOLParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#relationSymb}.
	 * @param ctx the parse tree
	 */
	void enterRelationSymb(@NotNull FOLParser.RelationSymbContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#relationSymb}.
	 * @param ctx the parse tree
	 */
	void exitRelationSymb(@NotNull FOLParser.RelationSymbContext ctx);
}