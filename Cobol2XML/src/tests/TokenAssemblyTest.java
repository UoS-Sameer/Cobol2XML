package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import parse.tokens.Token;
import parse.tokens.TokenAssembly;
import parse.tokens.TokenString;

class TokenAssemblyTest {

	@Test
	void testConsumed() {
        Token[] tokens = {new Token("One"), new Token("Two"), new Token("Three")};
        TokenString tokenString = new TokenString(tokens);
	    TokenAssembly assembly = new TokenAssembly(tokenString);
	    assertEquals("", assembly.consumed("/"));
	}

    @Test
    void testDefaultDelimiter() {
        Token[] tokens = {new Token("One"), new Token("Two"), new Token("Three")};
        TokenString tokenString = new TokenString(tokens);
	    TokenAssembly assembly = new TokenAssembly(tokenString);
        assertEquals("/", assembly.defaultDelimiter());
    }

    @Test
    void testLength() {
        Token[] tokens = {new Token("One"), new Token("Two"), new Token("Three")};
        TokenString tokenString = new TokenString(tokens);
        TokenAssembly assembly = new TokenAssembly(tokenString);
        assertEquals(tokens.length, assembly.length());
    }

    @Test
    void testNextElement() {
        Token[] tokens = {new Token("One"), new Token("Two"), new Token("Three")};
        TokenString tokenString = new TokenString(tokens);
        TokenAssembly assembly = new TokenAssembly(tokenString);
        assertEquals(tokens[0], assembly.nextElement()); 
    }

    @Test
    void testPeek() {
        Token[] tokens = {new Token("One"), new Token("Two"), new Token("Three")};
        TokenString tokenString = new TokenString(tokens);
        TokenAssembly assembly = new TokenAssembly(tokenString);
        
        // Ensure that the peeked value is the first token
        assertEquals(tokens[0], assembly.peek());
    }


    @Test
    void testRemainder() {
        Token[] tokens = {new Token("One"), new Token("Two"), new Token("Three")};
        TokenString tokenString = new TokenString(tokens);
        TokenAssembly assembly = new TokenAssembly(tokenString);
        
        assembly.nextElement();

        
        String remainder = assembly.remainder("/");
        System.out.println("Remainder: " + remainder);
        assertEquals("Two/Three", remainder);
    }

    @Test
    void testPeekBeyondLength() {
        Token[] tokens = {new Token("One"), new Token("Two"), new Token("Three")};
        TokenString tokenString = new TokenString(tokens);
        TokenAssembly assembly = new TokenAssembly(tokenString);
        for (int i = 0; i < tokenString.length(); i++) {
            assembly.nextElement();
        }
        assertNull(assembly.peek());
    }

}
