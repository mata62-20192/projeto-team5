package br.ufba.mata62.SistemaAcademico.controller;


import java.awt.EventQueue;

import java.awt.Font;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import br.ufba.mata62.SistemaAcademico.domain.Aluno;
import br.ufba.mata62.SistemaAcademico.domain.Coordenador;
import br.ufba.mata62.SistemaAcademico.domain.Universidade;
import br.ufba.mata62.SistemaAcademico.service.EscalonamentoScoreService;
import br.ufba.mata62.SistemaAcademico.service.EscalonamentoSemestreService;
import br.ufba.mata62.SistemaAcademico.service.EscalonamentoService;
import br.ufba.mata62.SistemaAcademico.service.EscritorHtmlService;
import br.ufba.mata62.SistemaAcademico.service.EscritorTxtService;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;

public class CoordenadorController extends JFrame {

	private JPanel contentPane;
	private List list;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//CoordenadorController frame = new CoordenadorController();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Método que preenche lista de escalonamento, por escalonamento ou score
	private void preencheLista(EscalonamentoService escalonamento, Coordenador coordenador) {
		coordenador.setAlunos(escalonamento.organizaAlunos(coordenador.getAlunos()));
		
		list.removeAll();
		for(int index = 0; index < coordenador.getAlunos().size(); index++) {
			Aluno aluno = coordenador.getAlunos().get(index);
			list.add(aluno.getNome(), index);
		}
	}

	/**
	 * Create the frame.
	 */
	public CoordenadorController(Universidade universidade, Coordenador coordenador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 516);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Bem Vindo, " + coordenador.getNome() + "!");
		lblTitulo.setBounds(176, 57, 372, 20);
		contentPane.add(lblTitulo);
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitulo.setHorizontalAlignment(JTextField.CENTER);
		
		list = new List();
		
		list.setBounds(0, 232, 704, 153);
		contentPane.add(list);
		list.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
	    ButtonGroup grupoBotoes = new ButtonGroup();

		
		JRadioButton rdbtnSemestre = new JRadioButton("Semestre");
		rdbtnSemestre.setBackground(SystemColor.info);
		rdbtnSemestre.setSelected(true);
		
		rdbtnSemestre.setBounds(11, 197, 97, 29);
		contentPane.add(rdbtnSemestre);
		
		JRadioButton rdbtnScore = new JRadioButton("Score");
		rdbtnScore.setBackground(SystemColor.info);
		
		
		rdbtnScore.setBounds(124, 197, 155, 29);
		contentPane.add(rdbtnScore);
		
		grupoBotoes.add(rdbtnSemestre);
		grupoBotoes.add(rdbtnScore);
		
		JButton btnHistorico = new JButton("Visualizar Histórico");
		btnHistorico.setBackground(Color.WHITE);
		btnHistorico.setBounds(162, 429, 190, 29);
		contentPane.add(btnHistorico);
		
		JButton btnCurrculo = new JButton("Visualizar Currículo");
		btnCurrculo.setBackground(Color.WHITE);
		
		btnCurrculo.setBounds(367, 429, 181, 29);
		contentPane.add(btnCurrculo);
		
		JButton btnAdicionar = new JButton("Adicionar Aluno");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setBounds(534, 197, 155, 29);
		contentPane.add(btnAdicionar);
		
		JButton btnDarNota = new JButton("Dar Nota");
		btnDarNota.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDarNota.setBackground(Color.WHITE);
		
		btnDarNota.setBounds(364, 197, 155, 29);
		contentPane.add(btnDarNota);
		
		JLabel lblNewLabel = new JLabel("Escalonamento por ordem de:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(15, 175, 235, 20);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnTxt = new JRadioButton("TXT");
		rdbtnTxt.setBackground(SystemColor.info);
		rdbtnTxt.setSelected(true);
		rdbtnTxt.setBounds(276, 391, 76, 29);
		contentPane.add(rdbtnTxt);
		
		JRadioButton rdbtnHtml = new JRadioButton("HTML");
		rdbtnHtml.setBackground(SystemColor.info);
		rdbtnHtml.setBounds(375, 391, 155, 29);
		contentPane.add(rdbtnHtml);
		
		ButtonGroup grupoBotoes2 = new ButtonGroup();
		grupoBotoes2.add(rdbtnTxt);
		grupoBotoes2.add(rdbtnHtml);
		
		//Preenchendo lista	com escalonamento	
		preencheLista(new EscalonamentoSemestreService(), coordenador);
		
		//Caso o usuário queira ver por semestre, checa o radio button "semestre"
		rdbtnSemestre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(rdbtnSemestre.isEnabled()) {		
					preencheLista(new EscalonamentoSemestreService(), coordenador);
			}
			}
		});	
		
		//Caso o usuário queira ver por score, checa o radio button "score"
		rdbtnScore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preencheLista(new EscalonamentoScoreService(), coordenador);
			}
		});			
		
		//Abrindo tela de adição de aluno
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdicionarAlunoController telaAdicionar = new AdicionarAlunoController(universidade, coordenador);
				telaAdicionar.setVisible(true);
			}
		});
		
		//Quando segura o nome do aluno na lista, o coordenador pode dar uma nota
		btnDarNota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(list.getSelectedIndex() >= 0) { //Se foi selecionado algum aluno, vai para a tela de dar nota
				darNotaController nota = new darNotaController(coordenador, list.getSelectedIndex());
				nota.setVisible(true);
				}
			}
		});
		
		//Mostra histórico se clica no botão "Mostrar histórico"
		btnHistorico.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Analisa se algum aluno foi selecionado na lista
				if(list.getSelectedIndex() >= 0) {
					Aluno aluno = coordenador.getAlunos().get(list.getSelectedIndex());
				if(rdbtnHtml.isSelected()) {
					HistoricoController html = 
							new HistoricoController(aluno.getHistorico(), new EscritorHtmlService());
					html.setVisible(true);
					}
				//Imprimi em txt
				else {
					HistoricoController txt = 
							new HistoricoController(aluno.getHistorico(), new EscritorTxtService());
					txt.setVisible(true);
					}
				}
			}
		
		});
		
		btnCurrculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(list.getSelectedIndex() >= 0) {
					Aluno aluno = coordenador.getAlunos().get(list.getSelectedIndex());
				if(rdbtnHtml.isSelected()) {
					CurriculoController html = 
							new CurriculoController(aluno.getCurso(), new EscritorHtmlService());
					html.setVisible(true);
					}
				//Imprimi em txt
				else {
					CurriculoController txt = 
							new CurriculoController(aluno.getCurso(), new EscritorTxtService());
					txt.setVisible(true);
					}
				}
			}
		});
		
	}
}
