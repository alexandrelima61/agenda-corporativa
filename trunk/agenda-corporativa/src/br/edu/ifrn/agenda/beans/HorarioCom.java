package br.edu.ifrn.agenda.beans;

import java.util.Date;

public class HorarioCom {
	
	private int oid;
	private Date datainicio;
	private Date datafim;
	private boolean ativo;
	
	public HorarioCom() {
		super();
	}

	public HorarioCom(int oid, Date datainicio,
			Date datafim, boolean ativo) {
		super();
		this.oid = oid;
		this.datainicio = datainicio;
		this.datafim = datafim;
		this.ativo = ativo;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Date getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public Date getDatafim() {
		return datafim;
	}

	public void setDatafim(Date datafim) {
		this.datafim = datafim;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}	
	

}
