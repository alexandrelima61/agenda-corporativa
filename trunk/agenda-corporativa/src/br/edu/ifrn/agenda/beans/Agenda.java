package br.edu.ifrn.agenda.beans;

import java.util.List;

/**
 *
 * @author Rafael
 */
public class Agenda {

// o nome do atributo de identificacao Ž oid	
    private int oid;
    private String titulo;
    private String descricao;
    private boolean ativo = true;

// faltaram a definicao dos relacionamentos
// os atributos precisam de get e set
    private List<Contato> contatos;
    private List<Usuario> usuarios;
    private List<Tarefa> tarefas;
    private List<Compromisso> compromissos;
    private List<Lembrete> lembretes;


    public int getOid() {
        return oid;
    }

    public void setOid(int cod) {
        this.oid = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setCompromissos(List<Compromisso> compromissos) {
		this.compromissos = compromissos;
	}

	public List<Compromisso> getCompromissos() {
		return compromissos;
	}

	public void setLembretes(List<Lembrete> lembretes) {
		this.lembretes = lembretes;
	}

	public List<Lembrete> getLembretes() {
		return lembretes;
	}

// os beans devem ter toString e equals	
	@Override
	public String toString() {
		return "Agenda ID " + this.oid;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Agenda) {
			Agenda agenda = (Agenda) object;
			return this.getOid() == agenda.getOid();
		}
		return super.equals(object);
	}
}