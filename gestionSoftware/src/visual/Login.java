package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.omg.PortableInterceptor.SUCCESSFUL;

import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtInsertarUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon-32x32.png")));
		setBounds(100, 100, 730, 532);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 712, 485);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 120, 120));
		panel_1.setBounds(0, 0, 274, 485);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 35));
		lblNewLabel.setBounds(303, 13, 101, 42);
		panel.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblUsuario.setBounds(303, 132, 78, 16);
		panel.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblPassword.setBounds(302, 219, 101, 16);
		panel.add(lblPassword);
		
		txtInsertarUsuario = new JTextField();
		txtInsertarUsuario.setFont(new Font("Cambria", Font.PLAIN, 15));
		txtInsertarUsuario.setBounds(302, 161, 375, 45);
		panel.add(txtInsertarUsuario);
		txtInsertarUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(303, 255, 374, 45);
		panel.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtInsertarUsuario.getText();
				String password = passwordField.getText();
				if(username.equals("admin") && password.equals("1234")){
					JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso","Notificación",JOptionPane.INFORMATION_MESSAGE);
					Principal frame = new Principal();
					frame.setVisible(true);
					dispose();
				}
			}
		});
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setFocusPainted(false);
		btnLogin.setBackground(new Color(51, 255, 204));
		btnLogin.setBorderPainted(false);
		btnLogin.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnLogin.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnLogin.setBounds(576, 414, 101, 42);
		panel.add(btnLogin);
		
		
	
	}
}
