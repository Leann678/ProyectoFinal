package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cliente;
import logico.Contrato;
import logico.Empresa;
import logico.Proyecto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JComboBox; 
import javax.swing.DefaultComboBoxModel; 
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.awt.event.ActionEvent;

public class InsertarContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFechaInicio;
	private JTextField txtFechaEntrega;
	private JTextField txtCedula;
	private JTextField txtID;
	private JTextField txtProyecto;

	private RegContrato parentFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertarContrato dialog = new InsertarContrato(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertarContrato(RegContrato parent) {
        this.parentFrame = parent;

		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon-32x32.png")));
		setTitle("Insertar Contrato");
		setBounds(100, 100, 687, 444);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		
	
				JLabel lblNewLabel = new JLabel("Fecha de Inicio (YYYY-MM-DD):"); 
				lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
				lblNewLabel.setBounds(12, 13, 250, 16); 
				contentPanel.add(lblNewLabel);

				JLabel lblFechaDeEntrega = new JLabel("Fecha de Entrega (YYYY-MM-DD):"); 
				lblFechaDeEntrega.setFont(new Font("Cambria", Font.BOLD, 15));
				lblFechaDeEntrega.setBounds(12, 119, 250, 24);
				contentPanel.add(lblFechaDeEntrega);

				JLabel lblNewLabel_1 = new JLabel("ID Contrato:"); 
				lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 15));
				lblNewLabel_1.setBounds(327, 123, 150, 16);
				contentPanel.add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("Cedula Cliente:"); 
				lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 15));
				lblNewLabel_2.setBounds(12, 222, 119, 16); 
				contentPanel.add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("Proyecto:");
				lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 15));
				lblNewLabel_3.setBounds(331, 222, 86, 16); 
				contentPanel.add(lblNewLabel_3);

				
				txtFechaInicio = new JTextField(LocalDate.now().toString()); 
				txtFechaInicio.setBounds(12, 60, 172, 32);
				contentPanel.add(txtFechaInicio);
				txtFechaInicio.setColumns(10);

				txtFechaEntrega = new JTextField();
				txtFechaEntrega.setBounds(12, 156, 172, 38); 
				contentPanel.add(txtFechaEntrega);
				txtFechaEntrega.setColumns(10);

				txtCedula = new JTextField();
				txtCedula.setBounds(12, 251, 250, 40);
				contentPanel.add(txtCedula);
				txtCedula.setColumns(10);

				txtID = new JTextField();
				txtID.setBounds(331, 152, 172, 42);
				contentPanel.add(txtID);
				txtID.setColumns(10);

				txtProyecto = new JTextField();
				txtProyecto.setBounds(331, 251, 250, 40); 
				contentPanel.add(txtProyecto);
				txtProyecto.setColumns(10);

			
				JPanel buttonPane = new JPanel();
				buttonPane.setBackground(SystemColor.text);
				
				buttonPane.setBounds(0, 351, 669, 46); 
				contentPanel.add(buttonPane);
				buttonPane.setLayout(null);

				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Cambria", Font.BOLD, 18));
				cancelButton.setBounds(536, 15, 112, 28);
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose(); 
					}
				});
				buttonPane.add(cancelButton);

				JButton btnNewButton = new JButton("OK");
				btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtID.getText().isEmpty() ||
								txtCedula.getText().isEmpty() || txtProyecto.getText().isEmpty() ||
								txtFechaInicio.getText().isEmpty() || txtFechaEntrega.getText().isEmpty()) {
								JOptionPane.showMessageDialog(InsertarContrato.this, "Por favor, complete todos los campos obligatorios.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
								return;
							}

							LocalDate fInicio;
							LocalDate fEntrega;
							try {
								fInicio = LocalDate.parse(txtFechaInicio.getText());
								fEntrega = LocalDate.parse(txtFechaEntrega.getText());
								if (fEntrega.isBefore(fInicio)) {
									JOptionPane.showMessageDialog(InsertarContrato.this, "La Fecha de Entrega no puede ser anterior a la Fecha de Inicio.", "Error de Fecha", JOptionPane.ERROR_MESSAGE);
									return;
								}
							} catch (DateTimeParseException ex) {
								JOptionPane.showMessageDialog(InsertarContrato.this, "Formato de fecha inválido. Use YYYY-MM-DD.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
								return;
							}

							String selectedClienteCedula = txtCedula.getText().trim();
							String selectedProyectoName = txtProyecto.getText().trim();

			  System.out.println("DEBUG: Intentando crear contrato con:");
			 System.out.println("DEBUG ID: " + txtID.getText());
			 System.out.println("DEBUG Fecha Inicio: " + txtFechaInicio.getText());
			 System.out.println("DEBUG: Fecha Entrega: " + txtFechaEntrega.getText());
			 System.out.println("DEBUG: Cedula Cliente (desde JTextField): " + selectedClienteCedula);
			 System.out.println("DEBUG: Nombre del Proyecto (desde JTextField): " + selectedProyectoName);

			 Cliente clienteAsociado = new Cliente(
			"TEMP_Nombre",
			 "TEMP_Apellido",
			 selectedClienteCedula,
			  "TEMP_Direccion",
			  0 // Cantidad de proyectos inicial para este cliente
			 );
			 Proyecto proyectoAsociado = new Proyecto(selectedProyectoName);

									if (clienteAsociado == null || proyectoAsociado == null) {
										JOptionPane.showMessageDialog(InsertarContrato.this, "Error interno al procesar la entrada de cliente o proyecto.", "Error de Procesamiento", JOptionPane.ERROR_MESSAGE);
										return;
									}

									Contrato newContrato = new Contrato(
										fInicio,
										fEntrega,
										txtID.getText(),
										clienteAsociado.getCedulaCliente(),
										proyectoAsociado
									);

									boolean contratoConcedido = Empresa.getInstance().concederContrato(newContrato);

									if (contratoConcedido) {
										JOptionPane.showMessageDialog(InsertarContrato.this, "Contrato registrado con éxito!", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
										if (parentFrame != null) {
											parentFrame.agregarContrato(newContrato);
										}
										dispose();
									} else {
										JOptionPane.showMessageDialog(InsertarContrato.this, "No se pudo registrar el contrato. Posibles razones: ID duplicado, proyecto/cliente saturado.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
									}
					}
				});
				btnNewButton.setFont(new Font("Cambria", Font.BOLD, 18));
				btnNewButton.setBounds(415, 15, 112, 28);
				buttonPane.add(btnNewButton);
			}
		
}
