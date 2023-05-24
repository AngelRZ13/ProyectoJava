package ConexionMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConexion {
	
	public static Connection getConexion() {
		Connection cn=null;
		try {
			//carga de la clase Driver que se encuentra en jar
			Class.forName("com.mysql.cj.jdbc.Driver");
			//variables
			String url,user,pass;
			//
			url="jdbc:mysql://localhost/BD_Inspeccion?serverTimezone=UTC";
			user="root";
			pass="mysql";
			//crear objeto cn
			cn=DriverManager.getConnection(url, user, pass);			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cn;

}
	}
