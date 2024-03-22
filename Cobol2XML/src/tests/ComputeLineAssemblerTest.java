package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cobol.ComputeLineAssembler;
import parse.*;
import parse.tokens.*;
import cobol.Cobol;

class ComputeLineAssemblerTest {

    @Test
    void testSum() {
        ComputeLineAssembler assembler = new ComputeLineAssembler();
        TokenAssembly assembly = new TokenAssembly("test");

        assembly.push(new Token("sum"));    // computeSum
        assembly.push(new Token("="));      // computeEqual
        assembly.push(new Token("num_1"));  // computeVar_1
        assembly.push(new Token("+"));      // computeOperator
        assembly.push(new Token("5"));      // computeVar_2 as integer
        
        assembler.workOn(assembly);
        Cobol c = (Cobol) assembly.getTarget();
        
        assertEquals("sum", c.getComputeSum());
        assertEquals("=", c.getComputeEqual());
        assertEquals("num_1", c.getComputeVar_1());
        assertEquals("+", c.getComputeOperator());
        assertEquals("5", c.getComputeVar_2());
    }
    
    @Test
    void testDifference() {
        ComputeLineAssembler assembler = new ComputeLineAssembler();
        TokenAssembly assembly = new TokenAssembly("test");

        assembly.push(new Token("difference"));
        assembly.push(new Token("="));      
        assembly.push(new Token("num_1"));  
        assembly.push(new Token("-"));      
        assembly.push(new Token("5"));      
        
        assembler.workOn(assembly);
        Cobol c = (Cobol) assembly.getTarget();
        
        assertEquals("difference", c.getComputeSum());
        assertEquals("=", c.getComputeEqual());
        assertEquals("num_1", c.getComputeVar_1());
        assertEquals("-", c.getComputeOperator());
        assertEquals("5", c.getComputeVar_2());
    }
    
    @Test
    void testProduct() {
        ComputeLineAssembler assembler = new ComputeLineAssembler();
        TokenAssembly assembly = new TokenAssembly("test");

        assembly.push(new Token("product"));
        assembly.push(new Token("="));      
        assembly.push(new Token("num_1"));  
        assembly.push(new Token("*"));      
        assembly.push(new Token("5"));      
        
        assembler.workOn(assembly);
        Cobol c = (Cobol) assembly.getTarget();
        
        assertEquals("product", c.getComputeSum());
        assertEquals("=", c.getComputeEqual());
        assertEquals("num_1", c.getComputeVar_1());
        assertEquals("*", c.getComputeOperator());
        assertEquals("5", c.getComputeVar_2());
    }
    
    @Test
    void testQuotient() {
        ComputeLineAssembler assembler = new ComputeLineAssembler();
        TokenAssembly assembly = new TokenAssembly("test");

        assembly.push(new Token("quotient"));
        assembly.push(new Token("="));      
        assembly.push(new Token("num_1"));  
        assembly.push(new Token("/"));      
        assembly.push(new Token("5"));      
        
        assembler.workOn(assembly);
        Cobol c = (Cobol) assembly.getTarget();
        
        assertEquals("quotient", c.getComputeSum());
        assertEquals("=", c.getComputeEqual());
        assertEquals("num_1", c.getComputeVar_1());
        assertEquals("/", c.getComputeOperator());
        assertEquals("5", c.getComputeVar_2());
    }
    
}
