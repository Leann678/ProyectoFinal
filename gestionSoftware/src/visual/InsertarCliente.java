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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InsertarCliente extends JDialog {

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
			InsertarCliente dialog = new InsertarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertarCliente() {
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
	
		
		txtProyecto = new JTextField();
		txtProyecto.setFont(new Font("Cambria", Font.PLAIN, 13));
		txtProyecto.setColumns(10);
		txtProyecto.setBounds(447, 53, 204, 35);
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
		btnCancelar.setFont(new Font("Cambria", Font.BOLD, 17));
		btnCancelar.setBounds(583, 487, 121, 25);
		contentPanel.add(btnCancelar);
		setLocationRelativeTo(null);
		
		}

	}


