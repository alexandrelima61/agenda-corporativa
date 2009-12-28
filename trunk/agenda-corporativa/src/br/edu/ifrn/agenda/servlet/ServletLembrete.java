package br.edu.ifrn.agenda.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifrn.agenda.beans.Lembrete;
import br.edu.ifrn.agenda.persistencia.LembreteDAO;

public class ServletLembrete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletLembrete() {
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comando = request.getParameter("")
		
		String assunto = request.getParameter("assuntoLembrete");
		String descricao = request.getParameter("descricaoLembrete");
		String data = request.getParameter("dataLembrete");
		String[] datas = data.split("/");
		String hora = request.getParameter("dataLembrete");
		String[] tempo = hora.split(":");
		List<Date> listaDatas = new ArrayList<Date>();
		Date data = new Date();
		data.setDate(datas[0]);
		data.setMonth(datas[1]);
		data.setYear(datas[2]);
		data.setHour(tempo[0]);
		data.setMinute(tempo[1]);
		listaDatas.add(data);
		String[] alarme = request.getParameterValues("alarmarLembrete");
		String periodicidade = request.getParameter("periodicidadeLembrete");
		
		LembreteDAO dao = dao.inserirLembrete(assunto, descricao, listaDatas);
	}

}
