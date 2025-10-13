package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import co.edu.uniquindio.biblioteca.parcial1.Repository.UsuarioRepository;
import java.util.List;

public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl() {
        this.usuarioRepository = ModelFactory.getInstance().getUsuarioRepository();
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        usuarioRepository.agregarUsuario(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorId(String id) {
        return usuarioRepository.buscarUsuarioPorId(id);
    }

    @Override
    public void actualizarUsuario(String id, Usuario nuevoUsuario) {
        usuarioRepository.actualizarUsuario(id, nuevoUsuario);
    }

    @Override
    public void eliminarUsuario(String id) {
        usuarioRepository.eliminarUsuario(id);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.obtenerUsuarios();
    }
}
