public class SalaTelaComputador extends Sala{

  public SalaTelaComputador(){
    super("tela Computador", "imagens/tela1");
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
