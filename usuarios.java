package codigoFonte;

import java.sql.*;

public class usuarios {
	private Connection conBanco; 
	private PreparedStatement psComando;
	private ResultSet rsRegistros;
	
	public void configurarConexao(Connection conBanco) {this.conBanco = conBanco;}
	
	public boolean inserirRegistro(c_usuarios usuario) {
		String strComandoSQL; 
		try {
			strComandoSQL = "insert into usuarios(identificacao_usuario,senha_acesso, cadastro_funcionario, cadastro_usuario, cadastro_paciente, cadastro_especialidade,"+"cadastro_medico,cadastro_convenio, agendamento_consulta, cancelamento_consulta, modulo_administrativo, modulo_agendamento,modulo_atendimento)"+
		"values('"+usuario.getIdUsuario()+"',"
					+"'"+usuario.getSenhaAcesso()+"',"
					+"'"+usuario.getCadastroFuncionario()+"',"
					+"'"+usuario.getCadastroUsuario()+"',"
					+"'"+usuario.getCadastroPaciente()+"',"
					+"'"+usuario.getCadastroEspecialidade()+"',"
					+"'"+usuario.getCadastroMedico()+"',"
					+"'"+usuario.getCadastroConvenio()+"',"
					+"'"+usuario.getAgendamentoConsulta()+"',"
					+"'"+usuario.getCancelamentoConsulta()+"',"
					+"'"+usuario.getModuloAdministrativo()+"',"
					+"'"+usuario.getModuloAgendamento()+"',"
					+"'"+usuario.getModuloAtendimento()+"')";
			psComando = conBanco.prepareStatement(strComandoSQL);
			psComando.executeUpdate();
			
			return true;		
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
			
	}
	
	public int LocalizarRegistro(String strUsuario) {
		int intCodigoUsuario = 0 ;
		String  strComandoSQL;
		try {
			strComandoSQL = "SELECT Registro_Usuario FROM usuarios WHERE Identificacao_Usuario = '"+strUsuario+"'";
			psComando = conBanco.prepareStatement(strComandoSQL);
			rsRegistros = psComando.executeQuery();
			rsRegistros.next();
			
			intCodigoUsuario = rsRegistros.getInt("Registro_Usuario");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return intCodigoUsuario;
	}
	
	public ResultSet lerRegistro(int intCodigoUsuario) {
		String strComandoSQL;
		
		try {
			strComandoSQL = "SELECT * FROM usuarios WHERE Registro_Usuario = "+intCodigoUsuario;
			psComando = conBanco.prepareStatement(strComandoSQL);
			rsRegistros = psComando.executeQuery();
			rsRegistros.next();
			 return rsRegistros;
		
		}catch(Exception erro) {
			erro.printStackTrace();
			return null;
		}
		
	}
	
	public boolean alterarRegistro(c_usuarios usuario) {
		String strComandoSQL;
		try
		{
			strComandoSQL = "UPDATE  usuarios SET Identificacao_Usuario = '"+usuario.getIdUsuario()+"',"
					+"Senha_Acesso= '"+usuario.getSenhaAcesso()+"',"+
					"Cadastro_Funcionario = '"+usuario.getCadastroFuncionario()+"',"+
					"Cadastro_Usuario= '"+usuario.getCadastroUsuario()+"',"+
					"Cadastro_Paciente= '"+usuario.getCadastroPaciente()+"',"+
					"Cadastro_Especialidade='"+usuario.getCadastroEspecialidade()+"',"+
					"Cadastro_Medico='"+usuario.getCadastroMedico()+"',"+
					"Cadastro_Convenio='"+usuario.getCadastroConvenio()+"',"+
					"Agendamento_Consulta='"+usuario.getAgendamentoConsulta()+"',"+
					"Cancelamento_Consulta= '"+usuario.getCancelamentoConsulta()+"',"+
					"Modulo_Administrativo='"+usuario.getModuloAdministrativo()+"',"+
					"Modulo_Agendamento= '"+usuario.getModuloAgendamento()+"',"+
					"Moldulo_Atendimento='"+usuario.getModuloAtendimento()+"',"+
					"WHERE Registro_Usuario= "+usuario.getCodigoUsuario();
			psComando=conBanco.prepareStatement(strComandoSQL);
			psComando.executeUpdate();
			
			return true;
		}catch(Exception erro) {
			erro.printStackTrace();
			return false;
		}
	}
	
	public boolean excluirRegistro(int intCodigoUsuario) {
		
		String strComandoSQL;
		
		try
		{
			strComandoSQL = "DELETE FROM usuarios WHERE Registro_Usuario = "+intCodigoUsuario;
			psComando = conBanco.prepareStatement(strComandoSQL);
			psComando.executeUpdate();
			
			return true; 
		}catch(Exception e) {
			e.printStackTrace();
			return false; 
		}
		
	}
}
