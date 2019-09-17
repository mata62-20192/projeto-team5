package src.br.ufba.mata62.SistemaAcademico;

public class Curso{

  private String nome;
  private String sigla;
  private int numeroSemestres;
  private int ch;
  //private enum turno;

  public Curso(String nome, String sigla, int numeroSemestres, int ch){
    this.nome = nome;
    this.sigla = sigla;
    this.numeroSemestres = numeroSemestres;
    this.ch = ch;
  }

  // GETTERS E SETTERS

  public void setNome(String nome){
    this.nome = nome;
  }

  public void setSigla(String sigla){
    this.sigla = sigla;
  }

  public void setNumeroSemestres(String numero){
    this.numeroSemestres = numero;
  }

  public void setCh(int ch){
    this.ch = ch;
  }

  // FALTA ENUM TURNO

  public String getNome(){
    return nome;
  }

  public String getSigla(){
    return sigla;
  }

  public int get NumeroSemestres(){
    return numeroSemestres;
  }

  public int getCh(){
    return ch;
  }

  // FALTA ENUM TURNO


}

