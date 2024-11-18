<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html lang="es">  
<head>  
    <meta charset="UTF-8">  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"   
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"   
          crossorigin="anonymous">  
    <title>Librería</title>  
</head>  
<body>  
    <div class="container text-center mt-4">  
        <h1>Librería</h1>  
        <p>  
            Opciones:   
            <a href="<c:url value='/AgregarLibroServlet' />">Ingresar Libro</a>   
            |   
            <a href="<c:url value='/ConsultarLibroServlet' />">Consultar Libro</a>  
        </p>  
        <hr />  
    </div>  

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"   
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"   
            crossorigin="anonymous"></script>  
</body>  
</html>