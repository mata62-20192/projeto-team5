package br.ufba.mata62.SistemaAcademico;

public class Turma{

  private Disciplina disciplina;
  private String codigo;
  private int capacidade;
  private Calendar horario;

  public Turma(Disciplina disciplina, String codigo, int capacidade, Calendar horario){
    this.disciplina = disciplina;
    this.codigo = codigo;
    this.capacidade = capacidade;
    this.horario = horario;
  }

  public Turma(String nome, String codigo, Disciplina, int ch, String codigoTurma, int capacidade, Calendar horario){
    super(nome, codigoDisciplina, ch);
    this.codigo = codigo;
    this.capacidade = capacidade;
    this.horario = horario;
  }

  // GETTERS E SETTERS

  public void setDisciplina(Disciplina disciplina){
    this.disciplina = disciplina;
  }

  public void setCodigo(String codigo){
    this.codigo = codigo;
  }

  public void setCapacidade(int capacidade){
    this.capacidade = capacidade;
  }

  public void setHorario(Calendar horario){
    this.horario = horario;
  }

  public void getDisciplina(){
    return disciplina;
  }

  public String getCodigo(){
    return codigo;
  }

  public int getCapacidade(){
    return capacidade;
  }

  public Calendar getHorario(){
    return horario;
  }

}