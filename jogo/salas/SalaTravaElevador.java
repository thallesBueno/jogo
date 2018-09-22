package jogo.salas;

public class SalaTravaElevador extends Sala{

  public SalaTravaElevador(){
    super("Trava elevador", "imagens/travaElevador");
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
