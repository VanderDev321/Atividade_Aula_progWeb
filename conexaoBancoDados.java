package banco_dados;
 
import java.sql.*;
public class conexaoBancoDados {
	Connection conBanco;
	
	public boolean abrirConexao() {
		String url= "jdbc:mysql://localhost/clinica_medica?usetimeZone=true&serverTimezone=UTC";
		String userName= "vanderson";
		String password = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conBanco = DriverManager.getConnection(url,userName,password);
			return true;
		}
		catch(Exception erro){
			erro.printStackTrace();
			System.out.println("Driver nao encontrado");
			return false;
		}
	}
	public void fecharConexao() {
		try {
			conBanco.close();
		}
		catch(SQLException erro){
			erro.printStackTrace();
		}
	}
	public Connection obterConexao() {
		return conBanco;
	}

}