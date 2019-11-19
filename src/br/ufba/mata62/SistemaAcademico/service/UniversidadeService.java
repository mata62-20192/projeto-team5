package br.ufba.mata62.SistemaAcademico.service;

import java.util.ArrayList;

import java.util.List;

import br.ufba.mata62.SistemaAcademico.domain.Aluno;
import br.ufba.mata62.SistemaAcademico.domain.Coordenador;
import br.ufba.mata62.SistemaAcademico.domain.Curso;
import br.ufba.mata62.SistemaAcademico.domain.Disciplina;
import br.ufba.mata62.SistemaAcademico.domain.Universidade;
import br.ufba.mata62.SistemaAcademico.repository.LeitorTxtRepository;
import enums.Contrato;
import enums.Nivel;

public class UniversidadeService {
	// Pegar uma disciplina pelo código
	public static Disciplina getDisciplina(Universidade universidade, String codigoDisciplina) {
		
		List<Disciplina> disciplinas = universidade.getDisciplinas();
		for (int index = 0; index < universidade.getCursos().size(); index++) {
			if (disciplinas.get(index).equals(codigoDisciplina))
				return disciplinas.get(index);
		}
		return null;
	}

	// Pegar um curso pelo código
	public static Curso getCurso(Universidade universidade, String codigoCurso) {

		List<Curso> cursos = universidade.getCursos();		
		for (int index = 0; index < cursos.size(); index++) {
			if (cursos.get(index).equals(codigoCurso))
				return cursos.get(index);
		}
		return null;
	}
	
	//Retorna um coordenador pela matrícula
	public static Coordenador getCoordenador(Universidade universidade, String matricula) {
		Coordenador coordenador = null;
		for (int index = 0; index < universidade.getCoordenadores().size(); index++) {
			coordenador = universidade.getCoordenadores().get(index);
			if(coordenador.getMatricula().equals(matricula))
				return coordenador;
		}
		
		return null;
	}
	
	//Método que retorna alunos de um curso inscritos na universidade.
	//Utilizado para adicionar coordenadores
	public static List<Aluno> getAlunosCurso(Universidade universidade, Curso curso){
		List<Aluno> alunosCurso = new ArrayList<Aluno>();
		
		List<Aluno> alunosUniversidade = universidade.getAlunos();
		
		for (int index = 0; index < alunosUniversidade.size(); index++) {
			Aluno aux = alunosUniversidade.get(index);
			
			if (aux.getCurso().equals(curso)) {
				Aluno aluno = new Aluno(aux.getNome(), aux.getMatricula(), aux.getSenha(), 
						aux.getRg(), aux.getCpf(), curso);
				alunosCurso.add(aluno);
			}
		}
		return alunosCurso;
	}

//Inicializa a universidade no Main
public static void inicializaUniversidade(Universidade universidade) {
	// Lendo txt da universidade
	LeitorTxtRepository.leitor(universidade);
	
	//Criando coordenadores
	//Coordenador de engenharia de computação
	Curso curso = UniversidadeService.getCurso(universidade, "186140");
	
	Aluno aluno = new Aluno("Helio", "23519", "201045", "rg", "cpf", UniversidadeService.getCurso(universidade, "186140"));
	universidade.adicionaAluno(aluno);
	
	Aluno aluno2 = new Aluno("Fulano", "42354", "Senha", "rg", "cpf",
			UniversidadeService.getCurso(universidade, "186140"));
	universidade.adicionaAluno(aluno2);
	
	//Alunos de engenharia de computação
	List<Aluno> alunos = UniversidadeService.getAlunosCurso(universidade, curso);
	
	Coordenador c1 = new Coordenador("Fulano", "2161", "senha", "rg", 
			"cpf", Contrato.DEFINITIVO, Nivel.DOUTORADO, alunos, curso);
	
	//Coordenador de ciências da computação
	curso = UniversidadeService.getCurso(universidade, "112140");
			
	//Alunos de engenharia de computação
	alunos = UniversidadeService.getAlunosCurso(universidade, curso);
			
	Coordenador c2 = new Coordenador("Sicrano", "4051", "senha", "rg", 
					"cpf", Contrato.DEFINITIVO, Nivel.DOUTORADO, alunos, curso);
	
	universidade.adicionaCoordenador(c1);
	universidade.adicionaCoordenador(c2);
	
	
}

}
