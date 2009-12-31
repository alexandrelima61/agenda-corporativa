package br.edu.ifrn.agenda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifrn.agenda.beans.Agenda;
import br.edu.ifrn.agenda.beans.Compromisso;
import br.edu.ifrn.agenda.beans.HorarioCompromisso;
import br.edu.ifrn.agenda.beans.Usuario;
import br.edu.ifrn.agenda.persistencia.CompromissoDAO;
import br.edu.ifrn.agenda.persistencia.UsuarioDAO;


public class Sistema {

private static Sistema singleton = new Sistema();
	

	public static Sistema getInstance() {
		return singleton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * M�todo de cadastramento de compromissos
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
	 * M�todo de edi��o de compromissos
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
	 * M�todo para remover participante do compromisso
	 * @author Amanda, Ari, Diego, Kairon
	 * @return int
	 */
	public int removerParticipante(int idCom, int idPar) {
		return CompromissoDAO.getInstance().removerParticipante(idCom, idPar);
	}
	
	/**
	 * M�todo para adicionar participante ao compromisso
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
	 * M�todo para buscar usu�rio pelo nome
	 * @author Amanda, Ari, Diego, Kairon
	 * @return ArrayList<Usuario>
	 */
	public ArrayList<Usuario> buscarUsuarioPorNome(String nome){
		return UsuarioDAO.getInstance().buscarPorNome(nome);
	}
	
	
	
	
	
	
	
	
}