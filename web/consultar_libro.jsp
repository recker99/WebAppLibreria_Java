<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Consultar Libros</title>  
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"   
             integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"   
             crossorigin="anonymous">  
    </head>  
    <body>  
        <%@ include file="opciones.jsp" %>  
        <div class="container mt-5">  
            <h2>Consultar Libros</h2>  

            <form action="<c:url value='/ConsultarLibroServlet' />" method="get" class="mb-4">  
                <div class="mb-3">  
                    <label for="titulo" class="form-label">Título:</label>  
                    <input type="text" name="titulo" class="form-control" id="titulo" value="${titulo}"/>  
                </div>  
                <button type="submit" class="btn btn-primary">Buscar</button>  
            </form>  
            
            <div class="alert alert-info"><c:out value="${mensaje}" /></div>  

            <br />  

            <table class="table table-bordered table-striped">  
                <thead class="table-light">  
                    <tr>  
                        <th>ID</th>  
                        <th>Isbn</th>  
                        <th>Título</th>  
                        <th>Autor</th>  
                        <th>Editorial</th>  
                        <th>Precio</th>  
                        <th>Fecha Registro</th>  
                        <th>Acción</th>  
                    </tr>  
                </thead>  
                <tbody>  
                    <c:forEach var="l" items="${lstLibros}">  
                        <tr>  
                            <td><c:out value="${l.idLibro}" /></td>  
                            <td><c:out value="${l.isbn}" /></td>  
                            <td><c:out value="${l.titulo}" /></td>  
                            <td><c:out value="${l.autor}" /></td>  
                            <td><c:out value="${l.editorial}" /></td>  
                            <td><c:out value="${l.precio}" /></td>  
                            <td><c:out value="${l.fechaRegistro}" /></td> <!-- Asegúrate de que este campo exista -->  
                            <td>  
                                <c:url var="urlEliminar" value="/ConsultarLibroServlet">  
                                    <c:param name="idLibro" value="${l.idLibro}" />  
                                </c:url>  
                                <a href="${urlEliminar}" class="text-danger">Eliminar</a>  
                            </td>  
                        </tr>  
                    </c:forEach>  
                </tbody>  
            </table>  
        </div>  

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"   
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"   
                crossorigin="anonymous"></script>  
    </body>  
</html>