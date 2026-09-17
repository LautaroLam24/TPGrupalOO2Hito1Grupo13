# TP Grupal OO2 - Hito 1

Repositorio correspondiente al Trabajo Práctico Grupal de la materia **Orientación a Objetos 2**.

## Grupo

**Número de grupo:** Grupo 13

## Integrantes

| Nombre   | Apellido   | Usuario de GitHub  |
| -------- | ---------- | -----------------  |
| Lautaro  | Lamaita    | @LautaroLam24      |
| Gabriel  | Mendieta   | @Gabrielmendieta798|
| Facundo  | Simonetta  | @Facusimonetta     |
| Mateo    | Salomon    | @MateSalomon15     |

## Descripción del proyecto

El proyecto implementa un sistema utilizando **Java, Hibernate y MySQL**, aplicando una arquitectura organizada en distintas capas para separar las responsabilidades de acceso a datos, lógica de negocio y pruebas.

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
| 2             | Top X platos mas vendidos por festival                                                                           | Facundo Simonetta      |
| 3             | Listar las unidades de venta de un festival junto a su responsable, mostrando tipo (Cocinero/Cajero)             | Mateo Salomon         |
| 4             | Consultar FoodTrucks de un festival seleccionado por el usuario y mostrar la cantidad de platos que ofrece cada uno, ordenados de mayor a menor.                       | Gabriel Mendieta      |

## Tecnologías utilizadas

* Java
* Hibernate
* MySQL
* Eclipse
* Git
* GitHub

## Diagrama de clases 
<img width="1012" height="1010" alt="Diagrama de clases" src="https://github.com/user-attachments/assets/151f914c-ad9b-4c6d-b51d-496d08b4786e" />
