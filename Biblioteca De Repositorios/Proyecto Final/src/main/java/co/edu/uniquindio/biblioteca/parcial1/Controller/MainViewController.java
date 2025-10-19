package co.edu.uniquindio.biblioteca.parcial1.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

public class MainViewController {

    @FXML
    private TabPane tabPane;

    @FXML
    public void initialize() {
        System.out.println("MainViewController inicializado correctamente.");
    }
}
