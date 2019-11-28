package bank.controllers;

import java.util.ArrayList;
import java.util.List;

import bank.models.Account;
import bank.models.CheckingAccount;
import bank.models.Client;
import bank.models.ClientClass;
import bank.models.MarginAccount;
import bank.models.SavingsAccount;

public class BankClass implements Bank {
	private List<Client> clients;
	
	public BankClass() {
		clients = new ArrayList<Client>();
	}

	public boolean hasClient(String clientName) {
		for(Client client : this.clients) {
			if(client.getName() == clientName) {
				return true;
			}
		}
		return false;
	}

	public void createClient(String clientName) {
		this.clients.add(new ClientClass(clientName));
	}

	public Client getClient(String clientName) {
		for(Client client : this.clients) {
			if(client.getName() == clientName) {
				return client;
			}
		}
		return null;
	}
	public void createAccount(String clientName, String accountType, String accountName) {
		Account account = null;
		Client client = this.getClient(clientName);
		switch(accountType) {
		case "Ordem":
			account = new CheckingAccount(accountName);
			break;
		case "Poupança":
			account = new SavingsAccount(accountName);
			break;
		case "Margem":
			account = new MarginAccount(accountName);
			break;
		default:
			break;
		}
		client.addAccount(account);
	}

	public double getBalance(String clientName, String accountName) {
		// TODO Auto-generated method stub
		return 0;
	}


}
