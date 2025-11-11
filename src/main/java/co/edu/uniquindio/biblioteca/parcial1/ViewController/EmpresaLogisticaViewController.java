package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class EmpresaLogisticaViewController {

    @FXML private TabPane tabPanePrincipal;
    @FXML private Tab tabUsuarios;
    @FXML private Tab tabEnvios;
    @FXML private Tab tabRepartidores;
    @FXML private Tab tabPagos;
    @FXML private Tab tabTarifas;
    @FXML private Tab tabDirecciones;

    @FXML
    public void initialize() {

        cargarVista(tabUsuarios, "/view/UsuariosView.fxml");
        cargarVista(tabEnvios, "/view/EnviosView.fxml");
        cargarVista(tabRepartidores, "/view/RepartidoresView.fxml");
        cargarVista(tabPagos, "/view/PagosView.fxml");
        cargarVista(tabTarifas, "/view/TarifaView.fxml");
        cargarVista(tabDirecciones, "/view/DireccionView.fxml");
    }

    private void cargarVista(Tab tab, String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent vista = loader.load();
            tab.setContent(vista);
        } catch (Exception e) {
            e.printStackTrace();
            tab.setContent(new Label("⚠️ Error al cargar " + rutaFXML));
        }
    }
}
