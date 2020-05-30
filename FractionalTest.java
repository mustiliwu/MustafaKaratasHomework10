import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FractionalTest {

	@Test
	void testFractional() {
		Fractional test = new Fractional(11,3);
		Fractional f = new Fractional(11,3);
		assertEquals(f, test);
	}
	public void testSimplify() {
		Fractional test = new Fractional(21,7);
		Fractional f = test.simplify();
		assertEquals(f, test);
	}
	public void testIsNaN() {
		Fractional test = new Fractional(12,4);
		boolean isIsNaN = false;
		assertEquals(isIsNaN, test.isNaN());
	}
	public void testisInfinity() {
		Fractional test = new Fractional(10,2);
		boolean isInfinit = false;
		assertEquals(isInfinit, test.isInfinity());
	}
	public void testSignLongLong() {
		Fractional test = new Fractional(14,-8);
		Fractional test1 = new Fractional(-14,8);
		assertEquals(test1,test.sign());
	}

	public void testGetValue() {
		
	}
	public void testEqualsObject() {
		Fractional test = new Fractional(12,4);
		Fractional test1 = new Fractional(7,2);
		boolean isEqual = true;
		assertEquals(isEqual, test.equals(test1));
	}
	public void testToString() {
		String test = new Fractional(15,6).toString(); 
		String test1 = "15/6";
		assertEquals(test1, test);
	}
	
	
	


}
