import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
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
				String clientName = commands[1];
				break;
			case "AC":
				// Adiciona conta a cliente
				// AC NomeCliente TipoConta NomeConta
				String clientName = commands[1];
				String accountType = commands[2];
				String accountName = commands[3]
				break;
			case "AA":
				// Adiciona montante, positivo ou negativo, a conta
				// AA NomeCliente NomeConta Montante
				String clientName = commands[1];
				String accountName = commands[2];
				Double amount = Double.parseDouble(commands[3]);
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
}
