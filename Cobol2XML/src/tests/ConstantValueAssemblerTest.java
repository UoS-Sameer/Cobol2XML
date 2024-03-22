package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cobol.ConstantValueAssembler;
import parse.*;
import parse.tokens.*;
import cobol.Cobol;


class ConstantValueAssemblerTest {

    @Test
    void test() {
        ConstantValueAssembler assembler = new ConstantValueAssembler();
        TokenAssembly assembly = new TokenAssembly("test");
        
        // Push tokens to the assembly in the correct order
        assembly.push(new Token(1));       // Line number
        assembly.push(new Token("Constant")); // Constant name
        assembly.push(new Token("value"));    // Keyword "value"
        assembly.push(new Token(3));    // Constant value
        
        // Execute the assembler
        assembler.workOn(assembly);
        
        // Retrieve the Cobol object from the assembly
        Cobol c = (Cobol) assembly.getTarget();
        
        // Verify that the Cobol object is correctly populated
        assertEquals("Constant", c.getConstantName());
        assertEquals(1, c.getLineNumber());
        assertEquals(3, c.getConstantValue());
    }
}
