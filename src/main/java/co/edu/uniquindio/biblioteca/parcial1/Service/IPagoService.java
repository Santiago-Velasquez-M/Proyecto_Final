package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Model.Pago;

import java.util.List;

public interface IPagoService {

    void crearPago(Pago pago);
    Pago buscarPagoPorId(String id);
    void actualizarPago(String id, Pago nuevoPago);
    void eliminarPago(String id);
    List<Pago> listarPagos();
    boolean validarPago(Pago pago);
}
