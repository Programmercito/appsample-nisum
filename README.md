# Appsample

## Stack
- Base de datos: H2
- Java 11
- Spring Boot
- Token: JWT de Auth0
- Generador de contraseñas: Jbcrypt
- Maven
- Pruebas Unitarias Spring boot test (junit)

## Diagrama de clases
![Diagrama de clases](https://github.com/Programmercito/appsample-nisum/blob/main/diagrama.png?raw=true)

Esta es una aplicación de ejemplo que incluye validaciones, capturadores de errores y utiliza H2 como base de datos con una capa de servicio en el medio.

# Instalación con MAVEN en local

Para ejecutar la aplicación, sigue estos pasos:

1. Instala H2 en tu máquina local y
2. Por defecto la aplicacion ya tiene creacion de tablas automatica en la base de datos "test" sin embargo si quieres mantener los datos comenta la propiedad:
```
spring.jpa.hibernate.ddl-auto=create
```
Y ejecuta el siguiente escript en la base de datos H2 en la base de datos "test": 
```
CREATE CACHED TABLE "PUBLIC"."TELEFONO"(
    "CITYCODE" CHARACTER VARYING(255),
    "COUNTRYCODE" CHARACTER VARYING(255),
    "ID" CHARACTER VARYING(255) NOT NULL,
    "NUMBER" CHARACTER VARYING(255),
    "USUARIO_ID" CHARACTER VARYING(255)
);     
ALTER TABLE "PUBLIC"."TELEFONO" ADD CONSTRAINT "PUBLIC"."PK_TELEFONO" PRIMARY KEY("ID");     
CREATE CACHED TABLE "PUBLIC"."USUARIO"(
    "ISACTIVE" BOOLEAN,
    "CREATED" TIMESTAMP(6),
    "LAST_LOGIN" TIMESTAMP(6),
    "MODIFIED" TIMESTAMP(6),
    "EMAIL" CHARACTER VARYING(255),
    "ID" CHARACTER VARYING(255) NOT NULL,
    "NAME" CHARACTER VARYING(255),
    "PASSWORD" CHARACTER VARYING(255),
    "TOKEN" CHARACTER VARYING(1000)
);               
ALTER TABLE "PUBLIC"."USUARIO" ADD CONSTRAINT "PUBLIC"."PK_USUARIO" PRIMARY KEY("ID");     
ALTER TABLE "PUBLIC"."USUARIO" ADD CONSTRAINT "PUBLIC"."UK_USUARIO" UNIQUE("EMAIL");        
ALTER TABLE "PUBLIC"."TELEFONO" ADD CONSTRAINT "PUBLIC"."FK_TELEFONO_USUARIO" FOREIGN KEY("USUARIO_ID") REFERENCES "PUBLIC"."USUARIO"("ID") NOCHECK;  

```
3. Asegúrate de tener instalado Java 21 y que este fijado como java_home y en el path.
4. Asegúrate de tener instalado Maven en tu máquina local y que esté en el PATH.
5. Ejecuta el siguiente comando Maven para compilar el proyecto:
```
mvn clean package
```
6. Ejecuta la aplicación con Maven:
```
mvn exec:java -Dexec.mainClass="com.nisum.appsample.AppsampleApplication"
```

# Instalación con DOCKER

Como alternativa se puede usar el archivo docker que esta en la raiz del proyecto
1. Isntala docker en tu computador

```
   docker build -f spring.dockerfile -t nombre-de-tu-imagen 
```
2. y ejecutalo con :

```
    docker run -p 8080:8080 nombre-de-tu-imagen
```
3.. Si desea persistir los datos siga la instruccicon del paso 2 de la instalacion con maven solo que en el container de docker.
   
# PRUEBAS
En ambos casos ya sea en local o con docker una ves levantando lo puedes probar y testar en estos dos endpoints:
```
http://localhost:8080/ping
```
Con estos pasos, la aplicación debería estar corriendo.
```
http://localhost:8080/user en POST
```
#  Apidoc con Swagger

Para ver la documentación Swagger, visita 
```
http://localhost:8080/doc/swagger-ui/index.html
```
# Pruebas con curl 

Si quieres probar la aplicación desde la consola, puedes usar el siguiente comando curl:

```bash
curl --request POST \
  --url http://localhost:8080/user \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/8.3.0' \
  --data '{
"name": "Juan Rodriguez",
"email": "juan@emcail.com",
"password": "pas34#TcfffcHgGs",
"phones": [
{
"number": "1234567",
"citycode": "1",
"contrycode": "57"
}
]
}'
```
# Pruebas con Postman

En el repo hay un archivo llamado postman.json que tiene la collection para importar y probar 