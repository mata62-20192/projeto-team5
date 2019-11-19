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

import br.ufba.mata62.SistemaAcademico.domain.Historico;
import br.ufba.mata62.SistemaAcademico.service.EscritorHtmlService;
import br.ufba.mata62.SistemaAcademico.service.EscritorService;
import java.awt.Color;
import java.awt.SystemColor;

public class HistoricoController extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//HistoricoController frame = new HistoricoController();
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
	public HistoricoController(Historico historico, EscritorService escritor) {
		setBounds(100, 100, 522, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Escrevendo histórico do aluno
		JLabel txtrHtml = new JLabel();
		txtrHtml.setBackground(SystemColor.window);
		txtrHtml.setBounds(1, 1, 488, 281);
		String historicoAluno = escritor.escreveHistorico(historico);
		txtrHtml.setText(historicoAluno);
		contentPane.add(txtrHtml, BorderLayout.CENTER);
		
		//Fazendo barra de rolamento
		JScrollPane scroll = new JScrollPane(txtrHtml, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(5, 5, 490, 306);
		scroll.setBackground(Color.WHITE);
		contentPane.add(scroll);
		
		JButton btnGerarHtml = new JButton("Gerar Arquivo");
		btnGerarHtml.setBackground(Color.WHITE);
		btnGerarHtml.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Salva HTML com histórico do aluno
				escritor.salvarCurriculo
				(historico.getAluno().getNome(), historicoAluno);
				dispose();
			}
		});
		btnGerarHtml.setBounds(178, 315, 143, 29);
		contentPane.add(btnGerarHtml);

	}

}
