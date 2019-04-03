package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class CercaAnagrammi {
	
	String iniziale;
	List<String> anagrammi;
	List<Character> nonUsati;
	
	public CercaAnagrammi(String parola) {
		
		this.iniziale = parola;
		this.anagrammi = new ArrayList<String>();
		this.nonUsati = new ArrayList<Character>();
		
	}
	
	public void trovaAnagrammi(String parola) {
		
		Anagramma parziale = new Anagramma(parola);
		
		if()
	}
	
}
