<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.edu.ifrn.agenda.persistencia.AgendaDAO" %>
<%@ page import="br.edu.ifrn.agenda.beans.Agenda" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teste</title>
</head>
<body>
<h1>antes</h1>
	<% AgendaDAO agenda = new AgendaDAO(); %>
	<ul>
		<% for (Agenda agendas : agenda.listarTodasAgendas()){ %>
		<li><%=agendas.getTitulo() %></li>
		<%}%>		
	</ul>


<h2>depois</h2>
</body>
</html>