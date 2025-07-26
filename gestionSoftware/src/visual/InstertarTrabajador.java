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
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InstertarTrabajador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtEspecialidad;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDirreccion;
	private JTextField txtEdad;
	private JTextField txtSalario;
	private JTextField txtProyecto;
	private JComboBox <String> cbxPosicion;
	private JComboBox <String> cbxGenero;
	private JComboBox <String> cbxCA;
	private boolean confirmed = false;
	private JButton  btnOK;
	private JButton  btnCancelar;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InstertarTrabajador dialog = new InstertarTrabajador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InstertarTrabajador() {
		setBounds(100, 100, 734, 572);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
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
		
		JComboBox cbxPosicion = new JComboBox();
		cbxPosicion.setBorder(new EmptyBorder(0, 0, 0, 0));
		cbxPosicion.setOpaque(false);
		cbxPosicion.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Jefe de Proyecto","Programador","Planificador"}));
		cbxPosicion.setBounds(83, 109, 138, 22);
		contentPanel.add(cbxPosicion);
		
		JComboBox cbxGenero = new JComboBox();
		cbxGenero.setBorder(new EmptyBorder(0, 0, 0, 0));
		cbxGenero.setOpaque(false);
		cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "M", "F"}));
		cbxGenero.setBounds(422, 53, 106, 22);
		contentPanel.add(cbxGenero);
		
		JComboBox cbxCA = new JComboBox();
		cbxCA.setBorder(new EmptyBorder(0, 0, 0, 0));
		cbxCA.setOpaque(false);
		cbxCA.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Destacado", "Cumplidor", "Incumplidor"}));
		cbxCA.setBounds(489, 300, 138, 22);
		contentPanel.add(cbxCA);
		
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
		txtDirreccion.setBounds(12, 394, 692, 22);
		contentPanel.add(txtDirreccion);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtEdad.setColumns(10);
		txtEdad.setBounds(401, 109, 116, 22);
		contentPanel.add(txtEdad);
		
		txtSalario = new JTextField();
		txtSalario.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtSalario.setColumns(10);
		txtSalario.setBounds(412, 171, 116, 22);
		contentPanel.add(txtSalario);
		
		txtProyecto = new JTextField();
		txtProyecto.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtProyecto.setColumns(10);
		txtProyecto.setBounds(428, 241, 116, 22);
		contentPanel.add(txtProyecto);
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 confirmed = true; 
	                dispose(); 
			}
		});
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
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmed = false;
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Cambria", Font.BOLD, 17));
		btnCancelar.setBounds(583, 487, 121, 25);
		contentPanel.add(btnCancelar);
		setLocationRelativeTo(null);
		
		}

	public String getTxtCedula() {
		return txtCedula.getText();
	}
	public String getPosicion() {
		return (String) cbxPosicion.getSelectedItem(); 
	}
	public String getGenero() {
		return (String) cbxGenero.getSelectedItem();
	}
	public String  getTxtEspecialidad() {
		return txtEspecialidad.getText();
	}

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public String getTxtApellido() {
		return txtApellido.getText();
	}

	public String getTxtDirreccion() {
		return txtDirreccion.getText();
	}

	public String getTxtEdad() {
		return txtEdad.getText();
	}
	
	public String getTxtSalario() {
		return txtSalario.getText();
	}

	public String getTxtProyecto() {
		return txtProyecto.getText();
	}
	public String getCalificacionAnual() {
		return (String) cbxCA.getSelectedItem(); 
		}
	public JButton getBtnOK() {
		return btnOK;
	}

	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	 public boolean isConfirmed() { 
		 return confirmed; }
}
  