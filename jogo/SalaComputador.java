public class SalaComputador extends Sala{

  public SalaComputador(){
    super("Computador", "imagens/salaComputador");
  }

  @Override
  public boolean usa(String s){
    return false;
  }

  @Override
  public String textoDescricao(){
    return super.getNome();
  }
}
