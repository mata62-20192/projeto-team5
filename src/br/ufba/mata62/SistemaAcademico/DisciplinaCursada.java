package br.ufba.mata62.SistemaAcademico;

import enums.Conceito;

public class DisciplinaCursada {

	DisciplinaSelecionada disciplinaSelecionada;
	private Conceito conceito;
	private float nota;

	public DisciplinaCursada(DisciplinaSelecionada disciplinaSelecionada) {
		this.disciplinaSelecionada = disciplinaSelecionada;
		this.conceito = Conceito.NAOFEITA;
		this.nota = (float) -1;
	}

	public boolean equals(String codigo) {
		if (disciplinaSelecionada.equals(codigo))
			return true;

		return false;
	}

	// GETTERS E SETTERS
	public void setConceito(Conceito conceito) {
		this.conceito = conceito;
	}

	public void setNota(Float nota) {
		this.nota = nota;

		// truncando em duas casas decimais
		this.nota *= 100;
		int aux = (int) this.nota;
		this.nota = aux;
		this.nota /= 100;

	}

	public DisciplinaSelecionada getDisciplinaSelecionada() {
		return disciplinaSelecionada;
	}

	public Conceito getConceito() {
		return conceito;
	}

	public Float getNota() {
		return nota;
	}

	public Disciplina getDisciplina() {
		return disciplinaSelecionada.getDisciplina();
	}

	public boolean isObrigatoria() {
		return disciplinaSelecionada.isObrigatoria();
	}

	public int getSemestre() {
		return disciplinaSelecionada.getSemestre();
	}

	public String getNome() {
		return disciplinaSelecionada.getNome();
	}

	public String getCodigo() {
		return disciplinaSelecionada.getCodigo();
	}

	public int getCh() {
		return disciplinaSelecionada.getCh();
	}

}