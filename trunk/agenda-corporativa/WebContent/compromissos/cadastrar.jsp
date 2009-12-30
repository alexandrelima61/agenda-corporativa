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
			jQuery('#datasDoCompromisso').append('<div class="datasCompromisso" id="'+jQuery('#dataInicial').val()+'-'+jQuery('#horaInicial').val()+'-'+jQuery('#horaFinal').val()+'">'+jQuery('#dataInicial').val()+' / ' +jQuery('#horaInicial').val()+ ' / ' +jQuery('#horaFinal').val() +
					' | <a href="#" class="btnRemoverData">Remover</a></div>');
			jQuery('datasDoCompromisso input').val();

		});

		jQuery('#btnCadastro').click(function(){
			var datasC = new Array();
			var particpantesCompromisso = new Array();

			jQuery('.datasCompromisso').each(function(i){
				datasC.push(jQuery(this).attr('id'));
			});

			jQuery('.participanteCompromisso').each(function(i){
				participantesCompromisso.push(jQuery(this).attr('id'));
			});
			
			return false;
			jQuery.post('/agenda/CompromissoServlet?comando=cadastrar',{
				tituloCompromisso : jQuery('#tituloCompromisso').val(),
				datas : datasC,
				localCompromisso : jQuery('#localCompromisso').val(),
				agendaCompromisso : jQuery('#agendaCompromisso option:selected').attr('id'),
				participantesCompromisso : participantesCompromisso,
				descricaoCompromisso : jQuery('#descricaoCompromisso').val()	
			},function(data)
			{
				jQuery('#calendario-content').load('/agenda');
			});
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
			<input type="text" class="input-pequeno horaInicial" name="horaInicial"  id="horaInicial" />
			<input type="text" class="input-pequeno horaFinal" name="horaInicial"  id="horaFinal"/>
			<img class="btnAddData" src="/agenda/img/add-icon.png" alt="" />
		</div>
		<div id="datasDoCompromisso">
		</div>
		
		<label for="Local">Local</label>
		<input type="text" class="input-longo" name="localCompromisso" id="localCompromisso" />
		
		<label for="Categoria">Agenda</label>
		<select id="agendaCompromisso">
			<option id="1">Agenda 1</option>
			<option id="2">Agenda 2</option>
		</select>
		<label for="Participantes">Adicionar Participante</label>
		<input type="text" class="input-longo" name="pesquisaParticipante" id="pesquisaParticipante" />
		
		<div id="resultadoPesquisa">
		</div>
		
		<div id="participantesCompromisso">
			<div class="participanteCompromisso" id="01">Rui Anderson - <a href="#">Remover</a></div>	
		</div>
		
		
		<label for="Descricao">Descrição</label>
		 <textarea name="descricaoCompromisso" id="descricaoCompromisso"></textarea>
		 
		 <div class="buttonsForm">
		 	<input type="button" value="Agendar" id="btnCadastro" />
			<input type="reset" value="Limpar" /> 
		 </div>
	</fieldset>
</form>
</div>