package br.ufba.mata62.SistemaAcademico.service;

import java.util.List;
import java.util.NoSuchElementException;

import br.ufba.mata62.SistemaAcademico.domain.Aluno;
import br.ufba.mata62.SistemaAcademico.domain.Coordenador;
import br.ufba.mata62.SistemaAcademico.domain.DisciplinaCursada;
import br.ufba.mata62.SistemaAcademico.domain.Universidade;
import enums.Conceito;

public class CoordenadorService {

		public static boolean alunoExiste(Coordenador coordenador, Aluno aluno) {
			List<Aluno> alunos = coordenador.getAlunos();
			
			String matricula = aluno.getMatricula();
			String rg = aluno.getRg();
			String cpf = aluno.getCpf();
			
			
			for(int i = 0; i < alunos.size(); i++) {
				Aluno alunoAux = alunos.get(i);
				if(alunoAux.getMatricula().equals(matricula) || alunoAux.getRg().equals(rg)
						|| alunoAux.getCpf().equals(cpf))
					return true;
			}
			return false;
		}
	
		public static void adicionarAluno(Universidade universidade, Coordenador coordenador, Aluno aluno) throws Exception {
			if(!alunoExiste(coordenador, aluno)) {	//Adiciona o aluno caso não exista nenhum outro com mesmo número de matrícula, rg ou cpf	
			coordenador.adicionarAluno(aluno);
			universidade.adicionaAluno(aluno);
			}
			else
				throw new Exception("Não foi possível adicionar o aluno, matrícula já existe");
		}

		public void aprovaMatricula(Aluno aluno) {

		}

		/*
		 * public void mudaDisciplinaCursada(Aluno aluno, DisciplinaCursada
		 * disciplinaCursada) { universidade.getAlunos(). }
		 */

		// Método para o Coordenador dar conceito a uma matéria de um aluno
		public static void darConceito(Coordenador coordenador, Aluno aluno, String codigoDisciplina, Conceito conceito) throws Exception {

			// Cria DisciplinaCursada e busca na lista do histórico
			DisciplinaCursada disciplinaCursada = HistoricoService.getDisciplinaCursada(aluno.getHistorico(), codigoDisciplina);

			// Faz busca na lista pela posição da disciplina que receberá a nota
			int index = HistoricoService.getDisciplinaCursadaIndex(aluno.getHistorico(), codigoDisciplina);

			if (index == -1) // Disciplina não existe para o aluno
				throw new NoSuchElementException("Disciplina não existe para o aluno");

			// Se o conceito for aprovado ou reprovado por nota, não será possivel dar o
			// conceito sem nota
			if (conceito.equals(Conceito.APROVADO) || conceito.equals(Conceito.REPROVADO_NOTA)) {
				throw new Exception("Não é possível dar o conceito " + conceito + " sem nota");
			}

			else {
				disciplinaCursada.setConceito(conceito);
				disciplinaCursada.setNota((float) -1.0);
				aluno.getHistorico().alteraDisciplinaCursada(index, disciplinaCursada);

			}
		}

		public static void darNota(Coordenador coordenador, Aluno aluno, String codigoDisciplina, float nota) throws Exception {
			//Se o aluno não existe na lista do coordenador, não será possível atribuir nota
			if(!alunoExiste(coordenador, aluno))
				throw new Exception("Aluno não existe ou não pertence a esse curso.");
				
			// Cria DisciplinaCursada e busca na lista do histórico
			DisciplinaCursada disciplinaCursada = HistoricoService.getDisciplinaCursada(aluno.getHistorico(), codigoDisciplina);

			// Faz busca na lista pela posição da disciplina que receberá a nota
			int index = HistoricoService.getDisciplinaCursadaIndex(aluno.getHistorico(), codigoDisciplina);

			if (index == -1) // Disciplina n�o existe para o aluno
				throw new NoSuchElementException("Disciplina não existe para o aluno");

			disciplinaCursada.setNota(nota);

			if (nota >= 5.0)
				disciplinaCursada.setConceito(Conceito.APROVADO);
			else
				disciplinaCursada.setConceito(Conceito.REPROVADO_NOTA);

			// Altera disciplina com nova nota
			aluno.getHistorico().alteraDisciplinaCursada(index, disciplinaCursada);

			// Tendo uma nota nova, calcula-se o score novo do aluno
			AlunoService.calculaScore(aluno);

			// Calcula-se novamente o ch cursado pelo aluno
			HistoricoService.calculaCHCursado(aluno.getHistorico());
			
			//Calcula o semestre do aluno
			AlunoService.calculaSemestre(aluno);
		}
		
}
