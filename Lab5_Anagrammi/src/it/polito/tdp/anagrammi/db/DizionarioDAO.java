package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DizionarioDAO {
	
	public boolean isCorrect(String anagramma) throws SQLException {
			
		final String sql = "SELECT * FROM parola WHERE nome = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			conn.close();
			
			boolean result = rs.next();
			
			if(result)
				return true;
			return false;
			
			
		}catch(SQLException e) {
			throw new SQLException();
		}
	}
}
