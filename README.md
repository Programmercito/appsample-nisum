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
![[Diagrama de clases](https://github.com/Programmercito/appsample-nisum/blob/main/diagrama.png?raw=true)]

Esta es una aplicación de ejemplo que incluye validaciones, capturadores de errores y utiliza H2 como base de datos con una capa de servicio en el medio.

# Instalación

Para ejecutar la aplicación, sigue estos pasos:

1. Instala H2 en tu máquina local y ejecuta el siguiente script en la base de datos de prueba: [[script](https://raw.githubusercontent.com/Programmercito/appsample-nisum/main/base.sql?token=GHSAT0AAAAAACIY6J3GNDA66XMZRQEJLKL4ZJVGQCA)]
2. Asegúrate de tener instalado Java 21.
3. Asegúrate de tener instalado Maven en tu máquina local y que esté en el PATH.
4. Ejecuta el siguiente comando Maven para compilar el proyecto:
```
mvn clean package
```
5. Ejecuta la aplicación con Maven:
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