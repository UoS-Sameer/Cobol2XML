package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import parse.Assembly;
import parse.tokens.Num;
import parse.Assembler;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Stack;

class AssemblerTest {

	public static class TestAssembler extends Assembler {
		@Override
		public void workOn(Assembly a) {
			
		}
	}

	public class TestAssembly extends Assembly implements Enumeration<Object> {
		
	    public TestAssembly(Stack<Object> stack) {
	        this.stack = stack;
	        this.index = stack.size();
	    }


	    @Override
	    public Object nextElement() {
	        return null;
	    }

	    
	    @Override
	    public String defaultDelimiter() {
	        return ",";
	    }

	    @Override
	    public int length() {
	        return 0;
	    }

	    @Override
	    public Object peek() {
	        return null;
	    }

	    @Override
	    public String remainder(String delimiter) {
	        return "";
	    }
	    
	    @Override
	    public String consumed(String delimiter) {
	        return "";
	    }

	}
	
    @Test
    void testElementsAbove() {
        Stack<Object> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("fence");
        stack.push("3");
        stack.push("4");
        
		Assembly assembly = new TestAssembly(stack);
        
        ArrayList<Object> result = Assembler.elementsAbove(assembly, "fence");
        
        assertEquals(2, result.size());
        assertEquals("3", result.get(1));
        assertEquals("4", result.get(0));
    }

	
	@Test
	void testworkOn() {
		
	    Stack<Object> stack = new Stack<>();
	    stack.push("1");
	    stack.push("2");
	    stack.push("3");
	    stack.push("4");
		
		
		Assembler assembler = new TestAssembler();
		
		Assembly assembly = new TestAssembly(stack);
		
		assembler.workOn(assembly);
		
		assertEquals(4, stack.size());
		
		assertEquals("4", stack.peek());
	}

}
