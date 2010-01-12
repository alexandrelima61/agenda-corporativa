package br.edu.ifrn.agenda.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.edu.ifrn.agenda.beans.Tarefa;
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
		
		else if (comando.equalsIgnoreCase("editarTarefa")){
			
			int oidTarefa = Integer.parseInt(request.getParameter("id"));
			
			try {
				
				Tarefa tarefa = TarefaDAO.getInstance().recuperarPorOid(oidTarefa);
				request.setAttribute("tarefa", tarefa);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/tarefas/visualizar2.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comando = request.getParameter("comando");
		HttpSession session = request.getSession();
		
		if (comando.equalsIgnoreCase("inserirTarefa") || comando.equalsIgnoreCase("editarTarefa")){
			
						
			Tarefa tarefa = new Tarefa();
			
			String titulo = request.getParameter("tituloTarefa");
			//Prioridade prioridade = Prioridade.valueOf((request.getParameter("prioridadeTarefa").toUpperCase()));
			try {
				DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
				
				
				java.util.Date data1 = fmt.parse(request.getParameter("dataTarefa"));
				String[] aux = request.getParameter("horaTarefa").split(":");
				data1.setHours(Integer.parseInt(aux[0]));
				data1.setMinutes(Integer.parseInt(aux[1]));
				
				java.sql.Date data = new java.sql.Date(data1.getTime());
				
				

				String local = request.getParameter("localTarefa");
				String descricao = request.getParameter("descricaoTarefa");
				//int oidAgenda = Integer.parseInt(request.getParameter("AgendaTarefa"));
				
				//Agenda agenda = new Agenda();
				//agenda.setOid(oidAgenda);
				
				//Usuario usuario = (Usuario) session.getAttribute("usuario");
				
				//tarefa.setUsuario(usuario);
				//tarefa.setAgenda(agenda);
				tarefa.setTitulo(titulo);
				//tarefa.setPrioridade(prioridade);
				//tarefa.setEstado(EstadoTarefa.ABERTO);
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
				try {
					new TarefaDAO().editar(tarefa);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
