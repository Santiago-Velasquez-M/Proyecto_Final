package co.edu.uniquindio.biblioteca.parcial1.Service.impl;

import co.edu.uniquindio.biblioteca.parcial1.Model.Direccion;
import co.edu.uniquindio.biblioteca.parcial1.Service.IDireccionService;
import co.edu.uniquindio.biblioteca.parcial1.Singleton.DataStore;

import java.util.List;


public class DireccionService implements IDireccionService {

    private final DataStore dataStore = DataStore.getInstance();


    @Override
    public void crearDireccion(Direccion direccion) {
        if (direccion != null && buscarDireccionPorId(direccion.getIdDireccion()) == null) {
            dataStore.getDirecciones().add(direccion);
        }
    }


    @Override
    public Direccion buscarDireccionPorId(String idDireccion) {
        if (idDireccion == null || idDireccion.isBlank()) return null;
        for (Direccion actual : dataStore.getDirecciones()) {
            if (actual.getIdDireccion().equalsIgnoreCase(idDireccion)) {
                return actual;
            }
        }
        return null;
    }


    @Override
    public void actualizarDireccion(String idDireccion, Direccion nuevaDireccion) {
        if (idDireccion == null || nuevaDireccion == null) return;
        List<Direccion> direcciones = dataStore.getDirecciones();
        for (int i = 0; i < direcciones.size(); i++) {
            Direccion actual = direcciones.get(i);
            if (actual.getIdDireccion().equalsIgnoreCase(idDireccion)) {
                direcciones.set(i, nuevaDireccion);
                return;
            }
        }
    }


    @Override
    public void eliminarDireccion(String idDireccion) {
        if (idDireccion == null || idDireccion.isBlank()) return;
        dataStore.getDirecciones().removeIf(
                dir -> dir.getIdDireccion().equalsIgnoreCase(idDireccion)
        );
    }

    @Override
    public List<Direccion> listarDirecciones() {
        return dataStore.getDirecciones();
    }
}
