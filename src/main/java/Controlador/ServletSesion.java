/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Tienda;
import Entidad.Usuario;
import Modelo.ModeloTienda;
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
@WebServlet(name = "ServletSesion", urlPatterns = {"/ServletSesion"})
public class ServletSesion extends HttpServlet {

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
            out.println("<title>Servlet ServletSesion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletSesion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    Modelo.ModeloUsuario m = new ModeloUsuario();
    Modelo.ModeloTienda obtener = new ModeloTienda();
    public ServletSesion()
    {
        super();
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {
        String tipo=request.getParameter("tipo");
        if(tipo.equals("sesionCliente"))
	{
            String usuario,clave,rol;
            usuario=request.getParameter("txtlogin");
            clave=request.getParameter("txtpass");
            rol=request.getParameter("txtrol");
            Usuario e = m.iniciarSesion(usuario, clave, rol);

            if(e==null)
            {   
                request.setAttribute("mensaje", "Error usuario y/o clave");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
            else
            {
                request.setAttribute("usuario", e);
                List<Tienda> info=new ModeloTienda().listarTienda();
                request.setAttribute("data", info);
                request.getRequestDispatcher("menuTiendas.jsp").forward(request, response);

                //response.sendRedirect("menu.jsp");
            }
	}else if(tipo.equals("sesionVendedor"))
        {
            String usuario,clave,rol;
            usuario=request.getParameter("txtlogin");
            clave=request.getParameter("txtpass");
            rol=request.getParameter("txtrol");
            Usuario e = m.iniciarSesion(usuario, clave, rol);

            if(e==null)
            {   
                request.setAttribute("mensaje", "Error usuario y/o clave");
                request.getRequestDispatcher("loginVender.jsp").forward(request,response);
            }
            else
            {
                request.setAttribute("usuario", e);
                request.getRequestDispatcher("inicioVendedor.jsp").forward(request,response);

                //response.sendRedirect("menu.jsp");
            }
        }
    }
}
