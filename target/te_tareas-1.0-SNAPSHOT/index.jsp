
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.Tarea"%>
<%
if (session.getAttribute("almacen") == null){
    ArrayList<Tarea> lisaux = new ArrayList<Tarea>();
    session.setAttribute("almacen", lisaux);
    
}
ArrayList<Tarea> almacen= (ArrayList<Tarea>)session.getAttribute("almacen");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tareas pendientes</h1>
        <form action="Servlet" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="0" size="2"></td>
                    </tr>
                <tr>
                    <td>Tarea</td>
                    <td><input type="text" name="tarea" value=""></td>
                   
                </tr>
                
                
                <tr>
                    <td></td>
                    <td><input type="submit" value="Procesar"></td>
                    
                </tr>
                
            </table>
            
        </form>
        <a href="Servlet?op=nuevo">Nuevo</a>
        <h2>Contenido de la tarea</h2>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Tarea</th>
                <th>Completado</th>
                <th></th>
            </tr> 
            <%
            if (almacen != null){
                for (Tarea p : almacen){
                
                
            
            %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getTarea() %></td>
                <td><input type="checkbox"></td>
                <td><a href="Servlet?op=eliminar&id=<%= p.getId()%>">Eliminar</a></td>
            </tr>
            <%
                }
}
            %>
        </table>
    </body>
</html>
