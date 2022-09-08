package ProjetFinal;

public class Cliente {

	// ATRIBUTOS
	private String cpf;
	private String nome;
	private String telefone;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	
	// Construtores
	public Cliente() {
		// sem parâmetros
	}
	public Cliente(String cpf) {
		this.cpf = cpf;
	}
	public Cliente(String cpf, String nome, String telefone, String rua, String bairro, String cidade, String estado) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	// Getters e Setters
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
