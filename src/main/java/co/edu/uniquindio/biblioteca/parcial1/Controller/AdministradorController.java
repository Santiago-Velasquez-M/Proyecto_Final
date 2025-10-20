package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Enum.EstadoEnvio;
import co.edu.uniquindio.biblioteca.parcial1.Facade.EmpresaLogisticaFacade;
import co.edu.uniquindio.biblioteca.parcial1.Model.Administrador;
import co.edu.uniquindio.biblioteca.parcial1.Model.Envio;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import java.util.List;

public class AdministradorController {

    private final EmpresaLogisticaFacade empresaLogisticaFacade;
    private final Administrador administrador;

    public AdministradorController() {
        this.empresaLogisticaFacade = new EmpresaLogisticaFacade();
        this.administrador = new Administrador(
                "A001",
                "Administrador General",
                "admin@logistica.com",
                "3128185660",
                "admin123"
        );
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public List<Envio> listarTodosLosEnvios() {
        return empresaLogisticaFacade.getEnvioService().listarEnvios();
    }

    public void actualizarEstadoEnvio(Envio envio, EstadoEnvio nuevoEstado) {
        if (envio != null && nuevoEstado != null) {
            empresaLogisticaFacade.getEnvioService().actualizarEstadoEnvio(envio, nuevoEstado);
        }
    }

    public List<Usuario> listarUsuarios() {
        return empresaLogisticaFacade.getUsuarioService().listarUsuarios();
    }

    public void eliminarUsuario(Usuario usuario) {
        if (usuario != null) {
            empresaLogisticaFacade.getUsuarioService().eliminarUsuario(usuario.getIdUsuario());
        }
    }

    public void crearEnvio(Envio envio) {
        if (envio != null) {
            empresaLogisticaFacade.getEnvioService().crearEnvio(envio);
        }
    }

    public EmpresaLogisticaFacade getFacade() {
        return empresaLogisticaFacade;
    }
}
