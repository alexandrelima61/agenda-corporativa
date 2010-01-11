<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.edu.ifrn.agenda.persistencia.LembreteDAO"%>
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
	<h2>Editar Lembrete</h2>
	<form action="<%=request.getContextPath() %>/LembreteServlet?" method="post">
	<fieldset>
	
	<jsp:useBean id="lembrete" scope="request" type="br.edu.ifrn.agenda.beans.Lembrete"></jsp:useBean>

		 <label for="Assunto">Titulo</label>
		 <input type="hidden" name="comando" value="editarLembrete"/>
		 <input type="hidden" name="idLembrete" value="<%=lembrete.getOid()%>"/>
		 
		 <input type="text" name="assuntoLembrete" class="input-longo" id="assuntoLembrete" value="<%=lembrete.getTitulo()%>" />
		 
		 <label for="Descricao">Descrição</label>
		 <textarea name="descricaoLembrete" id="descricaoLembrete" > <%=lembrete.getCorpo()%></textarea>
		  	 
	 
		 <div class="buttonsForm">
		 	<input type="submit" value="Editar"/>
			<input type="reset" value="Limpar" />		
		 </div>
	</fieldset>
</form>
</div>