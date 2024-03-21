package cobol;

import parse.*;
import parse.tokens.*;

public class StopRunAssembler extends Assembler{

	@Override
	public void workOn(Assembly a) {
		Cobol c = new Cobol();
		Token t = (Token) a.pop();
		c.setStopRun(t.sval());
		//run
		
		a.setTarget(c);
	}

}
