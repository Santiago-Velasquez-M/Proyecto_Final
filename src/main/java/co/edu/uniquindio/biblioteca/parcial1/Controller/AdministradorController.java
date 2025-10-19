package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Enum.EstadoEnvio;
import co.edu.uniquindio.biblioteca.parcial1.Facade.EmpresaLogisticaFacade;
import co.edu.uniquindio.biblioteca.parcial1.Model.Administrador;
import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import java.util.List;

public class AdministradorController {

    private final EmpresaLogisticaFacade facade;
    private final Administrador administrador;

    public AdministradorController() {
        this.facade = new EmpresaLogisticaFacade();
        this.administrador = new Administrador(
                "A001",
                "Administrador General",
                "admin@logistica.com",
                "0000000000",
                "admin123"
        );
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public List<Envio> listarTodosLosEnvios() {
        return facade.getEnvioService().listarEnvios();
    }

    public void actualizarEstadoEnvio(Envio envio, EstadoEnvio nuevoEstado) {
        if (envio != null && nuevoEstado != null) {
            facade.actualizarEstadoEnvio(envio, nuevoEstado);
        }
    }

    public List<Usuario> listarUsuarios() {
        return facade.getUsuarioService().listarUsuarios();
    }

    public void eliminarUsuario(Usuario usuario) {
        if (usuario != null) {
            facade.getUsuarioService().eliminarUsuario(usuario.getIdUsuario());
        }
    }

    public void crearEnvio(Envio envio) {
        if (envio != null) {
            facade.getEnvioService().crearEnvio(envio);
        }
    }

    public EmpresaLogisticaFacade getFacade() {
        return facade;
    }
}
