package co.edu.uniquindio.biblioteca.parcial1.Model;

public class Direccion {

    private String idDireccion;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String latitud;
    private String longitud;

    public Direccion(String idDireccion, String nombre, String direccion, String ciudad
            , String latitud, String longitud) {
        this.idDireccion = idDireccion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.latitud = latitud;
        this.longitud = longitud;
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

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "idDireccion='" + idDireccion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", latitud='" + (latitud != null ? latitud : "N/A") + '\'' +
                ", longitud='" + (longitud != null ? longitud : "N/A") + '\'' +
                '}';
        }

    }
