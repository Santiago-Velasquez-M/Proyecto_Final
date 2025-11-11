package co.edu.uniquindio.biblioteca.parcial1.Model;

public class Tarifa {

    private String idTarifa;
    private double costoBase;
    private double costoPeso;
    private double costoVolumen;
    private double costoPrioridad;
    private double costoDistancia;

    public Tarifa(String idTarifa, double costoBase, double costoPeso,
                  double costoVolumen, double costoPrioridad, double costoDistancia) {
        this.idTarifa = idTarifa;
        this.costoBase = costoBase;
        this.costoPeso = costoPeso;
        this.costoVolumen = costoVolumen;
        this.costoPrioridad = costoPrioridad;
        this.costoDistancia = costoDistancia;
    }


    public double calcularCosto(double peso, double volumen, boolean prioridad) {
        double total = costoBase + (peso * costoPeso) + (volumen * costoVolumen);
        if (prioridad) total += costoPrioridad;
        return total;
    }


    public String getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(String idTarifa) {
        this.idTarifa = idTarifa;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public double getCostoPeso() {
        return costoPeso;
    }

    public void setCostoPeso(double costoPeso) {
        this.costoPeso = costoPeso;
    }

    public double getCostoVolumen() {
        return costoVolumen;
    }

    public void setCostoVolumen(double costoVolumen) {
        this.costoVolumen = costoVolumen;
    }

    public double getCostoPrioridad() {
        return costoPrioridad;
    }

    public void setCostoPrioridad(double costoPrioridad) {
        this.costoPrioridad = costoPrioridad;
    }

    public double getCostoDistancia() {
        return costoDistancia;
    }

    public void setCostoDistancia(double costoDistancia) {
        this.costoDistancia = costoDistancia;
    }

    @Override
    public String toString() {
        return String.format(
                "%s - Base: %.2f | Peso: %.2f | Volumen: %.2f | Prioridad: %.2f | Distancia: %.2f",
                idTarifa, costoBase, costoPeso, costoVolumen, costoPrioridad, costoDistancia
        );
    }
}
