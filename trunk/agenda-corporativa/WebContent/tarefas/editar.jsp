<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>

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
					
						
						
						
<div id="internas-content">
<div class="backBtn"><a href="<%=request.getContextPath() %>">Voltar</a></div>
	<h2>Editar Tarefa</h2>
<form action="<%=request.getContextPath() %>/TarefaServlet?" method="post">
  <fieldset>
  
  <jsp:useBean id="tarefa" scope="request" type="br.edu.ifrn.agenda.beans.Tarefa"></jsp:useBean>
  
  <label for="Título">Título</label>
  <input type="hidden" name="oidTarefa" value="2"/>
  <input type="hidden" name="comando" value="editarTarefa"/>
  <input type="hidden" name="idTarefa" value="<%=tarefa.getOid()%>"/>
  <input type="text" class="input-longo" name="tituloTarefa" id="tituloTarefa" value="<%=tarefa.getTitulo()%>"/>
     

		<div class="inputInline">
			<label for="Data">Data</label>
			<% SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); %>			
			<input type="text" class="input-longo" name="dataTarefa" id="dataTarefa" value="<%=dt.format(tarefa.getData())%>"/>
			<% SimpleDateFormat hr = new SimpleDateFormat("HH:mm"); %>
			<label for="Hora">Hora</label>
			<input type="text" class="input-longo" name="horaTarefa" id="horaTarefa" value="<%=hr.format(tarefa.getData())%>"/>						
		</div>
		
  <label for="Local">Local</label>
  <input type="text" class="input-longo" name="localTarefa" id="localTarefa" value="<%=tarefa.getLocal()%>"/>
  <label for="Descrição">Descrição</label>
  <textarea name="descricaoTarefa" id="descricaoTarefa" ><%=tarefa.getDescricao()%></textarea>
  
	<div class="buttonsForm">
		<input type="submit" value="Editar"/>
		<input type="reset" value="Limpar" />		
	</div>
</fieldset>
</form>
</div>