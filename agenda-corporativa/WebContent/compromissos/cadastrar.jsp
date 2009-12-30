<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery('#dataInicial').datepicker({
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
		
		jQuery('.btnAddData').click(function(){
			var idAtual = 2;
			jQuery('#datasCompromisso').append('<div id="'+jQuery('#dataInicial').val()+'">'+jQuery('#dataInicial').val()+'</div>');
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
		<div class="inputInline">
			<input type="text" class="input-medio" name="dataInicial" id="dataInicial" />
			<input type="text" class="input-pequeno horaInicial" name="horaInicial" />
			<input type="text" class="input-pequeno horaFinal" name="horaInicial" />
			<img class="btnAddData" src="/agenda/img/add-icon.png" alt="" />
		</div>
		<div id="datasCompromisso">
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