<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<form action="ContatoServlet" method="post">
  <fieldset>
  <label for="Nome">Nome:</label>
  <input type="text" name="nomeContato" id="nomeContato"/>
  
  <label for="Endereco">Endereço:</label>
  <input type="text" name="enderecoContato" id="enderecoContato"/>
    
  <label for="Telefone">Telefone:</label>
  <input type="text" name="telefone" id="telefone"/>
  
  
  <label for="Email">E-mail:</label>
  <input type="text" name="emailContato" id="emailContato"/>
  
  <input type="submit" name="botao" id="botao" value="Cadastrar Usuário">
  </fieldset>
</form>
