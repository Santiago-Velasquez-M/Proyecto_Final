package co.edu.uniquindio.biblioteca.parcial1.Service.impl;

import co.edu.uniquindio.biblioteca.parcial1.Enum.EstadoEnvio;
import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import co.edu.uniquindio.biblioteca.parcial1.Observer.Impl.EnvioNotificacion;
import co.edu.uniquindio.biblioteca.parcial1.Observer.Impl.NotificacionSms;
import co.edu.uniquindio.biblioteca.parcial1.Observer.Impl.NotificacionTelegram;
import co.edu.uniquindio.biblioteca.parcial1.Singleton.DataStore;
import co.edu.uniquindio.biblioteca.parcial1.Service.IEnvioService;

import java.util.ArrayList;
import java.util.List;

public class EnvioService implements IEnvioService {

    private final DataStore dataStore = DataStore.getInstance();
    private final EnvioNotificacion notificador;

    public EnvioService() {
        this.notificador = new EnvioNotificacion();
        notificador.agregarObserver(new NotificacionSms());
        notificador.agregarObserver(new NotificacionTelegram());
    }

    @Override
    public void crearEnvio(Envio envio) {
        if (envio != null) {
            dataStore.getEnvios().add(envio);
        }
    }

    @Override
    public Envio buscarEnvioPorId(String id) {
        for (Envio envio : dataStore.getEnvios()) {
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
        dataStore.getEnvios().removeIf(envio -> envio.getIdEnvio().equalsIgnoreCase(id));
    }

    @Override
    public List<Envio> listarEnvios() {
        return dataStore.getEnvios();
    }

    @Override
    public List<Envio> listarPorEstado(String estado) {
        List<Envio> resultado = new ArrayList<>();
        for (Envio envio : dataStore.getEnvios()) {
            if (envio.getEstadoEnvio().name().equalsIgnoreCase(estado)) {
                resultado.add(envio);
            }
        }
        return resultado;
    }

    @Override
    public void asignarRepartidor(String idEnvio, String idRepartidor) {
        // Implementación pendiente si se requiere
    }

    @Override
    public void actualizarEstadoEnvio(Envio envio, EstadoEnvio nuevoEstado) {
        if (envio == null || nuevoEstado == null) return;

        envio.setEstadoEnvio(nuevoEstado);

        String mensaje = switch (nuevoEstado) {
            case EN_RUTA -> "Tu envío " + envio.getIdEnvio() + " ha salido y está en camino.";
            case ENTREGADO -> "Tu envío " + envio.getIdEnvio() + " ha llegado a destino.";
            default -> "El estado de tu envío " + envio.getIdEnvio() + " cambió a: " + nuevoEstado;
        };

        notificador.notificar(envio, mensaje);
    }
}
