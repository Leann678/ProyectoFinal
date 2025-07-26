package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout; 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame; 
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.border.CompoundBorder; 


public class RegCliente extends JInternalFrame{

	private final JPanel contentPanel = new JPanel();
    private JTable table;
    private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCliente dialog = new RegCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCliente() {
		setResizable(true);
        setBounds(150, 50, 1300, 400);
        getContentPane().setLayout(new BorderLayout());
        JPanel mainContentPanel = new JPanel(new BorderLayout());
        mainContentPanel.setBorder(new CompoundBorder());
        getContentPane().add(mainContentPanel, BorderLayout.CENTER);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        //1
        tableModel.addColumn("Cedula");
        //2
        tableModel.addColumn("Nombre");
        //3
        tableModel.addColumn("Apellido");
        //4
        tableModel.addColumn("Dirreccion");
       //5
        tableModel.addColumn("Proyecto");
        
        JScrollPane scrollPane = new JScrollPane(table);
        mainContentPanel.add(scrollPane, BorderLayout.CENTER); 

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
        JButton btnInsertar = new JButton("Insertar Nuevo Cliente");
        buttonPanel.add(btnInsertar);
        mainContentPanel.add(buttonPanel, BorderLayout.SOUTH); 
	}

}
