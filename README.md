# Spring Boot REST API Demo

## Compilación 

Para compilar el proyecto se debe ejecutar el siguiente comando:

```bash
mvn clean install
```

## Ejecución

Para ejecutar el proyecto se debe ejecutar el siguiente comando:

```bash
mvn spring-boot:run
```

## Test operación hello con curl

```bash
curl http://localhost:8080/hello
```

## Test operación reverse con curl

```bash
curl http://localhost:8080/reverse?input=world
```

## Test operación removeVowels con curl

```bash
curl http://localhost:8080/removeVowels?input=world
```

## Ejecución de test unitarios

Para ejecutar los test unitarios se debe ejecutar el siguiente comando:

```bash
mvn test
```

## Containerización 

### Contruir imagen Docker

Para construir la imagen Docker se debe ejecutar el siguiente comando:

```bash
docker build -t api-demo .
```

### Ejecutar contenedor Docker

Para ejecutar el contenedor Docker se debe ejecutar el siguiente comando:

```bash
docker run -p 8080:8080 api-demo
```
