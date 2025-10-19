package co.edu.uniquindio.biblioteca.parcial1.Service.impl;

import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import co.edu.uniquindio.biblioteca.parcial1.Singleton.DataStore;
import co.edu.uniquindio.biblioteca.parcial1.Service.IEnvioService;

import java.util.ArrayList;
import java.util.List;

public class EnvioService implements IEnvioService {

    private final DataStore dataStore = DataStore.getInstance();

    @Override
    public void crearEnvio(Envio envio) {
        if (envio != null) {
            dataStore.getEnvios().add(envio);
        }
    }

    @Override
    public Envio buscarEnvioPorId(String id) {
        List<Envio> listaEnvios = dataStore.getEnvios();
        for (int i = 0; i < listaEnvios.size(); i++) {
            Envio envio = listaEnvios.get(i);
            if (envio.getIdEnvio().equalsIgnoreCase(id)) {
                return envio;
            }
        }
        return null;
    }

    @Override
    public void actualizarEnvio(String id, Envio nuevoEnvio) {
        List<Envio> listaEnvios = dataStore.getEnvios();
        for (int i = 0; i < listaEnvios.size(); i++) {
            Envio envio = listaEnvios.get(i);
            if (envio.getIdEnvio().equalsIgnoreCase(id)) {
                listaEnvios.set(i, nuevoEnvio);
                return;
            }
        }
    }

    @Override
    public void eliminarEnvio(String id) {
        List<Envio> listaEnvios = dataStore.getEnvios();
        for (int i = 0; i < listaEnvios.size(); i++) {
            Envio envio = listaEnvios.get(i);
            if (envio.getIdEnvio().equalsIgnoreCase(id)) {
                listaEnvios.remove(i);
                return;
            }
        }
    }

    @Override
    public List<Envio> listarEnvios() {
        return dataStore.getEnvios();
    }

    @Override
    public List<Envio> listarPorEstado(String estado) {
        List<Envio> resultado = new ArrayList<>();
        List<Envio> listaEnvios = dataStore.getEnvios();

        for (int i = 0; i < listaEnvios.size(); i++) {
            Envio envio = listaEnvios.get(i);
            if (envio.getEstadoEnvio().name().equalsIgnoreCase(estado)) {
                resultado.add(envio);
            }
        }
        return resultado;
    }

    @Override
    public void asignarRepartidor(String idEnvio, String idRepartidor) {
        List<Envio> listaEnvios = dataStore.getEnvios();
        for (int i = 0; i < listaEnvios.size(); i++) {
            Envio envio = listaEnvios.get(i);
            if (envio.getIdEnvio().equalsIgnoreCase(idEnvio)) {
                if (envio.getRepartidor() == null ||
                        !envio.getRepartidor().getIdRepartidor().equalsIgnoreCase(idRepartidor)) {
                    // Aquí podrías buscar al repartidor y asignarlo
                }
                return;
            }
        }
    }
}
