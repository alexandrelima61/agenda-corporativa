package br.edu.ifrn.agenda.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifrn.agenda.Sistema;
import br.edu.ifrn.agenda.beans.Agenda;
import br.edu.ifrn.agenda.persistencia.AgendaDAO;

/**
 * Servlet implementation class AgendaServlet
 */
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Sistema sistema = Sistema.getInstance();
	
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = request.getParameter("pagina");

		if(pagina.equalsIgnoreCase("editar")){
			int id = Integer.parseInt(request.getParameter("id"));
			Agenda agenda;
			try {
				agenda = AgendaDAO.getInstance().recuperarPorId(id);
				request.setAttribute("agenda",agenda);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				/*agenda = new Agenda();*/
			}
			
			
			/*Agenda agenda = new Agenda();
			agenda.setTitulo("Título da Agenda");
			agenda.setDescricao("Uma agenda qualquer de trabalho");*/

			RequestDispatcher d = request.getRequestDispatcher("agendas/editar.jsp");
            d.forward(request, response);
            
            return;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String atualizar = request.getParameter("atualizar");
		String desativar = request.getParameter("desativa");
		String pagina = request.getParameter("atualizar");
		
		if(pagina.equalsIgnoreCase("cadastrar")){
			String titulo = request.getParameter("tituloAgenda");
			String descricao = request.getParameter("descricaoAgenda");
			Agenda agenda = new Agenda();
			agenda.setTitulo(titulo);
			agenda.setDescricao(descricao);
			agenda.setAtivo(true);
			
			AgendaDAO dao = new AgendaDAO();
			try {
				dao.salvar(agenda);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("Agenda", agenda);
			RequestDispatcher d = request.getRequestDispatcher("/");
            d.forward(request, response);
            return;
		
		}else if(atualizar.equalsIgnoreCase("Atualizar Agenda")){
			
			String titulo = request.getParameter("tituloAgenda");
			String descricao = request.getParameter("descricaoAgenda");
			int id = Integer.parseInt(request.getParameter("idAgenda"));
			Agenda agenda = new Agenda();
			agenda.setOid(id);
			agenda.setTitulo(titulo);
			agenda.setDescricao(descricao);
			agenda.setAtivo(true);
			
			AgendaDAO dao = new AgendaDAO();
			try {
				dao.editarAgenda(agenda);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("Agenda", agenda);
			RequestDispatcher d = request.getRequestDispatcher("/");
            d.forward(request, response);
            return;
			
			
			
			
			
			
			
			
		}
		else if(desativar.equalsIgnoreCase("desativar agenda"))
		{
			Agenda agenda;
			try {
				agenda = sistema.buscarAgendaPorId(Integer.parseInt(request.getParameter("idAgenda")));
				agenda.setAtivo(false);
				
				AgendaDAO.getInstance().editarAgenda(agenda);
				
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RequestDispatcher d = request.getRequestDispatcher("/");
            d.forward(request, response);
		}
		/*else{
			Agenda agenda;
			
			String titulo = request.getParameter("titulo");
			String descricao = request.getParameter("descricao");

			try {
				agenda = new Agenda();
				agenda.setTitulo(titulo);
				agenda.setDescricao(descricao);
				AgendaDAO.getInstance().salvar(agenda);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher d = request.getRequestDispatcher("/");
            d.forward(request, response);
		}*/	
	}
}
