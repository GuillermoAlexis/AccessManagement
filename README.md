# ClientAccessManagement - Backend

Este proyecto contiene el backend para la gestión de acceso y permisos de usuarios en la aplicación ClientAccessManagement. A continuación, se detallan las entidades, mappers, DTOs, servicios, controladores y otros componentes principales del proyecto.

## Estructura del Proyecto

El proyecto está estructurado en varios paquetes para organizar las diferentes partes de la aplicación. A continuación, se presenta una descripción general de cada uno de los paquetes:

- `com.app.AccessManagement.controller`: Contiene los controladores que manejan las solicitudes HTTP y definen los puntos de enlace de la API.
- `com.app.AccessManagement.dto`: Contiene los DTOs (Data Transfer Objects) utilizados para intercambiar información entre capas.
- `com.app.AccessManagement.mapper`: Contiene los mappers que convierten entre entidades y DTOs.
- `com.app.AccessManagement.model`: Contiene las entidades que representan las tablas en la base de datos.
- `com.app.AccessManagement.repository`: Contiene los repositorios JPA para acceder a los datos en la base de datos.
- `com.app.AccessManagement.service`: Contiene las interfaces y sus implementaciones que definen la lógica del negocio.

## Uso

1. Clona este repositorio en tu máquina local.

git clone https://github.com/tu-usuario/ClientAccessManagement-backend.git


2. Importa el proyecto en tu entorno de desarrollo preferido (por ejemplo, Eclipse, IntelliJ IDEA).

3. Configura y asegúrate de que tengas una base de datos compatible en funcionamiento, y actualiza la configuración de conexión en `application.properties` según sea necesario.

4. Ejecuta la clase `AccessManagementApplication` para iniciar la aplicación backend.

## Endpoints de la API

A continuación, se listan algunos de los endpoints disponibles en la API del backend:

- `/accesos`: Operaciones relacionadas con los accesos de usuarios.
- `/permisos`: Operaciones relacionadas con los permisos de usuarios.
- `/usuarios`: Operaciones relacionadas con los usuarios, incluido el inicio de sesión.
