package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Model.EmpresaLogistica;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private EmpresaLogistica  empresaLogistica;

    @FXML
    private TextField txtCorreoDocumento;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private Label lblMensaje;

    private final ModelFactory modelFactory = ModelFactory.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        empresaLogistica = new EmpresaLogistica();


    }

    @FXML
    void onIngresar(ActionEvent event) {
        String input = txtCorreoDocumento.getText();
        String contrasena = txtContrasena.getText(); // por ahora no se usa

        if (input == null || input.isBlank()) {
            lblMensaje.setText("Ingresa un correo o documento.");
            return;
        }

        Usuario usuario = modelFactory.getUsuarioService().buscarPorCorreoODocumento(input);
        if (usuario != null) {
            abrirVistaUsuario(usuario);
            cerrarVentanaActual();
            return;
        }

        lblMensaje.setText("Usuario no encontrado.");
    }

    private void abrirVistaUsuario(Usuario usuario) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UsuarioPortalView.fxml"));
            Parent root = loader.load();

            UsuarioPortalController controller = loader.getController();
            controller.setUsuarioLogueado(usuario);

            Stage stage = new Stage();
            stage.setTitle("Portal de Usuario");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cerrarVentanaActual() {
        Stage stage = (Stage) txtCorreoDocumento.getScene().getWindow();
        stage.close();
    }
}
