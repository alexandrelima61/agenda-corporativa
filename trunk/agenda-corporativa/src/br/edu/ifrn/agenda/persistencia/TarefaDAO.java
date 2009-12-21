package br.edu.ifrn.agenda.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifrn.agenda.beans.Agenda;
import br.edu.ifrn.agenda.beans.Tarefa;

public class TarefaDAO {
	
	private Conexao conexao = null;
	
	public TarefaDAO(){
		conexao = Conexao.getInstance();
	}

	// nome errado da tarefa!!!
	public Tarefa retornaTarefa(){
		
		ResultSet rs = conexao.executeQueryStatement("select * from Tarefa");
		
		return null;		
	}
	
	public Tarefa retornaTarefaPorId(int id) throws SQLException{
		
		PreparedStatement stmt = conexao.getPreparedStatement("select * from tb_tarefa where tar_id = ?");
		
		stmt.setInt(1, id);
		
		
		
	}
	
	private Tarefa gerarTarefa(ResultSet rs) throws SQLException{
		
		Tarefa tarefa = new Tarefa();
		
		if(rs.next()){
			
			//tarefa.setAgenda(new AgendaDAO().recuperarPorId());
			tarefa.setData(rs.getDate("tar_data"));
			
		}
		
	}
	
	// falta métodos de inserir, salvar, recuperarTodos, recuperarPorOid, remover
	
}