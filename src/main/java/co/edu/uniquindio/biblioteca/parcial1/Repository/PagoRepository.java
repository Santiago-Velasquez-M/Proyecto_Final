package co.edu.uniquindio.biblioteca.parcial1.Repository;

import co.edu.uniquindio.biblioteca.parcial1.Model.Pago;
import java.util.ArrayList;
import java.util.List;

public class PagoRepository {

    private final List<Pago> listaPagos = new ArrayList<>();

    public List<Pago> obtenerPagos() {
        return new ArrayList<>(listaPagos); // se devuelve copia para evitar modificaciones externas
    }

    public boolean agregarPago(Pago pago) {
        if (pago == null || pago.getIdPago() == null) {
            return false;
        }


        for (Pago p : listaPagos) {
            if (p.getIdPago().equalsIgnoreCase(pago.getIdPago())) {
                return false;
            }
        }

        listaPagos.add(pago);
        return true;
    }
    public boolean eliminarPago(String idPago) {
        return listaPagos.removeIf(p -> p.getIdPago().equalsIgnoreCase(idPago));
    }

    public Pago buscarPagoPorId(String idPago) {
        for (Pago pago : listaPagos) {
            if (pago.getIdPago().equalsIgnoreCase(idPago)) {
                return pago;
            }
        }
        return null;
    }

    public boolean actualizarPago(Pago pagoActualizado) {
        for (int i = 0; i < listaPagos.size(); i++) {
            Pago existente = listaPagos.get(i);
            if (existente.getIdPago().equalsIgnoreCase(pagoActualizado.getIdPago())) {
                listaPagos.set(i, pagoActualizado);
                return true;
            }
        }
        return false;
    }
}
