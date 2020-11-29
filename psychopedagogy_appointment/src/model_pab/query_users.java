package model_pab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class query_users extends connection {
	
	public boolean ingresar(users userx) {
		PreparedStatement ps = null;
		ResultSet rs= null;
		Connection con = getConexion();
		
		String query = "SELECT * FROM users WHERE _login=? AND _password=?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, userx.getLogin());
			ps.setString(2, userx.getPassword());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				userx.setIdUser(Integer.parseInt(rs.getString("_idUser")));
				userx.setPrivileges(rs.getString("_privileges"));
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				System.err.println(e);
			}
		}
		
	}
}
