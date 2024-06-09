
package com.gf.appHospitalmv.model;

/**
 * Clase del paciente
 * @author Juan Jose Blanco Diaz y Alejandro Francos Fernandez
 * @since 04-06-2024
 * @version 1.0
 */
public class Paciente {
    
   private String dni_paciente = "";
   private String nombre_paciente = "";
   private String apellidos_paciente = "";
   private int telefono_paciente = 0;
   private String direccion_paciente = "";

    public Paciente() {
    }

    public String getDni_paciente() {
        return dni_paciente;
    }

    public void setDni_paciente(String dni_paciente) {
        this.dni_paciente = dni_paciente;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellidos_paciente() {
        return apellidos_paciente;
    }

    public void setApellidos_paciente(String apellidos_paciente) {
        this.apellidos_paciente = apellidos_paciente;
    }

    public int getTelefono_paciente() {
        return telefono_paciente;
    }

    public void setTelefono_paciente(int telefono_paciente) {
        this.telefono_paciente = telefono_paciente;
    }

    public String getDireccion_paciente() {
        return direccion_paciente;
    }

    public void setDireccion_paciente(String direccion_paciente) {
        this.direccion_paciente = direccion_paciente;
    }

    @Override
    public String toString() {
        return "Datos del Paciente : " + 
                "\n Dni: " + dni_paciente + 
                "\n Nombre: " + nombre_paciente + 
                "\n Apellidos: " + apellidos_paciente + 
                "\n Telefono: " + telefono_paciente + 
                "\n Direccion: " + direccion_paciente;
    }
}
