package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import Controller.DataController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.Image;

import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DataEditView extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table_1;
	DataController dc=new DataController();
	ModifOView mov;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DataEditView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 982, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 43, 954, 279);
		panel.add(scrollPane);
		
		table_1 = new JTable(dc.consultar());
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		int[] columnsWidth = {
				130, 80, 402, 80, 80, 80, 100
	        };
        int i = 0;
        for (int width : columnsWidth) {
            TableColumn column =table_1.getColumnModel().getColumn(i++);
            column.setMinWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
        }
		table_1.setBackground(new Color(60, 179, 113));
		scrollPane.setViewportView(table_1);
		
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JButton btnNewButton = new JButton("Modificar Orden");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int fila=table_1.getSelectedRowCount();
				if(fila<1) {
					JOptionPane.showMessageDialog(null, "Seleccione una orden",
				               "No hay ninguna orden seleccionada", JOptionPane.ERROR_MESSAGE);
				}else {
					mov=new ModifOView(table_1);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(0, 326, 451, 65);
		panel.add(btnNewButton);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila=table_1.getSelectedRowCount();
				if(fila<1) {
					JOptionPane.showMessageDialog(null, "Seleccione una orden",
				               "No hay ninguna orden seleccionada", JOptionPane.ERROR_MESSAGE);
				}else {
					dc.EliminarOrden(table_1.getValueAt(table_1.getSelectedRow(),1).toString());
					table_1.setModel(dc.consultar());
					int[] columnsWidth = {
							130, 80, 402, 80, 80, 80, 100
				        };
			        int i = 0;
			        for (int width : columnsWidth) {
			            TableColumn column =table_1.getColumnModel().getColumn(i++);
			            column.setMinWidth(width);
			            column.setMaxWidth(width);
			            column.setPreferredWidth(width);
			        }
				}
				
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnEliminar.setBounds(503, 326, 451, 65);
		panel.add(btnEliminar);
		
		JButton salir = new JButton("");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Image imgsalir = new ImageIcon(this.getClass().getResource("/salir4.png")).getImage();
		salir.setIcon(new ImageIcon(imgsalir));
		salir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		salir.setBounds(0, 0, 51, 43);
		panel.add(salir);
		JLabel lblNewLabel = new JLabel("Seleccione una orden a modificar o eliminar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(134, 0, 689, 43);
		panel.add(lblNewLabel);
	}
}
