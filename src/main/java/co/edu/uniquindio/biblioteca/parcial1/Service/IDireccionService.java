package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Model.Direccion;

public interface IDireccionService {

    boolean crearDireccion(Direccion direccion);
    Direccion buscarDireccionPorId(String idDireccion);
    boolean actualizarDireccion(String idDireccion, Direccion nuevaDireccion);
    boolean eliminarDireccion(String idDireccion);

}
