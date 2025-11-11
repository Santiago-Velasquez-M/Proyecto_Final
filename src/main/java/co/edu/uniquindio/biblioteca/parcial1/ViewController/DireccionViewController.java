package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import co.edu.uniquindio.biblioteca.parcial1.Controller.DireccionController;
import co.edu.uniquindio.biblioteca.parcial1.Model.Direccion;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class DireccionViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtCiudad;
    @FXML private TextField txtLatitud;
    @FXML private TextField txtLongitud;
    @FXML private TableView<Direccion> tblDirecciones;
    @FXML private TableColumn<Direccion, String> colId;
    @FXML private TableColumn<Direccion, String> colNombre;
    @FXML private TableColumn<Direccion, String> colDireccion;
    @FXML private TableColumn<Direccion, String> colCiudad;
    @FXML private TableColumn<Direccion, String> colLatitud;
    @FXML private TableColumn<Direccion, String> colLongitud;

    private final DireccionController direccionController = new DireccionController();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idDireccion"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colLatitud.setCellValueFactory(new PropertyValueFactory<>("latitud"));
        colLongitud.setCellValueFactory(new PropertyValueFactory<>("longitud"));

        cargarTabla();

        tblDirecciones.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, sel) -> {
            if (sel != null) {
                txtId.setText(sel.getIdDireccion());
                txtNombre.setText(sel.getNombre());
                txtDireccion.setText(sel.getDireccion());
                txtCiudad.setText(sel.getCiudad());
                txtLatitud.setText(sel.getLatitud());
                txtLongitud.setText(sel.getLongitud());
            }
        });
    }

    private void cargarTabla() {
        tblDirecciones.setItems(FXCollections.observableArrayList(direccionController.listarDirecciones()));
    }

    @FXML
    private void agregar() {
        if (!validar()) return;

        Direccion nueva = new Direccion(
                txtId.getText(),
                txtNombre.getText(),
                txtDireccion.getText(),
                txtCiudad.getText(),
                txtLatitud.getText(),
                txtLongitud.getText()
        );

        direccionController.crearDireccion(nueva);
        info("Dirección agregada correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void actualizar() {
        Direccion sel = tblDirecciones.getSelectionModel().getSelectedItem();
        if (sel == null) { error("Selecciona una dirección"); return; }
        if (!validar()) return;

        Direccion actualizada = new Direccion(
                txtId.getText(),
                txtNombre.getText(),
                txtDireccion.getText(),
                txtCiudad.getText(),
                txtLatitud.getText(),
                txtLongitud.getText()
        );

        direccionController.actualizarDireccion(sel.getIdDireccion(), actualizada);
        info("Dirección actualizada correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void eliminar() {
        Direccion sel = tblDirecciones.getSelectionModel().getSelectedItem();
        if (sel == null) { error("Selecciona una dirección"); return; }

        direccionController.eliminarDireccion(sel.getIdDireccion());
        info("Dirección eliminada correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void limpiar() {
        txtId.clear();
        txtNombre.clear();
        txtDireccion.clear();
        txtCiudad.clear();
        txtLatitud.clear();
        txtLongitud.clear();
        tblDirecciones.getSelectionModel().clearSelection();
    }

    private boolean validar() {
        if (txtId.getText().isBlank() || txtDireccion.getText().isBlank()) {
            error("El ID y la dirección son obligatorios");
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
