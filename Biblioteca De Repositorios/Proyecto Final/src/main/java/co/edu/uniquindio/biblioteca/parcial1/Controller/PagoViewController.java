package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Enum.MetodoPago;
import co.edu.uniquindio.biblioteca.parcial1.Enum.ResultadoPago;
import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Model.Pago;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.format.DateTimeFormatter;

public class PagoViewController {

    @FXML private TextField txtIdPago;
    @FXML private TextField txtMonto;
    @FXML private ComboBox<MetodoPago> comboMetodo;
    @FXML private ComboBox<ResultadoPago> comboResultado;

    @FXML private TableView<Pago> tablaPagos;
    @FXML private TableColumn<Pago, String> colIdPago;
    @FXML private TableColumn<Pago, String> colMonto;
    @FXML private TableColumn<Pago, String> colMetodo;
    @FXML private TableColumn<Pago, String> colFecha;
    @FXML private TableColumn<Pago, String> colResultado;

    private final ModelFactory modelFactory = ModelFactory.getInstance();
    private final ObservableList<Pago> listaPagos = FXCollections.observableArrayList();
    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    @FXML
    public void initialize() {
        try {
            configurarCombos();
            configurarColumnas();
            cargarPagos();
            configurarSeleccionTabla();
        } catch (Exception e) {
            System.err.println("Error al inicializar PagoViewController: " + e.getMessage());
        }
    }

    private void configurarCombos() {
        if (comboMetodo != null)
            comboMetodo.setItems(FXCollections.observableArrayList(MetodoPago.values()));
        if (comboResultado != null)
            comboResultado.setItems(FXCollections.observableArrayList(ResultadoPago.values()));
    }

    private void configurarColumnas() {
        colIdPago.setCellValueFactory(data ->
                new SimpleStringProperty(obtenerTextoSeguro(data.getValue().getIdPago())));

        colMonto.setCellValueFactory(data ->
                new SimpleStringProperty(String.format("$ %.2f", data.getValue().getMonto())));

        colMetodo.setCellValueFactory(data ->
                new SimpleStringProperty(
                        data.getValue().getMetodoPago() != null
                                ? data.getValue().getMetodoPago().toString()
                                : "Sin método"));

        colFecha.setCellValueFactory(data ->
                new SimpleStringProperty(
                        data.getValue().getFechaPago() != null
                                ? data.getValue().getFechaPago().format(formatoFecha)
                                : "Sin fecha"));

        colResultado.setCellValueFactory(data ->
                new SimpleStringProperty(
                        data.getValue().getResultado() != null
                                ? data.getValue().getResultado().toString()
                                : "Sin resultado"));
    }

    @FXML
    private void cargarPagos() {
        listaPagos.setAll(modelFactory.getPagoRepository().obtenerPagos());
        tablaPagos.setItems(listaPagos);
    }

    @FXML
    private void agregarPago() {
        String idPago = txtIdPago.getText().trim();
        String montoStr = txtMonto.getText().trim();
        MetodoPago metodo = comboMetodo.getValue();
        ResultadoPago resultado = comboResultado.getValue();

        if (idPago.isEmpty() || montoStr.isEmpty() || metodo == null || resultado == null) {
            mostrarAlerta("Error", "Por favor completa todos los campos.");
            return;
        }

        double monto;
        try {
            monto = Double.parseDouble(montoStr);
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El monto debe ser un número válido.");
            return;
        }

        Pago nuevo = new Pago(idPago, monto, metodo, resultado);
        modelFactory.getPagoRepository().agregarPago(nuevo);
        listaPagos.add(nuevo);
        limpiarCampos();
        mostrarAlerta("Éxito", "Pago registrado correctamente.");
    }

    @FXML
    private void eliminarPago() {
        Pago seleccionado = tablaPagos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Atención", "Selecciona un pago para eliminar.");
            return;
        }

        modelFactory.getPagoRepository().eliminarPago(seleccionado.getIdPago());
        listaPagos.remove(seleccionado);
        mostrarAlerta("Éxito", "Pago eliminado correctamente.");
    }

    private void configurarSeleccionTabla() {
        tablaPagos.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, nuevo) -> {
            if (nuevo != null) {
                txtIdPago.setText(obtenerTextoSeguro(nuevo.getIdPago()));
                txtMonto.setText(String.valueOf(nuevo.getMonto()));
                comboMetodo.setValue(nuevo.getMetodoPago());
                comboResultado.setValue(nuevo.getResultado());
            }
        });
    }

    private void limpiarCampos() {
        txtIdPago.clear();
        txtMonto.clear();
        comboMetodo.getSelectionModel().clearSelection();
        comboResultado.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private String obtenerTextoSeguro(String texto) {
        return texto != null ? texto : "";
    }
}
