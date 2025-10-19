package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Model.Repartidor;
import java.util.List;

public interface IRepartidorService  {

    void crearRepartidor(Repartidor repartidor);
    Repartidor buscarRepartidorPorId(String id);
    void actualizarRepartidor(String id, Repartidor nuevoRepartidor);
    void eliminarRepartidor(String id);
    List<Repartidor> listarRepartidoresDisponibles();

}
