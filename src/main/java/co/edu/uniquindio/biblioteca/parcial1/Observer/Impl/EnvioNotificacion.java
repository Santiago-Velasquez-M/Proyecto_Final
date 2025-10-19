// EnvioNotificacion.java
package co.edu.uniquindio.biblioteca.parcial1.Observer.Impl;

import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import co.edu.uniquindio.biblioteca.parcial1.Observer.NotificacionObserver;

import java.util.ArrayList;
import java.util.List;

public class EnvioNotificacion {

    private final List<NotificacionObserver> observadores = new ArrayList<>();

    public void agregarObserver(NotificacionObserver observer) {
        observadores.add(observer);
    }

    public void eliminarObserver(NotificacionObserver observer) {
        observadores.remove(observer);
    }

    public void notificar(Envio envio, String mensaje) {
        for (NotificacionObserver obs : observadores) {
            obs.actualizar(envio, mensaje);
        }
    }
}
