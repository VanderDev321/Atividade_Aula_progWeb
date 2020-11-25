<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.ResultSet"%>
<%@ page import = "codigoFonte.*" %>
<jsp:useBean id="conexao" scope ="page" class="banco_dados.conexaoBancoDados"></jsp:useBean>
<jsp:useBean id="usuario" scope="page" class= "codigoFonte.usuarios"></jsp:useBean>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html charset= UTF-8"/>
		<title>SGC - VERSAO 1.0 </title>
		<link href="clinica.medica.css" rel ="stylesheet" type="text/css"/>
	</head>
	<body class="FundoPagina">
		<%
			ResultSet rsRegistro;
			boolean blnConectado;
			
			c_usuarios Usuario = new c_usuarios();
			int intCodigoUsuario = Integer.parseInt(request.getParameter("codigo_usuario"));
			blnConectado = false;
			
			if(conexao.abrirConexao())
			{
				usuario.configurarConexao(conexao.obterConexao());
				rsRegistro = usuario.lerRegistro(intCodigoUsuario);
				
				Usuario.setIdUsuario(rsRegistro.getString("identificacao_usuario"));
				Usuario.setSenhaAcesso(rsRegistro.getString("senha_acesso"));
				Usuario.setCadastroFuncionario(rsRegistro.getString("cadastro_funcionario"));
				Usuario.setCadastroUsuario(rsRegistro.getString("cadastro_usuario"));
				Usuario.setCadastroPaciente(rsRegistro.getString("cadastro_paciente"));
				Usuario.setCadastroEspecialidade(rsRegistro.getString("cadastro_especialidade"));
				Usuario.setCadastroMedico(rsRegistro.getString("cadastro_medico"));
				Usuario.setCadastroConvenio(rsRegistro.getString("cadastro_convenio"));
				Usuario.setAgendamentoConsulta(rsRegistro.getString("agendamento_consulta"));
				Usuario.setCancelamentoConsulta(rsRegistro.getString("cancelamento_consulta"));
				Usuario.setModuloAdministrativo(rsRegistro.getString("modulo_administrativo"));
				Usuario.setModuloAgendamento(rsRegistro.getString("modulo_agendamento"));
				Usuario.setModuloAtendimento(rsRegistro.getString("modulo_atendimento"));
				Usuario.setCodigoUsuario(intCodigoUsuario);
				
				conexao.fecharConexao();
	
				blnConectado = true;}
			else
			{
				out.println("<p>Falha de conex�o com o banco de Dados !</p>");
			}
		%>
		<%if(blnConectado){ %>
		<p class = "TituloAplicacao">SGC - SITEMA DE GEST�O DE CL�NICAS 1.0 </p>
		<p class= "TituloPagina">Cadastro de Funcionarios - Exclus�o </p>
		<form name="formExcluiUsuario" method="post" action="excluirUsuario" target="_parent">
			<p>Nome do Usu�rio: <%=Usuario.getIdUsuario() %></p>
			<br>
			<p>Modulo Administrativo: <%=Usuario.getModuloAdministrativo()%></p>
			<br>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;Cadastro de Funcion�rios: <%=Usuario.getCadastroFuncionario() %></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;Cadastro de Usu�rios: <%=Usuario.getCadastroUsuario() %></p>
			<p>&nbsp;&nbsp;&nbsp;;&nbsp;Cadastro de Especialidades:<%=Usuario.getCadastroEspecialidade() %></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;Cadastro de M�dicos:<%=Usuario.getCadastroMedico() %></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;Cadastro de Conv�nios:<%=Usuario.getCadastroConvenio() %></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;M�dulo de Agendamento:<%=Usuario.getModuloAgendamento() %></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;Cadastro de Pacientes:<%=Usuario.getCadastroPaciente() %></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;Agendamento de Consulta:<%=Usuario.getAgendamentoConsulta() %></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;Cancelamento de Consulta:<%=Usuario.getCancelamentoConsulta() %></p>
			<p>M�dulo de atendimento m�dico:<%=Usuario.getModuloAtendimento()%></p>
			<p><input type="hidden" name="codigo_usuario"value="<%=intCodigoUsuario %>"></p>
			<p><input type="submit" name="btnExcluir" value="Excluir"/>
				<span class="LinkVoltar"><a href="javascript:history.back()"><button>[VOLTAR]</button></a></span>
			</p>
		</form>	
		<p class="RodapePagina">Copyright(c)- 2015 EDITORA ERICA LTDA.</p>
		<% } %>
	</body>
</html>