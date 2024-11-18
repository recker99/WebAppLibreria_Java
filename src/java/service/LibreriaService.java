/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dominio.Libro;
import dto.LibroDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ivanb
 */

@Stateless
public class LibreriaService {
     @PersistenceContext
     private EntityManager em;
     
     public LibreriaService() {
        // Constructor vacío
    }

     
     public void agregarLibro(LibroDTO dto) throws ServicioException {
         // Verificar si el libro ya existe usando otros parámetros únicos, como ISBN, si es necesario  
    if (buscarLibroPorIsbn(dto.getIsbn()) != null) {
        throw new ServicioException("Ya existe un libro con el ISBN: " + dto.getIsbn());
    }

    Libro l = new Libro();
    l.setIsbn(dto.getIsbn());
    l.setTitulo(dto.getTitulo());
    l.setAutor(dto.getAutor());
    l.setEditorial(dto.getEditorial());
    l.setPrecio(dto.getPrecio());
    l.setFechaRegistro(new Date()); // Establecer la fecha de registro


    em.persist(l);
    em.flush(); // Añadido para detectar errores en el momento de la persistencia
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Libro> buscarLibroPorId(Long IdLibro) {
        List<Libro> lstLibros = new ArrayList<>();
        Libro l = null;
        try {
            l = em.createNamedQuery("Libro.findByIdLibro", Libro.class)
                    .setParameter("idLibro", IdLibro)
                    .getSingleResult();
            lstLibros.add(l);
        } catch (NoResultException ex) {
            // No se encontró ningún libro con el ID especificado
        } catch (NonUniqueResultException ex) {
            // Existe más de un libro con el ID especificado
            throw ex;
        }
        return lstLibros;
    }


    public void eliminarLibro(Long IdLibro) {
        Libro l = em.find(Libro.class, IdLibro);
        em.remove(l);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Libro> buscarLibroTodos() {
        return em.createNamedQuery("Libro.findAll", Libro.class)
                .getResultList();

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Libro> buscarLibroTitulo(String titulo) {
        return em.createNamedQuery("Libro.findByTitulo", Libro.class)
                .setParameter("titulo", titulo)
                .getResultList();
    }

    // Método para buscar por ISBN, opcionalmente puede evitar duplicados  
    private Libro buscarLibroPorIsbn(String isbn) {  
    try {  
        return em.createNamedQuery("Libro.findByIsbn", Libro.class)  
                .setParameter("isbn", isbn)  
                .getSingleResult();  
    } catch (NoResultException e) {  
        return null;  
    } catch (NonUniqueResultException e) {  
        throw e;  
    }  
}  
}
