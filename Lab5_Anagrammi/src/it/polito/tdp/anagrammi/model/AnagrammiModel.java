package it.polito.tdp.anagrammi.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.DizionarioDAO;

public class AnagrammiModel {
	
	DizionarioDAO dao;
	
	public AnagrammiModel() {
		dao = new DizionarioDAO();
	}
	
	public boolean esisteAnagramma(String anagramma) throws SQLException {
		boolean esiste = false;
		try {
			esiste = dao.isCorrect(anagramma);
		}catch(SQLException e) {
			throw new SQLException();
		}
		return esiste;
	}

	public void trovaAnagrammi(String parola, List<String> corretti, List<String> errati){
		CercaAnagrammi cerca = new CercaAnagrammi(parola);
		cerca.trovaAnagrammi();
		List<String> tutti = new ArrayList<String>(cerca.getAnagrammi());
		try {
			for(String s : tutti) {
				if(esisteAnagramma(s) == true) {
					corretti.add(s);
				}
				else
					errati.add(s);
			}
			if(corretti.size() == 0)
				corretti.add("NESSUN ANAGRAMMA CORRETTO TROVATO");
			if(errati.size() == 0)
				errati.add("NESSUN ANAGRAMMA ERRATO TROVATO");
//			System.out.println("Corretti (model): "+corretti);
//			System.out.println("Errati (model): "+errati);
		}catch(SQLException e) {
			corretti.add("Errore nel DB");
			errati.add("Errore nel DB");
			return;
		}
	}
	
}
