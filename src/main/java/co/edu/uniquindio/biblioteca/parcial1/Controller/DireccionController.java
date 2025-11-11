package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Model.Direccion;
import co.edu.uniquindio.biblioteca.parcial1.Service.IDireccionService;

import java.util.List;

public class DireccionController {

    private final IDireccionService direccionService;

    public DireccionController() {

        this.direccionService = ModelFactory.getInstance()
                .getEmpresaLogisticaFacade()
                .getDireccionService();
    }

    public void crearDireccion(Direccion direccion) {
        direccionService.crearDireccion(direccion);
    }

    public Direccion buscarDireccionPorId(String id) {
        return direccionService.buscarDireccionPorId(id);
    }

    public void actualizarDireccion(String id, Direccion nuevaDireccion) {
        direccionService.actualizarDireccion(id, nuevaDireccion);
    }

    public void eliminarDireccion(String id) {
        direccionService.eliminarDireccion(id);
    }

    public List<Direccion> listarDirecciones() {
        return direccionService.listarDirecciones();
    }
}
