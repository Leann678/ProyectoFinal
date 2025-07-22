package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.border.CompoundBorder;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Vortex Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 724);
		dim = getToolkit().getScreenSize();
		setSize(dim.width,dim.height);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//panel para el menu
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBorder(null);
		panel.setPreferredSize(new Dimension(300, 600));
		contentPane.add(panel, BorderLayout.WEST);
		
		//fotico
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -19, 300, 175);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yovat\\Downloads\\download.jpg"));
		String imagePath = "C:\\Users\\yovat\\Downloads\\download.jpg"; 
		ImageIcon originalIcon = new ImageIcon(imagePath);
		Image originalImage = originalIcon.getImage();
		int newWidth = 300;  
		int newHeight = 150;
		Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		panel.setLayout(null);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		lblNewLabel.setIcon(scaledIcon);
		
		//boton
		JButton btnNewButton = new JButton("Inicio");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setOpaque(false);
	            btnNewButton.setContentAreaFilled(false);
				btnNewButton.setForeground(Color.blue);
			}
			 @Override
	            public void mouseExited(MouseEvent e) {
				 btnNewButton.setOpaque(true);
	             btnNewButton.setContentAreaFilled(true);
	             btnNewButton.setForeground(SystemColor.desktop); 
	           }
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnNewButton.setOpaque(true);           
		btnNewButton.setContentAreaFilled(true); 
		btnNewButton.setBorderPainted(false);   
		btnNewButton.setFocusPainted(false);  
		btnNewButton.setForeground(SystemColor.desktop); 
		btnNewButton.setBounds(5, 175, 290, 35); 
		
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setOpaque(false);
				btnNewButton_1.setContentAreaFilled(false);
	            btnNewButton_1.setForeground(Color.blue);
			}
			 @Override
	            public void mouseExited(MouseEvent e) {
				 btnNewButton_1.setOpaque(true);
				 btnNewButton_1.setContentAreaFilled(true);
	             btnNewButton_1.setForeground(SystemColor.desktop); 
	           }
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnNewButton_1.setOpaque(true);           
		btnNewButton_1.setContentAreaFilled(true); 
		btnNewButton_1.setBorderPainted(false);   
		btnNewButton_1.setFocusPainted(false);  
		btnNewButton_1.setForeground(SystemColor.desktop);
		btnNewButton_1.setBounds(5, 252, 290, 35);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setOpaque(false);
				btnNewButton_2.setContentAreaFilled(false);
	            btnNewButton_2.setForeground(Color.blue);
			}
			 @Override
	            public void mouseExited(MouseEvent e) {
				 btnNewButton_2.setOpaque(true);
				 btnNewButton_2.setContentAreaFilled(true);
	             btnNewButton_2.setForeground(SystemColor.desktop); 
	           }
		});
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnNewButton_2.setOpaque(true);           
		btnNewButton_2.setContentAreaFilled(true); 
		btnNewButton_2.setBorderPainted(false);   
		btnNewButton_2.setFocusPainted(false);  
		btnNewButton_2.setForeground(SystemColor.desktop);
		btnNewButton_2.setBounds(5, 325, 290, 35);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_3.setOpaque(false);
				btnNewButton_3.setContentAreaFilled(false);
	            btnNewButton_3.setForeground(Color.blue);
			}
			 @Override
	            public void mouseExited(MouseEvent e) {
				 btnNewButton_3.setOpaque(true);
				 btnNewButton_3.setContentAreaFilled(true);
	             btnNewButton_3.setForeground(SystemColor.desktop); 
	           }
		});
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnNewButton_3.setOpaque(true);           
		btnNewButton_3.setContentAreaFilled(true); 
		btnNewButton_3.setBorderPainted(false);   
		btnNewButton_3.setFocusPainted(false);  
		btnNewButton_3.setForeground(SystemColor.desktop);
		btnNewButton_3.setBounds(5, 391, 290, 35);
		panel.add(btnNewButton_3);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		
		
		dim = getToolkit().getScreenSize();
		
		setSize(852,631);
		setLocationRelativeTo(null);
		
		
	}
}
