package br.edu.ifrn.agenda.beans;

public class Usuario {

	private int oid;
	private String nome;
	private String apelido;
	private String senha;
	private boolean ativado;
	
	
	
	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getOid() {		
		return this.oid;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getApelido() {
		return apelido;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setAtivado(boolean ativado) {
		this.ativado = ativado;
	}

	public boolean isAtivado() {
		return ativado;
	}

	@Override
	public String toString() {
		return "Usuario ID " + this.oid;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Usuario) {
			Usuario usuario = (Usuario) object;
			return this.getOid() == usuario.getOid();
		}
		return false;
	}

}
