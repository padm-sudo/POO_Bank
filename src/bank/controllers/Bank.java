package bank.controllers;

public interface Bank {

	boolean hasClient(String clientName);

	void createClient(String clientName);

	void createAccount(String clientName, String accountType, String accountName);

	double getBalance(String clientName, String accountName);

}
