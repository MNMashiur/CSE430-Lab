package CalcTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import Calc.BankAccount;

public class BankAccountTest {
	
	private BankAccount b;
	
	@BeforeEach
	public void setup() {
		b = new BankAccount();
		System.out.println("Running before each method");
	}
	
	@AfterEach
	public void lastmethod() {
		b = null;
		System.out.println("Running after each method");
	}
	
	@Test
	public void testDeposit() {
		double amount = 1000;
		double expectedoutput = 1000;

		b.deposit(amount);
		double actualoutput = b.getBalance();
		
		assertEquals(expectedoutput, actualoutput, 0.01);
	}
	
	@Test
	public void testWithdraw() {
		b.deposit(1000);

		double amount = 400;
		double expectedoutput = 600;

		b.withdraw(amount);
		double actualoutput = b.getBalance();

		assertEquals(expectedoutput, actualoutput, 0.01);
	}
	
	@Test
	public void testWithdrawBeyondBalance() {
		assertThrows(IllegalStateException.class, () -> {
			b.withdraw(5000);
		});
	}
	
	@Test
	public void testNegativeDeposit() {
		assertThrows(IllegalArgumentException.class, () -> {
			b.deposit(-100);
		});
	}
	
	@Test
	public void testAccountActive() {
		b.deposit(500);
		
		boolean actualoutput = b.isActive();
		
		assertTrue(actualoutput);
	}
	
	@Test
	public void testAccountInactive() {
		b.deposit(150);
		b.withdraw(100);
		
		boolean actualoutput = b.isActive();
		
		assertFalse(actualoutput);
	}
}