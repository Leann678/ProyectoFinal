package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import logico.Cliente;
import logico.Empresa;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class InsertarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDirreccion;
	private JSpinner spnProyecto;
	private JButton  btnOK;
	private JButton  btnCancelar;
    private RegCliente parentFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertarCliente dialog = new InsertarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 public InsertarCliente() {
	        this(null);
	    }

	/**
	 * Create the dialog.
	 */
	public InsertarCliente(RegCliente parent) {
		 this.parentFrame = parent;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon-32x32.png")));
		setTitle("Insertar Cliente");
		setBounds(100, 100, 734, 572);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 66, 80, 16);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNombre.setBounds(12, 183, 80, 16);
		contentPanel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Cambria", Font.BOLD, 15));
		lblApellido.setBounds(366, 183, 80, 16);
		contentPanel.add(lblApellido);
		
		JLabel lblDirreccion = new JLabel("Dirreccion");
		lblDirreccion.setFont(new Font("Cambria", Font.BOLD, 15));
		lblDirreccion.setBounds(12, 260, 80, 16);
		contentPanel.add(lblDirreccion);

		JLabel lblProyecto = new JLabel("Proyecto");
		lblProyecto.setFont(new Font("Cambria", Font.BOLD, 15));
		lblProyecto.setBounds(366, 66, 80, 16);
		contentPanel.add(lblProyecto);
	
		
		txtCedula = new JTextField();
		txtCedula.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtCedula.setBounds(67, 53, 168, 35);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);
		
		spnProyecto = new JSpinner();
		spnProyecto.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spnProyecto.setBounds(447, 53, 179, 35);
		contentPanel.add(spnProyecto);
		setLocationRelativeTo(null);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtNombre.setColumns(10);
		txtNombre.setBounds(80, 170, 155, 35);
		contentPanel.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtApellido.setColumns(10);
		txtApellido.setBounds(447, 170, 204, 35);
		contentPanel.add(txtApellido);
		
		txtDirreccion = new JTextField();
		txtDirreccion.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtDirreccion.setColumns(10);
		txtDirreccion.setBounds(12, 299, 692, 45);
		contentPanel.add(txtDirreccion);
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.out.println("DEBUG: OK button for Cliente actionPerformed triggered.");
	                if (txtCedula.getText().isEmpty() || txtNombre.getText().isEmpty() ||
	                    txtApellido.getText().isEmpty() || txtDirreccion.getText().isEmpty()) {
	                    System.out.println("DEBUG: Validation failed - fields incomplete.");
	                    return;
	                }
	                try {
	                    System.out.println("DEBUG: Creando objeto Cliente con los datos recolectados.");	          
	                    Cliente newCliente = new Cliente(
	                        txtNombre.getText(), 
	                        txtApellido.getText(), 
	                        txtCedula.getText(), 
	                        txtDirreccion.getText(), 
	                        ((Number)spnProyecto.getValue()).intValue() 	      
	                    );
	                    System.out.println("DEBUG: Cliente creado: " + newCliente.getNombre() + " " + newCliente.getApellido());

	                    System.out.println("DEBUG: Registrando Cliente con Empresa.");
	                    Empresa.getInstance().registrarCliente(newCliente);
	                    System.out.println("DEBUG: Cliente registrado con Empresa.");

	              
	                    if (parentFrame != null) {
	                        System.out.println("DEBUG: El frame padre existe. Intentando añadir el cliente a la tabla.");
	                        parentFrame.agregarCliente(newCliente); 
	                        System.out.println("DEBUG: Cliente añadido a la tabla.");
	                    } else {
	                        System.out.println("DEBUG: El frame padre es NULL. No se puede actualizar la tabla directamente.");
	                    }

	                    JOptionPane.showMessageDialog(InsertarCliente.this, "Cliente registrado con éxito!", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
	                    dispose(); 

	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                    System.err.println("ERROR: Excepción general capturada - " + ex.getMessage());
	                }
	            }

			}
		);
		btnOK.setFont(new Font("Cambria", Font.BOLD, 17));
		btnOK.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnOK.setBounds(472, 487, 97, 25);
		contentPanel.add(btnOK);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancelar.setOpaque(false);
				btnCancelar.setContentAreaFilled(false);
				btnCancelar.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancelar.setOpaque(true);
				btnCancelar.setContentAreaFilled(true);
				btnCancelar.setForeground(SystemColor.black);
			}
		});
		btnCancelar.setFont(new Font("Cambria", Font.BOLD, 17));
		btnCancelar.setBounds(583, 487, 121, 25);
		contentPanel.add(btnCancelar);
		
		
		
		}
	}


