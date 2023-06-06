/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gestor.eventos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import modelo.EventManager;
import modelo.Evento;

/**
 * FXML Controller class
 *
 * @author David
 */
public class AddEventController implements Initializable {

    @FXML
    private TextField nombreField;
    @FXML
    private TextArea sinopsisField;
    @FXML
    private DatePicker fechaInicioField;
    @FXML
    private DatePicker fechaFinField;
    @FXML
    private TextField imagenField;
    @FXML
    private TextField responsableField;
    @FXML
    private DatePicker publicacionField;
    @FXML
    private DatePicker ocultarField;
    @FXML
    private ImageView imagenView;
    @FXML
    private Button seleccionarImagenButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addEvent() {
        String nombre = nombreField.getText();
        String sinopsis = sinopsisField.getText();
        LocalDateTime fechaInicio = LocalDateTime.of(fechaInicioField.getValue(), LocalTime.MIDNIGHT);
        LocalDateTime fechaFin = LocalDateTime.of(fechaFinField.getValue(), LocalTime.MIDNIGHT);
        String imagen = imagenField.getText();
        String responsable = responsableField.getText();
        LocalDateTime fechaPublicacion = LocalDateTime.of(publicacionField.getValue(), LocalTime.MIDNIGHT);
        LocalDateTime fechaOcultar = LocalDateTime.of(ocultarField.getValue(), LocalTime.MIDNIGHT);

        Evento newEvent = new Evento(0, nombre, sinopsis, fechaInicio, fechaFin, imagen, responsable, fechaPublicacion, fechaOcultar);
        EventManager.addEvent(newEvent);

        clearFields();
        
        try {
            App.setRoot("precioView");
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearFields() {
        nombreField.clear();
        sinopsisField.clear();
        fechaInicioField.setValue(null);
        fechaFinField.setValue(null);
        imagenField.clear();
        responsableField.clear();
        publicacionField.setValue(null);
        ocultarField.setValue(null);
    }

    @FXML
    private void seleccionarImagen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Images (*.png, *.jpg, *.jpeg)", "*.png", "*.jpg", "*.jpeg");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show open file dialog
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            try {
                Image image = new Image(new FileInputStream(file));
                imagenView.setImage(image);
                imagenField.setText(file.toURI().toString()); // suponiendo que 'imagenField' es el TextField para la URL de la imagen.
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
