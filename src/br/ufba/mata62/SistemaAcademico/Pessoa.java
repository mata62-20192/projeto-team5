package src.br.ufba.mata62.SistemaAcademico;

public class Pessoa{
  
  private String nome;
  private String matricula;
  private String senha;
  private String rg;
  private String cpf;

  public Pessoa(String nome, String matricula, String senha, String rg, String cpf){
    this.nome = nome;
    this.matricula = matricula;
    this.senha = senha;
    this.rg = rg;
    this.cpf = cpf;
  }

  // GETTES E SETTERS

  private void setNome(String nome){
    this.nome = nome;
  }

  public void setMatricula(String matricula){
    this.matricula = matricula;
  }

  public void setSenha(String senha){
    this.senha = senha;
  }

  public void setRg(String rg){
    this.rg = rg;
  }

  public void setCpf(String cpf){
    this.cpf = cpf;
  }
  
  public String getNome(){
    return nome;
  }

  public String getMatricula(){
    return matricula;
  }

  public String getSenha(){
    return senha;
  }

  public String getRg(){
    return rg;
  }

  public String getCpf(){
    return cpf;
  }
  
}