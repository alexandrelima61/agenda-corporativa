<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery('.btnAddData').click(function(){
			var idAtual = 2;
			jQuery('#datasCompromisso').append('<div class="inputInline" id="data-'+idAtual+'"><input type="text" class="input-medio datas" name="dataInicial" id="dataInicial" />' +
					'<input type="text" class="input-pequeno horaInicial" name="horaInicial" />' +
					'<input type="text" class="input-pequeno horaFinal" name="horaInicial" />' +
					'<img class="btnRemoveData" id="'+idAtual+'" src="/agenda/img/remove-icon.png" alt="" /></div>');
		});
	});
</script>

<div id="internas-content">
	 <div class="backBtn"><a href="<%=request.getContextPath() %>">Voltar</a></div>
	<h2>Adicionar Compromisso</h2>
<form action="#">
	<fieldset>
		<label for="Compromisso">Compromisso</label>
		<input type="text" name="tituloCompromisso" class="input-longo" id="tituloCompromisso" />
		
		<label for="Data">Data / Início / Fim</label>
		<div id="datasCompromisso">
		<div class="inputInline">
			<input type="text" class="input-medio" name="dataInicial" id="dataInicial" />
			<input type="text" class="input-pequeno horaInicial" name="horaInicial" />
			<input type="text" class="input-pequeno horaFinal" name="horaInicial" />
			<img class="btnAddData" src="/agenda/img/add-icon.png" alt="" />
		</div>
		</div>
		
		<label for="Local">Local</label>
		<input type="text" class="input-longo" name="localCompromisso" id="localCompromisso" />
		
		<label for="Categoria">Agenda</label>
		<select id="agendaCompromisso">
			<option id="1">Agenda 1</option>
			<option id="2">Agenda 2</option>
		</select>
		
		<label for="Descricao">Descrição</label>
		 <textarea name="descricaoCompromisso" id="descricaoCompromisso"></textarea>
		 
		 <div class="buttonsForm">
		 	<input type="button" value="Agendar" id="btnCadastro" />
			<input type="reset" value="Limpar" /> 
		 </div>
	</fieldset>
</form>
</div>