package co.edu.uniquindio.biblioteca.parcial1.Singleton;

import co.edu.uniquindio.biblioteca.parcial1.Model.*;
import java.util.ArrayList;
import java.util.List;

public class DataStore {

    private static DataStore instance;

    private final List<Usuario> usuarios;
    private final List<Repartidor> repartidores;
    private final List<Envio> envios;
    private final List<Pago> pagos;
    private final List<Tarifa> tarifas;
    private final List<Direccion> direcciones;

    private DataStore() {
        this.usuarios = new ArrayList<>();
        this.repartidores = new ArrayList<>();
        this.envios = new ArrayList<>();
        this.pagos = new ArrayList<>();
        this.tarifas = new ArrayList<>();
        this.direcciones = new ArrayList<>();
    }

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Repartidor> getRepartidores() {
        return repartidores;
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public List<Tarifa> getTarifas() {
        return tarifas;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }
}
