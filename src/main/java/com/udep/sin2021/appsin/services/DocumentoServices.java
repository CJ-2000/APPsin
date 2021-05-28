/* Capa Services:*/
// Devuelve el resultado de la capa de persistencia o DAO
// Deben estar todos los métodos de la capa DAO

// Si afecta el contenido de la BD, pensar en incluir el concepto de TRANSACCIONES
// También se ve lógica como validaciones

package com.udep.sin2021.appsin.services;

import com.udep.sin2021.appsin.dao.DocumentoDao;
import java.sql.SQLException;

public class DocumentoServices {
    private DocumentoDao documentoDao = new DocumentoDao(); 
    
    public int RegistraDocumento(String codigo, String nombre, String version, String fecha, String ruta, String icono, String tipo, String area, String unidad_negocio) throws SQLException, ClassNotFoundException{
        return documentoDao.RegistraDocumento(codigo,nombre,version,fecha,ruta,icono,tipo,area,unidad_negocio);
        
    }
}
