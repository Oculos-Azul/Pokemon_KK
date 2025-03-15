package br.com.senac.jogoPokemon;

import Enum.Evolucao;

public class EvolucaoFactory {
		
	 public static Evolucao criarProximaEvolucao(Evolucao evolucaoAtual) {
	        switch (evolucaoAtual) {
	            case CHARMANDER:
	                return Evolucao.CHARMILION;
	            case CHARMILION:
	                return Evolucao.CHARIZARD;
	            case BULBASAURO:
	                return Evolucao.IVYSAURO;
	            case IVYSAURO:
	                return Evolucao.VENOSAURO;
	            default:
	                return null;  
	        }
	    }	
}
