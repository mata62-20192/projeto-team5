package br.ufba.mata62.SistemaAcademico.service;

import java.io.BufferedWriter;
import java.util.Iterator;

import br.ufba.mata62.SistemaAcademico.domain.Aluno;
import br.ufba.mata62.SistemaAcademico.domain.Curso;
import br.ufba.mata62.SistemaAcademico.domain.DisciplinaCursada;
import br.ufba.mata62.SistemaAcademico.domain.DisciplinaSelecionada;
import br.ufba.mata62.SistemaAcademico.domain.Historico;
import br.ufba.mata62.SistemaAcademico.repository.EscreveTxtRepository;

public class EscritorTxtService extends EscritorService {

	@Override
	public void salvarHistorico(String nomeTxt, String historico) {
		EscreveTxtRepository.salvarHistoricoTxt(nomeTxt, historico);
	}
	
	@Override
	public void salvarCurriculo(String nomeTxt, String curriculo) {
		EscreveTxtRepository.salvarCurriculoTxt(nomeTxt, curriculo);
	}
	
	@Override
	public String escreveHistorico(Historico historico) {
		
		StringBuilder string = new StringBuilder();
		
		Aluno aluno = historico.getAluno();
		
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
			return string.toString();
	}


	@Override
	public String escreveCurriculo(Curso curso) {

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

		return string.toString();
	}	

}
