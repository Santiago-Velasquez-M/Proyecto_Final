package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Model.Direccion;

public interface IDireccionService extends ICrudService<Direccion> {

    Direccion buscarPorCiudad(String ciudad);
}
