package ProjetFinal;
	import java.util.Scanner;

public class controllerProd {
	// INSTANCIANDO DAOPRODUTO
	daoProduto daoProd = new daoProduto();
	Scanner lerProd = new Scanner(System.in);
		
	//FUNÇÃO PARA ADICIONAR PRODUTOS ===============1
	public void addProd(){
	System.out.println("+=====================================+");
	System.out.println("| - ADICIONANDO NOVO PRODUTO:         |");
	System.out.println("+=====================================+");
	System.out.println("");
	
	System.out.print("CODIGO: ");
		int codigo = lerProd.nextInt();
		clearBuffer(lerProd);
	System.out.print("DESCRICAO: ");
		String descricao = lerProd.nextLine();
	System.out.print("VALOR UNITARIO: R$ ");
		Double valor_unit = lerProd.nextDouble();	
	// INSTANCIANDO PRODUTO
	Produto prod = new Produto(codigo, descricao, valor_unit);	
	// INSTANCIANDO DAO DO PRODUTO
	daoProduto daoProd = new daoProduto();
		daoProd.addProduto(prod);
	}			
		
	//FUNÇÃO PARA MOSTRAR TODOS OS PRODUTOS ============2
	public void mostraProd() {
	System.out.println("+=====================================+");
	System.out.println("| - LISTANDO TODOS OS PRODUTOS:       |");
	System.out.println("+=====================================+");
		daoProd.mostraProduto();
	}
		
	//FUNÇÃO PARA ATUALIZAR PRODUTOS ===============3
	public void updateProd() {
	System.out.println("+=====================================+");
	System.out.println("| - ATUALIZANDO UM PRODUTO:           |");
	System.out.println("+=====================================+");
	System.out.println("");

	System.out.print("CODIGO: ");
		int codigo = lerProd.nextInt();
		clearBuffer(lerProd);
	System.out.print("DESCRICAO DO PRODUTO: ");
		String descricao = lerProd.nextLine();
	System.out.print("VALOR UNITARIO: R$ ");
		double valor_unit = lerProd.nextDouble();
	// INSTANCIANDO PRODUTO
	Produto prod = new Produto(codigo, descricao, valor_unit);
	// INSTANCIANDO DAO DO PRODUTO
	daoProd.updateProduto(prod);
	}
		
	//FUNÇÃO PARA DELETAR PRODUTOS ===============4
	public void delProd() {
	System.out.println("+=====================================+");
	System.out.println("| - DELETANDO PRODUTOS:               |");
	System.out.println("+=====================================+");
	System.out.println("");	

	System.out.print("CODIGO: ");
		int codigo = lerProd.nextInt();		
	// INSTANCIANDO PRODUTO
	Produto prod = new Produto(codigo);
	// INSTANCIANDO DAO DO PRODUTO
	daoProd.deleteProduto(prod);
	}
		
	//FUNÇÃO PARA PROCURAR UM PRODUTO ===============5
	public void procuraProd() {
	System.out.println("+=====================================+");
	System.out.println("| - PROCURANDO UM PRODUTO:            |");
	System.out.println("+=====================================+");
	System.out.println("");	

	System.out.print("CODIGO: ");
		int codigo = lerProd.nextInt();		
	// INSTANCIANDO PRODUTO
	Produto prod = new Produto(codigo);
	// INSTANCIANDO DAO DO PRODUTO
	daoProd.procuraProduto(prod);
	}
		
	// FUNÇÃO PARA LIMPAR BUFFER DO NEXTLINE()
	private static void clearBuffer(Scanner scanner) {
		if (scanner.hasNextLine()) {
			scanner.nextLine();
	    }
	}
}
