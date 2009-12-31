<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de Lembretes</title>
</head>
<body>
	<jsp:useBean id="lembretes" scope="request" type="java.util.List<br.edu.ifrn.agenda.persistencia.LembreteDAO>" />
	<ul>
		<%for(int i = 0;i < lembretes.size();i++){ %>
			<li>
			<%=lembretes.get(i).toString() %>
			</li>
		<%}%>
	</ul>
</body>
</html>