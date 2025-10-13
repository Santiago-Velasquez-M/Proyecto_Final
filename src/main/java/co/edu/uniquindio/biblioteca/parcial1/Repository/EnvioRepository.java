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
        boolean existe = envios.stream()
                .anyMatch(e -> e.getId().equals(envio.getId()));

        if (!existe) {
            envios.add(envio);
        } else {
            System.out.println("Envío con ID " + envio.getId() + " ya existe. No se agregó nuevamente.");
        }
    }

    public Envio buscarEnvioPorId(String id) {
        for (Envio e : envios) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public void eliminarEnvio(String id) {
        envios.removeIf(e -> e.getId().equals(id));
    }

    public List<Envio> obtenerEnvios() {
        return envios;
    }

    public List<Envio> getListaEnvios() {
        return envios;
    }
}
