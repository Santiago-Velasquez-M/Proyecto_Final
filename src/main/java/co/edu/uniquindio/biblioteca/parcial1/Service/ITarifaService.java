package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Model.Tarifa;
import java.util.List;


public interface ITarifaService {

    void crearTarifa(Tarifa tarifa);

    Tarifa buscarTarifaPorId(String id);


    void actualizarTarifa(String id, Tarifa nuevaTarifa);


    void eliminarTarifa(String id);

    List<Tarifa> listarTarifas();


    double calcularCosto(double peso, double volumen, boolean prioridad);
}
