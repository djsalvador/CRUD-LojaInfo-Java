package ProjetFinal;
	import java.util.Scanner;
	
public class controllerCli {
	
	// INSTANCIANDO DAOCLIENTE
	daoCliente daoC = new daoCliente();
	Scanner lerCli = new Scanner(System.in);
	
	//FUNÇÃO PARA ADICIONAR CLIENTES ===============1
	public void addCli(){
	System.out.println("+=====================================+");
	System.out.println("| - ADICIONANDO NOVO CLIENTE:         |");
	System.out.println("+=====================================+");
	System.out.println("");
		
	System.out.print("CPF: ");
		String cpf = lerCli.nextLine();
	System.out.print("NOME: ");
		String nome = lerCli.nextLine();
	System.out.print("TELEFONE: ");
		String telefone = lerCli.nextLine();
	System.out.print("RUA: ");
		String rua = lerCli.nextLine();
	System.out.print("BAIRRO: ");
		String bairro = lerCli.nextLine();
	System.out.print("CIDADE: ");
		String cidade = lerCli.nextLine();
	System.out.print("ESTADO: ");
		String estado = lerCli.nextLine();		
	// INSTANCIANDO CLIENTE
	Cliente cli = new Cliente(cpf, nome, telefone, rua, bairro, cidade, estado);	
	// INSTANCIANDO DAO DO CLIENTE
	daoCliente daoC = new daoCliente();
		daoC.addCliente(cli);
	}			
	
	//FUNÇÃO PARA MOSTRAR CLIENTES ===============2
	public void mostraCli() {
		System.out.println("+=====================================+");
		System.out.println("|     LISTANDO TODOS OS CLIENTES:     |");
		System.out.println("+=====================================+");
		daoC.mostraCliente();
	}
	
	//FUNÇÃO PARA ATUALIZAR CLIENTES ===============3
	public void updateCli() {
	System.out.println("+=====================================+");
	System.out.println("| - ATUALIZAR DADOS DE UM CLIENTE:    |");
	System.out.println("+=====================================+");
	System.out.println("");

	System.out.print("CPF: ");
		String cpf = lerCli.nextLine();
	System.out.print("NOME: ");
		String nome = lerCli.nextLine();
	System.out.print("TELEFONE: ");
		String telefone = lerCli.nextLine();
	System.out.print("RUA: ");
		String rua = lerCli.nextLine();
	System.out.print("BAIRRO: ");
		String bairro = lerCli.nextLine();
	System.out.print("CIDADE: ");
		String cidade = lerCli.nextLine();
	System.out.print("ESTADO: ");
		String estado = lerCli.nextLine();
	// INSTANCIANDO CLIENTE
	Cliente cli = new Cliente(cpf, nome, telefone, rua, bairro, cidade, estado);
	// INSTANCIANDO DAO DO CLIENTE
	daoC.updateCliente(cli);
	}
	
	//FUNÇÃO PARA DELETAR CLIENTES ===============4
	public void delCli() {
	System.out.println("+=====================================+");
	System.out.println("| - DELETAR UM CLIENTE:               |");
	System.out.println("+=====================================+");
	System.out.println("");
	
	System.out.print("CPF: ");
		String cpf = lerCli.nextLine();		
	// INSTANCIANDO CLIENTE
	Cliente cli = new Cliente(cpf);
	// INSTANCIANDO DAO DO CLIENTE
	daoC.deleteCliente(cli);
	}
	
	//FUNÇÃO PARA PROCURAR UM CLIENTE ===============5
	public void procuraCli() {
	System.out.println("+=====================================+");
	System.out.println("| - PROCURANDO UM CLIENTE:            |");
	System.out.println("+=====================================+");
	System.out.println("");
	
	System.out.print("CPF: ");
		String cpf = lerCli.nextLine();		
	// INSTANCIANDO CLIENTE
	Cliente cli = new Cliente(cpf);
	// INSTANCIANDO DAO DO CLIENTE
	daoC.procuraCliente(cli);
	}
	
}
