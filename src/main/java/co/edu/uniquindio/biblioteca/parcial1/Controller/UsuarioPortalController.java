package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class UsuarioPortalController {

    @FXML
    private Label lblNombreUsuario;

    @FXML
    private TableView<?> tablaEnvios;

    @FXML
    private TableColumn<?, ?> colIdEnvio;

    @FXML
    private TableColumn<?, ?> colEstadoEnvio;

    @FXML
    private TableColumn<?, ?> colFecha;

    private Usuario usuarioLogueado;

    public void setUsuarioLogueado(Usuario usuario) {
        this.usuarioLogueado = usuario;

        if (lblNombreUsuario != null && usuario != null) {
            lblNombreUsuario.setText(usuario.getNombreCompleto());
        }


    }

    // Método que luego puedes implementar para mostrar los envíos en la tabla
    private void cargarEnviosDelUsuario() {
        // Ejemplo:
        // List<Envio> envios = modelFactory.getEnvioService().buscarPorUsuario(usuarioLogueado);
        // tablaEnvios.setItems(FXCollections.observableArrayList(envios));
    }
}
