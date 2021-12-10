package Modelo;

import Entidad.Carrito;
import Entidad.Pedido;
import Utils.MysqlDBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author edicz
 */
public class CompraDAO {
    
    Connection con;
    MysqlDBConexion cn = new MysqlDBConexion();
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
    public int GenerarCompra(Pedido pedido){
        int idPedido;
        String sql="insert into pedido(fechaPedido,totalPrecio,idEstadoPedido,idPago,idUsuario,direccionPedido,horaEntrega,fechaEntrega,idTienda)values(?,?,?,?,?,?,?,?,?)";
        
        try {
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pedido.getFechaPedido());
            ps.setDouble(2, pedido.getTotalPrecio());
            ps.setInt(3, pedido.getIdEstadoPedido());
            ps.setInt(4, pedido.getIdPago());
            ps.setInt(5, pedido.getIdUsuario());
            ps.setString(6, pedido.getDireccionPedido());
            ps.setString(7, pedido.getHoraEntrega());
            ps.setString(8, pedido.getFechaEntrega());
            ps.setInt(9, pedido.getIdTienda());
            r=ps.executeUpdate();
            
            sql="Select @@IDENTITY AS idPedido";
            rs=ps.executeQuery(sql);
            rs.next();
            idPedido=rs.getInt("idPedido");
            rs.close();
            
            for(Carrito detalle : pedido.getDetallePedido()){
                sql="insert into detallepedido(cantidad,precio,idProducto,idPedido)values(?,?,?,?)"; 
                ps=con.prepareStatement(sql);
                ps.setInt(1, detalle.getCantidad());
                ps.setDouble(2, detalle.getPrecioCompra()*detalle.getCantidad());
                ps.setInt(3, detalle.getIdProducto());
                ps.setInt(4, idPedido);
                r=ps.executeUpdate();
            }
            
        } catch (Exception e) {
        }
        return r;
    }
}
