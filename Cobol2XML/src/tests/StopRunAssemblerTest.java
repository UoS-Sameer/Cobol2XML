package tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import cobol.StopRunAssembler;
import parse.*;
import parse.tokens.*;
import cobol.Cobol;

class StopRunAssemblerTest {

    @Test
    void test() {
        StopRunAssembler assembler = new StopRunAssembler();
        
        TokenAssembly assembly = new TokenAssembly("test");
        assembly.push(new Token("run"));
        
        assembler.workOn(assembly);
        Cobol c = (Cobol) assembly.getTarget();
        assertEquals("run", c.getStopRun());
    }
}
