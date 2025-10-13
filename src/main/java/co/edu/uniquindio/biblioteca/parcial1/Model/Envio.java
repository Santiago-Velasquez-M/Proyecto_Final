package co.edu.uniquindio.biblioteca.parcial1.Model;

import java.time.LocalDateTime;

public class Envio {

    private String id;
    private Direccion origen;
    private Direccion destino;
    private double peso;
    private double volumen;
    private double costo;
    private LocalDateTime fechaEntrega;
    private Repartidor repartidor;
    private Usuario usuario;
    private Pago pago;

    public Envio(Direccion origen, Direccion destino, double peso, double volumen, double costo,
                 LocalDateTime fechaEntrega, Repartidor repartidor, Usuario usuario, Pago pago) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
        this.volumen = volumen;
        this.costo = costo;
        this.fechaEntrega = fechaEntrega;
        this.repartidor = repartidor;
        this.usuario = usuario;
        this.pago = pago;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Direccion getOrigen() {
        return origen;
    }

    public void setOrigen(Direccion origen) {
        this.origen = origen;
    }

    public Direccion getDestino() {
        return destino;
    }

    public void setDestino(Direccion destino) {
        this.destino = destino;
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

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}
