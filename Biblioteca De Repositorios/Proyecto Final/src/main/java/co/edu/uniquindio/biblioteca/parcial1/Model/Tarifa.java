package co.edu.uniquindio.biblioteca.parcial1.Model;

public class Tarifa {

    private String idTarifa;
    private double costoBase;
    private double costoPeso;
    private double costoVolumen;
    private double costoPrioridad;
    private double CostoDistancia;


    public Tarifa(String idTarifa, double costoBase, double costoPeso,
                  double costoVolumen, double costoPrioridad, double costoDistancia) {
        this.idTarifa = idTarifa;
        this.costoBase = costoBase;
        this.costoPeso = costoPeso;
        this.costoVolumen = costoVolumen;
        this.costoPrioridad = costoPrioridad;
        CostoDistancia = costoDistancia;
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
        return CostoDistancia;
    }

    public void setCostoDistancia(double costoDistancia) {
        CostoDistancia = costoDistancia;
    }
}
