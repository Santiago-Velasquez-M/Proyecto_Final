package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import co.edu.uniquindio.biblioteca.parcial1.Controller.RegistroUsuarioController;
import co.edu.uniquindio.biblioteca.parcial1.Util.Constantes;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistroUsuarioViewController {

    @FXML private TextField txtNombreCompleto;
    @FXML private TextField txtDocumento;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtCorreo;
    @FXML private Button btnRegistrar;

    private RegistroUsuarioController registroController;

    @FXML
    public void initialize() {
        registroController = new RegistroUsuarioController();
        registroController.initialize();
    }

    @FXML
    private void registrarUsuario() {

        String nombre = txtNombreCompleto.getText();
        String documento = txtDocumento.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();

        // Validaciones
        if (nombre.isEmpty()) {
            mostrarMensaje(Constantes.REGISTRO_NOMBRE_VACIO);
            return;
        }
        if (documento.isEmpty()) {
            mostrarMensaje(Constantes.REGISTRO_DOCUMENTO_VACIO);
            return;
        }
        if (telefono.isEmpty()) {
            mostrarMensaje(Constantes.REGISTRO_TELEFONO_VACIO);
            return;
        }
        if (correo.isEmpty()) {
            mostrarMensaje("Debe ingresar un correo.");
            return;
        }

        try {
            registroController.registrarUsuario(nombre, documento, telefono, correo);

            mostrarMensaje(Constantes.REGISTRO_COMPLETADO);
            limpiarCampos();

        } catch (Exception e) {
            mostrarMensaje(Constantes.REGISTRO_ERROR + e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtNombreCompleto.clear();
        txtDocumento.clear();
        txtTelefono.clear();
        txtCorreo.clear();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registro de Usuario");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
