package ProjetFinal;
	import java.util.Scanner;

public class menu {
	
	Scanner ler = new Scanner(System.in);
	
	// FUNÇÃO MENU CLIENTES 
	public void menuCli() {
		controllerCli cli = new controllerCli();
		System.out.println();
		System.out.println("+=================================================+");
		System.out.println("|                MODULO CLIENTES                  |");
		System.out.println("|=================================================|");
		System.out.println("| ENTRE COM A OPCAO:                              |");
		System.out.println("|        (1) ADICIONAR NOVO CLIENTE               |");
		System.out.println("|        (2) LISTAR TODOS OS CLIENTES             |");
		System.out.println("|        (3) ATUALIZAR DADOS DE UM CLIENTE        |");
		System.out.println("|        (4) DELETAR UM CLIENTE                   |");
		System.out.println("|        (5) PROCURAR UM CLIENTE                  |");
		System.out.println("|        (6) SAIR                                 |");
		System.out.println("+=================================================+");
		
		System.out.print("OPCAO: ");
		int op = ler.nextInt();
		
		switch(op) {
			case 1: cli.addCli();
				menuCli();
				break;
			case 2: cli.mostraCli();
				menuCli();
				break;
			case 3: cli.updateCli();
				menuCli();
				break;
			case 4: cli.delCli();
				menuCli();
				break;
			case 5: cli.procuraCli();
				menuCli();
				break;
			case 6: voltarMain();
				break;
			default:
				System.out.println("OPCAO INVALIDA");
				menuCli();
				break;
		}
	}
	
	// FUNÇÃO MENU PRODUTOS 
	public void menuProd() {
		controllerProd prod = new controllerProd();
		System.out.println();
		System.out.println("+=================================================+");
		System.out.println("|                MODULO PRODUTOS                  |");
		System.out.println("|=================================================|");
		System.out.println("| ENTRE COM A OPCAO:                              |");
		System.out.println("|        (1) ADICIONAR NOVO PRODUTO               |");
		System.out.println("|        (2) LISTAR TODOS OS PRODUTOS             |");
		System.out.println("|        (3) ATUALIZAR DADOS DE UM PRODUTO        |");
		System.out.println("|        (4) DELETAR UM PRODUTO                   |");
		System.out.println("|        (5) PROCURAR UM PRODUTO                  |");
		System.out.println("|        (6) SAIR                                 |");
		System.out.println("+=================================================+");
		
		System.out.print("OPCAO: ");
		int op = ler.nextInt();
			
		switch(op) {
			case 1: prod.addProd();
				menuProd();
				break;
			case 2: prod.mostraProd();
				menuProd();
				break;
			case 3: prod.updateProd();
				menuProd();
				break;
			case 4: prod.delProd();
				menuProd();
				break;
			case 5: prod.procuraProd();
				menuProd();
				break;
			case 6: voltarMain();
				break;
			default:
				System.out.println("OPCAO INVALIDA");
				menuProd();
				break;
		}
	}
	
	// FUNÇÃO MENU PEDIDOS 
	public void menuPed() {
		controllerPed ped = new controllerPed();
		System.out.println();
		System.out.println("+=================================================+");
		System.out.println("|                MODULO PEDIDOS                   |");
		System.out.println("|=================================================|");
		System.out.println("| ENTRE COM A OPCAO:                              |");
		System.out.println("|        (1) ADICIONAR UM NOVO PEDIDO             |");
		System.out.println("|        (2) LISTAR TODOS OS PEDIDOS              |");
		System.out.println("|        (3) ATUALIZAR DADOS DE UM PEDIDO         |");
		System.out.println("|        (4) DELETAR UM PEDIDO                    |");
		System.out.println("|        (5) PROCURAR UM PEDIDO                   |");
		System.out.println("|        (6) GERAR NOTA FISCAL DE UM PEDIDO       |");
		System.out.println("|        (7) SAIR                                 |");
		System.out.println("+=================================================+");
			
		System.out.print("OPCAO: ");
		int op = ler.nextInt();
				
		switch(op) {
			case 1: ped.addPed();
				menuPed();
				break;
			case 2: ped.mostraPed();
				menuPed();
				break;
			case 3: ped.updatePed();
				menuPed();
				break;
			case 4: ped.delPed();
				menuPed();
				break;
			case 5: ped.procuraPed();
				menuPed();
				break;
			case 6: ped.gerarNota();
				menuPed();
				break;
			case 7: voltarMain();
				break;
			default:
				System.out.println("OPCAO INVALIDA");
				menuPed();
				break;
		}
	}	
	
	// FUNÇÃO PARA VOLTAR PRO MAIN
	public void voltarMain() {
		Principal p = new Principal();
		p.menuPrin();
	}
}
