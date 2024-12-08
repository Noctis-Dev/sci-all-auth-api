# Sci-All Auth API

API desarrollada en Java 17 para gestionar la autenticación y autorización dentro del ecosistema Sci-All, implementada con una arquitectura hexagonal.

## Tecnologías
- **Java 17**
- **Spring Boot**
- **Spring Security**
- **Flyway** (para migraciones de base de datos)
- **Docker** (opcional)
- **H2 Database** (por defecto, para pruebas locales)

## Requisitos
- Tener **Java 17** instalado en tu máquina. Puedes descargar Amazon Corretto [aquí](https://aws.amazon.com/es/corretto/).
- **Maven** (versión 3.8.4 o superior). Descárgalo desde [Maven](https://maven.apache.org/download.cgi).
- Tener **Docker** instalado para configurar la base de datos (opcional). Descárgalo desde [Docker Desktop](https://www.docker.com/products/docker-desktop/).

## Cómo Iniciar el Proyecto

### Opcion 1: Usando Docker para la base de datos

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/Noctis-Dev/sci-all-auth-api.git
   cd sci-all-auth-api
   ```

2. **Construye la base de datos con Docker:**
   ```bash
   docker run --name sci_all_auth_postgres -e POSTGRES_PASSWORD=adminadmin -p 5433:5433 -d postgres
   ```

3. **Configura el archivo `application.properties`:**
   Abre el archivo `src/main/resources/application.properties` y asegúrate de que la configuración sea la siguiente:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5433/sci_all_auth
   spring.datasource.username=postgres
   spring.datasource.password=adminadmin
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Compila el proyecto:**
   ```bash
   mvn clean install
   ```

5. **Ejecuta la aplicación:**
   ```bash
   mvn spring-boot:run
   ```

6. **Accede a la API:**
   Abre [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) para ver la documentación interactiva de la API.

### Notas Finales
- Este proyecto utiliza una base de datos H2 para pruebas locales por defecto, pero es recomendable usar PostgreSQL para entornos de desarrollo y producción.
- Si encuentras algún problema, por favor abre un _issue_ en el repositorio.

