package br.edu.ifrn.agenda.beans;

import java.util.Date;

public class Lembrete {
	private String titulo, corpo;
	private Date[] datas;

	public Lembrete() {
		super();
	}
	

	public Lembrete(String titulo, String corpo, Date[] datas) {
		super();
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

	public Date[] getDatas() {
		return datas;
	}

	public void setDatas(Date[] datas) {
		this.datas = datas;
	}
	
	
	@SuppressWarnings("null")
	public void adicionarData(Date data){
		Date[] copia = null;
		System.arraycopy(this.getDatas(), 0, copia, 0, this.getDatas().length);
		copia[(this.getDatas().length+1)] = data;
		this.setDatas(copia);
	}

}
