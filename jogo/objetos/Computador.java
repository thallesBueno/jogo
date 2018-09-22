package jogo.objetos;

import jogo.ferramentas.*;

public class Computador extends ObjetoFX{

  public Computador(){
    super("Computador", "Computador estragado", "Computador");
  }

  @Override
  public boolean usar(Ferramenta f){
    if(f instanceof Cartao){
      setAcaoOk(true);
      return true;
    }
    return false;
  }
}
