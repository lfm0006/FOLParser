// Generated from FOL.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, TRUE=8, FALSE=9, 
		FORALL=10, EXISTS=11, AND=12, OR=13, IMPLY=14, BICOND=15, NOT=16, CHARACTER=17, 
		ENDLINE=18, WS=19, COMMENT=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "TRUE", "FALSE", 
		"FORALL", "EXISTS", "AND", "OR", "IMPLY", "BICOND", "NOT", "CHARACTER", 
		"ENDLINE", "WS", "COMMENT"
	};


	public FOLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FOL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26\u0082\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\6\22a\n\22\r\22"+
		"\16\22b\3\23\6\23f\n\23\r\23\16\23g\3\23\3\23\3\24\6\24m\n\24\r\24\16"+
		"\24n\3\24\3\24\3\25\3\25\3\25\3\25\7\25w\n\25\f\25\16\25z\13\25\3\25\5"+
		"\25}\n\25\3\25\3\25\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26\3\2\21"+
		"\4\2VVvv\4\2TTtt\4\2WWww\4\2GGgg\4\2HHhh\4\2CCcc\4\2NNnn\4\2UUuu\4\2Q"+
		"Qqq\4\2ZZzz\4\2KKkk\5\2\62;C\\c|\4\2\f\f\17\17\4\2\13\13\"\"\4\2\13\f"+
		"\17\17\u0086\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5-\3\2\2"+
		"\2\7/\3\2\2\2\t\61\3\2\2\2\13\63\3\2\2\2\r\65\3\2\2\2\17\67\3\2\2\2\21"+
		"9\3\2\2\2\23>\3\2\2\2\25D\3\2\2\2\27K\3\2\2\2\31R\3\2\2\2\33T\3\2\2\2"+
		"\35V\3\2\2\2\37Y\3\2\2\2!]\3\2\2\2#`\3\2\2\2%e\3\2\2\2\'l\3\2\2\2)r\3"+
		"\2\2\2+,\7+\2\2,\4\3\2\2\2-.\7\60\2\2.\6\3\2\2\2/\60\7a\2\2\60\b\3\2\2"+
		"\2\61\62\7*\2\2\62\n\3\2\2\2\63\64\7?\2\2\64\f\3\2\2\2\65\66\7%\2\2\66"+
		"\16\3\2\2\2\678\7A\2\28\20\3\2\2\29:\t\2\2\2:;\t\3\2\2;<\t\4\2\2<=\t\5"+
		"\2\2=\22\3\2\2\2>?\t\6\2\2?@\t\7\2\2@A\t\b\2\2AB\t\t\2\2BC\t\5\2\2C\24"+
		"\3\2\2\2DE\t\6\2\2EF\t\n\2\2FG\t\3\2\2GH\t\7\2\2HI\t\b\2\2IJ\t\b\2\2J"+
		"\26\3\2\2\2KL\t\5\2\2LM\t\13\2\2MN\t\f\2\2NO\t\t\2\2OP\t\2\2\2PQ\t\t\2"+
		"\2Q\30\3\2\2\2RS\7(\2\2S\32\3\2\2\2TU\7~\2\2U\34\3\2\2\2VW\7/\2\2WX\7"+
		"@\2\2X\36\3\2\2\2YZ\7>\2\2Z[\7/\2\2[\\\7@\2\2\\ \3\2\2\2]^\7\u0080\2\2"+
		"^\"\3\2\2\2_a\t\r\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2c$\3\2\2"+
		"\2df\t\16\2\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hi\3\2\2\2ij\b\23"+
		"\2\2j&\3\2\2\2km\t\17\2\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2op\3"+
		"\2\2\2pq\b\24\2\2q(\3\2\2\2rs\7\61\2\2st\7\61\2\2tx\3\2\2\2uw\n\20\2\2"+
		"vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y|\3\2\2\2zx\3\2\2\2{}\7\17\2"+
		"\2|{\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\7\f\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0081\b\25\2\2\u0081*\3\2\2\2\b\2bgnx|\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}