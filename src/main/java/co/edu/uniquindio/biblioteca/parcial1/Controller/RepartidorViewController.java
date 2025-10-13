package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Model.Repartidor;
import javafx.beans.property.SimpleStringProperty;
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

    private final ModelFactory modelFactory = ModelFactory.getInstance();

    private final ObservableList<Repartidor> listaRepartidores = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        configurarColumnas();
        cargarRepartidores();
        configurarSeleccionTabla();
    }

    private void configurarColumnas() {
        colId.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));
        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        colTelefono.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTelefono()));
        colVehiculo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getVehiculo()));
        colPlaca.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPlaca()));
        colDisponible.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().isDisponible() ? "Sí" : "No"));
    }

    private void cargarRepartidores() {
        listaRepartidores.setAll(modelFactory.getRepartidorRepository().obtenerRepartidores());
        tablaRepartidores.setItems(listaRepartidores);

        System.out.println("Repartidores cargados: " + listaRepartidores.size());
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
        modelFactory.getRepartidorRepository().agregarRepartidor(nuevo);

        limpiarCampos();
        mostrarAlerta("Éxito", "Repartidor agregado correctamente");
    }

    @FXML
    public void eliminarRepartidor() {
        Repartidor seleccionado = tablaRepartidores.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            modelFactory.getRepartidorRepository().eliminarRepartidor(seleccionado.getId());
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

        modelFactory.getRepartidorRepository().actualizarRepartidor(seleccionado);
        limpiarCampos();
        mostrarAlerta("Éxito", "Repartidor actualizado correctamente");
    }

    private void configurarSeleccionTabla() {
        tablaRepartidores.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txtId.setText(newSel.getId());
                txtNombre.setText(newSel.getNombre());
                txtTelefono.setText(newSel.getTelefono());
                txtVehiculo.setText(newSel.getVehiculo());
                txtPlaca.setText(newSel.getPlaca());
            }
        });
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
