package co.edu.uniquindio.biblioteca.parcial1.Model;
import co.edu.uniquindio.biblioteca.parcial1.Enum.EstadoEnvio;
import java.time.LocalDateTime;

public class Envio {

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

    public Envio(String idEnvio, Direccion origen, Direccion destino, double peso,
                 double volumen, double costo, EstadoEnvio estadoEnvio, LocalDateTime fechaCreacion,
                 LocalDateTime fechaEntregaEstimada,
                 Usuario usuario, Repartidor repartidor, Pago pago, Tarifa tarifa) {

        this.idEnvio = idEnvio;
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
        this.volumen = volumen;
        this.costo = costo;
        this.estadoEnvio = estadoEnvio;
        this.fechaCreacion = fechaCreacion;
        this.fechaEntregaEstimada = fechaEntregaEstimada;
        this.usuario = usuario;
        this.repartidor = repartidor;
        this.pago = pago;
        this.tarifa = tarifa;
    }
    public Envio() {
    }


    public String getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(String idEnvio) {
        this.idEnvio = idEnvio;
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

    public LocalDateTime getFechaEntregaEstimada() {
        return fechaEntregaEstimada;
    }

    public void setFechaEntregaEstimada(LocalDateTime fechaEntregaEstimada) {
        this.fechaEntregaEstimada = fechaEntregaEstimada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "Envio{" +
                "idEnvio='" + idEnvio + '\'' +
                ", origen=" + (origen != null ? origen : "null") +
                ", destino=" + (destino != null ? destino : "null") +
                ", peso=" + peso +
                ", volumen=" + volumen +
                ", costo=" + costo +
                ", estadoEnvio=" + (estadoEnvio != null ? estadoEnvio : "null") +
                ", fechaCreacion=" + (fechaCreacion != null ? fechaCreacion : "null") +
                ", fechaEntregaEstimada=" + (fechaEntregaEstimada != null ? fechaEntregaEstimada : "null") +
                ", usuario=" + (usuario != null ? usuario.getNombreCompleto() : "null") +
                ", repartidor=" + (repartidor != null ? repartidor.getNombre() : "null") +
                ", pago=" + (pago != null ? pago.toString() : "null") +
                ", tarifa=" + (tarifa != null ? tarifa.toString() : "null") +
                '}';
    }
}
