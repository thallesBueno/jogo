package jogo.personagem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import jogo.ferramentas.*;

    public class Mochila {
    private Map<String,FerramentaFX> coisas;

    public Mochila() {
    	coisas = new HashMap<>();
    }

    public void guardar(FerramentaFX f) {
    	coisas.put(f.getNome(), f);
    }

    public FerramentaFX usar(String descricao) {
    	return coisas.get(descricao);
    }

    public List<String> inventario(){
    	return coisas.keySet().stream().collect(Collectors.toList());
    }
}
