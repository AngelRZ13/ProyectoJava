package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Asignacion;
import entidades.Entidades;
import entidades.Inspectores;
import utils.MySQLCONEXION;

public class MySqlAsignacion {
	
	public List<Inspectores> getListInsp(){
		List<Inspectores> Insp = new ArrayList<>();
		
		String sql="select * from Inpectores";
		
		try(PreparedStatement pstm = MySQLCONEXION.getConexion().prepareStatement(sql)){
			try(ResultSet rs = pstm.executeQuery()){
				while(rs.next()) {
					Inspectores inpec = new  Inspectores();
					inpec.setCodigo(rs.getInt(1));
					inpec.setNombreIns(rs.getString(2));
					
					Insp.add(inpec);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Insp;
	}
	
	public int save(Asignacion bean) {
		int salida=-1;
		Connection ct = null;
		PreparedStatement pt= null;
		try {
			ct = MySQLCONEXION.getConexion();
			String sql="insert into Asignacion values(null,?,?,?,?)";
			pt =ct.prepareStatement(sql);
			pt.setString(1, bean.getDocAsignacion());
			pt.setString(2, bean.getFechAsignacion());
			pt.setInt(3, bean.getCodInspector());
			pt.setInt(4, bean.getCodResultado());
			salida=pt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pt!=null) pt.close();
				if(ct!=null) ct.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
				
		return salida;
	}
	public int update(Asignacion bean) {
		int salida= -1;
		Connection ct = null;
		PreparedStatement pt= null;
		try {
			ct = MySQLCONEXION.getConexion();
			String sql="update Asignacion set Doc_Asig=?,Fec_Aig=?, cod_insp=?, cod_Resu=? where cod_Asig=?";
			pt =ct.prepareStatement(sql);
			pt.setString(1, bean.getDocAsignacion());
			pt.setString(2, bean.getFechAsignacion());
			pt.setInt(3, bean.getCodInspector());
			pt.setInt(4, bean.getCodResultado());
			pt.setInt(5, bean.getCodAsignacion());
			salida=pt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pt!=null) pt.close();
				if(ct!=null) ct.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
				
		return salida;
	}
	public int delete(int cod) {
		int salida= -1;
		Connection ct = null;
		PreparedStatement pt= null;
		try {
			ct = MySQLCONEXION.getConexion();
			String sql="delete from Asignacion where cod_Asig=?";
			pt =ct.prepareStatement(sql);
			pt.setInt(1, cod);
			salida=pt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pt!=null) pt.close();
				if(ct!=null) ct.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
				
		return salida;
	}
	public  ArrayList<Asignacion> findAll() {
		ArrayList<Asignacion> data=new ArrayList<Asignacion>();
		Connection ct = null;
		PreparedStatement pt= null;
		ResultSet rs= null;
		try {
			ct = MySQLCONEXION.getConexion();
			String sql="select a.cod_Asig, a.Doc_Asig, a.Fec_Asig, "+
					 " i.nom_insp,r.nom_Resu from Asignacion a join Resultado r on r.cod_Resu=a.cod_Resu join Inpectores i on i.cod_insp=a.cod_insp";
			pt =ct.prepareStatement(sql);
			rs= pt.executeQuery();
			while(rs.next()) {
				Asignacion emp = new Asignacion();
				emp.setCodAsignacion(rs.getInt(1));
				emp.setDocAsignacion(rs.getString(2));
				emp.setFechAsignacion(rs.getString(3));
				emp.setNomInspector(rs.getString(4));
				emp.setNomResultado(rs.getString(5));
				
				data.add(emp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pt!=null) pt.close();
				if(ct!=null) ct.close();
				if(rs!=null) rs.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
				
		return data;
	}
	public ArrayList<Asignacion> listAllByDocumento(String doc) {
		ArrayList<Asignacion> data=new ArrayList<Asignacion>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLCONEXION.getConexion();
			String sql="select a.cod_Asig, a.Doc_Asig, a.Fec_Asig,"+
					 " i.nom_insp,r.nom_Resu from Asignacion a join Resultado r on r.cod_Resu=a.cod_Resu join Inpectores i on i.cod_insp=a.cod_insp where Doc_Asig like ?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, doc+"%");
			rs=pstm.executeQuery();
			while(rs.next()){
				Asignacion asig=new Asignacion();
				asig.setCodAsignacion(rs.getInt(1));
				asig.setDocAsignacion(rs.getString(2));
				asig.setFechAsignacion(rs.getString(3));
				asig.setNomInspector(rs.getString(4));
				asig.setNomResultado(rs.getString(5));
				data.add(asig);
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
