
package com.emergente;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obtener acceso al objeto  session
        HttpSession ses = request.getSession();
        //se elemina la sesion
        ses.invalidate();
        //transfiere el control a index.jsp
        response.sendRedirect("index.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera el producto enviado desde formulario
        
        String producto = request.getParameter("producto");
        //se obtiene el acceso a la session
        HttpSession ses = request.getSession();
        //se obtiene la lista que seta como atributo de session
        ArrayList<String>  lista = ( ArrayList<String>)ses.getAttribute("lista");
         //a la coleccion se adiciona el elemento
        lista.add(producto);
        //se redirecciona a index.jsp
        response.sendRedirect("index.jsp");
       
    }

    

}
