/* Capa Persistencia o DAO:*/
// Toma la BD y crea un objeto

package com.udep.sin2021.appsin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBD {
    public static Connection initializeDatabase()
        throws SQLException,ClassNotFoundException {         
        String host = "localhost";
        String puerto = "3306";
        String usuario = "root";
        String password = "";
        String bd = "sistema";
        String url = "jdbc:mysql://" + host + ":"+puerto+"/"+ bd +"?user=" + usuario + "&password=" + password;

        Connection con = DriverManager.getConnection(url);
        return con;
    }
}
