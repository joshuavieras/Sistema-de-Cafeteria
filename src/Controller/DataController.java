package Controller;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.DataModel;
import Model.LoginModel;
import StarbuzzApp.Bebida;
import StarbuzzApp.StarbuzzProgram;
import View.ModifOView;
import View.ConsultView;
import View.GestionUsuariosView;
import View.LoginView;

public class DataController {
	
	
	public void startApplicationView() {
		ConsultView cv = new ConsultView();
		cv.setVisible(true);
		
	}
	
	public void guardar(Bebida b, int tip, int total) throws HeadlessException, FileNotFoundException, IOException {
		DataModel  dm= new DataModel();
		dm.guardar(b, tip,total);
	}
	
	public DefaultTableModel consultar() {
		DataModel dm= new DataModel();
		return dm.consultarOrdenes();
	}
	
	public void edicion(String numorden, String estado) {
		DataModel dm=new DataModel();
		dm.edicion(numorden, estado);
	}
	public void StartApplicationModify(JTable j) {
		ModifOView mof=new ModifOView(j);
		mof.setVisible(true);
	}
	public void EliminarOrden(String numorden) {
		DataModel dm=new DataModel();
		dm.EliminarOrden(numorden);
	}
	
	
	/////////////////////////////USUARIOS////////////////////////////////////////
	public void startApplicationManageUsers() {
		GestionUsuariosView guv=new GestionUsuariosView();
		guv.setVisible(true);
	}
	
	public void nuevoUsuario(String user, String pass) {
		DataModel dm=new DataModel();
		dm.nuevoUsuario(user, pass);
	}
	
	public void eliminaUsuario(String user) {
		DataModel dm=new DataModel();
		dm.eliminaUsuario(user);
	}
	
	public void bloquearUsuario(String user) {
		DataModel dm=new DataModel();
		dm.bloquearUsuario(user);
	}
	
	public void desbloquearUsuario(String user) {
		DataModel dm=new DataModel();
		dm.desbloquearUsuario(user);
	}
	
	
	public DefaultTableModel consultarUsuarios() {
		DataModel dm=new DataModel();
		return dm.consultarUsuarios();
	}
	
	public void cambiarContra(String user, String pass) {
		DataModel dm =new DataModel();
		dm.cambiarContra(user, pass);
	}
	
	
}
