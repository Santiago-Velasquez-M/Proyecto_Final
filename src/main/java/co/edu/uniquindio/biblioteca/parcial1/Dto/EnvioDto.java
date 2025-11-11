package co.edu.uniquindio.biblioteca.parcial1.Dto;

import co.edu.uniquindio.biblioteca.parcial1.Enum.EstadoEnvio;
import java.time.LocalDateTime;

public class EnvioDto {

    private String idEnvio;
    private String direccionOrigen;
    private String direccionDestino;
    private double peso;
    private double volumen;
    private double costo;
    private EstadoEnvio estadoEnvio;
    private LocalDateTime fechaCreacion;

    public EnvioDto() {}

    public EnvioDto(String idEnvio, String direccionOrigen, String direccionDestino,
                    double peso, double volumen, double costo,
                    EstadoEnvio estadoEnvio, LocalDateTime fechaCreacion) {
        this.idEnvio = idEnvio;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.peso = peso;
        this.volumen = volumen;
        this.costo = costo;
        this.estadoEnvio = estadoEnvio;
        this.fechaCreacion = fechaCreacion;
    }


    public String getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(String idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public EstadoEnvio getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(EstadoEnvio estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "EnvioDto{" +
                "idEnvio='" + idEnvio + '\'' +
                ", direccionOrigen='" + direccionOrigen + '\'' +
                ", direccionDestino='" + direccionDestino + '\'' +
                ", peso=" + peso +
                ", volumen=" + volumen +
                ", costo=" + costo +
                ", estadoEnvio=" + estadoEnvio +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
