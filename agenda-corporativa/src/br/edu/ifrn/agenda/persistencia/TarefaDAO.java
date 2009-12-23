package br.edu.ifrn.agenda.persistencia;

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


	public List<Tarefa> retornaTarefaPorTitulo(String titulo) throws SQLException {

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

	public void salvar(Tarefa tarefa) {

		conexao.executeUpdateStatement("update tb_tarefa set tar_titulo="
				+ tarefa.getTitulo() + ",tar_data=" + tarefa.getData()
				+ ",tar_local=" + tarefa.getLocal() + ",tar_prioridade="
				+ tarefa.getPrioridade() + ",tar_descricao="
				+ tarefa.getDescricao() + ",tar_estado=" + tarefa.getEstado()
				+ ",tar_ativado=" + tarefa.isAtivo() + " where tar_id = "
				+ tarefa.getOid());

	}

	public void inserir(Tarefa tarefa) {

		conexao
				.executeQueryStatement("insert into tb_tarefa (age_id int,usu_id,tar_titulo,tar_data,"
						+ "tar_local,tar_prioridade,tar_descricao,tar_estado,tar_ativado) values ("
						+ tarefa.getAgenda().getOid()
						+ ","
						+ tarefa.getUsuario().getOid()
						+ ","
						+ tarefa.getTitulo()
						+ ","
						+ tarefa.getData()
						+ ","
						+ tarefa.getLocal()
						+ ","
						+ tarefa.getPrioridade()
						+ ","
						+ tarefa.getDescricao()
						+ ","
						+ tarefa.getEstado() + "," + tarefa.isAtivo());

	}

	public void remover(int tarefaOid) {

		conexao.executeQueryStatement("update tb_tarefa set tar_ativo = 0 where tar_id="
				+ tarefaOid);
	}

	private Tarefa gerarTarefa(ResultSet rs) throws SQLException {

		Tarefa tarefa = new Tarefa();

		if (rs.next()) {

			//tarefa.setAgenda(new AgendaDAO().recuperarPorId(rs.getInt("age_id")));
			tarefa.setTitulo(rs.getString("tar_titulo"));
			tarefa.setData(rs.getDate("tar_data"));
			tarefa.setLocal(rs.getString("tar_local"));
			tarefa.setPrioridade(Prioridade.valueOf(rs
					.getString("tar_prioridade")));
			tarefa.setDescricao(rs.getString("tar_descricao"));
			tarefa.setEstado(EstadoTarefa.valueOf(rs.getString("tar_estado")));
			tarefa.setAtivo(rs.getBoolean("tar_ativado"));

		}

		return null;

	}

}