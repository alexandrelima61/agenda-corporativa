<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<script type="text/javascript">
	jQuery(function() {
		jQuery('#dataLembrete').datepicker({
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
	<h2>Adicionar Lembrete</h2>
<form action="#">
	<fieldset>

		 <label for="Assunto">Assunto</label>
		 <input type="text" name="assuntoLembrete" class="input-longo" id="assuntoLembrete" />
		 
		 <label for="Descricao">Descrição</label>
		 <textarea name="descricaoLembrete" id="descricaoLembrete"></textarea>
		 
		 <label for="Agenda">Agenda</label>
		 <select name="agendaLembrete" id="agendaLembrete">
		    <option>Agenda 1</option>
		    <option>Agenda 2</option>
		    <option>Agenda n</option>
		 </select>	
		  	 
  		 <div class="inputInline">
			 <label for="Data">Data</label>
			 <input type="text" name="dataLembrete" id="dataLembrete" />
			 
			 <label for="Hora">Hora</label>
			 <input type="text" name="horaLembrete" id="horaLembrete" />
		 </div>
		 <div class="inputInline">
			<label for="Alarmar">Alarmar</label>
		 	<input type="checkbox" name="alarmarLembrete" id="alarmarLembrete"/>
			
			<label for="Alarmar">Repetir Lembrete</label>
		 	<input type="checkbox" id="repetirLembrete"/>
			
			<label for="Periodicidade">Periodicidade</label>
			<input type="text" name="periodicidadeLembrete" id="periodicidadeLembrete" disabled="disabled" />
			
			 <label for="DataFim">DataFim</label>
			 <input type="text" name="dataFim" id="dataFim" />
		 </div>
		 
		 
		 <div class="buttonsForm">
		 	<input type="button" value="Registrar" id="btnCadastro" />
			<input type="reset" value="Limpar" /> 
		 </div>
	</fieldset>
</form>
</div>