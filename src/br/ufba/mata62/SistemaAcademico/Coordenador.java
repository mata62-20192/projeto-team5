package src.br.ufba.mata62.SistemaAcademico;

public class Coordernador extends Professor{

  public void adicionarAluno(Aluno aluno);
  public void aprovaMatricula(Aluno aluno);
  public void darNota(Aluno aluno, String codigo);
  public void criaTurma(Turma turma);
  public void excluiTurma(String codigo);
  public void iniciaSemestre();
  public void encerraSemestre();
  
}