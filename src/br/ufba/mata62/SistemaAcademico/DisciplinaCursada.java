package br.ufba.mata62.SistemaAcademico;

import enums.Conceito;

public class DisciplinaCursada{

  DisciplinaSelecionada disciplinaSelecionada;	
  private Conceito conceito;
  private Float nota;

  public DisciplinaCursada(DisciplinaSelecionada disciplinaSelecionada){
	  this.disciplinaSelecionada = disciplinaSelecionada;
	  this.conceito = Conceito.NAOFEITA;
	  this.nota = (float) -1;
  }
  

  // GETTERS E SETTERS
  public void setConceito(Conceito conceito){
    this.conceito = conceito;
  }

  public void setNota(Float nota){
	    this.nota = nota;
	  }
  
  public DisciplinaSelecionada getDisciplinaSelecionada() {
	return disciplinaSelecionada;
}

  public Conceito getConceito(){
    return conceito;
  }

  public Float getNota(){
    return nota;
  }

}