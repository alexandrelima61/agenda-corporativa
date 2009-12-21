package br.edu.ifrn.agenda.beans;

import java.util.Date;
import java.util.List;

public class Compromisso {
	private int oid;

// Como estamos trabalhando com objetos, nada de idOutroObjeto
	// private int idUsuario;
	// private int idAgenda;
	
	private boolean ativo;
	private String local;
	private String titulo;
	private String descricao;
	private List<Date> datas;
	private Usuario proprietario;
	private List<Usuario> participantes;
	private Agenda agenda;

// Sempre deve ter um construtor sem parametro para os beans	
	public Compromisso() {
		super();
	}

// Como não tem idOutroObjeto também não tem métodos de acesso
//	public int getIdUsuario() {
//		return idUsuario;
//	}
//
//	public void setIdUsuario(int idUsuario) {
//		this.idUsuario = idUsuario;
//	}
//
//	public int getIdAgenda() {
//		return idAgenda;
//	}
//
//	public void setIdAgenda(int idAgenda) {
//		this.idAgenda = idAgenda;
//	}

	public int getOid() {
		return oid;
	}

	public void setOid(int idCompromisso) {
		this.oid = idCompromisso;
	}

	public List<Date> getDatas() {
		return datas;
	}

	public void setDatas(List<Date> datas) {
		this.datas = datas;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}

	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}

	public Usuario getProprietario() {
		return proprietario;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Agenda getAgenda() {
		return agenda;
	}

// Os métodos toString e equals devem ser implementados	
	@Override
	public String toString() {
		return "Compromisso ID " + this.oid;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Compromisso) {
			Compromisso compromisso = (Compromisso) object;
			return this.getOid() == compromisso.getOid();
		}
		return false;
	}
		
}
