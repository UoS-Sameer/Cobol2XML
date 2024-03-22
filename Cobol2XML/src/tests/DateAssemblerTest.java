package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cobol.DateAssembler;
import parse.*;
import parse.tokens.*;
import cobol.Cobol;

class DateAssemblerTest {

    @Test
    void test() {
        DateAssembler assembler = new DateAssembler();
        
        TokenAssembly assembly = new TokenAssembly(new TokenString("test")); 
        assembly.push(new Token(31)); //Day
        assembly.push(new Token("DEC/2023")); //Month + Year
        
        assembler.workOn(assembly);
        
        Cobol c = (Cobol) assembly.getTarget();
        System.out.println(c.getMonthDateWritten());
        System.out.println(c.getYearDateWritten());
        System.out.println(c.getDayDateWritten());
        
        assertEquals("DEC", c.getMonthDateWritten());
        assertEquals(2023, c.getYearDateWritten());
        assertEquals(31, c.getDayDateWritten());
    }
}
