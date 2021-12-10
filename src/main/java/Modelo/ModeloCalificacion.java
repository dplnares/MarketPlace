/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidad.Calificacion;
import Utils.MysqlDBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edicz
 */
public class ModeloCalificacion {
    
    public int insertarCalificacion(Calificacion obj)
    {
	int salida = -1;
		
	Connection conn= null;
	PreparedStatement pstm = null;
	try 
        {
            conn = MysqlDBConexion.getConexion();
            String sql ="insert into calificacion values(null,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, obj.getCalificacion());
            pstm.setString(2, obj.getComentario());
            pstm.setString(3, obj.getFechaCalificacion());
            pstm.setInt(4, obj.getIdUsuario());
            pstm.setInt(5, obj.getIdTienda());
                        
            salida = pstm.executeUpdate();
			
        } catch (Exception e)
        {
            e.printStackTrace();
	}
        finally
        {
            try {
                    if(pstm!= null) pstm.close();
                    if(conn!= null) conn.close();
                } catch (Exception e2) 
                {}
        }
        return salida;
    }
    
    public List<Calificacion> listarCalificacion(int idTienda)
    {   
        List<Calificacion> data=new ArrayList<Calificacion>();
        Connection conn= null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Calificacion alu = null;
        try 
        {   conn=MysqlDBConexion.getConexion();
            String sql="select calificacion.idCalificacion, calificacion.calificacion, calificacion.comentario, calificacion.fechaCalificacion, calificacion.idUsuario, calificacion.idTienda, usuario.nombresUsuario, tienda.nombreTienda from calificacion inner join usuario inner JOIN tienda where calificacion.idUsuario = usuario.idUsuario and calificacion.idTienda = tienda.idTienda and calificacion.idTienda=?";
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, idTienda);
            rs=pstm.executeQuery();
            while(rs.next())
            {   alu=new Calificacion();
                alu.setIdCalificacion(rs.getInt("idCalificacion"));                
                alu.setCalificacion(rs.getInt("calificacion"));
                alu.setComentario(rs.getString("comentario"));
                alu.setFechaCalificacion(rs.getString("fechaCalificacion"));
                alu.setIdUsuario(rs.getInt("idUsuario"));
                alu.setIdTienda(rs.getInt("idTienda"));
                alu.setNombreUsuario(rs.getString("nombresUsuario"));
                alu.setNombreTienda(rs.getString("nombreTienda"));
                data.add(alu);
            }
        } catch (Exception e) 
            {   e.printStackTrace();
            }
        finally
        {  try 
            {   if(rs!=null)rs.close();
                if(pstm!=null)pstm.close();
                if(conn!=null)conn.close();
            } catch (Exception e2){
                }
        }
        return data;
    }
}
