package br.edu.ifrn.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xml.internal.serialize.Printer;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import br.edu.ifrn.agenda.beans.Agenda;
import br.edu.ifrn.agenda.beans.EstadoTarefa;
import br.edu.ifrn.agenda.beans.Prioridade;
import br.edu.ifrn.agenda.beans.Tarefa;
import br.edu.ifrn.agenda.beans.Usuario;
import br.edu.ifrn.agenda.persistencia.TarefaDAO;

public class TarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TarefaServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String comando = request.getParameter("comando");
		HttpSession session = request.getSession();
		
		
		if(comando.equalsIgnoreCase("removerTarefa")){

			int oidTarefa = Integer.parseInt(request.getParameter("oidTarefa"));
			
			new TarefaDAO().remover(oidTarefa);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/* caminho pagina destino */");
			dispatcher.forward(request, response);
		}
		
		else if (comando.equalsIgnoreCase("visualizarTarefa")){
			
			int oidTarefa = Integer.parseInt(request.getParameter("oidTarefa"));
			
			try {
				
				Tarefa tarefa = new TarefaDAO().recuperarPorOid(oidTarefa);
				request.setAttribute("tarefa", tarefa);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/* caminho pagina destino */");
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comando = request.getParameter("comando");
		HttpSession session = request.getSession();
		
		if (comando.equalsIgnoreCase("inserirTarefa") || comando.equalsIgnoreCase("editarTarefa")){
			
			Tarefa tarefa = new Tarefa();
			
			String titulo = request.getParameter("tituloTarefa");
			Prioridade prioridade = Prioridade.valueOf((request.getParameter("prioridadeTarefa").toUpperCase()));
			Date data;
			try {
				data = (Date) new SimpleDateFormat("dd/MM/yyyy").parse((request.getParameter("dataTarefa")));
				String dataBanco = new SimpleDateFormat("yyyy-MM-dd").format(data);
				String hora = request.getParameter("horaTarefa");
				
				String[] aux = hora.split(":");
				data.setHours(Integer.parseInt(aux[0]));
				data.setMinutes(Integer.parseInt(aux[1]));
				String local = request.getParameter("localTarefa");
				String descricao = request.getParameter("descricaoTarefa");
				int oidAgenda = Integer.parseInt(request.getParameter("AgendaTarefa"));
				
				Agenda agenda = new Agenda();
				agenda.setOid(oidAgenda);
				
				Usuario usuario = (Usuario) session.getAttribute("usuario");
				
				tarefa.setUsuario(usuario);
				tarefa.setAgenda(agenda);
				tarefa.setTitulo(titulo);
				tarefa.setPrioridade(prioridade);
				tarefa.setEstado(EstadoTarefa.ABERTO);
				tarefa.setData(data);
				tarefa.setLocal(local);
				tarefa.setDescricao(descricao);
				tarefa.setAtivo(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			if (comando.equalsIgnoreCase("inserirTarefa"))
				try {
					
					new TarefaDAO().inserir(tarefa);
					PrintWriter pw = response.getWriter();
					pw.print("ok");
					pw.flush(); pw.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			else{
				int oidTarefa = Integer.parseInt(request.getParameter("oidTarefa"));
				tarefa.setOid(oidTarefa);
				new TarefaDAO().salvar(tarefa);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/* caminho pagina destino */");
			dispatcher.forward(request, response);
		}
		
	}

}
