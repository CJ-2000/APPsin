/* Capa Persistencia o DAO:*/
// Toma la BD y crea un objeto

package com.udep.sin2021.appsin.dao;

import com.udep.sin2021.appsin.beans.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDao {
    //Esta clase contiene métodos que devuelven entero, lista o algún otro tipo de dato
    
    public int buscarUsuario(String nombreusuario, String clave, Usuario u1) throws ClassNotFoundException, SQLException{    
        //Este método se usa para validar al usuario. Es necesario contar con los parámetros asignados
        //Retorna valor int: 0 o 1
        try (Connection con = ConectaBD.initializeDatabase()) {
            Statement stmt =con.createStatement();
            String consulta = "SELECT * FROM credencial WHERE usuario = '" + nombreusuario + "' AND clave = '" + clave + "'";
            ResultSet rs= stmt.executeQuery(consulta);

            if (!rs.next()) {
                //No existe coincidencia
                return 0;
            } else{
                //Guarda los datos de la consulta dentro de los atributos de Usuario
                u1.setNombreusuario(rs.getString("usuario"));
                u1.setClave(rs.getString("clave"));
                u1.setNombre(rs.getString("nombre"));
                u1.setApellido(rs.getString("apellido"));
                // Cierra la conexión de la BD
                con.close();                
                return 1;
            }    
            
        } catch(SQLException error) {
           return 404;     
        }
    }
}
