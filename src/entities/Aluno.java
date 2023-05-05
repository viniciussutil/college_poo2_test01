package entities;

public class Aluno {
	
	private String nome;
	private String endereco;
	private String telefone;
	private String cpf;
	private String tipoSanguineo;
	private String rh;
	private String curso;
	private String contatoEmergencia;
	private String telefoneEmergencia;
	private int id;
	
	public Aluno(String nome, String endereco, String telefone, String cpf, String tipoSanguineo, String rh,
			String curso, String contatoEmergencia, String telefoneEmergencia) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.tipoSanguineo = tipoSanguineo;
		this.rh = rh;
		this.curso = curso;
		this.contatoEmergencia = contatoEmergencia;
		this.telefoneEmergencia = telefoneEmergencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getRh() {
		return rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getContatoEmergencia() {
		return contatoEmergencia;
	}

	public void setContatoEmergencia(String contatoEmergencia) {
		this.contatoEmergencia = contatoEmergencia;
	}

	public String getTelefoneEmergencia() {
		return telefoneEmergencia;
	}

	public void setTelefoneEmergencia(String telefoneEmergencia) {
		this.telefoneEmergencia = telefoneEmergencia;
	}
	
}