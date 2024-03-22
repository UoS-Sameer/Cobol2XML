package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cobol.DivisionAssembler;
import parse.*;
import parse.tokens.*;
import cobol.Cobol;
class DivisionAssemblerTest {

    @Test
    void test() {
        DivisionAssembler assembler = new DivisionAssembler();
        TokenAssembly assembly = new TokenAssembly("test");
        
        assembly.push(new Token("Data"));
        
        assembler.workOn(assembly);
        
        Cobol c = (Cobol) assembly.getTarget();
        assertEquals("Data", c.getDivisionName());
    }
}
