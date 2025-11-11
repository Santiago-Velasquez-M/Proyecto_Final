package co.edu.uniquindio.biblioteca.parcial1.Service.impl;

import co.edu.uniquindio.biblioteca.parcial1.Model.Tarifa;
import co.edu.uniquindio.biblioteca.parcial1.Service.ITarifaService;
import co.edu.uniquindio.biblioteca.parcial1.Singleton.DataStore;

import java.util.List;


public class TarifaService implements ITarifaService {

    private final DataStore dataStore = DataStore.getInstance();

    @Override
    public void crearTarifa(Tarifa tarifa) {
        if (tarifa != null && buscarTarifaPorId(tarifa.getIdTarifa()) == null) {
            dataStore.getTarifas().add(tarifa);
        }
    }

    @Override
    public Tarifa buscarTarifaPorId(String id) {
        if (id == null || id.isBlank()) return null;
        for (Tarifa tarifa : dataStore.getTarifas()) {
            if (tarifa.getIdTarifa().equalsIgnoreCase(id)) {
                return tarifa;
            }
        }
        return null;
    }

    @Override
    public void actualizarTarifa(String id, Tarifa nuevaTarifa) {
        if (id == null || nuevaTarifa == null) return;

        List<Tarifa> lista = dataStore.getTarifas();
        for (int i = 0; i < lista.size(); i++) {
            Tarifa actual = lista.get(i);
            if (actual.getIdTarifa().equalsIgnoreCase(id)) {
                lista.set(i, nuevaTarifa);
                return;
            }
        }
    }

    @Override
    public void eliminarTarifa(String id) {
        if (id == null || id.isBlank()) return;

        dataStore.getTarifas().removeIf(
                tarifa -> tarifa.getIdTarifa().equalsIgnoreCase(id)
        );
    }

    @Override
    public List<Tarifa> listarTarifas() {
        return dataStore.getTarifas();
    }

    @Override
    public double calcularCosto(double peso, double volumen, boolean prioridad) {
        if (!dataStore.getTarifas().isEmpty()) {
            Tarifa tarifa = dataStore.getTarifas().get(0);
            return tarifa.calcularCosto(peso, volumen, prioridad);
        }

        double base = (peso * 1000) + (volumen * 500);
        if (prioridad) {
            base *= 1.25;
        }
        return base;
    }
}
