<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import = "codigoFonte.c_usuarios" %>
<jsp:useBean id="conexao" scope="page" class="banco_dados.conexaoBancoDados"></jsp:useBean>
<jsp:useBean id="usuario" scope="page" class="codigoFonte.usuarios"></jsp:useBean>     
    
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
	
				blnConectado = true;
			}
			else
			{
				out.println("<p>Falha de conexão com o banco de Dados !</p>");
			}
		%>
		<%if(blnConectado) {%>
		<p class = "TituloAplicacao">SGC - SITEMA DE GESTÃO DE CLÍNICAS 1.0 </p>
		<p class= "TituloPagina">Cadastro de Funcionarios - Edição</p>
		
		<form name="formEditaUsuario" method="post" value="atualizarUsuario" target="_parent">
			<p>Nome do Usuário: <input type="text" name="txtNomeUsuario" size="20" maxlength="20" value="<%=Usuario.getIdUsuario() %>" /></p>
			<% if(Usuario.getModuloAdministrativo().equals("S")) {%>
			<p><input name = "chkAdministrativo" type ="checkbox" value="ModuloAdministrativo" checked="checked"/>Modulo Administrativo</p>
			<%
				}
			  else
			  {
			  %>
			  <p><input name="chkAdministrativo" type="checkbox" value="ModuloAdministrativo"/>Módulo Administrativo</p>
			  <% } %>
			  <%if(Usuario.getCadastroFuncionario().equals("S")){ %>
			  <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkFuncionario" type="checkbox" value="Funcionario" checked="checked"/>Cadastro de Funcionários</p>
			  <%
			  }
			  else
			  {
			  %>
			  <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name=chkFuncionario type="checkbox" value= Funcionario/>Cadastro de Funcionários</p>
			  <% } %>
			  <%
			  if(Usuario.getCadastroUsuario().equals("S")){%>
			  <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkUsuario" type="checkbox" value="Usuario" checked="checked"/>Cadastro de Usuários</p>
			  <%
			  }
			  else
			  {
			  %>
			  <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkUsuario" type ="checkbox" value="Usuario"/>Cadastro de Usuários</p>
			  <% } %>
			  <%if(Usuario.getCadastroEspecialidade().equals("S")){ %>
			  <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name ="chkEspecialidade" type="checkbox" value="Especialidade" checked="checked"/>Cadastro de Especialidade</p>
			  <%
			  }
			  else
			  {
			  %>
			    <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name ="chkEspecialidade" type="checkbox" value="Especialidade"/>Cadastro de Especialidade</p>
			  <% } %>
			  <%if(Usuario.getCadastroMedico().equals("S")){ %>
			  <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkMedico" type="checkbox" value="Medico" checked="checked"/>Cadastro de Médicos</p>
			  <%
			  }
			  else
			  {
			  %>
			  <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkMedico" type="checkbox" value="Medico"/>Cadastro de Médicos</p>
			   <% } %>
			   <%if(Usuario.getCadastroConvenio().equals("S")){ %>
			   <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkConvenio" type="checkbox" value="Convenio" checked="checked"/>Cadastro de Convenios</p>
			   <%
			   }
			   else
			   {
			   %>
			   <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkConvenio" type="checkbox" value="Convenio"/>Cadastro de Convenios</p>
			   <% } %>
			   <% if(Usuario.getModuloAgendamento().equals("S")){ %>
			   <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkAgendamento" type="checkbox" value="ModuloAgendamento" checked="checked"/>Módulo de agendamento.</p>
			   <%
			   }
			   else
			   {
			   %>
			   <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkAgendamento" type="checkbox" value="ModuloAgendamento""/>Módulo de agendamento.</p>	  	   	 
			  <% } %>
			  <%if(Usuario.getCadastroPaciente().equals("S")){ %>
			  <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkPaciente" type="checkbox" value="Paciente" checked="checked"/>Cadastro de pacientes</p>
			  <%
			  }
			  else
			  {
			  %>
			  <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkPaciente" type="checkbox" value="Paciente"/>Cadastro de pacientes</p>
			  <% } %>
			  <% if(Usuario.getAgendamentoConsulta().equals("S")){ %>
			  <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkAgendarConsulta" type="checkbox" value="AgendarConsulta" checked="checked"/>Agendamento de Consulta</p>
			  <%
			  }
			  else
			  {
			  %>
			  <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkAgendarConsulta" type="checkbox" value="AgendarConsulta"/>Agendamento de Consulta</p>
			  <% } %>
			  <% if(Usuario.getCancelamentoConsulta().equals("S")){ %>
			  <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkCancelarConsulta" type="checkbox" value="CancelarConsulta" checked="checked"/>Cancelamento de Consulta</p>
			  <%
			  }
			  else
			  {
			  %>
			   <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkCancelarConsulta" type="checkbox" value="CancelarConsulta"/>Cancelamento de Consulta</p>
			  <% } %> 
			  <%if(Usuario.getModuloAtendimento().equals("S")){ %>
			   <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkAtendimento" type="checkbox" value="ModuloAtendimento" checked="checked"/>Módulo de Atendimento Médico</p>
			    <%
			     }
			     else
			     {
			    %>
			    <p>&nbsp;&nbsp;&nbsp;&nbsp;<input name="chkAtendimento" type="checkbox" value="ModuloAtendimento"/>Módulo de Atendimento Médico</p>
			    <% } %>
			     <p>
			     	<input type="hidden" name="codigo_usuario" value="<%= intCodigoUsuario %>">
			     	<input type="hidden" name="senha_acesso" value="<%= Usuario.getSenhaAcesso()%>">
			     </p>
			     <br>
			     <p><input type="submit" name="btnAtualizar" value="Atualizar"/>
			     	<span class="LinkVoltar"><a href="javascript:history.back()">[ VOLTAR ]</a></span>
			     </p> 
		</form>
		<p class="RodapePagina">Copyright(c)- EDITORA ERICA LTDA </p>
		<% } %>
	</body>
</html>