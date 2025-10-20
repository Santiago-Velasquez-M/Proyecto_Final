package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import co.edu.uniquindio.biblioteca.parcial1.Controller.UsuarioController;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class UsuariosViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;

    @FXML private TableView<Usuario> tblUsuarios;
    @FXML private TableColumn<Usuario, String> colId;
    @FXML private TableColumn<Usuario, String> colNombre;
    @FXML private TableColumn<Usuario, String> colCorreo;
    @FXML private TableColumn<Usuario, String> colTelefono;

    private final UsuarioController usuarioController = new UsuarioController();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        cargarUsuarios();
    }

    @FXML
    private void cargarUsuarios() {
        tblUsuarios.setItems(FXCollections.observableArrayList(usuarioController.listarUsuarios()));
    }

    @FXML
    private void agregarUsuario() {
        Usuario nuevo = new Usuario(
                txtId.getText(),
                txtNombre.getText(),
                txtCorreo.getText(),
                txtTelefono.getText()
        );
        usuarioController.crearUsuario(nuevo);
        mostrarAlerta("Usuario agregado correctamente.");
        limpiarCampos();
        cargarUsuarios();
    }

    @FXML
    private void actualizarUsuario() {
        Usuario seleccionado = tblUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Seleccione un usuario para actualizar.");
            return;
        }

        Usuario actualizado = new Usuario(
                txtId.getText(),
                txtNombre.getText(),
                txtCorreo.getText(),
                txtTelefono.getText()
        );
        usuarioController.actualizarUsuario(seleccionado.getIdUsuario(), actualizado);
        mostrarAlerta("Usuario actualizado correctamente.");
        limpiarCampos();
        cargarUsuarios();
    }

    @FXML
    private void eliminarUsuario() {
        Usuario seleccionado = tblUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Seleccione un usuario para eliminar.");
            return;
        }

        usuarioController.eliminarUsuario(seleccionado.getIdUsuario());
        mostrarAlerta("Usuario eliminado correctamente.");
        cargarUsuarios();
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Gestión de Usuarios");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
