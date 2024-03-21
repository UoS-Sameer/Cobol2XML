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
	void testDivisionName() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		//DivisionName Parser Test #1
		t.setString("identification division.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		//DivisionName Parser Test #2
		t.setString("data division.");
		in = new TokenAssembly(t);
		out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		// DivisionName Parser Test #3
		t.setString("procedure division.");
		in = new TokenAssembly(t);
		out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
	}
	
	@Test
	void testProgramID() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		// ProgramID Parser Test
		t.setString("program-id.  base_jb.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		}
	
	@Test
	void testDateWritten() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		// DateWritten Parser Test
		t.setString("date-written.  7-jul-1995 - mb.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		}
	
	
	@Test
	void testSectionName() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		//SectionName Parser Test
		t.setString("working-storage section.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		assertFalse(out.stackIsEmpty());
		
		}
	
	
	@Test
	void testComputeLine() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		//computeLine Parser Test #1
		t.setString("compute sum = num_1 + num_2.");
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
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
		
		}
	
	
	@Test
	void testDisplay() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		//display Parser Test
				t.setString("display \"The sum of \" num_1 \" and \" num_2 \" is \" 10.");
				Assembly in = new TokenAssembly(t);
				Assembly out = p.bestMatch(in);
				assertFalse(out.stackIsEmpty());
		}
	
	@Test
	void testStopRun() {
		Tokenizer t = CobolParser.tokenizer();
		Parser p = CobolParser.start();
		
		//stopRun Parser Test
				t.setString("stop run.");
				Assembly in = new TokenAssembly(t);
				Assembly out = p.bestMatch(in);
				assertFalse(out.stackIsEmpty());
		}
	

}
