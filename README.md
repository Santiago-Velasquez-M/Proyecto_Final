# 📦 Proyecto Final - Plataforma de Logística

### 🧠 Descripción General
Aplicación desarrollada en **JavaFX** que simula una **plataforma de envíos urbanos tipo “same-day”**, permitiendo a los usuarios registrar pedidos, rastrear paquetes y recibir notificaciones de estado.  
El sistema cuenta con dos perfiles: **Usuario** y **Administrador**.

---

### 🚀 Funcionalidades Principales
#### 👤 Usuario
- Registro e inicio de sesión.
- Gestión de perfil y direcciones frecuentes.
- Cotización de tarifas según peso, volumen y prioridad.
- Creación y cancelación de solicitudes de envío.
- Pago simulado y consulta de comprobantes.
- Seguimiento del estado del envío (Solicitado, En ruta, Entregado).
- Recepción de notificaciones por **SMS** y **Telegram**.

#### 🧑‍💼 Administrador
- Gestión de usuarios y repartidores.
- Asignación de envíos y control de estado.
- Panel de métricas con **gráficos JavaFX**.
- Generación de reportes en **CSV** y **PDF**.

---

### ⚙️ Estructura del Proyecto


src/

├── Model/ # Entidades principales (Usuario, Envio, Pago, etc.)

├── Observer/ # Interfaces y clases del patrón Observer(Notificaciones)


├── Facade/ # Fachada central (EmpresaLogisticaFacade)

├── Controller/ # Lógica de negocio por rol (Usuario, Envío, Admin)

└── ViewController/ # Controladores de interfaz JavaFX


---


---

### 🧩 Patrones de Diseño Implementados

##### 🟢 **Singleton #2 — DataStore (Almacenamiento central de datos)**
El segundo uso del patrón Singleton se encuentra en la clase `DataStore`, que funciona como una **base de datos en memoria** dentro del sistema.  
Su objetivo es almacenar las listas principales del proyecto —usuarios, repartidores, envíos, pagos, tarifas y direcciones—, asegurando que **todas las operaciones compartan la misma información** en tiempo real.

Gracias a que solo existe una instancia de `DataStore`, los cambios realizados desde cualquier servicio se reflejan de forma inmediata en toda la aplicación.  
Esto mantiene la **coherencia global** de los datos sin necesidad de utilizar una base de datos externa.

El patrón se aplica garantizando que:
- El constructor de `DataStore` sea **privado**, impidiendo múltiples instancias.
- La clase posea un **método estático `getInstance()`**, que crea la instancia única solo la primera vez que se solicita.
- Todos los servicios accedan a la misma instancia compartida.

En conjunto, `DataStore` y `ModelFactory` implementan el patrón Singleton de manera complementaria:  
uno como **centro de servicios** y el otro como **centro de datos**, brindando estabilidad, sincronización y control global a toda la plataforma logística.

---


#### 🧱 **2. Facade — Una puerta de entrada simplificada al sistema**
El patrón **Facade** tiene como objetivo ofrecer una interfaz unificada para interactuar con subsistemas complejos.  
En este caso, la clase `EmpresaLogisticaFacade` actúa como una “fachada” que reúne y simplifica el acceso a los servicios de usuarios, envíos, pagos, tarifas y repartidores.  
Gracias a este diseño, el código se vuelve más limpio, modular y fácil de mantener, ya que las demás capas de la aplicación no necesitan conocer los detalles internos de cada servicio, sino que interactúan directamente con la fachada.

---

#### 🧱 **3. Observer — Comunicación automática entre componentes**
El patrón **Observer** permite que ciertos objetos sean notificados automáticamente cuando otro cambia su estado.  
En el sistema, se aplica en la gestión de los **envíos**, donde el `EnvioService` actúa como el sujeto observado.  
Cuando un envío cambia de estado (por ejemplo, de *ASIGNADO* a *EN RUTA* o *ENTREGADO*), los observadores como `NotificacionSms` y `NotificacionTelegram` reciben una alerta y ejecutan una acción (enviar mensajes al usuario).  
Este patrón aporta **automatización y reactividad**, eliminando la necesidad de notificaciones manuales y manteniendo la información sincronizada entre los diferentes canales.

---

#### 🧱 **4. Builder — Creación flexible de objetos**
El patrón **Builder** facilita la construcción de objetos complejos paso a paso.  
En este proyecto se usa para instanciar entidades como `Envio` y `Pago`, las cuales requieren múltiples parámetros.  
El Builder mejora la **legibilidad**, evita errores en la inicialización y permite crear variaciones de objetos sin sobrecargar los constructores.

---

#### 🧱 **5. Strategy — Variabilidad en los cálculos**
El patrón **Strategy** se aplica en el cálculo de tarifas y métodos de pago simulados.  
Permite definir diferentes estrategias (por ejemplo, envíos locales, nacionales o prioritarios) y seleccionar dinámicamente la que se debe utilizar sin modificar el resto del código.  
Esto hace que el sistema sea más **flexible y extensible**, ya que se pueden añadir nuevas formas de cálculo o métodos de pago sin alterar la estructura principal.

---

### 🔔 Notificaciones Automatizadas
El sistema incorpora un **Observer real** que interactúa con la **Telegram Bot API**, permitiendo enviar mensajes automáticos a los usuarios sobre el estado de sus envíos.  
Gracias a esta integración, cada cambio de estado se traduce en una notificación inmediata por los canales registrados (SMS y Telegram), reflejando un comportamiento similar al de una plataforma logística profesional.

---

### 🧱 Requerimientos Técnicos
- **Java 17+**
- **JavaFX 17+**
- **Apache POI / PDFBox** (para generación de reportes en PDF y Excel)
- **Conexión a Internet** (para pruebas de notificaciones con Telegram)

---

### 👨‍💻 Autores
Proyecto académico desarrollado para la asignatura **Programación II - Universidad del Quindío (2025-2)**.  
Creado por **Leandro Ortegón** y **Santiago Velásquez**, como una simulación completa de un sistema de gestión logística moderna, integrando interfaz gráfica, persistencia de datos y patrones de diseño avanzados.
