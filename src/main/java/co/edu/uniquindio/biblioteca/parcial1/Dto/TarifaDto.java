package co.edu.uniquindio.biblioteca.parcial1.Dto;

public class TarifaDto {

    private String idTarifa;
    private double costoBase;
    private double costoPorPeso;
    private double costoPorVolumen;
    private double costoPrioridad;
    private double costoDistancia;

    public TarifaDto() {}

    public TarifaDto(String idTarifa, double costoBase, double costoPorPeso,
                     double costoPorVolumen, double costoPrioridad, double costoDistancia) {
        this.idTarifa = idTarifa;
        this.costoBase = costoBase;
        this.costoPorPeso = costoPorPeso;
        this.costoPorVolumen = costoPorVolumen;
        this.costoPrioridad = costoPrioridad;
        this.costoDistancia = costoDistancia;
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

    public double getCostoPorPeso() {
        return costoPorPeso;
    }

    public void setCostoPorPeso(double costoPorPeso) {
        this.costoPorPeso = costoPorPeso;
    }

    public double getCostoPorVolumen() {
        return costoPorVolumen;
    }

    public void setCostoPorVolumen(double costoPorVolumen) {
        this.costoPorVolumen = costoPorVolumen;
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
                "%s | Base: %.2f | Peso: %.2f | Volumen: %.2f | Prioridad: %.2f | Distancia: %.2f",
                idTarifa, costoBase, costoPorPeso, costoPorVolumen, costoPrioridad, costoDistancia
        );
    }
}
