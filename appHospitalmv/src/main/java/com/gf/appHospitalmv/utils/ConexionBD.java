
package com.gf.appHospitalmv.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para establecer la conexion
 * @author Juan Jose Blanco Diaz y Alejandro Francos Fernandez
 * @since 04-06-2024
 * @version 1.0
 */
public class ConexionBD {
    
    private static Connection conn;
    private static final String MYSQL_DB_URL =  "jdbc:mysql://localhost:3306/hospital";
    private static final String MYSQL_DB_USER = "root";
    private static final String MYSQL_DB_PASSWORD = "";
    
    /**
     * getConnection realiza la conexion con la base de datos
     * @return La conexion
     * @throws SQLException Errores relacionados al trabajo y conexion con la base de datos
     */
    public static Connection getConnection() throws SQLException{
        conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASSWORD);
        return conn; 
    }
    
}
