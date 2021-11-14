// Generated from FOL.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FOLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FOLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code parensClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensClause(@NotNull FOLParser.ParensClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equaltyClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualtyClause(@NotNull FOLParser.EqualtyClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionClause}
	 * labeled alternative in {@link FOLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionClause(@NotNull FOLParser.FunctionClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negationClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationClause(@NotNull FOLParser.NegationClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationClause(@NotNull FOLParser.RelationClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code connectiveClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectiveClause(@NotNull FOLParser.ConnectiveClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constantClause}
	 * labeled alternative in {@link FOLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantClause(@NotNull FOLParser.ConstantClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableClause}
	 * labeled alternative in {@link FOLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableClause(@NotNull FOLParser.VariableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLParser#functionSymb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSymb(@NotNull FOLParser.FunctionSymbContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sentenceClause}
	 * labeled alternative in {@link FOLParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenceClause(@NotNull FOLParser.SentenceClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueClause(@NotNull FOLParser.ValueClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formulaClause}
	 * labeled alternative in {@link FOLParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormulaClause(@NotNull FOLParser.FormulaClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(@NotNull FOLParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code quantifierClause}
	 * labeled alternative in {@link FOLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifierClause(@NotNull FOLParser.QuantifierClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLParser#constantSymb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantSymb(@NotNull FOLParser.ConstantSymbContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull FOLParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLParser#relationSymb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationSymb(@NotNull FOLParser.RelationSymbContext ctx);
}