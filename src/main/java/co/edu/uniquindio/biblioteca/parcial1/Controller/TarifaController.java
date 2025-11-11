package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Dto.TarifaDto;
import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Model.Tarifa;
import co.edu.uniquindio.biblioteca.parcial1.Service.ITarifaService;

import java.util.List;
import java.util.stream.Collectors;

public class TarifaController {

    private final ModelFactory modelFactory = ModelFactory.getInstance();
    private final ITarifaService tarifaService;

    public TarifaController() {
        this.tarifaService = modelFactory.getEmpresaLogisticaFacade().getTarifaService();
    }

    public void crearTarifa(TarifaDto dto) {
        if (dto != null) {
            Tarifa tarifa = convertirAModelo(dto);
            tarifaService.crearTarifa(tarifa);
            System.out.println("Tarifa creada correctamente: " + dto.getIdTarifa());
        } else {
            System.err.println("Error: la tarifa no puede ser nula");
        }
    }

    public TarifaDto buscarTarifaPorId(String id) {
        if (id == null || id.isBlank()) {
            System.err.println("ID inválido para búsqueda de tarifa");
            return null;
        }
        Tarifa tarifa = tarifaService.buscarTarifaPorId(id);
        return tarifa != null ? convertirADto(tarifa) : null;
    }

    public void actualizarTarifa(String id, TarifaDto dto) {
        if (id == null || id.isBlank() || dto == null) {
            System.err.println("Error al actualizar: datos incompletos");
            return;
        }
        Tarifa nuevaTarifa = convertirAModelo(dto);
        tarifaService.actualizarTarifa(id, nuevaTarifa);
        System.out.println("Tarifa actualizada correctamente: " + id);
    }

    public void eliminarTarifa(String id) {
        if (id == null || id.isBlank()) {
            System.err.println("Error al eliminar: ID vacío");
            return;
        }
        tarifaService.eliminarTarifa(id);
        System.out.println("Tarifa eliminada correctamente: " + id);
    }

    public List<TarifaDto> listarTarifas() {
        List<Tarifa> lista = tarifaService.listarTarifas();
        if (lista.isEmpty()) {
            System.out.println("No hay tarifas registradas actualmente.");
        }
        return lista.stream().map(this::convertirADto).collect(Collectors.toList());
    }

    public double calcularCosto(double peso, double volumen, boolean prioridad) {
        return tarifaService.calcularCosto(peso, volumen, prioridad);
    }

    private TarifaDto convertirADto(Tarifa tarifa) {
        return new TarifaDto(
                tarifa.getIdTarifa(),
                tarifa.getCostoBase(),
                tarifa.getCostoPeso(),
                tarifa.getCostoVolumen(),
                tarifa.getCostoPrioridad(),
                tarifa.getCostoDistancia()
        );
    }

    private Tarifa convertirAModelo(TarifaDto dto) {
        return new Tarifa(
                dto.getIdTarifa(),
                dto.getCostoBase(),
                dto.getCostoPorPeso(),
                dto.getCostoPorVolumen(),
                dto.getCostoPrioridad(),
                dto.getCostoDistancia()
        );
    }
}
