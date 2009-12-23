package br.edu.ifrn.agenda.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifrn.agenda.beans.Lembrete;
import br.edu.ifrn.agenda.persistencia.LembreteDAO;

/**
 * Servlet implementation class ServletLembrete
 */
public class ServletLembrete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletLembrete() {
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
		String assunto = request.getParameter("assuntoLembrete");
		String descricao = request.getParameter("descricaoLembrete");
		String data = request.getParameter("dataLembrete");
		String hora = request.getParameter("dataLembrete");
		String[] alarme = request.getParameterValues("alarmarLembrete");
		String periodicidade = request.getParameter("periodicidadeLembrete");
		
		//TODO Validar os dados necesarios á verificação
		
		//LembreteDAO dao = dao.inserirLembrete("assuntoLembrete", "descricaoLembrete", datas);
	}

}
