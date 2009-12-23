<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<script type="text/javascript">
	jQuery(function() {
		jQuery('#dataInicial, #dataFinal').datepicker({
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
	});
</script>

<div id="internas-content">
	 <div class="backBtn"><a href="<%=request.getContextPath() %>">Voltar</a></div>
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