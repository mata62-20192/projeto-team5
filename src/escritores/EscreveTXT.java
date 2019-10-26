package escritores;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import br.ufba.mata62.SistemaAcademico.Aluno;
import br.ufba.mata62.SistemaAcademico.Curso;
import br.ufba.mata62.SistemaAcademico.DisciplinaCursada;
import br.ufba.mata62.SistemaAcademico.DisciplinaSelecionada;
import br.ufba.mata62.SistemaAcademico.Historico;

public class EscreveTXT {
	
	public static void escreveListaAlunos(List<Aluno> alunos) {
		
		for(int index = 0; index < alunos.size(); index++) {
			//Escreve histórico de cada aluno
			escreveHistoricoTXT(alunos.get(index).getHistorico());
			//Escreve Curso
			escreveCursoTXT(alunos.get(index).getCurso(), alunos.get(index).getNome());
		}
		
	}
	
	
	//Escreve o histórico do aluno
	public static void escreveHistoricoTXT(Historico historico) {
		
		BufferedWriter txt = null;
		try {
			Aluno aluno = historico.getAluno();
			
			//Cria arquivo com o nome "Historico_nomeAluno"
			FileWriter writer = new FileWriter("Historico_" + aluno.getNome() + ".txt");

			
			txt = new BufferedWriter(writer);
			
			//Onde o txt ser� escrito
			StringBuilder string = new StringBuilder();
			
			string.append("Aluno: " + aluno.getNome() + "\n");
			string.append("Matrícula: " + aluno.getMatricula() + "\n");			
			string.append("Curso: " + aluno.getCurso().getNome() + "\n");
			string.append("Score: " + aluno.getScore() + "\n");
			string.append("Carga horária cursada: " + historico.getchCursada() + " Horas\n");

			
			string.append("\n\n\n\n\n");
			
			for(int i = 0; i < 8; i++)
			string.append("  ");
			
			string.append("IMPRESSÃO DE HISTÓRICO\n\n");
			
			
			//código, nome, carga horária, natureza, nota e conceito 
			
			//semestreAtual é usado para escrever o semestre no txt
			int semestreAtual = 1;

				string.append("\n\n");
			for(int i = 0; i < 8; i++)
				string.append("  ");
				string.append("Semestre 1\n\n");

			
			for(int index = 0; index < historico.getDisciplinaCursada().size(); index++) {
				
				
				DisciplinaCursada aux = historico.getDisciplinaCursada().get(index);
				
				if(semestreAtual != aux.getSemestre() && aux.getSemestre() != 0) {
					//Se o semestreAtual é diferente do semestre da matéria e ela não
					//é optativa
						string.append("\n\n");
					for(int i = 0; i < 8; i++)
						string.append("  ");
						string.append("Semestre " + aux.getSemestre() + "\n\n");
						semestreAtual = aux.getSemestre();
				}
				
				else if(semestreAtual != aux.getSemestre() && aux.getSemestre() == 0){
					//Ao ler a primeira optativa, escrevemos "Optativas"
						string.append("\n\n");
					for(int i = 0; i < 8; i++)
						string.append("  ");
						string.append("Optativas \n\n");
						semestreAtual = aux.getSemestre();
				}
				
				string.append(aux.getCodigo() + "  ");
				
				//Utiliza para deixar nomes alinhados, todos os nomes de disciplina
				//terão 60 caracteres
				int tam = 60 - aux.getNome().length(); 
				
				if(aux.getNome().length() > 60)
				string.append(aux.getNome().substring(0, 60));
				else
				string.append(aux.getNome());
				
				for(int i = 0; i < tam; i++)
					string.append(" ");
				
				//Utilizado para alinhar ch
				if(aux.getCh() >= 100)
					tam = 0;
				else
					tam = 1;
				
					string.append(aux.getCh() + "   ");
				
				for(int i = 0; i < tam; i++)
				string.append(" ");
					
				if(aux.isObrigatoria())
				string.append("OB" + "  ");
				else
				string.append("OP" + "  ");
				
				if(aux.getNota() == -1)
					//Aluno não tem nota
					string.append("---" + "  ");
				else {
					//Alinhando notas					
					string.append(String.format("%.2f", aux.getNota()) + "  ");					
					
				}
				
				string.append(aux.getConceito() + "  ");
				
				string.append("\n");					
				
			}

			txt.write(string.toString());
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally {
			try {
			txt.close();
			}
			catch(Exception e){
			}
		}
	}
	
	
	
	
	
	
	
	//Imprimindo no txt o currículo do curso dos alunos
	public static void escreveCursoTXT(Curso curso, String nomeAluno) {

		BufferedWriter txt = null;
		try {
			
			//Cria arquivo com o nome "Curso_codigoCurso"
			FileWriter writer = new FileWriter("Curso_" + nomeAluno + ".txt");

			
			txt = new BufferedWriter(writer);
			
			//Onde o txt será escrito
			StringBuilder string = new StringBuilder();
			
			string.append("Curso: " + curso.getNome() + "\n");
			string.append("Código: " + curso.getCodigo() + "\n");			
			string.append("CH: " + curso.getCh() + " Horas" + "\n");
			string.append("Número de semestres: " + curso.getNumeroSemestres() + "\n");
			
			string.append("\n\n\n\n\n");
			
			for(int i = 0; i < 8; i++)
			string.append("  ");
			
			string.append("IMPRESSÃO DE CURRÍCULO\n\n");
						
			int semestreAtual = 1;

				string.append("\n\n");
			for(int i = 0; i < 8; i++)
				string.append("  ");
				string.append("Semestre 1\n\n");

			Iterator<DisciplinaSelecionada> iterator = curso.getDisciplinaSelecionada().iterator();
			
			while(iterator.hasNext()) {
				
				//Atual disciplinaSelecionada
				DisciplinaSelecionada aux = iterator.next();
				
				
				if(semestreAtual != aux.getSemestre() && aux.getSemestre() != 0) {
						string.append("\n\n");
					for(int i = 0; i < 8; i++)
						string.append("  ");
					
						string.append("Semestre " + aux.getSemestre() + "\n\n");
						semestreAtual = aux.getSemestre();
				}
				
				else if(semestreAtual != aux.getSemestre() && aux.getSemestre() == 0){
						string.append("\n\n");
					for(int i = 0; i < 8; i++)
						string.append("  ");
						string.append("Optativas \n\n");
						semestreAtual = aux.getSemestre();
				}
				
				string.append(aux.getCodigo() + "  ");
				
				//Utiliza para deixar nomes alinhados, todos os nomes de disciplina
				//terão no máximo 60 caracteres
				int tam = 60 - aux.getNome().length(); 
				
				if(aux.getNome().length() > 60)
				string.append(aux.getNome().substring(0, 60));
				else
				string.append(aux.getNome());
				
				for(int i = 0; i < tam; i++)
					string.append(" ");
				
				//Utilizado para alinhar ch
				if(aux.getCh() >= 100)
					tam = 0;
				else
					tam = 1;
				
					string.append(aux.getCh() + "   ");
				
				for(int i = 0; i < tam; i++)
				string.append(" ");
				
				if(aux.isObrigatoria())
				string.append("OB" + "  ");
				else
				string.append("OP" + "  ");
				
				string.append("\n");
			}

			txt.write(string.toString());
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally {
			try {
			txt.close();
			}
			catch(Exception e){
			}
		}
	}
}
