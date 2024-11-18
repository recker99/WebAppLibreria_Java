/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LibreriaService;

/**
 *
 * @author ivanb
 */
@WebServlet(name = "ConsultarLibroServlet", urlPatterns = {"/ConsultarLibroServlet"})
public class ConsultarLibroServlet extends HttpServlet {

    
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
            out.println("<title>Servlet ConsultarLibroServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultarLibroServlet at " + request.getContextPath() + "</h1>");
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
                String titulo = request.getParameter("titulo");
                String idLibro = request.getParameter("idLibro");

                if (idLibro != null) {
                    Long idLibroLong = Long.parseLong(idLibro);
                    service.eliminarLibro(idLibroLong);
                    request.setAttribute("mensaje", "Libro eliminado con éxito");
                }

                if (titulo == null || titulo.isEmpty()) {
                    request.setAttribute("lstLibros", service.buscarLibroTodos());
                } else {
                    request.setAttribute("lstLibros", service.buscarLibroTitulo(titulo));
                }
                request.setAttribute("titulo",titulo);
                request.getRequestDispatcher("/consultar_libro.jsp").forward(request, response);
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
        
                    Long IdLibro = null;
                    String idLibroParam = request.getParameter("IdLibro");
                    
                    if (idLibroParam != null && !idLibroParam.isEmpty()) {
                        IdLibro = Long.parseLong(idLibroParam);
                    } else {
                        System.out.println("No se ha enviado el parámetro IdLibro");
                    }

                    if (IdLibro != null) {
                        service.eliminarLibro(IdLibro);
                        request.setAttribute("mensaje", "Libro eliminado con éxito");
                    } else {
                        request.setAttribute("mensaje", "No se pudo eliminar el libro");
                    }


                   String titulo = request.getParameter("titulo");
                   if (titulo == null || titulo.isEmpty()) {
                       request.setAttribute("lstLibros", service.buscarLibroTodos());
                   } else {
                       request.setAttribute("lstLibros", service.buscarLibroTitulo(titulo));
                   }
                   request.setAttribute("titulo",titulo); 
                   request.getRequestDispatcher("/consultar_libro.jsp").forward(request, response);
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
