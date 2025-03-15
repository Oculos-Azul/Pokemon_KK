package br.com.senac.jogoPokemon;

import Enum.Evolucao;
 
public class Pokemon {	
	private String nome;
	private String tipo;
	private int vida;
    private int maxVida;
	private int ataque;
	private int defesa;
    private int maxDefesa;
	private int nivel;
	private int xp;
	
    private Evolucao evolucaoAtual;


	public Pokemon(String tipo, int vida,int ataque, int defesa, int xp,  Evolucao evolucaoAtual) {
		this.nome = evolucaoAtual.getNome();	
		this.tipo = tipo;
		this.vida = vida;
		this.maxVida = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.maxDefesa = defesa;
		this.nivel = 1;
		this.xp = 0;
		this.evolucaoAtual = evolucaoAtual;
	}


	public Evolucao getEvolucaoAtual() {
        return evolucaoAtual;
    }
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public int getMaxVida() {
		return maxVida;
	}



	public void setMaxVida(int maxVida) {
		this.maxVida = maxVida;
	}



	public int getMaxDefesa() {
		return maxDefesa;
	}



	public void setMaxDefesa(int maxDefesa) {
		this.maxDefesa = maxDefesa;
	}


	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	
	// Methodo de EVOLUIR
	public void evoluir( ) {
		Evolucao proximaEvolucao = EvolucaoFactory.criarProximaEvolucao(this.evolucaoAtual);
		if(proximaEvolucao != null) {
			this.evolucaoAtual = proximaEvolucao;
			this.setNome(proximaEvolucao.getNome());
            System.out.println(this.nome + " evoluiu para " + this.evolucaoAtual + "!");
		}else {
			System.out.println(this.nome + " ja esta no ultimo estagio da linha evolutiva");
		}
	}
	
	// Methodo de ATACAR
	public void  atacar(Pokemon pokemonAtacado) {
        System.out.println(this.nome + " atacou " + pokemonAtacado.getNome());
        
        
        int ataque = this.getAtaque();
        int defesa = pokemonAtacado.getDefesa();
        
        if(defesa >= ataque) {
        	pokemonAtacado.setDefesa(defesa - ataque);
        }else {
        	pokemonAtacado.setDefesa(0);
            int danoRestante = ataque - defesa; 
    		pokemonAtacado.setVida(pokemonAtacado.getVida() - danoRestante);
    	}
    }
	
//	// toda vez que a classe pokemon e instanciada e chama esse methodo, ele instancia uma outra classe item
//	public void adicionarItem(Item item) {
//		item.aplicar(this);
//	}
//	
	

	
	//ToString
	@Override
	public String toString() {
		return " nome: " + nome + "\n tipo: " + tipo + "\n vida: " + vida + "\n ataque: " + ataque + "\n defesa:"
				+ defesa + "\n nivel: " + nivel + "\n xp: " + xp ;
	}
	
	public String toStringVidaDefesa() {
		return " nome: " + nome + "\n vida: " + vida + "\n defesa:" + defesa;
	}
	
}
