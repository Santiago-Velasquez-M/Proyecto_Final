package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import java.util.List;

public interface IEnvioService extends ICrudService<Envio> {

    List<Envio> listarPorEstado(String estado);

    void asignarRepartidor(String idEnvio, String idRepartidor);
}
