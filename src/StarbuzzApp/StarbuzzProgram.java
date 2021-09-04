package StarbuzzApp;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DataController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import View.ConsultView;
public class StarbuzzProgram extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public String Orden() {
		return "";
	}
	public StarbuzzProgram(){
		setResizable(false);
		setTitle("Sistema de ordenes Starbuzz(PANTALLA PRINCIPAL)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("");
		Image img = new ImageIcon(this.getClass().getResource("/coffee.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 146, 345, 282);
		panel.add(btnNewButton);
		
		JLabel lblNewLabelm = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/starbuzz.png")).getImage();
		lblNewLabelm.setIcon(new ImageIcon(img4));
		lblNewLabelm.setBounds(259, -26, 234, 161);
		panel.add(lblNewLabelm);
		
		JButton salir = new JButton("");
		Image imgsalir = new ImageIcon(this.getClass().getResource("/salir3.png")).getImage();
		salir.setIcon(new ImageIcon(imgsalir));
		salir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		salir.setBounds(0, 0, 95, 81);
		panel.add(salir);
		
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaFrame cf=new ConsultaFrame();
				cf.setVisible(true);
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/consult.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img2));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(365, 146, 345, 282);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Nueva Orden");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 101, 345, 44);
		panel.add(lblNewLabel);
		
		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsulta.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblConsulta.setBounds(365, 101, 345, 44);
		panel.add(lblConsulta);
		
		
		
		JButton btnNewButton_2 = new JButton("Gestión de usuarios");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			DataController dc=new DataController();
			dc.startApplicationManageUsers();
			}
		});
		btnNewButton_2.setBounds(543, 0, 180, 23);
		panel.add(btnNewButton_2);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPedido p=new VentanaPedido();
				p.setVisible(true);
			}
		});
		
		

		
		
		

	}
}
