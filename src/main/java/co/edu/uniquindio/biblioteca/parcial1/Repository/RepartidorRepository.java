package co.edu.uniquindio.biblioteca.parcial1.Repository;

import co.edu.uniquindio.biblioteca.parcial1.Model.Repartidor;
import java.util.ArrayList;
import java.util.List;

public class RepartidorRepository {

    private final List<Repartidor> repartidores = new ArrayList<>();

    public RepartidorRepository() {
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        repartidores.add(new Repartidor("REP001", "Carlos Pérez", "3124567890", "Moto", "ABC-123"));
        repartidores.add(new Repartidor("REP002", "Daniela Gómez", "3109876543", "Carro", "XYZ-789"));
        repartidores.add(new Repartidor("REP003", "Jorge Ruiz", "3001234567", "Camioneta", "LMN-456"));

        System.out.println("Repartidores cargados correctamente (" + repartidores.size() + ")");
    }

    public List<Repartidor> obtenerRepartidores() {
        return new ArrayList<>(repartidores);
    }

    public void agregarRepartidor(Repartidor repartidor) {
        boolean existe = repartidores.stream()
                .anyMatch(r -> r.getId().equals(repartidor.getId()));

        if (!existe) {
            repartidores.add(repartidor);
        } else {
            System.out.println("El repartidor con ID " + repartidor.getId() + " ya existe.");
        }
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
