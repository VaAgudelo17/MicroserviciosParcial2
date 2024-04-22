# MicroserviciosParcial2
creación del microservicio Usuarios y Eureka 

## 👤📚Servicio usuario 📚
### Dependencias utilizadas 
#### 🌟Spring Boot DevTools:
Esta dependencia está diseñada para hacer la vida del desarrollador más fácil. Proporciona características como el reinicio automático de la aplicación cada vez que se hacen cambios en el código, lo cual es muy útil durante el desarrollo ya que te ahorra tiempo al no tener que reiniciar manualmente la aplicación. Además, DevTools incluye configuraciones predeterminadas para mejorar la experiencia de desarrollo.

#### 🌟Spring Data JPA:
Spring Data JPA es una extensión de Spring que facilita la implementación de repositorios basados en JPA (Java Persistence API). Esta dependencia permite a los desarrolladores escribir menos código de acceso a datos, ya que maneja automáticamente la creación de consultas y la gestión de transacciones. Simplifica enormemente el trabajo con bases de datos en aplicaciones Java, permitiendo que te concentres más en la lógica del negocio en lugar de en la interacción directa con la base de datos.

#### 🌟Postgres Driver:
Esta es la dependencia del controlador JDBC para PostgreSQL. Es necesaria para que las aplicaciones Java puedan conectarse y operar con una base de datos PostgreSQL. El controlador traduce las llamadas hechas desde el código Java en comandos que la base de datos PostgreSQL puede entender y procesar. Si estás trabajando con PostgreSQL como tu sistema de gestión de bases de datos, necesitarás esta dependencia para la conexión.

#### 🌟Spring Web:
Spring Web, parte de Spring MVC, es una dependencia que proporciona funcionalidades para desarrollar aplicaciones web. Incluye soporte para desarrollar servicios web RESTful, manejo de solicitudes HTTP, y mucho más. Spring Web facilita la creación de interfaces de usuario web y la integración con otras tecnologías web, lo que lo hace muy poderoso y flexible para el desarrollo de aplicaciones modernas basadas en la web.

### Decoradores utilizados 

#### ✨@Id
Esta anotación se utiliza para especificar la propiedad que actúa como la clave primaria de una entidad. Cada entidad debe tener una clave primaria que la identifique de manera única.

#### ✨@Entity
Se coloca sobre una clase para indicar que esta clase es una entidad JPA. Esto significa que la clase está vinculada a una tabla en la base de datos, y cada instancia de la clase representará una fila en esa tabla.

#### ✨@Table
Se usa para especificar detalles de la tabla que estará asociada con la entidad mapeada. Permite configurar opciones de la tabla como el nombre de la tabla en la base de datos (name), el catálogo (catalog), y el esquema (schema) entre otros.

#### ✨@GeneratedValue
Esta anotación se utiliza junto con @Id para especificar la estrategia de generación de la clave primaria. JPA provee varias estrategias de generación como AUTO, SEQUENCE, IDENTITY, y TABLE, que permiten que el valor sea generado automáticamente al insertar un nuevo registro.

#### ✨@Column
Se utiliza para definir las características de una columna en la tabla de base de datos que corresponde a un campo o propiedad de la entidad, como el nombre de la columna (name), si puede ser nula (nullable), su longitud (length), etc.

#### ✨@Temporal:
Se usa para precisar cómo se debe mapear un campo java.util.Date o java.util.Calendar a una base de datos. Las opciones incluyen TemporalType.DATE (solo fecha), TemporalType.TIME (solo hora), y TemporalType.TIMESTAMP (fecha y hora).

#### ✨@PrePersist:
Es un tipo de callback en el ciclo de vida de las entidades que se invoca justo antes de que la entidad sea persistida (insertada) en la base de datos. Se puede usar para ejecutar algún código justo antes de que la entidad sea guardada, como configurar un timestamp o calcular un valor.

#### ✨@Transactional:
se utiliza para declarar que un método, o todos los métodos de una clase, deben ser ejecutados dentro de un contexto transaccional. Esto significa que las operaciones realizadas dentro del método forman parte de una transacción de base de datos, las cuales son gestionadas automáticamente por Spring.

### Conceptos en Spring Boot :
#### 🔆ResponseEntity<?>
Es una clase en Spring Framework usada para representar toda la respuesta HTTP, incluyendo el cuerpo, estado y cabeceras. Esta clase es parametrizable, lo que significa que puedes definir el tipo de dato que quieres que contenga el cuerpo de la respuesta con ResponseEntity<T>, donde T es el tipo de dato del cuerpo.

#### 🔆Optional
Es una clase contenedor introducida en Java 8 que puede contener o no un valor. Esta clase se utiliza para representar un valor que puede ser opcionalmente presente o ausente, ayudando a evitar el uso de null y los errores relacionados con NullPointerException.

#### 🔆@PathVariable
Es una anotación utilizada en Spring MVC para indicar que un parámetro de método debe estar vinculado a una variable de plantilla URI (parte de la URL). 

## 👤🖥Servicio Eureka🖥

### Definición:
Es un componente clave dentro de Spring Cloud que actúa como un servidor de descubrimiento de servicios. Este servidor es parte del patrón de diseño de microservicios, facilitando la forma en que los servicios dentro de una arquitectura de microservicios se localizan y comunican entre sí. Eureka es desarrollado y mantenido por Netflix y está integrado en el ecosistema Spring Cloud para su uso en aplicaciones Java.


