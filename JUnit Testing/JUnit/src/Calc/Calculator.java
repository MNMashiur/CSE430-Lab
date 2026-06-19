package Calc;

public class Calculator {
	 public int add(int a, int b) { 
	        return a + b; 
	    } 
	 
	 
	    public int subtract(int a, int b) { 
	        return a - b; 
	    } 
	 
	    
	    public int multiply(int a, int b) { 
	        return a * b; 
	    } 
	 
	    
	    public int divide(int a, int b) { 
	        if (b == 0) { 
	            throw new IllegalArgumentException("Cannot divide by zero."); 
	        } 
	        return a / b; 
	    }
	    
	    
	    public int power(int base, int exp) {
	    	int result = 1;
	    	
	    	for(int i=0; i<exp; i++) {
	    		result = result * base;
	    	}
	    	
	    	return result;
	    }
	    
	    
	    public int modulus(int a, int b) {
	    	if(b == 0) {
	    		throw new IllegalArgumentException("Cannot modulus by zero.");
	    	}
	    	
	    	return a % b;
	    }

}
