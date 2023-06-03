/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gestor.eventos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author David
 */
public class PagoTarjetaController implements Initializable {

    @FXML
    private TextField nombreTarjetahabienteField;
    @FXML
    private TextField numeroTarjetaField;
    @FXML
    private TextField fechaVencimientoField;
    @FXML
    private TextField codigoVerificacionField;
    @FXML
    private TextField direccionField;
    @FXML
    private TextField codigoPostalField;
    @FXML
    private Label resumenCompraLabel;
    @FXML
    private Button aceptarButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAceptarButton(ActionEvent event)throws IOException {
        String nombreTarjetahabiente = nombreTarjetahabienteField.getText();
        String numeroTarjeta = numeroTarjetaField.getText();
        String fechaVencimiento = fechaVencimientoField.getText();
        String codigoVerificacion = codigoVerificacionField.getText();
        String direccion = direccionField.getText();
        String codigoPostal = codigoPostalField.getText();

        // Aquí deberías validar los datos ingresados y proceder con el pago.
        // Si los datos no son válidos, muestra un mensaje de error.
        // Si los datos son válidos, procesa el pago y navega a la pantalla siguiente.
    }
    
}
