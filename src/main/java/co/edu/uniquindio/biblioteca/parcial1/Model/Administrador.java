package co.edu.uniquindio.biblioteca.parcial1.Model;

public class Administrador extends Usuario {

    private String clave;

    public Administrador(String idUsuario, String nombre, String correo, String telefono, String clave) {
        super(idUsuario, nombre, correo, telefono, ""); // documento vacío
        this.clave = clave;
    }

    public Administrador() {
        super("", "", "", "", "");
        this.clave = "";
    }

    // getters
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean validarClave(String claveIngresada) {
        return clave != null && clave.equals(claveIngresada);
    }
}
