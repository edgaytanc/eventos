package gestor.eventos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.UserManager;

public class LoginController implements Initializable {

    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtConrasena;
    @FXML
    private Button btnIngresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void click() throws IOException {
        String correo = txtCorreo.getText();
        String contrasena = txtConrasena.getText();

        if (UserManager.loginUser(correo, contrasena)) {
            try {
                App.setRoot("compraBoletos");
            } catch (IOException e) {
                e.printStackTrace();
                // Aquí deberías manejar la excepción, quizá mostrando un mensaje al usuario.
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Inicio de Sesión");
            alert.setHeaderText(null);
            alert.setContentText("Correo electrónico o contraseña incorrectos. Inténtalo de nuevo.");
            alert.showAndWait();
        }
    }

}
