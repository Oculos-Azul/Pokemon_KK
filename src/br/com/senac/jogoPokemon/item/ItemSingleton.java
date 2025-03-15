package br.com.senac.jogoPokemon.item;

import br.com.senac.jogoPokemon.Pokemon;

public class ItemSingleton {

	private static ItemSingleton instanciaUnica;
	private Item item;
	
    // a instancia do methodo por padrao recebe a cura
	private ItemSingleton() {
		this.item = new Cura();
	}
	
    public static ItemSingleton getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new ItemSingleton();
        }
        return instanciaUnica;
    }
	
    public Item getItem() {
    	return this.item;
    }
    
	public void setItem(Item item) {
		this.item = item;
	}
	
	public void aplicarItem(Pokemon pokemon) {
		if(item != null) {
			item.aplicar(pokemon);
            System.out.println("Item aplicado no Pokémon: " + pokemon.getNome());
        } else {
            System.out.println("Nenhum item foi selecionado.");
		}
	}
	
}
