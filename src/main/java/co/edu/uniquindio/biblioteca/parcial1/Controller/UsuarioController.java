package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Dto.UsuarioDto;
import co.edu.uniquindio.biblioteca.parcial1.Facade.EmpresaLogisticaFacade;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<UsuarioDto> listarUsuariosDto() {
        return listarUsuarios()
                .stream()
                .map(this::convertirAUsuarioDto)
                .collect(Collectors.toList());
    }

    public void crearUsuarioDto(UsuarioDto dto) {
        if (dto != null) {
            empresaLogisticaFacade.getUsuarioService().crearUsuario(convertirAUsuario(dto));
        }
    }

    public UsuarioDto buscarUsuarioDtoPorId(String idUsuario) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        return usuario != null ? convertirAUsuarioDto(usuario) : null;
    }

    public void actualizarUsuarioDto(String idUsuario, UsuarioDto dto) {
        if (idUsuario != null && dto != null) {
            empresaLogisticaFacade.getUsuarioService().actualizarUsuario(idUsuario, convertirAUsuario(dto));
        }
    }

    public void eliminarUsuarioDto(String idUsuario) {
        eliminarUsuario(idUsuario);
    }

    private UsuarioDto convertirAUsuarioDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getIdUsuario(),
                usuario.getNombreCompleto(),
                usuario.getCorreo(),
                usuario.getTelefono(),
                usuario.getDocumento()
        );
    }

    private Usuario convertirAUsuario(UsuarioDto dto) {
        return new Usuario(
                dto.getIdUsuario(),
                dto.getNombreCompleto(),
                dto.getCorreo(),
                dto.getTelefono(),
                dto.getDocumento()
        );
    }
}
