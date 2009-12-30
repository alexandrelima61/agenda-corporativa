package br.edu.ifrn.agenda.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.sound.DataPusher;

import br.edu.ifrn.agenda.Sistema;
import br.edu.ifrn.agenda.beans.HorarioCompromisso;
import br.edu.ifrn.agenda.beans.Usuario;

/**
 * Servlet implementation class CompromissoServlet
 */
public class CompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Sistema sistema = Sistema.getInstance();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompromissoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void redirecionarPagina(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	RequestDispatcher dispache = request.getRequestDispatcher(url);
		dispache.forward(request, response);
    	
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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comando = request.getParameter("comando");
		
		
		//metodo cadastrar compromisso
		if(comando.equalsIgnoreCase("cadastrar")){
			String titulo = request.getParameter("tituloCompromisso");
			String datas[] = request.getParameterValues("datasCompromisso");
			String local = request.getParameter("localCompromisso");
			String descricao = request.getParameter("descricaoCompromisso");
			String agenda = request.getParameter("agendaCompromisso");
			String partic[] = request.getParameterValues("participantesCompromisso");
			//Pegar sessao...
			Usuario proprietario = (Usuario) request.getSession().getAttribute("user");
			
			List<HorarioCompromisso> horarios = new ArrayList<HorarioCompromisso>();
			List<Usuario> participantes = new ArrayList<Usuario>();
			
			for (int i = 0; i < datas.length; i++) {
				HorarioCompromisso horario = new HorarioCompromisso();
				String[] data = datas[0].split("-");
				String[] horaInicial = datas[1].split("-");
				String[] horaFinal = datas[2].split("");
				// Data Inicio
				SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
				Date dataInicio = new Date();
				try {
					dataInicio = fmt.parse(data[i]);
				} catch (ParseException e) {
					// TODO Tratamento de exceção
					e.printStackTrace();
				}
				
				String[] aux = horaInicial[i].split(":");
				dataInicio.setHours(Integer.parseInt(aux[0]));
				dataInicio.setMinutes(Integer.parseInt(aux[1]));

				horario.setDataInicio(dataInicio);
				// Data Fim
				Date dataFim = new Date();
				try {
					dataFim = fmt.parse(data[i]);
				} catch (ParseException e) {
					// TODO Tratamento de exceção
					e.printStackTrace();
				}

				aux = horaFinal[i].split(":");
				dataFim.setHours(Integer.parseInt(aux[0]));
				dataFim.setMinutes(Integer.parseInt(aux[1]));
				horario.setDataFim(dataFim);
				
				horarios.add(horario);
			}
			int oid =0;
			for (int i = 0; i < partic.length; i++) {
				oid = Integer.parseInt(partic[i]);
				participantes.add(sistema.recuperarUsuarioPorID(oid));
			}
			
			try {
				sistema.cadastrarCompromisso(titulo, horarios, local, descricao, agenda, participantes, proprietario);
				String url="";
				this.redirecionarPagina(url, request, response);
			} catch (Exception e) {
				// TODO Tratamento de exceção
				e.printStackTrace();
			}	
			
		
		}		
		
		if(comando.equalsIgnoreCase("removerParticipantes")){
			
			int id = Integer.parseInt(request.getParameter("idCompromisso"));
			String partic[] = request.getParameterValues("participantesCompromisso");	
			
			for (int i = 0; i < partic.length; i++) {				
				sistema.removerParticipante(id, Integer.parseInt(partic[i]));				
			}
			String url="";
			this.redirecionarPagina(url, request, response);
		}
		
		if(comando.equalsIgnoreCase("adicionarParticipantes")){
			
			int id = Integer.parseInt(request.getParameter("idCompromisso"));
			String partic[] = request.getParameterValues("participantesCompromisso");
			
			for (int i = 0; i < partic.length; i++) {				
				sistema.adicionarParticipante(id, Integer.parseInt(partic[i]));				
			}
			String url="";
			this.redirecionarPagina(url, request, response);
		}	
		
		
		//metodo editar compromisso
		if(comando.equalsIgnoreCase("editar")){
			int id = Integer.parseInt(request.getParameter("idCompromisso"));
			String oldData =  request.getParameter("oldDataCompromisso");
			String oldHoraInicio =  request.getParameter("oldHoraInicioCompromisso");
			String oldHoraFim =  request.getParameter("oldHoraFimCompromisso");
			String titulo = request.getParameter("tituloCompromisso");
			String dataInicial = request.getParameter("dataInicial");
			String horaInicial = request.getParameter("horaInicial");
			String horaFinal = request.getParameter("horaFinal");
			String local = request.getParameter("localCompromisso");
			String descricao = request.getParameter("descricaoCompromisso");
			String agenda = request.getParameter("agendaCompromisso");
			
			//Pegar sessao...
			Usuario proprietario = (Usuario) request.getSession().getAttribute("user");
			

			List<Usuario> participantes = new ArrayList<Usuario>();
			
			HorarioCompromisso horario = new HorarioCompromisso();
			// Data Inicio
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			Date dataInicio = new Date();
			try {
				dataInicio = fmt.parse(oldData);
			} catch (ParseException e) {
				// TODO Tratamento de exceção
				e.printStackTrace();
			}

			String[] aux = oldHoraInicio.split(":");
			dataInicio.setHours(Integer.parseInt(aux[0]));
			dataInicio.setMinutes(Integer.parseInt(aux[1]));

			horario.setDataInicio(dataInicio);
			// Data Fim
			Date dataFim = new Date();
			try {
				dataFim = fmt.parse(dataInicial);
			} catch (ParseException e) {
				// TODO Tratamento de exceção
				e.printStackTrace();
			}

			aux = oldHoraFim.split(":");
			dataFim.setHours(Integer.parseInt(aux[0]));
			dataFim.setMinutes(Integer.parseInt(aux[1]));
			horario.setDataFim(dataFim);		
				
				HorarioCompromisso novoHorario = new HorarioCompromisso();
				
				// Data Inicio
				
				dataInicio = new Date();
				try {
					dataInicio = fmt.parse(dataInicial);
				} catch (ParseException e) {
					// TODO Tratamento de exceção
					e.printStackTrace();
				}

				aux = horaInicial.split(":");
				dataInicio.setHours(Integer.parseInt(aux[0]));
				dataInicio.setMinutes(Integer.parseInt(aux[1]));

				novoHorario.setDataInicio(dataInicio);
				// Data Fim
				dataFim = new Date();
				try {
					dataFim = fmt.parse(dataInicial);
				} catch (ParseException e) {
					// TODO Tratamento de exceção
					e.printStackTrace();
				}

				aux = horaFinal.split(":");
				dataFim.setHours(Integer.parseInt(aux[0]));
				dataFim.setMinutes(Integer.parseInt(aux[1]));
				novoHorario.setDataFim(dataFim);
			
			try {
				sistema.editarCompromisso(id, true, titulo, horario, novoHorario, local, descricao, agenda, participantes, proprietario);
				String url="";
				this.redirecionarPagina(url, request, response);
			} catch (Exception e) {
				// TODO Tratamento de exceção
				e.printStackTrace();
			}
			
			
		}
	}

}
