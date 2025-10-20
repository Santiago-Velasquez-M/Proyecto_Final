package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Enum.EstadoEnvio;
import co.edu.uniquindio.biblioteca.parcial1.Facade.EmpresaLogisticaFacade;
import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import java.util.List;

public class EnvioController {

    private final EmpresaLogisticaFacade empresaLogisticaFacade;

    public EnvioController() {
        this.empresaLogisticaFacade = new EmpresaLogisticaFacade();
    }

    public List<Envio> listarTodosLosEnvios() {
        return empresaLogisticaFacade.getEnvioService().listarEnvios();
    }

    public void crearEnvio(Envio envio) {
        if (envio != null) {
            empresaLogisticaFacade.getEnvioService().crearEnvio(envio);
        }
    }

    public void actualizarEstadoEnvio(Envio envio, EstadoEnvio nuevoEstado) {
        if (envio != null && nuevoEstado != null) {
            empresaLogisticaFacade.getEnvioService().actualizarEstadoEnvio(envio, nuevoEstado);
        }
    }

    public Envio buscarEnvioPorId(String idEnvio) {
        if (idEnvio == null || idEnvio.isBlank()) {
            return null;
        }
        return empresaLogisticaFacade.getEnvioService().buscarEnvioPorId(idEnvio);
    }

    public void eliminarEnvio(String idEnvio) {
        if (idEnvio != null && !idEnvio.isBlank()) {
            empresaLogisticaFacade.getEnvioService().eliminarEnvio(idEnvio);
        }
    }
}
