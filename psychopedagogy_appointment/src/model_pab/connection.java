package model_pab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {

	private final String base = "psychopedagogy_appointment_book";
	private final String user = "kralos";
	private final String password = "YHpHOCH4WJpeMc47";
	private final String url = "jdbc:mysql://localhost:3306/" + base;
	private Connection con = null;
	
	public Connection getConexion() {		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(this.url,this.user,this.password); 
			
		} catch(SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} 
		
		return con;
	}
 	
}
