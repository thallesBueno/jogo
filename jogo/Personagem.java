public class Personagem extends Mochila{

    private String nome;
    private int vida;

    public Personagem(String nome){
      super();
      this.vida = 100;
      this.nome = nome;
    }

    public String getNome(){
      return nome;
    }

    public int getVida(){
      return vida;
    }
}
