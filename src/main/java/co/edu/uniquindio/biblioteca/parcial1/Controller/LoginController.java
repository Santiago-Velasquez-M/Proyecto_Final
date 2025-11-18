package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Model.Administrador;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;

public class LoginController {

    private final ModelFactory modelFactory;

    public LoginController() {
        this.modelFactory = ModelFactory.getInstance();
    }

    public Usuario login(String correoODocumento, String contrasena) {

        if (correoODocumento == null || correoODocumento.isBlank()) {
            return null;
        }

        Usuario usuario = modelFactory.getUsuarioService()
                .buscarPorCorreoODocumento(correoODocumento);

        if (usuario == null) {
            return null;
        }

        // comparar contraseña con el documento (porque no tienes clave en Usuario)
        if (usuario.getDocumento().equals(contrasena)) {
            return usuario;
        }

        return null;
    }


    public Administrador loginAdmin(String idAdmin, String clave) {

        Administrador admin = modelFactory.getEmpresaLogistica().getAdministrador();

        if (admin == null) {
            return null;
        }

        if (admin.getIdUsuario().equals(idAdmin) &&
                admin.getClave().equals(clave)) {

            return admin;
        }

        return null;
    }
}
