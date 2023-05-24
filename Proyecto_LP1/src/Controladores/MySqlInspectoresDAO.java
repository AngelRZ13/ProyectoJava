package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Inspectores;
import interfaces.InpectoresDAO;
import utils.MySQLCONEXION;

public class MySqlInspectoresDAO implements InpectoresDAO {
	
	@Override
	public int save(Inspectores bean) {
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			conn=MySQLCONEXION.getConexion();
			String sql="insert into Inpectores values(null,?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, bean.getNombreIns());
			pstm.setString(2, bean.getApellidoIns());
			pstm.setInt(3, bean.getTelefonoIns());
			pstm.setString(4, bean.getFecha());
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
	public int update(Inspectores bean) {
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			conn=MySQLCONEXION.getConexion();
			String sql="update Inpectores set nom_insp=?,ape_insp=?,tel_insp=?,fech_insp=? where cod_insp=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,bean.getNombreIns());
			pstm.setString(2, bean.getApellidoIns());	
			pstm.setInt(3, bean.getTelefonoIns());
			pstm.setString(4, bean.getFecha());
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
			String sql="delete from Inpectores where cod_insp=?";
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
	public ArrayList<Inspectores>findAll() {
		ArrayList<Inspectores> data=new ArrayList<Inspectores>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLCONEXION.getConexion();
			String sql="select cod_insp,nom_Insp,ape_insp,tel_insp,fech_insp from Inpectores";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				Inspectores Ins=new Inspectores();
				Ins.setCodigo(rs.getInt(1));
				Ins.setNombreIns(rs.getString(2));
				Ins.setApellidoIns(rs.getString(3));
				Ins.setTelefonoIns(rs.getInt(4));
				Ins.setFecha(rs.getString(5));
				data.add(Ins);
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
	public ArrayList<Inspectores> listAll() {
		ArrayList<Inspectores> data=new ArrayList<Inspectores>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLCONEXION.getConexion();
			String sql="SELECT * FROM Inpectores";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				Inspectores Ins=new Inspectores();
				Ins.setCodigo(rs.getInt(1));
				Ins.setNombreIns(rs.getString(2));
				Ins.setApellidoIns(rs.getString(3));
				Ins.setTelefonoIns(rs.getInt(4));
				Ins.setFecha(rs.getString(5));
				data.add(Ins);
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
