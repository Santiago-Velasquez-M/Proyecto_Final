package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Model.Repartidor;
import java.util.List;

public interface IRepartidorService extends ICrudService<Repartidor> {

    List<Repartidor> listarDisponibles();
}
