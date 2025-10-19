package co.edu.uniquindio.biblioteca.parcial1.Model.Builder;

import co.edu.uniquindio.biblioteca.parcial1.Model.Repartidor;

public class RepartidorBuilder {

    private String id;
    private String nombre;
    private String documento;
    private String telefono;
    private String zonaCobertura;
    private boolean disponible;

    public RepartidorBuilder id(String id) {
        this.id = id;
        return this;
    }

    public RepartidorBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public RepartidorBuilder documento(String documento) {
        this.documento = documento;
        return this;
    }

    public RepartidorBuilder telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public RepartidorBuilder zonaCobertura(String zonaCobertura) {
        this.zonaCobertura = zonaCobertura;
        return this;
    }

    public RepartidorBuilder disponible(boolean disponible) {
        this.disponible = disponible;
        return this;
    }


    public Repartidor build() {
        Repartidor r = new Repartidor(id, nombre, telefono, zonaCobertura, documento);
        r.setDisponible(disponible);
        return r;
    }
}
