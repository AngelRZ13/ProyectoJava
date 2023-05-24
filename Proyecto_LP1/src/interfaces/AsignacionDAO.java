package interfaces;

import java.util.ArrayList;

import entidades.Asignacion;

public interface AsignacionDAO {
	
	public int guardarAsignacion();
	public int save(Asignacion bean);
	public int update(Asignacion bean);
	public int delete(int cod);
	public ArrayList<Asignacion> findAll();
	public ArrayList<Asignacion> listAllByDocumento(String doc);

}
