package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cobol.DisplayAssembler;
import parse.*;
import parse.tokens.*;
import cobol.Cobol;


class DisplayAssemblerTest {

    @Test
    void test() {
        DisplayAssembler assembler = new DisplayAssembler();
        
        TokenAssembly assembly = new TokenAssembly("test");
        
        assembly.push(new Token("\"The sum of\"")); // Display String 1
        assembly.push(new Token("num_1"));      // Display 1
        assembly.push(new Token("\" and \""));      // Display String 2
        assembly.push(new Token("num_2"));      // Display 2
        assembly.push(new Token("\" is \""));       // Display String 3
        assembly.push(new Token(10));           // Display Number
        
        // Execute the assembler
        assembler.workOn(assembly);

        Cobol c = (Cobol) assembly.getTarget();
        
        assertEquals("\"The sum of\"", c.getDisplayString1());
        assertEquals("num_1", c.getDisplay1());
        assertEquals("\" and \"", c.getDisplayString2());
        assertEquals("num_2", c.getDisplay2());
        assertEquals("\" is \"", c.getDisplayString3());
        assertEquals(10, c.getDisplayNumber());
    }
}
