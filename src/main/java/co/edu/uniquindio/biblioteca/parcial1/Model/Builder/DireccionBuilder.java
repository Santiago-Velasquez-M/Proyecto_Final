package co.edu.uniquindio.biblioteca.parcial1.Model.Builder;

import co.edu.uniquindio.biblioteca.parcial1.Model.Direccion;

public class DireccionBuilder {

    private String idDireccion;
    private String nombre;       // antes 'alias'
    private String direccion;    // antes 'calle'
    private String ciudad;
    private String coordenadas;

    public DireccionBuilder id(String idDireccion) {
        this.idDireccion = idDireccion;
        return this;
    }

    public DireccionBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DireccionBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public DireccionBuilder ciudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public DireccionBuilder coordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
        return this;
    }

    public Direccion build() {
        return new Direccion(idDireccion, nombre, direccion, ciudad, coordenadas);
    }
}
