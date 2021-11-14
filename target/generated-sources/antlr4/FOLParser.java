// Generated from FOL.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, TRUE=8, FALSE=9, 
		FORALL=10, EXISTS=11, AND=12, OR=13, IMPLY=14, BICOND=15, NOT=16, CHARACTER=17, 
		ENDLINE=18, WS=19, COMMENT=20;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "'.'", "'_'", "'('", "'='", "'#'", "'?'", "TRUE", 
		"FALSE", "FORALL", "EXISTS", "'&'", "'|'", "'->'", "'<->'", "'~'", "CHARACTER", 
		"ENDLINE", "WS", "COMMENT"
	};
	public static final int
		RULE_prog = 0, RULE_sentence = 1, RULE_formula = 2, RULE_term = 3, RULE_constantSymb = 4, 
		RULE_functionSymb = 5, RULE_relationSymb = 6, RULE_variable = 7, RULE_value = 8;
	public static final String[] ruleNames = {
		"prog", "sentence", "formula", "term", "constantSymb", "functionSymb", 
		"relationSymb", "variable", "value"
	};

	@Override
	public String getGrammarFileName() { return "FOL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FOLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SentenceClauseContext extends ProgContext {
		public TerminalNode EOF() { return getToken(FOLParser.EOF, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public TerminalNode COMMENT() { return getToken(FOLParser.COMMENT, 0); }
		public TerminalNode ENDLINE() { return getToken(FOLParser.ENDLINE, 0); }
		public SentenceClauseContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterSentenceClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitSentenceClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitSentenceClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			_localctx = new SentenceClauseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(18); match(COMMENT);
				}
			}

			setState(22); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(21); sentence();
				}
				}
				setState(24); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__4) | (1L << T__3) | (1L << T__1) | (1L << T__0) | (1L << TRUE) | (1L << FALSE) | (1L << FORALL) | (1L << EXISTS) | (1L << NOT))) != 0) );
			setState(27);
			_la = _input.LA(1);
			if (_la==ENDLINE) {
				{
				setState(26); match(ENDLINE);
				}
			}

			setState(29); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceContext extends ParserRuleContext {
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
	 
		public SentenceContext() { }
		public void copyFrom(SentenceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FormulaClauseContext extends SentenceContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public FormulaClauseContext(SentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterFormulaClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitFormulaClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitFormulaClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentence);
		try {
			_localctx = new FormulaClauseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(31); formula(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParensClauseContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ParensClauseContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterParensClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitParensClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitParensClause(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualtyClauseContext extends FormulaContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public EqualtyClauseContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterEqualtyClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitEqualtyClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitEqualtyClause(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueClauseContext extends FormulaContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueClauseContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterValueClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitValueClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitValueClause(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegationClauseContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode NOT() { return getToken(FOLParser.NOT, 0); }
		public NegationClauseContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterNegationClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitNegationClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitNegationClause(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuantifierClauseContext extends FormulaContext {
		public Token qop;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode EXISTS() { return getToken(FOLParser.EXISTS, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode FORALL() { return getToken(FOLParser.FORALL, 0); }
		public QuantifierClauseContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterQuantifierClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitQuantifierClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitQuantifierClause(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationClauseContext extends FormulaContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public RelationSymbContext relationSymb() {
			return getRuleContext(RelationSymbContext.class,0);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public RelationClauseContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterRelationClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitRelationClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitRelationClause(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConnectiveClauseContext extends FormulaContext {
		public Token op;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public TerminalNode AND() { return getToken(FOLParser.AND, 0); }
		public TerminalNode OR() { return getToken(FOLParser.OR, 0); }
		public TerminalNode IMPLY() { return getToken(FOLParser.IMPLY, 0); }
		public TerminalNode BICOND() { return getToken(FOLParser.BICOND, 0); }
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ConnectiveClauseContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterConnectiveClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitConnectiveClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitConnectiveClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new NegationClauseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(34); match(NOT);
				setState(35); formula(7);
				}
				break;
			case FORALL:
			case EXISTS:
				{
				_localctx = new QuantifierClauseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				((QuantifierClauseContext)_localctx).qop = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==FORALL || _la==EXISTS) ) {
					((QuantifierClauseContext)_localctx).qop = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(37); match(T__3);
				setState(38); variable();
				setState(39); match(T__6);
				setState(40); match(T__3);
				setState(41); formula(0);
				setState(42); match(T__6);
				}
				break;
			case T__4:
				{
				_localctx = new RelationClauseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44); relationSymb();
				setState(53);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(45); match(T__3);
					setState(47); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(46); term();
						}
						}
						setState(49); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__1) | (1L << T__0))) != 0) );
					setState(51); match(T__6);
					}
					break;
				}
				}
				break;
			case T__5:
			case T__1:
			case T__0:
				{
				_localctx = new EqualtyClauseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55); term();
				setState(56); match(T__2);
				setState(57); term();
				}
				break;
			case TRUE:
			case FALSE:
				{
				_localctx = new ValueClauseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59); value();
				}
				break;
			case T__3:
				{
				_localctx = new ParensClauseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60); match(T__3);
				setState(61); formula(0);
				setState(62); match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConnectiveClauseContext(new FormulaContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_formula);
					setState(66);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(67);
					((ConnectiveClauseContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLY) | (1L << BICOND))) != 0)) ) {
						((ConnectiveClauseContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(68); formula(7);
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstantClauseContext extends TermContext {
		public ConstantSymbContext constantSymb() {
			return getRuleContext(ConstantSymbContext.class,0);
		}
		public ConstantClauseContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterConstantClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitConstantClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitConstantClause(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableClauseContext extends TermContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VariableClauseContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterVariableClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitVariableClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitVariableClause(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionClauseContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public FunctionSymbContext functionSymb() {
			return getRuleContext(FunctionSymbContext.class,0);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public FunctionClauseContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterFunctionClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitFunctionClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitFunctionClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_term);
		int _la;
		try {
			setState(85);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new FunctionClauseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74); functionSymb();
				setState(75); match(T__3);
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(76); term();
					}
					}
					setState(79); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__1) | (1L << T__0))) != 0) );
				setState(81); match(T__6);
				}
				break;
			case T__1:
				_localctx = new ConstantClauseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(83); constantSymb();
				}
				break;
			case T__0:
				_localctx = new VariableClauseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(84); variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantSymbContext extends ParserRuleContext {
		public TerminalNode CHARACTER() { return getToken(FOLParser.CHARACTER, 0); }
		public ConstantSymbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantSymb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterConstantSymb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitConstantSymb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitConstantSymb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantSymbContext constantSymb() throws RecognitionException {
		ConstantSymbContext _localctx = new ConstantSymbContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constantSymb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); match(T__1);
			setState(88); match(CHARACTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionSymbContext extends ParserRuleContext {
		public TerminalNode CHARACTER() { return getToken(FOLParser.CHARACTER, 0); }
		public FunctionSymbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionSymb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterFunctionSymb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitFunctionSymb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitFunctionSymb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionSymbContext functionSymb() throws RecognitionException {
		FunctionSymbContext _localctx = new FunctionSymbContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionSymb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); match(T__5);
			setState(91); match(CHARACTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationSymbContext extends ParserRuleContext {
		public TerminalNode CHARACTER() { return getToken(FOLParser.CHARACTER, 0); }
		public RelationSymbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationSymb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterRelationSymb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitRelationSymb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitRelationSymb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationSymbContext relationSymb() throws RecognitionException {
		RelationSymbContext _localctx = new RelationSymbContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_relationSymb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); match(T__4);
			setState(94); match(CHARACTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode CHARACTER() { return getToken(FOLParser.CHARACTER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); match(T__0);
			setState(97); match(CHARACTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(FOLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FOLParser.FALSE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FOLListener ) ((FOLListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLVisitor ) return ((FOLVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2: return formula_sempred((FormulaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26h\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\5\2\26"+
		"\n\2\3\2\6\2\31\n\2\r\2\16\2\32\3\2\5\2\36\n\2\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\62\n\4\r\4\16\4\63"+
		"\3\4\3\4\5\48\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4C\n\4\3\4\3\4"+
		"\3\4\7\4H\n\4\f\4\16\4K\13\4\3\5\3\5\3\5\6\5P\n\5\r\5\16\5Q\3\5\3\5\3"+
		"\5\3\5\5\5X\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\2\3\6\13\2\4\6\b\n\f\16\20\22\2\5\3\2\f\r\3\2\16\21\3\2\n\13l\2"+
		"\25\3\2\2\2\4!\3\2\2\2\6B\3\2\2\2\bW\3\2\2\2\nY\3\2\2\2\f\\\3\2\2\2\16"+
		"_\3\2\2\2\20b\3\2\2\2\22e\3\2\2\2\24\26\7\26\2\2\25\24\3\2\2\2\25\26\3"+
		"\2\2\2\26\30\3\2\2\2\27\31\5\4\3\2\30\27\3\2\2\2\31\32\3\2\2\2\32\30\3"+
		"\2\2\2\32\33\3\2\2\2\33\35\3\2\2\2\34\36\7\24\2\2\35\34\3\2\2\2\35\36"+
		"\3\2\2\2\36\37\3\2\2\2\37 \7\2\2\3 \3\3\2\2\2!\"\5\6\4\2\"\5\3\2\2\2#"+
		"$\b\4\1\2$%\7\22\2\2%C\5\6\4\t&\'\t\2\2\2\'(\7\6\2\2()\5\20\t\2)*\7\3"+
		"\2\2*+\7\6\2\2+,\5\6\4\2,-\7\3\2\2-C\3\2\2\2.\67\5\16\b\2/\61\7\6\2\2"+
		"\60\62\5\b\5\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2"+
		"\64\65\3\2\2\2\65\66\7\3\2\2\668\3\2\2\2\67/\3\2\2\2\678\3\2\2\28C\3\2"+
		"\2\29:\5\b\5\2:;\7\7\2\2;<\5\b\5\2<C\3\2\2\2=C\5\22\n\2>?\7\6\2\2?@\5"+
		"\6\4\2@A\7\3\2\2AC\3\2\2\2B#\3\2\2\2B&\3\2\2\2B.\3\2\2\2B9\3\2\2\2B=\3"+
		"\2\2\2B>\3\2\2\2CI\3\2\2\2DE\f\b\2\2EF\t\3\2\2FH\5\6\4\tGD\3\2\2\2HK\3"+
		"\2\2\2IG\3\2\2\2IJ\3\2\2\2J\7\3\2\2\2KI\3\2\2\2LM\5\f\7\2MO\7\6\2\2NP"+
		"\5\b\5\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7\3\2\2T"+
		"X\3\2\2\2UX\5\n\6\2VX\5\20\t\2WL\3\2\2\2WU\3\2\2\2WV\3\2\2\2X\t\3\2\2"+
		"\2YZ\7\b\2\2Z[\7\23\2\2[\13\3\2\2\2\\]\7\4\2\2]^\7\23\2\2^\r\3\2\2\2_"+
		"`\7\5\2\2`a\7\23\2\2a\17\3\2\2\2bc\7\t\2\2cd\7\23\2\2d\21\3\2\2\2ef\t"+
		"\4\2\2f\23\3\2\2\2\13\25\32\35\63\67BIQW";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}