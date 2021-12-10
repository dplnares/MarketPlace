/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Carrito;
import Entidad.Pedido;
import Entidad.Producto;
import Entidad.Usuario;
import Modelo.CompraDAO;
import Modelo.ModeloProducto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edicz
 */
@WebServlet(name = "ControladoProducto", urlPatterns = {"/ControladoProducto"})
public class ControladoProducto extends HttpServlet {
    ModeloProducto pdao=new ModeloProducto();
    Producto p=new Producto();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    List<Producto> productos=new ArrayList<>();
    List<Carrito> listaCarrito=new ArrayList<>();
    int item;
    double totalPagar=0.0;
    int cantidad=1;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        switch(accion){
            case "AgregaCarrito":
                int pos=0;
                totalPagar=0.0;
                cantidad=Integer.parseInt(request.getParameter("cantidad"));
                int idProducto=Integer.parseInt(request.getParameter("id"));
                p=pdao.listarId(idProducto);
                
                if(listaCarrito.size()>0){
                    for(int i=0;i<listaCarrito.size();i++){
                        if(idProducto==listaCarrito.get(i).getIdProducto()){
                            pos=i;
                        }
                    }
                    if(idProducto==listaCarrito.get(pos).getIdProducto()){
                        cantidad=listaCarrito.get(pos).getCantidad()+cantidad;
                        double subtotal=listaCarrito.get(pos).getPrecioCompra()*cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubTotal(subtotal);
                    }else{
                        item=item+1;
                        Carrito car= new Carrito();
                        car.setItem(item);
                        car.setIdProducto(p.getIdProducto());
                        car.setNombres(p.getNombreProducto());
                        car.setDescripcion(p.getDescripcionProducto());
                        car.setPrecioCompra(p.getPrecioProducto());
                        car.setImg(p.getImgProducto());
                        car.setIdTienda(p.getIdTienda());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad*p.getPrecioProducto());
                        listaCarrito.add(car);                        
                    }
                }else{
                    item=item+1;
                    Carrito car= new Carrito();
                    car.setItem(item);
                    car.setIdProducto(p.getIdProducto());
                    car.setNombres(p.getNombreProducto());
                    car.setDescripcion(p.getDescripcionProducto());
                    car.setPrecioCompra(p.getPrecioProducto());
                    car.setImg(p.getImgProducto());
                    car.setIdTienda(p.getIdTienda());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad*p.getPrecioProducto());
                    listaCarrito.add(car);
                }
                
                
                for(int i=0;i<listaCarrito.size();i++){
                    totalPagar= totalPagar+listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.setAttribute("carrito", listaCarrito);
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("cart.jsp").forward(request, response);
                break;
            case "Delete":
                int idP=Integer.parseInt(request.getParameter("idProducto"));
                for(int i=0;i<listaCarrito.size();i++){
                    if(listaCarrito.get(i).getIdProducto()==idP){
                       listaCarrito.remove(i);
                    }
                }
                break;
            case "ActualizarCantidad":
                int idPro=Integer.parseInt(request.getParameter("idp"));
                int cant=Integer.parseInt(request.getParameter("Cantidad"));
                for(int i=0;i<listaCarrito.size();i++){
                    if(listaCarrito.get(i).getIdProducto()==idPro){
                        listaCarrito.get(i).setCantidad(cant);
                        double st=listaCarrito.get(i).getPrecioCompra()*cant;
                        listaCarrito.get(i).setSubTotal(st);
                    }
                }
                break;
            case "Carrito":
                totalPagar=0.0;
                request.setAttribute("carrito", listaCarrito);
                for(int i=0;i<listaCarrito.size();i++){
                    totalPagar=totalPagar+listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("cart.jsp").forward(request, response);
                break;
            case "listarCarrito":
                totalPagar=0.0;
                request.setAttribute("carrito", listaCarrito);
                for(int i=0;i<listaCarrito.size();i++){
                    totalPagar=totalPagar+listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("confirmarCompra.jsp").forward(request, response);
                break;
            case "GenerarCompra":
                int idUsuario=Integer.parseInt(request.getParameter("idUsuario"));
                int idPago=Integer.parseInt(request.getParameter("idPago"));
                String direccionPedido=request.getParameter("direccionPedido");
                String fechaPedido=request.getParameter("fechaPedido");
                String horaEntrega=request.getParameter("horaEntrega");
                String fechaEntrega=request.getParameter("fechaEntrega");
                int idTienda=Integer.parseInt(request.getParameter("idTienda"));
                Usuario usuario = new Usuario();
                
                CompraDAO dao= new CompraDAO();
                
                Pedido pedido= new Pedido(1,idPago,idUsuario,totalPagar,fechaPedido,direccionPedido,horaEntrega,fechaEntrega,idTienda, listaCarrito);
                int res=dao.GenerarCompra(pedido);
                
                if(res!=0&&totalPagar>0){
                    request.getRequestDispatcher("ServletProducto?tipo=listarPedidoCliente&id="+idUsuario).forward(request, response);
                }else{
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                break;    
            default:
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
