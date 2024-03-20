package cobol;

import parse.*;
import parse.tokens.*;

public class DisplayAssembler extends Assembler{

	@Override
	public void workOn(Assembly a) {
		Cobol c = new Cobol();
		Token t = (Token) a.pop();
		c.setDisplayNumber((int)t.nval());
		// 10
		
		t = (Token) a.pop();
		c.setDisplayString3(t.sval());
		// " is "
		
		t = (Token) a.pop();
		c.setDisplay2(t.sval());
		// num_2
		
		t = (Token) a.pop();
		c.setDisplayString2(t.sval());
		// " and "
		
		t = (Token) a.pop();
		c.setDisplay1(t.sval());
		// num_1
		
		t = (Token) a.pop();
		c.setDisplayString1(t.sval());
		// "The sum of "
		
		a.setTarget(c);
	}

}
