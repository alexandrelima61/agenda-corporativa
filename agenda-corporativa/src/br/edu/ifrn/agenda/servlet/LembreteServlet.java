package br.edu.ifrn.agenda.servlet;


import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifrn.agenda.Sistema;
import br.edu.ifrn.agenda.beans.Lembrete;
import br.edu.ifrn.agenda.persistencia.Conexao;
import br.edu.ifrn.agenda.persistencia.LembreteDAO;

public class LembreteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String tituloLembrete = null;
	
    public LembreteServlet() {
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("pagina");
		
		if(op.equalsIgnoreCase("editar")){
			int id = Integer.parseInt(request.getParameter("idLem"));
			 request.setAttribute("lembrete", LembreteDAO.getInstance().recuperarPorId(id));
			 RequestDispatcher dispache = request.getRequestDispatcher("lembretes/editar.jsp");
			 dispache.forward(request, response);
			 
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comando = request.getParameter("comando");
		
		if(comando.equalsIgnoreCase("editarLembrete")){
			int id = Integer.parseInt(request.getParameter("idLembrete"));			
			String assunto = request.getParameter("assuntoLembrete");
			String descricao = request.getParameter("descricaoLembrete");
			
			
			Sistema.getInstance().editarLembrete(id, assunto, descricao);

			RequestDispatcher dispache = request.getRequestDispatcher("index.jsp");
			 dispache.forward(request, response);
			
			
		}
		
		
		if(comando.equalsIgnoreCase("inserirLembrete")){
		
		
		String assunto = request.getParameter("assuntoLembrete");
		String descricao = request.getParameter("descricaoLembrete");
		String data = request.getParameter("dataLembrete");
		String[] datas = data.split("/");
		String hora = request.getParameter("horaLembrete");
		String[] tempo = hora.split(":");
		List<Date> listaDatas = new ArrayList<Date>();
		

		
		Date date = new Date(DateToMillisec(datas[2], datas[1], datas[0], tempo[1], tempo[0]));
				
		
		String[] alarme = request.getParameterValues("alarmarLembrete");
		String periodicidade = request.getParameter("periodicidadeLembrete");
		
		String data1 = request.getParameter("dataFim");
		String[] datas1 = data.split("/");
		
		Date date2 = new Date(DateToMillisec(datas1[2], datas1[1], datas1[0]));
		
		listaDatas = adicionarComparando(listaDatas, date, date2, periodicidade);
		
		Lembrete ltemp = new Lembrete(assunto,descricao,listaDatas);
		
		LembreteDAO dao = new LembreteDAO();
		try {
			dao.inserirLembrete(ltemp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		 RequestDispatcher dispache = request.getRequestDispatcher("index.jsp");
		 dispache.forward(request, response);
		}

	}
	
	public long DateToMillisec(String Ano, String Mes, String Dia, String Hora, String Min){
		long ano = Long.parseLong(Ano);
		long mes = Long.parseLong(Mes);
		long dia = Long.parseLong(Dia);
		long hora = Long.parseLong(Hora);
		long min = Long.parseLong(Min);
		
		
		long total = 0;
		total += ano*Long.parseLong("31556952000");
		total += mes*Long.parseLong("2551443840");
		total += dia*86400000;
		total += hora*3600000;
		total += min*60000;
		return total;
	}
	
	public long DateToMillisec(String Ano, String Mes, String Dia){
		long ano = Long.parseLong(Ano);
		long mes = Long.parseLong(Mes);
		long dia = Long.parseLong(Dia);
		
		long total = 0;
		total += ano*Long.parseLong("31556952000");
		total += mes*Long.parseLong("2551443840");
		total += dia*86400000;
		return total;
	}
	
	public List<Date> adicionarComparando(List<Date> lista, Date datainicio, Date datafim, String periodicidade){
		Date ultimaData;
		long dia = Long.parseLong("86400000")*Long.parseLong(periodicidade);
		ultimaData = datainicio;
		while(ultimaData.after(datafim)){
			lista.add(ultimaData);
			String x = Long.toString(ultimaData.getSeconds());
			long a = Long.parseLong(x);
			a *= 1000;
			a += dia;
			ultimaData = new Date(a);
			
		}
		return lista;
	}
	
	

}
