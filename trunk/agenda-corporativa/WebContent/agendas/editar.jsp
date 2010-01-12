<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="agenda" scope="request" type="br.edu.ifrn.agenda.beans.Agenda" />
<div id="internas-content">
<div class="backBtn"><a href="<%=request.getContextPath() %>">Voltar</a></div>
	<h2>Editar Agenda</h2>
<form action="<%=request.getContextPath() %>/AgendaServlet" method="get" >
  <fieldset>
  <label for="Título">Título:</label>
  <input type="text" class="input-longo" name="tituloAgenda" id="tituloAgenda" value="<%= agenda.getTitulo() %>"/>
  
  <input type="hidden" name="idAgenda" value="<%=agenda.getOid() %>" />
  
    <label for="Descrição">Descrição:</label>
  <textarea name="descricaoAgenda" id="descricaoAgenda"> <%= agenda.getDescricao()  %> </textarea>
  </fieldset>
</form>
</div>