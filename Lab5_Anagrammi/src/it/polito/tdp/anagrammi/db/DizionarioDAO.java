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
			
			boolean result;
			
			if(rs.next())
				result = true;
			else
				result = false;
			//System.out.println("La parola "+anagramma+" è "+result);
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		}
	}
}
