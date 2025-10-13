package co.edu.uniquindio.biblioteca.parcial1.Service;

import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import java.util.List;

public interface IUsuarioService {
    void crearUsuario(Usuario usuario);
    Usuario buscarUsuarioPorId(String id);
    void actualizarUsuario(String id, Usuario nuevoUsuario);
    void eliminarUsuario(String id);
    List<Usuario> listarUsuarios();
}
