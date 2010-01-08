<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="Agenda" scope="request" type="br.edu.ifrn.agenda.beans.Agenda" />
<div id="internas-content">
<div class="backBtn"><a href="<%=request.getContextPath() %>">Voltar</a></div>
	<h2>Editar Agenda</h2>
<form action="<%=request.getContextPath() %>/AgendaServlet" method="post" >
  <fieldset>
  <label for="Título">Título:</label>
  <input type="text" class="input-longo" name="tituloAgenda" id="tituloAgenda" value="<%=Agenda.getTitulo() %>"/>
  
  <input type="hidden" name="idAgenda" value="<%=Agenda.getOid() %>" />
  
    <label for="Descrição">Descrição:</label>
  <textarea name="descricaoAgenda" id="descricaoAgenda"> <%= Agenda.getDescricao()%> </textarea>
 <div class="buttonsForm">
  <input type="submit" name="atualizar" id="atualiza" value="Atualizar Agenda"/>
  
  <form action="<%=request.getContextPath() %>/AgendaServlet" method="post">
  <input type="hidden" name="idAgenda" value="<%=Agenda.getOid() %>" />
 		<input type="submit" name="atualizar" id="atualiza" value="Desativar Agenda"/>
  </form>
  
  </div>
  </fieldset>
</form>
</div>