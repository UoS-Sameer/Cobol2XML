package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import parse.tokens.Word;
import java.util.ArrayList;


class WordTest {

	@Test
	void test() {
		Word word = new Word();
		int maxDepth = 2;
		int depth = 1;
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList = word.randomExpansion(maxDepth, depth);
		
		//fail if randomExpansion() did not return anything
		assertFalse(arrayList.isEmpty()); 
	}

}
