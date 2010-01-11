package br.edu.ifrn.agenda;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifrn.agenda.beans.Agenda;
import br.edu.ifrn.agenda.beans.Prioridade;
import br.edu.ifrn.agenda.beans.Tarefa;
import br.edu.ifrn.agenda.beans.Compromisso;
import br.edu.ifrn.agenda.beans.HorarioCompromisso;
import br.edu.ifrn.agenda.beans.Lembrete;
import br.edu.ifrn.agenda.beans.Usuario;
import br.edu.ifrn.agenda.persistencia.AgendaDAO;
import br.edu.ifrn.agenda.persistencia.CompromissoDAO;

import br.edu.ifrn.agenda.persistencia.TarefaDAO;
import br.edu.ifrn.agenda.persistencia.LembreteDAO;
import br.edu.ifrn.agenda.persistencia.UsuarioDAO;


public class Sistema {

private static Sistema singleton = new Sistema();
	
	

	public static Sistema getInstance() {
		return singleton;
	}
	
	/**
	 * Método de cadastramento de compromissos
	 * 	@author Amanda, Ari, Diego, Kairon
	 *  @return void
	 */
	
	public void cadastrarCompromisso(String titulo, List<HorarioCompromisso> datas, String local, String descricao, 
			String nomeAgenda, List<Usuario> participantes, Usuario proprietario) throws Exception {
		
		Agenda agenda = new Agenda();
		Compromisso compromisso = new Compromisso(0, true, local, titulo, descricao, datas, proprietario, participantes, agenda);
		CompromissoDAO.getInstance().inserir(compromisso);
	}
	
	/**
	 * Método de edição de compromissos
	 * @author Amanda, Ari, Diego, Kairon
	 * @return void
	 */
	public void editarCompromisso(int oid, boolean ativo, String titulo, HorarioCompromisso horario, HorarioCompromisso novoHorario, String local, String descricao,
			String agenda, List<Usuario> participantes, Usuario proprietario) throws Exception {
		ArrayList<HorarioCompromisso> horarios = new ArrayList<HorarioCompromisso>(); 
		horarios.add(horario);
		horarios.add(novoHorario);
		Agenda agenda1 = new Agenda();
		Compromisso compromisso =  new Compromisso(oid, ativo, local, titulo, descricao, horarios, proprietario, participantes, agenda1);
		CompromissoDAO.getInstance().alterar(compromisso);
	}


	
	/**
	 * Método para remover participante do compromisso
	 * @author Amanda, Ari, Diego, Kairon
	 * @return int
	 */
	public int removerParticipante(int idCom, int idPar) {
		return CompromissoDAO.getInstance().removerParticipante(idCom, idPar);
	}
	
	/**
	 * Método para adicionar participante ao compromisso
	 * @author Amanda, Ari, Diego, Kairon
	 * @return int
	 */
	public int adicionarParticipante(int idCom,int idPart){
		return CompromissoDAO.getInstance().adicionarParticipante(idCom, idPart);
		 
	}
	
	// Metodos de USUARIO
	public Usuario recuperarUsuarioPorID(int oid){
		return UsuarioDAO.getInstance().buscarPorID(oid);
	}
	
	/**
	 * Método para buscar usuário pelo nome
	 * @author Amanda, Ari, Diego, Kairon
	 * @return ArrayList<Usuario>
	 */
	public ArrayList<Usuario> buscarUsuarioPorNome(String nome){
		return UsuarioDAO.getInstance().buscarPorNome(nome);
	}
	
	public Agenda buscarAgendaPorId(int id) throws SQLException{
		return AgendaDAO.getInstance().recuperarPorId(id); 
	}
	// Metodo para buscar tarefas e editá-las - Nélio
	public List<Tarefa> buscarTarefaPorData(String titulo) throws SQLException{
		return TarefaDAO.getInstance().retornaTarefaPorTitulo(titulo);
	}
	
	
	public List<Tarefa> recuperarTarefaPorDia(String data){
	    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	    java.util.Date date = new java.util.Date();
	    Date dataTarefa = new Date(date.getTime()); 
		try {
			dataTarefa = new Date(fmt.parse(data).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return TarefaDAO.getInstance().recuperarPorData(dataTarefa, dataTarefa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Erro em resgatar tarefa");
		}
		
		
		return new ArrayList<Tarefa>();
		
		
	}
	
	public List<Tarefa> recuperarTarefaPorId(int id){
		List<Tarefa> lista = new ArrayList<Tarefa>();
		try {
			lista.add(TarefaDAO.getInstance().recuperarPorOid(id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	
	public List<Lembrete> recuperarLembretes(){
		
		try {
			return LembreteDAO.getInstance().recuperarTodosLembretes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Lembrete>();
		
	}
	
	public void editarLembrete(int id, String assunto, String descricao){
		Lembrete lembrete = new Lembrete();
		lembrete.setOid(id);
		lembrete.setTitulo(assunto);
		lembrete.setCorpo(descricao);
		//lembrete.setDatas(datas);
		lembrete.setAtivo(true);
		
		LembreteDAO.getInstance().editarLembrete(lembrete);		
		
	}
	
	//Método Listar Tarefa - Nélio
	public List<Tarefa> recuperarTarefas(){
		
		try {
			return TarefaDAO.getInstance().recuperarTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Tarefa>();
		
	}
	
	// Método Editar Tarefa - Nélio
	public void editarTarefa(int id, String assunto, String descricao, Date data, String local, Prioridade prioridade, Boolean ativo) throws SQLException{
		Tarefa tarefa = new Tarefa();
		tarefa.setOid(id);
		tarefa.setTitulo(assunto);
		tarefa.setDescricao(descricao);
		tarefa.setData(data);
		tarefa.setLocal(local);
		tarefa.setPrioridade(prioridade);		
		tarefa.setAtivo(true);
		
		TarefaDAO.getInstance().editar(tarefa);		
		
	}	
	
}
