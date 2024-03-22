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
        TokenAssembly assembly = new TokenAssembly("test");
        
        assembly.push(new Token("working-storage")); 
        assembler.workOn(assembly);
        
        Cobol c = (Cobol) assembly.getTarget();
        assertEquals("working-storage", c.getSectionName());
    }
}
