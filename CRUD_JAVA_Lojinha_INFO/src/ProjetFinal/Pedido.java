package ProjetFinal;
	import java.util.Date;

public class Pedido {

	// ATRIBUTOS
	private int numero;
	private Date data_pedido;
	private String forma_pg;
	private String cliente;
	private int produto;
	private int qtde_prod;
	
	// CONSTRUTOR
	public Pedido() {
		// sem parâmetros
	}
	public Pedido(int numero) {
		this.numero = numero;
	}
	public Pedido(int numero, String forma_pg, String cliente, int produto, int qtde_prod) {
		this.numero = numero;
		//this.data_pedido = data_pedido;
		this.forma_pg = forma_pg;
		this.cliente = cliente;
		this.produto = produto;
		this.qtde_prod = qtde_prod;
	}
	
	// GETTERS E SETTERS
		public int getNumero() {
			return numero;
		}
		public void setNumero(int numero) {
			this.numero = numero;
		}
		public Date getData_pedido() {
			return data_pedido;
		}
		public void setData_pedido(Date data_pedido) {
			this.data_pedido = data_pedido;
		}
		public String getForma_pg() {
			return forma_pg;
		}
		public void setForma_pg(String forma_pg) {
			this.forma_pg = forma_pg;
		}
		public String getCliente() {
			return cliente;
		}
		public void setCliente(String cliente) {
			this.cliente = cliente;
		}
		public int getProduto() {
			return produto;
		}
		public void setProduto(int produto) {
			this.produto = produto;
		}
		public int getQtde_prod() {
			return qtde_prod;
		}
		public void setQtde_prod(int qtde_prod) {
			this.qtde_prod = qtde_prod;
		}
}
