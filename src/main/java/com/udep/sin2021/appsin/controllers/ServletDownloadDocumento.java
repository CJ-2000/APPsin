/* Capa Controllers:*/
// Captura parámetros

package com.udep.sin2021.appsin.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDownloadDocumento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        // Extrae parámetro "nombre" del archivo desde la tabla anterior. Ejemplo: "documento.xlsx"
        String nombre_archivo = request.getParameter("nombre"); 
        // Ruta de la carpeta destino donde se va a descargar el archivo
        String ruta_destino = "d:/aplicacion/"; 

        // Package Utilitys, clases con constantes como "rutas"
        // iReport crea reportes (jasperreports) : template->BD / jxrml (plantilla) dentro de carpeta wildfly/ 
        // Llamar a la plantilla con servlet
        
        // reportes: índice de documentos solicitados

        // Establece el tipo de archivo de manera general. Ejemplo: Para imagen sería ("image/png")
        response.setContentType("application/octet-stream");  
        // Solo guarda el archivo, no lo va a mostrar
        response.setHeader("Content-Disposition","attachment; filename=\"" + nombre_archivo + "\"");   
        
        
        File f = new File(ruta_destino + nombre_archivo);        
         // Esto debe enviar el archivo al navegador
         OutputStream out = response.getOutputStream();
         FileInputStream in = new FileInputStream(f);
         byte[] buffer = new byte[4096];
         int length;
         while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
         }
         in.close();
         out.flush();        

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
