package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import co.edu.uniquindio.biblioteca.parcial1.Controller.UsuarioPrincipalController;
import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import co.edu.uniquindio.biblioteca.parcial1.Model.Pago;
import co.edu.uniquindio.biblioteca.parcial1.Model.Tarifa;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class UsuarioPrincipalViewController {

    @FXML private Label lblNombre;
    @FXML private Label lblCorreo;

    @FXML private TableView<Envio> tblEnvios;
    @FXML private TableColumn<Envio, String> colIdEnvio;
    @FXML private TableColumn<Envio, String> colEstadoEnvio;
    @FXML private TableColumn<Envio, String> colFechaEnvio;

    @FXML private TableView<Pago> tblPagos;
    @FXML private TableColumn<Pago, String> colIdPago;
    @FXML private TableColumn<Pago, Double> colMontoPago;
    @FXML private TableColumn<Pago, String> colMetodoPago;
    @FXML private TableColumn<Pago, String> colResultadoPago;

    @FXML private TableView<Tarifa> tblTarifas;
    @FXML private TableColumn<Tarifa, String> colIdTarifa;
    @FXML private TableColumn<Tarifa, Double> colCostoBase;

    @FXML private TextField txtPeso;
    @FXML private TextField txtVolumen;
    @FXML private CheckBox chkLocal;
    @FXML private Label lblCostoCalculado;

    private UsuarioPrincipalController usuarioController;

    public void setUsuario(Usuario usuario) {
        this.usuarioController = new UsuarioPrincipalController(usuario);
        cargarDatosUsuario();
        cargarMisEnvios();
        cargarMisPagos();
        cargarTarifas();
    }

    @FXML
    public void initialize() {
        // Columnas de envíos
        colIdEnvio.setCellValueFactory(new PropertyValueFactory<>("idEnvio"));
        colEstadoEnvio.setCellValueFactory(new PropertyValueFactory<>("estadoEnvio"));
        colFechaEnvio.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));

        // Columnas de pagos
        colIdPago.setCellValueFactory(new PropertyValueFactory<>("idPago"));
        colMontoPago.setCellValueFactory(new PropertyValueFactory<>("monto"));
        colMetodoPago.setCellValueFactory(new PropertyValueFactory<>("metodoPago"));
        colResultadoPago.setCellValueFactory(new PropertyValueFactory<>("resultado"));

        // Columnas de tarifas
        colIdTarifa.setCellValueFactory(new PropertyValueFactory<>("idTarifa"));
        colCostoBase.setCellValueFactory(new PropertyValueFactory<>("costoBase"));
    }

    // --------------------------
    // MÉTODOS DE CARGA DE INFO
    // --------------------------

    private void cargarDatosUsuario() {
        Usuario u = usuarioController.getUsuarioActual();
        lblNombre.setText(u.getNombreCompleto());
        lblCorreo.setText(u.getCorreo());
    }

    private void cargarMisEnvios() {
        tblEnvios.setItems(FXCollections.observableArrayList(
                usuarioController.listarMisEnvios()
        ));
    }

    private void cargarMisPagos() {
        tblPagos.setItems(FXCollections.observableArrayList(
                usuarioController.listarMisPagos()
        ));
    }

    private void cargarTarifas() {
        tblTarifas.setItems(FXCollections.observableArrayList(
                usuarioController.listarTarifas()
        ));
    }

    // --------------------------
    // CALCULAR COSTO
    // --------------------------

    @FXML
    private void calcularCosto() {
        try {
            double peso = Double.parseDouble(txtPeso.getText());
            double volumen = Double.parseDouble(txtVolumen.getText());
            boolean local = chkLocal.isSelected();

            double costo = usuarioController.calcularCosto(peso, volumen, local);

            lblCostoCalculado.setText("$ " + costo);

        } catch (Exception e) {
            mostrarError("Debes ingresar números válidos en peso y volumen.");
        }
    }


    private void mostrarError(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.show();
    }
}
