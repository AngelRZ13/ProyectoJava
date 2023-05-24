package interfaces;

import java.util.ArrayList;

import entidades.Inspectores;

public interface InpectoresDAO {
	
	public int save (Inspectores bean);
	public int update (Inspectores bean);
	public int delete (int cod);
	public ArrayList<Inspectores> findAll();
	public ArrayList<Inspectores> listAll();

}
