package co.edu.uniquindio.biblioteca.parcial1.Dto;

import java.time.LocalDateTime;

public class PagoDto {

    private String idPago;
    private String idEnvio;
    private String metodoPago;
    private double monto;
    private LocalDateTime fechaPago;

    // Constructor vacío (requerido por JavaFX)
    public PagoDto() {}

    // Constructor completo
    public PagoDto(String idPago, String idEnvio, String metodoPago, double monto, LocalDateTime fechaPago) {
        this.idPago = idPago;
        this.idEnvio = idEnvio;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

    // ===== Getters y Setters =====
    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public String getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(String idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public String toString() {
        return "PagoDto{" +
                "idPago='" + idPago + '\'' +
                ", idEnvio='" + idEnvio + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", monto=" + monto +
                ", fechaPago=" + fechaPago +
                '}';
    }
}
