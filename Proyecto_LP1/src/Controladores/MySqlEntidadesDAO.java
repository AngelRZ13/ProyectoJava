package Controladores;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Entidades;
import interfaces.EntidadesDao;
import utils.MySQLCONEXION;

public class MySqlEntidadesDAO implements EntidadesDao {
	
	@Override
	public int save(Entidades bean) {
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			conn=MySQLCONEXION.getConexion();
			String sql="insert into Entidades values(null,?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre());
			pstm.setString(2, bean.getDireccion());
			pstm.setInt(3, bean.getTelefono());
			pstm.setInt(4, bean.getcodCategoria());
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}
	
	@Override
	public int update(Entidades bean) {
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			conn=MySQLCONEXION.getConexion();
			String sql="update Entidades set nom_Ent=?,direc_Ent=?,tel_Ent=?,cod_Cat=? where cod_Ent=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,bean.getNombre());
			pstm.setString(2, bean.getDireccion());	
			pstm.setInt(3, bean.getTelefono());
			pstm.setInt(4, bean.getcodCategoria());
			pstm.setInt(5, bean.getCodigo());
			salida=pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(conn!=null)conn.close(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}
	@Override
	public int delete(int cod) {
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		try {	
			conn=MySQLCONEXION.getConexion();
			String sql="delete from Entidades where cod_Ent=?";
			pstm=conn.prepareStatement(sql);	
			pstm.setInt(1, cod);
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}
	@Override
	public ArrayList<Entidades> findAll() {
		ArrayList<Entidades> data=new ArrayList<Entidades>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLCONEXION.getConexion();
			String sql="select Ent.cod_Ent,Ent.nom_Ent,Ent.direc_Ent,Ent.tel_Ent,"+
							"c.nom_Cat from Entidades Ent join CategoriaEnt c on c.cod_Cat=Ent.cod_Cat ";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				Entidades Ent=new Entidades();
				Ent.setCodigo(rs.getInt(1));
				Ent.setNombre(rs.getString(2));
				Ent.setDireccion(rs.getString(3));
				Ent.setTelefono(rs.getInt(4));
				Ent.setNomCategoria(rs.getString(5));
				data.add(Ent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	@Override
	public ArrayList<Entidades> listAllByCategoria(String nom) {
		ArrayList<Entidades> data=new ArrayList<Entidades>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLCONEXION.getConexion();
			String sql="SELECT Ent.cod_Ent,Ent.nom_Ent,Ent.direc_Ent,Ent.tel_Ent,"+
					 " c.nom_Cat FROM Entidades Ent join CategoriaEnt c on c.cod_Cat=Ent.cod_Cat where nom_Ent like ?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, nom+"%");
			rs=pstm.executeQuery();
			while(rs.next()){
				Entidades ent=new Entidades();
				ent.setCodigo(rs.getInt(1));
				ent.setNombre(rs.getString(2));
				ent.setDireccion(rs.getString(3));
				ent.setTelefono(rs.getInt(4));
				ent.setNomCategoria(rs.getString(5));
				data.add(ent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}

	@Override
	public ArrayList<Entidades> listAll() {
		ArrayList<Entidades> data=new ArrayList<Entidades>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLCONEXION.getConexion();
			String sql="SELECT Ent.cod_Ent,Ent.nom_Ent,Ent.direc_Ent,Ent.tel_Ent,"+
					 " c.nom_Cat FROM Entidades Ent join CategoriaEnt c on c.cod_Cat=Ent.cod_Cat "; 
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				Entidades ent=new Entidades();
				ent.setCodigo(rs.getInt(1));
				ent.setNombre(rs.getString(2));
				ent.setDireccion(rs.getString(3));
				ent.setTelefono(rs.getInt(4));
				ent.setNomCategoria(rs.getString(5));
				data.add(ent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;	
	}

}
