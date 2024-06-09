package com.gf.appHospitalmv.controller;

import com.gf.appHospitalmv.lnn.LNDatos;
import com.gf.appHospitalmv.model.Paciente;
import com.gf.appHospitalmv.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase que comunica el modelo y la vista
 * @author Juan Jose Blanco Diaz y Alejandro Francos Fernandez
 * @since 04-06-2024
 * @version 1.0
 */
public class Controller implements ActionListener {

    private final Paciente modelo; //Modelo de datos 
    private final View vista; //Vista de la aplicacion

    public Controller(Paciente datos, View vista) throws SQLException {
        modelo = datos;
        this.vista = vista;
        this.vista.getjButtonInsertar().addActionListener(this);
        this.vista.getjButtonBorrar().addActionListener(this);
        this.vista.getjButtonActualizar().addActionListener(this);
        this.vista.getjButtonConsultar().addActionListener(this);

    }
    /**
     * iniciarVista establece parametros de la vista al momento de mostrarse al usuario
     */
    public void iniciarVista() {
        vista.setTitle("Lista Pacientes");
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setResizable(false);
        vista.setSize(700, 500);
        vista.setLocationRelativeTo(null);
        vista.pack();
        vista.setVisible(true);
    }
    /**
     * actionPerformed recoge el último evento para establecer que accion hay que realizar
     * @param evento Ultimo boton pulsado
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == vista.getjButtonInsertar()) {
            insertarDatos();
        } else if (evento.getSource() == vista.getjButtonBorrar()) {
            borrarDatos();
        } else if (evento.getSource() == vista.getjButtonActualizar()) {
            actualizarDatos();
        } else if (evento.getSource() == vista.getjButtonConsultar()) {
            consultarDatos();
        }

    }
    /**
     * insertarDatos se encarca de realizar la insercion de datos en la base de datos
     */
    public void insertarDatos() {
        try {
            //Llamada  a LN
            String mensaje = LNDatos.insert(modelo);
            
            vista.actualizarTabla(); //Actualiza la tabla para mostrar modificaciones en ella
            JOptionPane.showMessageDialog(null, mensaje + "\n ", "Inserción Datos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * borrarDatos se encarca de realizar el borrado de datos en la base de datos
     */
    public void borrarDatos() {
        try {
            //Llamada  a LN
            String mensaje = LNDatos.delete(modelo);

            vista.actualizarTabla(); //Actualiza la tabla para mostrar modificaciones en ella
            JOptionPane.showMessageDialog(null, mensaje + "\n ", "Borrado Datos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * actualizarDatos se encarca de realizar la actualizacion de datos en la base de datos
     */
    public void actualizarDatos() {
        try {
            //Llamada  a LN
            String mensaje = LNDatos.update(modelo);

            vista.actualizarTabla(); //Actualiza la tabla para mostrar modificaciones en ella
            JOptionPane.showMessageDialog(null, mensaje + "\n ", "Actulizacion Datos", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * consultarDatos se encarca de realizar la consulta de datos en la base de datos
     */
    public void consultarDatos() {
        try {
            //Llamada  a LN
            Set<Paciente> list = LNDatos.select();
            for (Paciente d : list) {
                JOptionPane.showMessageDialog(null, d.toString() + "\n ", "Consulta Paciente", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
