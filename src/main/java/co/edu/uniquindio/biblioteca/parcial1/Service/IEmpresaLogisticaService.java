package co.edu.uniquindio.biblioteca.parcial1.Service;

public interface IEmpresaLogisticaService {

    IUsuarioService getUsuarioService();
    IPagoService getPagoService();
    IEnvioService getEnvioService();
    IRepartidorService getRepartidorService();
    IDireccionService getDireccionService();
    ITarifaService getTarifaService();

}
