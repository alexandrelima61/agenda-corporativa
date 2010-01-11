<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.edu.ifrn.agenda.beans.HorarioCompromisso"%>
<%@page import="br.edu.ifrn.agenda.beans.Compromisso"%>


<script type="text/javascript">
	jQuery(function() {
		jQuery('#dataTarefa').datepicker({
			dateFormat: 'dd/mm/yy',
			dayNames: [  
			'Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'  
			],  
			dayNamesMin: [  
			'D','S','T','Q','Q','S','S','D'  
			],  
			dayNamesShort: [  
			'Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'  
			],  
			monthNames: [  
			'Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro',  
			'Outubro','Novembro','Dezembro'  
			],  
			monthNamesShort: [  
			'Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set',  
			'Out','Nov','Dez'  
			],  
			nextText: 'Próximo',  
			prevText: 'Anterior'
		});

		jQuery('#btnCadastro').click(function(){
			jQuery.post('/agenda/TarefaServlet?comando=inserirTarefa',{
				tituloTarefa : jQuery('#tituloTarefa').val(),
				prioridadeTarefa : jQuery('#prioridadeTarefa option:selected').val(),
				dataTarefa : jQuery('#dataTarefa').val(),
				horaTarefa : jQuery('#horaTarefa').val(),
				agendaTarefa : jQuery('#agendaTarefa option:selected').attr('id'),
				localTarefa : jQuery('#localTarefa').val(),
				descricaoTarefa : jQuery('#descricaoTarefa').val()	
			},function(data){
				if(data == 'ok')
					jQuery('#calendario-content').load('/agenda');
				else
					alert('Erro ao Adicionar Tarefa.\nTente Novamente');
			});
			return false;
		});

	});
</script>

<div id="internas-content">
<div class="backBtn"><a href="<%=request.getContextPath() %>">Voltar</a></div>
	<h2>Visualizar Compromisso</h2>
	<jsp:useBean id="compromisso" type="br.edu.ifrn.agenda.beans.Compromisso" scope="request"/>

	<div>
		<table>
		
		<tr><td>Titulo: </td><td> <%=compromisso.getTitulo() %></td>	</tr>
		<tr><td>Descrição: </td> <td> <%=compromisso.getDescricao() %></td>	</tr>
		<tr><td>Local: </td> <td> <%= compromisso.getLocal() %></td>	</tr>
		<tr><td>Horarios: </td> </tr>
		<% 
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat fmt2 = new SimpleDateFormat("hh:mm");
		
		for(HorarioCompromisso horario : compromisso.getDatas()){ 
			
		%>
		
			<tr><td> Data: </td><td><%= fmt.format(horario.getDataInicio()) %> </td> 
			<td> Início: </td><td><%= fmt2.format(horario.getDataInicio()) %> </td>
			<td> Fim: </td><td><%= fmt2.format(horario.getDataFim()) %> </td>
			
			</tr>
			
		<%} %>
	
		</table>
	
	</div>


</div>