package com.gf.appHospitalmv.lnn;

import com.gf.appHospitalmv.dao.DAODatos;
import com.gf.appHospitalmv.model.Paciente;
import java.sql.SQLException;
import java.util.Set;

/**
 * Clase que verifica si existe el paciente para realizar la operacion CRUD
 * @author Juan Jose Blanco Diaz y Alejandro Francos Fernandez
 * @since 04-06-2024
 * @version 1.0
 */
public class LNDatos {
    
    /**
     * insert realiza la comprobacion de la insercion
     * @param p Persona a insertar
     * @return Mensaje de confirmacion
     * @throws SQLException Errores relacionados al trabajo y conexion con la base de datos
     */
    public static String insert(Paciente p) throws SQLException {
        if (!DAODatos.selectDni(p)) {
            
            DAODatos.insert(p);
            
            return "El paciente se ha almacenado en la base de datos Correctamente";
        } else {
            return "El paciente ya existe";
        }
    }

    /**
     * delete realiza la comprobacion del borrado
     * @param p Persona a borrar
     * @return Mensaje de confirmacion
     * @throws SQLException Errores relacionados al trabajo y conexion con la base de datos
     */
    public static String delete(Paciente p) throws SQLException {
        if (DAODatos.selectDni(p)) {
            
            DAODatos.delete(p);
            
            return "El paciente se ha eliminado de la base de datos Correctamente";
        } else {
            return "El paciente no existe";
        }
    }

    /**
     * update realiza la comprobacion de la actualizacion
     * @param p Persona que actualizar
     * @return Mensaje de confirmacion
     * @throws SQLException Errores relacionados al trabajo y conexion con la base de datos
     */
    public static String update(Paciente p) throws SQLException {
        if (DAODatos.selectDni(p)) {
            
            DAODatos.update(p);
            
            return "El paciente se ha actualizado en la base de datos Correctamente";
        } else {
            return "El paciente no existe";
        }
    }

    /**
     * select realiza la comprobacion de la consulta
     * @return La lista de resultados de la consulta
     * @throws SQLException Errores relacionados al trabajo y conexion con la base de datos 
     */
    public static Set<Paciente> select() throws SQLException {
        Set<Paciente> lista;
        lista = DAODatos.select();
        return lista;
    }
}
