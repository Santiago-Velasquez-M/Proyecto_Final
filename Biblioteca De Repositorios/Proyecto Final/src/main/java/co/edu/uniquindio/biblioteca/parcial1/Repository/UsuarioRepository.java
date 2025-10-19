package co.edu.uniquindio.biblioteca.parcial1.Repository;

import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario) {
        boolean existe = usuarios.stream()
                .anyMatch(u -> u.getIdUsuario().equals(usuario.getIdUsuario()));

        if (!existe) {
            usuarios.add(usuario);
        } else {
            System.out.println("Usuario con ID " + usuario.getIdUsuario() + " ya existe. No se agregó nuevamente.");
        }
    }

    public Usuario buscarUsuarioPorId(String id) {
        return usuarios.stream()
                .filter(u -> u.getIdUsuario().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void actualizarUsuario(String id, Usuario nuevoUsuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdUsuario().equals(id)) {
                usuarios.set(i, nuevoUsuario);
                break;
            }
        }
    }

    public void eliminarUsuario(String id) {
        usuarios.removeIf(u -> u.getIdUsuario().equals(id));
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }
}
