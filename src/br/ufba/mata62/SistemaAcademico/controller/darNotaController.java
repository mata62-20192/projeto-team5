package br.ufba.mata62.SistemaAcademico.controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufba.mata62.SistemaAcademico.domain.Aluno;
import br.ufba.mata62.SistemaAcademico.domain.Coordenador;
import br.ufba.mata62.SistemaAcademico.service.CoordenadorService;
import br.ufba.mata62.SistemaAcademico.service.CursoService;
import enums.Conceito;

import javax.swing.JLabel;

import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Choice;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class darNotaController extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField InputNota;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//darNotaController frame = new darNotaController();
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
	public darNotaController(Coordenador coordenador, int index) {
		
		Aluno aluno = coordenador.getAlunos().get(index);
		setBounds(100, 100, 536, 330);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: " + aluno.getNome());
		lblNome.setBounds(15, 16, 240, 20);
		contentPane.add(lblNome);
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblMatricula = new JLabel("Matrícula: " + aluno.getMatricula());
		lblMatricula.setBounds(270, 16, 229, 20);
		contentPane.add(lblMatricula);
		lblMatricula.setFont(new Font("Times New Roman", Font.BOLD, 16));

		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setBounds(15, 66, 69, 20);
		contentPane.add(lblNota);
		lblNota.setFont(new Font("Times New Roman", Font.BOLD, 16));

		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setForeground(Color.BLACK);
		separator.setBounds(59, 52, 455, -5);
		contentPane.add(separator);
		
		Choice choice = new Choice();
		choice.setBounds(89, 127, 76, 26);
		contentPane.add(choice);
	
		choice.add("Não");		
		choice.add("Dispensa");
		choice.add("Trancamento");
		
		
		JLabel lblConceito = new JLabel("Conceito:");
		lblConceito.setBounds(15, 127, 69, 20);
		contentPane.add(lblConceito);
		lblConceito.setFont(new Font("Times New Roman", Font.BOLD, 16));
				
		InputNota = new JFormattedTextField();
		InputNota.setBounds(89, 63, 76, 26);
		contentPane.add(InputNota);
		InputNota.setColumns(10);
		
		JButton btnDarNota = new JButton("Dar Nota");
		btnDarNota.setBounds(211, 229, 115, 29);
		contentPane.add(btnDarNota);
		
		JLabel lblCdigoDaDisciplina = new JLabel("Código da Disciplina:");
		lblCdigoDaDisciplina.setBounds(270, 66, 153, 20);
		contentPane.add(lblCdigoDaDisciplina);
		lblCdigoDaDisciplina.setFont(new Font("Times New Roman", Font.BOLD, 16));

		
		JFormattedTextField InputCodigo = new JFormattedTextField();
		InputCodigo.setColumns(10);
		InputCodigo.setBounds(423, 63, 76, 26);
		contentPane.add(InputCodigo);
		
		JLabel lblErro = new JLabel("Escreva um número entre 0 e 10");
		lblErro.setBounds(146, 193, 303, 20);
		contentPane.add(lblErro);
		lblErro.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblErro.setForeground(Color.RED);
		lblErro.setVisible(false);
		
		btnDarNota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String codigoDisciplina = InputCodigo.getText();
				//Verificando se a disciplina existe ou não
				if(!CursoService.existeDisciplinaSelecionada(coordenador.getCurso(), codigoDisciplina)) {
					lblErro.setText("Não existe disciplina com esse código!");
					lblErro.setVisible(true);
				}
				
				else {
				int conceito = choice.getSelectedIndex();
				if(conceito == 1 ) { //Dispensa
					try {
						CoordenadorService.darConceito(coordenador, aluno, codigoDisciplina, Conceito.DISPENSA);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose(); 	//Fecha frame
					}
				
				else if(conceito == 2) { //Trancamento
					try {
						CoordenadorService.darConceito(coordenador, aluno, codigoDisciplina, Conceito.TRANCAMENTO);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose(); 	//Fecha frame
				}
				
				else {
					float nota =  Float.parseFloat(InputNota.getText());
					if(nota < 0 || nota > 10) {
						lblErro.setText("A nota é inválida");
						lblErro.setVisible(true);
					}
					else {
						try {
							CoordenadorService.darNota(coordenador, aluno, codigoDisciplina, nota);
							dispose();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}
				
		});
		
		
	}
}
