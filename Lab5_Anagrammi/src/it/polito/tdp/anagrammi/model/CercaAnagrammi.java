package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class CercaAnagrammi {
	
	String iniziale;
	List<String> anagrammi;
	Anagramma parziale;
	
	public CercaAnagrammi(String parola) {
		
		this.iniziale = parola;
		this.anagrammi = new ArrayList<String>();
		this.parziale = new Anagramma(parola);
	}
	
	public void trovaAnagrammi() {
		
		//Condizione di terminazione
		if(parziale.isComplete()) {
			anagrammi.add(parziale.toString());
			System.out.println(anagrammi.size() +". "+parziale.toString());
		}
		
		//Algoritmo ricorsivo
		for(Character c : iniziale.toCharArray()) {
			
			if(!parziale.contains(c)) {
				parziale.add(c);
				trovaAnagrammi();
				parziale.remove(c);
			}
			
		}
		
	}
	
}
