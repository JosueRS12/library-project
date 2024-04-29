# library-project
Library of harry potter  

Versión 0.3

## Para Correr:
### Pre-requisitos:
- Docker.
- Docker compose.
- postman (opcional) o donde pueda ejecutar request.

### Pasos:
#### Configuar el ambiente.
- clonar la rama `master`
- Posicionarse en el directorio `./server/library-api/`
  - Crear la imagen del rest api de spring boot:
  - `./mvnw spring-boot:build-image`
   * Creará la imagen del servidor: `library-api:0.0.1-SNAPSHOT`
- Posicionarse en la raiz del directorio `./`
  - Correr el comando: `docker-compose up -d`
 
#### Alimentar la bd
Para esto, seben hacer las request pre-establecidas en el siguiente link de postman. [Colección de postman](https://www.getpostman.com/collections/57edcca8491c2b99f9ff)

Una vez en postman, ejecutar las siguientes request:
 - catalogue/registerCatalogue
 - book/registerBook_[1...3]

## Aplicación - funcionalidades:
- Registrar usuario.
- iniciar sesión.
- crear carrito para usuario.
- agregar producto a carrito del usuario logueado. 
- persistir carrito de usuario.
- consultar los catalogos creados.
- agregar libros al catalogo creado.
- agregar productos al carrito creado.
- eliminar productos del carrito.
- confirmar compra.
- entre otros...

 
> En la proxima versión se tendrá la aplicación totalmente dockerizada => tag
> 0.4

:D :D :D :D
