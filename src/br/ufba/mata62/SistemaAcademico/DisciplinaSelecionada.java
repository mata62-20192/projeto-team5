package br.ufba.mata62.SistemaAcademico;

import java.util.ArrayList;

public class DisciplinaSelecionada extends Disciplina{

  private ArrayList<Disciplina> preRequisito;
  private boolean obrigatoria;
  private int semestre;

  public DisciplinaSelecionada(String nome, String codigo, int ch, ArrayList<Disciplina> preRequisito, boolean obrigatoria, int semestre){
    super(nome, codigo, ch);
    this.obrigatoria = obrigatoria;
    this.semestre = semestre;
  }

  // GETTERS E SETTERS

  public void setPreRequisito(ArrayList<Disciplina> preRequisito){
    this.preRequisito = preRequisito;
  }

  public void setObrigatoria(boolean obrigatoria){
    this.obrigatoria = obrigatoria;
  }

  public void setSemestre(int semestre){
    this.semestre = semestre;
  }

  public ArrayList<Disciplina> getPreRequisito(){
    return preRequisito;
  }
}