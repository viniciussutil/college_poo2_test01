package application;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class InterfaceGrafica extends JFrame implements ActionListener {

	db.DB base;

	private JButton buttonINSERT;
	private JButton buttonREMOVE;
	private JButton buttonCHANGE;
	private JButton buttonSEARCH;

	private JLabel lblNome;
	private JLabel lblEndereco;
	private JLabel lblTelefone;
	private JLabel lblCpf;
	private JLabel lblTipoSanguineo;
	private JLabel lblFatorRH;
	private JLabel lblCurso;
	private JLabel lblContatoEmergencia;
	private JLabel lblTelefoneEmergencia;
	private JLabel lblId;
	private JLabel lblResultadoPesquisa;
	private JLabel lblMensagem;
	
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtContatoEmergencia;
	private JTextField txtId;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtTelefoneEmergencia;

	private JComboBox boxCurso;
	private final String[] Curso = {"Direito", "Ciência da Computação", "Sistemas De Informação", "Medicina",
			"Psicologia", "Nutrição"};
	private JComboBox boxTipoSanguineo;
	private final String[] TipoSanguineo = { "A", "B", "AB", "O" };
	private JComboBox boxFatorRH;
	private final String[] FatorRH = { "+", "-" };

	private JTextArea listaPesquisaBancoDeDados;
	private JScrollPane scrollPesquisaBancoDeDados;

	private Container con;

	public InterfaceGrafica() {
		setSize(950, 500);
		setTitle("Cadastro de Aluno");
		con = getContentPane();
		con.setLayout(null);
		// centralizar
		setLocation(200, 130);
		// cor
		getContentPane().setBackground(new Color(124, 150, 160));

		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 10, 100, 20);
		txtNome = new JTextField();
		txtNome.setBounds(150, 10, 200, 20);
		con.add(lblNome);
		con.add(txtNome);
		
		lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(10, 80, 100, 20);
		txtEndereco = new JTextField();
		txtEndereco.setBounds(150, 80, 200, 20);
		con.add(lblEndereco);
		con.add(txtEndereco);
		
		lblTelefone = new JLabel("Telefone");
		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		lblTelefone.setBounds(10, 45, 100, 20);
		txtTelefone.setBounds(150, 45, 200, 20);
		con.add(lblTelefone);
		con.add(txtTelefone);
		
		lblCpf = new JLabel("CPF");
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		lblCpf.setBounds(10, 115, 100, 20);
		txtCpf.setBounds(150, 115, 200, 20);
		con.add(lblCpf);
		con.add(txtCpf);
		
		lblTipoSanguineo = new JLabel("Tipo Sanguíneo");
		lblTipoSanguineo.setBounds(10, 155, 100, 20);
		boxTipoSanguineo = new JComboBox(TipoSanguineo);
		boxTipoSanguineo.setBounds(150, 155, 50, 20);
		con.add(lblTipoSanguineo);
		con.add(boxTipoSanguineo);

		lblFatorRH = new JLabel("Fator RH");
		lblFatorRH.setBounds(240, 155, 100, 20);
		boxFatorRH = new JComboBox(FatorRH);
		boxFatorRH.setBounds(300, 155, 50, 20);
		con.add(lblFatorRH);
		con.add(boxFatorRH);

		lblCurso = new JLabel("Curso");
		lblCurso.setBounds(10, 195, 100, 20);
		boxCurso = new JComboBox(Curso);
		boxCurso.setBounds(150, 195, 200, 20);
		con.add(lblCurso);
		con.add(boxCurso);

		lblContatoEmergencia = new JLabel("Contato de emergência");
		lblContatoEmergencia.setBounds(10, 235, 150, 20);
		txtContatoEmergencia = new JTextField();
		txtContatoEmergencia.setBounds(150, 236, 200, 20);
		con.add(lblContatoEmergencia);
		con.add(txtContatoEmergencia);
		
		lblTelefoneEmergencia = new JLabel("Telefone");
		try {
			txtTelefoneEmergencia = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		lblTelefoneEmergencia.setBounds(10, 275, 200, 20);
		txtTelefoneEmergencia.setBounds(150, 275, 200, 20);
		con.add(lblTelefoneEmergencia);
		con.add(txtTelefoneEmergencia);		

		lblId = new JLabel("ID");
		lblId.setBounds(305, 365, 100, 20);
		txtId = new JTextField();
		txtId.setBounds(320, 365, 30, 20);
		con.add(lblId);
		con.add(txtId);		

		lblResultadoPesquisa = new JLabel("Resultado da pesquisa no Banco de Dados");
		lblResultadoPesquisa.setBounds(515, 5, 300, 20);
		con.add(lblResultadoPesquisa);

		listaPesquisaBancoDeDados = new JTextArea();
		scrollPesquisaBancoDeDados = new JScrollPane(listaPesquisaBancoDeDados);
		scrollPesquisaBancoDeDados.setBounds(377, 25, 530, 235);
		con.add(scrollPesquisaBancoDeDados);

		buttonINSERT = new JButton("Insert");
		buttonREMOVE = new JButton("Remove");
		buttonCHANGE = new JButton("Change");
		buttonSEARCH = new JButton("Search");
		
		buttonINSERT.setBounds(60, 330, 90, 40);
		buttonREMOVE.setBounds(152, 375, 90, 40);
		buttonCHANGE.setBounds(60, 375, 90, 40);
		buttonSEARCH.setBounds(152, 330, 90, 40);
		
		con.add(buttonINSERT);
		con.add(buttonREMOVE);
		con.add(buttonCHANGE);
		con.add(buttonSEARCH);
		
		setVisible(true);
		
		buttonINSERT.addActionListener(this);
		buttonREMOVE.addActionListener(this);
		buttonCHANGE.addActionListener(this);
		buttonSEARCH.addActionListener(this);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Insert")) {

			entities.Aluno objAluno = new entities.Aluno(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtCpf.getText(),
					boxTipoSanguineo.getSelectedItem().toString(), boxFatorRH.getSelectedItem().toString(),
					boxCurso.getSelectedItem().toString(), txtContatoEmergencia.getText(), txtTelefoneEmergencia.getText());

			try {
				db.DB base = new db.DB();
				int msg = base.insertData(objAluno);
				JOptionPane.showMessageDialog(this, "Dados inseridos com sucesso!");

			} catch (SQLException el) {
//				el.printStackTrace();
				JOptionPane.showMessageDialog(this, "Erro ao inserir dados!");
			}
		}
		
		if (e.getActionCommand().equals("Remove")) {

			entities.Aluno objAluno = new entities.Aluno(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtCpf.getText(),
					boxTipoSanguineo.getSelectedItem().toString(), boxFatorRH.getSelectedItem().toString(),
					boxCurso.getSelectedItem().toString(), txtContatoEmergencia.getText(), txtTelefoneEmergencia.getText());

			try {
				db.DB base = new db.DB();
				int id = Integer.parseInt(txtId.getText());
				int msg = base.removeData(id);
				JOptionPane.showMessageDialog(this, "Dados removidos com sucesso!");

			} catch (SQLException el) {
				el.printStackTrace();
				JOptionPane.showMessageDialog(this, "Erro ao remover dados!");
			}
		}

		if (e.getActionCommand().equals("Change")) {

			entities.Aluno objAluno = new entities.Aluno(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtCpf.getText(),
					boxTipoSanguineo.getSelectedItem().toString(), boxFatorRH.getSelectedItem().toString(),
					boxCurso.getSelectedItem().toString(), txtContatoEmergencia.getText(), txtTelefoneEmergencia.getText());

			try {
				db.DB base = new db.DB();
				int id = Integer.parseInt(txtId.getText());
				int msg = base.changeData(objAluno, id);
				JOptionPane.showMessageDialog(this, "Dados alterados com sucesso!");

			} catch (SQLException el) {
				JOptionPane.showMessageDialog(this, "Erro ao alterar dados!");
			}
		}

		if (e.getActionCommand().equals("Search")) {

			entities.Aluno objAluno = new entities.Aluno(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtCpf.getText(),
					boxTipoSanguineo.getSelectedItem().toString(), boxFatorRH.getSelectedItem().toString(),
					boxCurso.getSelectedItem().toString(), txtContatoEmergencia.getText(), txtTelefoneEmergencia.getText());

			try {
				db.DB base = new db.DB();
				ArrayList<String> objRelatorio = base.Relatorio();
				listaPesquisaBancoDeDados.setText("");
				for (String txt : objRelatorio) {
					listaPesquisaBancoDeDados.append(txt + "\n\n");
				}
			} catch (SQLException el) {
				el.printStackTrace();
			}
		}

	}
}