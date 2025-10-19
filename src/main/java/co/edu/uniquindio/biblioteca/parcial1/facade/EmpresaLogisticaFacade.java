package co.edu.uniquindio.biblioteca.parcial1.facade;

import co.edu.uniquindio.biblioteca.parcial1.Service.*;
import co.edu.uniquindio.biblioteca.parcial1.Service.impl.*;

public class EmpresaLogisticaFacade implements IEmpresaLogisticaService {

    private final IUsuarioService usuarioService = new UsuarioService();
    private final IRepartidorService repartidorService = new RepartidorService();
    private final IEnvioService envioService = new EnvioService();
    private final IPagoService pagoService = new PagoService();
    private final ITarifaService tarifaService = new TarifaService();
    private final IDireccionService direccionService = new DireccionService();

    @Override
    public IUsuarioService getUsuarioService() {
        return usuarioService;
    }

    @Override
    public IPagoService getPagoService() {
        return pagoService;
    }

    @Override
    public IEnvioService getEnvioService() {
        return envioService;
    }

    @Override
    public IRepartidorService getRepartidorService() {
        return repartidorService;
    }

    @Override
    public IDireccionService getDireccionService() {
        return direccionService;
    }

    @Override
    public ITarifaService getTarifaService() {
        return tarifaService;
    }
}
