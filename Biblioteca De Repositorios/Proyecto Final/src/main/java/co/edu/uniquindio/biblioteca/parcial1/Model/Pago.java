package co.edu.uniquindio.biblioteca.parcial1.Model;

import co.edu.uniquindio.biblioteca.parcial1.Enum.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pago {

    private String idPago;
    private double monto;
    private MetodoPago metodoPago;
    private LocalDateTime fechaPago;
    private ResultadoPago resultado;

    public Pago(String idPago, double monto, MetodoPago metodoPago, ResultadoPago resultado) {
        this.idPago = idPago;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = LocalDateTime.now();
        this.resultado = resultado;
    }

    public Pago(String idPago, double monto, MetodoPago metodoPago, LocalDateTime fechaPago, ResultadoPago resultado) {
        this.idPago = idPago;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = (fechaPago != null) ? fechaPago : LocalDateTime.now();
        this.resultado = resultado;
    }

    public Pago() {
        this.fechaPago = LocalDateTime.now();
    }

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

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "Pago{" +
                "idPago='" + idPago + '\'' +
                ", monto=" + monto +
                ", metodoPago=" + (metodoPago != null ? metodoPago.name() : "N/A") +
                ", resultado=" + (resultado != null ? resultado.name() : "N/A") +
                ", fechaPago=" + (fechaPago != null ? fechaPago.format(formato) : "N/A") +
                '}';
    }

}
