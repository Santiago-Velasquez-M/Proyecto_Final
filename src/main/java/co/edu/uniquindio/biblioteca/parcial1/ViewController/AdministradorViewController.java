package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import co.edu.uniquindio.biblioteca.parcial1.Controller.AdministradorController;
import co.edu.uniquindio.biblioteca.parcial1.Enum.EstadoEnvio;
import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class AdministradorViewController {

    @FXML
    private TableView<Envio> tablaEnvios;
    @FXML
    private TableView<Usuario> tablaUsuarios;
    @FXML
    private Button btnMarcarEnRuta;
    @FXML
    private Button btnMarcarEntregado;
    @FXML
    private Button btnEliminarUsuario;
    @FXML
    private Label lblNombreAdmin;

    private AdministradorController adminController;

    @FXML
    public void initialize() {
        adminController = new AdministradorController();
        lblNombreAdmin.setText(adminController.getAdministrador().getNombre());
        cargarEnvios();
        cargarUsuarios();
    }

    @FXML
    private void cargarEnvios() {
        tablaEnvios.setItems(FXCollections.observableArrayList(adminController.listarTodosLosEnvios()));
    }

    @FXML
    private void marcarEnRuta() {
        Envio envioSeleccionado = tablaEnvios.getSelectionModel().getSelectedItem();
        if (envioSeleccionado != null) {
            adminController.actualizarEstadoEnvio(envioSeleccionado, EstadoEnvio.EN_RUTA);
            mostrarMensaje("Envío marcado como 'En Ruta'.");
            cargarEnvios();
        } else {
            mostrarMensaje("Seleccione un envío primero.");
        }
    }

    @FXML
    private void marcarEntregado() {
        Envio envioSeleccionado = tablaEnvios.getSelectionModel().getSelectedItem();
        if (envioSeleccionado != null) {
            adminController.actualizarEstadoEnvio(envioSeleccionado, EstadoEnvio.ENTREGADO);
            mostrarMensaje("Envío marcado como 'Entregado'.");
            cargarEnvios();
        } else {
            mostrarMensaje("Seleccione un envío primero.");
        }
    }

    @FXML
    private void cargarUsuarios() {
        tablaUsuarios.setItems(FXCollections.observableArrayList(adminController.listarUsuarios()));
    }

    @FXML
    private void eliminarUsuario() {
        Usuario usuarioSeleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado != null) {
            adminController.eliminarUsuario(usuarioSeleccionado);
            mostrarMensaje("Usuario eliminado correctamente.");
            cargarUsuarios();
        } else {
            mostrarMensaje("Seleccione un usuario primero.");
        }
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Administrador");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
