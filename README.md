# Practica 6: Testing de una aplicacion de Spring Boot

## Emilio Kenji Hernández Kuramata


### Enunciado

Dado un desarrollo de Spring Boot, es necesario anhadir tests a las siguientes clases:

  

- DNI & Telefono (Unit Tests) (Cada clase tiene un metodo y varias casuisticas para probar)

- ProcessController (E2E Tests) (2 endpoints)

  

```

mvn clean spring-boot:run

  

curl -v -X POST http://localhost:8080/api/v1/process-step1-legacy \

-H "Content-Type: application/x-www-form-urlencoded" \

-d "fullName=Juan%20Antonio%20Brena%20Moral&dni=12345678Z&telefono=%2B34%20600903434"

  

curl -v -X POST http://localhost:8080/api/v1/process-step1 \

-H 'Content-Type: application/json' \

-d '{"fullName":"Juan Antonio Brena Moral","dni":"12345678Z", "telefono":"+34 600903434"}'

```



### Método

 A partir de la teoría y del ejemplo subido en https://github.com/gitt-3-pat/ejemplos-2022/tree/main/tema-8/testing-example , aplicaré el código necesario.

  

### Contenido (Requerido)

  

Mi site contiene lo siguiente:

  

1) DNI & Telefono (Unit Tests): 
- En DNI compruebo estas casuisticas:
-- Que ocurre si utilizo un DNI invalido
-- Que ocurre si entro un DNI en un formato incorrecto
-- Que ocurre si la última letra en DNI es una invalida
-- Caso perfecto
- En Telefono compruebo estas casuisticas:
-- Que ocurre si pongo un telefono en un formato incorrecto
-- Caso perfecto

2) ProcessController (E2E Tests) (2 endpoints)
Se comprueba para ambos tipos:
-- Datos introducidos incorrectos
-- Datos introducidos vacios
-- Dirección incorrecto
-- Caso perfecto
  
### Contenido (Extra)

He añadido esto de extra a mi site:
  

### Todo se puede comprobar en mi Github page de esta práctica:

  

https://github.com/EmilioKenjiHK/Practica6