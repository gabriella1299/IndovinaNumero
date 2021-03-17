package it.polito.tdp.IndovinaNumero.model;

import java.security.InvalidParameterException;

public class Model {
	
	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;
	
	public void nuovaPartita() {//tira a caso il numero, imposta i tentativi fatti a 0 e var. booleana a true
		//gestione inizio nuova partita
    	this.segreto = (int) (Math.random() * NMAX) +1;
    	this.tentativiFatti = 0;
    	this.inGioco = true;
	}

	public int getSegreto() {
		return segreto;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int tentativo(int tentativo) {
		//controlla se la partita e' in corso
		if(!inGioco) {
			throw new IllegalStateException("Hai perso, il numero era: "+this.segreto);
		}
		
		//controllo dell'input
		if(!tentativoValido(tentativo))
			throw new InvalidParameterException("Devi inserire un numero tra 1 e NMAX");
		
		//il tentativo e' valido
		this.tentativiFatti++;
		if(this.tentativiFatti==TMAX) {
			this.inGioco=false;
		}
		if(tentativo==this.segreto) {
			this.inGioco=false;
			return 0;
		}
		else if(tentativo<this.segreto)
			return -1;
		else return 1;
	}
	
	private boolean tentativoValido(int tentativo) {
		if(tentativo<1||tentativo>NMAX)
			return false;
		else
			return true;
	}
}
