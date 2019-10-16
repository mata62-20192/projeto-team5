package br.ufba.mata62.SistemaAcademico;

import java.util.ArrayList;

import buscadores.BuscaEmLista;

public class Universidade{

  private String nome;
  private String sigla;
  private String semestre;
  private ArrayList<Aluno> alunos;
  private ArrayList<Professor> professores;
  private Coordernador coordenador;
  private ArrayList<Disciplina> disciplinas;
  private ArrayList<Curso> cursos;

  public Universidade(String nome, String sigla, String semestre, 
		  				ArrayList<Disciplina> disciplinas){
    this.nome = nome;
    this.sigla = sigla;
    this.semestre = semestre;
    this.disciplinas = disciplinas;
    
    alunos = new ArrayList<Aluno>();
    professores = new ArrayList<Professor>();
    cursos = new ArrayList<Curso>();    
  }
  
  //Iniciar universidade com alunos, professores e coordenador
  public Universidade(String nome, String sigla, String semestre, 
						ArrayList<Disciplina> disciplinas, ArrayList<Aluno> alunos,
						ArrayList<Professor> professores, Coordernador coordenador){
	  this.nome = nome;
	  this.sigla = sigla;
	  this.semestre = semestre;
	  this.disciplinas = disciplinas;

	  this.alunos = alunos;
	  this.professores = professores;
	  this.coordenador = coordenador;
}
  
public void iniciaSemestre() {
	  
  };
  
  public void encerraSemestre() {
	  
  };
  
  public void adicionaAluno(Aluno aluno) {
	  alunos.add(aluno);
  }
  
  public void adicionaProfessor(Professor professor) {
	  professores.add(professor);
  }
  
  public void adicionaCurso(Curso curso) {
	  cursos.add(curso);
  }
  
  
  public void adicionaDisciplina(Disciplina disciplina) {
	  disciplinas.add(disciplina);
  }
  
	//Método que muda um professor na lista
	public void setProfessor(Professor professor, int index) {
		this.professores.set(index, professor);
	}
	
	//Método que muda um aluno na lista
	public void setAluno(Aluno aluno, int index) {
		this.alunos.set(index, aluno);
	}

	// GETTERS E SETTERS
  
	//Pegar uma disciplina pelo código
  public Disciplina getDisciplina(String codigoDisciplina) {
	  BuscaEmLista busca = new BuscaEmLista();
	  return busca.getDisciplina(disciplinas, codigoDisciplina);
  }
  
  //Pegar um curso pelo código
  public Curso getCurso(String codigoCurso) {
	  BuscaEmLista busca = new BuscaEmLista();
	  return busca.getCurso(cursos, codigoCurso);
  }
  
  public String getNome(){
    return nome;
  }
  
  public ArrayList<Aluno> getAlunos() {
	return alunos;
}

	public ArrayList<Professor> getProfessores() {
		return professores;
	}
	
	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public ArrayList<Curso> getCursos() {
		return cursos;
	}
	
	public Coordernador getCoordenador() {
		return coordenador;
	}
	
	public void setCoordenador(Coordernador coordenador) {
		this.coordenador = coordenador;
	}

  public String getSigla(){
    return sigla;
  }

  public String getSemestre(){
    return semestre;
  }
  
  
  
}