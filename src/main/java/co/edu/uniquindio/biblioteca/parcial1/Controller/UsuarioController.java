package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Facade.EmpresaLogisticaFacade;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import java.util.List;

public class UsuarioController {

    private final EmpresaLogisticaFacade empresaLogisticaFacade;

    public UsuarioController() {
        this.empresaLogisticaFacade = new EmpresaLogisticaFacade();
    }

    public List<Usuario> listarUsuarios() {
        return empresaLogisticaFacade.getUsuarioService().listarUsuarios();
    }

    public void crearUsuario(Usuario usuario) {
        if (usuario != null) {
            empresaLogisticaFacade.getUsuarioService().crearUsuario(usuario);
        }
    }

    public Usuario buscarUsuarioPorId(String idUsuario) {
        if (idUsuario == null || idUsuario.isBlank()) {
            return null;
        }
        return empresaLogisticaFacade.getUsuarioService().buscarUsuarioPorId(idUsuario);
    }

    public void actualizarUsuario(String idUsuario, Usuario nuevoUsuario) {
        if (idUsuario != null && nuevoUsuario != null) {
            empresaLogisticaFacade.getUsuarioService().actualizarUsuario(idUsuario, nuevoUsuario);
        }
    }

    public void eliminarUsuario(String idUsuario) {
        if (idUsuario != null && !idUsuario.isBlank()) {
            empresaLogisticaFacade.getUsuarioService().eliminarUsuario(idUsuario);
        }
    }
}
