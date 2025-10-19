package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class UsuarioViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;

    @FXML private TableView<Usuario> tblUsuarios;
    @FXML private TableColumn<Usuario, String> colId;
    @FXML private TableColumn<Usuario, String> colNombre;
    @FXML private TableColumn<Usuario, String> colCorreo;
    @FXML private TableColumn<Usuario, String> colTelefono;

    private final ModelFactory modelFactory = ModelFactory.getInstance();
    private final ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        configurarColumnas();
        cargarUsuarios();
        configurarSeleccionTabla();
    }

    private void configurarColumnas() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
    }

    @FXML
    private void cargarUsuarios() {
        listaUsuarios.setAll(modelFactory.getUsuarioRepository().obtenerUsuarios());
        tblUsuarios.setItems(listaUsuarios);
    }

    @FXML
    private void agregarUsuario() {
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String correo = txtCorreo.getText().trim();
        String telefono = txtTelefono.getText().trim();

        if (id.isEmpty() || nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            mostrarAlerta("Error", "Por favor completa todos los campos.");
            return;
        }

        // Evitar duplicados
        boolean existe = modelFactory.getUsuarioRepository()
                .obtenerUsuarios()
                .stream()
                .anyMatch(u -> u.getIdUsuario().equals(id));

        if (existe) {
            mostrarAlerta("Advertencia", "Ya existe un usuario con el ID " + id);
            return;
        }

        Usuario nuevo = new Usuario(id, nombre, correo, telefono, new ArrayList<>());
        modelFactory.getUsuarioRepository().agregarUsuario(nuevo);
        listaUsuarios.add(nuevo);
        limpiarCampos();
        mostrarAlerta("Éxito", "Usuario agregado correctamente.\nYa está disponible en la gestión de envíos.");
    }

    @FXML
    private void actualizarUsuario() {
        Usuario seleccionado = tblUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Selecciona un usuario para actualizar.");
            return;
        }

        seleccionado.setNombreCompleto(txtNombre.getText().trim());
        seleccionado.setCorreo(txtCorreo.getText().trim());
        seleccionado.setTelefono(txtTelefono.getText().trim());

        modelFactory.getUsuarioRepository().actualizarUsuario(seleccionado.getIdUsuario(), seleccionado);
        cargarUsuarios();
        limpiarCampos();
        mostrarAlerta("Éxito", "Usuario actualizado correctamente.");
    }

    @FXML
    private void eliminarUsuario() {
        Usuario seleccionado = tblUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Selecciona un usuario para eliminar.");
            return;
        }

        modelFactory.getUsuarioRepository().eliminarUsuario(seleccionado.getIdUsuario());
        listaUsuarios.remove(seleccionado);
        limpiarCampos();
        mostrarAlerta("Éxito", "Usuario eliminado correctamente.");
    }

    private void configurarSeleccionTabla() {
        tblUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txtId.setText(newSel.getIdUsuario());
                txtNombre.setText(newSel.getNombreCompleto());
                txtCorreo.setText(newSel.getCorreo());
                txtTelefono.setText(newSel.getTelefono());
            }
        });
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
