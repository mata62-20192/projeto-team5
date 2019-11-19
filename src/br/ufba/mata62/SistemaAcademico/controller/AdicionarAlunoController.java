package br.ufba.mata62.SistemaAcademico.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufba.mata62.SistemaAcademico.domain.Aluno;
import br.ufba.mata62.SistemaAcademico.domain.Coordenador;
import br.ufba.mata62.SistemaAcademico.domain.Universidade;
import br.ufba.mata62.SistemaAcademico.service.CoordenadorService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class AdicionarAlunoController extends JFrame {

	private JPanel contentPane;
	private JTextField InputNome;
	private JTextField InputMatricula;
	private JTextField InputSenha;
	private JTextField InputRg;
	private JTextField InputCpf;
	private JLabel lblErro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AdicionarAlunoController frame = new AdicionarAlunoController();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdicionarAlunoController(Universidade universidade, Coordenador coordenador) {
		setBounds(100, 100, 530, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(15, 38, 69, 20);
		contentPane.add(lblNome);
		
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		InputNome = new JTextField();
		InputNome.setBounds(99, 34, 394, 26);
		contentPane.add(InputNome);
		InputNome.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setBounds(15, 80, 69, 20);
		contentPane.add(lblMatricula);
		
		lblMatricula.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		InputMatricula = new JTextField();
		InputMatricula.setColumns(10);
		InputMatricula.setBounds(99, 76, 394, 26);
		contentPane.add(InputMatricula);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(15, 122, 69, 20);
		contentPane.add(lblSenha);
		
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 14));

		
		InputSenha = new JTextField();
		InputSenha.setColumns(10);
		InputSenha.setBounds(99, 118, 394, 26);
		contentPane.add(InputSenha);
		
		JLabel lblRg = new JLabel("Rg:");
		lblRg.setBounds(15, 164, 69, 20);
		contentPane.add(lblRg);
		
		lblRg.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		InputRg = new JTextField();
		InputRg.setColumns(10);
		InputRg.setBounds(99, 160, 394, 26);
		contentPane.add(InputRg);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(15, 206, 69, 20);
		contentPane.add(lblCpf);
		
		lblCpf.setFont(new Font("Times New Roman", Font.BOLD, 14));

		
		InputCpf = new JTextField();
		InputCpf.setColumns(10);
		InputCpf.setBounds(99, 202, 394, 26);
		contentPane.add(InputCpf);
		
		
		lblErro = new JLabel("Todos os campos devem ser preenchidos!");
		lblErro.setBounds(126, 257, 304, 20);
		contentPane.add(lblErro);
		lblErro.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblErro.setForeground(Color.RED);
		lblErro.setVisible(false);
		
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				String nome = InputNome.getText();
				String matricula = InputMatricula.getText();
				String senha = InputSenha.getText();
				String rg = InputRg.getText();
				String cpf = InputCpf.getText();
				
				if(nome.equals("") || matricula.equals("") || senha.equals("") || rg.equals("") || cpf.equals(""))
				lblErro.setVisible(true);
				
				else {
				Aluno aluno = new Aluno(nome, matricula, senha, rg, cpf, coordenador.getCurso());
				//Adicionando Aluno
				universidade.adicionaAluno(aluno);
				
				try {
					CoordenadorService.adicionarAluno(coordenador, aluno);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Aluno já existe");
				}
				
				dispose();	//Fecha frame
				}
			}
		});
		btnAdicionar.setBounds(197, 293, 115, 29);
		contentPane.add(btnAdicionar);
		
		
	}
}
