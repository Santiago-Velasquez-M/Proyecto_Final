package co.edu.uniquindio.biblioteca.parcial1.Controller;

import co.edu.uniquindio.biblioteca.parcial1.Facade.EmpresaLogisticaFacade;
import co.edu.uniquindio.biblioteca.parcial1.Factory.ModelFactory;
import co.edu.uniquindio.biblioteca.parcial1.Model.Usuario;

import java.util.UUID;

public class RegistroUsuarioController {

    private EmpresaLogisticaFacade facade;

    public void initialize() {
        facade = (EmpresaLogisticaFacade)
                ModelFactory.getInstance().getEmpresaLogisticaFacade();
    }

    public void registrarUsuario(String nombre, String cedula, String telefono, String correo) {

        String id = UUID.randomUUID().toString();

        Usuario usuario = new Usuario(
                id,          // idUsuario
                nombre,      // nombreCompleto
                correo,      // correo
                telefono,    // teléfono
                cedula       // documento
        );

        facade.getUsuarioService().crearUsuario(usuario);
    }
}
