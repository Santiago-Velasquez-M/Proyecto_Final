package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Dto.RepartidorDto;
import co.edu.uniquindio.biblioteca.parcial1.Enum.DisponibilidadRepartidor;
import co.edu.uniquindio.biblioteca.parcial1.Facade.EmpresaLogisticaFacade;
import co.edu.uniquindio.biblioteca.parcial1.Model.Repartidor;

import java.util.List;
import java.util.stream.Collectors;

public class RepartidorController {

    private final EmpresaLogisticaFacade empresaLogisticaFacade;

    public RepartidorController() {
        this.empresaLogisticaFacade = new EmpresaLogisticaFacade();
    }


    public List<RepartidorDto> listarRepartidoresDto() {
        return empresaLogisticaFacade.getRepartidorService()
                .listarRepartidores()
                .stream()
                .map(this::convertirARepartidorDto)
                .collect(Collectors.toList());
    }


    public List<RepartidorDto> listarRepartidoresDisponiblesDto() {
        return empresaLogisticaFacade.getRepartidorService()
                .listarRepartidoresDisponibles()
                .stream()
                .map(this::convertirARepartidorDto)
                .collect(Collectors.toList());
    }


    public void crearRepartidorDto(RepartidorDto dto) {
        if (dto != null) {
            empresaLogisticaFacade.getRepartidorService().crearRepartidor(convertirARepartidor(dto));
        }
    }


    public RepartidorDto buscarRepartidorDtoPorId(String idRepartidor) {
        Repartidor repartidor = empresaLogisticaFacade.getRepartidorService().buscarRepartidorPorId(idRepartidor);
        return repartidor != null ? convertirARepartidorDto(repartidor) : null;
    }


    public void actualizarRepartidorDto(String idRepartidor, RepartidorDto dto) {
        if (idRepartidor != null && dto != null) {
            empresaLogisticaFacade.getRepartidorService()
                    .actualizarRepartidor(idRepartidor, convertirARepartidor(dto));
        }
    }

    /**
     * Elimina un repartidor por su ID.
     */
    public void eliminarRepartidorDto(String idRepartidor) {
        if (idRepartidor != null && !idRepartidor.isBlank()) {
            empresaLogisticaFacade.getRepartidorService().eliminarRepartidor(idRepartidor);
        }
    }


    private RepartidorDto convertirARepartidorDto(Repartidor r) {
        return new RepartidorDto(
                r.getIdRepartidor(),
                r.getNombre(),
                r.getDocumento(),
                r.getTelefono(),
                r.getVehiculo(),
                r.getPlaca(),
                r.getZonaCobertura(),
                r.getDisponibilidadRepartidor()
        );
    }

    private Repartidor convertirARepartidor(RepartidorDto dto) {
        return new Repartidor(
                dto.getIdRepartidor(),
                dto.getNombre(),
                dto.getDocumento(),
                dto.getTelefono(),
                dto.getVehiculo(),
                dto.getPlaca(),
                dto.getZonaCobertura(),
                dto.getDisponibilidadRepartidor() != null
                        ? dto.getDisponibilidadRepartidor()
                        : DisponibilidadRepartidor.ACTIVO
        );
    }
}
