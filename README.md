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
| 1             | 	Ranking de unidades de venta más rentables: rango de fechas + temporada + mínimo de platos vendidos + antigüedad mínima de un cocinero del staff, ordenado por ganancia     | Lautaro Lamaita       |
| 2             | Top X platos mas vendidos por festival, Platos vendidos en X periodo con precio mayor a X                                                                           | Facundo Simonetta      |
| 3             | Dado un festival (nombre y temporada) y una superficie mínima, listar sus unidades de venta —con esa superficie o más— cuyo responsable sea Cocinero, ordenadas de mayor a menor superficie.            | Mateo Salomon         |
| 4 | Consultar platos de FoodTrucks de un festival según rango de precios y conexión eléctrica, y analizar los resultados obteniendo cantidad, precio promedio, margen promedio, plato más barato, más caro y con mayor margen. | Gabriel Mendieta |
## Tecnologías utilizadas

* Java
* Hibernate
* MySQL
* Eclipse
* Git
* GitHub

## Diagrama de clases 
<img width="1132" height="1390" alt="Diagrama de clases" src="https://github.com/user-attachments/assets/1fe453ba-222d-4ff2-8999-caa317c2c6cc" />

