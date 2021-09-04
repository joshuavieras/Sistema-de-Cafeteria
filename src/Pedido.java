import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
public class Pedido extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	JCheckBox chckbxNewCheckBox = new JCheckBox("Topping");
	JCheckBox chckbxMoca = new JCheckBox("Moca");
	JCheckBox chckbxSoja = new JCheckBox("Soja");
	JCheckBox chckbxLecheAlVapor = new JCheckBox("Leche al Vapor");
	String equipamiento ;
	JComboBox comboBox = new JComboBox();
	JButton btnNewButton = new JButton("Facturar");
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JCheckBox chckbxNewCheckBox_1;
	/**
	 * Launch the application.
	 */
	//metodo que retorna true o false si la cadena puede ser convertida a un numero entero o no
	public boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	//codigo de error para ser utilizado cuando se introduce mal un numero
	public void errornum() {
		JFrame frame = new JFrame("Mensaje de error");
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(frame, "No se introdujo una cantidad valida para el tip",
	               "Mensaje de error", JOptionPane.ERROR_MESSAGE);
		
	}
	//metodo para concatenar los extras seleccionados en una misma linea
	public String checkSelec() {
		String extra="";
		if(chckbxNewCheckBox.isSelected()) {
			extra+="-Topping Gratis ";
		}
		if(chckbxMoca.isSelected()) {
			extra+="-Moca ";
		}
		if(chckbxSoja.isSelected()) {
			extra+="-Soja ";
		}
		if(chckbxLecheAlVapor.isSelected()) {
			extra+="-Leche al Vapor ";
		}
		return extra;
	}
	//Método que recibe bebida y la decora segun la opcion seleccionada en el checkbox retorna la bebida decorada
	public Bebida decorar(Bebida b) {
		if(chckbxNewCheckBox.isSelected()) {
			b=new CondimentoTopping(b);
		}
		if(chckbxMoca.isSelected()) {
			b=new CondimentoMoca(b);
		}
		if(chckbxSoja.isSelected()) {
			b=new CondimentoSoja(b);
		}
		if(chckbxLecheAlVapor.isSelected()) {
			b=new CondimentoLeche(b);
		}
		
		return b;
	}
	//Error que tira al no seleccionar una bebida en el pedido
	public void error() {
		JFrame frame = new JFrame("Mensaje de error");
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(frame, "No has seleccionado tu bebida",
	               "Mensaje de error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void MsjOrden(Bebida b,JButton j,JCheckBox jc, JTextField jtx, int preciototal) {
		JFrame frame = new JFrame();
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(frame, "Pedido de: "+b.getNombre()+", completado\n"+"Costo: "+b.getPrecio()+"CRC"+"\nTip agregado: "+jtx.getText()+"CRC"+"\nTotal: "+preciototal+"CRC"+"\n----------Revise su orden----------",
	               "Orden Completada", JOptionPane.INFORMATION_MESSAGE);
		chckbxNewCheckBox.setEnabled(false);;
		chckbxMoca.setEnabled(false);
		chckbxSoja.setEnabled(false);;
		chckbxLecheAlVapor.setEnabled(false);;
		comboBox.setEditable(false);
		j.setEnabled(false);
		comboBox.setEnabled(false);
		jc.setEnabled(false);
		jtx.setEditable(false);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedido frame = new Pedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Metodo para imprimir la bebida con su nombre y precio
	static String ImprimirBebida(Bebida b) {
        return "Bebida: " + b.getNombre()+ ", Precio: " + b.getPrecio(); 
    }
	
	/**
	 * Create the frame.
	 */
	public void LogicaPedido(int tip) {
		if(textField.getText().equals("")||textField.getText().equals("()")) {
			error();
		}else {
			if(comboBox.getSelectedIndex()==1) {
				Bebida ex =new Expresso();
				ex=decorar(ex);
				//UtilidadPedidos.agregar(d,numeropedido,tip);
				textField.setText("Expreso");
				int preciofinal=ex.getPrecio()+tip;
				textField_2.setText(preciofinal+"CRC");
				textField_4.setText(ImprimirBebida(ex));
				MsjOrden(ex,btnNewButton,chckbxNewCheckBox_1,textField_3,preciofinal);
				
			}
			else if(comboBox.getSelectedIndex()==2) {
				Bebida hb=new HouseBlend();
				hb=decorar(hb);
				//UtilidadPedidos.agregar(d,numeropedido,tip);
				textField.setText("House Blend");
				int preciofinal=hb.getPrecio()+tip;
				textField_2.setText(preciofinal+"CRC");
				textField_4.setText(ImprimirBebida(hb));
				MsjOrden(hb,btnNewButton,chckbxNewCheckBox_1,textField_3,preciofinal);
			}else if(comboBox.getSelectedIndex()==3) {
				Bebida d=new Decaf();
				d=decorar(d);
				//UtilidadPedidos.agregar(d,numeropedido,tip);
				textField.setText("Descafeinado");
				int preciofinal=d.getPrecio()+tip;
				textField_2.setText(preciofinal+"CRC");
				textField_4.setText(ImprimirBebida(d));
				MsjOrden(d,btnNewButton,chckbxNewCheckBox_1,textField_3,preciofinal);
				
			}else if(comboBox.getSelectedIndex()==4) {
				Bebida dr=new DarkRoast();
				dr=decorar(dr);
				//UtilidadPedidos.agregar(d,numeropedido,tip);
				textField.setText("Dark Roast");
				int preciofinal=dr.getPrecio()+tip;
				textField_2.setText(preciofinal+"CRC");
				textField_4.setText(ImprimirBebida(dr));
				MsjOrden(dr,btnNewButton,chckbxNewCheckBox_1,textField_3,preciofinal);
			}else {
				error();
			}
		}
	}
	//constructor de pedido
	public Pedido() {
		setTitle("StarBuzz Coffee Order System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		chckbxNewCheckBox_1 = new JCheckBox("Agregar Tip");
		textField_3 = new JTextField();
		
		JLabel lblNewLabel_3_3 = new JLabel("(500CRC)");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_3.setBounds(623, 162, 90, 20);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_2 = new JLabel("(500CRC)");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(623, 128, 90, 20);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("(500CRC)");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(623, 89, 90, 20);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("(GRATIS)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(623, 52, 90, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Extras");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(467, 11, 163, 34);
		panel.add(lblNewLabel);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.setText(comboBox.getSelectedItem()+"");
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(new Color(160, 82, 45));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Expreso (1000CRC)", "House Blend (2500CRC)", "Descafeinado (800CRC)", "Dark Roast (2370CRC)"}));
		comboBox.setBounds(49, 45, 279, 46);
		panel.add(comboBox);
		
		JLabel lblBebida = new JLabel("Bebida");
		lblBebida.setBackground(Color.WHITE);
		lblBebida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBebida.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBebida.setBounds(106, 11, 163, 34);
		panel.add(lblBebida);
		
		
		//listener que genera los objetos y hace las operaciones
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tip=0;
				if(chckbxNewCheckBox_1.isSelected()) {
					if(!isNumeric(textField_3.getText())) {
						errornum();
						textField_3.setText("");
					}else {
						int num1 = Integer.parseInt(textField_3.getText());
						tip=num1;
						LogicaPedido(tip);
						
					}
				}else {
					LogicaPedido(tip);
				}
					
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(10, 348, 214, 68);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(new Color(50, 205, 50));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(106, 213, 342, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		

		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxNewCheckBox.setBounds(453, 45, 171, 34);
		panel.add(chckbxNewCheckBox);
		
		

		chckbxLecheAlVapor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxLecheAlVapor.setBounds(453, 82, 171, 34);
		panel.add(chckbxLecheAlVapor);
		


		chckbxMoca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxMoca.setBounds(453, 121, 171, 34);
		panel.add(chckbxMoca);
		
		chckbxLecheAlVapor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(checkSelec());
			}
		});
		
		chckbxMoca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(checkSelec());
			}
		});
		
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText(checkSelec());
			}
		});
		chckbxSoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(checkSelec());;
			}
		});
		chckbxSoja.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxSoja.setBounds(453, 158, 171, 34);
		panel.add(chckbxSoja);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(50, 205, 50));
		textField_1.setBounds(106, 258, 342, 34);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(50, 205, 50));
		textField_2.setBounds(106, 303, 342, 34);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Bebida");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 219, 121, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Extras");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(0, 258, 121, 34);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Precio");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(0, 303, 121, 34);
		panel.add(lblNewLabel_1_1_1);
		
		JButton btnNuevaOrden = new JButton("Nueva Orden");
		btnNuevaOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText("");
				textField.setText("");
				textField_2.setText("");
				textField_4.setText("");
				comboBox.setSelectedIndex(0);
				chckbxNewCheckBox.setSelected(false);
				chckbxMoca.setSelected(false);
				chckbxSoja.setSelected(false); 
				chckbxLecheAlVapor.setSelected(false);
				chckbxNewCheckBox_1.setSelected(false);
				chckbxNewCheckBox_1.setEnabled(true);
				textField_3.setEditable(false);
				textField_3.setText("");
				chckbxNewCheckBox.setEnabled(true);;
				chckbxMoca.setEnabled(true);
				chckbxSoja.setEnabled(true);;
				chckbxLecheAlVapor.setEnabled(true);;
				comboBox.setEnabled(true);
				btnNewButton.setEnabled(true);
				
				
			}
		});
		btnNuevaOrden.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNuevaOrden.setBounds(255, 348, 214, 68);
		panel.add(btnNuevaOrden);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField.setText("");
				textField_2.setText("");
				comboBox.setSelectedIndex(0);
				chckbxNewCheckBox.setSelected(false);
				chckbxMoca.setSelected(false);
				chckbxSoja.setSelected(false); 
				chckbxLecheAlVapor.setSelected(false);
				chckbxNewCheckBox_1.setSelected(false);
				textField_3.setEditable(false);
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnEliminar.setBounds(499, 348, 214, 68);
		panel.add(btnEliminar);
		
		
		
		
		textField_3.setEditable(false);
		textField_3.setBounds(544, 303, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Monto");
		lblNewLabel_2.setBounds(544, 288, 57, 14);
		panel.add(lblNewLabel_2);
		
		chckbxNewCheckBox_1.setBounds(544, 265, 97, 23);
		panel.add(chckbxNewCheckBox_1);
		
		JLabel label = new JLabel("New label");
		label.setBounds(559, 45, 121, 20);
		panel.add(label);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_4.setEditable(false);
		textField_4.setBounds(30, 182, 418, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CRC");
		lblNewLabel_4.setBounds(634, 306, 46, 14);
		panel.add(lblNewLabel_4);
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxNewCheckBox_1.isSelected()) {
					textField_3.setEditable(true);
				}else {
					textField_3.setEditable(false);
					textField_3.setText("");
				}
			}
		});
		
	}
}
