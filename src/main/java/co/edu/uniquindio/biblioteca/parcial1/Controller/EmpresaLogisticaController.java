package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Facade.EmpresaLogisticaFacade;
import co.edu.uniquindio.biblioteca.parcial1.Model.EmpresaLogistica;
import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import co.edu.uniquindio.biblioteca.parcial1.Model.Repartidor;
import co.edu.uniquindio.biblioteca.parcial1.Model.Tarifa;
import co.edu.uniquindio.biblioteca.parcial1.Model.Pago;

import java.util.List;

public class EmpresaLogisticaController {

    private final EmpresaLogistica empresaLogistica;
    private final EmpresaLogisticaFacade empresaLogisticaFacade;

    public EmpresaLogisticaController() {
        ModelFactory factory = ModelFactory.getInstance();
        this.empresaLogisticaFacade = (EmpresaLogisticaFacade) factory.getEmpresaLogisticaFacade();
        this.empresaLogistica = factory.getEmpresaLogistica();
    }

    public EmpresaLogistica getEmpresaLogistica() {
        return empresaLogistica;
    }

    public List<Usuario> listarUsuarios() {
        return empresaLogisticaFacade.getUsuarioService().listarUsuarios();
    }

    public List<Envio> listarEnvios() {
        return empresaLogisticaFacade.getEnvioService().listarEnvios();
    }

    public List<Repartidor> listarRepartidores() {
        return empresaLogisticaFacade.getRepartidorService().listarRepartidoresDisponibles();
    }

    public List<Tarifa> listarTarifas() {
        return empresaLogisticaFacade.getTarifaService().listarTarifas();
    }

    public List<Pago> listarPagos() {
        return empresaLogisticaFacade.getPagoService().listarPagos();
    }
}
