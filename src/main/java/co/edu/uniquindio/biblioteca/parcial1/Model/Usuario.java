package co.edu.uniquindio.biblioteca.parcial1.Model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String idUsuario;
    private String nombreCompleto;
    private String correo;
    private String telefono;
    private List<Direccion> direcciones;

    public Usuario(String idUsuario, String nombreCompleto, String correo, String telefono, List<Direccion> direcciones) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
        this.direcciones = (direcciones != null) ? direcciones : new ArrayList<>();
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public String getNombre() {
        return nombreCompleto;
    }
}
