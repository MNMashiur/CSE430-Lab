package Calc;

import java.util.Arrays;

public class StringUtil {
	
	public boolean isPalindrome(String s) { 
		if(s == null || s.isEmpty()) 
			return false; 
		
		String clean = s.replaceAll("[^A-Za-z]", "").toLowerCase(); 
		return new StringBuilder(clean).reverse().toString().equals(clean); 
	}
	
	public int countVowels(String s) {
		if(s == null || s.isEmpty())
			return 0;
		
		int count = 0;
		
		for(int i=0; i<s.length(); i++) {
			char ch = Character.toLowerCase(s.charAt(i));
			
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
				count++;
			}
		}
		
		return count;
	}
	
	public boolean isAnagram(String s1, String s2) {
		if(s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty())
			return false;
		
		char[] a1 = s1.toLowerCase().replaceAll("\\s","").toCharArray();
		char[] a2 = s2.toLowerCase().replaceAll("\\s","").toCharArray();
		
		Arrays.sort(a1);
		Arrays.sort(a2);
		
		return Arrays.equals(a1, a2);
	}
}