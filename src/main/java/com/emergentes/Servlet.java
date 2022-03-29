
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op =request.getParameter("op");
        if (op.equals("nuevo")){
        
        
        HttpSession ses = request.getSession();
        ses.invalidate();
        response.sendRedirect("index.jsp");
    }
        if (op.equals("eliminar")){
            int pos = -1;
            int buscado = -1;
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Tarea> lista = (ArrayList<Tarea>)ses.getAttribute("almacen");
        for (Tarea p : lista){
            pos++;
            if (p.getId()== id){
                buscado = pos;
                
                }
            }
        lista.remove(buscado);
        response.sendRedirect("index.jsp");
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    int id = Integer.parseInt(request.getParameter("id"));
       String tarea = request.getParameter("tarea");
       String completado = request.getParameter("completado");
       
       
       Tarea tar = new Tarea();
       tar.setId(id);
       tar.setTarea(tarea);
       tar.setCompletado(completado);
       
       
       HttpSession ses = request.getSession();
       
       ArrayList<Tarea> lista = (ArrayList<Tarea>)ses.getAttribute("almacen");
       lista.add(tar);
       response.sendRedirect("index.jsp");
    }

  
}
