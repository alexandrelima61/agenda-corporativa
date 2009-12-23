<script type="text/javascript">
	jQuery(function() {
		jQuery('#dataInicial, #dataFinal').datepicker();
	});
</script>

<div id="internas-content">
	<h2>Adicionar Compromisso</h2>
<form action="#">
	<fieldset>
		<label for="Compromisso">Compromisso</label>
		<input type="text" name="tituloCompromisso" class="input-longo" id="tituloCompromisso" />
		
		<label for="Data">Data</label>
		<div class="inputInline">
			<input type="text" class="input-medio" name="dataInicial" id="dataInicial" />
			<input type="text" class="input-pequeno" name="horaInicial"  id="horaInicial" />
			<span>Até</span>
			<input type="text" class="input-medio" name="dataFinal" id="dataFinal" />
			<input type="text" class="input-pequeno" name="horaFinal" id="horaFinal" />
		</div>
		
		<label for="Local">Local</label>
		<input type="text" class="input-longo" name="localCompromisso" id="localCompromisso" />
		
		<label for="Categoria">Categoria</label>
		<select id="categoriaCompromisso">
			<option id="1">Categoria 1</option>
			<option id="2">Categoria 2</option>
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