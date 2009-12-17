package br.edu.ifrn.agenda.persistencia;

import java.sql.ResultSet;

public class TarefaDAO {
	
	private Conexao conexao = Conexao.getInstance();
	
	public Tarefa retornaTarefa(){
		
		ResultSet rs = conexao.executeQueryStatement("select * from ");
		
	}
	
}