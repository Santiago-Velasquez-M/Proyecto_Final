package co.edu.uniquindio.biblioteca.parcial1.Factory;

import co.edu.uniquindio.biblioteca.parcial1.Model.*;
import co.edu.uniquindio.biblioteca.parcial1.Repository.*;
import co.edu.uniquindio.biblioteca.parcial1.Enum.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ModelFactory {

    private static ModelFactory instance;


    private final UsuarioRepository usuarioRepository;
    private final RepartidorRepository repartidorRepository;
    private final EnvioRepository envioRepository;
    private final PagoRepository pagoRepository;

    private ModelFactory() {
        usuarioRepository = new UsuarioRepository();
        repartidorRepository = new RepartidorRepository();
        envioRepository = new EnvioRepository();
        pagoRepository = new PagoRepository();

        cargarDatosQuemados();
    }

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }


    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public RepartidorRepository getRepartidorRepository() {
        return repartidorRepository;
    }

    public EnvioRepository getEnvioRepository() {
        return envioRepository;
    }

    public PagoRepository getPagoRepository() {
        return pagoRepository;
    }


    private void cargarDatosQuemados() {

        Direccion dirCasaAna = new Direccion("D001", "Casa", "Calle 10 #5-33", "Armenia", "4.533,-75.681");
        Direccion dirTrabajoLuis = new Direccion("D002", "Trabajo", "Cra 8 #12-45", "Pereira", "4.814,-75.694");
        Direccion dirCasaMaria = new Direccion("D003", "Casa", "Av Bolívar 123", "Cali", "3.451,-76.531");

        Usuario ana = new Usuario("U001", "Ana Pérez", "ana.perez@mail.com", "3104567890", new ArrayList<>());
        Usuario luis = new Usuario("U002", "Luis Díaz", "luis.diaz@mail.com", "3119876543", new ArrayList<>());
        Usuario maria = new Usuario("U003", "María López", "maria.lopez@mail.com", "3001234567", new ArrayList<>());

        usuarioRepository.agregarUsuario(ana);
        usuarioRepository.agregarUsuario(luis);
        usuarioRepository.agregarUsuario(maria);

        Repartidor repCarlos = new Repartidor("REP001", "Carlos Pérez", "3124567890", "Moto", "ABC-123");
        Repartidor repDaniela = new Repartidor("REP002", "Daniela Gómez", "3109876543", "Carro", "XYZ-789");
        Repartidor repJorge = new Repartidor("REP003", "Jorge Ruiz", "3001234567", "Camioneta", "LMN-456");

        repartidorRepository.agregarRepartidor(repCarlos);
        repartidorRepository.agregarRepartidor(repDaniela);
        repartidorRepository.agregarRepartidor(repJorge);

        // 🔹 Pagos
        Pago pago1 = new Pago("P001", 7500, MetodoPago.TARJETA_CREDITO, LocalDateTime.now(), ResultadoPago.APROBADO);
        Pago pago2 = new Pago("P002", 6400, MetodoPago.EFECTIVO, LocalDateTime.now(), ResultadoPago.APROBADO);
        Pago pago3 = new Pago("P003", 8200, MetodoPago.TRANSFERENCIA, LocalDateTime.now(), ResultadoPago.RECHAZADO);

        pagoRepository.agregarPago(pago1);
        pagoRepository.agregarPago(pago2);
        pagoRepository.agregarPago(pago3);

        Envio envio1 = new Envio(dirCasaAna, dirTrabajoLuis, 1.2, 0.3, 7500,
                LocalDateTime.now().plusDays(2), repCarlos, ana, pago1);
        envio1.setId("ENV001");

        Envio envio2 = new Envio(dirTrabajoLuis, dirCasaMaria, 2.5, 0.5, 6400,
                LocalDateTime.now().plusDays(3), repDaniela, luis, pago2);
        envio2.setId("ENV002");

        Envio envio3 = new Envio(dirCasaMaria, dirCasaAna, 3.1, 0.8, 8200,
                LocalDateTime.now().plusDays(1), repJorge, maria, pago3);
        envio3.setId("ENV003");

        envioRepository.agregarEnvio(envio1);
        envioRepository.agregarEnvio(envio2);
        envioRepository.agregarEnvio(envio3);

        System.out.println("Datos quemados cargados correctamente sin duplicados.");
    }
}
