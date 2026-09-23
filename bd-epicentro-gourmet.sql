create database bd_epicentro_gourmet;

USE bd_epicentro_gourmet;

-- =========================================================
-- LIMPIAR DATOS DE PRUEBA ANTERIORES
-- =========================================================

SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE item_pedido;
TRUNCATE TABLE pedido;
TRUNCATE TABLE plato;
TRUNCATE TABLE unidad_personal;
TRUNCATE TABLE food_truck;
TRUNCATE TABLE puesto_desarmable;
TRUNCATE TABLE unidad_de_venta;
TRUNCATE TABLE cajero;
TRUNCATE TABLE cocinero;
TRUNCATE TABLE personal;
TRUNCATE TABLE festival;

SET FOREIGN_KEY_CHECKS = 1;


-- =========================================================
-- 1. FESTIVALES
-- =========================================================

INSERT INTO festival
(id, nombre, temporada, fecha_inicio, fecha_fin,
 costo_por_superficie, costo_por_montaje,
 plus_electricidad, sueldo_base)
VALUES
(1, 'Festival Sabores del Sur', 'PRIMAVERA', '2026-09-01', '2026-09-10', 1500, 25000, 8000, 500000),
(2, 'Buenos Aires Gourmet',      'PRIMAVERA', '2026-09-15', '2026-09-20', 1800, 28000, 9000, 510000),
(3, 'Fiesta de la Cocina',       'VERANO',    '2026-12-05', '2026-12-12', 2000, 30000, 9500, 520000),
(4, 'Sabores Argentinos',        'VERANO',    '2027-01-10', '2027-01-16', 2200, 32000, 10000, 530000),
(5, 'Festival del Asado',        'OTONIO',    '2027-04-01', '2027-04-05', 2500, 35000, 11000, 540000),
(6, 'Festival Urbano',           'OTONIO',    '2027-04-15', '2027-04-20', 1900, 29000, 9000, 500000),
(7, 'Feria de Sabores',          'INVIERNO',  '2027-07-01', '2027-07-07', 1700, 26000, 8500, 510000),
(8, 'Cocina Federal',            'INVIERNO',  '2027-07-20', '2027-07-25', 2100, 31000, 10000, 520000),
(9, 'Gastro Fest',               'PRIMAVERA', '2027-09-10', '2027-09-15', 2300, 33000, 10500, 530000),
(10,'Sabores de Argentina',      'VERANO',    '2027-12-01', '2027-12-08', 2400, 34000, 11000, 540000);


-- =========================================================
-- 2. PERSONAL
--    10 personas: 5 cajeros + 5 cocineros
-- =========================================================

INSERT INTO personal
(id, nombre, apellido, dni, fecha_nacimiento, fecha_ingreso, sueldo_base)
VALUES
(1, 'Juan',     'Perez',     '30111222', '1990-05-10', '2024-01-10', 520000),
(2, 'Maria',    'Gomez',     '32222333', '1992-08-21', '2024-02-15', 530000),
(3, 'Lucas',    'Fernandez', '33444555', '1994-03-12', '2024-03-01', 525000),
(4, 'Sofia',    'Martinez',  '34555666', '1995-06-25', '2024-03-20', 535000),
(5, 'Tomas',    'Rodriguez', '35666777', '1996-11-02', '2024-04-10', 540000),
(6, 'Carla',    'Lopez',     '36777888', '1997-01-14', '2024-04-15', 550000),
(7, 'Mateo',    'Diaz',      '37888999', '1998-02-17', '2024-05-01', 555000),
(8, 'Julieta',  'Romero',    '38999000', '1999-07-08', '2024-05-20', 560000),
(9, 'Nicolas',  'Torres',    '39100111', '1993-09-30', '2024-06-01', 565000),
(10,'Camila',   'Ruiz',      '40211222', '2000-12-12', '2024-06-15', 570000);


-- Cajeros
INSERT INTO cajero (id, turno)
VALUES
(1, 'MANANA'),
(2, 'NOCHE'),
(3, 'MANANA'),
(4, 'NOCHE'),
(5, 'MANANA');


-- Cocineros
INSERT INTO cocinero
(id, especialidad, plus_por_categoria)
VALUES
(6, 'Parrilla',     80000),
(7, 'Pastas',       70000),
(8, 'Reposteria',   65000),
(9, 'Vegetariano',  60000),
(10,'Comida Rapida',75000);


-- =========================================================
-- 3. UNIDADES DE VENTA
-- =========================================================

INSERT INTO unidad_de_venta
(id, nombre_comercial, codigo, superficie_m2, festival_id, responsable_id)
VALUES
(1,  'Ruta Burger',       'FT00000001', 25.00, 1, 1),
(2,  'Pasta Sobre Ruedas','FT00000002', 28.00, 1, 1),
(3,  'Dulce Esquina',     'PD00000003', 18.00, 1, 2),
(4,  'Parrilla Movil',    'FT00000004', 32.00, 1, 2),

(5,  'Sabores del Norte', 'PD00000005', 22.00, 2, 1),
(6,  'Cafe Rodante',      'FT00000006', 20.00, 2, 3),

(7,  'Veggie Point',      'PD00000007', 24.00, 3, 4),
(8,  'Pizza Truck',       'FT00000008', 30.00, 3, 5),

(9,  'Wok Express',       'PD00000009', 21.00, 4, 6),
(10, 'Helado Bus',        'FT00000010', 19.00, 5, 7);


-- =========================================================
-- 4. SUBCLASE FOODTRUCK
-- =========================================================

INSERT INTO food_truck
(id, patente, requiere_conexion_electrica)
VALUES
(1,  'AA111AA', 1),
(2,  'AB222BB', 1),
(4,  'AC333CC', 1),
(6,  'AD444DD', 1),
(8,  'AE555EE', 1),
(10, 'AF666FF', 1);


-- =========================================================
-- 5. SUBCLASE PUESTO DESARMABLE
-- =========================================================

INSERT INTO puesto_desarmable
(id, cantidad_carpas, tiempo_montaje_minutos)
VALUES
(3,  2, 45),
(5,  3, 60),
(7,  2, 50),
(9,  4, 75);


-- =========================================================
-- 6. STAFF DE LAS UNIDADES (N:M)
-- =========================================================

INSERT INTO unidad_personal
(unidad_id, personal_id)
VALUES
(1,1),(1,6),(1,10),
(2,1),(2,7),(2,3),
(3,2),(3,8),
(4,2),(4,6),(4,5),
(5,1),(5,7),
(6,3),(6,8),
(7,4),(7,9),
(8,5),(8,10),
(9,6),(9,9),
(10,7),(10,8);


-- =========================================================
-- 7. PLATOS
--    Unidad 1 tiene varios para que TestLautaro sea interesante
-- =========================================================

INSERT INTO plato
(id, nombre, precio_venta, costo_produccion, unidad_id)
VALUES

-- Unidad 1 - Ruta Burger
(1,  'Hamburguesa Completa', 12000, 5000, 1),
(2,  'Papas Fritas',          5500, 1800, 1),
(3,  'Bondiola',             13500, 6000, 1),
(4,  'Veggie Burger',        11000, 4500, 1),
(5,  'Choripan',              8000, 3000, 1),

-- Unidad 2
(6,  'Ravioles',             15000, 6500, 2),
(7,  'Lasagna',              16500, 7200, 2),
(8,  'Nioquis',              13000, 5200, 2),

-- Unidad 3
(9,  'Brownie',               6500, 2200, 3),
(10, 'Chocotorta',            7000, 2600, 3),

-- Unidad 4
(11, 'Asado',                18000, 8500, 4),
(12, 'Vacio',                17500, 8000, 4),

-- Otras unidades
(13, 'Empanadas Nortenas',    9000, 3500, 5),
(14, 'Cafe con Leche',        4500, 1200, 6),
(15, 'Bowl Veggie',          12500, 4800, 7),
(16, 'Pizza Muzzarella',     12000, 4200, 8),
(17, 'Wok de Pollo',         14000, 5500, 9),
(18, 'Copa Helada',           7500, 2600, 10);


-- =========================================================
-- 8. PEDIDOS
-- =========================================================

INSERT INTO pedido
(id, fecha_transaccion, unidad_id)
VALUES
(1,  '2026-09-01', 1),
(2,  '2026-09-01', 1),
(3,  '2026-09-02', 1),
(4,  '2026-09-03', 1),

(5,  '2026-09-01', 2),
(6,  '2026-09-02', 2),
(7,  '2026-09-03', 2),

(8,  '2026-09-02', 3),
(9,  '2026-09-03', 4),

(10, '2026-09-16', 5),
(11, '2026-12-06', 8),
(12, '2027-04-02', 10);


-- =========================================================
-- 9. ITEM PEDIDO
-- =========================================================

INSERT INTO item_pedido
(id, nombre, cantidad, pedido_id, plato_id)
VALUES

-- Pedido 1 - Ruta Burger
(1,  'Hamburguesa Completa', 3, 1, 1),
(2,  'Papas Fritas',         2, 1, 2),
(3,  'Choripan',             1, 1, 5),

-- Pedido 2
(4,  'Hamburguesa Completa', 4, 2, 1),
(5,  'Papas Fritas',         4, 2, 2),
(6,  'Veggie Burger',        1, 2, 4),

-- Pedido 3
(7,  'Bondiola',             3, 3, 3),
(8,  'Hamburguesa Completa', 2, 3, 1),
(9,  'Papas Fritas',         1, 3, 2),

-- Pedido 4
(10, 'Hamburguesa Completa', 5, 4, 1),
(11, 'Choripan',             3, 4, 5),
(12, 'Papas Fritas',         2, 4, 2),

-- Unidad 2
(13, 'Ravioles',             2, 5, 6),
(14, 'Lasagna',              1, 5, 7),

(15, 'Ravioles',             3, 6, 6),
(16, 'Nioquis',              2, 6, 8),

(17, 'Lasagna',              4, 7, 7),
(18, 'Ravioles',             1, 7, 6),

-- Unidad 3
(19, 'Brownie',              5, 8, 9),
(20, 'Chocotorta',           6, 8, 10),

-- Unidad 4
(21, 'Asado',                7, 9, 11),
(22, 'Vacio',                4, 9, 12),

-- Otros festivales
(23, 'Empanadas Nortenas',   4, 10, 13),

(24, 'Pizza Muzzarella',     5, 11, 16),

(25, 'Copa Helada',          6, 12, 18);