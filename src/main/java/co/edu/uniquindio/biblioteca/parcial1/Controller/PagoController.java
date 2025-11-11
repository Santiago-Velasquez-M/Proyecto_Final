package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Dto.PagoDto;
import co.edu.uniquindio.biblioteca.parcial1.Enum.MetodoPago;
import co.edu.uniquindio.biblioteca.parcial1.Facade.EmpresaLogisticaFacade;
import co.edu.uniquindio.biblioteca.parcial1.Model.Pago;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PagoController {

    private final EmpresaLogisticaFacade empresaLogisticaFacade;

    public PagoController() {
        this.empresaLogisticaFacade = new EmpresaLogisticaFacade();
    }


    public List<PagoDto> listarPagos() {
        List<Pago> pagos = empresaLogisticaFacade.getPagoService().listarPagos();
        List<PagoDto> resultado = new ArrayList<>();

        for (Pago pago : pagos) {
            resultado.add(convertirAPagoDto(pago));
        }
        return resultado;
    }

    public void crearPago(PagoDto dto) {
        if (dto == null) return;

        Pago nuevoPago = convertirAPago(dto);
        empresaLogisticaFacade.getPagoService().crearPago(nuevoPago);
    }

    public void actualizarPago(String idPago, PagoDto dto) {
        if (idPago == null || dto == null) return;

        Pago pagoExistente = empresaLogisticaFacade.getPagoService().buscarPagoPorId(idPago);
        if (pagoExistente == null) return;

        // Conversión segura de String -> Enum
        MetodoPago metodo = convertirMetodoPago(dto.getMetodoPago());
        pagoExistente.setMetodoPago(metodo);
        pagoExistente.setMonto(dto.getMonto());
        pagoExistente.setFechaPago(dto.getFechaPago());

        empresaLogisticaFacade.getPagoService().actualizarPago(idPago, pagoExistente);
    }

    public void eliminarPago(String idPago) {
        if (idPago == null || idPago.isBlank()) return;
        empresaLogisticaFacade.getPagoService().eliminarPago(idPago);
    }



    private PagoDto convertirAPagoDto(Pago pago) {
        if (pago == null) return null;

        return new PagoDto(
                pago.getIdPago(),
                null, // ❌ ya no usamos getIdEnvio()
                pago.getMetodoPago() != null ? pago.getMetodoPago().name() : "N/A",
                pago.getMonto(),
                pago.getFechaPago()
        );
    }

    private Pago convertirAPago(PagoDto dto) {
        if (dto == null) return null;

        Pago pago = new Pago();
        pago.setIdPago(dto.getIdPago() != null ? dto.getIdPago() : UUID.randomUUID().toString());
        pago.setMetodoPago(convertirMetodoPago(dto.getMetodoPago()));
        pago.setMonto(dto.getMonto());
        pago.setFechaPago(dto.getFechaPago() != null ? dto.getFechaPago() : LocalDateTime.now());

        return pago;
    }


    private MetodoPago convertirMetodoPago(String metodoTexto) {
        try {
            return MetodoPago.valueOf(metodoTexto.toUpperCase());
        } catch (Exception e) {
            return MetodoPago.EFECTIVO; // valor por defecto
        }
    }
}
