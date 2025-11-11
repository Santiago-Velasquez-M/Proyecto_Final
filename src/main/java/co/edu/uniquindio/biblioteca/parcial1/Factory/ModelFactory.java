package co.edu.uniquindio.biblioteca.parcial1.Factory;

import co.edu.uniquindio.biblioteca.parcial1.Enum.DisponibilidadRepartidor;
import co.edu.uniquindio.biblioteca.parcial1.Enum.EstadoEnvio;
import co.edu.uniquindio.biblioteca.parcial1.Enum.MetodoPago;
import co.edu.uniquindio.biblioteca.parcial1.Enum.ResultadoPago;
import co.edu.uniquindio.biblioteca.parcial1.Model.*;
import co.edu.uniquindio.biblioteca.parcial1.Model.Builder.EnvioBuilder;
import co.edu.uniquindio.biblioteca.parcial1.Service.IEmpresaLogisticaService;
import co.edu.uniquindio.biblioteca.parcial1.Service.IUsuarioService;
import co.edu.uniquindio.biblioteca.parcial1.Facade.EmpresaLogisticaFacade;

import java.time.LocalDateTime;

public class ModelFactory {

    private static ModelFactory instance;
    private final IEmpresaLogisticaService empresaLogisticaFacade;
    private EmpresaLogistica empresaLogistica;

    private ModelFactory() {
        empresaLogisticaFacade = new EmpresaLogisticaFacade();
        inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public IEmpresaLogisticaService getEmpresaLogisticaFacade() {
        return empresaLogisticaFacade;
    }

    public EmpresaLogistica getEmpresaLogistica() {
        return empresaLogistica;
    }

    public IUsuarioService getUsuarioService() {
        return empresaLogisticaFacade.getUsuarioService();
    }


    private void inicializarDatos() {

        empresaLogistica = new EmpresaLogistica();
        empresaLogistica.setNombre("Logística Express S.A.S");

        Usuario usuario1 = new Usuario("U001", "Juan Pérez", "juan@example.com", "3001234567", "1234567890");
        Usuario usuario2 = new Usuario("U002", "María Gómez", "maria@correo.com", "abcd", "234567891");

        empresaLogisticaFacade.getUsuarioService().crearUsuario(usuario1);
        empresaLogisticaFacade.getUsuarioService().crearUsuario(usuario2);

        Repartidor repartidor1 = new Repartidor("R001", "Carlos Ramírez", "", "3103833464",
                "Moto", "ABC-123", "Cali", DisponibilidadRepartidor.ACTIVO);

        Repartidor repartidor2 = new Repartidor("R002", "Laura Sánchez", "", "3147454306",
                "Camión", "XYZ-987", "Bogotá", DisponibilidadRepartidor.INACTIVO);

        empresaLogisticaFacade.getRepartidorService().crearRepartidor(repartidor1);
        empresaLogisticaFacade.getRepartidorService().crearRepartidor(repartidor2);

        Tarifa tarifaLocal = new Tarifa("T001", 1000, 5000, 2000, 200, 250);
        Tarifa tarifaNacional = new Tarifa("T002", 15000, 5000, 4000, 150, 350);
        empresaLogisticaFacade.getTarifaService().crearTarifa(tarifaLocal);
        empresaLogisticaFacade.getTarifaService().crearTarifa(tarifaNacional);

        Direccion dirOrigen1 = new Direccion("D001", "Bodega Central", "Cra 12 #45-32", "Cali", "3.4372", "-76.5225");
        Direccion dirDestino1 = new Direccion("D002", "Cliente Bogotá", "Av 68 #10-20", "Bogotá", "4.6097", "-74.0817");
        Direccion dirOrigen2 = new Direccion("D003", "Sucursal Medellín", "Cl 70 #52-30", "Medellín", "6.2442", "-75.5812");
        Direccion dirDestino2 = new Direccion("D004", "Cliente Barranquilla", "Cra 40 #30-15", "Barranquilla", "10.9639", "-74.7964");


        empresaLogisticaFacade.getDireccionService().crearDireccion(dirOrigen1);
        empresaLogisticaFacade.getDireccionService().crearDireccion(dirDestino1);
        empresaLogisticaFacade.getDireccionService().crearDireccion(dirOrigen2);
        empresaLogisticaFacade.getDireccionService().crearDireccion(dirDestino2);

        Pago pago1 = new Pago("P001", 20000, MetodoPago.TARJETA_CREDITO, ResultadoPago.APROBADO);
        Pago pago2 = new Pago("P002", 35000, MetodoPago.TARJETA_DEBITO, ResultadoPago.RECHAZADO);
        empresaLogisticaFacade.getPagoService().crearPago(pago1);
        empresaLogisticaFacade.getPagoService().crearPago(pago2);

        Envio envio1 = new EnvioBuilder()
                .idEnvio("E001")
                .origen(dirOrigen1)
                .destino(dirDestino1)
                .peso(10.5)
                .volumen(2.3)
                .costo(empresaLogisticaFacade.getTarifaService()
                        .calcularCosto(10.5, 2.3, true))
                .estadoEnvio(EstadoEnvio.ASIGNADO)
                .fechaCreacion(LocalDateTime.now())
                .fechaEntregaEstimada(LocalDateTime.now().plusDays(2))
                .usuario(usuario1)
                .repartidor(repartidor1)
                .pago(pago1)
                .tarifa(tarifaLocal)
                .build();

        Envio envio2 = new EnvioBuilder()
                .idEnvio("E002")
                .origen(dirOrigen2)
                .destino(dirDestino2)
                .peso(20.0)
                .volumen(5.0)
                .costo(empresaLogisticaFacade.getTarifaService()
                        .calcularCosto(20.0, 5.0, true))
                .estadoEnvio(EstadoEnvio.EN_RUTA)
                .fechaCreacion(LocalDateTime.now())
                .fechaEntregaEstimada(LocalDateTime.now().plusDays(3))
                .usuario(usuario2)
                .repartidor(repartidor2)
                .pago(pago2)
                .tarifa(tarifaNacional)
                .build();

        empresaLogisticaFacade.getEnvioService().crearEnvio(envio1);
        empresaLogisticaFacade.getEnvioService().crearEnvio(envio2);

        System.out.println("Datos de prueba cargados correctamente en el sistema.");
    }
}
