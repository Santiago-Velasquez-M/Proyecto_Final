package co.edu.uniquindio.biblioteca.parcial1.Model.Builder;

import co.edu.uniquindio.biblioteca.parcial1.Model.Pago;
import co.edu.uniquindio.biblioteca.parcial1.Enum.MetodoPago;
import co.edu.uniquindio.biblioteca.parcial1.Enum.ResultadoPago;

public class PagoBuilder {

    private String idPago;
    private double monto;
    private MetodoPago metodoPago;
    private ResultadoPago resultado;

    public PagoBuilder idPago(String idPago) {
        this.idPago = idPago;
        return this;
    }

    public PagoBuilder monto(double monto) {
        this.monto = monto;
        return this;
    }

    public PagoBuilder metodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
        return this;
    }

    public PagoBuilder resultado(ResultadoPago resultado) {
        this.resultado = resultado;
        return this;
    }

    public Pago build() {
        return new Pago(idPago, monto, metodoPago, resultado);
    }
}
