package br.ufba.mata62.SistemaAcademico.controller;

import java.awt.EventQueue;



import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;

import br.ufba.mata62.SistemaAcademico.domain.Coordenador;
import br.ufba.mata62.SistemaAcademico.domain.Disciplina;
import br.ufba.mata62.SistemaAcademico.domain.Universidade;
import br.ufba.mata62.SistemaAcademico.service.UniversidadeService;


import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;
	
	Universidade universidade = new Universidade("Universidade Federal da Bahia", "UFBA", "20192",
			new ArrayList<Disciplina>());
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Main() {
		//Inicializando a universidade
		//Pegar matrícula e senha dos coordenadores lá
		UniversidadeService.inicializaUniversidade(universidade);;
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBackground(SystemColor.info);
		frame.setEnabled(true);
		frame.setBounds(100, 100, 726, 516);
		
		frame.setBackground(new Color(255, 215, 0));
		
		String tituloStr = "<html>\n" + 
				"	<div style=\"margin-top: 80px;\">Sistema Acadêmico</div>\n" + 
				"</html>";
		frame.getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel(tituloStr);
		titulo.setBounds(0, 0, 704, 140);
		
		frame.getContentPane().add(titulo);
		
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setBounds(137, 184, 105, 39);
		frame.getContentPane().add(lblMatricula);
		lblMatricula.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		textField = new JTextField();
		textField.setBounds(240, 187, 302, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(137, 252, 80, 36);
		frame.getContentPane().add(lblSenha);
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(240, 254, 302, 36);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		
		JLabel lblErro = new JLabel("Matrícula ou senha inválida");
		lblErro.setBounds(240, 403, 302, 36);
		frame.getContentPane().add(lblErro);
		
		lblErro.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblErro.setForeground(Color.RED);
		lblErro.setVisible(false);
		
		//Realiza ação caso o usuário aperte em login
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Coordenador coordenador = UniversidadeService.getCoordenador
						(universidade, textField.getText());
				
				//Caso o coordenador não exista ou a senha esteja errada, exibe mensagem
				//de erro
				if(coordenador == null || !coordenador.getSenha().equals(textField_1.getText()))
					lblErro.setVisible(true);
				
				else {
					//frame.setVisible(false);
					CoordenadorController control = new CoordenadorController(universidade, coordenador);
					control.setVisible(true);
				}
			}
		});
		
		btnLogin.setBounds(310, 343, 115, 29);
		frame.getContentPane().add(btnLogin);
		
		
	}
}
