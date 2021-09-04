package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Controller.DataController;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	DataController dc=new DataController();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ChangePassword(JTable j) {
		setModal(true);
		setTitle("Cambio de contrase\u00F1a usuario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField(j.getValueAt(j.getSelectedRow(),0).toString());
		textField.setEditable(false);
		textField.setBounds(172, 65, 175, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Cambiar Contrase\u00F1a");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(passwordField.getText().equals(passwordField_1.getText())) {
					dc.cambiarContra(textField.getText().toString(), passwordField.getText().toString());
					j.setModel(dc.consultarUsuarios());
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden",
				               "Error de Contraseña", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(141, 194, 138, 23);
		contentPanel.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(172, 127, 175, 20);
		contentPanel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(172, 96, 175, 20);
		contentPanel.add(passwordField_1);
		
		
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 68, 164, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva Contrase\u00F1a");
		lblNuevaContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaContrasea.setBounds(10, 99, 164, 14);
		contentPanel.add(lblNuevaContrasea);
		
		JLabel lblConfirmarNuevaContrasea = new JLabel("Confirmar Nueva Contrase\u00F1a");
		lblConfirmarNuevaContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarNuevaContrasea.setBounds(10, 130, 152, 14);
		contentPanel.add(lblConfirmarNuevaContrasea);
		
		JLabel lblNewLabel_1 = new JLabel("Cambio de contrase\u00F1a usuario");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(75, 22, 272, 14);
		contentPanel.add(lblNewLabel_1);
	}
}
