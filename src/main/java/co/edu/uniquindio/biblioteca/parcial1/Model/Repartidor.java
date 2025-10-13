package co.edu.uniquindio.biblioteca.parcial1.Model;

public class Repartidor {

    private String id;
    private String nombre;
    private String telefono;
    private String vehiculo;
    private String placa;
    private boolean disponible;

    public Repartidor(String id, String nombre, String telefono, String vehiculo, String placa) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.vehiculo = vehiculo;
        this.placa = placa;
        this.disponible = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
