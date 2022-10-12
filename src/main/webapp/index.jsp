<%@page import="java.util.ArrayList"%>
<%
    
    //verificar si existe la coleccion en el objeto sesseion 
    if (session.getAttribute("lista")==null) {
            //inicializar la lista auxiliar
            
            ArrayList<String> lis = new ArrayList<String>();
            
            //craando un atributo con una coleccion vacia
            session.setAttribute("lista", lis);
        }
    //se obtiene la coleccion lista que esta como atributo de session
    ArrayList<String> lista = (ArrayList<String>)session.getAttribute("lista");
%>    

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carrito de compras</h1>
        
        <p>Inserte los productos que desea</p>
        
        <form action="ProcesaServlet" method="post">

            Producto: <input type="text" name="producto">

            <input type="submit" value="Enviar">



        </form>
        <br>

        <a href="ProcesaServlet">Vaciar el carrito</a>
        <h3>Contenido del carrito</h3>

        <ul>
            <%
                if (lista !=null) {
                        for (String item : lista) {
                                out.print("<li>"+item+"</li>");
                            }
                    }
                %>
        </ul>
    </body>
</html>
