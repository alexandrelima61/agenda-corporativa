<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.edu.ifrn.agenda.beans.HorarioCompromisso"%>
<%@page import="br.edu.ifrn.agenda.beans.Compromisso"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Agenda Corporativa :: Visualizar Calendário</title>
		
		<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
		<script type="text/javascript" src="js/jquery.tooltip.min.js"></script>
		<script type="text/javascript" src="js/jquery.contextMenu.js"></script>
		<script type="text/javascript" src="js/functions.js"></script>
        <script type="text/javascript" src="js/navegacao-calendario.js"></script>
		<script type="text/javascript" src="js/navegacao.js"></script>
		
		
		<link rel="stylesheet" type="text/css" href="css/redmond/jquery-ui-1.7.2.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery.tooltip.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery.contextMenu.css" />
		<link rel="stylesheet" type="text/css" href="css/estilo.css" />
    </head>
	
    <body>
<ul id="menu-direito" class="contextMenu">
    <li class="adicionar-compromisso">
        <a href="#adicionar-compromisso">Adicionar Compromisso</a>
    </li>
    <li class="adicionar-tarefa">
        <a href="#adicionar-tarefa">Adicionar Tarefa</a>
    </li>
    <li class="adicionar-lembrete">
        <a href="#adicionar-lembrete">Adicionar Lembrete</a>
    </li>
</ul>

		<div id="site-wrap">
			<div id="top-wrap">
				<div id="logo">
					<h1>Agenda Corporativa</h1>
				</div>
			</div>
			
			<!-- Inicio do Conteudo -->
			<div id="content-wrap">
				<div id="calendario-wrap">
					<div id="calendario-sidebar">
						<div id="show-calendario"></div>
						
						<div id="agendas-wrap">
							<div class="portlet">
								<div class="portlet-header">Agendas</div>
								<div class="portlet-content">
									<div class="eventos-dia-calendario agenda-laranja">
										Agenda Laranja
									</div>
									<div class="eventos-dia-calendario agenda-vermelha">
										Agenda Vermelha
									</div>
									<div class="eventos-dia-calendario agenda-verde" >
										Agenda Verde
									</div>
									<div class="add-button-wrap">
										<a href="<%=request.getContextPath() %>/agendas/cadastrar.jsp">Adicionar Agenda</a>
									</div>
								</div>
							</div>
							
						</div>
					</div>
					<div id="calendario-compromisso">
						<table>
		
							<tbody>
								<tr>
									<td><!-- inicio do conteudo Visualizar compromisso -->
									
									<h2>Visualizar Compromisso</h2>
									<jsp:useBean id="compromisso" type="br.edu.ifrn.agenda.beans.Compromisso" scope="request"/>
								
									<div>
										<table>
										
										<tr><td>Titulo: </td><td> <%=compromisso.getTitulo() %></td>	</tr>
										<tr><td>Descrição: </td> <td> <%=compromisso.getDescricao() %></td>	</tr>
										<tr><td>Local: </td> <td> <%= compromisso.getLocal() %></td>	</tr>
										<tr><td>Horarios: </td> </tr>
										<% 
										SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
										SimpleDateFormat fmt2 = new SimpleDateFormat("hh:mm");
										
										for(HorarioCompromisso horario : compromisso.getDatas()){ 
											
										%>
										
											<tr><td> Data: </td><td><%= fmt.format(horario.getDataInicio()) %> </td> 
											<td> Início: </td><td><%= fmt2.format(horario.getDataInicio()) %> </td>
											<td> Fim: </td><td><%= fmt2.format(horario.getDataFim()) %> </td>
											
											</tr>
											
										<%} %>
									
										</table>
									
									</div>

								</td>
								</tr>								
							</tbody>
						</table>
					</div>
				</div>
			</div>
			
			<div id="rodape">
				<p>Agenda Corporativa</p>
			</div>
		</div>
    </body>
</html>