package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import parse.tokens.CaselessLiteral;
import java.util.ArrayList;

class CaselessLiteralTest {

	@Test
	void test() {
		CaselessLiteral caselessLiteral = new CaselessLiteral("test");
		int maxDepth = 2;
		int depth = 1;
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList = caselessLiteral.randomExpansion(maxDepth, depth);
		
		//fail if randomExpansion() did not return anything
		assertFalse(arrayList.isEmpty()); 
	}

}
