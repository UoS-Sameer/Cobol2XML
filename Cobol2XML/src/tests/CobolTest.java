package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cobol.Cobol;

class CobolTest {

	@Test
	void testClone() {
		Cobol c = new Cobol();
		Cobol coboldClone = (Cobol) c.clone();
		
		assertTrue(Cobol.ifCobolObjEqual(c, coboldClone));
	}
	
	
	@Test
	void testToString() {
		Cobol c = new Cobol();
		Object string = c.toString();
		
		assertTrue(string instanceof String);
		
	}
	
	@Test
	void testEquals() {
		
		//Same object
		Cobol c = new Cobol();
        assertTrue(c.equals(c));
        
        //Null
        assertFalse(c.equals(null));
        
        //Different objects
        Cobol differentC = new Cobol();
        c.setProgram_ID("1");
        assertFalse(c.equals(differentC));
        
	}
	

}
