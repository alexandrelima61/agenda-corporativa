<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<script type="text/javascript">
	jQuery(function() {
		jQuery('#dataTarefa').datepicker({
			dateFormat: 'dd/mm/yy',
			dayNames: [  
			'Domingo','Segunda','Ter�a','Quarta','Quinta','Sexta','S�bado','Domingo'  
			],  
			dayNamesMin: [  
			'D','S','T','Q','Q','S','S','D'  
			],  
			dayNamesShort: [  
			'Dom','Seg','Ter','Qua','Qui','Sex','S�b','Dom'  
			],  
			monthNames: [  
			'Janeiro','Fevereiro','Mar�o','Abril','Maio','Junho','Julho','Agosto','Setembro',  
			'Outubro','Novembro','Dezembro'  
			],  
			monthNamesShort: [  
			'Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set',  
			'Out','Nov','Dez'  
			],  
			nextText: 'Pr�ximo',  
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

		jQuery('#btnBuscar').click(function(){
			jQuery.post('/agenda/TarefaServlet?comando=editarTarefa',{
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
  
  <label for="T�tulo">T�tulo</label>
  <input type="hidden" name="comando" value="editarTarefa"/>
  <input type="hidden" name="idTarefa" value="<%=tarefa.getOid()%>"/>
  <input type="text" class="input-longo" name="tituloTarefa" id="tituloTarefa" value="<%=tarefa.getTitulo()%>"/>
  
  <label for="Agenda">Agenda</label>
  <select name="agendaTarefa" id="agendaTarefa">
    <option><%=tarefa.getAgenda()%></option>
    
  </select>
		<div class="inputInline">
			<label for="Data">Data</label>
			<input type="text" class="input-medio" name="dataTarefa" id="dataTarefa" value="<%=tarefa.getData()%>"/>		
		</div>
		
  <label for="Local">Local</label>
  <input type="text" class="input-longo" name="localTarefa" id="localTarefa" value="<%=tarefa.getLocal()%>"/>
  <label for="Prioridade">Prioridade</label>
  <select name="prioridadeTarefa" id="prioridadeTarefa">
    <option><%=tarefa.getPrioridade()%></option>
  </select>
  <label for="Descri��o">Descri��o</label>
  <textarea name="descricao" id="descricao" value="<%=tarefa.getLocal()%>" ></textarea>
  
	<div class="buttonsForm">
		<input type="submit" value="Editar"/>
		<input type="reset" value="Limpar" />		
	</div>
</fieldset>
</form>
</div>