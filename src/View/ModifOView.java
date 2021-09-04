package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import Controller.DataController;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ModifOView extends JDialog {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private DataController dc=new DataController();
	private JComboBox comboBox;
	JTable j;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ModifOView(JTable j) {
	    setVisible(true);
		setTitle("Cambiar estado de orden");
		setAutoRequestFocus(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 278, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	      contentPane.setLayout(null);
	      setSize(381, 254);
	      setLocationRelativeTo(null);
	      
	      comboBox = new JComboBox();
	      comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Atrasada", "Procesando", "Entregada"}));
	      comboBox.setBounds(30, 44, 260, 20);
	      contentPane.add(comboBox);
	      
	      btnNewButton = new JButton("Cambiar");
	      btnNewButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		dc.edicion(j.getValueAt(j.getSelectedRow(),1).toString(),comboBox.getSelectedItem().toString());
	      		j.setModel(dc.consultar());
	      		int[] columnsWidth = {
	      				130, 80, 400, 80, 80, 80, 100
	    	        };
	            int i = 0;
	            for (int width : columnsWidth) {
	                TableColumn column =j.getColumnModel().getColumn(i++);
	                column.setMinWidth(width);
	                column.setMaxWidth(width);
	                column.setPreferredWidth(width);
	            }
	      		dispose();
	      	}
	      });
	      btnNewButton.setBounds(20, 153, 326, 42);
	      contentPane.add(btnNewButton);
	      
	      lblNewLabel = new JLabel("Seleccione el nuevo estado de la orden");
	      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	      lblNewLabel.setBounds(20, 11, 326, 32);
	      contentPane.add(lblNewLabel);
	      

	}
}
