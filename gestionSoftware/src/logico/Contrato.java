package logico;

import java.time.LocalDate;

public class Contrato {
	private LocalDate fInicio;
	private LocalDate fEntrega;
	private int cantClientesProyecto;
	private String idContrato;
	private String cedulaCliente;
	private Proyecto proyecto;
	public Contrato(LocalDate fInicio, LocalDate fEntrega, int cantClientesProyecto, String idContrato, String cedulaCliente,
			Proyecto proyecto) {
		super();
		this.fInicio = fInicio;
		this.fEntrega = fEntrega;
		this.cantClientesProyecto = cantClientesProyecto;
		this.idContrato = idContrato;
		this.cedulaCliente = cedulaCliente;
		this.proyecto = proyecto;
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
	public Proyecto getProyecto() {
		return proyecto;
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
               ", Proyecto: " + proyecto.getNombre() + ", Inicio: " + fInicio +
               ", Entrega: " + fEntrega;
    }

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
}
