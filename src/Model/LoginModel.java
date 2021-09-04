package Model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.crypto.Mac;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Conexion.Conexion;



public class LoginModel {
	private Conexion c=new Conexion();
	public boolean getCredentials(String usuario, String contrasena)throws FileNotFoundException, IOException{
		
		boolean correcto= false;
		try{
			String SQL="select * from login";
			PreparedStatement pst=c.getConnection().prepareStatement(SQL);
			ResultSet rs=pst.executeQuery(SQL);
			while(rs.next()) {
				if(usuario.equals(rs.getString(1))&&contrasena.equals(rs.getString(2))) {
					correcto=true;
					return correcto;
				}
			}
			
		}catch(Exception er) {
			System.out.println("Error de excepcion");
			er.printStackTrace();
		}
		
		return correcto;
	}
	
	public boolean getBlocked(String user, String pass) {
		boolean correcto= false;
		try{
			String SQL="select * from login";
			PreparedStatement pst=c.getConnection().prepareStatement(SQL);
			ResultSet rs=pst.executeQuery(SQL);
			while(rs.next()) {
				if(user.equals(rs.getString(1))&&pass.equals(rs.getString(2))&&rs.getBoolean(3)==false) {
					correcto=true;
					return correcto;
				}
			}
			
		}catch(Exception er) {
			System.out.println("Error de excepcion");
			er.printStackTrace();
		}
		
		return correcto;
		
	}
}
