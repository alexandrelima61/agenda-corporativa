<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@page import="br.edu.ifrn.agenda.beans.Tarefa"%>
<%@page import="br.edu.ifrn.agenda.beans.Lembrete"%>
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
										<a href="<%=request.getContextPath() %>/AgendaServlet?pagina=editar&id=1" >Agenda Laranja</a>
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

							</thead>
							
			
							<tbody>
								<tr>
								<% for(int i = 1; i < 8; i++){%>
									<td>
										<div class="dia-calendario"><%= i %></div>
										
										<%  String data = "0"+i+"/01/2010";
											
							        		for(Tarefa tarefa : Sistema.getInstance().recuperarTarefaPorDia(data)){ %>
							        		<div class="eventos-dia-calendario agenda-vermelha">				
											  	<a style="color : white" href="<%=request.getContextPath() %>/TarefaServlet?comando=visualizarTarefa&id=<%=tarefa.getOid() %>"> <%=tarefa.getTitulo() %></a>
											  	</div>
										<% } for(Compromisso com : Sistema.getInstance().recuperarCompromissoPorDia(data)){ %>
											
											<div class="eventos-dia-calendario agenda-verde">			
											  	<a style="color : white" href="<%=request.getContextPath()%>/CompromissoServlet?pagina=visualizar&id=<%=com.getOid()%>"> <%=com.getTitulo() %></a>
											 </div>
													
										<% } for(Lembrete lem : Sistema.getInstance().recuperarLembretePorDia(data)){ %>
											
											<div class="eventos-dia-calendario agenda-laranja">			
											  	<a style="color : white" href="<%=request.getContextPath()%>/LembreteServlet?pagina=editar&idLem=<%=lem.getOid()%>"> <%=lem.getTitulo() %></a>
											 </div>
										<% }%>	
																											
										</div>
									</td>
								<%} %>
								
								</tr>
								
								
																<tr>
								<% for(int i = 8; i < 15; i++){%>
									<td>
										<div class="dia-calendario"><%= i %></div>
										<div class="eventos-calendario-wrap">
										<%  String data = "";
										if(i < 10) data = "0"+i+"/01/2010"; 	else data = i+"/01/2010";
										
											
							        		for(Tarefa tarefa : Sistema.getInstance().recuperarTarefaPorDia(data)){ %>
							        		<div class="eventos-dia-calendario agenda-vermelha">				
											  	<a style="color : white" href="<%=request.getContextPath() %>/TarefaServlet?comando=visualizarTarefa&id=<%=tarefa.getOid() %>"> <%=tarefa.getTitulo() %></a>
											 </div>
										<% } for(Compromisso com : Sistema.getInstance().recuperarCompromissoPorDia(data)){ %>
											
											<div class="eventos-dia-calendario agenda-verde">			
											  	<a  style="color : white" href="<%=request.getContextPath()%>/CompromissoServlet?pagina=visualizar&id=<%=com.getOid()%>"> <%=com.getTitulo() %></a>
											 </div>
													
										<% } for(Lembrete lem : Sistema.getInstance().recuperarLembretePorDia(data)){ %>
											
											<div class="eventos-dia-calendario agenda-laranja">			
											  	<a  style="color : white" href="<%=request.getContextPath()%>/LembreteServlet?pagina=editar&idLem=<%=lem.getOid()%>"> <%=lem.getTitulo() %></a>
											 </div>
										<% }%>	
																											
										</div>
										</div>
									</td>
								<%} %>
								
								</tr>
								
								<tr>
								<% for(int i = 15; i < 22; i++){%>
									<td>
										<div class="dia-calendario"><%= i %></div>
										<div class="eventos-calendario-wrap">
										<%  String data = i+"/01/2010";
											
							        		for(Tarefa tarefa : Sistema.getInstance().recuperarTarefaPorDia(data)){ %>
							        		<div class="eventos-dia-calendario agenda-vermelha">				
											  	<a style="color : white" href="<%=request.getContextPath() %>/TarefaServlet?comando=visualizarTarefa&id=<%=tarefa.getOid() %>"> <%=tarefa.getTitulo() %></a>
											  	</div>
										<% } for(Compromisso com : Sistema.getInstance().recuperarCompromissoPorDia(data)){ %>
											
											<div class="eventos-dia-calendario agenda-verde">			
											  	<a style="color : white" href="<%=request.getContextPath()%>/CompromissoServlet?pagina=visualizar&id=<%=com.getOid()%>"> <%=com.getTitulo() %></a>
											 </div>
													
										<% } for(Lembrete lem : Sistema.getInstance().recuperarLembretePorDia(data)){ %>
											
											<div class="eventos-dia-calendario agenda-laranja">			
											  	<a  style="color : white" href= "<%=request.getContextPath()%>/LembreteServlet?pagina=editar&idLem=<%=lem.getOid()%>"> <%=lem.getTitulo() %></a>
											 </div>
										<% }%>	
																											
										</div>
										</div>
									</td>
								<%} %>
								
								</tr>
								
								<tr>
								<% for(int i = 22; i < 29; i++){%>
									<td>
										<div class="dia-calendario"><%= i %></div>
										<div class="eventos-calendario-wrap">
										<%  String data = i+"/01/2010";
											
							        		for(Tarefa tarefa : Sistema.getInstance().recuperarTarefaPorDia(data)){ %>
							        		<div class="eventos-dia-calendario agenda-vermelha">				
											  	<a  style="color : white" href="<%=request.getContextPath() %>/TarefaServlet?comando=visualizarTarefa&id=<%=tarefa.getOid() %>"> <%=tarefa.getTitulo() %></a>
											  </div>
										<% } for(Compromisso com : Sistema.getInstance().recuperarCompromissoPorDia(data)){ %>
											
											<div class="eventos-dia-calendario agenda-verde">			
											  	<a style="color : white"  href="<%=request.getContextPath()%>/CompromissoServlet?pagina=visualizar&id=<%=com.getOid()%>"> <%=com.getTitulo() %></a>
											 </div>
													
										<% } for(Lembrete lem : Sistema.getInstance().recuperarLembretePorDia(data)){ %>
											
											<div class="eventos-dia-calendario agenda-laranja">			
											  	<a style="color : white"  href="<%=request.getContextPath()%>/LembreteServlet?pagina=editar&idLem=<%=lem.getOid()%>"> <%=lem.getTitulo() %></a>
											 </div>
										<% }%>	
																											
										</div>
										</div>
									</td>
								<%} %>
								
								</tr>
								<tr>
								<% for(int i = 29; i < 32; i++){%>
									<td>
										<div class="dia-calendario"><%= i %></div>
										<div class="eventos-calendario-wrap">
										
										<%  String data = i+"/01/2010";
											
							        		for(Tarefa tarefa : Sistema.getInstance().recuperarTarefaPorDia(data)){ %>
							        		<div class="eventos-dia-calendario agenda-vermelha">				
											  	<a style="color : white" href="<%=request.getContextPath() %>/TarefaServlet?comando=visualizarTarefa&id=<%=tarefa.getOid() %>"> <%=tarefa.getTitulo() %></a>
											 </div>
										<% } for(Compromisso com : Sistema.getInstance().recuperarCompromissoPorDia(data)){ %>
											
											<div class="eventos-dia-calendario agenda-verde">			
											  	<a style="color : white"  href="<%=request.getContextPath()%>/CompromissoServlet?pagina=visualizar&id=<%=com.getOid()%>"> <%=com.getTitulo() %></a>
											 </div>
													
										<% } for(Lembrete lem : Sistema.getInstance().recuperarLembretePorDia(data)){ %>
											
											<div class="eventos-dia-calendario agenda-laranja">			
											  	<a style="color : white"  href="<%=request.getContextPath()%>/LembreteServlet?pagina=editar&idLem=<%=lem.getOid()%>"> <%=lem.getTitulo() %></a>
											 </div>
										<% }%>	
										</div>																
										</div>
									</td>
								<%} %>
				


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