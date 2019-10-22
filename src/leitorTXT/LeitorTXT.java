package leitorTXT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import br.ufba.mata62.SistemaAcademico.Curso;
import br.ufba.mata62.SistemaAcademico.Disciplina;
import br.ufba.mata62.SistemaAcademico.DisciplinaSelecionada;
import br.ufba.mata62.SistemaAcademico.Universidade;

public class LeitorTXT {

	public static void leitor(Universidade universidade) {
		Scanner scanner = null;
		try {
			File file = new File("universidade.txt");
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

					Disciplina disciplina = universidade.getDisciplina(codigo);
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
