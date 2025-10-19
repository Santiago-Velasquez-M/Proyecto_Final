package co.edu.uniquindio.biblioteca.parcial1.Service.impl;

import co.edu.uniquindio.biblioteca.parcial1.Model.Direccion;
import co.edu.uniquindio.biblioteca.parcial1.Service.IDireccionService;
import co.edu.uniquindio.biblioteca.parcial1.Singleton.DataStore;

import java.util.List;

public class DireccionService implements IDireccionService {

    private final DataStore dataStore = DataStore.getInstance();

    @Override
    public boolean crearDireccion(Direccion direccion) {
        if (direccion == null) return false;

        List<Direccion> direcciones = dataStore.getDirecciones();

        for (int i = 0; i < direcciones.size(); i++) {
            Direccion d = direcciones.get(i);
            if (d.getIdDireccion().equalsIgnoreCase(direccion.getIdDireccion())) {
                return false;
            }
        }

        direcciones.add(direccion);
        return true;
    }

    @Override
    public Direccion buscarDireccionPorId(String idDireccion) {
        List<Direccion> direcciones = dataStore.getDirecciones();
        for (int i = 0; i < direcciones.size(); i++) {
            Direccion actual = direcciones.get(i);
            if (actual.getIdDireccion().equalsIgnoreCase(idDireccion)) {
                return actual;
            }
        }
        return null;
    }

    @Override
    public boolean actualizarDireccion(String idDireccion, Direccion nuevaDireccion) {
        List<Direccion> direcciones = dataStore.getDirecciones();
        for (int i = 0; i < direcciones.size(); i++) {
            Direccion actual = direcciones.get(i);
            if (actual.getIdDireccion().equalsIgnoreCase(idDireccion)) {
                direcciones.set(i, nuevaDireccion);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarDireccion(String idDireccion) {
        List<Direccion> direcciones = dataStore.getDirecciones();
        for (int i = 0; i < direcciones.size(); i++) {
            Direccion actual = direcciones.get(i);
            if (actual.getIdDireccion().equalsIgnoreCase(idDireccion)) {
                direcciones.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Direccion> listarDirecciones() {
        return dataStore.getDirecciones();
    }
}
