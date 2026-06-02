# Gestion Hexagonal - API RESTful

API RESTful construida con **Spring Boot** sobre **arquitectura Hexagonal** (puertos y adaptadores).
Incluye el **CRUDL de Usuarios** (con autenticacion JWT) y el **CRUDL de Empleos** (tabla asignada).

Universidad de Cartagena - Facultad de Ingenieria - Ingenieria de Software.

---

## Tecnologias

- Java 17
- Spring Boot 3.2.5 (Web, Data JPA, Security, Validation)
- JWT (jjwt 0.12.5)
- MySQL 8
- Maven

---

## Arquitectura Hexagonal

La aplicacion se organiza en tres capas concentricas. La regla de dependencia es estricta:
**el dominio no depende de nadie, y la infraestructura depende de la aplicacion, nunca al reves.**

```
com.unicartagena.gestion
│
├── domain/                         <- NUCLEO. Modelos y reglas de negocio puras.
│   ├── model/                         Usuario, Empleo (POJOs sin frameworks)
│   └── exception/                     Excepciones de negocio
│
├── application/                    <- CASOS DE USO. Orquesta el dominio.
│   ├── port/in/                       Puertos de ENTRADA (que ofrece la app)
│   ├── port/out/                      Puertos de SALIDA (que necesita del exterior)
│   └── service/                       Implementacion de los casos de uso
│
└── infrastructure/                 <- ADAPTADORES. Detalles tecnicos.
    ├── entrypoint/rest/               Adaptador de ENTRADA: controladores REST, DTOs, mappers
    ├── adapter/persistence/           Adaptador de SALIDA: JPA, entidades, repositorios
    ├── security/                      JWT, BCrypt, filtros y configuracion de Spring Security
    └── config/                        Configuracion general
```

### Flujo de una peticion (ejemplo: crear usuario)

```
HTTP POST /api/usuarios
  -> UsuarioController            (adaptador de entrada REST)
  -> UsuarioServicePort           (puerto de entrada)
  -> UsuarioService               (caso de uso, capa de aplicacion)
  -> UsuarioRepositoryPort        (puerto de salida)
  -> UsuarioPersistenceAdapter    (adaptador de salida, implementa el puerto)
  -> UsuarioJpaRepository         (Spring Data JPA -> MySQL)
```

El nucleo (dominio + aplicacion) no sabe que existe REST, JPA ni MySQL. Solo conoce
interfaces (puertos). Esto permite cambiar la tecnologia sin tocar la logica de negocio.

---

## Como ejecutar

1. Tener Java 17 y MySQL.
2. Crear la base de datos:
   ```sql
   CREATE DATABASE gestion_hexagonal;
   ```
3. Ajustar usuario y contrasena en `src/main/resources/application.properties`.
4. Ejecutar:
   - Desde el IDE: ejecutar la clase `GestionHexagonalApplication`.
   - Desde terminal: `mvn spring-boot:run`
5. La API queda en `http://localhost:8080`

---

## Endpoints

### Autenticacion (publico)
| Metodo | Ruta              | Descripcion                          |
|--------|-------------------|--------------------------------------|
| POST   | `/api/auth/login` | Login: devuelve un token JWT         |

### Usuarios
| Metodo | Ruta                    | Auth        | Descripcion          |
|--------|-------------------------|-------------|----------------------|
| POST   | `/api/usuarios`         | Publico     | Crear usuario        |
| GET    | `/api/usuarios`         | Bearer JWT  | Listar usuarios      |
| GET    | `/api/usuarios/{cedula}`| Bearer JWT  | Obtener un usuario   |
| PUT    | `/api/usuarios/{cedula}`| Bearer JWT  | Actualizar usuario   |
| DELETE | `/api/usuarios/{cedula}`| Bearer JWT  | Eliminar usuario     |

### Empleos (todos requieren Bearer JWT)
| Metodo | Ruta                | Descripcion         |
|--------|---------------------|---------------------|
| POST   | `/api/empleos`      | Crear empleo        |
| GET    | `/api/empleos`      | Listar empleos      |
| GET    | `/api/empleos/{id}` | Obtener un empleo   |
| PUT    | `/api/empleos/{id}` | Actualizar empleo   |
| DELETE | `/api/empleos/{id}` | Eliminar empleo     |

---

## Uso con token

1. Crear un usuario con `POST /api/usuarios`.
2. Hacer login con `POST /api/auth/login` -> copiar el `token` de la respuesta.
3. En las demas peticiones, agregar el header:
   ```
   Authorization: Bearer <token>
   ```

La coleccion de Postman incluida (`gestion-hexagonal.postman_collection.json`) ya guarda
el token automaticamente tras el login.

---

## Autor

David Santiago Escamilla Castro
