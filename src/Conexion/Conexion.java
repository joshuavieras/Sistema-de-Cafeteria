package Conexion;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class Conexion {
	public java.sql.Connection getConnection() throws SQLException {
		java.sql.Connection conexion=null;
		try{
			Properties properties = new Properties();
			properties.setProperty("user", "root");
			properties.setProperty("password", "admin");
			properties.setProperty("useSSL", "false");
			conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/starbuzz",properties);
			System.out.println("Se estableció una conexion con la base de datos exitosamente");			
		}catch(Exception er) {
			System.out.println("Error de conexion");
			er.printStackTrace();
		}
		return conexion;
	}
}
