package br.edu.ifrn.agenda.persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.agenda.beans.EstadoTarefa;
import br.edu.ifrn.agenda.beans.Prioridade;
import br.edu.ifrn.agenda.beans.Tarefa;

public class TarefaDAO {

	private Conexao conexao = null;

	public TarefaDAO() {
		conexao = Conexao.getInstance();
	}

	public List<Tarefa> retornaTarefaPorTitulo(String titulo)
			throws SQLException {

		ResultSet rs = conexao
				.executeQueryStatement("select * from tb_tarefa where tar_titulo = "
						+ titulo);

		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		while (rs.next())
			tarefas.add(this.gerarTarefa(rs));

		return tarefas;
	}

	public Tarefa recuperarPorOid(int id) throws SQLException {

		ResultSet rs = conexao
				.executeQueryStatement("select * from tb_tarefa where tar_id = "
						+ id);

		return this.gerarTarefa(rs);

	}

	public List<Tarefa> recuperarTodos() throws SQLException {

		ResultSet rs = conexao.executeQueryStatement("select * from tb_tarefa");

		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		while (rs.next())
			tarefas.add(this.gerarTarefa(rs));

		return tarefas;

	}

	public List<Tarefa> recuperarPorData(Date dataInicio, Date dataFim)
			throws SQLException {

		ResultSet rs = conexao
				.executeQueryStatement("select * from tb_tarefe where tar_data > '"
						+ dataInicio + "' and tar_data < '" + dataFim + "'");

		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		while (rs.next())
			tarefas.add(this.gerarTarefa(rs));

		return tarefas;
	}

	public void salvar(Tarefa tarefa) {

		conexao.executeUpdateStatement("update tb_tarefa set tar_titulo="
				+ tarefa.getTitulo() + ",tar_data=" + tarefa.getData()
				+ ",tar_local=" + tarefa.getLocal() + ",tar_prioridade="
				+ tarefa.getPrioridade() + ",tar_descricao="
				+ tarefa.getDescricao() + ",tar_estado=" + tarefa.getEstado()
				+ ",tar_ativado=" + tarefa.isAtivo() + " where tar_id = "
				+ tarefa.getOid());

	}

	public void inserir(Tarefa tarefa) throws SQLException {
		
		 	String SQL = "insert into tb_tarefa (age_id int,usu_id,tar_titulo,tar_data,tar_local," +
		 			"tar_prioridade,tar_descricao,tar_estado,tar_ativado) values = ?,?,?,?,?,?,?,?,";
	        PreparedStatement ps = conexao.getPreparedStatement(SQL);
	        ps.setInt(1, tarefa.getAgenda().getOid());
	        ps.setInt(2, tarefa.getUsuario().getOid());
	        ps.setString(3, tarefa.getTitulo());
	        ps.setDate(4, (Date) tarefa.getData());
	        ps.setString(5, tarefa.getLocal());
	        ps.setString(6, tarefa.getPrioridade().name());
	        ps.setString(7, tarefa.getDescricao());
	        ps.setString(8, tarefa.getEstado().name());
	        ps.setBoolean(9, tarefa.isAtivo());
	        
	        
	        ps.executeUpdate();
	        

		
	}

	public void remover(int tarefaOid) {

		conexao
				.executeQueryStatement("update tb_tarefa set tar_ativo = 0 where tar_id="
						+ tarefaOid);
	}
	
	
	public List<Tarefa> recuperarTarefasDaAgenda(int idAgenda) throws SQLException {
				
		
            String SQL = "select * from tb_tarefa where age_id = ?";
            PreparedStatement ps = conexao.getPreparedStatement(SQL);
            ps.setInt(1, idAgenda);
           

            ResultSet rs = ps.executeQuery();
            
            List<Tarefa> tarefas = new ArrayList<Tarefa>();
    		while (rs.next())
    			tarefas.add(this.gerarTarefa(rs));

    		return tarefas; 

       
	}
	
	
	public List<Tarefa> recuperarTarefasDoUsuario(int idUsuario) throws SQLException {
		
		
        String SQL = "select * from tb_tarefa where usu_id = ?";
        PreparedStatement ps = conexao.getPreparedStatement(SQL);
        ps.setInt(1, idUsuario);
       

        ResultSet rs = ps.executeQuery();
        
        List<Tarefa> tarefas = new ArrayList<Tarefa>();
		while (rs.next())
			tarefas.add(this.gerarTarefa(rs));

		return tarefas; 

   
	}
	
		public List<Tarefa> recuperarTarefasDoUsuarioEDaAgenda(int idAgenda, int idUsuario) throws SQLException {
		
		
        String SQL = "select * from tb_tarefa where age_id = ? usu_id = ?";
        PreparedStatement ps = conexao.getPreparedStatement(SQL);
        ps.setInt(1, idAgenda);
        ps.setInt(2, idUsuario);
       

        ResultSet rs = ps.executeQuery();
        
        List<Tarefa> tarefas = new ArrayList<Tarefa>();
		while (rs.next())
			tarefas.add(this.gerarTarefa(rs));

		return tarefas; 

   
		}
	
	
	private Tarefa gerarTarefa(ResultSet rs) throws SQLException {

		Tarefa tarefa = new Tarefa();

		if (rs.next()) {

			// tarefa.setAgenda(new
			// AgendaDAO().recuperarPorId(rs.getInt("age_id")));
			tarefa.setTitulo(rs.getString("tar_titulo"));
			tarefa.setData(rs.getDate("tar_data"));
			tarefa.setLocal(rs.getString("tar_local"));
			tarefa.setPrioridade(Prioridade.valueOf(rs
					.getString("tar_prioridade")));
			tarefa.setDescricao(rs.getString("tar_descricao"));
			tarefa.setEstado(EstadoTarefa.valueOf(rs.getString("tar_estado")));
			tarefa.setAtivo(rs.getBoolean("tar_ativado"));

		}

		return tarefa;

	}

}