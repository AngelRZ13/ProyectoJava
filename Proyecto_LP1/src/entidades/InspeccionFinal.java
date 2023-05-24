package entidades;

import java.sql.Date;

public class InspeccionFinal {
	
	private int codigoInspF,codEntidad,codInspector;
	private String  nomInspector,Direccion;
	private Date FInspeccion;
	
	public int getCodigoInspF() {
		return codigoInspF;
	}
	public void setCodigoInspF(int codigoInspF) {
		this.codigoInspF = codigoInspF;
	}
	public int getCodEntidad() {
		return codEntidad;
	}
	public void setCodEntidad(int codEntidad) {
		this.codEntidad = codEntidad;
	}
	public int getCodInspector() {
		return codInspector;
	}
	public void setCodInspector(int codInspector) {
		this.codInspector = codInspector;
	}
	public Date getFInspeccion() {
		return FInspeccion;
	}
	public void setFInspeccion(Date fInspeccion) {
		FInspeccion = fInspeccion;
	}
	public String getNomInspector() {
		return nomInspector;
	}
	public void setNomInspector(String nomInspector) {
		this.nomInspector = nomInspector;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	
}
