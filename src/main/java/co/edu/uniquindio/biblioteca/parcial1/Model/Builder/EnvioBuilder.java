package co.edu.uniquindio.biblioteca.parcial1.Model.Builder;

import co.edu.uniquindio.biblioteca.parcial1.Enum.EstadoEnvio;
import co.edu.uniquindio.biblioteca.parcial1.Model.*;
import java.time.LocalDateTime;

public class EnvioBuilder {

    private String idEnvio;
    private Direccion origen;
    private Direccion destino;
    private double peso;
    private double volumen;
    private double costo;
    private EstadoEnvio estadoEnvio;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaEntregaEstimada;
    private Usuario usuario;
    private Repartidor repartidor;
    private Pago pago;
    private Tarifa tarifa;

    public EnvioBuilder idEnvio(String idEnvio) {
        this.idEnvio = idEnvio;
        return this;
    }

    public EnvioBuilder origen(Direccion origen) {
        this.origen = origen;
        return this;
    }

    public EnvioBuilder destino(Direccion destino) {
        this.destino = destino;
        return this;
    }

    public EnvioBuilder peso(double peso) {
        this.peso = peso;
        return this;
    }

    public EnvioBuilder volumen(double volumen) {
        this.volumen = volumen;
        return this;
    }

    public EnvioBuilder costo(double costo) {
        this.costo = costo;
        return this;
    }

    public EnvioBuilder estadoEnvio(EstadoEnvio estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
        return this;
    }

    public EnvioBuilder fechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public EnvioBuilder fechaEntregaEstimada(LocalDateTime fechaEntregaEstimada) {
        this.fechaEntregaEstimada = fechaEntregaEstimada;
        return this;
    }

    public EnvioBuilder usuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public EnvioBuilder repartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
        return this;
    }

    public EnvioBuilder pago(Pago pago) {
        this.pago = pago;
        return this;
    }

    public EnvioBuilder tarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
        return this;
    }

    public Envio build() {
        return new Envio(
                idEnvio,
                origen,
                destino,
                peso,
                volumen,
                costo,
                estadoEnvio,
                fechaCreacion,
                fechaEntregaEstimada,
                usuario,
                repartidor,
                pago,
                tarifa
        );
    }
}
