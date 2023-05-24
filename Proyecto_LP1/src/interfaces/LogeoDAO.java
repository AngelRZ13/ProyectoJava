package interfaces;

import entidades.logeo;

public interface LogeoDAO {
	
	public logeo iniciarSesion(String login,String clave);

}
