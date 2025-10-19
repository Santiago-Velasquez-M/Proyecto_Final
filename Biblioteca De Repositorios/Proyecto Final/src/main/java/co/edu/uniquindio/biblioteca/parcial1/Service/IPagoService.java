package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Model.Pago;

public interface IPagoService extends ICrudService<Pago> {
    boolean validarPago(Pago pago);
}
