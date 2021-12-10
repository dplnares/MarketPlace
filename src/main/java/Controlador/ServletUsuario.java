/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Distrito;
import Entidad.Usuario;
import Modelo.ModeloUsuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends HttpServlet {

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
            out.println("<title>Servlet ServletUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    Modelo.ModeloUsuario m = new ModeloUsuario();
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {
        String tipo=request.getParameter("tipo");
        if(tipo.equals("listarDistritoCliente"))
	{
            listarDistritoCliente(request, response);
	}
        else if(tipo.equals("registrarUsuario"))
            {
                registrarUsuario(request, response);
            }else if(tipo.equals("listarDistritoVendedor"))
            {
                listarDistritoVendedor(request, response);
            }else if(tipo.equals("registrarVendedor"))
            {
                registrarVendedor(request, response);
            }else if(tipo.equals("siguiente"))
            {
                String usuario,clave,rol;
                usuario=request.getParameter("txtlogin");
                clave=request.getParameter("txtpass");
                rol=request.getParameter("txtrol");
                Usuario e = m.iniciarSesion(usuario, clave, rol);

                if(e==null)
                {   
                    request.setAttribute("mensaje", "Error usuario y/o clave");
                    request.getRequestDispatcher("validarVendedor.jsp").forward(request,response);
                }
                else
                {
                    request.setAttribute("usuario", e);
                    listarDistritoTienda(request, response);
                }
            }
    }
    private void listarDistritoCliente(HttpServletRequest request, HttpServletResponse
                response) throws ServletException, IOException 
    {
        List<Distrito> info=new ModeloUsuario().listarDistritos();
        request.setAttribute("data", info);
        request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
    }
    private void listarDistritoVendedor(HttpServletRequest request, HttpServletResponse
                response) throws ServletException, IOException 
    {
        List<Distrito> info=new ModeloUsuario().listarDistritos();
        request.setAttribute("data", info);
        request.getRequestDispatcher("registrarVendedor.jsp").forward(request, response);
    }
    private void listarDistritoTienda(HttpServletRequest request, HttpServletResponse
                response) throws ServletException, IOException 
    {
        List<Distrito> info=new ModeloUsuario().listarDistritos();
        request.setAttribute("data", info);
        request.getRequestDispatcher("registrarTienda.jsp").forward(request, response);
    }
    
    protected void registrarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
	//Se obtiene los parametros
		
        String nombresUsuario = request.getParameter("nombresUsuario");
        String apellidosUsuario = request.getParameter("apellidosUsuario");
        String telefonoUsuario = request.getParameter("telefonoUsuario");
        String correoUsuario = request.getParameter("correoUsuario");
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("clave");
        String dniUsuario = request.getParameter("dniUsuario");
        String direccionUsuario = request.getParameter("direccionUsuario");
        String idDistrito = request.getParameter("idDistrito");
        String idRol = request.getParameter("idRol");
        //se Crea el objeto 
        Usuario a = new Usuario();
        a.setNombresUsuario(nombresUsuario);
        a.setApellidosUsuario(apellidosUsuario);
        a.setTelefonoUsuario(Integer.parseInt(telefonoUsuario));
        a.setCorreoUsuario(correoUsuario);
        a.setUsuario(usuario);
        a.setClave(contraseña);
        a.setDniUsuario(Integer.parseInt(dniUsuario));
        a.setDireccionUsuario(direccionUsuario);
        a.setIdDistrito(Integer.parseInt(idDistrito));
        a.setIdRol(Integer.parseInt(idRol));
                
        //Se inserta a la BD 
        ModeloUsuario model = new ModeloUsuario();
        model.insertaUsuario(a);
            
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    protected void registrarVendedor(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
	//Se obtiene los parametros
		
        String nombresUsuario = request.getParameter("nombresUsuario");
        String apellidosUsuario = request.getParameter("apellidosUsuario");
        String telefonoUsuario = request.getParameter("telefonoUsuario");
        String correoUsuario = request.getParameter("correoUsuario");
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("clave");
        String dniUsuario = request.getParameter("dniUsuario");
        String direccionUsuario = request.getParameter("direccionUsuario");
        String idDistrito = request.getParameter("idDistrito");
        String idRol = request.getParameter("idRol");
        //se Crea el objeto 
        Usuario a = new Usuario();
        a.setNombresUsuario(nombresUsuario);
        a.setApellidosUsuario(apellidosUsuario);
        a.setTelefonoUsuario(Integer.parseInt(telefonoUsuario));
        a.setCorreoUsuario(correoUsuario);
        a.setUsuario(usuario);
        a.setClave(contraseña);
        a.setDniUsuario(Integer.parseInt(dniUsuario));
        a.setDireccionUsuario(direccionUsuario);
        a.setIdDistrito(Integer.parseInt(idDistrito));
        a.setIdRol(Integer.parseInt(idRol));
                
        //Se inserta a la BD 
        ModeloUsuario model = new ModeloUsuario();
        model.insertaUsuario(a);
        
        request.getRequestDispatcher("validarVendedor.jsp").forward(request,response);
    }

}
