package co.edu.uniquindio.biblioteca.parcial1.Dto;

public class DireccionDto {
    private String idDireccion;
    private String ciudad;
    private String direccion;
    private String departamento;
    private String latitud;
    private String longitud;

    public DireccionDto() {}

    public DireccionDto(String idDireccion, String ciudad, String direccion,
                        String departamento, String latitud, String longitud) {
        this.idDireccion = idDireccion;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.departamento = departamento;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getIdDireccion() { return idDireccion; }
    public void setIdDireccion(String idDireccion) { this.idDireccion = idDireccion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getLatitud() { return latitud; }
    public void setLatitud(String latitud) { this.latitud = latitud; }

    public String getLongitud() { return longitud; }
    public void setLongitud(String longitud) { this.longitud = longitud; }

    @Override
    public String toString() {
        return ciudad + " - " + direccion;
    }
}
