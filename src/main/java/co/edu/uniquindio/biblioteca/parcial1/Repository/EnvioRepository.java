package co.edu.uniquindio.biblioteca.parcial1.Repository;

import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import java.util.ArrayList;
import java.util.List;

public class EnvioRepository {

    private final List<Envio> envios;

    public EnvioRepository() {
        envios = new ArrayList<>();
    }

    public void agregarEnvio(Envio envio) {
        if (envio == null || envio.getId() == null) {
            System.out.println("No se puede agregar un envío nulo o sin ID.");
            return;
        }

        boolean existe = envios.stream().anyMatch(e -> e.getId().equals(envio.getId()));

        if (!existe) {
            envios.add(envio);
            System.out.println("Envío agregado: " + envio.getId());
        } else {
            System.out.println("Envío con ID " + envio.getId() + " ya existe. No se agregó nuevamente.");
        }
    }

    public Envio buscarEnvioPorId(String id) {
        if (id == null || id.isEmpty()) return null;
        return envios.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void eliminarEnvio(String id) {
        if (id == null || id.isEmpty()) return;
        envios.removeIf(e -> e.getId().equals(id));
        System.out.println("Envío eliminado:" + id);
    }
    public List<Envio> obtenerEnvios() {
        return new ArrayList<>(envios);
    }
}
