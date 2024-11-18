/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import dto.LibroDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LibreriaService;
import service.ServicioException;

/**
 *
 * @author ivanb
 */
@WebServlet(name = "AgregarLibroServlet", urlPatterns = {"/AgregarLibroServlet"})
public class AgregarLibroServlet extends HttpServlet {

    
     @EJB
    private LibreriaService service;
     
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
            out.println("<title>Servlet AgregarLibroServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarLibroServlet at " + request.getContextPath() + "</h1>");
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
                LibroDTO libro = new LibroDTO();

                request.setAttribute("libro", libro);
                request.getRequestDispatcher("/ingresar_libro.jsp").forward(request, response);
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
                request.setCharacterEncoding("UTF-8");

                   LibroDTO libro = new LibroDTO();
                   Map<String, String> mapMensajes = new HashMap<>();
                   String mensaje;

                   // convertir y validar
                   String isbn = request.getParameter("isbn");
                   if (isbn.isEmpty()) {
                       mapMensajes.put("isbn", "Favor, Ingrese Isbn");
                   } else {
                       libro.setIsbn(isbn);
                   }

                   String titulo = request.getParameter("titulo");
                   if (titulo.isEmpty()) {
                       mapMensajes.put("titulo", "Favor, Ingrese Titulo");
                   } else {
                       libro.setTitulo(titulo);
                   }

                   String autor = request.getParameter("autor");     
                   if (autor.isEmpty()) {
                       mapMensajes.put("autor", "Favor, Ingrese Autor");
                   } else {
                       libro.setAutor(autor);
                   }

                     String editorial = request.getParameter("editorial");     
                   if (editorial.isEmpty()) {
                       mapMensajes.put("editorial", "Favor, Ingrese Editorial");
                   } else {
                       libro.setEditorial(editorial);
                   }

                   try {
                       int precio = Integer.parseInt(request.getParameter("precio"));
                       if (precio <= 0) {
                           mapMensajes.put("precio", "Favor, Ingrese Valor para precio Positivo");
                       } else {
                           libro.setPrecio(precio);
                       }
                   } catch (NumberFormatException ex) {
                       mapMensajes.put("precio", "Precio no es válido: " + request.getParameter("Precio"));
                   }

                   // delegarla logica de negocio
                   if (mapMensajes.isEmpty()) {
                       try {
                           service.agregarLibro(libro);
                           mensaje = "Libro agregado exitosamente";
                       } catch (ServicioException ex) {
                           mensaje = ex.getMessage();
                       }
                   } else {
                       mensaje = "Favor, revise el formulario";
                   }

                   request.setAttribute("mapMensajes", mapMensajes);
                   request.setAttribute("mensaje", mensaje);
                   request.setAttribute("libro", libro);
                   request.getRequestDispatcher("/ingresar_libro.jsp").forward(request, response);
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
