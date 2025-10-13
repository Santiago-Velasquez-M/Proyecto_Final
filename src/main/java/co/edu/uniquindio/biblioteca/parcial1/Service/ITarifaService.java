package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Model.Tarifa;

public interface ITarifaService extends ICrudService<Tarifa> {

    double calcularCosto(double peso, double volumen, boolean prioridad);
}

