package br.com.senac.jogo.pokemon;

import br.com.senac.jogo.ataque.TipoAtaqueStrategy;
import br.com.senac.jogo.evolucao.Evolucao;
import br.com.senac.jogo.tipo.TipoPokemon;

public class Pokemon {
	private String nome;
	private int vida;
	private int maxVida;
	private int ataque;
	private int defesa;
	private int maxDefesa;
	private int nivel;
	private int xp;

	private TipoPokemon tipo;
	private TipoAtaqueStrategy ataqueStrategy;
	private Evolucao evolucaoAtual;

	public Pokemon(TipoPokemon tipo, int vida, int ataque, int defesa, int xp, TipoAtaqueStrategy ataqueStrategy,
			Evolucao evolucaoAtual) {
		this.nome = evolucaoAtual.getNome();
		this.tipo = tipo;
		this.vida = vida;
		this.maxVida = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.maxDefesa = defesa;
		this.nivel = 1;
		this.xp = 0;

		this.ataqueStrategy = ataqueStrategy;
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

	public TipoPokemon getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoPokemon tipo) {
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

	public void atacar(Pokemon alvo) {
		ataqueStrategy.atacar(this, alvo);
	}

	public void tipoAtaque(TipoAtaqueStrategy ataqueStrategy) {
		this.ataqueStrategy = ataqueStrategy;
	}

	public void evoluir() {
		String nome1 = nome;
		Evolucao proximaEvolucao = this.evolucaoAtual.getProximaEvolucao();
		if (proximaEvolucao != null) {
			this.evolucaoAtual = proximaEvolucao;
			atualizarAtributosParaEvolucao();
			System.out.println(nome1 + " evoluiu para " + this.evolucaoAtual.getNome() + "!");
		} else {
			System.out.println(nome1 + " já está no último estágio de evolução!");
		}
	}

	private void atualizarAtributosParaEvolucao() {
		this.nome = this.evolucaoAtual.getNome();
		this.maxVida += 20; // Aumenta a vida ao evoluir
		this.vida = this.maxVida;
		this.ataque += 10; // Aumenta o ataque ao evoluir
		this.defesa += 5; // Aumenta a defesa ao evoluir
		this.maxDefesa = this.defesa;
		this.nivel += 1; // Sobe de nível ao evoluir
	}

	// ToString
	@Override
	public String toString() {
		return " nome: " + nome + "\n tipo: " + tipo + "\n vida: " + vida + "\n ataque: " + ataque + "\n defesa:"
				+ defesa + "\n nivel: " + nivel + "\n xp: " + xp + "\n";
	}

	public String toStringVidaDefesa() {
		return " nome: " + nome + "\n vida: " + vida + "\n defesa:" + defesa;
	}

}
