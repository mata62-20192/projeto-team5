package br.ufba.mata62.SistemaAcademico.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import br.ufba.mata62.SistemaAcademico.domain.Curso;
import br.ufba.mata62.SistemaAcademico.domain.Disciplina;
import br.ufba.mata62.SistemaAcademico.domain.DisciplinaSelecionada;
import br.ufba.mata62.SistemaAcademico.domain.Universidade;
import br.ufba.mata62.SistemaAcademico.service.UniversidadeService;

public class LeitorTxtRepository {
	public static void leitor(Universidade universidade) {
		Scanner scanner = null;
		try {
			File file = new File("universidade.txt");
			System.out.println(file.getAbsolutePath());
			scanner = new Scanner(file);

			int numCursos = scanner.nextInt();

			String nome, codigo, natureza, curriculo;
			int i, j, semestre, ch, materias;
			boolean obrigatoria;

			int totalSemestres = 0; // Verifica o número total de semestres do curso

			for (i = 0; i < numCursos; i++) {
				// Informações do curso
				scanner.nextLine();

				nome = scanner.nextLine();
				codigo = scanner.nextLine();
				materias = scanner.nextInt();
				
				Curso curso = new Curso(nome, codigo);
				totalSemestres = 0;

				for (j = 0; j < materias; j++) {
					// Informações da matéria
					scanner.nextLine();

					nome = scanner.nextLine();
					codigo = scanner.next();
					semestre = scanner.nextInt();
					natureza = scanner.next();
					ch = scanner.nextInt();
					curriculo = scanner.next();
					
					Disciplina disciplina = UniversidadeService.getDisciplina(universidade, codigo);
					if (disciplina == null) {
						disciplina = new Disciplina(nome, codigo, ch);
						universidade.adicionaDisciplina(disciplina);
					}

					// Vendo se a matéria é obrigatória ou não
					if (natureza.equals("OB"))
						obrigatoria = true;
					else
						obrigatoria = false;

					curso.adicionaDisciplinaSelecionada(
							new DisciplinaSelecionada(disciplina, new ArrayList<Disciplina>(), obrigatoria, semestre));
					if (semestre > totalSemestres)
						totalSemestres = semestre;
				}
				curso.setNumeroSemestres(totalSemestres);
				universidade.adicionaCurso(curso);
			}

			scanner.close();
		}

		catch (Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			try {
				scanner.close();
			} catch (Exception e) {
			}
		}
	}
}
