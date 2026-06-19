package CalcTest;

import Calc.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    
    private static Calculator c;

    @BeforeEach
    void setup() {
		c = new Calculator();
		System.out.println("Calculator initialized before each test");
	}

    @AfterEach
	void reset() {
    		c = null;
		System.out.println("Running after test");
	}

    
    //Addition
    
    @Test
    void testAdd() {
    		int a=4 ,b=5;
    		int actualOutput= c.add(a, b);
    		int expectedOutput= 9;
    		
        assertEquals(actualOutput, expectedOutput);
    }
    
    @Test
	void testAddBoundary() {
		int a=5, b=0;
		int actualOutput = c.add(a, b);
		int expectedOutput = 5;
	
		assertEquals(expectedOutput, actualOutput);
	}
    
    @Test
	void testAddExceptional() {
		int a=2147483647, b=1;
		int actualOutput = c.add(a, b);
		int expectedOutput = -2147483648;
		
		assertEquals(expectedOutput, actualOutput);
	}

    
    //Subtraction
    
    @Test
    void testSubtract() {
		int a=9 ,b=5;
		int actualOutput= c.subtract(a, b);
		int expectedOutput= 4;
		
		assertEquals(actualOutput, expectedOutput);
    }
    
    @Test
	void testSubtractBoundary() {
		int a=5, b=5;
		int actualOutput = c.subtract(a, b);
		int expectedOutput = 0;
		
		assertEquals(expectedOutput, actualOutput);
	}
    
    @Test
	void testSubtractExceptional() {
		int a=-2147483648, b=1;
		int actualOutput = c.subtract(a, b);
		int expectedOutput = 2147483647;
		
		assertEquals(expectedOutput, actualOutput);
	}
    
    
    //Multiplication
    
    @Test
    void testMultiply() {
		int a=4 ,b=5;
		int actualOutput= c.multiply(a, b);
		int expectedOutput= 20;
		
		assertEquals(actualOutput, expectedOutput);
    }
    
    @Test
	void testMultiplyBoundary() {
		int a=4, b=0;
		int actualOutput = c.multiply(a, b);
		int expectedOutput = 0;
		
		assertEquals(expectedOutput, actualOutput);
	}
    
    @Test
	void testMultiplyExceptional() {
		int a=2147483647, b=2;
		int actualOutput = c.multiply(a, b);
		int expectedOutput = -2;
		
		assertEquals(expectedOutput, actualOutput);
	}
    
    
    //Division
    
    @Test
    void testDivide() {
		int a=20 ,b=5;
		int actualOutput= c.divide(a, b);
		int expectedOutput= 4;
		
		assertEquals(actualOutput, expectedOutput);
    }
    
    @Test
	void testDivideBoundary() {
		int a=20, b=1;
		int actualOutput = c.divide(a, b);
		int expectedOutput = 20;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void testDivideExceptional() {
		int a=20, b=0;
		
		assertThrows(IllegalArgumentException.class, () -> {
			c.divide(a, b);
		});
	}
	
	
	// Power
	
	@Test
	void testPower() {
		int base=2, exp=3;
		int actualOutput = c.power(base, exp);
		int expectedOutput = 8;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void testPowerBoundary() {
		int base=5, exp=0;
		int actualOutput = c.power(base, exp);
		int expectedOutput = 1;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void testPowerExceptional() {
		int base=0, exp=0;
		int actualOutput = c.power(base, exp);
		int expectedOutput = 1;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	
	// Modulus
	
	@Test
	void testModulus() {
		int a=10, b=3;
		int actualOutput = c.modulus(a, b);
		int expectedOutput = 1;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void testModulusBoundary() {
		int a=10, b=1;
		int actualOutput = c.modulus(a, b);
		int expectedOutput = 0;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void testModulusExceptional() {
		int a=10, b=0;
		
		assertThrows(IllegalArgumentException.class, () -> {
			c.modulus(a, b);
		});
	}

}