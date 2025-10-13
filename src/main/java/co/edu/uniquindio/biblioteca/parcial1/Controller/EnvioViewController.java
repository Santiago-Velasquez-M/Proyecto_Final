package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EnvioViewController {

    @FXML
    private TableView<Envio> tablaEnvios;

    @FXML
    private TableColumn<Envio, String> colId;
    @FXML
    private TableColumn<Envio, String> colOrigen;
    @FXML
    private TableColumn<Envio, String> colDestino;
    @FXML
    private TableColumn<Envio, Double> colPeso;
    @FXML
    private TableColumn<Envio, Double> colVolumen;
    @FXML
    private TableColumn<Envio, Double> colCosto;
    @FXML
    private TableColumn<Envio, String> colRepartidor;
    @FXML
    private TableColumn<Envio, String> colUsuario;

    @FXML
    private TextField txtId, txtOrigen, txtDestino, txtPeso, txtVolumen, txtCosto, txtRepartidor, txtUsuario;

    private final ModelFactory modelFactory = ModelFactory.getInstance();
    private final ObservableList<Envio> listaEnvios = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        configurarColumnas();
        cargarEnvios();
    }

    private void configurarColumnas() {
        colId.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getId()));
        colOrigen.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
                cellData.getValue().getOrigen() != null ? cellData.getValue().getOrigen().getDireccion() : ""));
        colDestino.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
                cellData.getValue().getDestino() != null ? cellData.getValue().getDestino().getDireccion() : ""));
        colPeso.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getPeso()));
        colVolumen.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getVolumen()));
        colCosto.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getCosto()));
        colRepartidor.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
                cellData.getValue().getRepartidor() != null ? cellData.getValue().getRepartidor().getNombre() : ""));
        colUsuario.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
                cellData.getValue().getUsuario() != null ? cellData.getValue().getUsuario().getNombre() : ""));
    }

    @FXML
    private void cargarEnvios() {
        listaEnvios.setAll(modelFactory.getEnvioRepository().getListaEnvios());
        tablaEnvios.setItems(listaEnvios);
    }

    @FXML
    private void agregarEnvio() {
        mostrarAlerta("Agregar", "Funcionalidad de agregar envío en desarrollo.");
    }

    @FXML
    private void actualizarEnvio() {
        mostrarAlerta("Actualizar", "Funcionalidad de actualizar envío en desarrollo.");
    }

    @FXML
    private void eliminarEnvio() {
        mostrarAlerta("Eliminar", "Funcionalidad de eliminar envío en desarrollo.");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
