package br.edu.ifrn.agenda.beans;

import java.util.Date;

public class Tarefa {
	
	private String titulo;
	private Prioridade prioridade;
	private EstadoTarefa estado = EstadoTarefa.ABERTO;
	private Date data;
	private String local;
	private String descricao;
	
	
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
	
}