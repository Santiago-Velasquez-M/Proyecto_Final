package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Facade.EmpresaLogisticaFacade;
import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import co.edu.uniquindio.biblioteca.parcial1.Model.Pago;
import co.edu.uniquindio.biblioteca.parcial1.Model.Tarifa;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipalController {

    private final EmpresaLogisticaFacade empresaLogisticaFacade;
    private final Usuario usuarioActual;

    public UsuarioPrincipalController(Usuario usuarioActual) {
        ModelFactory factory = ModelFactory.getInstance();
        this.empresaLogisticaFacade = (EmpresaLogisticaFacade) factory.getEmpresaLogisticaFacade();
        this.usuarioActual = usuarioActual;
    }

    /**
     * Retorna el usuario logueado
     */
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    /**
     * Listar solo los envíos del usuario actual
     */
    public List<Envio> listarMisEnvios() {
        return empresaLogisticaFacade.getEnvioService()
                .listarEnvios()
                .stream()
                .filter(envio -> envio.getUsuario().getIdUsuario().equals(usuarioActual.getIdUsuario()))
                .collect(Collectors.toList());
    }

    /**
     * Listar solo los pagos del usuario actual
     */
    public List<Pago> listarMisPagos() {
        return empresaLogisticaFacade.getPagoService()
                .listarPagos()
                .stream()
                .filter(pago -> pago.getUsuario() != null &&
                        pago.getUsuario().getIdUsuario().equals(usuarioActual.getIdUsuario()))
                .collect(Collectors.toList());
    }

    public List<Tarifa> listarTarifas() {
        return empresaLogisticaFacade.getTarifaService().listarTarifas();
    }

    public double calcularCosto(double peso, double volumen, boolean local) {
        return empresaLogisticaFacade.getTarifaService().calcularCosto(peso, volumen, local);
    }
}
