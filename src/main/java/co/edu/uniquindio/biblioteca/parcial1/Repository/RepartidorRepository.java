package co.edu.uniquindio.biblioteca.parcial1.Repository;

import co.edu.uniquindio.biblioteca.parcial1.Model.Repartidor;
import java.util.ArrayList;
import java.util.List;

public class RepartidorRepository {

    private final List<Repartidor> repartidores = new ArrayList<>();

    public List<Repartidor> obtenerRepartidores() {
        return new ArrayList<>(repartidores);
    }

    public void agregarRepartidor(Repartidor repartidor) {
        repartidores.add(repartidor);
    }

    public void eliminarRepartidor(String id) {
        repartidores.removeIf(r -> r.getId().equals(id));
    }

    public void actualizarRepartidor(Repartidor repartidorActualizado) {
        for (int i = 0; i < repartidores.size(); i++) {
            if (repartidores.get(i).getId().equals(repartidorActualizado.getId())) {
                repartidores.set(i, repartidorActualizado);
                break;
            }
        }
    }
}
