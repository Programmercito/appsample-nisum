# Appsample

## Stack
- Base de datos: H2
- Java 21
- Spring Boot
- Token: JWT de Auth0
- Generador de contraseñas: Jbcrypt
- Maven
- Pruebas Unitarias Spring boot test (junit)

## Diagrama de clases
![Diagrama de clases](https://github.com/Programmercito/appsample-nisum/blob/main/diagrama.png?raw=true)

Esta es una aplicación de ejemplo que incluye validaciones, capturadores de errores y utiliza H2 como base de datos con una capa de servicio en el medio.

# Instalación

Para ejecutar la aplicación, sigue estos pasos:

1. Instala H2 en tu máquina local y ejecuta el siguiente script en la base de datos de prueba (test en h2): 
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
2. Asegúrate de tener instalado Java 21 y que este fijado como java_home y en el path.
3. Asegúrate de tener instalado Maven en tu máquina local y que esté en el PATH.
4. Ejecuta el siguiente comando Maven para compilar el proyecto:
```
mvn clean package
```
1. Ejecuta la aplicación con Maven:
```
mvn exec:java -Dexec.mainClass="com.nisum.appsample.AppsampleApplication"
```

Con estos pasos, la aplicación debería estar corriendo.

Para ver la documentación Swagger, visita [http://localhost:8080/doc/swagger-ui/index.html].

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
