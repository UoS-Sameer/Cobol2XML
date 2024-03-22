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
        TokenAssembly assembly = new TokenAssembly(new TokenString("test"));
        
        assembly.push(new Token("MyProgram"));

        assembler.workOn(assembly);
        
        Cobol c = (Cobol) assembly.getTarget();
        
        assertEquals("MyProgram", c.getProgram_ID());
    }
}
