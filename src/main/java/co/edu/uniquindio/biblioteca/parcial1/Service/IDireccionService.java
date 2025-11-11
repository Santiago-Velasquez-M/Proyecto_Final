package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Model.Direccion;
import java.util.List;


public interface IDireccionService {

    void crearDireccion(Direccion direccion);


    Direccion buscarDireccionPorId(String id);


    void actualizarDireccion(String id, Direccion nuevaDireccion);


    void eliminarDireccion(String id);


    List<Direccion> listarDirecciones();
}
