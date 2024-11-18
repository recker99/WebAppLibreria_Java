<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Ingresar Libro</title>  
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"   
             integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"   
             crossorigin="anonymous">  
    </head>  
    <body>  
        <div class="container mt-5">  
            <%@include file="opciones.jsp" %>  
            <h2>Ingresar Libro</h2>  
            
            <form action="<c:url value="/AgregarLibroServlet" />" method="post">  
                <div class="mb-3">  
                    <label for="isbn" class="form-label">Isbn:</label>  
                    <input type="text" class="form-control" id="isbn" name="isbn"   
                           value="<c:out value="${libro.isbn}" />" />  
                    <div class="text-danger"><c:out value="${mapMensajes['isbn']}" /></div>  
                </div>  

                <div class="mb-3">  
                    <label for="titulo" class="form-label">Título:</label>  
                    <input type="text" class="form-control" id="titulo" name="titulo"   
                           value="<c:out value="${libro.titulo}" />" />  
                    <div class="text-danger"><c:out value="${mapMensajes['titulo']}" /></div>  
                </div>  

                <div class="mb-3">  
                    <label for="autor" class="form-label">Autor:</label>  
                    <input type="text" class="form-control" id="autor" name="autor"   
                           value="<c:out value="${libro.autor}" />" />  
                    <div class="text-danger"><c:out value="${mapMensajes['autor']}" /></div>  
                </div>  

                <div class="mb-3">  
                    <label for="editorial" class="form-label">Editorial:</label>  
                    <input type="text" class="form-control" id="editorial" name="editorial"   
                           value="<c:out value="${libro.editorial}" />" />  
                    <div class="text-danger"><c:out value="${mapMensajes['editorial']}" /></div>  
                </div>  

                <div class="mb-3">  
                    <label for="precio" class="form-label">Precio:</label>  
                    <input type="text" class="form-control" id="precio" name="precio"   
                           value="<c:out value="${libro.precio}" />" />  
                    <div class="text-danger"><c:out value="${mapMensajes['precio']}" /></div>  
                </div>  

                <button type="submit" class="btn btn-primary">Registrar</button>  
            </form>  

            <br/>  
            <div class="alert alert-info"><c:out value="${mensaje}" /></div>  
        </div>  

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"   
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"   
                crossorigin="anonymous"></script>  
    </body>  
</html>