package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout; 
import javax.swing.JButton;
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

public class RegTrabajador extends JInternalFrame { 

    private JTable table;
    private DefaultTableModel tableModel;

    public RegTrabajador() {
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
        tableModel.addColumn("Posicion");
        //3
        tableModel.addColumn("Especialidad");
        //4
        tableModel.addColumn("Nombre");
        //5
        tableModel.addColumn("Apellido");
    
        tableModel.addColumn("Salario");
        //10
        tableModel.addColumn("Proyecto");
        //11
        tableModel.addColumn("Calificacion Anual");
        
        JScrollPane scrollPane = new JScrollPane(table);
        mainContentPanel.add(scrollPane, BorderLayout.CENTER); 

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
        JButton btnInsertar = new JButton("Insertar Nuevo Trabajador");
        buttonPanel.add(btnInsertar);
        mainContentPanel.add(buttonPanel, BorderLayout.SOUTH); 

        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            InstertarTrabajador insertTra = new InstertarTrabajador();
            insertTra.setLocationRelativeTo(RegTrabajador.this); 
            insertTra.setVisible(true);
                }
        });
    }

	
}