/* Capa Controllers:*/
// Captura parámetros

package com.udep.sin2021.appsin.controllers;

import com.udep.sin2021.appsin.beans.Usuario;
import com.udep.sin2021.appsin.services.UsuarioServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

    
public class ServletValidaUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Recojo los parámetros enviados por el form de la página precedente
            String user = request.getParameter("usuario");
            String clave = request.getParameter("clave");

            //Creo un nuevo Usuario
            Usuario usuario = new Usuario();
            usuario.setNombreusuario(user);
            usuario.setClave(clave);
            
            //Creo un nuevo UsuarioServices
            UsuarioServices us = new UsuarioServices();
            int rpta = us.buscarUsuario(user, clave, usuario);

            switch (rpta) {
                case 404:
                    /*Si no hay resultados, lanza una alerta y se dirige al mismo login*/
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('No hay conexión con la base de datos MySQL');");
                    out.println("location='index.jsp';");
                    out.println("</script>");
                    break;
                case 0:
                    /*Si no hay resultados, lanza una alerta y se dirige al mismo login*/
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Usuario o contraseña no existe');");
                    out.println("location='index.jsp';");
                    out.println("</script>");
                    break;
                default:
                    //Si hay resultados, guarda los atributos del mismo usuario, para luego invocarlo
                    String nombre = usuario.getNombre();
                    String apellidos = usuario.getApellido();
                    //Guarda nombre y apellidos en toda la sesión
                    HttpSession session = request.getSession();
                    session.setAttribute("nombre",nombre);
                    session.setAttribute("apellidos",apellidos);
                    //System.out.println( left(nombre,3) );
                    //System.out.println(left(apellidos,3) );
                    //Se dirige a la página inicio
                    response.sendRedirect(request.getContextPath() + "/jsp/inicio.jsp");
                    break;
            }
        }
        
        // Capturo parametros
        // Construye bean, instancia de alumno. Con los setter añade los parámetros
        
        // En caso se cambie el DBMS, crear un nuevo DAO y la librería
        // Capa DAO: "Lo que estaba dentro del traje era distinto", y podemos tener objetos intercambiables sin afectar a las otras capas
        // Con getParameterMap devuelve todos los parámetros en una línea
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletValidaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletValidaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletValidaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletValidaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
