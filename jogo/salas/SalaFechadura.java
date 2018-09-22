package jogo.salas;

public class SalaFechadura extends Sala{

  public SalaFechadura(){
    super("Fechadura", "imagens/fechadura");
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
