/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gestor.eventos;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import modelo.AsientoSeleccionado;
import modelo.ListaAsientoSeleccionado;

/**
 * FXML Controller class
 *
 * @author David
 */
public class CompraBoletosController implements Initializable {

    private ListaAsientoSeleccionado lista = new ListaAsientoSeleccionado();
    private int contador = 0;

    @FXML
    private GridPane seatGrid;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Define las filas y columnas de tu disposición de asientos.
        int numRows = 14;
        int numCols = 14;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                // Crea un nuevo botón de asiento para cada asiento en la disposición.
                RadioButton seatButton = new RadioButton(rowToLetter(row) + (col + 1));
                seatButton.setOnAction(event -> handleSeatSelection(seatButton));
                if (row < 2) {
                    seatButton.setStyle("-fx-text-fill: red;");  // VIP+M&G
                    seatButton.setUserData("VIP+M&G");
                } else if (row < 7) {
                    seatButton.setStyle("-fx-text-fill: blue;"); // VIP
                    seatButton.setUserData("VIP");
                } else if (row < 10) {
                    seatButton.setStyle("-fx-text-fill: green;"); // Platea A
                    seatButton.setUserData("PLATEA A");
                } else {
                    seatButton.setStyle("-fx-text-fill: black;"); // Platea B
                    seatButton.setUserData("PLATEA B");
                }
                // Agrega el botón de asiento a la grilla.
                seatGrid.add(seatButton, col, row);
            }
        }

    }

    private void handleSeatSelection(RadioButton seatButton) {
        if (contador <= 10) {

        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Limite Alcanzado");
            alert.setContentText("Ya no es posible seleccionar mas asientos/n Llego a su limite");
        }
        String seatPosition = seatButton.getText();
        String section = (String) seatButton.getUserData();
        System.out.println("Asiento seleccionado: " + seatPosition + " " + section);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Asiento Seleccionado");
        alert.setContentText(seatPosition + " " + section);

        // Este es el cambio importante
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {

            AsientoSeleccionado asientoSeleccionado = new AsientoSeleccionado(seatPosition, section);
            lista.add(asientoSeleccionado);

        } else {
            seatButton.setSelected(false);
        }
    }

    private String rowToLetter(int row) {
        // Comienza en la letra 'A'
        int letter = 'A' + row;
        // Si excedemos la 'Z', comenzamos a agregar letras adicionales
        if (letter > 'Z') {
            // Devuelve "A" para la fila 26, "B" para la fila 27, etc.
            return "A" + (char) ('A' + row - 26);
        } else {
            return String.valueOf((char) letter);
        }
    }

    @FXML
    private void clickAceptar(ActionEvent event) throws IOException{
        //Se modifica el codigo para enviar el listado a el carrito de compras

        ArrayList<AsientoSeleccionado> listado = lista.lista();

        for (AsientoSeleccionado asiento : listado) {
            System.out.println(asiento.getAsiento() + " " + asiento.getSeccion());
        }
        
        App.setRoot("comprador");
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
    }

}
