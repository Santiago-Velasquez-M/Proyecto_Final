package co.edu.uniquindio.biblioteca.parcial1.Model.Builder;

import co.edu.uniquindio.biblioteca.parcial1.Model.*;
import java.time.LocalDateTime;

public class EnvioBuilder {
    private Direccion origen;
    private Direccion destino;
    private double peso;
    private double volumen;
    private double costo;
    private LocalDateTime fechaEntregaEstimada;
    private Repartidor repartidor;
    private Usuario usuario;
    private Pago pago;

    public EnvioBuilder origen(Direccion o){ this.origen = o; return this; }
    public EnvioBuilder destino(Direccion d){ this.destino = d; return this; }
    public EnvioBuilder peso(double p){ this.peso = p; return this; }
    public EnvioBuilder volumen(double v){ this.volumen = v; return this; }
    public EnvioBuilder costo(double c){ this.costo = c; return this; }
    public EnvioBuilder fechaEntrega(LocalDateTime f){ this.fechaEntregaEstimada = f; return this; }
    public EnvioBuilder repartidor(Repartidor r){ this.repartidor = r; return this; }
    public EnvioBuilder usuario(Usuario u){ this.usuario = u; return this; }
    public EnvioBuilder pago(Pago p){ this.pago = p; return this; }

    public Envio build(){
        return new Envio(origen, destino, peso, volumen, costo, fechaEntregaEstimada, repartidor, usuario, pago);
    }
}
