/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidad.Calificacion;
import Modelo.ModeloCalificacion;
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
@WebServlet(name = "ServletCalificacion", urlPatterns = {"/ServletCalificacion"})
public class ServletCalificacion extends HttpServlet {

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
            out.println("<title>Servlet ServletCalificacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCalificacion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {
        String tipo=request.getParameter("tipo");
        if(tipo.equals("listarCalificacion"))
	{
            
	}else if(tipo.equals("registrarCalificacion"))
            {
                registrarCalificacion(request, response);
            }
    }
    protected void registrarCalificacion(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
	//Se obtiene los parametros
        
        String calificacion = request.getParameter("calificacion");
        String comentario = request.getParameter("comentario");
        String fechaCalificacion = request.getParameter("fechaCalificacion");
        String idUsuario = request.getParameter("idUsuario");
        String idTienda = request.getParameter("idTienda");
        //se Crea el objeto 
        Calificacion a = new Calificacion();
        a.setCalificacion(Integer.parseInt(calificacion));
        a.setComentario(comentario);
        a.setFechaCalificacion(fechaCalificacion);
        a.setIdUsuario(Integer.parseInt(idUsuario));
        a.setIdTienda(Integer.parseInt(idTienda));
                
        //Se inserta a la BD 
        
        ModeloCalificacion model = new ModeloCalificacion();
        model.insertarCalificacion(a);
            
        request.getRequestDispatcher("catalogo.jsp").forward(request, response);
    }

}
