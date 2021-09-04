package Controller;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Model.LoginModel;
import View.LoginView;
import StarbuzzApp.StarbuzzProgram;
public class LoginController {
	private LoginView v=null;
	int intentos=1;
	boolean correcto=false;
	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public void startApplication() {
		 v = new LoginView();
		v.setVisible(true);
	}
	
	public void getCredentials(String user, String pass) throws HeadlessException, FileNotFoundException, IOException {
		LoginModel model = new LoginModel();
			if(!model.getCredentials(user, pass)&&intentos==3) {
				JFrame frame = new JFrame();
				  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos\nUsted realizó 3 intentos sin exito\n"+"Este programa se cerrará por seguridad",
			               "3 Retries", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			if(model.getCredentials(user, pass)&&model.getBlocked(user, pass)) {
				JFrame frame = new JFrame();
				  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JOptionPane.showMessageDialog(frame, "Usted ingresó correctamente\n"+"Bienvenido "+user,
			               "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);
				correcto=true;
				StarbuzzProgram frame1 = new StarbuzzProgram();
				frame1.setVisible(true);
			}else if(model.getCredentials(user, pass)&&model.getBlocked(user, pass)==false) {
				intentos++;
				JFrame frame = new JFrame();
				  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JOptionPane.showMessageDialog(frame, "Usuario Bloqueado",
			               "Login Error", JOptionPane.ERROR_MESSAGE);
			}else if(!model.getCredentials(user, pass)) {
				JFrame frame = new JFrame();
				  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos",
			               "Login Error", JOptionPane.ERROR_MESSAGE);
				intentos++;
				}
			
				
			
	}
}
