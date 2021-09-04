package Model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conexion.Conexion;
import StarbuzzApp.Bebida;

public class DataModel {
	private Conexion c=new Conexion();
	java.util.Date today = new java.util.Date();
	java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());
	
	
	
	
	
	public void guardar(Bebida b, int tip, int total) {
		try {
			Timestamp tt=timestamp;
			PreparedStatement pst= c.getConnection().prepareStatement("INSERT INTO pedido (fecha,numero,detalle,precio,tip,total,estado) VALUES(?,?,?,?,?,?,?)");
			
			pst.setInt(2,0);
			pst.setString(3,b.getNombre());
			pst.setInt(4, b.getPrecio());
			pst.setInt(5, tip);
			pst.setInt(6, total);
			pst.setString(7, "Pendiente");

			
			//////////obtener numero de orden//////////////////
			String sql = "SELECT * FROM pedido WHERE fecha = ?";
			PreparedStatement ps=c.getConnection().prepareStatement(sql);

			pst.setString(1, tt.toString().substring(0, 19));
			ps.setString(1, tt.toString().substring(0, 19));
			pst.executeUpdate();
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
					b.setNum(rs.getInt("numero"));
					return;
				}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public DefaultTableModel consultarOrdenes() {
		String[]datos=new String[7];
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int filas, int columnas) {
				if(columnas==7) {
					return true;
				}else {
					return false;
				}
			}
		};
		model.addColumn("Fecha y Hora");
		model.addColumn("Num Orden");
		model.addColumn("Descripcion Bebida");
		model.addColumn("Precio");
		model.addColumn("Tip");
		model.addColumn("Total");
		model.addColumn("Estado");
		
		try {
			Statement st = c.getConnection().createStatement();
			ResultSet rs =st.executeQuery("Select * from pedido");
					while(rs.next()) {
						datos[0]=rs.getString(1).substring(0,19);
						datos[1]=rs.getString(2);
						datos[2]=rs.getString(3);
						datos[3]=rs.getString(4);
						datos[4]=rs.getString(5);
						datos[5]=rs.getString(6);
						datos[6]=rs.getString(7);
						model.addRow(datos);
					}
		}catch(SQLException ex) {
			
		}
		return model;
	}
	
	public void edicion(String numorden, String estado) {
		try {
			Connection con=c.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE pedido SET estado='"+estado+"' WHERE numero='"+numorden+"'");
			ps.executeUpdate();
			JFrame frame = new JFrame();
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JOptionPane.showMessageDialog(frame, "Orden Modificada: "+numorden,
		               "Modificacion con exito", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Ocurrio un problema: ","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void EliminarOrden(String numorden) {
		try {
			Statement st=c.getConnection().createStatement();
			st.executeUpdate("DELETE FROM pedido WHERE numero='"+numorden+"'");
			JFrame frame = new JFrame();
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JOptionPane.showMessageDialog(frame, "Orden "+numorden+" eliminada.",
		               "Eliminacion exitosa", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Ocurrio un problema: ","Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	////////////////////////////////////USUARIOS/////////////////////////////////////////
	public void nuevoUsuario(String user, String pass) {
		try {
			PreparedStatement pst= c.getConnection().prepareStatement("INSERT INTO login (username,password,estado) VALUES(?,?,?)");
			pst.setString(1, user);
			pst.setString(2,pass);
			pst.setBoolean(3, false);
			pst.executeUpdate();
			JFrame frame = new JFrame();
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JOptionPane.showMessageDialog(frame, "Usted ingresó correctamente al usuario: "+user,
		               "Ingreso Exitoso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ya existe ese usuario",
		               "Error de registro", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	public void cambiarContra(String user, String pass) {
		try {
			Connection con=c.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE login SET password='"+pass+"' WHERE username='"+user+"'");
			ps.executeUpdate();
			JFrame frame = new JFrame();
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JOptionPane.showMessageDialog(frame, "Usted cambio correctamente la conraseña al usuario: /n"+user,
		               "Ingreso Exitoso", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un problema: ","Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void eliminaUsuario(String user) {
		try {
			Statement st=c.getConnection().createStatement();
			st.executeUpdate("DELETE FROM login WHERE username='"+user+"'");
			JFrame frame = new JFrame();
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JOptionPane.showMessageDialog(frame, "Usuario eliminado: "+user,
		               "Eliminacion exitosa", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Ocurrio un problema: ","Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void bloquearUsuario(String user) {
		try {
			Connection con=c.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE login SET estado = 1 WHERE username='"+user+"'");
			ps.executeUpdate();
			JFrame frame = new JFrame();
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JOptionPane.showMessageDialog(frame, "Usuario bloqueado: "+user,
		               "Usuario bloqueado con exito", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Ocurrio un problema: ","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void desbloquearUsuario(String user) {
		try {
			Connection con=c.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE login SET estado='"+0+"' WHERE username='"+user+"'");
			ps.executeUpdate();
			JFrame frame = new JFrame();
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JOptionPane.showMessageDialog(frame, "Usuario desbloqueado: "+user,
		               "Usuario desbloqueado con exito", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Ocurrio un problema: ","Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public DefaultTableModel consultarUsuarios() {
		String[]datos=new String[2];
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Usuario");
		model.addColumn("Estado");
		try {
			Statement st = c.getConnection().createStatement();
			ResultSet rs =st.executeQuery("Select * from login");
					while(rs.next()) {
						datos[0]=rs.getString(1);
						if(rs.getString(3).equals("1")){
							datos[1]="Bloqueado";
						}else {
							datos[1]="Habilitado";
						}
						model.addRow(datos);
					}
					
		}catch(SQLException ex) {
			
		}
		return model;
	}
	
	
	
	
}