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

### 🧩 Patrones de Diseño Implementados
- **Observer:** gestión de notificaciones (SMS / Telegram).
- **Builder:** creación de objetos `Envio` y `Pago`.
- **Facade:** acceso unificado a servicios y lógica de negocio.
- **Strategy:** cálculo de tarifas y métodos de pago simulados.

---

### 🔔 Notificaciones
El sistema integra un **Observer real con conexión a Telegram Bot API**,  
permitiendo enviar notificaciones automáticas al usuario sobre el estado de su envío.

---

### 🧱 Requerimientos Técnicos
- Java 17+
- JavaFX 17+
- Apache POI / PDFBox (para reportes)
- Internet (para pruebas con Telegram)

---

### 👨‍💻 Autores
Proyecto académico para **Programación II - Universidad del Quindío (2025-2)**.  
Desarrollado por **Leandro Ortegón** y equipo.
