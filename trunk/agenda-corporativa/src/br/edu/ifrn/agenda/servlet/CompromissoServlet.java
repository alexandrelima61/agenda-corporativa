package br.edu.ifrn.agenda.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.sound.DataPusher;

import br.edu.ifrn.agenda.Sistema;
import br.edu.ifrn.agenda.beans.HorarioCom;
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
			String datas[] = request.getParameterValues("datas");
			String local = request.getParameter("localCompromisso");
			String descricao = request.getParameter("descricaoCompromisso");
			String agenda = request.getParameter("agendaCompromisso");
			String partic[] = request.getParameterValues("participantesCompromisso");
			//Pegar sessao...
			Usuario proprietario = (Usuario) request.getSession().getAttribute("user");
			
			List<HorarioCom> horarios = new ArrayList<HorarioCom>();
			List<Usuario> participantes = new ArrayList<Usuario>();
			
			for (int i = 0; i < datas.length; i++) {
				HorarioCom horario = new HorarioCom();
				String[] data = datas[0].split("-");
				String[] horaInicial = datas[1].split("-");
				String[] horaFinal = datas[2].split("");
				// Data Inicio
				SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
				Date dataInicio = new Date();
				try {
					dataInicio = fmt.parse(data[i]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
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
					// TODO Auto-generated catch block
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		if(comando.equalsIgnoreCase("removerParticipantes")){
			
			int id = Integer.parseInt(request.getParameter("idCompromisso"));
			String partic[] = request.getParameterValues("participantesCompromisso");
			
			int idp = 0;
			for (int i = 0; i < partic.length; i++) {
				idp = Integer.parseInt(partic[i]);
				sistema.removerParticipante(idPart);
				
			}
			
			
			
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
			
			HorarioCom horario = new HorarioCom();
			// Data Inicio
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			Date dataInicio = new Date();
			try {
				dataInicio = fmt.parse(oldData);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			aux = oldHoraFim.split(":");
			dataFim.setHours(Integer.parseInt(aux[0]));
			dataFim.setMinutes(Integer.parseInt(aux[1]));
			horario.setDataFim(dataFim);
			
			
			
				
				HorarioCom novoHorario = new HorarioCom();
				
				// Data Inicio
				
				dataInicio = new Date();
				try {
					dataInicio = fmt.parse(dataInicial);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				aux = horaFinal.split(":");
				dataFim.setHours(Integer.parseInt(aux[0]));
				dataFim.setMinutes(Integer.parseInt(aux[1]));
				novoHorario.setDataFim(dataFim);
			

			
			try {
				sistema.editarCompromisso(id, true, titulo, horario, novoHorario, local, descricao, agenda, participantes, proprietario);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
