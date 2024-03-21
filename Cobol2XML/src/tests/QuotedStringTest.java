package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import parse.tokens.QuotedString;
import java.util.ArrayList;

class QuotedStringTest {

	@Test
	void test() {
		QuotedString quotedString = new QuotedString();
		int maxDepth = 2;
		int depth = 1;
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList = quotedString.randomExpansion(maxDepth, depth);
		
		//fail if randomExpansion() did not return anything
		assertFalse(arrayList.isEmpty()); 
	}

}
