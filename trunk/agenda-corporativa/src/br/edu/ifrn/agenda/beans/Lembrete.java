package br.edu.ifrn.agenda.beans;

import java.sql.Date;
import java.util.List;

public class Lembrete {
	

	private int oid;
	private String titulo, corpo;

	private List<Date> datas;

	private boolean ativo;

	private Agenda agenda;
	
	public Lembrete() {
		super();
	}
	

	public Lembrete(String titulo, String corpo, List<Date> datas) {
		this();
		this.titulo = titulo;
		this.corpo = corpo;
		this.datas = datas;
	}



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public List<Date> getDatas() {
		return datas;
	}

	public void setDatas(List<Date> datas) {
		this.datas = datas;
	}
	
	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getOid() {
		return oid;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Agenda getAgenda() {
		return agenda;
	}


	public void adicionarData(Date data){
		this.datas.add(data);
	}

	public void removerData(Date data) {
		this.datas.remove(data);
	}


	@Override
	public String toString() {
		return "Lembrete ID " + this.oid;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Lembrete) {
			Lembrete lembrete = (Lembrete) object;
			return this.getOid() == lembrete.getOid();
		}
		return false;
	}
}
