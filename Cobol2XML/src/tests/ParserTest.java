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
		
		//DivisionName Parser Test #1
		t.setString("identification division.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		// ProgramID Parser Test
		t.setString("program-id.  base_jb.");
		in = new TokenAssembly(t);
		out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		// DateWritten Parser Test
		t.setString("date-written.  7-jul-1995 - mb.");
		in = new TokenAssembly(t);
		out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		//DivisionName Parser Test #2
		t.setString("data division.");
		in = new TokenAssembly(t);
		out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		//SectionName Parser Test
		t.setString("working-storage section.");
		in = new TokenAssembly(t);
		out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		// DivisionName Parser Test #3
		t.setString("procedure division.");
		in = new TokenAssembly(t);
		out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		//computeLine Parser Test #1
		t.setString("compute sum = num_1 + num_2.");
		in = new TokenAssembly(t);
		out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		//computeLine Parser Test #2
		t.setString("compute difference = num_1 - num_2.");
		in = new TokenAssembly(t);
		out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		//computeLine Parser Test #3
		t.setString("compute product = 13 * num_2.");
		in = new TokenAssembly(t);
		out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		//computeLine Parser Test #4
		t.setString("compute quotient = num_1 / 2.");
		in = new TokenAssembly(t);
		out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		//display Parser Test
		t.setString("display \"The sum of \" num_1 \" and \" num_2 \" is \" 10.");
		in = new TokenAssembly(t);
		out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		//stopRun Parser Test
		t.setString("stop run.");
		in = new TokenAssembly(t);
		out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
	}

}
