package br.ufba.mata62.SistemaAcademico.controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.ufba.mata62.SistemaAcademico.domain.Curso;
import br.ufba.mata62.SistemaAcademico.domain.Historico;
import br.ufba.mata62.SistemaAcademico.service.EscritorService;
import java.awt.SystemColor;
import java.awt.Color;

public class CurriculoController extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//CurriculoController frame = new CurriculoController();
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
	public CurriculoController(Curso curso, EscritorService escritor) {
		setBounds(100, 100, 522, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Escrevendo histórico do aluno
		JLabel txtrHtml = new JLabel();
		txtrHtml.setBackground(Color.WHITE);
		txtrHtml.setBounds(1, 1, 488, 281);
		String curriculo = escritor.escreveCurriculo(curso);
		txtrHtml.setText(curriculo);
		contentPane.add(txtrHtml, BorderLayout.CENTER);
		
		//Fazendo barra de rolamento
		JScrollPane scroll = new JScrollPane(txtrHtml, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(5, 5, 490, 306);
		contentPane.add(scroll);
		
		JButton btnGerarHtml = new JButton("Gerar Arquivo");
		btnGerarHtml.setBackground(Color.WHITE);
		btnGerarHtml.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Salva HTML com histórico do aluno
				escritor.salvarCurriculo
				(curso.getNome(), curriculo);
				dispose();
			}
		});
		btnGerarHtml.setBounds(178, 315, 139, 29);
		contentPane.add(btnGerarHtml);
	}

}
