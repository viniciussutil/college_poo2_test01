package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

	Connection conn;
	
	final String url_db;
	final String user;
	final String password;

	public DB() {
		url_db = "jdbc:mysql://localhost:3307/dbpoo";
		user = "root";
		password = "admin";
	}

	private void getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url_db, user, password);
			System.out.println("Conexao realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao acessar o Banco de Dados!");
		}
	}

	private void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

	public int insertData(entities.Aluno objAluno) throws SQLException {
		
		getConnection();
		
		if (conn != null) {
			
			PreparedStatement inserir = conn.prepareStatement (
											"INSERT INTO aluno "
											+ "(nome, endereco, telefone, cpf, "
											+ "tipoSanguineo, rh, curso, contatoEmergencia, "
											+ "telefoneEmergencia) "
											+ "VALUES "
											+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			inserir.setString(1, objAluno.getNome());
			inserir.setString(2, objAluno.getEndereco());
			inserir.setString(3, objAluno.getTelefone());
			inserir.setString(4, objAluno.getCpf());
			inserir.setString(5, objAluno.getTipoSanguineo());
			inserir.setString(6, objAluno.getRh());
			inserir.setString(7, objAluno.getCurso());
			inserir.setString(8, objAluno.getContatoEmergencia());
			inserir.setString(9, objAluno.getTelefoneEmergencia());
			
			inserir.execute();
			closeConnection();
			
			return 1;
		} else {
			return 0;
		}
	}

	public int changeData(entities.Aluno objAluno, int id) throws SQLException {
		
		getConnection();
		
		if (conn != null) {
			
			PreparedStatement change = conn.prepareStatement (
										"UPDATE aluno "
										+ "SET nome = ?, endereco = ?, telefone = ?, "
										+ "cpf = ?, tipoSanguineo = ?, rh = ?, curso = ?, "
										+ "contatoEmergencia = ?, telefoneEmergencia = ? "
										+ "WHERE id = ?");
			
			change.setString(1, objAluno.getNome());
			change.setString(2, objAluno.getEndereco());
			change.setString(3, objAluno.getTelefone());
			change.setString(4, objAluno.getCpf());
			change.setString(5, objAluno.getTipoSanguineo());
			change.setString(6, objAluno.getRh());
			change.setString(7, objAluno.getCurso());
			change.setString(8, objAluno.getContatoEmergencia());
			change.setString(9, objAluno.getTelefoneEmergencia());
			change.setInt(10, id);
			
			change.execute();
			closeConnection();
			
			return 1;
		} else {
			return 0;
		}
	}

	public int removeData(int id) throws SQLException {
		
		getConnection();
		
		if (conn != null) {
			
			PreparedStatement remove = conn.prepareStatement("DELETE FROM aluno WHERE id = ?");
			
			remove.setInt(1, id);
			
			remove.execute();
			closeConnection();

			return 1;
		} else {
			return 0;
		}
	}

	public ArrayList<String> Relatorio() throws SQLException {

		getConnection();

		ArrayList<String> objRelatorio = new ArrayList<String>();

		if (conn != null) {

			Statement comandoConsulta = conn.createStatement();
			ResultSet resultadoConsulta = comandoConsulta.executeQuery("SELECT * FROM aluno");
			
			String nome;
			String endereco;
			String cpf;
			String tipoSanguineo;
			String rh;
			String curso;
			String contatoEmergencia;
			String telefone;
			String telefoneEmergencia;
			String id;
			String resultado;

			while (resultadoConsulta.next()) {

				nome = resultadoConsulta.getString("nome");
				endereco = resultadoConsulta.getString("endereco");
				telefone = resultadoConsulta.getString("telefone");
				cpf = resultadoConsulta.getString("cpf");
				tipoSanguineo = resultadoConsulta.getString("tipoSanguineo");
				rh = resultadoConsulta.getString("rh");
				curso = resultadoConsulta.getString("curso");
				contatoEmergencia = resultadoConsulta.getString("contatoEmergencia");
				telefoneEmergencia = resultadoConsulta.getString("telefoneEmergencia");
				id = resultadoConsulta.getString("id");

				resultado = "ID: " + id + "\r\nNome: " + nome + "\r\nEndereço: " + endereco + "\r\nTelefone: "
						+ telefone + "\r\nCPF: " + cpf + "\r\nTipo Sanguineo: " + tipoSanguineo + "\r\nFator RH: " + rh + "\r\nCurso: "
						+ curso + "\r\nContato Emergencia: " + contatoEmergencia + "\r\nTelefone Emergencia: "
						+ telefoneEmergencia;

				objRelatorio.add(resultado);
			}

			closeConnection();

			return objRelatorio;
		}

		return null;

	}
}