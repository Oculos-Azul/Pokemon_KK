package br.senac.jogopokemon.tipoPokemon;

import br.com.senac.jogoPokemon.Pokemon;

public class TiposSimples implements TipoPokemon {
	
	private String tipo;

    public TiposSimples(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void tipo(Pokemon pokemon) {
        pokemon.setTipo(new TiposSimples(tipo));
    }

    @Override
    public String getTipo() {
        return tipo;
    }

	@Override
	public String toString() {
		return tipo;
	}

}
