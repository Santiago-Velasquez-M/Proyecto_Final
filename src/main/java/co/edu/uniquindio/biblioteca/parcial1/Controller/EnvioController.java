package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Dto.EnvioDto;
import co.edu.uniquindio.biblioteca.parcial1.Enum.EstadoEnvio;
import co.edu.uniquindio.biblioteca.parcial1.Facade.EmpresaLogisticaFacade;
import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import co.edu.uniquindio.biblioteca.parcial1.Model.Direccion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EnvioController {

    private final EmpresaLogisticaFacade empresaLogisticaFacade;

    public EnvioController() {
        this.empresaLogisticaFacade = new EmpresaLogisticaFacade();
    }


    public List<EnvioDto> listarTodosLosEnvios() {
        List<Envio> envios = empresaLogisticaFacade.getEnvioService().listarEnvios();
        List<EnvioDto> resultado = new ArrayList<>();

        for (Envio envio : envios) {
            resultado.add(convertirAEnvioDto(envio));
        }
        return resultado;
    }


    public void crearEnvio(EnvioDto dto) {
        if (dto == null) return;

        Envio envio = convertirAEnvio(dto);
        empresaLogisticaFacade.getEnvioService().crearEnvio(envio);
    }


    public void actualizarEnvio(String idEnvio, EnvioDto dto) {
        if (idEnvio == null || dto == null) return;

        Envio envioExistente = empresaLogisticaFacade.getEnvioService().buscarEnvioPorId(idEnvio);
        if (envioExistente == null) return;

        envioExistente.setOrigen(new Direccion(UUID.randomUUID().toString(), "Origen", dto.getDireccionOrigen(), "", null, null));
        envioExistente.setDestino(new Direccion(UUID.randomUUID().toString(), "Destino", dto.getDireccionDestino(), "", null, null));
        envioExistente.setPeso(dto.getPeso());
        envioExistente.setVolumen(dto.getVolumen());
        envioExistente.setCosto(dto.getCosto());
        envioExistente.setEstadoEnvio(dto.getEstadoEnvio());

        empresaLogisticaFacade.getEnvioService().actualizarEnvio(idEnvio, envioExistente);
    }

    public void actualizarEstadoEnvio(EnvioDto dto, EstadoEnvio nuevoEstado) {
        if (dto == null || nuevoEstado == null) return;

        Envio envio = empresaLogisticaFacade.getEnvioService().buscarEnvioPorId(dto.getIdEnvio());
        if (envio == null) return;

        envio.setEstadoEnvio(nuevoEstado);
        empresaLogisticaFacade.getEnvioService().actualizarEstadoEnvio(envio, nuevoEstado);
    }

    public void eliminarEnvio(String idEnvio) {
        if (idEnvio == null || idEnvio.isBlank()) return;
        empresaLogisticaFacade.getEnvioService().eliminarEnvio(idEnvio);
    }

    private EnvioDto convertirAEnvioDto(Envio envio) {
        if (envio == null) return null;

        String origen = envio.getOrigen() != null ? envio.getOrigen().getDireccion() : "";
        String destino = envio.getDestino() != null ? envio.getDestino().getDireccion() : "";

        return new EnvioDto(
                envio.getIdEnvio(),
                origen,
                destino,
                envio.getPeso(),
                envio.getVolumen(),
                envio.getCosto(),
                envio.getEstadoEnvio(),
                envio.getFechaCreacion()
        );
    }

    private Envio convertirAEnvio(EnvioDto dto) {
        if (dto == null) return null;

        Envio envio = new Envio();
        envio.setIdEnvio(dto.getIdEnvio());
        envio.setOrigen(new Direccion(UUID.randomUUID().toString(), "Origen", dto.getDireccionOrigen(), "", null, null));
        envio.setDestino(new Direccion(UUID.randomUUID().toString(), "Destino", dto.getDireccionDestino(), "", null, null));
        envio.setPeso(dto.getPeso());
        envio.setVolumen(dto.getVolumen());
        envio.setCosto(dto.getCosto());
        envio.setEstadoEnvio(dto.getEstadoEnvio());
        envio.setFechaCreacion(dto.getFechaCreacion() != null ? dto.getFechaCreacion() : LocalDateTime.now());
        return envio;
    }
}
