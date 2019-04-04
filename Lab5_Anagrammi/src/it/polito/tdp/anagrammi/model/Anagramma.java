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
	
	public void add(Character lettera) {
		this.lettere.add(lettera);
	}
	
	public void remove(Character c) {
		this.lettere.remove(c);	
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
		return anagramma;
	}
	
	@Override
	public Anagramma clone() {
		Anagramma other = new Anagramma(this.parola, this.lettere);
		return other;
	}

	public List<Character> stringToList(String s){
		List<Character> list = new ArrayList<Character>();
		for(int i=0; i<s.length(); i++)
			list.add(s.charAt(i));
		return list;
	}
	
	public boolean contains(Character c) {
		if(count(c, stringToList(parola)) == count(c, lettere)) {
			//System.out.println("La lettera '"+c+"' è presente in numero uguale sia in "+parola+" che in "+lettere.toString());
			return true;
		}
		//System.out.println("Manca almeno una lettera '"+c+"' in "+lettere.toString());
		return false;
	}
	
	public int count(Character c, List<Character> list) {
		int i = 0;
		for(Character ch : list)
			if(ch.equals(c))
				i++;
		return i;
	}
	
	
	
	
}
