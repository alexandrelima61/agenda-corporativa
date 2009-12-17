package br.edu.ifrn.agenda.beans;

public class Contato {
	
	private String  nome;
	private String[] telefone;
	private String[] email;
	private String endereco;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	public void setTelefone(String[] telefone) {
		this.telefone = telefone;
	}
	
	public String[] getTelefone() {
		return telefone;
	}
	
	public void setEmail(String[] email) {
		this.email = email;
	}
	
	public String[] getEmail() {
		return email;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return endereco;
	}
}
