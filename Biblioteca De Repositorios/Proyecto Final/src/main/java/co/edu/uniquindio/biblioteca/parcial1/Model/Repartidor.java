package co.edu.uniquindio.biblioteca.parcial1.Model;

import co.edu.uniquindio.biblioteca.parcial1.Enum.DisponibilidadRepartidor;

public class Repartidor {

    private String idRepartidor;
    private String nombre;
    private String documento;
    private String telefono;
    private String vehiculo;
    private String placa;
    private String zonaCobertura;
    private DisponibilidadRepartidor disponibilidadRepartidor;

    public Repartidor(String idRepartidor, String nombre, String documento, String telefono,
                      String vehiculo, String placa, String zonaCobertura,
                      DisponibilidadRepartidor disponibilidadRepartidor) {
        this.idRepartidor = idRepartidor;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.vehiculo = vehiculo;
        this.placa = placa;
        this.zonaCobertura = zonaCobertura;
        this.disponibilidadRepartidor = disponibilidadRepartidor;
    }

    public String getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(String idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getZonaCobertura() {
        return zonaCobertura;
    }

    public void setZonaCobertura(String zonaCobertura) {
        this.zonaCobertura = zonaCobertura;
    }

    public DisponibilidadRepartidor getDisponibilidadRepartidor() {
        return disponibilidadRepartidor;
    }

    public void setDisponibilidadRepartidor(DisponibilidadRepartidor disponibilidadRepartidor) {
        this.disponibilidadRepartidor = disponibilidadRepartidor;
    }

    @Override
    public String toString() {
        return "Repartidor{" +
                "idRepartidor='" + idRepartidor + '\'' +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", vehiculo='" + vehiculo + '\'' +
                ", placa='" + placa + '\'' +
                ", zonaCobertura='" + zonaCobertura + '\'' +
                ", disponibilidad=" + (disponibilidadRepartidor != null ? disponibilidadRepartidor.name() : "N/A") +
                '}';
    }
}
