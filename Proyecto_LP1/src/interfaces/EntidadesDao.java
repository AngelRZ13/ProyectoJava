package interfaces;

import java.util.ArrayList;

import entidades.Entidades;

public interface EntidadesDao {
	
	public int save (Entidades bean);
	public int update (Entidades bean);
	public int delete (int cod);
	public ArrayList<Entidades> findAll();
	public ArrayList<Entidades> listAllByCategoria(String nom);
	public ArrayList<Entidades> listAll();
}
