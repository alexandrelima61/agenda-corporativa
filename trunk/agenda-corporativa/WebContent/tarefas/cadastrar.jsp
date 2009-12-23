<script type="text/javascript">
	jQuery(function() {
		jQuery('#dataTarefa').datepicker();
	});
</script>

<div id="internas-content">
	<h2>Adicionar Tarefa</h2>
<form action="#">
  <fieldset>
  <label for="Título">Título</label>
  <input type="text" class="input-longo" name="tituloTarefa" id="tituloTarefa"/>
  <label for="Categoria">Categoria</label>
  <select name="categoriaTarefa" id="categoriaTarefa">
    <option>Categoria 1</option>
    <option>Categoria 2</option>
    <option>Categoria n</option>
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