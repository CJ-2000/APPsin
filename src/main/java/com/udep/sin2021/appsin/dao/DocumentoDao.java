/* Capa Persistencia o DAO:*/
// Toma la BD y crea un objeto

package com.udep.sin2021.appsin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DocumentoDao {
    //Esta clase contiene métodos que devuelven entero, lista o algún otro tipo de dato
    
    public int RegistraDocumento(String codigo, String nombre, String version, String fecha, String ruta, String icono, String tipo, String area, String unidad_negocio) throws SQLException, ClassNotFoundException{
        //Este método se usa para registrar en la BD, los datos de un documento nuevo
        //Retorna valor int: 0 o 1
            Connection con = ConectaBD.initializeDatabase();
            Statement stmt =con.createStatement();
            String consulta = "INSERT INTO documento "
                    + "(Codigo,Nombre,Version,Fecha,Ruta,Icono,Tipo,Area,Und_neg) "
                    + "VALUES ( '" + codigo + "','" + nombre + "','" 
                    + version + "','" + fecha + "','" +  ruta + "','" +  icono + "','" 
                    + tipo + "','" + area + "','" +  unidad_negocio 
                    + "'   )";
            
            int filas = stmt.executeUpdate(consulta);
            if (filas > 0 ) { //Se logró insertar
                // Cierra la conexión de la BD
                con.close();  
                return 1;
            }  else { //No hubo respuesta
                // Cierra la conexión de la BD
                con.close();  
                return 0; 
            }        
    }
            
    
    //Métodos que devuelven entero, lista o algún otro tipo de dato
    //public List<Documento> listarDocumentos(){ 
        //Select * from documentos -> ResultSet
        //Hace un while de todos los registros y por cada uno crea un objeto
        //Cada objeto Documento se adiciona a un array  
        
        //List listaDocumentos = new ArrayList();
        
        /*
        while(rs.next()){
            Documento d1 = new Documento();
            d1.setCodigo(rs.getString("codigo"));
            d1.setVersion(rs.getString("version"));
            d1.setFecha(rs.getString("fecha"));
            d1.setRuta(rs.getString("ruta"));
            d1.setTipo(rs.getString("tipo"));
            d1.setArea(rs.getString("area"));
            d1.setUnidad_negocio(rs.getString("unidad_negocio"));
            
            listaDocumentos.add(d1);
        }
        */
        
        //return listaDocumentos;
    //}
    
    
    
}
