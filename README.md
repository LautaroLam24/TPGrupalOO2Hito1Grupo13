# TP Grupal OO2 - Hito 1

Repositorio correspondiente al Trabajo Práctico Grupal de la materia **Orientación a Objetos 2**.

## Grupo

**Número de grupo:** Grupo XX

## Integrantes

| Nombre   | Apellido   | Usuario de GitHub  |
| -------- | ---------- | -----------------  |
| Lautaro  | Lamaita    | @LautaroLam24      |
| Gabriel  | Mendieta   | @Gabrielmendieta798|
| Facundo  | Simonetta  | @Facusimonetta     |
| Mateo    | Salomon    | @MateSalomon15     |

## Descripción del proyecto

El proyecto implementa un sistema utilizando **Java, Hibernate y PostgreSQL**, aplicando una arquitectura organizada en distintas capas para separar las responsabilidades de acceso a datos, lógica de negocio y pruebas.

### Estructura principal

* **datos:** contiene las clases que representan las entidades del sistema.
* **dao:** contiene las clases encargadas de realizar las operaciones de acceso a la base de datos mediante Hibernate.
* **negocio:** contiene la lógica de negocio y los ABM del sistema.
* **test:** contiene las clases utilizadas para probar las funcionalidades implementadas.

## Modelo de datos

El proyecto utiliza **Hibernate** para realizar el mapeo objeto-relacional entre las clases Java y las tablas de la base de datos.

Las relaciones entre las distintas entidades se encuentran definidas mediante los archivos de mapeo correspondientes.

## Casos de uso realizados

En cada actualización del proyecto se deberá indicar el **caso de uso implementado** y el **responsable de su realización**.

| Actualización | Caso de uso realizado                                                                                            | Responsable           |
| ------------- | ---------------------------------------------------------------------------------------------------------------- | ----------------------|
| 1             | Unidad con sus listas de platos - Estadistica de platos - Ranking de unidades - Orden descendente de markups     | Lautaro Lamaita       |
| 2             | Top 3 platos mas vendidos por festival                                                                           | Facundo Simoneta      |
| 3             | Listar los responsables que estan a cargo de mas de una unidad de venta,  mostando su tipo, unidades y superficie| Mateo Salomon         |
| 4             | Listar los Food trucks de un festival y devolver la cantidad de platos que ofrecen                               | Gabriel Mendieta      |

## Tecnologías utilizadas

* Java
* Hibernate
* PostgreSQL
* Eclipse
* Git
* GitHub
