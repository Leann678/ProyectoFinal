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


public class RegContrato extends JInternalFrame {

	private final JPanel contentPanel = new JPanel();
    private JTable table;
    private DefaultTableModel tableModel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegContrato dialog = new RegContrato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegContrato() {
		setResizable(true);
        setBounds(150, 50, 1300, 400);
        getContentPane().setLayout(new BorderLayout());
        JPanel mainContentPanel = new JPanel(new BorderLayout());
        mainContentPanel.setBorder(new CompoundBorder());
        getContentPane().add(mainContentPanel, BorderLayout.CENTER);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        //1
        tableModel.addColumn("Fecha de Inicio");
        //2
        tableModel.addColumn("Fecha de Entrega");
        //3
        tableModel.addColumn("Cantidad de Clientes Por Proyecto");
        //4
        tableModel.addColumn("ID");
        //5
        tableModel.addColumn("Cedula Cliente");
       //6
        tableModel.addColumn("Proyecto");
        
        JScrollPane scrollPane = new JScrollPane(table);
        mainContentPanel.add(scrollPane, BorderLayout.CENTER); 

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
        JButton btnInsertar = new JButton("Insertar Nuevo Contrato");
        btnInsertar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		InsertarContrato insertCont = new InsertarContrato();
        		insertCont.setLocationRelativeTo(RegContrato.this);
        		insertCont.setVisible(true);
        	}
        });
        buttonPanel.add(btnInsertar);
        mainContentPanel.add(buttonPanel, BorderLayout.SOUTH); 	}

}
