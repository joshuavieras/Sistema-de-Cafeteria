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
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import View.*;

public class ConsultaFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public ConsultaFrame(){
		setResizable(false);
		setTitle("Consultas Starbuzz");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("");
		Image img = new ImageIcon(this.getClass().getResource("/orden.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 146, 345, 282);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataEditView dev=new DataEditView();
				dev.setVisible(true);
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img2));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(365, 146, 345, 282);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabels = new JLabel("");
		Image imgs = new ImageIcon(this.getClass().getResource("/starbuzz.png")).getImage();
		lblNewLabels.setIcon(new ImageIcon(imgs));
		lblNewLabels.setBounds(262, 0, 201, 122);
		panel.add(lblNewLabels);
		
		JLabel lblNewLabel = new JLabel("Consultar Ordenes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 112, 345, 33);
		panel.add(lblNewLabel);
		
		JLabel lblConsulta = new JLabel("Modificar Ordenes");
		lblConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsulta.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblConsulta.setBounds(365, 111, 345, 34);
		panel.add(lblConsulta);
		
		JButton salir = new JButton("");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Image imgsalir = new ImageIcon(this.getClass().getResource("/salir2.png")).getImage();
		salir.setIcon(new ImageIcon(imgsalir));
		salir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		salir.setBounds(1, 0, 75, 75);
		panel.add(salir);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataController dc=new DataController();
				dc.startApplicationView();
				
			}
		});
		
		

		
		
		

	}
}
