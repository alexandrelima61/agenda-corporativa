package br.edu.ifrn.agenda.beans;


import java.util.List;

public class Compromisso {
	private int oid;	
	private boolean ativo;
	private String local;
	private String titulo;
	private String descricao;
	private List<HorarioCompromisso> datas;
	private Usuario proprietario;
	private List<Usuario> participantes;
	private Agenda agenda;


	public Compromisso() {
		super();
	}	
	

	public int getOid() {
		return oid;
	}

	public Compromisso(int oid, boolean ativo, String local, String titulo,
		String descricao, List<HorarioCompromisso> datas, Usuario proprietario,
		List<Usuario> participantes, Agenda agenda) {
	super();
	this.oid = oid;
	this.ativo = ativo;
	this.local = local;
	this.titulo = titulo;
	this.descricao = descricao;
	this.datas = datas;
	this.proprietario = proprietario;
	this.participantes = participantes;
	this.agenda = agenda;
}

	public void setOid(int idCompromisso) {
		this.oid = idCompromisso;
	}

	public List<HorarioCompromisso> getDatas() {
		return datas;
	}

	public void setDatas(List<HorarioCompromisso> datas) {
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
