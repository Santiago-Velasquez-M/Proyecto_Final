package co.edu.uniquindio.biblioteca.parcial1.ViewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class EmpresaLogisticaViewController {

    @FXML
    private TabPane tabPanePrincipal;

    @FXML
    private Tab tabUsuarios;

    @FXML
    private Tab tabEnvios;

    @FXML
    private Tab tabRepartidores;

    @FXML
    private Tab tabTarifas;

    @FXML
    private Tab tabPagos;

    @FXML
    public void initialize() {
        cargarVista(tabUsuarios, "/co/edu/uniquindio/biblioteca/parcial1/View/UsuariosView.fxml");
        cargarVista(tabEnvios, "/co/edu/uniquindio/biblioteca/parcial1/View/EnviosView.fxml");
        cargarVista(tabRepartidores, "/co/edu/uniquindio/biblioteca/parcial1/View/RepartidoresView.fxml");
        cargarVista(tabTarifas, "/co/edu/uniquindio/biblioteca/parcial1/View/TarifasView.fxml");
        cargarVista(tabPagos, "/co/edu/uniquindio/biblioteca/parcial1/View/PagosView.fxml");
    }

    private void cargarVista(Tab pestaña, String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent vista = loader.load();

            AnchorPane.setTopAnchor(vista, 0.0);
            AnchorPane.setBottomAnchor(vista, 0.0);
            AnchorPane.setLeftAnchor(vista, 0.0);
            AnchorPane.setRightAnchor(vista, 0.0);

            pestaña.setContent(vista);
        } catch (IOException e) {
            e.printStackTrace();
            pestaña.setContent(new javafx.scene.control.Label("Error al cargar la vista: " + rutaFXML));
        }
    }
}
