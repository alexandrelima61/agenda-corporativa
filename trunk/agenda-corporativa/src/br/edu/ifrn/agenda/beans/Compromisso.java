package br.edu.ifrn.agenda.beans;

import java.util.ArrayList;
import java.util.Date;

public class Compromisso {
	private int idUsuario;
	private int idAgenda;
	private int idCompromisso;
	private ArrayList<Date> datas;
	private String local;
	private String titulo;
	private String descricao;
	private boolean ativo;
	private ArrayList<Usuario> participantes;
	
	public Compromisso(int idUsuario, int idAgenda, int idCompromisso,
			ArrayList<Date> datas, String local, String titulo,
			String descricao, boolean ativo, ArrayList<Usuario> participantes) {
		super();
		this.idUsuario = idUsuario;
		this.idAgenda = idAgenda;
		this.idCompromisso = idCompromisso;
		this.datas = datas;
		this.local = local;
		this.titulo = titulo;
		this.descricao = descricao;
		this.ativo = ativo;
		this.participantes = participantes;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}

	public int getIdCompromisso() {
		return idCompromisso;
	}

	public void setIdCompromisso(int idCompromisso) {
		this.idCompromisso = idCompromisso;
	}

	public ArrayList<Date> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<Date> datas) {
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

	public ArrayList<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Usuario> participantes) {
		this.participantes = participantes;
	}
	
		
}
