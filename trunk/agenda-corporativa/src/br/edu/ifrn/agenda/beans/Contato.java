package br.edu.ifrn.agenda.beans;

import java.util.List;

public class Contato {

// todos os beans devem ter um identificador	
	private int oid;
	private String  nome;
	private String telefone;
	private String email;
	private String endereco;
// todos as informacoes devem ter um flag
	private boolean ativo;
	
// segundo o modelo, os contatos devem ter uma agenda	
	private Agenda agenda;
	
	public void setOid(int oid){
		this.oid = oid;
	}
	
	public int getOid(){
		return this.oid;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public boolean isAtivo() {
		return ativo;
	}

// os beans devem ter toString e equals	
	@Override
	public String toString() {
		return "Contado ID " + this.oid;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
