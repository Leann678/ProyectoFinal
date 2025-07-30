package logico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contrato {
	private LocalDate fInicio;
	private LocalDate fEntrega;
	private int cantClientesProyecto;
	private String idContrato;
	private String cedulaCliente;
	private Proyecto nombreProyecto;
	private Cliente cliente;
	
	public Contrato(LocalDate fInicio, LocalDate fEntrega, String idContrato, String cedulaCliente,
			Proyecto nombreProyecto) {
		super();
		this.fInicio = fInicio;
		this.fEntrega = fEntrega;
		this.cantClientesProyecto = cantClientesProyecto;
		this.idContrato = idContrato;
		this.cedulaCliente = cedulaCliente;
		this.nombreProyecto = nombreProyecto;
	}
	public LocalDate getfInicio() {
		return fInicio;
	}
	public void setfInicio(LocalDate fInicio) {
		this.fInicio = fInicio;
	}
	public LocalDate getfEntrega() {
		return fEntrega;
	}
	public void setfEntrega(LocalDate fEntrega) {
		this.fEntrega = fEntrega;
	}
	public int getCantClientesProyecto() {
		return cantClientesProyecto;
	}
	public void setCantClientesProyecto(int cantClientesProyecto) {
		this.cantClientesProyecto = cantClientesProyecto;
	}
	public String getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(String idContrato) {
		this.idContrato = idContrato;
	}
	public String getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public Proyecto getNombreProyecto() {
		return nombreProyecto;
	}
	public void setNombreProyecto(Proyecto nombreProyecto) { 
        this.nombreProyecto = nombreProyecto;
    }
	
	public boolean esEntregaATiempo(LocalDate fechaEntregaReal) {
        return !fechaEntregaReal.isAfter(fEntrega);
    }

    public void prorrogarContrato(LocalDate nuevaFechaEntrega) {
        this.fEntrega = nuevaFechaEntrega;
    }

    public boolean estaActivo(LocalDate fechaActual) {
        return (fechaActual.isEqual(fInicio) || fechaActual.isAfter(fInicio)) && fechaActual.isBefore(fEntrega);
    }

    @Override
    public String toString() {
        return "ID Contrato: " + idContrato + ", Cliente: " + cedulaCliente +
               ", Proyecto: " + nombreProyecto + ", Inicio: " + fInicio +
               ", Entrega: " + fEntrega;
    }

	public void setProyecto(Proyecto nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	
	public Object getProyectoAsociado() {
		return null;
	}
}
