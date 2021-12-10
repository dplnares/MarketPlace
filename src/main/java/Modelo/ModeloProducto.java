/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidad.Categoria;
import Entidad.DetallePedido;
import Entidad.Pedido;
import Entidad.Producto;
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
public class ModeloProducto {
    
    public List<Producto> listarProducto(int idTienda)
    {   
        List<Producto> data=new ArrayList<Producto>();
        Connection conn= null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Producto alu = null;
        try 
        {   conn=MysqlDBConexion.getConexion();
            String sql="select * from producto where idTienda=?";
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, idTienda);
            rs=pstm.executeQuery();
            while(rs.next())
            {   alu=new Producto();
                alu.setIdProducto(rs.getInt("idProducto"));
                alu.setNombreProducto(rs.getString("nombreProducto"));
                alu.setPrecioProducto(rs.getDouble("precioProducto"));
                alu.setImgProducto(rs.getString("imgProducto"));
                alu.setDescripcionProducto(rs.getString("descripcionProducto"));
                alu.setEstadoProducto(rs.getInt("estadoProducto"));
                alu.setMarcaProducto(rs.getString("marcaProducto"));
                alu.setUnidadDeMedida(rs.getString("unidadDeMedida"));
                alu.setIdCategoria(rs.getInt("idCategoria"));
                alu.setIdTienda(rs.getInt("idTienda"));
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
    public int insertaProducto(Producto obj)
    {
	int salida = -1;
		
	Connection conn= null;
	PreparedStatement pstm = null;
	try 
        {
            conn = MysqlDBConexion.getConexion();
            String sql ="insert into producto values(null,?,?,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getNombreProducto());
            pstm.setDouble(2, obj.getPrecioProducto());
            pstm.setString(3, obj.getImgProducto());
            pstm.setString(4, obj.getDescripcionProducto());
            pstm.setInt(5, obj.getEstadoProducto());
            pstm.setString(6, obj.getMarcaProducto());
            pstm.setString(7, obj.getUnidadDeMedida());
            pstm.setInt(8, obj.getIdCategoria());
            pstm.setInt(9, obj.getIdTienda());
                        
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
    public List<Categoria> listarCategoria()
    {   Categoria alu=null;
        List<Categoria> data=new ArrayList<Categoria>();
        Connection cn=null;
        ResultSet rs=null;
        PreparedStatement pstm=null;
        try 
        {   cn=MysqlDBConexion.getConexion();
            String sql="select * from categoria";
            pstm=cn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while(rs.next())
            {   alu=new Categoria();
                alu.setIdCategoria(rs.getInt("idCategoria"));
                alu.setNombreCategoria(rs.getString("nombreCategoria"));
                alu.setDescripcionCategoria(rs.getString("descripcionCategoria"));
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
    public int eliminaProducto(int idProducto)
    {
        int salida = -1;
        Connection conn= null;
        PreparedStatement pstm = null;
        try 
        {
            conn = MysqlDBConexion.getConexion();
            String sql ="delete from producto where idProducto=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idProducto);
            salida = pstm.executeUpdate();
			
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            try 
            {
                if(pstm!= null) pstm.close();
                if(conn!= null) conn.close();
            } catch (Exception e2) {
                }
        }
        return salida;
    }
    public Producto buscaProducto(int idProducto)
    {
        Connection conn= null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Producto obj = null;
        try {
            conn = MysqlDBConexion.getConexion();
            String sql ="select * from producto where idProducto=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idProducto);
            rs = pstm.executeQuery();
            if(rs.next()){
                obj = new Producto();
                obj.setIdProducto(rs.getInt("idProducto"));
                obj.setNombreProducto(rs.getString("nombreProducto"));
                obj.setPrecioProducto(rs.getDouble("precioProducto"));
                obj.setImgProducto(rs.getString("imgProducto"));
                obj.setDescripcionProducto(rs.getString("descripcionProducto"));
                obj.setEstadoProducto(rs.getInt("estadoProducto"));
                obj.setMarcaProducto(rs.getString("marcaProducto"));
                obj.setUnidadDeMedida(rs.getString("unidadDeMedida"));
                obj.setIdCategoria(rs.getInt("idCategoria"));
                obj.setIdTienda(rs.getInt("idTienda"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(rs!= null) rs.close();
                if(pstm!= null) pstm.close();
                if(conn!= null) conn.close();
            } catch (Exception e2) {
            }
        }

        return obj;
    }
    public int actualizaProducto(Producto obj)
    {
        int salida = -1;

        Connection conn= null;
        PreparedStatement pstm = null;
        try {
                conn = MysqlDBConexion.getConexion();
                String sql ="update producto set nombreProducto=?, precioProducto=?, imgProducto=?, descripcionProducto=?, estadoProducto=?, marcaProducto=?, unidadDeMedida=?, idCategoria=?, idTienda=? where idProducto=?";     
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, obj.getNombreProducto());
                pstm.setDouble(2, obj.getPrecioProducto());
                pstm.setString(3, obj.getImgProducto());
                pstm.setString(4, obj.getDescripcionProducto());
                pstm.setInt(5, obj.getEstadoProducto());
                pstm.setString(6, obj.getMarcaProducto());
                pstm.setString(7, obj.getUnidadDeMedida());
                pstm.setInt(8, obj.getIdCategoria());
                pstm.setInt(9, obj.getIdTienda());
                pstm.setInt(10, obj.getIdProducto());
                salida = pstm.executeUpdate();

        } catch (Exception e) {
                e.printStackTrace();
        } finally{
                try {
                        if(pstm!= null) pstm.close();
                        if(conn!= null) conn.close();
                } catch (Exception e2) {
                }
        }
        return salida;
    }
    Connection con;
    MysqlDBConexion cn= new MysqlDBConexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Producto listarId(int id){
        String sql="Select * from producto where idProducto="+id;
        Producto p=new Producto();
        try {
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                p.setIdProducto(rs.getInt(1));
                p.setNombreProducto(rs.getString(2));
                p.setPrecioProducto(rs.getDouble(3));
                p.setImgProducto(rs.getString(4));
                p.setDescripcionProducto(rs.getString(5));
                p.setEstadoProducto(rs.getInt(6));
                p.setMarcaProducto(rs.getString(7));
                p.setUnidadDeMedida(rs.getString(8));
                p.setIdCategoria(rs.getInt(9));
                p.setIdTienda(rs.getInt(10)); 
                
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    public Producto getProducto(int idProducto)
    {
        Connection conn= null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Producto obj = null;
        try {
            conn = MysqlDBConexion.getConexion();
            String sql ="select * from producto where idProducto=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idProducto);
            rs = pstm.executeQuery();
            if(rs.next()){
                obj = new Producto();
                obj.setIdProducto(rs.getInt("idProducto"));
                obj.setNombreProducto(rs.getString("nombreProducto"));
                obj.setPrecioProducto(rs.getDouble("precioProducto"));
                obj.setImgProducto(rs.getString("imgProducto"));
                obj.setDescripcionProducto(rs.getString("descripcionProducto"));
                obj.setEstadoProducto(rs.getInt("estadoProducto"));
                obj.setMarcaProducto(rs.getString("marcaProducto"));
                obj.setUnidadDeMedida(rs.getString("unidadDeMedida"));
                obj.setIdCategoria(rs.getInt("idCategoria"));
                obj.setIdTienda(rs.getInt("idTienda"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(rs!= null) rs.close();
                if(pstm!= null) pstm.close();
                if(conn!= null) conn.close();
            } catch (Exception e2) {
            }
        }

        return obj;
    }
    public List<Pedido> listarPedidosCliente(int idUsuario)
    {   
        List<Pedido> data=new ArrayList<Pedido>();
        Connection conn= null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Pedido alu = null;
        try 
        {   conn=MysqlDBConexion.getConexion();
            String sql="select * from pedido where idUsuario=?";
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, idUsuario);
            rs=pstm.executeQuery();
            while(rs.next())
            {   alu=new Pedido();
                alu.setIdPedido(rs.getInt("idPedido"));
                alu.setFechaPedido(rs.getString("fechaPedido"));
                alu.setTotalPrecio(rs.getInt("totalPrecio"));
                alu.setIdEstadoPedido(rs.getInt("idEstadoPedido"));
                alu.setIdPago(rs.getInt("idPago"));
                alu.setIdUsuario(rs.getInt("idUsuario"));
                alu.setDireccionPedido(rs.getString("direccionPedido"));
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
    public List<DetallePedido> listarDetallePedido(int idPedido)
    {   
        List<DetallePedido> data=new ArrayList<DetallePedido>();
        Connection conn= null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        DetallePedido alu = null;
        try 
        {   conn=MysqlDBConexion.getConexion();
            String sql="select detallepedido.idDetallePedido, detallepedido.cantidad, detallepedido.precio, detallepedido.idProducto, detallepedido.idPedido, producto.nombreProducto, producto.imgProducto, producto.precioProducto from detallepedido inner join producto where detallepedido.idProducto = producto.idProducto and idPedido=?";
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, idPedido);
            rs=pstm.executeQuery();
            while(rs.next())
            {   alu=new DetallePedido();
                alu.setIdDetallePedido(rs.getInt("idDetallePedido"));
                alu.setCantida(rs.getInt("cantidad"));
                alu.setPrecio(rs.getDouble("precio"));
                alu.setIdProducto(rs.getInt("idProducto"));
                alu.setIdPedido(rs.getInt("idPedido"));
                alu.setNombreProducto(rs.getString("nombreProducto"));
                alu.setImgProducto(rs.getString("imgProducto"));
                alu.setPrecioProducto(rs.getDouble("precioProducto"));
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
    public List<Pedido> listarPedidosClienteTienda(int idTienda)
    {   
        List<Pedido> data=new ArrayList<Pedido>();
        Connection conn= null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Pedido alu = null;
        try 
        {   conn=MysqlDBConexion.getConexion();
            String sql="select * from pedido where idTienda=?";
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, idTienda);
            rs=pstm.executeQuery();
            while(rs.next())
            {   alu=new Pedido();
                alu.setIdPedido(rs.getInt("idPedido"));
                alu.setFechaPedido(rs.getString("fechaPedido"));
                alu.setTotalPrecio(rs.getInt("totalPrecio"));
                alu.setIdEstadoPedido(rs.getInt("idEstadoPedido"));
                alu.setIdPago(rs.getInt("idPago"));
                alu.setIdUsuario(rs.getInt("idUsuario"));
                alu.setDireccionPedido(rs.getString("direccionPedido"));
                alu.setHoraEntrega(rs.getString("horaEntrega"));
                alu.setFechaEntrega(rs.getString("fechaEntrega"));
                alu.setIdTienda(rs.getInt("idTienda"));
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
    public int eliminaDetalleProducto(int idDetallePedido)
    {
        int salida = -1;
        Connection conn= null;
        PreparedStatement pstm = null;
        try 
        {
            conn = MysqlDBConexion.getConexion();
            String sql ="delete from detallepedido where idDetallePedido=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idDetallePedido);
            salida = pstm.executeUpdate();
			
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            try 
            {
                if(pstm!= null) pstm.close();
                if(conn!= null) conn.close();
            } catch (Exception e2) {
                }
        }
        return salida;
    }
    public Pedido buscaPedido(int idPedido)
    {
        Connection conn= null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Pedido obj = null;
        try {
            conn = MysqlDBConexion.getConexion();
            String sql ="select * from pedido where idPedido=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idPedido);
            rs = pstm.executeQuery();
            if(rs.next()){
                obj = new Pedido();
                obj.setIdPedido(rs.getInt("idPedido"));
                obj.setFechaPedido(rs.getString("fechaPedido"));
                obj.setTotalPrecio(rs.getDouble("totalPrecio"));
                obj.setIdEstadoPedido(rs.getInt("IdEstadoPedido"));
                obj.setIdPago(rs.getInt("idPago"));
                obj.setIdUsuario(rs.getInt("idUsuario"));
                obj.setDireccionPedido(rs.getString("direccionPedido"));
                obj.setHoraEntrega(rs.getString("horaEntrega"));
                obj.setFechaEntrega(rs.getString("fechaEntrega"));
                obj.setIdTienda(rs.getInt("idTienda"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(rs!= null) rs.close();
                if(pstm!= null) pstm.close();
                if(conn!= null) conn.close();
            } catch (Exception e2) {
            }
        }
        return obj;
    }
    public int actualizaPedido(Pedido obj)
    {
        int salida = -1;

        Connection conn= null;
        PreparedStatement pstm = null;
        try {
                conn = MysqlDBConexion.getConexion();
                String sql ="update pedido set fechaPedido=?, totalPrecio=?, idEstadoPedido=?, idPago=?, idUsuario=?, direccionPedido=?, horaEntrega=?, fechaEntrega=?, idTienda=? where idPedido=?";     
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, obj.getFechaPedido());
                pstm.setDouble(2, obj.getTotalPrecio());
                pstm.setInt(3, obj.getIdEstadoPedido());
                pstm.setInt(4, obj.getIdPago());
                pstm.setInt(5, obj.getIdUsuario());
                pstm.setString(6, obj.getDireccionPedido());
                pstm.setString(7, obj.getHoraEntrega());
                pstm.setString(8, obj.getFechaEntrega());
                pstm.setInt(9, obj.getIdTienda());
                pstm.setInt(10, obj.getIdPedido());
                salida = pstm.executeUpdate();

        } catch (Exception e) {
                e.printStackTrace();
        } finally{
                try {
                        if(pstm!= null) pstm.close();
                        if(conn!= null) conn.close();
                } catch (Exception e2) {
                }
        }
        return salida;
    }
    public int actualizaDetalleProducto(DetallePedido obj)
    {
        int salida = -1;

        Connection conn= null;
        PreparedStatement pstm = null;
        try {
                conn = MysqlDBConexion.getConexion();
                String sql ="update detallepedido set cantidad=?, precio=? where idDetallePedido=?";     
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, obj.getCantida());
                pstm.setDouble(2, obj.getPrecio());
                pstm.setInt(3, obj.getIdDetallePedido());
                salida = pstm.executeUpdate();

        } catch (Exception e) {
                e.printStackTrace();
        } finally{
                try {
                        if(pstm!= null) pstm.close();
                        if(conn!= null) conn.close();
                } catch (Exception e2) {
                }
        }
        return salida;
    }
    public List<Producto> buscar(int idTienda,String texto )
    {   
        List<Producto> data=new ArrayList<Producto>();
        Connection conn= null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Producto alu = null;
        try 
        {   conn=MysqlDBConexion.getConexion();
            String sql="select * from producto where idTienda="+idTienda+" and nombreProducto like '%"+texto+"%' or marcaProducto like '%"+texto+"%'";
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while(rs.next())
            {   alu=new Producto();
                alu.setIdProducto(rs.getInt("idProducto"));
                alu.setNombreProducto(rs.getString("nombreProducto"));
                alu.setPrecioProducto(rs.getDouble("precioProducto"));
                alu.setImgProducto(rs.getString("imgProducto"));
                alu.setDescripcionProducto(rs.getString("descripcionProducto"));
                alu.setEstadoProducto(rs.getInt("estadoProducto"));
                alu.setMarcaProducto(rs.getString("marcaProducto"));
                alu.setUnidadDeMedida(rs.getString("unidadDeMedida"));
                alu.setIdCategoria(rs.getInt("idCategoria"));
                alu.setIdTienda(rs.getInt("idTienda"));
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
