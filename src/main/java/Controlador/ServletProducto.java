/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Calificacion;
import Entidad.Categoria;
import Entidad.DetallePedido;
import Entidad.Pedido;
import Entidad.Producto;
import Modelo.ModeloCalificacion;
import Modelo.ModeloProducto;
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
@WebServlet(name = "ServletProducto", urlPatterns = {"/ServletProducto"})
public class ServletProducto extends HttpServlet {

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
            out.println("<title>Servlet ServletProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletProducto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {
        String tipo=request.getParameter("tipo");
        if(tipo.equals("listarProducto"))
	{
            listarProducto(request, response);
	}else if(tipo.equals("registrarProducto"))
            {
                registrarProducto(request, response);
            }else if(tipo.equals("listarCategoria"))
                {
                    listarCategoria(request, response);
                }else if(tipo.equals("listarCatalogo"))
                    {
                        listarCatalogo(request, response);
                    }else if(tipo.equals("eliminarProducto"))
                        {
                            eliminarProducto(request, response);
                        }
                        else if(tipo.equals("actualizarProducto"))
                            {
                                actualizarProducto(request, response);
                            }
                            else if(tipo.equals("buscarProducto"))
                                {
                                    buscarProducto(request, response);
                                }else if(tipo.equals("getProducto"))
                                    {
                                        getProducto(request, response);
                                    }else if(tipo.equals("listarPedidoCliente"))
                                        {
                                            listarPedidoCliente(request, response);
                                        }else if(tipo.equals("listarDetallePedido"))
                                            {
                                                listarDetallePedido(request, response);
                                            }else if(tipo.equals("listarCatalogoMapa"))
                                                {
                                                    listarCatalogoMapa(request, response);
                                                }else if(tipo.equals("listarPedidoClienteTienda"))
                                                    {
                                                        listarPedidoClienteTienda(request, response);
                                                    }else if(tipo.equals("listarDetallePedidoTienda"))
                                                        {
                                                            listarDetallePedidoTienda(request, response);
                                                        }else if(tipo.equals("eliminarDetallePedido"))
                                                            {
                                                                eliminarDetallePedido(request, response);
                                                            }else if(tipo.equals("actualizaPedido"))
                                                                {
                                                                    actualizaPedido(request, response);
                                                                }
                                                                else if(tipo.equals("buscarPedido"))
                                                                    {
                                                                        buscarPedido(request, response);
                                                                    }else if(tipo.equals("actualizaDetalleProducto"))
                                                                        {
                                                                            actualizaDetalleProducto(request, response);
                                                                        }else if(tipo.equals("listarReporte"))
                                                                            {
                                                                                listarReporte(request, response);
                                                                            }else if(tipo.equals("buscar"))
                                                                                {
                                                                                    buscar(request, response);
                                                                                }
    }
    protected void listarProducto(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        //Se inserta a la BD el cursos
        List<Producto> info = new ModeloProducto().listarProducto(Integer.parseInt(id));
        //Se almacena en memoria llamada request
        request.setAttribute("data",info);
        //Se reenvia el request(con los datos) al jsp listaCursos.jsp
        request.getRequestDispatcher("productos.jsp").forward(request, response);
    }
    protected void listarCatalogo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        //Se inserta a la BD el cursos
        List<Producto> info = new ModeloProducto().listarProducto(Integer.parseInt(id));
        List<Calificacion> info2=new ModeloCalificacion().listarCalificacion(Integer.parseInt(id));
        //Se almacena en memoria llamada request
        request.setAttribute("data",info);
        request.setAttribute("data2",info2);
        //Se reenvia el request(con los datos) al jsp listaCursos.jsp
        request.getRequestDispatcher("/catalogo.jsp").forward(request, response);
    }
    protected void listarCatalogoMapa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("idMapa");
        //Se inserta a la BD el cursos
        List<Producto> info = new ModeloProducto().listarProducto(Integer.parseInt(id));
        //Se almacena en memoria llamada request
        request.setAttribute("data",info);
        //Se reenvia el request(con los datos) al jsp listaCursos.jsp
        request.getRequestDispatcher("/catalogo.jsp").forward(request, response);
    }
    protected void listarPedidoCliente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        //Se inserta a la BD el cursos
        List<Pedido> info = new ModeloProducto().listarPedidosCliente(Integer.parseInt(id));
        //Se almacena en memoria llamada request
        request.setAttribute("data",info);
        //Se reenvia el request(con los datos) al jsp listaCursos.jsp
        request.getRequestDispatcher("/historialCompras.jsp").forward(request, response);
    }
    protected void listarPedidoClienteTienda(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        //Se inserta a la BD el cursos
        List<Pedido> info = new ModeloProducto().listarPedidosClienteTienda(Integer.parseInt(id));
        //Se almacena en memoria llamada request
        request.setAttribute("data",info);
        //Se reenvia el request(con los datos) al jsp listaCursos.jsp
        request.getRequestDispatcher("/listarPedido.jsp").forward(request, response);
    }
    protected void listarReporte(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        //Se inserta a la BD el cursos
        List<Pedido> info = new ModeloProducto().listarPedidosClienteTienda(Integer.parseInt(id));
        //Se almacena en memoria llamada request
        request.setAttribute("data",info);
        //Se reenvia el request(con los datos) al jsp listaCursos.jsp
        request.getRequestDispatcher("/Reporte.jsp").forward(request, response);
    }
    protected void listarDetallePedido(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        //Se inserta a la BD el cursos
        List<DetallePedido> info = new ModeloProducto().listarDetallePedido(Integer.parseInt(id));
        //Se almacena en memoria llamada request
        request.setAttribute("data",info);
        //Se reenvia el request(con los datos) al jsp listaCursos.jsp
        request.getRequestDispatcher("/detallePedido.jsp").forward(request, response);
    }
    protected void listarDetallePedidoTienda(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        //Se inserta a la BD el cursos
        List<DetallePedido> info = new ModeloProducto().listarDetallePedido(Integer.parseInt(id));
        //Se almacena en memoria llamada request
        request.setAttribute("data",info);
        //Se reenvia el request(con los datos) al jsp listaCursos.jsp
        request.getRequestDispatcher("/detallePedidoTienda.jsp").forward(request, response);
    }
    private void listarCategoria(HttpServletRequest request, HttpServletResponse
                response) throws ServletException, IOException 
    {
        List<Categoria> info=new ModeloProducto().listarCategoria();
        request.setAttribute("data", info);
        request.getRequestDispatcher("insertarProducto.jsp").forward(request, response);
    }
    
    protected void registrarProducto(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
	//Se obtiene los parametros
        
        String nombreProducto = request.getParameter("nombreProducto");
        String precioProducto = request.getParameter("precioProducto");
        String imgProducto = request.getParameter("imgProducto");
        String descripcionProducto = request.getParameter("descripcionProducto");
        String estadoProducto= request.getParameter("estadoProducto");
        String marcaProducto = request.getParameter("marcaProducto");
        String unidadDeMedida = request.getParameter("unidadDeMedida");
        String idCategoria = request.getParameter("idCategoria");
        String idTienda = request.getParameter("idTienda");
        //se Crea el objeto 
        Producto a = new Producto();
        a.setNombreProducto(nombreProducto);
        a.setPrecioProducto(Double.parseDouble(precioProducto));
        a.setImgProducto(imgProducto);
        a.setDescripcionProducto(descripcionProducto);
        a.setEstadoProducto(Integer.parseInt(estadoProducto));
        a.setMarcaProducto(marcaProducto);
        a.setUnidadDeMedida(unidadDeMedida);
        a.setIdCategoria(Integer.parseInt(idCategoria));
        a.setIdTienda(Integer.parseInt(idTienda));
                
        //Se inserta a la BD 
        
        ModeloProducto model = new ModeloProducto();
        model.insertaProducto(a);
            
        request.getRequestDispatcher("productos.jsp").forward(request, response);
    }
    protected void eliminarProducto(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("id");
		
        //Se inserta a la BD el cursos
        ModeloProducto model = new ModeloProducto();
        model.eliminaProducto(Integer.parseInt(id));
        //Se lista todos los cursos
        listarProducto(request, response);
    }
    protected void eliminarDetallePedido(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("id");
		
        //Se inserta a la BD el cursos
        ModeloProducto model = new ModeloProducto();
        model.eliminaDetalleProducto(Integer.parseInt(id));
        //Se lista todos los cursos
        listarPedidoClienteTienda(request, response);
    }
    protected void actualizarProducto(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
    {
        //Se obtiene los parametros}
        String nombreProducto = request.getParameter("nombreProducto");
        String precioProducto = request.getParameter("precioProducto");
        String imgProducto = request.getParameter("imgProducto");
        String descripcionProducto = request.getParameter("descripcionProducto");
        String estadoProducto = request.getParameter("estadoProducto");
        String marcaProducto = request.getParameter("marcaProducto");
        String unidadDeMedida = request.getParameter("unidadDeMedida");
        String idCategoria = request.getParameter("idCategoria");
        String idTienda = request.getParameter("idTienda");
                
        String id = request.getParameter("id");
		
        //se Crea el objeto cursos
        Producto a = new Producto();
        a.setIdProducto(Integer.parseInt(id));
        a.setNombreProducto(nombreProducto);
        a.setPrecioProducto(Double.parseDouble(precioProducto));
        a.setImgProducto(imgProducto);
        a.setDescripcionProducto(descripcionProducto);
        a.setEstadoProducto(Integer.parseInt(estadoProducto));
        a.setMarcaProducto(marcaProducto);
        a.setUnidadDeMedida(unidadDeMedida);
        a.setIdCategoria(Integer.parseInt(idCategoria));
        a.setIdTienda(Integer.parseInt(idTienda));

        //Se inserta a la BD el cursos
        ModeloProducto model = new ModeloProducto();
        model.actualizaProducto(a);

        //Se lista todos los cursos
        listarProducto(request, response);
				
    }
    protected void buscarProducto(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("id");

        //Se inserta a la BD el cursos
        ModeloProducto model = new ModeloProducto();
        Producto a = model.buscaProducto(Integer.parseInt(id));

        //Se almacena en memoria llamada request
        request.setAttribute("data",a);

        //Se reenvia el request(con los datos) al jsp listaCursos.jsp
        request.getRequestDispatcher("/actualizaProducto.jsp").forward(request, response);

    }
    protected void getProducto(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("id");

        //Se inserta a la BD el cursos
        ModeloProducto model = new ModeloProducto();
        Producto a = model.getProducto(Integer.parseInt(id));

        //Se almacena en memoria llamada request
        request.setAttribute("data",a);

        //Se reenvia el request(con los datos) al jsp listaCursos.jsp
        request.getRequestDispatcher("/detalleProducto.jsp").forward(request, response);

    }
    protected void actualizaPedido(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
    {
        //Se obtiene los parametros}
        String fechaPedido = request.getParameter("fechaPedido");
        String totalPrecio = request.getParameter("totalPrecio");
        String idEstadoPedido = request.getParameter("idEstadoPedido");
        String idPago = request.getParameter("idPago");
        String idUsuario = request.getParameter("idUsuario");
        String direccionPedido = request.getParameter("direccionPedido");
        String horaEntrega = request.getParameter("horaEntrega");
        String fechaEntrega = request.getParameter("fechaEntrega");
        String idTienda = request.getParameter("idTienda");
                
        String id = request.getParameter("id");
		
        //se Crea el objeto cursos
        Pedido a = new Pedido();
        a.setIdPedido(Integer.parseInt(id));
        a.setFechaPedido(fechaPedido);
        a.setTotalPrecio(Double.parseDouble(totalPrecio));
        a.setIdEstadoPedido(Integer.parseInt(idEstadoPedido));
        a.setIdPago(Integer.parseInt(idPago));
        a.setIdUsuario(Integer.parseInt(idUsuario));
        a.setDireccionPedido(direccionPedido);
        a.setHoraEntrega(horaEntrega);
        a.setFechaEntrega(fechaEntrega);
        a.setIdTienda(Integer.parseInt(idTienda));

        //Se inserta a la BD el cursos
        ModeloProducto model = new ModeloProducto();
        model.actualizaPedido(a);

        //Se lista todos los cursos
        listarPedidoClienteTienda(request, response);
				
    }
    protected void buscarPedido(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("id");

        //Se inserta a la BD el cursos
        ModeloProducto model = new ModeloProducto();
        Pedido a = model.buscaPedido(Integer.parseInt(id));

        //Se almacena en memoria llamada request
        request.setAttribute("data",a);

        //Se reenvia el request(con los datos) al jsp listaCursos.jsp
        request.getRequestDispatcher("/atenderPedido.jsp").forward(request, response);

    }
    protected void buscar(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, IOException 
    {
        //Se obtiene los parametros
        String id = request.getParameter("id");
        String dato = request.getParameter("txtBuscar");
        //Se inserta a la BD el cursos
        if(dato==""){
            List<Producto> info = new ModeloProducto().listarProducto(Integer.parseInt(id));
            List<Calificacion> info2=new ModeloCalificacion().listarCalificacion(Integer.parseInt(id));
            //Se almacena en memoria llamada request
            request.setAttribute("data",info);
            request.setAttribute("data2",info2);
            //Se reenvia el request(con los datos) al jsp listaCursos.jsp
            request.getRequestDispatcher("/catalogo.jsp").forward(request, response);
        }else{
            List<Producto> info = new ModeloProducto().buscar(Integer.parseInt(id),dato);
            List<Calificacion> info2=new ModeloCalificacion().listarCalificacion(Integer.parseInt(id));
            //Se almacena en memoria llamada request
            request.setAttribute("data",info);
            //Se reenvia el request(con los datos) al jsp listaCursos.jsp
            request.getRequestDispatcher("/catalogo.jsp").forward(request, response);
        }
    }
    protected void actualizaDetalleProducto(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
    {
        //Se obtiene los parametros}
        String cantidad = request.getParameter("cantidad");
        String precio = request.getParameter("precio");
        String id = request.getParameter("id");
		
        //se Crea el objeto cursos
        DetallePedido a = new DetallePedido();
        a.setIdDetallePedido(Integer.parseInt(id));
        a.setCantida(Integer.parseInt(cantidad));
        a.setPrecio(Double.parseDouble(precio));

        //Se inserta a la BD el cursos
        ModeloProducto model = new ModeloProducto();
        model.actualizaDetalleProducto(a);

        //Se lista todos los cursos
        listarPedidoClienteTienda(request, response);
				
    }
}
