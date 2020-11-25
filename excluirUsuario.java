package codigoFonte;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.apache.catalina.connector.Request;

import banco_dados.*;
import codigoFonte.*;

public class excluirUsuario extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out; 
		resp.setContentType("text/html;charset=UTF-8");
		out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>");
		out.println("<title>SGC - VERSAO 1.0 </title>");
		out.println("<link href='clinica_medica.css' rel='stylesheet' type='text/css'/>");
		out.println("</head>");
		out.println("<body class='FundoPagina'>");
		out.println("<p class='TituloAplicacao'>SGC - Sistema de Gestão de Clinicas 1.0</p>");
		out.println("<!DOCTYPE html>");
		out.println("<p class='TituloPagina'>Cadastro de Usuários</p>");
		
		try
		{
			conexaoBancoDados con = new conexaoBancoDados();
			usuarios usuarios = new usuarios();
			if(con.abrirConexao()) {
				usuarios.configurarConexao(con.obterConexao());
				if(usuarios.excluirRegistro(Integer.parseInt(req.getParameter("codigo_usuario")))){
					
					out.println("<h2>Registro de usuário excluído com sucesso!</h2>");
					out.println("<br><br><br><br>");
					out.println("<a href='menu_usuarios.html>[FECHAR]</a>");
				}
				else {
					out.println("<h2>Não foi possível excluir o registro do usuário</h2>");
					con.fecharConexao();
				}				
			}
			else {
				out.println("<h2>Não foi possível estabelecer conexao com o banco de dados! </h2>");
			}
				
		}
		catch(Exception erro) {
			erro.printStackTrace();
			out.println("<h2>Erro do sistema: processo de exclusão de usuário</h2>");
		}
		
		out.println("<p class='RodapePagina'>Copyright (c) - 2015 EDITORA ERICA LTDA </p>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
