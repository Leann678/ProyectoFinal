package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane; 

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import logico.Empresa;
import logico.Proyecto;
import logico.Trabajador;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpinnerNumberModel;

public class InsertarTrabajador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtEspecialidad;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDirreccion;
	private JTextField txtProyecto;
	private JSpinner spnEdad;     
	private JSpinner spnSalario;  
	private JComboBox <String> cbxPosicion; 
	private JComboBox <String> cbxGenero;   
	private JComboBox <String> cbxCA;       
	private JButton btnOK;     
	private JButton btnCancelar; 

	
	private RegTrabajador parentFrame;


	/**
	 * Main method for launching the application independently (for testing).
	 */
	public static void main(String[] args) {
		try {
			// When launching from main, we pass null for the parent frame
			InsertarTrabajador dialog = new InsertarTrabajador(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public InsertarTrabajador() {
		this(null); 
	}

	/**
	 * Parameterized constructor to create the dialog.
	 */
	public InsertarTrabajador(RegTrabajador parent) {
		this.parentFrame = parent; 

		// Basic dialog setup
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon-32x32.png")));
		setBounds(100, 100, 734, 572);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null); 

		
		txtCedula = new JTextField();
		txtCedula.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtCedula.setBounds(67, 53, 116, 22);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);

		txtEspecialidad = new JTextField();
		txtEspecialidad.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtEspecialidad.setColumns(10);
		txtEspecialidad.setBounds(113, 167, 116, 22);
		contentPanel.add(txtEspecialidad);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtNombre.setColumns(10);
		txtNombre.setBounds(83, 241, 116, 22);
		contentPanel.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtApellido.setColumns(10);
		txtApellido.setBounds(83, 300, 116, 22);
		contentPanel.add(txtApellido);

		txtDirreccion = new JTextField();
		txtDirreccion.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtDirreccion.setColumns(10);
		txtDirreccion.setBounds(12, 394, 692, 44);
		contentPanel.add(txtDirreccion);

		txtProyecto = new JTextField();
		txtProyecto.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtProyecto.setColumns(10);
		txtProyecto.setBounds(428, 241, 116, 22);
		contentPanel.add(txtProyecto);

	
		cbxPosicion = new JComboBox<String>();
		cbxPosicion.setBorder(new EmptyBorder(0, 0, 0, 0));
		cbxPosicion.setOpaque(false);
		cbxPosicion.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione", "Jefe de Proyecto","Programador","Planificador"}));
		cbxPosicion.setBounds(83, 109, 138, 22);
		contentPanel.add(cbxPosicion);

		cbxGenero = new JComboBox<String>(); 
		cbxGenero.setBorder(new EmptyBorder(0, 0, 0, 0));
		cbxGenero.setOpaque(false);
		cbxGenero.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione", "M", "F"}));
		cbxGenero.setBounds(422, 53, 106, 22);
		contentPanel.add(cbxGenero);

		cbxCA = new JComboBox<String>();
		cbxCA.setBorder(new EmptyBorder(0, 0, 0, 0));
		cbxCA.setOpaque(false);
		cbxCA.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione", "Destacado", "Cumplidor", "Incumplidor"}));
		cbxCA.setBounds(489, 300, 138, 22);
		contentPanel.add(cbxCA);

		
		spnEdad = new JSpinner(new SpinnerNumberModel(18, 1, 100, 1)); 
		spnEdad.setBounds(422, 109, 106, 22);
		contentPanel.add(spnEdad);

		spnSalario = new JSpinner(new SpinnerNumberModel(0.0f, 0.0f, null, 1.0f)); 
		spnSalario.setBounds(422, 171, 97, 22);
		contentPanel.add(spnSalario);

		
		JLabel lblNewLabel = new JLabel("Cedula");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 55, 80, 16);
		contentPanel.add(lblNewLabel);

		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setFont(new Font("Cambria", Font.BOLD, 15));
		lblPosicion.setBounds(12, 111, 80, 16);
		contentPanel.add(lblPosicion);

		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setFont(new Font("Cambria", Font.BOLD, 15));
		lblEspecialidad.setBounds(12, 173, 100, 16);
		contentPanel.add(lblEspecialidad);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNombre.setBounds(12, 243, 80, 16);
		contentPanel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Cambria", Font.BOLD, 15));
		lblApellido.setBounds(12, 302, 80, 16);
		contentPanel.add(lblApellido);

		JLabel lblDirreccion = new JLabel("Dirreccion");
		lblDirreccion.setFont(new Font("Cambria", Font.BOLD, 15));
		lblDirreccion.setBounds(12, 365, 80, 16);
		contentPanel.add(lblDirreccion);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Cambria", Font.BOLD, 15));
		lblGenero.setBounds(358, 55, 80, 16);
		contentPanel.add(lblGenero);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Cambria", Font.BOLD, 15));
		lblEdad.setBounds(358, 111, 80, 16);
		contentPanel.add(lblEdad);

		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Cambria", Font.BOLD, 15));
		lblSalario.setBounds(358, 173, 80, 16);
		contentPanel.add(lblSalario);

		JLabel lblProyecto = new JLabel("Proyecto");
		lblProyecto.setFont(new Font("Cambria", Font.BOLD, 15));
		lblProyecto.setBounds(358, 243, 80, 16);
		contentPanel.add(lblProyecto);

		JLabel lblCalificacionAnual = new JLabel("Calificacion Anual");
		lblCalificacionAnual.setFont(new Font("Cambria", Font.BOLD, 15));
		lblCalificacionAnual.setBounds(354, 302, 138, 16);
		contentPanel.add(lblCalificacionAnual);

		btnOK = new JButton("OK"); 
		btnOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOK.setOpaque(false);
				btnOK.setContentAreaFilled(false);
				btnOK.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOK.setOpaque(true);
				btnOK.setContentAreaFilled(true);
				btnOK.setForeground(Color.black);
			}
		});
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("DEBUG: OK button actionPerformed triggered."); 
				if (txtCedula.getText().isEmpty() || txtNombre.getText().isEmpty() ||
					txtApellido.getText().isEmpty() || txtDirreccion.getText().isEmpty() ||
					txtProyecto.getText().isEmpty() || cbxGenero.getSelectedIndex() == 0 ||
					cbxPosicion.getSelectedIndex() == 0 || cbxCA.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(InsertarTrabajador.this, "Por favor, complete todos los campos obligatorios.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
					System.out.println("DEBUG: Validation failed - fields incomplete.");
					return; 
				}

				try {
					System.out.println("DEBUG: Validation passed. Attempting to create Proyecto.");
					Proyecto nuevoProyecto = new Proyecto(txtProyecto.getText());
					System.out.println("DEBUG: Proyecto created: " + nuevoProyecto.getNombreProyecto());

					String genero = cbxGenero.getSelectedItem().toString();
					String calificacionAnual = cbxCA.getSelectedItem().toString();
					String posicion = cbxPosicion.getSelectedItem().toString();

					int edad = ((Number)spnEdad.getValue()).intValue(); 
					float salario = ((Number)spnSalario.getValue()).floatValue(); 

					System.out.println("DEBUG: Creating Trabajador object with collected data.");
					logico.Trabajador aux = new logico.Trabajador(
						txtCedula.getText(),
						txtNombre.getText(),
						txtApellido.getText(),
						txtDirreccion.getText(),
						genero,
						edad,
						salario,
						calificacionAnual,
						nuevoProyecto,
                        posicion, 
                        txtEspecialidad.getText() 
					);
					System.out.println("DEBUG: Trabajador created: " + aux.getNombre() + " " + aux.getApellido());
					System.out.println("DEBUG: Registering Trabajador with Empresa.");
					Empresa.getInstance().registrarTrabajador(aux);
					System.out.println("DEBUG: Trabajador registered with Empresa.");

					if (parentFrame != null) {
						System.out.println("DEBUG: Parent frame exists. Attempting to add worker to table.");
						parentFrame.agregarTrabajador(aux);
						System.out.println("DEBUG: Worker added to table.");
					} else {
						System.out.println("DEBUG: Parent frame is NULL. Cannot update table directly.");
					}

					JOptionPane.showMessageDialog(InsertarTrabajador.this, "Trabajador registrado con éxito!", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
					dispose(); 

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(InsertarTrabajador.this, "Edad o Salario deben ser números válidos. Error: " + ex.getMessage(), "Error de Formato", JOptionPane.ERROR_MESSAGE);
					System.err.println("ERROR: NumberFormatException - " + ex.getMessage());
					ex.printStackTrace();
				} catch (Exception ex) { 
					ex.printStackTrace();
					JOptionPane.showMessageDialog(InsertarTrabajador.this, "Ocurrió un error inesperado al registrar el trabajador: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					System.err.println("ERROR: General Exception caught - " + ex.getMessage());
				}
			}
		});
		btnOK.setFont(new Font("Cambria", Font.BOLD, 17));
		btnOK.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnOK.setBounds(472, 487, 97, 25);
		contentPanel.add(btnOK);

		btnCancelar = new JButton("Cancelar"); 
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
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 
			}
		});
		btnCancelar.setFont(new Font("Cambria", Font.BOLD, 17));
		btnCancelar.setBounds(583, 487, 121, 25);
		contentPanel.add(btnCancelar);

	} 
    
	public String getTxtCedula() { return txtCedula.getText(); }
	public String getPosicion() { return (String) cbxPosicion.getSelectedItem(); }
	public String getGenero() { return (String) cbxGenero.getSelectedItem(); }
	public String getTxtEspecialidad() { return txtEspecialidad.getText(); }
	public String getTxtNombre() { return txtNombre.getText(); }
	public String getTxtApellido() { return txtApellido.getText(); }
	public String getTxtDirreccion() { return txtDirreccion.getText(); }
	public String getTxtProyecto() { return txtProyecto.getText(); }
	public String getCalificacionAnual() { return (String) cbxCA.getSelectedItem(); }

	public JButton getBtnOK() { return btnOK; }
	public void setBtnOK(JButton btnOK) { this.btnOK = btnOK; }
	public JButton getBtnCancelar() { return btnCancelar; }
	public void setBtnCancelar(JButton btnCancelar) { this.btnCancelar = btnCancelar; }
}
