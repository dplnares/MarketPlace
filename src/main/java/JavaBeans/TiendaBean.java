/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

/**
 *
 * @author edicz
 */
public class TiendaBean {
    public TiendaBean(){
        
    }
    private int idTienda;
    private int idUsuario;
    private int idDistrito;
    private int telefonoTienda;
    private int estadoTienda;
    private int idCalificacion;
    private String nombreTienda;
    private String longitud;
    private String latitud;
    private String direccionTienda;

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public int getTelefonoTienda() {
        return telefonoTienda;
    }

    public void setTelefonoTienda(int telefonoTienda) {
        this.telefonoTienda = telefonoTienda;
    }

    public int getEstadoTienda() {
        return estadoTienda;
    }

    public void setEstadoTienda(int estadoTienda) {
        this.estadoTienda = estadoTienda;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getDireccionTienda() {
        return direccionTienda;
    }

    public void setDireccionTienda(String direccionTienda) {
        this.direccionTienda = direccionTienda;
    }
}
