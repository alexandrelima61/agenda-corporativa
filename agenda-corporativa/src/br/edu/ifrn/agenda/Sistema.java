package br.edu.ifrn.agenda;

import java.util.Date;
import java.util.List;

import br.edu.ifrn.agenda.beans.HorarioCom;
import br.edu.ifrn.agenda.beans.Usuario;


public class Sistema {

private static Sistema singleton = new Sistema();
	
	public static Sistema getInstance() {
		return singleton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Metodos referentes aos COMPROMISSOS
	
	
	public boolean cadastrarCompromisso(String titulo, List<HorarioCom> horarios, String local, String descricao, 
			String agenda, List<Usuario> participantes) {
		return false;
		
	}
	
	
	
	
}
