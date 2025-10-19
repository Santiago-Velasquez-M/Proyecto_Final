package co.edu.uniquindio.biblioteca.parcial1.Service.impl;

import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;
import co.edu.uniquindio.biblioteca.parcial1.Singleton.DataStore;
import co.edu.uniquindio.biblioteca.parcial1.Service.IUsuarioService;

import java.util.List;

public class UsuarioService implements IUsuarioService {

    private final DataStore dataStore = DataStore.getInstance();

    @Override
    public void crearUsuario(Usuario usuario) {
        if (usuario != null) {
            dataStore.getUsuarios().add(usuario);
        }
    }

    @Override
    public Usuario buscarUsuarioPorId(String id) {
        List<Usuario> lista = dataStore.getUsuarios();
        for (int i = 0; i < lista.size(); i++) {
            Usuario u = lista.get(i);
            if (u.getIdUsuario().equalsIgnoreCase(id)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void actualizarUsuario(String id, Usuario nuevoUsuario) {
        List<Usuario> lista = dataStore.getUsuarios();
        for (int i = 0; i < lista.size(); i++) {
            Usuario u = lista.get(i);
            if (u.getIdUsuario().equalsIgnoreCase(id)) {
                lista.set(i, nuevoUsuario);
                return;
            }
        }
    }

    @Override
    public void eliminarUsuario(String id) {
        List<Usuario> lista = dataStore.getUsuarios();
        for (int i = 0; i < lista.size(); i++) {
            Usuario u = lista.get(i);
            if (u.getIdUsuario().equalsIgnoreCase(id)) {
                lista.remove(i);
                return;
            }
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return dataStore.getUsuarios();
    }
}
