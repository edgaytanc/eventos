/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gestor.eventos;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import modelo.EventManager;
import modelo.Evento;

/**
 * FXML Controller class
 *
 * @author David
 */
public class ListaEventoController implements Initializable {

    @FXML
    private AnchorPane eventListPane;
    @FXML
    private TableView<Evento> eventTable;
    @FXML
    private TableColumn<Evento, String> nameColumn;
    @FXML
    private TableColumn<Evento, LocalDateTime> dateColumn;
    private TableColumn<Evento, String> locationColumn;
    @FXML
    private TableColumn<?, ?> sinopsisColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Configurar las columnas
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("fechaInicio")); // Suponiendo que 'fechaInicio' es la fecha del evento
        sinopsisColumn.setCellValueFactory(new PropertyValueFactory<>("sinopsis")); // Nota: Reemplaza "location" por el nombre correcto del campo en tu clase Evento

        // Obtener la lista de eventos
        ObservableList<Evento> eventos = FXCollections.observableArrayList(EventManager.getEvents());

        // Añadir los eventos a la tabla
        eventTable.setItems(eventos);

        // Añadir un listener de selección para la tabla
        eventTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                App.selectedEvent = newSelection; // Guarda el evento seleccionado
            }
        });

    }

    @FXML
    private void editEvent(ActionEvent event) {
    }

    @FXML
    private void deleteEvent(ActionEvent event) {
    }

    @FXML
    private void selectEvent(ActionEvent event) {
        if (App.usuarioActivo == null) {
            try {
                App.setRoot("login");
            } catch (IOException e) {
                e.printStackTrace();
                // Aquí deberías manejar la excepción, quizá mostrando un mensaje al usuario.
            }
        } else {
            try {
                App.setRoot("compraBoletos");
            } catch (IOException e) {
                e.printStackTrace();
                // Aquí deberías manejar la excepción, quizá mostrando un mensaje al usuario.
            }
        }

    }

}
