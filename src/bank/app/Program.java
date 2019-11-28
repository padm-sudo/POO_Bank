package bank.app;
import java.util.Scanner;

import bank.controllers.Bank;
import bank.controllers.BankClass;

public class Program {
	public static void main(String[] args) {
		Bank bank = new BankClass();
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()) {
			String line = input.nextLine();
			if(line.isBlank()) {
				input.close();
				System.exit(0);
			}
			String[] commands = line.split(" ");
			switch(commands[0]) {
			case "RC":
				// Regista cliente
				// RC NomeCliente
				commandRC(bank, commands);
				break;
			case "AC":
				// Adiciona conta a cliente
				// AC NomeCliente TipoConta NomeConta
				commandAC(bank, commands);
				break;
			case "AA":
				// Adiciona montante, positivo ou negativo, a conta
				// AA NomeCliente NomeConta Montante
				commandAA(bank, commands);
				break;
			case "CAT":
				// Altera o tipo de conta
				// CAT NomeCliente NomeConta TipoConta
				String clientName = commands[1];
				String accountName = commands[2];
				String accountType = commands[3];
				break;
			case "CAB":
				// Lista o montante total to tipo de conta indicado
				// CAB NomeCliente TipoConta
				String clientName = commands[1];
				String accountType = commands[2];
				break;
			case "CP":
				// Mosta a posição global do cliente
				// CP NomeCliente
				String clientName = commands[1];
				break;
			case "LC":
				// Lista todos os cliente, indicando os que se encontram 
				// impedidos de fazer levantamentos.
				// LC
				break
			default:
				System.out.println("Instrução inválida.");
			}
		}
		input.close();
	}

	private static void commandAA(Bank bank, String[] commands) {
		String clientName = commands[1];
		String accountName = commands[2];
		Double amount = Double.parseDouble(commands[3]);
		if(!bank.hasClient(clientName)) {
			System.out.println("Cliente inexistente.");
		}
		else if(!bank.hasAccount(clientName, accountName)) {
			System.out.println("Conta inexistente.");
		}
		else {
			boolean isInvalidWithdrawal = false;
			if(amount < 0) {
				if(bank.isClientBlocked(clientName)) {
					System.out.println("Levantamentos bloqueados para o cliente.");
					isInvalidWithdrawal = true;
				}
				else if(bank.getBalance(clientName, accountName) < Math.abs(amount)) {
					System.out.println("Fundos insuficientes na conta.");
					isInvalidWithdrawal = true;
				}
			}
			else if(!isInvalidWithdrawal) {
				bank.registerOperation(clientName, accountName, amount);
			}
		}
	}

	private static void commandAC(Bank bank, String[] commands) {
		String clientName = commands[1];
		String accountType = commands[2];
		String accountName = commands[3];
		if(!bank.hasClient(clientName)) {
			System.out.println("Cliente inexistente.");
		}
		else if(!bank.hasAccountType(accountType)) {
			System.out.println("Tipo de conta inexistente.");
		}
		else {
			bank.createAccount(clientName, accountType, accountName);
			System.out.println("Conta constituída com sucesso.");
		}
	}

	private static void commandRC(Bank bank, String[] commands) {
		String clientName = commands[1];
		if(bank.hasClient(clientName)) {
			System.out.println("Cliente existente.");
		}
		else {
			bank.createClient(clientName);
			System.out.println("Cliente registado com sucesso.");
		}
	}
}
