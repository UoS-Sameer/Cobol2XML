package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cobol.Program_idAssembler;
import parse.*;
import parse.tokens.*;
import cobol.Cobol;


class Program_idAssemblerTest {

    @Test
    void test() {
        Program_idAssembler assembler = new Program_idAssembler();
        TokenAssembly assembly = new TokenAssembly("test");
        
        assembly.push(new Token("program-id"));

        assembler.workOn(assembly);
        
        Cobol c = (Cobol) assembly.getTarget();
        
        assertEquals("program-id", c.getProgram_ID());
    }
}
