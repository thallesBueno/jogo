package jogo.salas;

public class SalaLaboratorio extends Sala{

  public SalaLaboratorio(){
    super("Laboratorio", "imagens/lab");
    }

  @Override
  public boolean usa(String ferramenta){
    return false;
  }

  @Override
  public String textoDescricao(){
    return super.getNome();
  }
}
