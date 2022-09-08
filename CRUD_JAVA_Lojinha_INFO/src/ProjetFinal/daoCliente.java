package ProjetFinal;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

public class daoCliente {
	
	// ATRIBUTOS
	private Connection conn;
			
	// CONSTRUTOR
	public daoCliente() {
		this.conn = conexao.getConnection();
	}
			
	// FUNÇÃO ADICIONAR CLIENTES =============================
	public void addCliente(Cliente cli) {	
		Connection conn = null;
        PreparedStatement stmt = null;
		try {
			conn = conexao.getConnection();
			stmt = conn.prepareStatement("insert into clientes (cpf, nome, telefone, rua, bairro, cidade, estado) values (?, ?, ?, ?, ?, ?, ?)");	
				stmt.setString(1, cli.getCpf());
				stmt.setString(2, cli.getNome());
				stmt.setString(3, cli.getTelefone());
				stmt.setString(4, cli.getRua());
				stmt.setString(5, cli.getBairro());
				stmt.setString(6, cli.getCidade());
				stmt.setString(7, cli.getEstado());
					
		// pergunta quantas linhas (rows) forma inseridas
			int rowsInserted = stmt.executeUpdate(); 
		// se o numero de linhas inseridas forem maior que zero
			if(rowsInserted > 0) { 
				System.out.println("Cliente inserido com sucesso.");
			}
				stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
			
	// FUNÇÃO MOSTRAR CLIENTES =============================
	public void mostraCliente() {
		try {
			Statement s = conn.createStatement();
			ResultSet stmt = s.executeQuery("select * from clientes order by cpf asc");
					
			while(stmt.next()) {
				String cpf = stmt.getString(1);
				String nome = stmt.getString(2);
				String telefone = stmt.getString(3);
				String rua = stmt.getString(4);
				String bairro = stmt.getString(5);
				String cidade = stmt.getString(6);
				String estado = stmt.getString(7);
						
				String output = "CLIENTE: %s - %s - %s - %s - %s - %s - %s";
					System.out.println(String.format(output, cpf, nome, telefone, rua, bairro, cidade, estado));
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// FUNÇÃO ATUALIZAR CLIENTES =============================
	public void updateCliente(Cliente Cli) {	
		Connection conn = null;
	    PreparedStatement stmt = null;
		try {
			conn = conexao.getConnection();
			stmt = conn.prepareStatement("update clientes set nome=?, telefone=?, rua=?, bairro=?, cidade=?, estado=? where cpf=?");	
				stmt.setString(1, Cli.getNome());
				stmt.setString(2, Cli.getTelefone());
				stmt.setString(3, Cli.getRua());
				stmt.setString(4, Cli.getBairro());
				stmt.setString(5, Cli.getCidade());
				stmt.setString(6, Cli.getEstado());
				stmt.setString(7, Cli.getCpf());		
				stmt.execute();
						
			// pergunta quantas linhas (rows) forma inseridas
				int rowsInserted = stmt.executeUpdate(); 
			// se o numero de linhas inseridas forem maior que zero
				if(rowsInserted > 0) { 
					System.out.println("Cliente atualizado com sucesso.");
				}	
				stmt.close();	
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// FUNÇÃO DELETAR CLIENTES =============================
	public void deleteCliente(Cliente Cli) {
		Connection conn = null;
	    PreparedStatement stmt = null;
        try {
        	conn = conexao.getConnection();
        	stmt = conn.prepareStatement("delete from clientes where cpf=?");
        	stmt.setString(1, Cli.getCpf());
        	stmt.execute();
        		System.out.println("Cliente deletado com sucesso.");
        	stmt.close();
			
       }catch (SQLException e) {
        	throw new RuntimeException(e);
        }
    }	
	
	//FUNÇÃO PARA PROCURAR UM CLIENTE
	public void procuraCliente(Cliente Cli) {
		Connection conn = null;
	    PreparedStatement stmt = null;
        try {
        	conn = conexao.getConnection();
        	stmt = conn.prepareStatement("select * from clientes where cpf=?");
        	stmt.setString(1, Cli.getCpf());
        	stmt.execute();
        	stmt.close();
        	
        	String x = Cli.getCpf();
        	Statement s = conn.createStatement();
			ResultSet stmt1 = s.executeQuery("select * from clientes where cpf = "+x);
		
			while(stmt1.next()) {		
				String cpf = stmt1.getString(1);
				String nome = stmt1.getString(2);
				String telefone = stmt1.getString(3);
				String rua = stmt1.getString(4);
				String bairro = stmt1.getString(5);
				String cidade = stmt1.getString(6);
				String estado = stmt1.getString(7);
						
				System.out.println("Nome do Cliente: " + nome);
				System.out.println("CPF: " + cpf);
				System.out.println("Telefone: " + telefone);
				System.out.println("Rua: " + rua);
				System.out.println("Bairro: " + bairro);
				System.out.println("Cidade: " + cidade);
				System.out.println("Estado: " + estado);
			}
        }catch (SQLException e) {
	        	throw new RuntimeException(e);
	    }
	}
}