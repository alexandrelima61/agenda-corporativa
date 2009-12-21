package br.edu.ifrn.agenda.beans;

import java.util.Date;

public class HorarioCom {
	
	private int oid;
	private Date dataInicio;
	private Date dataFim;
	private boolean ativo;
	
	public HorarioCom() {
		super();
	}

	public HorarioCom(int oid, Date datainicio,
			Date datafim, boolean ativo) {
		super();
		this.oid = oid;
		this.dataInicio = datainicio;
		this.dataFim = datafim;
		this.ativo = ativo;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date datainicio) {
		this.dataInicio = datainicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date datafim) {
		this.dataFim = datafim;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}	
	

}
