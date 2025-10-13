package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDateTime;

public class EnvioViewController {

    @FXML private TableView<Envio> tablaEnvios;
    @FXML private TableColumn<Envio, String> colId;
    @FXML private TableColumn<Envio, String> colOrigen;
    @FXML private TableColumn<Envio, String> colDestino;
    @FXML private TableColumn<Envio, Double> colPeso;
    @FXML private TableColumn<Envio, Double> colVolumen;
    @FXML private TableColumn<Envio, Double> colCosto;
    @FXML private TableColumn<Envio, String> colRepartidor;
    @FXML private TableColumn<Envio, String> colUsuario;

    @FXML private TextField txtId, txtOrigen, txtDestino, txtPeso, txtVolumen, txtCosto;
    @FXML private ComboBox<Repartidor> comboRepartidor;
    @FXML private ComboBox<Usuario> comboUsuario;

    private final ModelFactory modelFactory = ModelFactory.getInstance();
    private final ObservableList<Envio> listaEnvios = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        configurarColumnas();
        actualizarCombos();
        cargarEnvios();
        configurarSeleccionTabla();
    }

    private void configurarColumnas() {
        colId.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getId()));
        colOrigen.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                c.getValue().getOrigen() != null ? c.getValue().getOrigen().getDireccion() : ""));
        colDestino.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                c.getValue().getDestino() != null ? c.getValue().getDestino().getDireccion() : ""));
        colPeso.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getPeso()));
        colVolumen.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getVolumen()));
        colCosto.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getCosto()));
        colRepartidor.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                c.getValue().getRepartidor() != null ? c.getValue().getRepartidor().getNombre() : ""));
        colUsuario.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                c.getValue().getUsuario() != null ? c.getValue().getUsuario().getNombreCompleto() : ""));
    }

    @FXML
    private void actualizarCombos() {
        comboRepartidor.setItems(FXCollections.observableArrayList(
                modelFactory.getRepartidorRepository().obtenerRepartidores()
        ));
        comboUsuario.setItems(FXCollections.observableArrayList(
                modelFactory.getUsuarioRepository().obtenerUsuarios()
        ));

        // Configuración visual de los combos
        comboRepartidor.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Repartidor item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNombre());
            }
        });
        comboRepartidor.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Repartidor item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNombre());
            }
        });

        comboUsuario.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Usuario item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNombreCompleto());
            }
        });
        comboUsuario.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Usuario item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNombreCompleto());
            }
        });
    }

    @FXML
    private void cargarEnvios() {
        listaEnvios.setAll(modelFactory.getEnvioRepository().obtenerEnvios());
        tablaEnvios.setItems(listaEnvios);
        actualizarCombos(); // 🔁 Cada vez que recargas la lista, actualiza también los combos
    }

    @FXML
    private void agregarEnvio() {
        try {
            String id = txtId.getText();
            double peso = Double.parseDouble(txtPeso.getText());
            double volumen = Double.parseDouble(txtVolumen.getText());
            double costo = Double.parseDouble(txtCosto.getText());
            Repartidor repartidor = comboRepartidor.getValue();
            Usuario usuario = comboUsuario.getValue();

            if (repartidor == null || usuario == null) {
                mostrarAlerta("Error", "Debes seleccionar un repartidor y un usuario.");
                return;
            }

            Envio envio = new Envio(
                    new Direccion("D001", "Origen", txtOrigen.getText(), "", ""),
                    new Direccion("D002", "Destino", txtDestino.getText(), "", ""),
                    peso, volumen, costo, LocalDateTime.now().plusDays(2),
                    repartidor, usuario, null
            );
            envio.setId(id);

            modelFactory.getEnvioRepository().agregarEnvio(envio);
            cargarEnvios();
            limpiarCampos();
            mostrarAlerta("Éxito", "Envío agregado correctamente.");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Los campos de peso, volumen y costo deben ser numéricos.");
        }
    }

    @FXML
    private void actualizarEnvio() {
        Envio seleccionado = tablaEnvios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Error", "Selecciona un envío para actualizar.");
            return;
        }

        try {
            seleccionado.setOrigen(new Direccion("D001", "Origen", txtOrigen.getText(), "", ""));
            seleccionado.setDestino(new Direccion("D002", "Destino", txtDestino.getText(), "", ""));
            seleccionado.setPeso(Double.parseDouble(txtPeso.getText()));
            seleccionado.setVolumen(Double.parseDouble(txtVolumen.getText()));
            seleccionado.setCosto(Double.parseDouble(txtCosto.getText()));
            seleccionado.setRepartidor(comboRepartidor.getValue());
            seleccionado.setUsuario(comboUsuario.getValue());

            tablaEnvios.refresh();
            mostrarAlerta("Éxito", "Envío actualizado correctamente.");
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Los campos de peso, volumen y costo deben ser numéricos.");
        }
    }

    @FXML
    private void eliminarEnvio() {
        Envio seleccionado = tablaEnvios.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            modelFactory.getEnvioRepository().eliminarEnvio(seleccionado.getId());
            cargarEnvios();
            mostrarAlerta("Éxito", "Envío eliminado correctamente.");
        } else {
            mostrarAlerta("Error", "Selecciona un envío para eliminar.");
        }
    }

    private void configurarSeleccionTabla() {
        tablaEnvios.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txtId.setText(newSel.getId());
                txtOrigen.setText(newSel.getOrigen() != null ? newSel.getOrigen().getDireccion() : "");
                txtDestino.setText(newSel.getDestino() != null ? newSel.getDestino().getDireccion() : "");
                txtPeso.setText(String.valueOf(newSel.getPeso()));
                txtVolumen.setText(String.valueOf(newSel.getVolumen()));
                txtCosto.setText(String.valueOf(newSel.getCosto()));
                comboRepartidor.setValue(newSel.getRepartidor());
                comboUsuario.setValue(newSel.getUsuario());
            }
        });
    }

    private void limpiarCampos() {
        txtId.clear();
        txtOrigen.clear();
        txtDestino.clear();
        txtPeso.clear();
        txtVolumen.clear();
        txtCosto.clear();
        comboRepartidor.getSelectionModel().clearSelection();
        comboUsuario.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
