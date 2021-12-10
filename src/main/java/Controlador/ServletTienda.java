/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidad.Tienda;
import Entidad.Usuario;
import Modelo.ModeloTienda;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author edicz
 */
@WebServlet(name = "ServletTienda", urlPatterns = {"/ServletTienda"})
public class ServletTienda extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletTienda</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletTienda at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    Modelo.ModeloTienda m = new ModeloTienda();
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {
        String tipo=request.getParameter("tipo");
        if(tipo.equals("registrarTienda"))
	{
            registrarTienda(request, response);
	}
        else if(tipo.equals("listarTienda"))
            {
                listarTienda(request, response);
            }else if(tipo.equals("catalogo"))
                {
                    String id;
                    id=request.getParameter("txtid");
                    Tienda e = m.iniciarTienda(id);

                    if(e==null)
                    {   
                        request.setAttribute("mensaje", "Error usuario y/o clave");
                        request.getRequestDispatcher("login.jsp").forward(request,response);
                    }
                    else
                    {
                        request.setAttribute("tienda", e);
                        request.getRequestDispatcher("catalogo.jsp").forward(request,response);
                    }
                }else if(tipo.equals("vendedorTienda"))
                    {
                        String id;
                        id=request.getParameter("txtid");
                        Tienda e = m.iniciarTiendaVendedor(id);

                        if(e==null)
                        {   
                            request.setAttribute("mensaje", "Error usuario y/o clave");
                            request.getRequestDispatcher("login.jsp").forward(request,response);
                        }
                        else
                        {
                            request.setAttribute("tienda", e);
                            request.getRequestDispatcher("displayVendedor.jsp").forward(request,response);
                        }
                    }
        }
    void listarTienda(HttpServletRequest request, HttpServletResponse
                response) throws ServletException, IOException 
    {
        List<Tienda> info=new ModeloTienda().listarTienda();
        request.setAttribute("data", info);
        request.getRequestDispatcher("menuTiendas.jsp").forward(request, response);
    }

    protected void registrarTienda(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
	//Se obtiene los parametros
		
        String nombreTienda = request.getParameter("nombreTienda");
        String longitud = request.getParameter("longitud");
        String latitud = request.getParameter("latitud");
        String estadoTienda = request.getParameter("estadoTienda");
        String telefonoTienda= request.getParameter("telefonoTienda");
        String idCalificacion = request.getParameter("idCalificacion");
        String direccionTienda = request.getParameter("direccionTienda");
        String idUsuario = request.getParameter("idUsuario");
        String idDistrito = request.getParameter("idDistrito");
        //se Crea el objeto 
        Tienda a = new Tienda();
        a.setNombreTienda(nombreTienda);
        a.setLongitud(longitud);
        a.setLatitud(latitud);
        a.setEstadoTienda(Integer.parseInt(estadoTienda));
        a.setTelefonoTienda(Integer.parseInt(telefonoTienda));
        a.setIdCalificacion(Integer.parseInt(idCalificacion));
        a.setDireccionTienda(direccionTienda);
        a.setIdUsuario(Integer.parseInt(idUsuario));
        a.setIdDistrito(Integer.parseInt(idDistrito));
                
        //Se inserta a la BD 
        ModeloTienda model = new ModeloTienda();
        model.insertaTienda(a);
            
        request.getRequestDispatcher("loginVender.jsp").forward(request,response);
    }
    
}
