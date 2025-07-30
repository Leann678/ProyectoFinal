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
import logico.Trabajador;
import logico.Empresa;
import logico.Proyecto;

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
        tableModel.addColumn("Cedula");
        tableModel.addColumn("Posicion");
        tableModel.addColumn("Especialidad");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Apellido");
        tableModel.addColumn("Salario");
        tableModel.addColumn("Proyecto");        
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
            	InsertarTrabajador insertTra = new InsertarTrabajador(RegTrabajador.this);
            	insertTra.setLocationRelativeTo(RegTrabajador.this);
                 insertTra.setVisible(true);
                }
        });
    }
    public void agregarTrabajador(Trabajador tab) {
    	System.out.println("DEBUG: agregarTrabajador called for Trabajador: " + tab.getNombre() + " " + tab.getApellido());
        Proyecto assignedProject = tab.getProyectoAsignado();
        String nombreProyecto = "Sin Proyecto"; 
        if (assignedProject != null) {
            nombreProyecto = assignedProject.getNombreProyecto();
            if (nombreProyecto == null || nombreProyecto.trim().isEmpty()) {
                nombreProyecto = "Proyecto sin nombre"; // Handle empty string project name
            }
        }
        System.out.println("DEBUG: Project Name extracted in RegTrabajador: '" + nombreProyecto + "'");
        Object[] rowData = {
            tab.getCedulaTrab(),
            tab.getPosicion(),     
            tab.getEspecialidad(),
            tab.getNombre(),
            tab.getApellido(),
            tab.getSalario(),
            nombreProyecto,
            tab.getCalificacionAnual()
        };
        tableModel.addRow(rowData);
    }
	
}