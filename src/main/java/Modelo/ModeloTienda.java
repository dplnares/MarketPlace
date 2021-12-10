
package Modelo;

import Entidad.Tienda;
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
public class ModeloTienda {
    public int insertaTienda(Tienda obj)
    {
	int salida = -1;
		
	Connection conn= null;
	PreparedStatement pstm = null;
	try 
        {
            conn = MysqlDBConexion.getConexion();
            String sql ="insert into tienda values(null,?,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getNombreTienda());
            pstm.setString(2, obj.getLongitud());			
            pstm.setString(3, obj.getLatitud());
            pstm.setInt(4, obj.getEstadoTienda());
            pstm.setInt(5, obj.getTelefonoTienda());
            pstm.setString(6, obj.getDireccionTienda());
            pstm.setInt(7, obj.getIdUsuario());
            pstm.setInt(8, obj.getIdDistrito());
                        
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
    public List<Tienda> listarTienda()
    {   Tienda alu=null;
        List<Tienda> data=new ArrayList<Tienda>();
        Connection cn=null;
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try 
        {   cn=MysqlDBConexion.getConexion();
            String sql="select * from tienda";
            pstm=cn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while(rs.next())
            {   alu=new Tienda();
                alu.setIdTienda(rs.getInt("idTienda"));
                alu.setNombreTienda(rs.getString("nombreTienda"));
                alu.setLongitud(rs.getString("longitud"));
                alu.setLatitud(rs.getString("latitud"));
                alu.setEstadoTienda(rs.getInt("estadoTienda"));
                alu.setTelefonoTienda(rs.getInt("telefonoTienda"));
                alu.setDireccionTienda(rs.getString("direccionTienda"));
                alu.setIdUsuario(rs.getInt("idUsuario"));
                alu.setIdDistrito(rs.getInt("idDistrito"));
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
    public Tienda iniciarTienda(String id)
    {
		Tienda obj=null;
		Connection cn=null;
		ResultSet rs=null;
		PreparedStatement pstm=null;
		try 
                {
                    String sql="select * from tienda where idTienda=?";
                    cn=MysqlDBConexion.getConexion();
                    pstm=cn.prepareStatement(sql);
                    pstm.setString(1, id);
                    rs=pstm.executeQuery();
                    if(rs.next())
                    {
                        obj=new Tienda();
                        obj.setIdTienda(rs.getInt(1));
                        obj.setNombreTienda(rs.getString(2));
                        obj.setLongitud(rs.getString(3));
                        obj.setLatitud(rs.getString(4));
                        obj.setEstadoTienda(rs.getInt(5));
                        obj.setTelefonoTienda(rs.getInt(6));
                        obj.setDireccionTienda(rs.getString(7));
                        obj.setIdUsuario(rs.getInt(8));
                        obj.setIdDistrito(rs.getInt(9));
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
    public Tienda iniciarTiendaVendedor(String id)
    {
		Tienda obj=null;
		Connection cn=null;
		ResultSet rs=null;
		PreparedStatement pstm=null;
		try 
                {
                    String sql="select * from tienda where idUsuario=?";
                    cn=MysqlDBConexion.getConexion();
                    pstm=cn.prepareStatement(sql);
                    pstm.setString(1, id);
                    rs=pstm.executeQuery();
                    if(rs.next())
                    {
                        obj=new Tienda();
                        obj.setIdTienda(rs.getInt(1));
                        obj.setNombreTienda(rs.getString(2));
                        obj.setLongitud(rs.getString(3));
                        obj.setLatitud(rs.getString(4));
                        obj.setEstadoTienda(rs.getInt(5));
                        obj.setTelefonoTienda(rs.getInt(6));
                        obj.setDireccionTienda(rs.getString(7));
                        obj.setIdUsuario(rs.getInt(8));
                        obj.setIdDistrito(rs.getInt(9));
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
}
