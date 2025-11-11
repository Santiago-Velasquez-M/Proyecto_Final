package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import co.edu.uniquindio.biblioteca.parcial1.Controller.RepartidorController;
import co.edu.uniquindio.biblioteca.parcial1.Dto.RepartidorDto;
import co.edu.uniquindio.biblioteca.parcial1.Enum.DisponibilidadRepartidor;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class RepartidoresViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtDocumento;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtVehiculo;
    @FXML private TextField txtPlaca;
    @FXML private TextField txtZona;
    @FXML private ComboBox<DisponibilidadRepartidor> comboDisponibilidad;

    @FXML private TableView<RepartidorDto> tblRepartidores;
    @FXML private TableColumn<RepartidorDto, String> colId;
    @FXML private TableColumn<RepartidorDto, String> colNombre;
    @FXML private TableColumn<RepartidorDto, String> colDocumento;
    @FXML private TableColumn<RepartidorDto, String> colTelefono;
    @FXML private TableColumn<RepartidorDto, String> colVehiculo;
    @FXML private TableColumn<RepartidorDto, String> colPlaca;
    @FXML private TableColumn<RepartidorDto, String> colZona;
    @FXML private TableColumn<RepartidorDto, DisponibilidadRepartidor> colDisponibilidad;

    private final RepartidorController controller = new RepartidorController();

    @FXML
    public void initialize() {
        comboDisponibilidad.setItems(FXCollections.observableArrayList(DisponibilidadRepartidor.values()));

        colId.setCellValueFactory(new PropertyValueFactory<>("idRepartidor"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDocumento.setCellValueFactory(new PropertyValueFactory<>("documento"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colVehiculo.setCellValueFactory(new PropertyValueFactory<>("vehiculo"));
        colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colZona.setCellValueFactory(new PropertyValueFactory<>("zonaCobertura"));
        colDisponibilidad.setCellValueFactory(new PropertyValueFactory<>("disponibilidadRepartidor"));

        cargarTabla();

        tblRepartidores.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, sel) -> {
            if (sel != null) {
                txtId.setText(sel.getIdRepartidor());
                txtNombre.setText(sel.getNombre());
                txtDocumento.setText(sel.getDocumento());
                txtTelefono.setText(sel.getTelefono());
                txtVehiculo.setText(sel.getVehiculo());
                txtPlaca.setText(sel.getPlaca());
                txtZona.setText(sel.getZonaCobertura());
                comboDisponibilidad.setValue(sel.getDisponibilidadRepartidor());
            }
        });
    }

    private void cargarTabla() {
        tblRepartidores.setItems(FXCollections.observableArrayList(controller.listarRepartidoresDto()));
    }

    @FXML
    private void agregar() {
        if (!validar()) return;
        RepartidorDto dto = new RepartidorDto(
                txtId.getText(),
                txtNombre.getText(),
                txtDocumento.getText(),
                txtTelefono.getText(),
                txtVehiculo.getText(),
                txtPlaca.getText(),
                txtZona.getText(),
                comboDisponibilidad.getValue()
        );
        controller.crearRepartidorDto(dto);
        info("Repartidor agregado correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void actualizar() {
        RepartidorDto sel = tblRepartidores.getSelectionModel().getSelectedItem();
        if (sel == null) { error("Selecciona un repartidor"); return; }
        if (!validar()) return;

        RepartidorDto dto = new RepartidorDto(
                txtId.getText(),
                txtNombre.getText(),
                txtDocumento.getText(),
                txtTelefono.getText(),
                txtVehiculo.getText(),
                txtPlaca.getText(),
                txtZona.getText(),
                comboDisponibilidad.getValue()
        );
        controller.actualizarRepartidorDto(sel.getIdRepartidor(), dto);
        info("Repartidor actualizado correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void eliminar() {
        RepartidorDto sel = tblRepartidores.getSelectionModel().getSelectedItem();
        if (sel == null) { error("Selecciona un repartidor"); return; }
        controller.eliminarRepartidorDto(sel.getIdRepartidor());
        info("Repartidor eliminado correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void limpiar() {
        txtId.clear();
        txtNombre.clear();
        txtDocumento.clear();
        txtTelefono.clear();
        txtVehiculo.clear();
        txtPlaca.clear();
        txtZona.clear();
        comboDisponibilidad.getSelectionModel().clearSelection();
        tblRepartidores.getSelectionModel().clearSelection();
    }

    private boolean validar() {
        if (txtId.getText().isBlank() || txtNombre.getText().isBlank()) {
            error("El ID y el Nombre son obligatorios");
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
