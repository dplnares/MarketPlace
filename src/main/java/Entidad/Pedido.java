
package Entidad;

import java.util.List;

public class Pedido {
    private int idPedido;
    private int idEstadoPedido;
    private int idPago;
    private int idUsuario;
    private double totalPrecio;
    private String fechaPedido;
    private String direccionPedido;
    private String horaEntrega;
    private String fechaEntrega;
    private int idTienda;
    
    private List<Carrito>detallePedido;

    public Pedido() {
    }

    public Pedido(int idEstadoPedido, int idPago, int idUsuario, double totalPrecio, String fechaPedido, String direccionPedido, String horaEntrega, String fechaEntrega, int idTienda, List<Carrito> detallePedido) {
        this.idEstadoPedido = idEstadoPedido;
        this.idPago = idPago;
        this.idUsuario = idUsuario;
        this.totalPrecio = totalPrecio;
        this.fechaPedido = fechaPedido;
        this.direccionPedido = direccionPedido;
        this.horaEntrega = horaEntrega;
        this.fechaEntrega = fechaEntrega;
        this.idTienda=idTienda;
        this.detallePedido = detallePedido;        
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(int idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getTotalPrecio() {
        return totalPrecio;
    }

    public void setTotalPrecio(double totalPrecio) {
        this.totalPrecio = totalPrecio;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getDireccionPedido() {
        return direccionPedido;
    }

    public void setDireccionPedido(String direccionPedido) {
        this.direccionPedido = direccionPedido;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
    
    public List<Carrito> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<Carrito> detallePedido) {
        this.detallePedido = detallePedido;
    }
    
    
}