package co.edu.uniquindio.biblioteca.parcial1.Observer.Impl;

import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import co.edu.uniquindio.biblioteca.parcial1.Observer.NotificacionObserver;

public class NotificacionTelegram implements NotificacionObserver {

    @Override
    public void actualizar(Envio envio, String mensaje) {
        if (envio.getUsuario() != null) {
            System.out.println("[TELEGRAM SIMULADO] A " + envio.getUsuario().getNombreCompleto() + ": " + mensaje);
        } else {
            System.out.println("[TELEGRAM SIMULADO] A usuario desconocido: " + mensaje);
        }
    }
}
