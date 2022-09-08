package ProjetFinal;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

public class daoProduto {
	// ATRIBUTOS
	private Connection conn;
	
	// CONSTRUTOR
	public daoProduto() {
		this.conn = conexao.getConnection();
	}
	
	// FUNÇÃO ADICIONAR PRODUTOS =============================
	public void addProduto(Produto prod) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = conexao.getConnection();
			stmt = conn.prepareStatement("insert into produtos(codigo, descricao, valor_unit) values(?, ?, ?)");
				stmt.setInt(1, prod.getCodigo());
				stmt.setString(2, prod.getDescricao());
				stmt.setDouble(3, prod.getValor_unit());
				
			// pergunta quantas linhas (rows) forma inseridas
				int rowsInserted = stmt.executeUpdate();
			// se o numero de linhas inseridas forem maior que zero
				if(rowsInserted > 0) {
					System.out.println("Produto cadastrado com sucesso.");
				}
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
		
	// FUNÇÃO MOSTRAR PRODUTOS =============================
	public void mostraProduto() {
		try {
			Statement s = conn.createStatement();
			ResultSet stmt = s.executeQuery("select * from produtos order by codigo asc");
				
			while(stmt.next()) {
				int codigo = stmt.getInt(1);
				String descricao = stmt.getString(2);
				double valor_unit = stmt.getDouble(3);
					
				String output = "PRODUTO: %s - %s - %s";
				System.out.println(String.format(output, codigo, descricao, valor_unit));
			}	
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// FUNÇÃO ATUALIZAR PRODUTOS =============================
	public void updateProduto(Produto prod) {	
		Connection conn = null;
	    PreparedStatement stmt = null;
		try {
			conn = conexao.getConnection();
			stmt = conn.prepareStatement("update produtos set descricao=?, valor_unit=? where codigo=?");	
				stmt.setString(1, prod.getDescricao());
				stmt.setDouble(2, prod.getValor_unit());
				stmt.setInt(3, prod.getCodigo());
				stmt.execute();
						
			// pergunta quantas linhas (rows) forma inseridas
				int rowsInserted = stmt.executeUpdate(); 
			// se o numero de linhas inseridas forem maior que zero
				if(rowsInserted > 0) { 
					System.out.println("Produto atualizado com sucesso.");
				}	
				stmt.close();	
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// FUNÇÃO DELETAR PRODUTOS =============================
	public void deleteProduto(Produto prod) {
		Connection conn = null;
		PreparedStatement stmt = null;
	    try {
	        conn = conexao.getConnection();
	        stmt = conn.prepareStatement("delete from produtos where codigo=?");
	        	stmt.setInt(1, prod.getCodigo());
	        	stmt.execute();
	        		System.out.println("Produto deletado com sucesso.");
	        	stmt.close();
				
	       }catch (SQLException e) {
	        	throw new RuntimeException(e);
	        }
	    }
	
	//FUNÇÃO PARA PROCURAR UM PRODUTO
		public void procuraProduto(Produto prod) {
			Connection conn = null;
		    PreparedStatement stmt = null;
	        try {
	        	conn = conexao.getConnection();
	        	stmt = conn.prepareStatement("select * from produtos where codigo=?");
	        	stmt.setInt(1, prod.getCodigo());
	        	stmt.execute();
	        	stmt.close();
	        	
	        	int x = prod.getCodigo();
	        	Statement s = conn.createStatement();
				ResultSet stmt1 = s.executeQuery("select * from produtos where codigo = "+x);
			
				while(stmt1.next()) {		
					int codigo = stmt1.getInt(1);
					String descricao = stmt1.getString(2);
					double valor_unit = stmt1.getDouble(3);
					
							
					System.out.println("Codigo do Produto: " + codigo);
					System.out.println("Descricao do Produto: " + descricao);
					System.out.println("Valor Unitario: R$" + valor_unit);
				}
	        }catch (SQLException e) {
		        	throw new RuntimeException(e);
		    }
		}
}