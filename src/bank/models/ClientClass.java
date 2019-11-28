package bank.models;

import java.util.ArrayList;
import java.util.List;

public class ClientClass implements Client {
	private String name;
	private List<Account> accounts;
	
	public ClientClass(String name) {
		this.name = name;
		this.accounts = new ArrayList<Account>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}
	
	public boolean hasAccount(String accountName) {
		for(Account account : this.accounts) {
			if(account.getName() == accountName) {
				return true;
			}
		}
		return false;
	}

}
