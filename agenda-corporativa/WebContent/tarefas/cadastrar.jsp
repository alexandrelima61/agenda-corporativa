<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h2>Adicionar Tarefa</h2>
<form action="#">
  <fieldset>
  <label for="Título">Título</label>
  <input type="text" class="input-longo" name="tituloTarefa" id="tituloTarefa"/>
  <label for="Agenda">Agenda</label>
  <select name="agendaTarefa" id="agendaTarefa">
    <option>Agenda 1</option>
    <option>Agenda 2</option>
    <option>Agenda n</option>
  </select>
		<div class="inputInline">
			<label for="Data">Data</label>
			<input type="text" class="input-medio" name="dataTarefa" id="dataTarefa" />
			<input type="text" class="input-pequeno" name="horaTarefa"  id="horaTarefa" />
		</div>
  <label for="Local">Local</label>
  <input type="text" class="input-longo" name="localTarefa" id="localTarefa"/>
  <label for="Prioridade">Prioridade</label>
  <select name="prioridadeTarefa" id="prioridadeTarefa">
    <option>Baixa</option>
    <option>Normal</option>
    <option>Alta</option>
  </select>
  <label for="Descrição">Descrição</label>
  <textarea name="descricao" id="descricao"></textarea>
  
	<div class="buttonsForm">
		<input type="button" value="Agendar" id="btnCadastro" />
		<input type="reset" value="Limpar" /> 
	</div>
</fieldset>
</form>
</div>