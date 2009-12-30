package br.edu.ifrn.agenda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifrn.agenda.beans.Agenda;
import br.edu.ifrn.agenda.beans.Compromisso;
import br.edu.ifrn.agenda.beans.HorarioCom;
import br.edu.ifrn.agenda.beans.Usuario;
import br.edu.ifrn.agenda.persistencia.CompromissoDAO;
import br.edu.ifrn.agenda.persistencia.UsuarioDAO;


public class Sistema {

private static Sistema singleton = new Sistema();
	
	public static Sistema getInstance() {
		return singleton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Metodos referentes aos COMPROMISSOS

	
	public void cadastrarCompromisso(String titulo, List<HorarioCom> datas, String local, String descricao, 
			String nomeAgenda, List<Usuario> participantes, Usuario proprietario) throws Exception {
		
		Agenda agenda = new Agenda();
		Compromisso compromisso = new Compromisso(0, true, local, titulo, descricao, datas, proprietario, participantes, agenda);
		CompromissoDAO.getInstance().inserir(compromisso);
	}

	public void editarCompromisso(int oid, boolean ativo, String titulo, HorarioCom horario, HorarioCom novoHorario, String local, String descricao,
			String agenda, List<Usuario> participantes, Usuario proprietario) throws Exception {
		ArrayList<HorarioCom> horarios = new ArrayList<HorarioCom>(); 
		horarios.add(horario);
		horarios.add(novoHorario);
		Agenda agenda1 = new Agenda();
		Compromisso compromisso =  new Compromisso(oid, ativo, local, titulo, descricao, horarios, proprietario, participantes, agenda1);
		CompromissoDAO.getInstance().alterar(compromisso);
	}


	
	
	public int removerParticipante(int idCom, int idPar) {
		return CompromissoDAO.getInstance().removerParticipante(idCom, idPar);
	}
	
	
	public int adicionarParticipante(int idCom,int idPart){
		return CompromissoDAO.getInstance().adicionarParticipante(idCom, idPart);
		 
	}
	
	// Metodos de USUARIO
	public Usuario recuperarUsuarioPorID(int oid){
		return UsuarioDAO.getInstance().buscarPorID(oid);
	}
	
	
	public ArrayList<Usuario> buscarUsuarioPorNome(String nome){
		return UsuarioDAO.getInstance().buscarPorNome(nome);
	}
	
	
	
	
	
	
	
	
}
