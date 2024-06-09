
package com.gf.appHospitalmv;

import com.gf.appHospitalmv.controller.Controller;
import com.gf.appHospitalmv.model.Paciente;
import com.gf.appHospitalmv.view.View;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fraferal
 */
public class AppHospitalmv {

    public static void main(String[] args) {
        
        Paciente modelo = new Paciente();
        View vista = new View();
        
        Controller controlador;
        try {
            
            controlador = new Controller(modelo, vista);
            controlador.iniciarVista();
            
        } catch (SQLException ex) {
            Logger.getLogger(AppHospitalmv.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }
}
