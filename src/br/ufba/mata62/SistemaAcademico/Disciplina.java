package src.br.ufba.mata62.SistemaAcademico;

public class Disciplina{

  private String nome;
  private String codigo;
  private int ch;

  public Disciplina(String nome, String codigo, int ch){
    this.nome = nome;
    this.codigo = codigo;
    this.ch = ch;
  }

  //GETTES E SETTERS

  public void setNome(String nome){
    this.nome = nome;
  }

  public void setCodigo{
    this.codigo = codigo;
  }

  public void setCh{
    this.ch = ch;
  }

  public String getNome(){
    return nome;
  }

  public String getCodigo{
    return codigo;
  }

  public int getCh(){
    return ch;
  }

}