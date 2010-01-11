<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@page import="br.edu.ifrn.agenda.beans.Tarefa"%>
<%@page import="br.edu.ifrn.agenda.beans.Compromisso"%>
<%@page import="br.edu.ifrn.agenda.Sistema"%>


<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifrn.agenda.persistencia.TarefaDAO"%><html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
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
    
    <% 
        for(int i = 1; i <= 31; i++){
        	String data;
        	if(i > 0 && i < 10) data = "0"+i+"/01/2010";
        		else data = i+"/01/2010";
        	
    		request.setAttribute("dia"+i, Sistema.getInstance().recuperarTarefaPorDia(data));
        }
    
    for(int i = 1; i <= 31; i++){
    	String data;
    	if(i > 0 && i < 10) data = "0"+i+"/01/2010";  		else data = i+"/01/2010";
    	
		request.setAttribute("comdia"+i, Sistema.getInstance().recuperarCompromissoPorDia(data));
    }
    
     %>
    
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
					<div id="calendario-content">
						<table id="tabela-calendario">
							<thead>
								<tr class="ui-widget-header">
									<th>dom</th>
									<th>seg</th>
									<th>ter</th>
									<th>qua</th>
									<th>qui</th>
									<th>sex</th>
									<th>sab</th>
						</tr>
<%		
    	
    	request.setAttribute("dia1", Sistema.getInstance().recuperarTarefaPorId(18));
    	request.setAttribute("dia11", Sistema.getInstance().recuperarTarefaPorId(16));%>
							</thead>
							
							<tbody>
								<tr>
									<td>
										<div class="dia-calendario">01</div>
										<jsp:useBean id="dia1" type="java.util.List<br.edu.ifrn.agenda.beans.Tarefa>" scope="request"/>
										<div>
											<% for(Tarefa tarefa : dia1){ %>				
											  	<a href="<%=request.getContextPath() %>/TarefaServlet?comando=visualizarTarefa&id=18"> <%=tarefa.getTitulo() %></a>
											<% }%>
										</div>
									</td>
									<td>
										<div class="dia-calendario">02</div>
										<jsp:useBean id="dia2" type="java.util.List<br.edu.ifrn.agenda.beans.Tarefa>" scope="request"/>
										<div>
											<% for(Tarefa tarefa : dia2){ %>				
											  	<a href="<%=request.getContextPath() %>/TarefaServlet?comando=visualizarTarefa&id=16"> <%=tarefa.getTitulo() %></a>
											<% }%>
										</div>									</td>
									<td>
										<div class="dia-calendario">03</div>
										<div class="eventos-dia-calendario agenda-laranja">
											<jsp:useBean id="dia3" type="java.util.List<br.edu.ifrn.agenda.beans.Tarefa>" scope="request"/>
										<div>
											<% for(Tarefa tarefa : dia3){ %>				
											  	<%=tarefa.getTitulo() %>
											<% }%>
										</div>
											</div>
								
									</td>
									<td>
										<div class="dia-calendario">04</div>
										<jsp:useBean id="comdia4" type="java.util.List<br.edu.ifrn.agenda.beans.Compromisso>" scope="request"/>
										<div>
											<% for(Compromisso com : comdia4){ %>				
											  	<a href="<%=request.getContextPath() %>/CompromissoServlet?pagina=visualizar&id=<%=com.getOid()%>"> <%=com.getTitulo() %></a>
											<% }%>
											
										</div>
										
										
									</td>
									<td>
										<div class="dia-calendario">05</div>
										
									<jsp:useBean id="comdia5" type="java.util.List<br.edu.ifrn.agenda.beans.Compromisso>" scope="request"/>
										<div>
											<% for(Compromisso com : comdia5){ %>				
											  	<a href="<%=request.getContextPath() %>/CompromissoServlet?pagina=visualizar&id=<%=com.getOid()%>"> <%=com.getTitulo() %></a>
											<% }%>
											
										</div>
									</td>
									<td>
										<div class="dia-calendario">06</div>
										<jsp:useBean id="comdia6" type="java.util.List<br.edu.ifrn.agenda.beans.Compromisso>" scope="request"/>
										<div>
											<% for(Compromisso com : comdia6){ %>				
											  	<a href="<%=request.getContextPath() %>/CompromissoServlet?pagina=visualizar&id=<%=com.getOid()%>"> <%=com.getTitulo() %></a>
											<% }%>
											
										</div>
										
									</td>
									<td>
										<div class="dia-calendario">07</div>
									</td>								
								</tr>
							<tr>
									<td>
										<div class="dia-calendario">08</div>
									</td>
									<td>
										<div class="dia-calendario">09</div>
										
									</td>
									<td>
										<div class="dia-calendario">10</div>
										<a href="<%=request.getContextPath() %>/LembreteServlet?pagina=editar&idLem=4">Lembrete de Hoje</a>

									</td>
									<td>
										<div class="dia-calendario">11</div>
										<jsp:useBean id="dia11" type="java.util.List<br.edu.ifrn.agenda.beans.Tarefa>" scope="request"/>
										<div>
											<% for(Tarefa tarefa : dia11){ %>				
											  	<a href="<%=request.getContextPath() %>/TarefaServlet?comando=visualizarTarefa&id=16"> <%=tarefa.getTitulo() %></a>
											<% }%>
											
										</div>
									</td>
									<td>
										<div class="dia-calendario">12</div>

									</td>
									<td>
										<div class="dia-calendario">13</div>
	
									</td>
									<td>
										<div class="dia-calendario">14</div>

									</td>								
								</tr>
							<tr>
									<td>
										<div class="dia-calendario">15</div>
									<jsp:useBean id="comdia15" type="java.util.List<br.edu.ifrn.agenda.beans.Compromisso>" scope="request"/>
										<div>
											<% for(Compromisso com : comdia15){ %>				
											  	<a href="<%=request.getContextPath() %>/CompromissoServlet?pagina=visualizar&id=<%=com.getOid()%>"> <%=com.getTitulo() %></a>
											<% }%>
											
										</div>
									<div class="eventos-calendario-wrap">
											<div class="eventos-dia-calendario agenda-vermelha">
												Reunião com...
											</div>
										</div>
									</td>
									<td>
										<div class="dia-calendario">16</div>
									<div class="eventos-calendario-wrap">
											<div class="eventos-dia-calendario agenda-vermelha">
												Reunião com...
											</div>
										</div>
									</td>
									<td>
										<div class="dia-calendario">17</div>
									<div class="eventos-calendario-wrap">
											<div class="eventos-dia-calendario agenda-vermelha">
												Reunião com...
											</div>
										</div>
									</td>
									<td>
										<div class="dia-calendario">18</div>
										<div class="eventos-calendario-wrap">
											<div class="eventos-dia-calendario agenda-vermelha">
												Reunião com...
											</div>
										</div>
									</td>
									<td>
										<div class="dia-calendario">19</div>
									<div class="eventos-calendario-wrap">
											<div class="eventos-dia-calendario agenda-vermelha">
												Reunião com...
											</div>
										</div>
									</td>
									<td>
										<div class="dia-calendario">20</div>
									<div class="eventos-calendario-wrap">
											<div class="eventos-dia-calendario agenda-vermelha">
												Reunião com...
											</div>
										</div>
									</td>
									<td>
										<div class="dia-calendario">21</div>
									<div class="eventos-calendario-wrap">
											<div class="eventos-dia-calendario agenda-vermelha">
												Reunião com...
											</div>
										</div>
									</td>								
								</tr>
							<tr>
									<td>
										<div class="dia-calendario">22</div>

									</td>
									<td>
										<div class="dia-calendario">23</div>

									</td>
									<td>
										<div class="dia-calendario">24</div>

									</td>
									<td>
										<div class="dia-calendario">25</div>

									</td>
									<td>
										<div class="dia-calendario">26</div>

									</td>
									<td>
										<div class="dia-calendario">27</div>
	
									</td>
									<td>
										<div class="dia-calendario">28</div>
										<div class="eventos-calendario-wrap">
											<div class="eventos-dia-calendario agenda-verde">
												Reuniao Y
											</div>
											<div class="eventos-dia-calendario agenda-vermelha">
												Encontro
											</div>
										</div>	
									</td>								
								</tr>
							<tr>
									<td>
										<div class="dia-calendario">29</div>

									</td>
									<td>
										<div class="dia-calendario">30</div>

									</td>
									<td>
										<div class="dia-calendario">31</div>
									</td>
									<td>

									</td>
									<td>

									</td>
									<td>

									</td>
									<td>
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