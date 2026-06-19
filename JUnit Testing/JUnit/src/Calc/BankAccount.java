package Calc;

public class BankAccount {
	
	private double balance;
	private boolean active = true;
	
	public void deposit(double amt){ 
		if(amt<0) 
			throw new 
			IllegalArgumentException();
			balance+=amt; 
			
		System.out.println("Deposited: " + amt);
		System.out.println("Current Balance: " + balance);
	}
	
	public void withdraw(double amt){ 
		if(amt > balance) 
			throw new IllegalStateException();
		
		balance -= amt;
		
		System.out.println("Withdrawn: " + amt);
		System.out.println("Current Balance: " + balance);
		
		if(balance < 100) {
			active = false;
		}
	}
	
	public double getBalance(){ 
		return balance; 
	}
	
	public boolean isActive() {
		return active;
	}

}
