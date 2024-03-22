package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parse.tokens.Token;
import parse.tokens.Tokenizer;

class TokenizerTest {

private Tokenizer tokenizer;
    
    @BeforeEach
    public void setUpTests() {
        tokenizer = new Tokenizer();
    }

    @Test
    public void testNextTokenWithSymbol() throws IOException {
        tokenizer.setString("+");
        Token token = tokenizer.nextToken();
        assertEquals(Token.TT_SYMBOL, token.ttype());
        assertEquals("+", token.sval());
    }

    @Test
    public void testNextTokenWithNumber() throws IOException {
        tokenizer.setString("123");
        Token token = tokenizer.nextToken();
        assertEquals(Token.TT_NUMBER, token.ttype());
        assertEquals(123.0, token.nval());
    }

    @Test
    public void testNextTokenWithWord() throws IOException {
        tokenizer.setString("hello");
        Token token = tokenizer.nextToken();
        assertEquals(Token.TT_WORD, token.ttype());
        assertEquals("hello", token.sval());
    }

    @Test
    public void testNextTokenWithQuotedString() throws IOException {
        tokenizer.setString("\"quoted string\"");
        Token token = tokenizer.nextToken();
        assertEquals(Token.TT_QUOTED, token.ttype());
        assertEquals("\"quoted string\"", token.sval());
    }

    @Test
    public void testNextTokenWithEOF() throws IOException {
        tokenizer.setString("");
        Token token = tokenizer.nextToken();
        assertEquals(Token.TT_EOF, token.ttype());
    }
}
