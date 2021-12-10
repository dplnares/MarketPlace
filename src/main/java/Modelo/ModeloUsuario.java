/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidad.Distrito;
import Entidad.Usuario;
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
public class ModeloUsuario {
    public List<Distrito> listarDistritos()
    {   Distrito alu=null;
        List<Distrito> data=new ArrayList<Distrito>();
        Connection cn=null;
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try 
        {   cn=MysqlDBConexion.getConexion();
            String sql="select * from distrito";
            pstm=cn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while(rs.next())
            {   alu=new Distrito();
                alu.setIdDistrito(rs.getInt("idDistrito"));
                alu.setNombreDireccion(rs.getString("nombreDistrito"));
                data.add(alu);
            }
        } catch (Exception e) 
            {   e.printStackTrace();
            }
        finally
        {  try 
            {   if(rs!=null)rs.close();
                if(pstm!=null)pstm.close();
                if(cn!=null)cn.close();
            } catch (Exception e2) 
                {   e2.printStackTrace();
                }
        }
        return data;
    }
    public Usuario iniciarSesion(String log,String pas, String rol)
    {
		Usuario obj=null;
		Connection cn=null;
		ResultSet rs=null;
		PreparedStatement pstm=null;
		try 
                {
                    String sql="select * from usuario where usuario=? and clave=? and idRol=?";
                    cn=MysqlDBConexion.getConexion();
                    pstm=cn.prepareStatement(sql);
                    pstm.setString(1, log);
                    pstm.setString(2, pas);
                    pstm.setString(3, rol);
                    rs=pstm.executeQuery();
                    if(rs.next())
                    {
                        obj=new Usuario();
                        obj.setIdUsuario(rs.getInt(1));
                        obj.setNombresUsuario(rs.getString(2));
                        obj.setApellidosUsuario(rs.getString(3));
                        obj.setTelefonoUsuario(rs.getInt(4));
                        obj.setCorreoUsuario(rs.getString(5));
                        obj.setUsuario(rs.getString(6));
                        obj.setClave(rs.getString(7));
                        obj.setDniUsuario(rs.getInt(8));
                        obj.setDireccionUsuario(rs.getString(9));
                        obj.setIdDistrito(rs.getInt(10));
                        obj.setIdRol(rs.getInt(11));
                    }
		} catch (Exception e) 
                {
                    e.printStackTrace();
		}
		finally
                {
                    try 
                    {
                        if(rs!=null)rs.close();
                        if(pstm!=null)pstm.close();
                        if(cn!=null)cn.close();
                    } 
                    catch (Exception e2) 
                    {
                        e2.printStackTrace();
                    }
		}
		return obj;
    }
    public Usuario iniciarSesionTienda(int id)
    {
		Usuario obj=null;
		Connection cn=null;
		ResultSet rs=null;
		PreparedStatement pstm=null;
		try 
                {
                    String sql="select * from tienda where idTienda=?";
                    cn=MysqlDBConexion.getConexion();
                    pstm=cn.prepareStatement(sql);
                    pstm.setInt(1, id);
                    rs=pstm.executeQuery();
                    if(rs.next())
                    {
                        obj=new Usuario();
                        obj.setIdUsuario(rs.getInt(1));
                        obj.setNombresUsuario(rs.getString(2));
                        obj.setApellidosUsuario(rs.getString(3));
                        obj.setTelefonoUsuario(rs.getInt(4));
                        obj.setCorreoUsuario(rs.getString(5));
                        obj.setUsuario(rs.getString(6));
                        obj.setClave(rs.getString(7));
                        obj.setDniUsuario(rs.getInt(8));
                        obj.setDireccionUsuario(rs.getString(9));
                        obj.setIdDistrito(rs.getInt(10));
                        obj.setIdRol(rs.getInt(11));
                    }
		} catch (Exception e) 
                {
                    e.printStackTrace();
		}
		finally
                {
                    try 
                    {
                        if(rs!=null)rs.close();
                        if(pstm!=null)pstm.close();
                        if(cn!=null)cn.close();
                    } 
                    catch (Exception e2) 
                    {
                        e2.printStackTrace();
                    }
		}
		return obj;
    }
    public int insertaUsuario(Usuario obj)
    {
	int salida = -1;
		
	Connection conn= null;
	PreparedStatement pstm = null;
	try 
        {
            conn = MysqlDBConexion.getConexion();
            String sql ="insert into usuario values(null,?,?,?,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getNombresUsuario());
            pstm.setString(2, obj.getApellidosUsuario());			
            pstm.setInt(3, obj.getTelefonoUsuario());
            pstm.setString(4, obj.getCorreoUsuario());
            pstm.setString(5, obj.getUsuario());
            pstm.setString(6, obj.getClave());
            pstm.setInt(7, obj.getDniUsuario());
            pstm.setString(8, obj.getDireccionUsuario());
            pstm.setInt(9, obj.getIdDistrito());
            pstm.setInt(10, obj.getIdRol());
                        
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
}
