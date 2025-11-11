package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import co.edu.uniquindio.biblioteca.parcial1.Controller.PagoController;
import co.edu.uniquindio.biblioteca.parcial1.Dto.PagoDto;
import co.edu.uniquindio.biblioteca.parcial1.Enum.MetodoPago;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PagosViewController {

    @FXML private TextField txtIdPago;
    @FXML private TextField txtMonto;
    @FXML private ComboBox<MetodoPago> comboMetodoPago;
    @FXML private DatePicker dateFechaPago;
    @FXML private TableView<PagoDto> tablaPagos;
    @FXML private TableColumn<PagoDto, String> colIdPago;
    @FXML private TableColumn<PagoDto, String> colMetodo;
    @FXML private TableColumn<PagoDto, Double> colMonto;
    @FXML private TableColumn<PagoDto, String> colFecha;

    private final PagoController pagoController = new PagoController();

    @FXML
    public void initialize() {
        comboMetodoPago.setItems(FXCollections.observableArrayList(MetodoPago.values()));

        colIdPago.setCellValueFactory(new PropertyValueFactory<>("idPago"));
        colMetodo.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getMetodoPago()));
        colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        colFecha.setCellValueFactory(p ->
                new SimpleStringProperty(p.getValue().getFechaPago() != null ?
                        p.getValue().getFechaPago().toString() : "")
        );

        cargarTabla();

        tablaPagos.getSelectionModel().selectedItemProperty().addListener((obs, o, s) -> {
            if (s != null) {
                txtIdPago.setText(s.getIdPago());
                txtMonto.setText(String.valueOf(s.getMonto()));
                comboMetodoPago.setValue(MetodoPago.valueOf(s.getMetodoPago()));
                dateFechaPago.setValue(s.getFechaPago() != null ? s.getFechaPago().toLocalDate() : null);
            }
        });
    }

    private void cargarTabla() {
        tablaPagos.setItems(FXCollections.observableArrayList(pagoController.listarPagos()));
    }

    @FXML
    private void registrarPago() {
        if (!validar()) return;

        PagoDto dto = new PagoDto(
                txtIdPago.getText().isBlank() ? null : txtIdPago.getText(),
                null,
                comboMetodoPago.getValue().name(),
                Double.parseDouble(txtMonto.getText()),
                dateFechaPago.getValue() != null ? dateFechaPago.getValue().atStartOfDay() : LocalDateTime.now()
        );

        pagoController.crearPago(dto);
        info("Pago registrado correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void actualizarPago() {
        PagoDto seleccionado = tablaPagos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) { error("Selecciona un pago de la tabla"); return; }
        if (!validar()) return;

        PagoDto dto = new PagoDto(
                seleccionado.getIdPago(),
                null,
                comboMetodoPago.getValue().name(),
                Double.parseDouble(txtMonto.getText()),
                dateFechaPago.getValue() != null ? dateFechaPago.getValue().atStartOfDay() : LocalDateTime.now()
        );

        pagoController.actualizarPago(seleccionado.getIdPago(), dto);
        info("Pago actualizado correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void eliminarPago() {
        PagoDto seleccionado = tablaPagos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) { error("Selecciona un pago para eliminar"); return; }

        pagoController.eliminarPago(seleccionado.getIdPago());
        info("Pago eliminado correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void limpiar() {
        txtIdPago.clear();
        txtMonto.clear();
        comboMetodoPago.getSelectionModel().clearSelection();
        dateFechaPago.setValue(null);
        tablaPagos.getSelectionModel().clearSelection();
    }

    private boolean validar() {
        try {
            if (comboMetodoPago.getValue() == null) {
                error("Selecciona un método de pago");
                return false;
            }
            Double.parseDouble(txtMonto.getText());
            return true;
        } catch (Exception e) {
            error("El monto debe ser numérico");
            return false;
        }
    }

    private void info(String m){ alerta(Alert.AlertType.INFORMATION, m); }
    private void error(String m){ alerta(Alert.AlertType.ERROR, m); }
    private void alerta(Alert.AlertType t, String m){
        Alert a = new Alert(t); a.setHeaderText(null); a.setContentText(m); a.showAndWait();
    }
}
