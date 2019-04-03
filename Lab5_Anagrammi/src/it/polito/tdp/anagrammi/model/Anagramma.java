package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Anagramma {
	
	private List<Character> lettere;
	private int lunghezza;
	private String parola;
	
	public Anagramma(String parola) {
		this.parola = parola;
		this.lettere = new ArrayList<Character>();
		this.lunghezza = parola.length();
	}
	
public Anagramma(String parola, List<Character> lettere) {
		
		this.lettere = new ArrayList<Character>(lettere);
		this.lunghezza = parola.length();
	}
	
	public void add(char lettera) {
		this.lettere.add(lettera);
	}
	
	public boolean isComplete() {
		if(lettere.size() == this.lunghezza)
			return true;
		return false;
	}

	public List<Character> getLettere() {
		return this.lettere;
	}
	

	@Override
	public String toString() {
		String anagramma = "";
		for(Character c : lettere)
			anagramma += c;
		anagramma += "\n";
		return anagramma;
	}
	
	@Override
	public Anagramma clone() {
		Anagramma other = new Anagramma(this.parola, this.lettere);
		return other;
	}
	
	
}
