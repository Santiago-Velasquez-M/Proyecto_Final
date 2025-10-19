package co.edu.uniquindio.biblioteca.parcial1.Observer;

import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;

public interface NotificacionObserver {
    void actualizar(Envio envio, String mensaje);
}

