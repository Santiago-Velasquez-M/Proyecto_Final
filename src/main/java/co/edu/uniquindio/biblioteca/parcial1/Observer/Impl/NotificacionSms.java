package co.edu.uniquindio.biblioteca.parcial1.Observer.Impl;

import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import co.edu.uniquindio.biblioteca.parcial1.Observer.NotificacionObserver;
import co.edu.uniquindio.biblioteca.parcial1.Util.Constantes;

public class NotificacionSms implements NotificacionObserver {
    @Override
    public void actualizar(Envio envio, String mensaje) {
        String nombreUsuario = (envio.getUsuario() != null)
                ? envio.getUsuario().getNombreCompleto()
                : Constantes.MENSAJE_USUARIO_DESCONOCIDO;

        String mensajeFinal = String.format("%s A %s: %s",
                Constantes.MENSAJE_CAMBIO_ESTADO, nombreUsuario, mensaje);

        registrarMensaje(mensajeFinal);
    }

    private void registrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
