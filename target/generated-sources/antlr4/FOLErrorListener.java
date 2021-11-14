import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class FOLErrorListener extends BaseErrorListener {
	
	public String errorMessage = "";
	
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
			Object offendingSymbol,
			int line, int charPositionInLine,
			String msg,
			RecognitionException e)
	{
		List<String> stack = ((FOLParser)recognizer).getRuleInvocationStack();
		Collections.reverse(stack);
		//System.err.println("rule stack: "+stack);
		//System.err.println("line "+line+":"+charPositionInLine+" at "+ offendingSymbol+": "+msg);
		System.err.println("line "+line+":" + charPositionInLine +": "+msg);
		errorMessage = msg;
	}

}
