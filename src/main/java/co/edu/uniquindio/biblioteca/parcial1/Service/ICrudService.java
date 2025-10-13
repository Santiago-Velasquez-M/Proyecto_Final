package co.edu.uniquindio.biblioteca.parcial1.Service;

import java.util.List;

public interface ICrudService<T> {
    void crear(T entidad);
    void actualizar(T entidad);
    void eliminar(T entidad);
    List<T> listar();
}
