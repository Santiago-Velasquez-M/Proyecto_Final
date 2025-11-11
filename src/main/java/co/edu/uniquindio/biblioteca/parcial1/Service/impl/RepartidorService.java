package co.edu.uniquindio.biblioteca.parcial1.Service.impl;

import co.edu.uniquindio.biblioteca.parcial1.Enum.DisponibilidadRepartidor;
import co.edu.uniquindio.biblioteca.parcial1.Model.Repartidor;
import co.edu.uniquindio.biblioteca.parcial1.Singleton.DataStore;
import co.edu.uniquindio.biblioteca.parcial1.Service.IRepartidorService;

import java.util.ArrayList;
import java.util.List;

public class RepartidorService implements IRepartidorService {

    private final DataStore dataStore = DataStore.getInstance();

    @Override
    public void crearRepartidor(Repartidor repartidor) {
        if (repartidor != null) {
            dataStore.getRepartidores().add(repartidor);
        }
    }

    @Override
    public Repartidor buscarRepartidorPorId(String id) {
        List<Repartidor> lista = dataStore.getRepartidores();
        for (int i = 0; i < lista.size(); i++) {
            Repartidor rep = lista.get(i);
            if (rep.getIdRepartidor().equalsIgnoreCase(id)) {
                return rep;
            }
        }
        return null;
    }

    @Override
    public void actualizarRepartidor(String id, Repartidor nuevoRepartidor) {
        List<Repartidor> lista = dataStore.getRepartidores();
        for (int i = 0; i < lista.size(); i++) {
            Repartidor rep = lista.get(i);
            if (rep.getIdRepartidor().equalsIgnoreCase(id)) {
                lista.set(i, nuevoRepartidor);
                return;
            }
        }
    }

    @Override
    public void eliminarRepartidor(String id) {
        List<Repartidor> lista = dataStore.getRepartidores();
        for (int i = 0; i < lista.size(); i++) {
            Repartidor rep = lista.get(i);
            if (rep.getIdRepartidor().equalsIgnoreCase(id)) {
                lista.remove(i);
                return;
            }
        }
    }

    @Override
    public List<Repartidor> listarRepartidoresDisponibles() {
        List<Repartidor> resultado = new ArrayList<>();
        List<Repartidor> lista = dataStore.getRepartidores();

        for (int i = 0; i < lista.size(); i++) {
            Repartidor rep = lista.get(i);
            if (rep.getDisponibilidadRepartidor() == DisponibilidadRepartidor.ACTIVO) {
                resultado.add(rep);
            }
        }
        return resultado;
    }
    @Override
    public List<Repartidor> listarRepartidores() {
        return dataStore.getRepartidores();
    }

}
