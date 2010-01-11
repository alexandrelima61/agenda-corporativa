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
	
	private static LembreteDAO singleton = new LembreteDAO();
	
	public static LembreteDAO getInstance(){
		return singleton;
	}
	
	
	private Conexao conexao = Conexao.getInstance();



	public Lembrete recuperarPorId(int id){
		String sql = "SELECT * FROM tb_lembrete WHERE lem_id = ?";
		PreparedStatement statement = Conexao.getInstance().getPreparedStatement(sql);
		
		try {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()){
				Lembrete lem = new Lembrete();
				
				lem.setOid(result.getInt("lem_id"));
				lem.setTitulo(result.getString("lem_titulo"));
				lem.setCorpo(result.getString("lem_corpo"));
							
				 return lem;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	public void editarLembrete(Lembrete lembrete) {
		PreparedStatement ps = null;
		try {
			String SQL = "UPDATE tb_lembrete SET lem_titulo = ?, lem_corpo = ?,"
					+ "lem_ativo = ? WHERE lem_id = ?";
			ps = conexao.getPreparedStatement(SQL);
			ps.setString(1, lembrete.getTitulo());
			ps.setString(2, lembrete.getCorpo());
			ps.setBoolean(3, lembrete.isAtivo());
			ps.setInt(4, lembrete.getOid());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.print("Erro ao editar os dados " + ex.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public void inserirLembrete(Lembrete lembrete)
			throws SQLException {

		String comando = "insert into tb_lembrete(titulo,corpo) values(?,?,?)";
		PreparedStatement statement = Conexao.getInstance().getPreparedStatement(comando);

		statement.setInt(1, lembrete.getAgenda().getOid());
		statement.setString(2, lembrete.getTitulo());
		statement.setString(3, lembrete.getCorpo());
		

		statement.execute();
		statement.close();

		String comandoBusca = "SELECT lem_id FROM tb_lembretes WHERE corpo = ?";
		PreparedStatement stmt = Conexao.getInstance().getPreparedStatement(
				comandoBusca);

		stmt.setString(1, lembrete.getCorpo());

		ResultSet result = Conexao.getInstance().executeQueryStatement(
				comandoBusca);

		int lem_id = 0;
		while (result.next()) {
			lem_id = result.getInt("lem_id");
		}

		comando = "insert into tb_lembretes_datas(lem_id, datas) values(?,?)";

		for (Date date : lembrete.getDatas()) {
			PreparedStatement statement3 = Conexao.getInstance().getPreparedStatement(comando);
			statement3.setInt(1, lem_id);
			statement3.setInt(2, date.getDate());
			statement3.execute();
			statement3.close();
		}
	}

	public Lembrete buscarLembretePorData(Date data) {
		String comando = "SELECT  * FROM tb_lembretes  INNER JOIN tb_lembretes_datas ON  tb_lembrete.id_lem = tb_lembretes_datas.id_lem WHERE tb_lembretes_datas.data = ? ";
				
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
		String comando = "SELECT * FROM tb_lembretes INNER JOIN tb_lembretes_datas ON  tb_lembrete.id_lem = tb_lembretes_datas.id_lem WHERE tb_lembrete.titulo = ? ";
				
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
	
	public void apagarTodosLembretes() {
		String comando = "DELETE  FROM tb_lembretes_datas";

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
		String comando = "SELECT * FROM tb_lembretes INNER JOIN tb_lembretes_datas ON  tb_lembrete.id_lem = tb_lembretes_datas.id_lem WHERE tb_lembrete.titulo = ? ";
		
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
		
		
			
			
		
		comando = "DELETE  FROM tb_lembretes_datas WHERE tb_lembretes_datas.lem_id = ?";
		

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
		String comando = "SELECT * FROM tb_lembretes INNER JOIN tb_lembretes_datas ON  tb_lembrete.id_lem = tb_lembretes_datas.id_lem WHERE tb_lembrete.titulo = ? ";
		
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
		
		
			
		
		
		comando = "UPDATE tb_lembretes_datas SET data = ? WHERE tb_lembretes_datas.lem_id = ?";
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
				
				e.printStackTrace();
			}
			return lembrete;
			
	}
	
	public List<Lembrete> recuperarTodosLembretes() throws SQLException {
		List<Lembrete> lista = new ArrayList<Lembrete>();
		String comando = "SELECT tb_lembrete.lem_id, tb_lembrete.age_id, tb_lembrete.lem_titulo, tb_lembrete.lem_corpo, tb_lembrete.lem_ativo, tb_agenda.age_id AS Expr1, tb_agenda.age_titulo, tb_agenda.age_descricao, tb_agenda.age_ativo, tb_lembretes_datas.lem_id AS Expr2, tb_lembretes_datas.lem_dat_data" +
						"FROM tb_lembrete INNER JOIN tb_agenda ON tb_lembrete.age_id = tb_agenda.age_id INNER JOIN tb_lembretes_datas ON tb_lembrete.lem_id = tb_lembretes_datas.lem_id" +
						"WHERE  tb_agenda.age_id = ?" +
						"ORDER BY tb_lembretes_datas.lem_dat_data";
		PreparedStatement statement;
		statement = conexao.getPreparedStatement(comando);
		ResultSet result = statement.executeQuery();
		while(result.next()){
			Lembrete temp = montarLembrete(result);
			lista.add(temp);
		}
		return lista;
}

	@SuppressWarnings("unchecked")
	public Lembrete montarLembrete(ResultSet result){
		Lembrete lembrete = null;
		List<Date> datas = new ArrayList();
		lembrete = new Lembrete();
		try { 
			while (result.next()) {
				datas.add(result.getDate("data")); 
				lembrete.setTitulo(result.getString("titulo"));
				lembrete.setCorpo(result.getString("corpo"));
				lembrete.setDatas(datas);
			}
		} catch (SQLException ex) {
			Logger.getLogger(LembreteDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		return lembrete;
	}

}

