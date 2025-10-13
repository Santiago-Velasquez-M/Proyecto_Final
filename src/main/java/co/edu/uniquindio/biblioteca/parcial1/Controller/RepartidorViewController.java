package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Model.Repartidor;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RepartidorViewController {

    @FXML private TableView<Repartidor> tablaRepartidores;
    @FXML private TableColumn<Repartidor, String> colId;
    @FXML private TableColumn<Repartidor, String> colNombre;
    @FXML private TableColumn<Repartidor, String> colTelefono;
    @FXML private TableColumn<Repartidor, String> colVehiculo;
    @FXML private TableColumn<Repartidor, String> colPlaca;
    @FXML private TableColumn<Repartidor, String> colDisponible;

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtVehiculo;
    @FXML private TextField txtPlaca;

    private final ObservableList<Repartidor> listaRepartidores = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configurar columnas
        colId.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getId()));
        colNombre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        colTelefono.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTelefono()));
        colVehiculo.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getVehiculo()));
        colPlaca.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getPlaca()));
        colDisponible.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(
                data.getValue().isDisponible() ? "Sí" : "No"
        ));

        tablaRepartidores.setItems(listaRepartidores);
    }

    @FXML
    public void agregarRepartidor() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String vehiculo = txtVehiculo.getText();
        String placa = txtPlaca.getText();

        if (id.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || vehiculo.isEmpty() || placa.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios");
            return;
        }

        Repartidor nuevo = new Repartidor(id, nombre, telefono, vehiculo, placa);
        listaRepartidores.add(nuevo);
        limpiarCampos();
    }

    @FXML
    public void eliminarRepartidor() {
        Repartidor seleccionado = tablaRepartidores.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaRepartidores.remove(seleccionado);
        } else {
            mostrarAlerta("Error", "Selecciona un repartidor para eliminar");
        }
    }

    @FXML
    public void actualizarRepartidor() {
        Repartidor seleccionado = tablaRepartidores.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Error", "Selecciona un repartidor para actualizar");
            return;
        }

        seleccionado.setNombre(txtNombre.getText());
        seleccionado.setTelefono(txtTelefono.getText());
        seleccionado.setVehiculo(txtVehiculo.getText());
        seleccionado.setPlaca(txtPlaca.getText());
        tablaRepartidores.refresh();
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtTelefono.clear();
        txtVehiculo.clear();
        txtPlaca.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
