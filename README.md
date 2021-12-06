# library-project
Library of harry potter  

Versión 0.2

## Para Correr:
### Pre-requisitos:
- Docker.
- Docker compose.
- postman (opcional) o donde pueda ejecutar request.
- java version 11.
- springboot version 2.0.6

### Pasos:
#### Configuar el ambiente.
- clonar la rama `master`
- Posicionarse en el directorio `Library-app/client/library`
  - Ejecutar el comando `docker-compose up -d`:
   * Este expondrá el puerto 3000 del contenedor al puerto 3000 del local.
   * De este modo se tendrá el server del cliente corriendo.
- Posicionarse en la ruta `Library-app/server/scripts`  
  - Ejecutar los siguientes comandos en orden:
  ```
  docker run --name postgresdb -e POSTGRES_PASSWORD=admin -d -p 5430:5432 postgres:14.1-alpine

  # posicionarse en /scripts
  docker cp create.sql postgresdb:./

  # entrar al contenedor
  docker exec -it postgresdb bash

  psql -U postgres --file create.sql 


  # para acceder a db
  psql -U postgres -d librarydb 

  ```
  - Esto levantará el contenedor de la base de datos en postgres
- Ejecutar Server de Sprinboot (2 opciones):
  - Abrir el proyecto ubicado en `Library-app/server/library-api` en algún IDE (preferiblemente intellij)
   - Ejecutar la clase main `LibraryApiApplication` 
  - 
  - Crear ejecutable con mvn: `mvn clean install` en el path `Library-app/server/library-api` 
   - Ejecutar con `java -jar [nombre del ejecutable generado].`
 
#### Alimentar la bd
Para esto, seben hacer las request pre-establecidas en el siguiente link de postman. [Colección de postman](https://www.getpostman.com/collections/57edcca8491c2b99f9ff)

Una vez en postman, ejecutar las siguientes request:
 - client/RegisterUser
 - catalogue/registerCatalogue
 - book/registerBook_[1...3]
 - cart/create

## Aplicación
En esta versión se puede:
- agregar libros al catalogo creado.
- agregar libros al carrito creado.
- eliminar libros del carrito.
- confirmar compra.

##### Limitaciones
> El carrito está estático para el id del cliente creado en la request; También listar productos está estático para el catalogo creado en la request.
> Registrar usuario no está implementado del lado del cliente.

Se está trabajando para solventar las limitaciones. Se lanzará una versión nueva prontamente con el tag `0.3`.

:D :D :D :D
