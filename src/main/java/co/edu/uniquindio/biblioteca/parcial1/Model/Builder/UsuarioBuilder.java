package co.edu.uniquindio.biblioteca.parcial1.Model.Builder;

import co.edu.uniquindio.biblioteca.parcial1.Model.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioBuilder {

    private String idUsuario;
    private String nombreCompleto;
    private String correo;
    private String telefono;
    private List<Direccion> direccionesFrecuentes = new ArrayList<>();

    public UsuarioBuilder id(String idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioBuilder nombre(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public UsuarioBuilder correo(String correo) {
        this.correo = correo;
        return this;
    }

    public UsuarioBuilder telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public UsuarioBuilder agregarDireccion(Direccion direccion) {
        this.direccionesFrecuentes.add(direccion);
        return this;
    }

    public Usuario build() {
        return new Usuario(idUsuario, nombreCompleto, correo, telefono, direccionesFrecuentes);
    }
}
