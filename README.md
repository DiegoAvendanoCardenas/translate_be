# Integración de Azure Cognitive Services AI con Spring Boot y Base de Datos

Este proyecto demuestra cómo integrar los servicios cognitivos de inteligencia artificial (AI) de Azure con una aplicación Spring Boot que utiliza una base de datos PostgreSQL para almacenar las traducciones realizadas.

## Concepto

El objetivo principal de este proyecto es utilizar los servicios cognitivos de AI de Azure, específicamente el servicio Translator Text, para traducir texto de un idioma a otro en una aplicación Spring Boot. Utilizando la API del servicio Translator, la aplicación recibe texto en un idioma de origen, lo traduce al idioma de destino especificado y guarda tanto el texto original como el traducido en una base de datos PostgreSQL.

## Herramientas y Tecnologías Utilizadas

- **Azure Cognitive Services**: Se utiliza el servicio Translator Text de Azure Cognitive Services para realizar la traducción de texto.
- **Spring Boot**: Se utiliza para construir la aplicación web que maneja las solicitudes HTTP y la lógica de negocio.
- **PostgreSQL**: Se utiliza como base de datos para almacenar las traducciones realizadas.
- **Java**: El lenguaje de programación principal utilizado en el backend de la aplicación.
- **JSON**: Formato de intercambio de datos utilizado para comunicarse con la API de Azure Translator y para la respuesta de la aplicación.

## Creación e implementación del servicio cognitivo API_TRANSLATE

### Creación paso a paso:

1. **Activar el Sandbox para poder ingresar al portal de Azure**
   ![Activar Sandbox](https://github.com/vallegrande/AS221S5_T08_be/assets/112032872/fe8f9012-f138-40e2-92b7-c0e275bfa982)

2. **Nos dirigimos a los recursos de IA y escogemos el API Translate**
   ![Escoger API Translate](https://github.com/vallegrande/AS221S5_T08_be/assets/112032872/60afde87-0a89-4434-b43e-af642ede00de)

3. **Clic en Translate Text y nos saldrá una pantalla donde debemos de colocar información como el nombre, escogemos la tarifa que puede ser estándar o FREE**
   
   ![Configurar Translate Text](https://github.com/vallegrande/AS221S5_T08_be/assets/112032872/353aea53-1e53-48c3-a615-de2faa802b6b)

5. **Luego del paso anterior, damos en revisar y crear y nos saldrá otra pantalla donde haremos clic en crear**
   ![Revisar y Crear](https://github.com/vallegrande/AS221S5_T08_be/assets/112032872/7866dd6d-45d2-4aba-a309-82e2c9f3efcd)
  
6. **Se inicia la implementación del recurso**
   
   ![Implementación en curso](https://github.com/vallegrande/AS221S5_T08_be/assets/112032872/70f21f69-e761-48f6-affd-9af86c69f95b)
  
7. **Una vez que el recurso se haya completado, damos clic en IR AL RECURSO**
   ![Ir al recurso](https://github.com/vallegrande/AS221S5_T08_be/assets/112032872/df0107c1-842b-4496-9e9a-3175f76f17f8)
  
8. **Nos mostrará una pantalla con cuadros donde podremos hacer la prueba desde el portal de Azure, que sería la información general**
   ![Información general](https://github.com/vallegrande/AS221S5_T08_be/assets/112032872/a34ce62f-564c-4855-996a-3c65751c8e97)
  
9. **Luego, para ver las claves y llaves de acceso, nos dirigimos a este apartado**
   ![Claves de acceso](https://github.com/vallegrande/AS221S5_T08_be/assets/112032872/7f9f5b90-d193-488f-9a8f-9bfddb61cf2a)
  
## Dependencias de Spring Boot

Las dependencias de Spring Boot utilizadas en este proyecto incluyen:

- `spring-boot-starter-webflux`: Para desarrollar aplicaciones web reactivas con Spring WebFlux.
- `lombok`: Para reducir el código boilerplate.
- `r2dbc-postgresql`: Para interactuar con la base de datos PostgreSQL de forma reactiva.
- `reactor-test`: Para pruebas reactivas.

## Fin del Desarrollo del Proyecto

El desarrollo de este proyecto tiene como objetivo crear una aplicación que permita a los usuarios traducir texto de un idioma a otro de manera eficiente y almacenar las traducciones realizadas en una base de datos para su posterior referencia. Además, proporciona una muestra de cómo integrar los servicios cognitivos de Azure AI en una aplicación Java utilizando Spring Boot.

<div style="display:flex; justify-content: center;">
    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Microsoft_Azure_Logo.svg/1200px-Microsoft_Azure_Logo.svg.png" alt="Azure Logo" style="width: 100px; margin-right: 20px;">
    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/1200px-Spring_Framework_Logo_2018.svg.png" alt="Spring Boot Logo" style="width: 100px; margin-right: 20px;">
    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Postgresql_elephant.svg/1200px-Postgresql_elephant.svg.png" alt="PostgreSQL Logo" style="width: 100px;">
</div>
