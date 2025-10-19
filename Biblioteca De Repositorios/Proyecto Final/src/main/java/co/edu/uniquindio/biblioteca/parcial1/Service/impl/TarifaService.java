package co.edu.uniquindio.biblioteca.parcial1.Service.impl;

import co.edu.uniquindio.biblioteca.parcial1.Model.Tarifa;
import co.edu.uniquindio.biblioteca.parcial1.Singleton.DataStore;
import co.edu.uniquindio.biblioteca.parcial1.Service.ITarifaService;

import java.util.List;

public class TarifaService implements ITarifaService {

    private final DataStore dataStore = DataStore.getInstance();

    @Override
    public void crearTarifa(Tarifa tarifa) {
        if (tarifa != null) {
            dataStore.getTarifas().add(tarifa);
        }
    }

    @Override
    public Tarifa buscarTarifaPorId(String id) {
        List<Tarifa> lista = dataStore.getTarifas();
        for (int i = 0; i < lista.size(); i++) {
            Tarifa tarifa = lista.get(i);
            if (tarifa.getIdTarifa().equalsIgnoreCase(id)) {
                return tarifa;
            }
        }
        return null;
    }

    @Override
    public void actualizarTarifa(String id, Tarifa nuevaTarifa) {
        List<Tarifa> lista = dataStore.getTarifas();
        for (int i = 0; i < lista.size(); i++) {
            Tarifa tarifa = lista.get(i);
            if (tarifa.getIdTarifa().equalsIgnoreCase(id)) {
                lista.set(i, nuevaTarifa);
                return;
            }
        }
    }

    @Override
    public void eliminarTarifa(String id) {
        List<Tarifa> lista = dataStore.getTarifas();
        for (int i = 0; i < lista.size(); i++) {
            Tarifa tarifa = lista.get(i);
            if (tarifa.getIdTarifa().equalsIgnoreCase(id)) {
                lista.remove(i);
                return;
            }
        }
    }

    @Override
    public double calcularCosto(double peso, double volumen, boolean prioridad) {
        if (!dataStore.getTarifas().isEmpty()) {
            Tarifa tarifa = dataStore.getTarifas().get(0);
            return tarifa.calcularCosto(peso, volumen, prioridad);
        }
        double base = (peso * 1000) + (volumen * 500);
        if (prioridad) base *= 1.25;
        return base;
    }
}
