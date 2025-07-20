package logico;

import java.util.Date;

public class Contrato {
	private Date fInicio;
	private Date fEntrega;
	private int cantClientesProyecto;
	private String idContrato;
	private String cedulaCliente;
	private Proyecto proyecto;
	public Contrato(Date fInicio, Date fEntrega, int cantClientesProyecto, String idContrato, String cedulaCliente,
			Proyecto proyecto) {
		super();
		this.fInicio = fInicio;
		this.fEntrega = fEntrega;
		this.cantClientesProyecto = cantClientesProyecto;
		this.idContrato = idContrato;
		this.cedulaCliente = cedulaCliente;
		this.proyecto = proyecto;
	}
	public Date getfInicio() {
		return fInicio;
	}
	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}
	public Date getfEntrega() {
		return fEntrega;
	}
	public void setfEntrega(Date fEntrega) {
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
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
}
