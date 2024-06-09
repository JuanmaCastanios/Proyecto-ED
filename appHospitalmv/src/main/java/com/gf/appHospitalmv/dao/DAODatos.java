
package com.gf.appHospitalmv.dao;

import com.gf.appHospitalmv.model.Paciente;
import com.gf.appHospitalmv.utils.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 * Clase que realiza la logica de las operaciones CRUD
 * @author Juan Jose Blanco Diaz y Alejandro Francos Fernandez
 * @since 04-06-2024
 * @version 1.0
 */
public class DAODatos {
    
    /**
     * insert contiene la logica de la insercion
     * @param p Paciente a insertar
     * @return Ejecucion de la consulta
     * @throws SQLException Errores relacionados al trabajo y conexion con la base de datos
     */
    public static int insert(Paciente p) throws SQLException {
        try (Connection conn = ConexionBD.getConnection()) {
            String sql = "INSERT INTO paciente VALUES(?,?,?,?,?)";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            p.setNombre_paciente(String.valueOf(JOptionPane.showInputDialog(null, "Introduce el nombre del paciente : ", "Añadir paciente", JOptionPane.INFORMATION_MESSAGE)));
            p.setApellidos_paciente(String.valueOf(JOptionPane.showInputDialog(null, "Introduce los apellidos del paciente : ", "Añadir paciente", JOptionPane.INFORMATION_MESSAGE)));
            p.setTelefono_paciente(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el telefono del paciente : ", "Añadir paciente", JOptionPane.INFORMATION_MESSAGE)));
            p.setDireccion_paciente(String.valueOf(JOptionPane.showInputDialog(null, "Introduce la direccion del paciente : ", "Añadir paciente", JOptionPane.INFORMATION_MESSAGE)));
            
            ps.setString(1, p.getDni_paciente());
            ps.setString(2, p.getNombre_paciente());
            ps.setString(3, p.getApellidos_paciente());
            ps.setInt(4, p.getTelefono_paciente());
            ps.setString(5, p.getDireccion_paciente());

            return ps.executeUpdate();
        }
    }
    
    /**
     * delete contiene la logica del borrado
     * @param p Paciente a eliminar
     * @return Ejecucion de la consulta
     * @throws SQLException Errores relacionados al trabajo y conexion con la base de datos
     */
    public static int delete(Paciente p) throws SQLException {
        String sql = "DELETE FROM paciente WHERE dni_paciente=?";
        try (Connection conn = ConexionBD.getConnection()) {
            
            PreparedStatement ps = conn.prepareStatement(sql);      
            
            ps.setString(1, p.getDni_paciente());
            
            return ps.executeUpdate();
        }
    }
    
    /**
     * update contiene la logica de la actualizacion
     * @param p Paciente que actualizar
     * @return Ejecucion de la consulta
     * @throws SQLException Errores relacionados al trabajo y conexion con la base de datos
     */
    public static int update(Paciente p) throws SQLException {
        String sql = "UPDATE paciente SET nombre_paciente=?,apellidos_paciente=?,telefono_paciente=?,direccion_paciente=? WHERE dni_paciente=?";
        try (Connection conn = ConexionBD.getConnection()) {
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            p.setNombre_paciente(String.valueOf(JOptionPane.showInputDialog(null, "Introduce el nombre del paciente : ", "Actualizar paciente", JOptionPane.INFORMATION_MESSAGE)));
            p.setApellidos_paciente(String.valueOf(JOptionPane.showInputDialog(null, "Introduce los apellidos del paciente : ", "Actualizar paciente", JOptionPane.INFORMATION_MESSAGE)));
            p.setTelefono_paciente(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el telefono del paciente : ", "Actualizar paciente", JOptionPane.INFORMATION_MESSAGE)));
            p.setDireccion_paciente(String.valueOf(JOptionPane.showInputDialog(null, "Introduce la direccion del paciente : ", "Actualizar paciente", JOptionPane.INFORMATION_MESSAGE)));
            
            ps.setString(1, p.getNombre_paciente());
            ps.setString(2, p.getApellidos_paciente());
            ps.setInt   (3, p.getTelefono_paciente());
            ps.setString(4, p.getDireccion_paciente());
            ps.setString(5, p.getDni_paciente());
            
            return ps.executeUpdate();
        }
    }
    
    /**
     * select contiene la logica de la consulta
     * @return El resultado de la consulta realizada
     * @throws SQLException Errores relacionados al trabajo y conexion con la base de datos
     */
    public static Set<Paciente> select() throws SQLException{
        String sql = "SELECT * FROM paciente WHERE dni_paciente = ?";
        Set<Paciente> lista = new HashSet<>();
        try (Connection conn = ConexionBD.getConnection()) {
            
            PreparedStatement ps = conn.prepareStatement(sql);
            String dni = String.valueOf(JOptionPane.showInputDialog(null, "Introduce el dni del paciente: ", "Consulta Paciente", JOptionPane.QUESTION_MESSAGE));
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Paciente datos = new Paciente();
                
                datos.setDni_paciente(rs.getString(1));
                datos.setNombre_paciente(rs.getString(2));
                datos.setApellidos_paciente(rs.getString(3));
                datos.setTelefono_paciente(rs.getInt(4));
                datos.setDireccion_paciente(rs.getString(5));
                lista.add(datos);
            }
            return lista;
        }
    }

    /**
     * selectDni busca si existe el paciente con el que se quiere trabajar
     * @param p paciente
     * @return Boleano de si existe el paciente
     * @throws SQLException Errores relacionados al trabajo y conexion con la base de datos
     */
    public static boolean selectDni(Paciente p) throws SQLException{
        String sql = "SELECT * FROM paciente WHERE dni_paciente=?";
        
        boolean exist = false;
        try (Connection conn = ConexionBD.getConnection()) {
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            p.setDni_paciente(String.valueOf(JOptionPane.showInputDialog(null, "Introduce el dni del paciente : ", "Seleccionar paciente", JOptionPane.INFORMATION_MESSAGE)));
            
            ps.setString(1, p.getDni_paciente());
            
            ResultSet rs= ps.executeQuery();
            
            if(rs.next()){
                exist = true;
            }
            return exist;
        }
    }
    
}