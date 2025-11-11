package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import co.edu.uniquindio.biblioteca.parcial1.Controller.UsuarioController;
import co.edu.uniquindio.biblioteca.parcial1.Dto.UsuarioDto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class UsuariosViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtDocumento;
    @FXML private TableView<UsuarioDto> tblUsuarios;
    @FXML private TableColumn<UsuarioDto, String> colId;
    @FXML private TableColumn<UsuarioDto, String> colNombre;
    @FXML private TableColumn<UsuarioDto, String> colCorreo;
    @FXML private TableColumn<UsuarioDto, String> colTelefono;
    @FXML private TableColumn<UsuarioDto, String> colDocumento;

    private final UsuarioController usuarioController = new UsuarioController();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDocumento.setCellValueFactory(new PropertyValueFactory<>("documento"));

        cargarTabla();

        tblUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, sel) -> {
            if (sel != null) {
                txtId.setText(sel.getIdUsuario());
                txtNombre.setText(sel.getNombreCompleto());
                txtCorreo.setText(sel.getCorreo());
                txtTelefono.setText(sel.getTelefono());
                txtDocumento.setText(sel.getDocumento());
            }
        });
    }

    private void cargarTabla() {
        tblUsuarios.setItems(FXCollections.observableArrayList(usuarioController.listarUsuariosDto()));
    }

    @FXML
    private void cargarUsuarios() {
        cargarTabla();
    }

    @FXML
    private void agregarUsuario() {
        if (!validar()) return;

        UsuarioDto nuevo = new UsuarioDto(
                txtId.getText(),
                txtNombre.getText(),
                txtCorreo.getText(),
                txtTelefono.getText(),
                txtDocumento.getText()
        );

        usuarioController.crearUsuarioDto(nuevo);
        info("Usuario agregado correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void actualizarUsuario() {
        UsuarioDto sel = tblUsuarios.getSelectionModel().getSelectedItem();
        if (sel == null) { error("Selecciona un usuario"); return; }
        if (!validar()) return;

        UsuarioDto actualizado = new UsuarioDto(
                txtId.getText(),
                txtNombre.getText(),
                txtCorreo.getText(),
                txtTelefono.getText(),
                txtDocumento.getText()
        );

        usuarioController.actualizarUsuarioDto(sel.getIdUsuario(), actualizado);
        info("Usuario actualizado");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void eliminarUsuario() {
        UsuarioDto sel = tblUsuarios.getSelectionModel().getSelectedItem();
        if (sel == null) { error("Selecciona un usuario"); return; }

        usuarioController.eliminarUsuarioDto(sel.getIdUsuario());
        info("Usuario eliminado");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void limpiar() {
        txtId.clear();
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        txtDocumento.clear();
        tblUsuarios.getSelectionModel().clearSelection();
    }

    private boolean validar() {
        if (txtId.getText().isBlank() || txtNombre.getText().isBlank()) {
            error("ID y Nombre son obligatorios");
            return false;
        }
        return true;
    }

    private void info(String m){ alerta(Alert.AlertType.INFORMATION, m); }
    private void error(String m){ alerta(Alert.AlertType.ERROR, m); }
    private void alerta(Alert.AlertType t, String m){
        Alert a = new Alert(t);
        a.setHeaderText(null);
        a.setContentText(m);
        a.showAndWait();
    }
}
