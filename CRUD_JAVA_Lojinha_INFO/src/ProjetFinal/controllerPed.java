package ProjetFinal;
	import java.util.Scanner;

public class controllerPed {
	// INSTANCIANDO DAOPEDIDO
	daoPedido daoPed = new daoPedido();
	Scanner lerPed = new Scanner(System.in);
			
	//FUNÇÃO PARA ADICIONAR PEDIDO ===============1
	public void addPed(){
	System.out.println("+=====================================+");
	System.out.println("| - ADICIONANDO NOVO PEDIDO:          |");
	System.out.println("+=====================================+");
	System.out.println("");

	System.out.print("NUMERO DO PEDIDO: ");
		int numero = lerPed.nextInt();
		clearBuffer(lerPed);
	System.out.print("FORMA DE PAGAMENTO: ");
		String forma_pg = lerPed.nextLine();
	System.out.print("CPF DO CLIENTE: ");
		String cliente = lerPed.nextLine();
	System.out.print("CODIGO DO PRODUTO: ");
		int produto = lerPed.nextInt();
	System.out.print("QTDE DO PRODUTO: ");
		int qtde_prod = lerPed.nextInt();	
	// INSTANCIANDO PEDIDO
	Pedido ped = new Pedido(numero, forma_pg, cliente, produto, qtde_prod);	
	// INSTANCIANDO DAO DO PRODUTO
	daoPedido daoPed = new daoPedido();
		daoPed.addPedido(ped);
	}			
			
	//FUNÇÃO PARA MOSTRAR TODOS OS PEDIDOS ============2
	public void mostraPed() {
	System.out.println("+=====================================+");
	System.out.println("| - LISTANDO TODOS OS PEDIDOS:        |");
	System.out.println("+=====================================+");
		daoPed.mostraPedido();
	}
			
	//FUNÇÃO PARA ATUALIZAR PEDIDOS ===============3
	public void updatePed() {
	System.out.println("+=====================================+");
	System.out.println("| - ATUALIZANDO UM PEDIDO:            |");
	System.out.println("+=====================================+");
	System.out.println("");

	System.out.print("NUMERO DO PEDIDO: ");
		int numero = lerPed.nextInt();
		clearBuffer(lerPed);
	System.out.print("FORMA DE PAGAMENTO: ");
		String forma_pg = lerPed.nextLine();
	System.out.print("CPF DO CLIENTE: ");
		String cliente = lerPed.nextLine();
	System.out.print("CODIGO DO PRODUTO: ");
		int produto = lerPed.nextInt();
	System.out.print("QTDE DO PRODUTO: ");
		int qtde_prod = lerPed.nextInt();
	// INSTANCIANDO PEDIDO
	Pedido ped = new Pedido(numero, forma_pg, cliente, produto, qtde_prod);
	// INSTANCIANDO DAO DO PEDIDO
	daoPed.updatePedido(ped);
	}
			
	//FUNÇÃO PARA DELETAR PEDIDO ===============4
	public void delPed() {
	System.out.println("+=====================================+");
	System.out.println("| - DELETANDO PEDIDO:                 |");
	System.out.println("+=====================================+");
	System.out.println("");	

	System.out.print("NUMERO DO PEDIDO: ");
		int numero = lerPed.nextInt();		
	// INSTANCIANDO PEDIDO
	Pedido ped = new Pedido(numero);
	// INSTANCIANDO DAO DO PEDIDO
	daoPed.deletePedido(ped);
	}
			
	//FUNÇÃO PARA PROCURAR UM PEDIDO ===============5
	public void procuraPed() {
	System.out.println("+=====================================+");
	System.out.println("| - PROCURANDO UM PEDIDO:             |");
	System.out.println("+=====================================+");
	System.out.println("");	

	System.out.print("NUMERO DO PEDIDO: ");
	System.out.println();
		int numero = lerPed.nextInt();	
	// INSTANCIANDO PEDIDO
	Pedido ped = new Pedido(numero);
	// INSTANCIANDO DAO DO PEDIDO
	daoPed.procuraPedido(ped);
	}
			
	//FUNÇÃO PARA GERAR NOTA DE UM PEDIDO ===============5
	public void gerarNota() {
	System.out.println("+=====================================+");
	System.out.println("| - GERAR NOTA DO PEDIDO:             |");
	System.out.println("+=====================================+");
	System.out.println("");	

	System.out.print("NUMERO DO PEDIDO: ");
		int numero = lerPed.nextInt();	
	// INSTANCIANDO PEDIDO
	Pedido ped = new Pedido(numero);
	// INSTANCIANDO DAO DO PEDIDO
	daoPed.gerarNota(ped);
	}
			
	// FUNÇÃO PARA LIMPAR BUFFER DO NEXTLINE()
	private static void clearBuffer(Scanner scanner) {
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
	}
}
