package co.edu.uniquindio.biblioteca.parcial1.Model;

public class Direccion {

    private String idDireccion;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String coordenadas;

    public Direccion(String idDireccion, String nombre, String direccion, String ciudad, String coordenadas) {
        this.idDireccion = idDireccion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.coordenadas = coordenadas;
    }

    public String getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

}
