package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import co.edu.uniquindio.biblioteca.parcial1.Controller.TarifaController;
import co.edu.uniquindio.biblioteca.parcial1.Dto.TarifaDto;
import co.edu.uniquindio.biblioteca.parcial1.Enum.PrioridadEnvio;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class TarifaViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtBase;
    @FXML private TextField txtPorPeso;
    @FXML private TextField txtPorVolumen;
    @FXML private TextField txtRecargo;
    @FXML private ComboBox<PrioridadEnvio> cmbPrioridad;
    @FXML private TableView<TarifaDto> tblTarifas;
    @FXML private TableColumn<TarifaDto, String> colId;
    @FXML private TableColumn<TarifaDto, Double> colBase;
    @FXML private TableColumn<TarifaDto, Double> colPorPeso;
    @FXML private TableColumn<TarifaDto, Double> colPorVolumen;
    @FXML private TableColumn<TarifaDto, Double> colRecargo;
    @FXML private TableColumn<TarifaDto, Double> colDescuento;

    private final TarifaController tarifaController = new TarifaController();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idTarifa"));
        colBase.setCellValueFactory(new PropertyValueFactory<>("costoBase"));
        colPorPeso.setCellValueFactory(new PropertyValueFactory<>("costoPorPeso"));
        colPorVolumen.setCellValueFactory(new PropertyValueFactory<>("costoPorVolumen"));
        colRecargo.setCellValueFactory(new PropertyValueFactory<>("costoDistancia"));
        colDescuento.setCellValueFactory(new PropertyValueFactory<>("costoPrioridad"));

        cmbPrioridad.getItems().setAll(PrioridadEnvio.values());
        cmbPrioridad.setValue(PrioridadEnvio.NORMAL);

        cargarTabla();

        tblTarifas.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, sel) -> {
            if (sel != null) {
                txtId.setText(sel.getIdTarifa());
                txtBase.setText(String.valueOf(sel.getCostoBase()));
                txtPorPeso.setText(String.valueOf(sel.getCostoPorPeso()));
                txtPorVolumen.setText(String.valueOf(sel.getCostoPorVolumen()));
                txtRecargo.setText(String.valueOf(sel.getCostoDistancia()));
            }
        });
    }

    private void cargarTabla() {
        tblTarifas.setItems(FXCollections.observableArrayList(tarifaController.listarTarifas()));
    }

    @FXML
    private void agregar() {
        if (!validar()) return;

        double costoPrioridad = obtenerCostoPrioridad(cmbPrioridad.getValue());

        TarifaDto nueva = new TarifaDto(
                txtId.getText(),
                Double.parseDouble(txtBase.getText()),
                Double.parseDouble(txtPorPeso.getText()),
                Double.parseDouble(txtPorVolumen.getText()),
                costoPrioridad,
                Double.parseDouble(txtRecargo.getText())
        );

        tarifaController.crearTarifa(nueva);
        info("Tarifa agregada correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void actualizar() {
        TarifaDto sel = tblTarifas.getSelectionModel().getSelectedItem();
        if (sel == null) { error("Selecciona una tarifa"); return; }
        if (!validar()) return;

        double costoPrioridad = obtenerCostoPrioridad(cmbPrioridad.getValue());

        TarifaDto actualizada = new TarifaDto(
                txtId.getText(),
                Double.parseDouble(txtBase.getText()),
                Double.parseDouble(txtPorPeso.getText()),
                Double.parseDouble(txtPorVolumen.getText()),
                costoPrioridad,
                Double.parseDouble(txtRecargo.getText())
        );

        tarifaController.actualizarTarifa(sel.getIdTarifa(), actualizada);
        info("Tarifa actualizada correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void eliminar() {
        TarifaDto sel = tblTarifas.getSelectionModel().getSelectedItem();
        if (sel == null) { error("Selecciona una tarifa"); return; }
        tarifaController.eliminarTarifa(sel.getIdTarifa());
        info("Tarifa eliminada correctamente");
        limpiar();
        cargarTabla();
    }

    @FXML
    private void limpiar() {
        txtId.clear();
        txtBase.clear();
        txtPorPeso.clear();
        txtPorVolumen.clear();
        txtRecargo.clear();
        cmbPrioridad.setValue(PrioridadEnvio.NORMAL);
        tblTarifas.getSelectionModel().clearSelection();
    }

    private boolean validar() {
        try {
            if (txtId.getText().isBlank()) { error("El ID es obligatorio"); return false; }
            Double.parseDouble(txtBase.getText());
            Double.parseDouble(txtPorPeso.getText());
            Double.parseDouble(txtPorVolumen.getText());
            Double.parseDouble(txtRecargo.getText());
        } catch (NumberFormatException e) {
            error("Los campos numéricos deben tener un valor válido");
            return false;
        }
        return true;
    }

    private double obtenerCostoPrioridad(PrioridadEnvio prioridad) {
        return switch (prioridad) {
            case URGENTE -> 400;
            case PRIORITARIO -> 250;
            case NORMAL -> 100;
        };
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
