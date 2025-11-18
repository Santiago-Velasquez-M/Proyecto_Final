package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import co.edu.uniquindio.biblioteca.parcial1.Controller.LoginController;
import co.edu.uniquindio.biblioteca.parcial1.Model.Administrador;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import co.edu.uniquindio.biblioteca.parcial1.Util.Constantes;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {

    private LoginController loginController;

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtContrasena;
    @FXML private Label lblMensaje;

    @FXML
    public void initialize() {
        loginController = new LoginController();
    }

    @FXML
    public void onIngresar() {

        String usuarioInput = txtUsuario.getText();
        String claveInput = txtContrasena.getText();

        if (usuarioInput.isBlank()) {
            lblMensaje.setText(Constantes.LOGIN_CAMPO_USUARIO_VACIO);
            return;
        }

        if (claveInput.isBlank()) {
            lblMensaje.setText(Constantes.LOGIN_CAMPO_CLAVE_VACIO);
            return;
        }

        Usuario usuario = loginController.login(usuarioInput, claveInput);

        if (usuario != null) {
            abrirVistaUsuario(usuario);
            cerrarVentanaActual();
            return;
        }

        Administrador admin = loginController.loginAdmin(usuarioInput, claveInput);

        if (admin != null) {
            abrirVistaAdministrador();
            cerrarVentanaActual();
            return;
        }

        lblMensaje.setText(Constantes.LOGIN_CREDENCIALES_INVALIDAS);
    }


    // ---------------------------------------------------------
    // ABRIR VISTA DE REGISTRO
    // ---------------------------------------------------------
    @FXML
    public void onRegistrar() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/RegistroView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Registro de Usuario");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            lblMensaje.setText("Error cargando la vista de registro.");
        }
    }

    private void abrirVistaUsuario(Usuario usuario) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UsuarioPrincipalView.fxml"));
            Parent root = loader.load();

            // Pasar usuario al ViewController
            UsuarioPrincipalViewController controller = loader.getController();
            controller.setUsuario(usuario);

            Stage stage = new Stage();
            stage.setTitle("Panel del Usuario");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            lblMensaje.setText("Error cargando la vista del usuario.");
        }
    }

    private void abrirVistaAdministrador() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EmpresaLogisticaView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Panel de Administración - Empresa Logística");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            lblMensaje.setText("Error cargando la vista del administrador.");
        }
    }


    private void cerrarVentanaActual() {
        Stage stage = (Stage) txtUsuario.getScene().getWindow();
        stage.close();
    }
}
