package br.senac.jogopokemon.tipoPokemon;

import java.util.ArrayList;

import br.com.senac.jogoPokemon.Pokemon;

public class TipoGramaComposite implements TipoPokemon{
	
    private String tipo; 
	private ArrayList<TipoPokemon> subTipos = new ArrayList<TipoPokemon>();
	
			
    public TipoGramaComposite(String tipoPokemon) {
        this.tipo = tipoPokemon;
    }
			
    //Adiciona um subtipo ao arrayList	
	public void adicionaSubtipo(TipoPokemon subtipo) {
		subTipos.add(subtipo);
	}
	
	
    // Adiciona um subtipo ao pokemon
	@Override
	public void tipo(Pokemon pokemon) {
		String tipos = subTipos.stream().map(TipoPokemon::getTipo)
										.reduce((a ,b) -> a + " / " +  b)
										.orElse(null);
		
	}
	
    @Override
    public String getTipo() {
        return tipo;
    }

	@Override
	public String toString() {
		return tipo + subTipos;
	}

    
 
}
