package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;

public class EmpresaLogisticaViewController {

    @FXML
    private TabPane tabPanePrincipal;

    @FXML
    private Tab tabUsuarios;

    @FXML
    private Tab tabEnvios;

    @FXML
    private Tab tabTarifas;

    @FXML
    public void initialize() {
        cargarVista(tabUsuarios, "/co/edu/uniquindio/biblioteca/parcial1/View/UsuariosView.fxml");
    }

    private void cargarVista(Tab pestaña, String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent vista = loader.load();
            pestaña.setContent(vista);
        } catch (IOException e) {
            e.printStackTrace();
            pestaña.setContent(new javafx.scene.control.Label("⚠️ Error al cargar: " + rutaFXML));
        }
    }
}
