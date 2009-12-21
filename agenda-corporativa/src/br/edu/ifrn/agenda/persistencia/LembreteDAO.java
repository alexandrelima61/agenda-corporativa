package br.edu.ifrn.agenda.persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.ifrn.agenda.beans.Lembrete;

public class LembreteDAO {

	public LembreteDAO() {

	}

	public void inserirLembrete(String titulo, String corpo, String datas)
			throws SQLException {

		String comando = "insert into tb_lembrete(titulo,corpo) values(?,?)";
		PreparedStatement statement = Conexao.getInstance()
				.getPreparedStatement(comando);

		statement.setString(1, titulo);
		statement.setString(2, corpo);

		statement.execute();
		statement.close();

		String comandoBusca = "SELECT lem_id FROM tb_lembretes WHERE corpo = ?";
		PreparedStatement stmt = Conexao.getInstance().getPreparedStatement(
				comandoBusca);

		stmt.setString(1, corpo);

		ResultSet result = Conexao.getInstance().executeQueryStatement(
				comandoBusca);

		@SuppressWarnings("unused")
		int lem_id;
		while (result.next()) {
			lem_id = result.getInt("lem_id");
		}

		comando = "insert into tb_datas(lem_id, datas) values(?,?)";

		for (int i = 0; i < datas.length(); i++) {
			PreparedStatement statement3 = Conexao.getInstance().getPreparedStatement(comando);
			statement3.execute();
			statement3.close();
		}
	}

	public Lembrete buscarLembretePorData(Date data) {
		String comando = "SELECT  * FROM tb_lembretes  INNER JOIN tb_datas ON  tb_lembrete.id_lem = tb_datas.id_lem WHERE tb_datas.data = ? ";
				
		Lembrete lembrete = null;
		try {
			PreparedStatement statement = Conexao.getInstance().getPreparedStatement(comando);

			statement.setDate(1, data);

			ResultSet result = Conexao.getInstance().executeQueryStatement(comando);
			lembrete = montarLembrete(result);
		} catch (SQLException ex) {
			Logger.getLogger(Lembrete.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return lembrete;
	}
	
	public Lembrete buscarLembretePorTitulo(String titulo) {
		String comando = "SELECT * FROM tb_lembretes INNER JOIN tb_datas ON  tb_lembrete.id_lem = tb_datas.id_lem WHERE tb_lembrete.titulo = ? ";
				
		Lembrete lembrete = null;
		try {
			PreparedStatement statement = Conexao.getInstance().getPreparedStatement(comando);

			statement.setString(1, titulo);

			ResultSet result = Conexao.getInstance().executeQueryStatement(
					comando);
			lembrete = montarLembrete(result);
		} catch (SQLException ex) {
			Logger.getLogger(Lembrete.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return lembrete;
	}
	
	public Lembrete recuperarTodosLembretes() {
		String comando = "SELECT * FROM tb_lembretes INNER JOIN tb_datas ON  tb_lembrete.id_lem = tb_datas.id_lem";

		ResultSet result = Conexao.getInstance().executeQueryStatement(
				comando);
		Lembrete lembrete = montarLembrete(result);
		return lembrete;
	}
	
	public void apagarTodosLembretes() {
		String comando = "DELETE  FROM tb_datas";

		PreparedStatement statement1 = Conexao.getInstance().getPreparedStatement(comando);
		
		try {
			statement1.execute();
			statement1.close();
			
		comando = "DELETE  FROM tb_lembrete";

		PreparedStatement statement2 = Conexao.getInstance().getPreparedStatement(comando);
		
		
			statement2.execute();
			statement2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
			
	}
	
	public Lembrete apagarLembretePorTitulo(String titulo) {
		String comando = "SELECT * FROM tb_lembretes INNER JOIN tb_datas ON  tb_lembrete.id_lem = tb_datas.id_lem WHERE tb_lembrete.titulo = ? ";
		
		Lembrete lembrete;
		
		ResultSet result = Conexao.getInstance().executeQueryStatement(comando);
		lembrete = montarLembrete(result);
		
		int lem_id = 0;
		try {
			while(result.next()){
				 lem_id = result.getInt("lem_id");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
			
			
		
		comando = "DELETE  FROM tb_datas WHERE tb_datas.lem_id = ?";
		

		PreparedStatement statement1 = Conexao.getInstance().getPreparedStatement(comando);
		 
		try {
			statement1.setInt(1, lem_id);
			statement1.execute();
			statement1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		comando = "DELETE  FROM tb_lembrete WHERE tb_lembrete.lem_id = ?";

		PreparedStatement statement2 = Conexao.getInstance().getPreparedStatement(comando);
		try {
			statement2.setInt(1, lem_id);
			statement2.execute();
			statement2.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lembrete;
			
	}
	
	public Lembrete atualizarLembretePorTitulo(String titulo) {
		String comando = "SELECT * FROM tb_lembretes INNER JOIN tb_datas ON  tb_lembrete.id_lem = tb_datas.id_lem WHERE tb_lembrete.titulo = ? ";
		
		Lembrete lembrete;
		
		ResultSet result = Conexao.getInstance().executeQueryStatement(comando);
		lembrete = montarLembrete(result);
		
		int lem_id = 0;
		try {
			while(result.next()){
				 lem_id = result.getInt("lem_id");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
			
		/*UPDATE Persons
		SET Address='Nissestien 67', City='Sandnes'
		WHERE LastName='Tjessem' AND FirstName='Jakob'*/
		
		comando = "UPDATE tb_datas SET data = ? WHERE tb_datas.lem_id = ?";
		PreparedStatement statement1 = Conexao.getInstance().getPreparedStatement(comando);
		
			try {
				statement1.setDate(1, result.getDate("data"));
			
			statement1.setInt(2, lem_id);
			statement1.execute();
			statement1.close();
		
		
		
		comando = "UPDATE tb_lembrete SET titulo = ?,corpo = ? WHERE tb_lembrete.lem_id = ?";

		PreparedStatement statement2 = Conexao.getInstance().getPreparedStatement(comando);
		
			statement2.setString(1, result.getString("titulo"));
			statement2.setString(2, result.getString("corpo"));
			statement2.setInt(3,lem_id);
			
			statement2.execute();
			statement2.close();
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lembrete;
			
	}


	public List<Lembrete> getLembretes() {
		String comando = "SELECT lem_id FROM tb_lembretes";
		List<Lembrete> lista = new ArrayList<Lembrete>();

		PreparedStatement statement;
		try {
			statement = Conexao.getInstance().getPreparedStatement(comando);

			ResultSet result = statement.executeQuery();
			@SuppressWarnings("unused")
			Lembrete lembrete = montarLembrete(result);

			while (result.next()) {
				lista.add(montarLembrete(result));
			}
		} catch (SQLException ex) {
			Logger.getLogger(LembreteDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public Lembrete montarLembrete(ResultSet result){
		Lembrete lembrete = null;
		List<Date> datas = new ArrayList();
		try { 
			while (result.next()) {
				datas.add(result.getDate("data")); 
			}
		} catch (SQLException ex) {
			Logger.getLogger(LembreteDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		try {
			
			lembrete = new Lembrete(result.getString("titulo"),result.getString("corpo"),datas);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lembrete;
	}

}

