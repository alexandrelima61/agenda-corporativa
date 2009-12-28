package br.edu.ifrn.agenda.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifrn.agenda.beans.Contato;
import br.edu.ifrn.agenda.persistencia.ContatoDAO;

public class ContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ContatoServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String comando = request.getParameter("botao");
		Contato contato = new Contato();
		ContatoDAO dao = new ContatoDAO();
		
		String nome = request.getParameter("Nome");
		String endereco = request.getParameter("Endereco");
		List<String> telefone = null;
		List<String> email = null;
		telefone.add(request.getParameter("Telefone"));
		email.add(request.getParameter("Email"));
		
		if(comando.equalsIgnoreCase("inserir")){
			try {
				contato.setNome(nome);
				contato.setTelefone(telefone);
				contato.setEmail(email);
				contato.setEndereco(endereco);
				if(dao.verificarContato(nome)!=0)dao.atualizarContato(contato);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		else if(comando.equalsIgnoreCase("editar")){
			contato.setNome(nome);
		}
		else if(comando.equalsIgnoreCase("excluir")){
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
