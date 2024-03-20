package cobol;

import parse.*;
import parse.tokens.*;

public class ComputeLineAssembler extends Assembler{

	@Override
	public void workOn(Assembly a) {
		Cobol c = new Cobol();
		Token t = (Token) a.pop();
		c.setComputeVar_2(t.sval());
		//This should be num_2
		
		t = (Token) a.pop();
		c.setComputeOperator(t.sval());
		//This should be +
		
		t = (Token) a.pop();
		c.setComputeVar_1(t.sval());
		//This should be num_1
		
		t = (Token) a.pop();
		c.setComputeEqual(t.sval());
		//This should be =
		
		t = (Token) a.pop();
		c.setComputeSum(t.sval());
		//This should be sum
		
		a.setTarget(c);
		
	}

}
