package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.InspeccionFinalDAO;
import entidades.InspeccionFinal;
import utils.MySQLCONEXION;

public class MySqlInspeccionFinal {
	
	public int save(InspeccionFinal bean) {
		int salida=-1;
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			conn=MySQLCONEXION.getConexion();
			String sql="insert into Entidades values(null,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, bean.getCodEntidad());
			pstm.setDate(2, bean.getFInspeccion());
			pstm.setInt(3, bean.getCodInspector());
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

	public ArrayList<InspeccionFinal> findAll() {
		ArrayList<InspeccionFinal> data=new ArrayList<InspeccionFinal>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySQLCONEXION.getConexion();
			String sql="select Ent.cod_Inspeccion,Ent.cod_Ent,Ent.cod_insp,Ent.tel_Ent,"+
							"c.nom_Cat from inspeccionFin Ent join CategoriaEnt c on c.cod_Cat=Ent.cod_Cat ";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				InspeccionFinal Ent=new InspeccionFinal();
				Ent.setCodigoInspF(rs.getInt(1));
				Ent.setFInspeccion(rs.getDate(2));
				Ent.setCodInspector(rs.getInt(3));
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
}
