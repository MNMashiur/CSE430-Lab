package CalcTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Calc.StringUtil;

public class StringUtilTest {
	
	private StringUtil s;
	
	@BeforeEach
	void setup() {
		s = new StringUtil();
		System.out.println("Running before each method");
	}
	
	
	// Palindrome 
	
	@Test
	@DisplayName("Test palindrome normal")
	void testPalindrome() {
		String str = "madam";
		
		boolean actualOutput = s.isPalindrome(str);
		boolean expectedOutput = true;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	@DisplayName("Test palindrome case insensitive")
	void testPalindromeCaseInsensitive() {
		String str = "RaceCar";
		
		boolean actualOutput = s.isPalindrome(str);
		boolean expectedOutput = true;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	@DisplayName("Test non palindrome")
	void testNotPalindrome() {
		String str = "hello";
		
		boolean actualOutput = s.isPalindrome(str);
		boolean expectedOutput = false;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	@DisplayName("Test null palindrome")
	void testNullPalindrome() {
		String str = null;
		
		boolean actualOutput = s.isPalindrome(str);
		boolean expectedOutput = false;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	@DisplayName("Test empty palindrome")
	void testEmptyPalindrome() {
		String str = "";
		
		boolean actualOutput = s.isPalindrome(str);
		boolean expectedOutput = false;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	
	// Vowel Counts
	
	@Test
	@DisplayName("Test count vowels normal")
	void testCountVowels() {
		String str = "hello";
		
		int actualOutput = s.countVowels(str);
		int expectedOutput = 2;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	@DisplayName("Test count vowels all vowels")
	void testCountAllVowels() {
		String str = "aeiou";
		
		int actualOutput = s.countVowels(str);
		int expectedOutput = 5;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	@DisplayName("Test count vowels empty")
	void testCountVowelsEmpty() {
		String str = "";
		
		int actualOutput = s.countVowels(str);
		int expectedOutput = 0;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	
	// Anagram
	
	@Test
	@DisplayName("Test anagram normal")
	void testAnagram() {
		String str1 = "listen";
		String str2 = "silent";
		
		boolean actualOutput = s.isAnagram(str1, str2);
		boolean expectedOutput = true;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	@DisplayName("Test anagram case insensitive")
	void testAnagramCaseInsensitive() {
		String str1 = "Race";
		String str2 = "Care";
		
		boolean actualOutput = s.isAnagram(str1, str2);
		boolean expectedOutput = true;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	@DisplayName("Test non anagram")
	void testNotAnagram() {
		String str1 = "hello";
		String str2 = "world";
		
		boolean actualOutput = s.isAnagram(str1, str2);
		boolean expectedOutput = false;
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	@DisplayName("Test null anagram")
	void testNullAnagram() {
		String str1 = null;
		String str2 = "test";
		
		boolean actualOutput = s.isAnagram(str1, str2);
		boolean expectedOutput = false;
		
		assertEquals(expectedOutput, actualOutput);
	}
}