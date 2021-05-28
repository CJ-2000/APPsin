/* Capa Services:*/
// Devuelve el resultado de la capa de persistencia o DAO
// Deben estar todos los métodos de la capa DAO

// Si afecta el contenido de la BD, pensar en incluir el concepto de TRANSACCIONES
// También se ve lógica como validaciones

package com.udep.sin2021.appsin.services;

import com.udep.sin2021.appsin.beans.Usuario;
import com.udep.sin2021.appsin.dao.UsuarioDao;
import java.sql.SQLException;

public class UsuarioServices {
    private UsuarioDao usuarioDao = new UsuarioDao();
    
    public int buscarUsuario(String nombreusuario, String clave, Usuario usuario) throws ClassNotFoundException, SQLException{    
        return usuarioDao.buscarUsuario(nombreusuario, clave, usuario);
    }
    
}
