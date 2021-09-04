package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controller.DataController;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionUsuariosView extends JDialog {

	private JPanel contentPane;
	DataController dc=new DataController();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GestionUsuariosView() {
		setTitle("Gestor de Usuarios STARBUZZ");
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTable table_1 = new JTable(dc.consultarUsuarios());
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 634, 268);
		panel.add(scrollPane);
		scrollPane.setViewportView(table_1);
		JButton btnNewButton = new JButton("Agregar usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register r=new Register(table_1);
				r.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 284, 199, 87);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Bloquear usuario");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila=table_1.getSelectedRowCount();
				if(fila<1) {
					JOptionPane.showMessageDialog(null, "Seleccione un usuario");
				}else {
					dc.bloquearUsuario(table_1.getValueAt(table_1.getSelectedRow(),0).toString());
				}
				table_1.setModel(dc.consultarUsuarios());
			}
		});
		btnNewButton_1.setBounds(229, 284, 199, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Eliminar usuario");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila=table_1.getSelectedRowCount();
				if(fila<1) {
					JOptionPane.showMessageDialog(null, "Seleccione una usuario");
				}else {
					dc.eliminaUsuario(table_1.getValueAt(table_1.getSelectedRow(),0).toString());
				}
				table_1.setModel(dc.consultarUsuarios());
			}
		});
		btnNewButton_1_1.setBounds(445, 284, 199, 87);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Desbloquear usuario");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila=table_1.getSelectedRowCount();
				if(fila<1) {
					JOptionPane.showMessageDialog(null, "Seleccione un usuario");
				}else {
					dc.desbloquearUsuario(table_1.getValueAt(table_1.getSelectedRow(),0).toString());
				}
				table_1.setModel(dc.consultarUsuarios());
			}
		});
		btnNewButton_1_2.setBounds(229, 313, 199, 29);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Cambio de Contrase\u00F1a");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int fila=table_1.getSelectedRowCount();
				if(fila<1) {
					JOptionPane.showMessageDialog(null, "Seleccione un usuario");
				}else {
					ChangePassword cp=new ChangePassword(table_1);
					cp.setVisible(true);
				}
				table_1.setModel(dc.consultarUsuarios());
				
			}
		});
		btnNewButton_1_2_1.setBounds(229, 342, 199, 29);
		panel.add(btnNewButton_1_2_1);
		
	}
}
