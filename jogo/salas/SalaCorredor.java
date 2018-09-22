package jogo.salas;

public class SalaCorredor extends Sala{

  public SalaCorredor(){
    super("Corredor", "imagens/corredor");
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
