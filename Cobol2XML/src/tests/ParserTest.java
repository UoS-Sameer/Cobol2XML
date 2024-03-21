package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

class ParserTest {

	@Test
	void test() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		t.setString("program-id. JB-base.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
	}

}
