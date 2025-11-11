package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Model.Repartidor;
import java.util.List;

public interface IRepartidorService {

    void crearRepartidor(Repartidor repartidor);
    Repartidor buscarRepartidorPorId(String idRepartidor);
    void actualizarRepartidor(String idRepartidor, Repartidor nuevoRepartidor);
    void eliminarRepartidor(String idRepartidor);
    List<Repartidor> listarRepartidores();
    List<Repartidor> listarRepartidoresDisponibles();
}
