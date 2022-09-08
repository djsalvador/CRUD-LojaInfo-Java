package ProjetFinal;
	import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Principal menu = new Principal();
		menu.menuPrin();
	}
	
	public void menuPrin() {
		System.out.println();
		System.out.println("+================================================+");
		System.out.println("| SISTEMA LOJINHA DE INFORMATICA DO SALVADOR 8^) |");
		System.out.println("+================================================+");
		System.out.println("| ENTRE COM A OPCAO:                             |");
		System.out.println("|      (1) MODULO CLIENTES                       |");
		System.out.println("|      (2) MODULO PRODUTOS                       |");
		System.out.println("|      (3) MODULO PEDIDOS                        |");
		System.out.println("|      (4) SAIR DO SISTEMA                       |");
		System.out.println("+================================================+");
		
		Scanner ler = new Scanner(System.in);
		System.out.print("OPCAO: ");
			int opcao = ler.nextInt();
		
		menu menu = new menu();
			
		switch(opcao){
			case 1:
				menu.menuCli();
				break;
			case 2:
				menu.menuProd();
				break;
			case 3:
				menu.menuPed();
				break;
			case 4:
				ler.close();
				System.out.println("Sistema encerrado. Obrigado por me usar. 8^)");
				break;
			default:
				System.out.println("OPCAO INVALIDA.");
				menuPrin();
				break;
		}
	}
	
}