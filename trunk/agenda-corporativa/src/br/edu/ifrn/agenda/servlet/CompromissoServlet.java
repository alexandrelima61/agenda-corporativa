package br.edu.ifrn.agenda.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CompromissoServlet
 */
public class CompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompromissoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comando = request.getParameter("comando");
		
		if(comando.equalsIgnoreCase("cad_compromisso")){
			String titulo = request.getParameter("tituloCompromisso");
			String dataInicial = request.getParameter("dataInicial");
			String dataFinal = request.getParameter("dataFinal");
			String horaInicial = request.getParameter("horaInicial");
			String horaFinal = request.getParameter("horaFinal");
			String local = request.getParameter("localCompromisso");
			String descricaoCompromisso = request.getParameter("descricaoCompromisso");
			String agenda = request.getParameter("agendaCompromisso");
			String participantes = request.getParameter("participantesCompromisso");
			
			
			
		}
		
		
	}

}
