package br.ufba.mata62.SistemaAcademico;

public class Universidade{

  private String nome;
  private String sigla;
  private String semestre;

  public Universidade(String nome, String sigla, String semestre){
    this.nome = nome;
    this.sigla = sigla;
    this.semestre = semestre;
  }

  // GETTERS E SETTERS

  public void setNome(String nome){
    this.nome = nome;
  }

  public void setSigla(String sigla){
    this.sigla = sigla;
  }

  public void setSemestre(String semestre){
    this.semestre = semestre;
  }

  public String getNome(){
    return nome;
  }
  
  public String getSigla(){
    return sigla;
  }

  public String getSemestre(){
    return semestre;
  }

}