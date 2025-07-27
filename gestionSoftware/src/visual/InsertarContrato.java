package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertarContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFechaInicio;
	private JTextField txtFechaEntrega;
	private JTextField txtCedulaCliente;
	private JTextField txtID;
	private JTextField txtProyecto;
	private JTextField txtCantClienProyec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertarContrato dialog = new InsertarContrato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertarContrato() {
		setBounds(100, 100, 687, 444);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fecha de Inicio");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 13, 133, 16);
		contentPanel.add(lblNewLabel);
		
		JLabel lblFechaDeEntrega = new JLabel("Fecha de Entrega");
		lblFechaDeEntrega.setFont(new Font("Cambria", Font.BOLD, 15));
		lblFechaDeEntrega.setBounds(12, 115, 133, 24);
		contentPanel.add(lblFechaDeEntrega);
		
		JLabel lblCantidadDeClientes = new JLabel("Cantidad de Clientes Por Proyecto");
		lblCantidadDeClientes.setFont(new Font("Cambria", Font.BOLD, 15));
		lblCantidadDeClientes.setBounds(339, 221, 253, 16);
		contentPanel.add(lblCantidadDeClientes);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_1.setBounds(339, 13, 56, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cedula Cliente");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_2.setBounds(12, 221, 119, 16);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Proyecto");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_3.setBounds(339, 119, 86, 16);
		contentPanel.add(lblNewLabel_3);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.text);
			buttonPane.setBounds(0, 351, 669, 46);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Cambria", Font.BOLD, 18));
				cancelButton.setBounds(536, 15, 112, 28);
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			JButton btnNewButton = new JButton("OK");
			btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setFont(new Font("Cambria", Font.BOLD, 18));
			btnNewButton.setBounds(415, 15, 112, 28);
			buttonPane.add(btnNewButton);
		}
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setBounds(12, 38, 172, 22);
		contentPanel.add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		txtFechaEntrega = new JTextField();
		txtFechaEntrega.setBounds(12, 152, 172, 22);
		contentPanel.add(txtFechaEntrega);
		txtFechaEntrega.setColumns(10);
		
		txtCedulaCliente = new JTextField();
		txtCedulaCliente.setBounds(12, 247, 172, 22);
		contentPanel.add(txtCedulaCliente);
		txtCedulaCliente.setColumns(10);
		
		txtID = new JTextField();
		txtID.setBounds(339, 38, 172, 22);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		txtProyecto = new JTextField();
		txtProyecto.setBounds(339, 148, 172, 22);
		contentPanel.add(txtProyecto);
		txtProyecto.setColumns(10);
		
		txtCantClienProyec = new JTextField();
		txtCantClienProyec.setBounds(339, 250, 172, 22);
		contentPanel.add(txtCantClienProyec);
		txtCantClienProyec.setColumns(10);
	}
}
