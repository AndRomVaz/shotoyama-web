# Web del Club Deportivo Shotoyama

Primera versión funcional y administrable creada con Java 21, Spring Boot 4.1, Thymeleaf, Spring Security, JPA, H2 y PostgreSQL.

## Incluye

- Inicio moderno con la paleta negra y amarilla.
- Calendario mensual con eventos gestionados desde el área privada.
- Próximos eventos en la portada.
- Botón para añadir cada evento a Google Calendar.
- Opción de incrustar un Google Calendar público.
- CRUD de noticias, eventos, actividades y horarios.
- Formulario de contacto y bandeja de mensajes.
- Diseño responsive.
- Configuración para desplegar en Render.

## Abrir en NetBeans

1. Instala JDK 21.
2. Descomprime el ZIP.
3. En NetBeans: `File > Open Project`.
4. Selecciona la carpeta que contiene `pom.xml`.
5. Espera a que Maven descargue las dependencias.
6. Ejecuta `ShotoyamaWebApplication.java`.

NetBeans reconoce automáticamente los proyectos Maven.

## Acceso local

- Web: `http://localhost:8080`
- Administración: `http://localhost:8080/admin`
- Usuario: `admin`
- Contraseña inicial: `CambiarShotoyama2026!`

Cambia la contraseña antes de publicar. En producción se controla con `ADMIN_USER` y `ADMIN_PASSWORD`.

## Base de datos

En local se utiliza H2 persistente y se crea `data/shotoyama.mv.db`. En producción, el perfil `prod` utiliza PostgreSQL.

## Google Calendar

El calendario propio ya permite crear eventos desde `/admin/eventos` y ofrece un botón para añadirlos a Google Calendar.

Para incrustar un calendario público:
1. Abre Google Calendar desde un ordenador.
2. Ve a Configuración > nombre del calendario > Integrar calendario.
3. Hazlo público.
4. Copia la URL del atributo `src` del iframe.
5. Colócala en `app.google-calendar.embed-url` o en la variable `GOOGLE_CALENDAR_EMBED_URL`.

La sincronización bidireccional real requiere Google Cloud, OAuth y credenciales. No se incluye en esta primera versión para no dejar claves privadas en el proyecto.

## Publicación y dominio

`render.yaml` prepara la aplicación para Render. Sube el proyecto a GitHub o GitLab, crea en Render un `Blueprint` y selecciona el repositorio.

Render asigna un subdominio público `onrender.com`. La configuración solicita:
`https://shotoyama-karate.onrender.com`

La dirección no está activa ni reservada hasta realizar el despliegue y podría cambiar si ese nombre ya estuviera ocupado. El Blueprint pedirá una contraseña segura para `ADMIN_PASSWORD`.

**Importante para la prueba gratuita:** la base de datos PostgreSQL gratuita de Render caduca a los 30 días. Sirve para enseñar la primera versión; para conservar los datos de forma permanente hay que mejorar el plan o conectar una base de datos PostgreSQL persistente.

Para un dominio propio hay que comprarlo o disponer de él y conectarlo desde Render. Nombres recomendados para comprobar en un registrador: `shotoyamakarate.es`, `clubshotoyama.es` y `cdshotoyama.es`.

## Antes de publicar oficialmente

- Sustituye `static/images/logo.svg`: el incluido es un escudo provisional, no el oficial.
- Revisa horarios e instalaciones; los datos iniciales son de demostración.
- Revisa dirección, teléfono y correo.
- Añade aviso legal, privacidad y política de cookies.
- Cambia la contraseña de administración.
