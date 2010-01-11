<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.text.SimpleDateFormat"%><script type="text/javascript">
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
	<h2>Visualizar Tarefa</h2>
	<jsp:useBean id="tarefa" type="br.edu.ifrn.agenda.beans.Tarefa" scope="request"/>

	<div>
		<table>
		
		<tr><td>Titulo: </td><td> <%=tarefa.getTitulo() %></td>	</tr>
		<tr><td>Descrição: </td> <td> <%=tarefa.getDescricao() %></td>	</tr>
		<tr><td>Local: </td> <td> <%=tarefa.getLocal() %></td>	</tr>
		<% SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); %>
		<tr><td>Data: </td> <td> <%= fmt.format(tarefa.getData()) %></td>	</tr>
	
		</table>
	
	</div>


</div>