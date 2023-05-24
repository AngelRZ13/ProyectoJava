package entidades;

public class Asignacion {
	private int CodAsignacion, codInspector, codResultado;
	private String  DocAsignacion, FechAsignacion;
	private String nomResultado, nomInspector;
	
	public int getCodAsignacion() {
		return CodAsignacion;
	}
	public void setCodAsignacion(int codAsignacion) {
		CodAsignacion = codAsignacion;
	}
	public int getCodInspector() {
		return codInspector;
	}
	public void setCodInspector(int codInspector) {
		this.codInspector = codInspector;
	}
	public int getCodResultado() {
		return codResultado;
	}
	public void setCodResultado(int codResultado) {
		this.codResultado = codResultado;
	}
	public String getDocAsignacion() {
		return DocAsignacion;
	}
	public void setDocAsignacion(String docAsignacion) {
		DocAsignacion = docAsignacion;
	}
	public String getFechAsignacion() {
		return FechAsignacion;
	}
	public void setFechAsignacion(String fechAsignacion) {
		FechAsignacion = fechAsignacion;
	}
	public String getNomResultado() {
		return nomResultado;
	}
	public void setNomResultado(String nomResultado) {
		this.nomResultado = nomResultado;
	}
	public String getNomInspector() {
		return nomInspector;
	}
	public void setNomInspector(String nomInspector) {
		this.nomInspector = nomInspector;
	}
	
	
	
}
