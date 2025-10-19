package co.edu.uniquindio.biblioteca.parcial1.Model;

import co.edu.uniquindio.biblioteca.parcial1.Enum.MetodoPago;
import java.util.ArrayList;

public class Usuario {

    private String idUsuario;
    private String nombreCompleto;
    private String correo;
    private String telefono;
    private ArrayList<Direccion> direcciones;
    private ArrayList<MetodoPago> metodosPago;

    public Usuario(String idUsuario, String nombreCompleto, String correo, String telefono,
                   ArrayList<Direccion> direcciones, ArrayList<MetodoPago> metodosPago) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
        this.direcciones = (direcciones != null) ? direcciones : new ArrayList<>();
        this.metodosPago = (metodosPago != null) ? metodosPago : new ArrayList<>();
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

    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(ArrayList<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public ArrayList<MetodoPago> getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(ArrayList<MetodoPago> metodosPago) {
        this.metodosPago = metodosPago;
    }

    public String getNombre() {
        return nombreCompleto;
    }
}
