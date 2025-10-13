package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();

        if (!id.isEmpty() && !nombre.isEmpty()) {
            Usuario nuevo = new Usuario(id, nombre, correo, telefono, new java.util.ArrayList<>());
            modelFactory.getUsuarioRepository().agregarUsuario(nuevo);
            cargarUsuarios();
            limpiarCampos();
        }
    }

    @FXML
    private void actualizarUsuario() {
        Usuario seleccionado = tblUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setNombreCompleto(txtNombre.getText());
            seleccionado.setCorreo(txtCorreo.getText());
            seleccionado.setTelefono(txtTelefono.getText());
            modelFactory.getUsuarioRepository().actualizarUsuario(seleccionado.getIdUsuario(), seleccionado);
            cargarUsuarios();
        }
    }

    @FXML
    private void eliminarUsuario() {
        Usuario seleccionado = tblUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            modelFactory.getUsuarioRepository().eliminarUsuario(seleccionado.getIdUsuario());
            cargarUsuarios();
        }
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
    }
}
