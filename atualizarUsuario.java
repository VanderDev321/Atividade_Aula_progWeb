package codigoFonte;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco_dados.conexaoBancoDados;

import java.io.PrintWriter;


/**
 * Servlet implementation class atualizarUsuario
 */
@WebServlet("/atualizarUsuario")
public class atualizarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public atualizarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strIDUsuario,strSenha, strAdministrativo,strFuncionario,strUsuario,strEspecialidade,strMedico,strConvenio,strAgendamento,
		strPaciente,strAgendarConsulta,strCancelarConsulta,strAtendimento;
		int intCodigoUsuario;
		PrintWriter out;
		
		strIDUsuario = request.getParameter("txtNomeUsuario");
		strSenha = request.getParameter("senha_acesso");
		intCodigoUsuario = Integer.parseInt(request.getParameter("codigo_usuario"));
		
		if(request.getParameter("chkAdministrativo")!= null)
		
			strAdministrativo = "S";
		else
			strAdministrativo = "N";
		
		if(request.getParameter("chkFuncionario")!= null)
			
			strFuncionario = "S";
		else
			strFuncionario = "N";
		if(request.getParameter("chkUsuario")!= null)
			
			strUsuario = "S";
		else
			strUsuario = "N";
		if(request.getParameter("chkEspecialidade")!= null)
			
			strEspecialidade = "S";
		else
			strEspecialidade = "N";
		if(request.getParameter("chkMedico")!= null)
			
			strMedico = "S";
		else
			strMedico = "N";
		if(request.getParameter("chkConvenio")!= null)
			
			strConvenio = "S";
		else
			strConvenio = "N";
		if(request.getParameter("chkAgendamento")!= null)
			
			strAgendamento = "S";
		else
			strAgendamento = "N";
		if(request.getParameter("chkPaciente")!= null)
			
			strPaciente = "S";
		else
			strPaciente = "N";
		if(request.getParameter("chkAgendarConsulta")!= null)
			
			strAgendarConsulta = "S";
		else
			strAgendarConsulta = "N";
		if(request.getParameter("chkCancelarConsulta")!= null)
			
			strCancelarConsulta = "S";
		else
			strCancelarConsulta = "N";
		if(request.getParameter("chkAtendimento")!= null)
			
			strAtendimento = "S";
		else
			strAtendimento = "N";
		
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html;charset=utf-8'/>");
		out.println("<title>SGC-VERSÃO 1.0</title>");
		out.println("<link href='clinica_medica.css' rel='stylesheet' type='text/css'/>");
		out.println("</head>");
		out.println("<body class='FundoPagina'>");
		out.println("<p class='TituloAplicacao'>SGC- Sistema de Gestao de Clinicas 1.0 </p> ");
		out.println("<p class='TituloPagina'>Cadastro de Usuários</p>");
		
		try {
			conexaoBancoDados conexao = new conexaoBancoDados();
			usuarios user = new usuarios();
			
			c_usuarios Usuario= new c_usuarios(strIDUsuario.toUpperCase(),strSenha.toUpperCase(),
					strAdministrativo,strFuncionario,strUsuario,strEspecialidade,strMedico,strConvenio,strAgendamento
					,strPaciente,strAgendarConsulta,strCancelarConsulta,intCodigoUsuario);
			if(conexao.abrirConexao()) {
				user.configurarConexao(conexao.obterConexao());
				if(user.alterarRegistro(Usuario))
				{
					out.println("<h2>Dados atualizados com sucesso!</h2>");
					out.println("<br><br><br><br>");
					out.println("<a href='menu_usuarios.html'><button>Fechar</button></a>");
					out.println();
				}
				else
				{
					out.println("<h2>Não foi possivel atualizar os dados do usuário.</h2>");
					conexao.fecharConexao();
				}
			}
			else
			{
				out.println("<h2>Não foi possível estabelecer conexão com o banco de dados!!</h2>");
				
			}
		}
		catch(Exception erro)
		{
			erro.printStackTrace();
			out.println("<h2>Erro do Sistema: processo de atualização de dados. </h2>");
			
		}
		out.println("<p class ='RodapePagina'>Copyright (c) 2015 - EDITORA ERICA LTDA</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
