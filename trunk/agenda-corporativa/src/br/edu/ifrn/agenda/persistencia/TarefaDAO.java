package br.edu.ifrn.agenda.persistencia;

import java.sql.ResultSet;

import br.edu.ifrn.agenda.beans.Tarefa;

public class TarefaDAO {
	
	private Conexao conexao = null;
	
	public TarefaDAO(){
		conexao = Conexao.getInstance();
	}

	// nome errado da tarefa!!!
	public Tarefa retornaTarefa(){
		
		ResultSet rs = conexao.executeQueryStatement("select * from ");
		
		return null;		
	}
	
	// falta métodos de inserir, salvar, recuperarTodos, recuperarPorOid, remover
	
}