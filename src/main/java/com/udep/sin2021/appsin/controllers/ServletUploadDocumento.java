/* Capa Controllers:*/
// Captura parámetros

package com.udep.sin2021.appsin.controllers;

import com.udep.sin2021.appsin.services.DocumentoServices;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import static org.apache.commons.lang3.StringUtils.right;

@MultipartConfig
public class ServletUploadDocumento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        // Extrae archivo del form
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String version = request.getParameter("version");
        String fecha = request.getParameter("fecha");
        String area = request.getParameter("area");
        String ruta = null;
        String icono = null;                
        String tipo = request.getParameter("tipo");        
        String unidad_negocio = request.getParameter("unidad_negocio");        
        
        Part filePart = request.getPart("file"); 
        
        // Arreglo 'MSIE' para extraer el nombre del archivo con su extensión. Ejemplo: "Documento.docx"
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 
        // Defino ruta para almacenar los archivos cargados
        String uploads = "d:/aplicacion" ; 
        File file = new File(uploads, fileName);
        //System.out.println(right(fileName,4) );
        switch (right(fileName,4)) {
            case "xlsx":
                {
                    ruta = ".xlsx";
                    icono = "iconos/excel-24.png";
                    break;
                }
            case ".pdf":
                {
                    ruta = ".pdf";
                    icono = "iconos/pdf-24.png";
                    break;            
                }
            case "pptx":
                {
                    ruta = ".pptx";
                    icono = "iconos/powerpoint-24.png";
                    break;
                }
            case "docx":
                {
                    ruta = ".docx";
                    icono = "iconos/word-24.png";
                    break;
                }
            default:
                break;
        }
        
        //System.out.println(icono);
        
        try (InputStream fileContent = filePart.getInputStream()) {
            /*Inserta los datos a la BD*/
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                
                // Crea un nuevo DocumentoServices
                DocumentoServices ds = new DocumentoServices();
                int rpta = ds.RegistraDocumento(codigo, nombre, version, fecha, ruta, icono, tipo, area, unidad_negocio) ;
                
                if (rpta == 0){
                    /* retorna respuesta: tabla */
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error. No se pudo registrar');");
                    out.println("location='jsp/registro.jsp';");
                    out.println("</script>");                    
                } else {
                    /*Lanza una alerta en javascript*/                    
                    Files.copy(fileContent, file.toPath()); //Copia los archivos a la locación destino
                    
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('El archivo se subió correctamente');");
                    out.println("location='jsp/inicio.jsp';");
                    out.println("</script>");                    
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletUploadDocumento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletUploadDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletUploadDocumento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletUploadDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
