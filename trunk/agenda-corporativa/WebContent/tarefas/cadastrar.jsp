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
	});
</script>

<div id="internas-content">
<div class="backBtn"><a href="<%=request.getContextPath() %>">Voltar</a></div>
	<h2>Adicionar Tarefa</h2>
<form action="#">
  <fieldset>
  <label for="T�tulo">T�tulo</label>
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
  <label for="Descri��o">Descri��o</label>
  <textarea name="descricao" id="descricao"></textarea>
  
	<div class="buttonsForm">
		<input type="button" value="Agendar" id="btnCadastro" />
		<input type="reset" value="Limpar" /> 
	</div>
</fieldset>
</form>
</div>