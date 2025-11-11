package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import co.edu.uniquindio.biblioteca.parcial1.Controller.EnvioController;
import co.edu.uniquindio.biblioteca.parcial1.Dto.EnvioDto;
import co.edu.uniquindio.biblioteca.parcial1.Enum.EstadoEnvio;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class EnvioViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtOrigen;
    @FXML private TextField txtDestino;
    @FXML private TextField txtPeso;
    @FXML private TextField txtVolumen;
    @FXML private TextField txtCosto;
    @FXML private ComboBox<EstadoEnvio> comboEstado;
    @FXML private TableView<EnvioDto> tablaEnvios;
    @FXML private TableColumn<EnvioDto, String> colId;
    @FXML private TableColumn<EnvioDto, String> colOrigen;
    @FXML private TableColumn<EnvioDto, String> colDestino;
    @FXML private TableColumn<EnvioDto, Double> colPeso;
    @FXML private TableColumn<EnvioDto, Double> colVolumen;
    @FXML private TableColumn<EnvioDto, Double> colCosto;
    @FXML private TableColumn<EnvioDto, EstadoEnvio> colEstado;
    @FXML private TableColumn<EnvioDto, LocalDateTime> colFecha;

    private final EnvioController envioController = new EnvioController();

    @FXML
    public void initialize() {
        comboEstado.setItems(FXCollections.observableArrayList(EstadoEnvio.values()));

        colId.setCellValueFactory(new PropertyValueFactory<>("idEnvio"));
        colOrigen.setCellValueFactory(new PropertyValueFactory<>("direccionOrigen"));
        colDestino.setCellValueFactory(new PropertyValueFactory<>("direccionDestino"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colVolumen.setCellValueFactory(new PropertyValueFactory<>("volumen"));
        colCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoEnvio"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));

        cargarTabla();

        tablaEnvios.getSelectionModel().selectedItemProperty().addListener((obs, o, s) -> {
            if (s != null) {
                txtId.setText(s.getIdEnvio());
                txtOrigen.setText(s.getDireccionOrigen());
                txtDestino.setText(s.getDireccionDestino());
                txtPeso.setText(String.valueOf(s.getPeso()));
                txtVolumen.setText(String.valueOf(s.getVolumen()));
                txtCosto.setText(String.valueOf(s.getCosto()));
                comboEstado.setValue(s.getEstadoEnvio());
            }
        });
    }

    private void cargarTabla() {
        List<EnvioDto> lista = envioController.listarTodosLosEnvios();
        tablaEnvios.setItems(FXCollections.observableArrayList(lista));
    }

    @FXML
    private void registrarEnvio() {
        if (!validar()) return;

        EnvioDto dto = new EnvioDto(
                txtId.getText().isBlank() ? UUID.randomUUID().toString() : txtId.getText(),
                txtOrigen.getText(),
                txtDestino.getText(),
                Double.parseDouble(txtPeso.getText()),
                Double.parseDouble(txtVolumen.getText()),
                Double.parseDouble(txtCosto.getText()),
                comboEstado.getValue() != null ? comboEstado.getValue() : EstadoEnvio.SOLICITADO,
                LocalDateTime.now()
        );

        envioController.crearEnvio(dto);

        info("Envío registrado correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void actualizarEnvio() {
        EnvioDto seleccionado = tablaEnvios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            error("Selecciona un envío para actualizar");
            return;
        }
        if (!validar()) return;

        seleccionado.setDireccionOrigen(txtOrigen.getText());
        seleccionado.setDireccionDestino(txtDestino.getText());
        seleccionado.setPeso(Double.parseDouble(txtPeso.getText()));
        seleccionado.setVolumen(Double.parseDouble(txtVolumen.getText()));
        seleccionado.setCosto(Double.parseDouble(txtCosto.getText()));
        seleccionado.setEstadoEnvio(comboEstado.getValue());

        envioController.actualizarEnvio(seleccionado.getIdEnvio(), seleccionado);

        info("Envío actualizado correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void eliminarEnvio() {
        EnvioDto seleccionado = tablaEnvios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            error("Selecciona un envío para eliminar");
            return;
        }

        envioController.eliminarEnvio(seleccionado.getIdEnvio());

        info("Envío eliminado correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void limpiar() {
        txtId.clear();
        txtOrigen.clear();
        txtDestino.clear();
        txtPeso.clear();
        txtVolumen.clear();
        txtCosto.clear();
        comboEstado.getSelectionModel().clearSelection();
        tablaEnvios.getSelectionModel().clearSelection();
    }

    private boolean validar() {
        try {
            if (txtOrigen.getText().isBlank() || txtDestino.getText().isBlank()) {
                error("Los campos Origen y Destino son obligatorios");
                return false;
            }
            Double.parseDouble(txtPeso.getText());
            Double.parseDouble(txtVolumen.getText());
            Double.parseDouble(txtCosto.getText());
            return true;
        } catch (NumberFormatException e) {
            error("Verifica que peso, volumen y costo sean valores numéricos");
            return false;
        }
    }

    private void info(String mensaje) { alerta(Alert.AlertType.INFORMATION, mensaje); }
    private void error(String mensaje) { alerta(Alert.AlertType.ERROR, mensaje); }

    private void alerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
