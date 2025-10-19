package co.edu.uniquindio.biblioteca.parcial1.Service.impl;

import co.edu.uniquindio.biblioteca.parcial1.Model.Pago;
import co.edu.uniquindio.biblioteca.parcial1.Singleton.DataStore;
import co.edu.uniquindio.biblioteca.parcial1.Service.IPagoService;

import java.util.List;

public class PagoService implements IPagoService {

    private final DataStore dataStore = DataStore.getInstance();

    @Override
    public void crearPago(Pago pago) {
        if (pago != null) {
            dataStore.getPagos().add(pago);
        }
    }

    @Override
    public Pago buscarPagoPorId(String id) {
        List<Pago> listaPagos = dataStore.getPagos();
        for (int i = 0; i < listaPagos.size(); i++) {
            Pago pago = listaPagos.get(i);
            if (pago.getIdPago().equalsIgnoreCase(id)) {
                return pago;
            }
        }
        return null;
    }

    @Override
    public void actualizarPago(String id, Pago nuevoPago) {
        List<Pago> listaPagos = dataStore.getPagos();
        for (int i = 0; i < listaPagos.size(); i++) {
            Pago pago = listaPagos.get(i);
            if (pago.getIdPago().equalsIgnoreCase(id)) {
                listaPagos.set(i, nuevoPago);
                return;
            }
        }
    }

    @Override
    public void eliminarPago(String id) {
        List<Pago> listaPagos = dataStore.getPagos();
        for (int i = 0; i < listaPagos.size(); i++) {
            Pago pago = listaPagos.get(i);
            if (pago.getIdPago().equalsIgnoreCase(id)) {
                listaPagos.remove(i);
                return;
            }
        }
    }

    @Override
    public boolean validarPago(Pago pago) {
        if (pago == null) return false;
        return pago.getMonto() > 0 && pago.getMetodoPago() != null;
    }
}
