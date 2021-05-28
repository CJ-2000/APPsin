/* Capa Controllers:*/
// Captura parámetros

package com.udep.sin2021.appsin.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletCerrarSesion extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        // Remueve el atributo "nombre"
        HttpSession session = request.getSession();
        session.removeAttribute("nombre");
        session.invalidate();
        
        //Muestra alerta de sesión cerrada
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Cierre de sesión correcto');");
        out.println("location='index.jsp';");
        out.println("</script>");    
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
