package Controladores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.MySQLCONEXION;

import ConexionMysql.MysqlConexion;
import entidades.logeo;
import interfaces.LogeoDAO;

public class MySqlLogeoDAO implements LogeoDAO{
	
	  @Override
	    public logeo iniciarSesion(String login, String clave) {
	        logeo u = null;
	        Connection cn = null;
	        PreparedStatement pstm = null;
	        ResultSet rs=null;
	        try {
	            cn=MySQLCONEXION.getConexion();
	            String sql = "select id, usuario, pass from login "+
	                            "where usuario = ? and pass = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setString(1, login);
	            pstm.setString(2, clave);
	            rs=pstm.executeQuery();
	            //validar si existe registro
	            if(rs.next()){
	                //crear objeto "u"
	                u=new logeo();
	                //setear
	                u.setUsuario(rs.getString(1));
	                u.setContraseña(rs.getString(2));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(rs != null) rs.close();
	                if(pstm != null) pstm.close();
	                if(cn != null) cn.close();
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }

	        }
	        return u;
	    }

	}

