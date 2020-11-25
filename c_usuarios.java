package codigoFonte;

public class c_usuarios {
	private String idUsuario,
			senhaAcesso,
			cadastroFuncionario,
			cadastroUsuario,
			cadastroPaciente,
			cadastroEspecialidade,
			cadastroMedico,
			cadastroConvenio,
			agendamentoConsulta,
			cancelamentoConsulta,
			moduloAdministrativo,
			moduloAgendamento,
			moduloAtendimento;
	private int codigoUsuario;
	
	public c_usuarios()
	{
		this.idUsuario="";
		this.senhaAcesso="";
		this.cadastroFuncionario="";
		this.cadastroUsuario ="";
		this.cadastroPaciente="";
		this.cadastroEspecialidade="";
		this.cadastroMedico="";
		this.cadastroConvenio="";
		this.agendamentoConsulta="";
		this.cancelamentoConsulta="";
		this.moduloAdministrativo="";
		this.moduloAgendamento="";
		this.codigoUsuario = 0; 
		
	}
	public c_usuarios(String idUsuario,
			String senhaAcesso,
			String cadastroFuncionario,
			String cadastroUsuario,
			String cadastroPaciente,
			String cadastroEspecialidade,
			String cadastroMedico,
			String cadastroConvenio,
			String agendamentoConsulta,
			String cancelamentoConsulta,
			String moduloAdministrativo,
			String moduloAgendamento,
			int codigoUsuario) {
		
		this.idUsuario = idUsuario;
		this.senhaAcesso = senhaAcesso;
		this.cadastroFuncionario = cadastroFuncionario;
		this.cadastroUsuario = cadastroUsuario;
		this.cadastroPaciente = cadastroPaciente;
		this.cadastroEspecialidade = cadastroEspecialidade; 
		this.cadastroMedico = cadastroMedico;
		this.cadastroConvenio = cadastroConvenio; 
		this.agendamentoConsulta = agendamentoConsulta; 
		this.cancelamentoConsulta= cancelamentoConsulta; 
		this.moduloAdministrativo = moduloAdministrativo; 
		this.moduloAgendamento = moduloAgendamento; 
		this.codigoUsuario = codigoUsuario; 
	}
	
	public  void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public  void setSenhaAcesso(String senhaAcesso) {
		this.senhaAcesso = senhaAcesso;
	}
	public String getSenhaAcesso() {
		return senhaAcesso;
	}
	public  void setCadastroFuncionario(String cadastroFuncionario) {
		this.cadastroFuncionario = cadastroFuncionario;
	}
	public String getCadastroFuncionario() {
		return cadastroFuncionario;
	}
	public  void setCadastroUsuario(String cadastroUsuario) {
		this.cadastroUsuario = cadastroUsuario;
	}
	public String getCadastroUsuario() {
		return cadastroUsuario;
	}
	
	public  void setCadastroPaciente(String cadastroPaciente) {
		this.cadastroPaciente = cadastroPaciente;
	}
	public String getCadastroPaciente() {
		return cadastroPaciente;
	}
	public void setCadastroEspecialidade(String cadastroEspecialidade) {
		this.cadastroEspecialidade = cadastroEspecialidade;
	}
	public String getCadastroEspecialidade() {
		return cadastroEspecialidade;
	}
	public void setCadastroMedico(String cadastroMedico) {
		this.cadastroMedico = cadastroMedico;
	}
	public String getCadastroMedico() {
		return cadastroMedico;
	}
	public void setCadastroConvenio (String cadastroConvenio) {
		this.cadastroConvenio = cadastroConvenio;
	}
	public String getCadastroConvenio() {
		return cadastroConvenio;
	}
	public void setAgendamentoConsulta(String agendamentoConsulta) {
		this.agendamentoConsulta = agendamentoConsulta;
	}
	public String getAgendamentoConsulta() {
		return agendamentoConsulta;
	}
	public void setCancelamentoConsulta(String cancelamentoConsulta) {
		this.cancelamentoConsulta = cancelamentoConsulta;
	}
	public String getCancelamentoConsulta() {
		return cancelamentoConsulta;
	}
	public void setModuloAdministrativo(String moduloAdministrativo) {
		this.moduloAdministrativo = moduloAdministrativo;
	}
	public String getModuloAdministrativo() {
		return moduloAdministrativo;
	}
	public void setModuloAtendimento(String moduloAtendimento) {
		this.moduloAtendimento = moduloAtendimento;
	}
	public String getModuloAtendimento() {
		return moduloAtendimento;
	}
	public void setModuloAgendamento(String moduloAgendamento) {
		this.moduloAgendamento = moduloAgendamento;
	}
	public String getModuloAgendamento() {
		return moduloAgendamento;
	}
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public int getCodigoUsuario() {
		return codigoUsuario;
	}
	
	}
	
 	