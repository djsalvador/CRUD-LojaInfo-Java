package ProjetFinal;
	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Calendar;

public class daoPedido {
	// ATRIBUTOS
	private Connection conn;
		
	// CONSTRUTOR
	public daoPedido() {
		this.conn = conexao.getConnection();
	}
		
	// FUNÇÃO ADICIONAR PEDIDO =============================
	public void addPedido(Pedido ped) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = conexao.getConnection();
			stmt = conn.prepareStatement("insert into pedido(numero, data_pedido, forma_pg, cliente, produto, qtde_prod) values(?, ?, ?, ?, ?, ?)");
					stmt.setInt(1, ped.getNumero());
					stmt.setDate(2, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
					stmt.setString(3, ped.getForma_pg());
					stmt.setString(4, ped.getCliente());
					stmt.setInt(5, ped.getProduto());
					stmt.setInt(6, ped.getQtde_prod());
					
			// pergunta quantas linhas (rows) forma inseridas
				int rowsInserted = stmt.executeUpdate();
			// se o numero de linhas inseridas forem maior que zero
				if(rowsInserted > 0) {
					System.out.println("Pedido realizado com sucesso.");
				}
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
			
	// FUNÇÃO MOSTRAR PEDIDOS =============================
	public void mostraPedido() {
		try {
			Statement s = conn.createStatement();
			ResultSet stmt = s.executeQuery("select pedido.numero, clientes.nome, pedido.data_pedido, produtos.descricao, "
					+ "pedido.qtde_prod, produtos.valor_unit, (produtos.valor_unit * pedido.qtde_prod) as "
					+ "valor_total from clientes, pedido, produtos where clientes.cpf = pedido.cliente and "
					+ "produtos.codigo = pedido.produto order by pedido.numero;");
				
			while(stmt.next()) {
				int numero = stmt.getInt(1);
				String nome = stmt.getString(2);
				Date data_pedido = stmt.getDate(3);
				String descricao = stmt.getString(4);
				int qtde_prod = stmt.getInt(5);
				double valor_unit = stmt.getDouble(6);
				double valor_total = stmt.getDouble(7);
					
				String output = "PEDIDO: %s - %s - %s - %s - %s - %s - %s";
				System.out.println(String.format(output, numero, nome, data_pedido, descricao, qtde_prod, valor_unit, valor_total));
			}	
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// FUNÇÃO ATUALIZAR PEDIDOS =============================
	public void updatePedido(Pedido ped) {	
		Connection conn = null;
	    PreparedStatement stmt = null;
		try {
			conn = conexao.getConnection();
			stmt = conn.prepareStatement("update pedido set data_pedido=?, forma_pg=?, cliente=?, produto=?, qtde_prod=? where numero=?");	
				stmt.setDate(1, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
				stmt.setString(2, ped.getForma_pg());
				stmt.setString(3, ped.getCliente());
				stmt.setInt(4, ped.getProduto());
				stmt.setInt(5, ped.getQtde_prod());
				stmt.setInt(6, ped.getNumero());
				stmt.execute();
						
			// pergunta quantas linhas (rows) forma inseridas
				int rowsInserted = stmt.executeUpdate(); 
			// se o numero de linhas inseridas forem maior que zero
				if(rowsInserted > 0) { 
					System.out.println("Pedido atualizado com sucesso.");
				}	
				stmt.close();	
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// FUNÇÃO DELETAR PEDIDO =============================
	public void deletePedido(Pedido ped) {
		Connection conn = null;
		PreparedStatement stmt = null;
	    try {
	        conn = conexao.getConnection();
	        stmt = conn.prepareStatement("delete from pedido where numero=?");
	        	stmt.setInt(1, ped.getNumero());
	        	stmt.execute();
	        		System.out.println("Pedido deletado com sucesso.");
	        	stmt.close();
				
	       }catch (SQLException e) {
	        	throw new RuntimeException(e);
	        }
	    }

	//FUNÇÃO PARA PROCURAR UM PEDIDO
	public void procuraPedido(Pedido ped) {
		Connection conn = null;
		PreparedStatement stmt = null;
			try {
				conn = conexao.getConnection();
		        stmt = conn.prepareStatement("select * from pedido where numero=?");
		        stmt.setInt(1, ped.getNumero());
		        stmt.execute();
		        stmt.close();
		        	
		        int x = ped.getNumero();
		        Statement s = conn.createStatement();
				ResultSet stmt1 = s.executeQuery("select * from pedido where numero = "+x);
				
				while(stmt1.next()) {		
					int numero = stmt1.getInt(1);
					Date data_pedido = stmt1.getDate(2);
					String forma_pg = stmt1.getString(3);
					String cliente = stmt1.getString(4);
					int produto = stmt1.getInt(5);
					int qtde_prod = stmt1.getInt(6);
							
					System.out.println("Numero do Pedido: " + numero);
					System.out.println("Data do Pedido: " + data_pedido);
					System.out.println("Forma de Pagamento: " + forma_pg);
					System.out.println("CPF do Cliente: " + cliente);
					System.out.println("Codigo do Produto: " + produto);
					System.out.println("Quantidade do Produto: " + qtde_prod);
				}
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
	
	// FUNÇÃO GERAR NOTA FISCAL =============================
	public void gerarNota(Pedido ped) {
		
		int x = ped.getNumero();
		
		System.out.println();
		try {
			Statement s = conn.createStatement();
			ResultSet stmt = s.executeQuery("select pedido.numero, clientes.nome, pedido.data_pedido, "
					+ "produtos.descricao,  pedido.qtde_prod, produtos.valor_unit, "
					+ "(produtos.valor_unit * pedido.qtde_prod) as valor_total "
					+ "from clientes, pedido, produtos where clientes.cpf = pedido.cliente "
					+ "and produtos.codigo = pedido.produto and numero="+x);
        	
			while(stmt.next()) {
				int numero = stmt.getInt(1);
				String nome = stmt.getString(2);
				Date data_pedido = stmt.getDate(3);
				String descricao = stmt.getString(4);
				int qtde_prod = stmt.getInt(5);
				double valor_unit = stmt.getDouble(6);
				double valor_total = stmt.getDouble(7);
					
				System.out.println("+=========================================================================================+");
				System.out.println("| NOTA FISCAL                                                                             |");
				System.out.println("| NUMERO DO PEDIDO: "+numero+"  CLIENTE: "+nome+"  DATA: "+data_pedido);
				System.out.println("|=========================================================================================|");
				System.out.println("|   PRODUTO            QTDE               VALOR UNITARIO              VALOR TOTAL         |");
				System.out.println("|=========================================================================================|");
				System.out.println("|"+descricao+"      "+qtde_prod+"            "+valor_unit+"                "+valor_total);
			}	
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}	
}
