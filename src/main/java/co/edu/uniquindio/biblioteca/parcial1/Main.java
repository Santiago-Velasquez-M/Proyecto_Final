package co.edu.uniquindio.biblioteca.parcial1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Carga la vista principal del sistema (con el TabPane)
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/co/edu/uniquindio/biblioteca/parcial1/View/EmpresaLogisticaView.fxml")
        );

        Scene scene = new Scene(loader.load());
        stage.setTitle("🚚 Sistema de Envíos - Empresa Logística");
        stage.setScene(scene);
        stage.setResizable(false); // para mantener el tamaño fijo
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
