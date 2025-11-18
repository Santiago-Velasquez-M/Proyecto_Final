package co.edu.uniquindio.biblioteca.parcial1.Model;

import co.edu.uniquindio.biblioteca.parcial1.Enum.MetodoPago;
import java.util.ArrayList;

public class Usuario {

    private String idUsuario;
    private String nombreCompleto;
    private String correo;
    private String telefono;
    private String documento;
    private ArrayList<Direccion> direcciones;
    private ArrayList<MetodoPago> metodosPago;

    public Usuario(String idUsuario, String nombreCompleto, String correo, String telefono, String documento) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
        this.documento = documento;
        this.direcciones = new ArrayList<>();
        this.metodosPago = new ArrayList<>();
    }

    public Usuario(String idUsuario, String nombreCompleto, String correo, String telefono) {
        this(idUsuario, nombreCompleto, correo, telefono, ""); // documento vacío por defecto
    }

    public String getIdUsuario() { return idUsuario; }
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public ArrayList<Direccion> getDirecciones() { return direcciones; }
    public void setDirecciones(ArrayList<Direccion> direcciones) { this.direcciones = direcciones; }

    public ArrayList<MetodoPago> getMetodosPago() { return metodosPago; }
    public void setMetodosPago(ArrayList<MetodoPago> metodosPago) { this.metodosPago = metodosPago; }
}
