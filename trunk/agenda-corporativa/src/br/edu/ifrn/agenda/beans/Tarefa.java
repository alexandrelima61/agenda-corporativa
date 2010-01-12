package br.edu.ifrn.agenda.beans;

import java.util.Date;

public class Tarefa {

// faltou o identificador
	private int oid;
	private String titulo;
	private Prioridade prioridade;
	private EstadoTarefa estado = EstadoTarefa.ABERTO;
	private Date data;
	private String local;
	private String descricao;
	private boolean ativo;
// faltou os relacionamentos com agenda e com usuario
	private Agenda agenda;
	private Usuario usuario;

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Prioridade getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
	
	public EstadoTarefa getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoTarefa estado) {
		this.estado = estado;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}	
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getOid() {
		return oid;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
// deve ter toString e equals implementado	
	@Override
	public String toString() {
		return "Tarefa ID " + this.oid;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Tarefa) {
			Tarefa tarefa = (Tarefa) object;
			return this.getOid() == tarefa.getOid();
		}
		
		return false;
	}
	
}