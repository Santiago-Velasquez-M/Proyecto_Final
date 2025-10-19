package co.edu.uniquindio.biblioteca.parcial1.Model;

import co.edu.uniquindio.biblioteca.parcial1.Enum.*;
import java.time.LocalDateTime;

public class Pago {

    private String idPago;
    private double monto;
    private MetodoPago metodoPago;
    private LocalDateTime fechaPago;
    private ResultadoPago resultado;

    /**
     * Constructor que genera la fecha automáticamente (ahora).
     * Uso: new Pago("P001", 7500, MetodoPago.TARJETA_CREDITO, ResultadoPago.APROBADO);
     */
    public Pago(String idPago, double monto, MetodoPago metodoPago, ResultadoPago resultado) {
        this.idPago = idPago;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = LocalDateTime.now();
        this.resultado = resultado;
    }

    /**
     * Constructor que recibe la fecha explícitamente.
     * Uso: new Pago("P001", 7500, MetodoPago.TARJETA_CREDITO, LocalDateTime.now(), ResultadoPago.APROBADO);
     */
    public Pago(String idPago, double monto, MetodoPago metodoPago, LocalDateTime fechaPago, ResultadoPago resultado) {
        this.idPago = idPago;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = (fechaPago != null) ? fechaPago : LocalDateTime.now();
        this.resultado = resultado;
    }

    // Getters y setters
    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public ResultadoPago getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoPago resultado) {
        this.resultado = resultado;
    }

}
