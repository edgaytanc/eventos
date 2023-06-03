package gestor.eventos;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private Button btnVerEventos;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnResitrarse;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
