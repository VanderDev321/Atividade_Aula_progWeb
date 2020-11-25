package codigoFonte;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import banco_dados.conexaoBancoDados;
import codigoFonte.*;
import java.sql.ResultSet;
/**
 * Servlet implementation class pesquisarUsuario
 */
@WebServlet("/pesquisarUsuario")
public class pesquisarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pesquisarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rsRegistro ;
		PrintWriter out;
		String strUsuario;
		int intCodigoUsuario; 
		
		strUsuario = request.getParameter("txtUsuario");
		
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html;charset=utf-8'>");
		out.println("<title>SGC - VERSAO 1.0 </title>");
		out.println("<link href='clinica_medica.css' rel ='stylesheet' type='text/css'/>");
		out.println("</head>");
		out.println("<body class='FundoPagina'>");
		out.println("<p class='TituloAplicacao'>SGC - Sistema de Gestão de Clinicas 1.0 </p>");
		out.println("<p class='TituloPagina'> Cadastro de Usuários</p>");
		try
		{
			conexaoBancoDados conexao = new conexaoBancoDados();
			usuarios usuario = new usuarios();
			
			if(conexao.abrirConexao()){
				
				usuario.configurarConexao(conexao.obterConexao());
				intCodigoUsuario = usuario.LocalizarRegistro(strUsuario.toUpperCase());
				if(intCodigoUsuario != 0)
				{
					rsRegistro = usuario.lerRegistro(intCodigoUsuario);
					
					out.println("Identificação do Usuário: "+rsRegistro.getString("identificacao_usuario")+"<br>");
					out.println("<br><br>");
					out.println("<a href ='editar_Usuario.jsp?codigo_usuario="+intCodigoUsuario+"'>[ EDITAR ]</a><a href='excluir_Usuario.jsp?codigo_usuario="+intCodigoUsuario+"'>[EXCLUIR]</a>");
					out.println("<span class='linkVoltar'><a href='javascript:history.back()>[ VOLTAR ] </a>/span>");
					
				}
				else
				{
					out.println("<h2>Usuario não encontrado!</h2>");
					out.println("<br><br><br>");
					out.println("<p class ='LinkVoltar'><a href='javascript:history.back()'>[ VOLTAR ] </a></p>");
				}
				conexao.fecharConexao();
			}
			else
			{
				out.println("<h2>Não foi possível estabelecer conexão com o Banco de Dados :( </h2>");
			}
		}
			catch(Exception erro) {
				erro.printStackTrace();
				out.println("<h2>Erro do Sistema:processo de Cadastro de Usuário.</h2>");
			}
		out.println("<p class ='RodapePagina'>Copyright(c)- Editora Erica LTDA </p>");
		out.println("</body>");
		out.println("</html>");
		}
		
}


