package bank.models;

import java.util.List;

public interface Client {
	public String getName();
	
	public List<Account> getAccounts();
	
	public void addAccount(Account account);
	
	public boolean hasAccount(String accountName);
}
