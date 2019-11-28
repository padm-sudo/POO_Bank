package bank.models;

public abstract class AccountClass implements Account {
	private String name;
	private double balance;
	
	public AccountClass(String name) {
		this.name = name;
		this.balance = 0.0;
	}
	
	public String getName() {
		return name;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
