package co.edu.uniquindio.biblioteca.parcial1.Model;

public class Administrador extends Usuario {

    private String clave;

    public Administrador(String idUsuario, String nombre, String correo, String telefono, String clave) {
        super(idUsuario, nombre, correo, telefono);
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idUsuario='" + getIdUsuario() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                '}';
    }
}
