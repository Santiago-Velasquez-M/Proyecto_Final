package co.edu.uniquindio.biblioteca.parcial1.Model;

import co.edu.uniquindio.biblioteca.parcial1.Service.IEmpresaLogistica;
import java.util.ArrayList;
import java.util.List;

public class EmpresaLogistica implements IEmpresaLogistica {

    private List<Direccion> direcciones = new ArrayList<>();
    private List<Envio> envios = new ArrayList<>();
    private List<Pago> pagos = new ArrayList<>();
    private List<Repartidor> repartidores = new ArrayList<>();
    private List<Tarifa> tarifas = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public EmpresaLogistica() {
    }

    public EmpresaLogistica(List<Direccion> direcciones, List<Envio> envios, List<Pago> pagos,
                            List<Repartidor> repartidores, List<Tarifa> tarifas, List<Usuario> usuarios) {
        this.direcciones = direcciones;
        this.envios = envios;
        this.pagos = pagos;
        this.repartidores = repartidores;
        this.tarifas = tarifas;
        this.usuarios = usuarios;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public List<Repartidor> getRepartidores() {
        return repartidores;
    }

    public void setRepartidores(List<Repartidor> repartidores) {
        this.repartidores = repartidores;
    }

    public List<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(List<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
