<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.text.SimpleDateFormat"%>
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
	<h2>Editar Tarefa</h2>
<form action="<%=request.getContextPath() %>/TarefaServlet?" method="post">
  <fieldset>
  
  <jsp:useBean id="tarefa" scope="request" type="br.edu.ifrn.agenda.beans.Tarefa"></jsp:useBean>
  
  <label for="Título">Título</label>
  <input type="hidden" name="comando" value="editarTarefa"/>
  <input type="hidden" name="idTarefa" value="<%=tarefa.getOid()%>"/>
  <input type="text" class="input-longo" name="tituloTarefa" id="tituloTarefa" value="<%=tarefa.getTitulo()%>"/>
     
  </select>
		<div class="inputInline">
			<label for="Data">Data</label>
			<% SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); %>
			<input type="text" class="input-medio" name="dataTarefa" id="dataTarefa" value="<%=fmt.format(tarefa.getData())%>"/>					
		</div>
		
  <label for="Local">Local</label>
  <input type="text" class="input-longo" name="localTarefa" id="localTarefa" value="<%=tarefa.getLocal()%>"/>
  <label for="Descrição">Descrição</label>
  <textarea name="descricao" id="descricao" ><%=tarefa.getDescricao()%></textarea>
  
	<div class="buttonsForm">
		<input type="submit" value="Editar"/>
		<input type="reset" value="Limpar" />		
	</div>
</fieldset>
</form>
</div>