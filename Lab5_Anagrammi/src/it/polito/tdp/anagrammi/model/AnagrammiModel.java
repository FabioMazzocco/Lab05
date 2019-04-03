package it.polito.tdp.anagrammi.model;

import java.sql.SQLException;

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
}
