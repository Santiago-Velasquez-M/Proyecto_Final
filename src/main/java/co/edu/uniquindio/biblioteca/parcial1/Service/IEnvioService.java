package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import java.util.List;

public interface IEnvioService {

    void crearEnvio(Envio envio);
    Envio buscarEnvioPorId(String id);
    void actualizarEnvio(String id, Envio nuevoEnvio);
    void eliminarEnvio(String id);
    List<Envio> listarEnvios();
    List<Envio> listarPorEstado(String estado);
    void asignarRepartidor(String idEnvio, String idRepartidor);
}
