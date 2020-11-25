package codigoFonte;

import java.sql.*;

public class especialidades {
	
	private Connection conBanco; 
	private PreparedStatement psComando;
	private ResultSet rsRegistros; 
	
	public void ConfigurarConexao(Connection conBanco) { this.conBanco = conBanco ;}
	
	public boolean inserirRegistro(String strDeclaracao) {
		String strComandoSql; 
		try {
			strComandoSql = "INSERT INTO especialidades(descricao_especialidade) VALUES ('"+strDeclaracao+"')";
			psComando = conBanco.prepareStatement(strComandoSql);
			psComando.executeUpdate();
			
			return true;
		}catch(Exception erro){
			erro.printStackTrace();
			return false; 
		}
	}
	
	public boolean AlterarRegistro(int intCodigo , String strDescricao) {
		String strComandoSql;
		try {
			strComandoSql = "UPDATE especialidades SET descricao_especialidade = '"+strDescricao+"'WHERE codigo_especialidade="+intCodigo;
			psComando = conBanco.prepareStatement(strComandoSql);
			psComando.executeUpdate();
			
		return true;
		
		}catch(Exception erro ) {
			erro.printStackTrace();
			return false;
		}
	}
	public boolean excluirRegistro(int intCodigo) {
		String strComandoSql;
		try {
			strComandoSql = "DELETE FROM especialidades WHERE codigo_especialidade = "+intCodigo;
			psComando = conBanco.prepareStatement(strComandoSql);
			psComando.executeUpdate();
			
			return true;
		}catch(Exception erro) {
			erro.printStackTrace();
			return false;
		}
	}
	public ResultSet listarRegistros(String strOrdem) {
		String strComandoSql;
		try {
			if (strOrdem == "CODIGO") {
				strComandoSql = "SELECT * FROM especialidades ORDER BY codigo_especialidade";
			}else {
				strComandoSql = "SELECT * FROM especialidades ORDER BY descricao_especialidade";
			}
			psComando = conBanco.prepareStatement(strComandoSql);
			rsRegistros = psComando.executeQuery();
			return rsRegistros;
		}catch(Exception erro) {
			erro.printStackTrace();
			return null;
		}
	}
}
