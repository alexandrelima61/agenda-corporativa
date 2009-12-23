<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div id="internas-content">
<div class="backBtn"><a href="<%=request.getContextPath() %>">Voltar</a></div>
	<h2>Cadastrar Agenda</h2>
<form action="#">
  <fieldset>
  <label for="Título">Título:</label>
  <input type="text" class="input-longo" name="tituloAgenda" id="tituloAgenda"/>
  
    <label for="Descrição">Descrição:</label>
  <textarea name="descricaoAgenda" id="descricaoAgenda"></textarea>
 <div class="buttonsForm">
  <input type="button" name="botao" id="botao" value="Cadastrar Agenda"/>
  </div>
  </fieldset>
</form>
</div>