package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cobol.SectionNameAssembler;
import parse.*;
import parse.tokens.*;
import cobol.Cobol;


class SectionNameAssemblerTest {

    @Test
    void test() {
        SectionNameAssembler assembler = new SectionNameAssembler();
        TokenAssembly assembly = new TokenAssembly(new TokenString("test"));
        
        assembly.push(new Token("Main")); 
        assembler.workOn(assembly);
        
        Cobol c = (Cobol) assembly.getTarget();
        assertEquals("Main", c.getSectionName());
    }
}
