USE Labor_SQL;

-- 1
-- SELECT * FROM outcome
-- WHERE point = 2
-- ORDER BY `out`; 

-- 2
-- SELECT * FROM ships
-- WHERE class like '%o';

-- 3
-- SELECT DISTINCT maker FROM product
-- JOIN pc ON product.model = pc.model
-- WHERE type = 'pc' AND pc.speed <= 500;

-- 4
-- SELECT DISTINCT maker FROM product 
-- WHERE `type` = 'PC' and maker = ANY(
-- SELECT maker FROM product 
-- WHERE `type` = 'Laptop');

-- 5
-- SELECT DISTINCT maker FROM product 
-- WHERE `type` = 'PC' and maker = ANY(
-- SELECT maker FROM product JOIN laptop ON product.model = laptop.model
-- WHERE `type` = 'Laptop' AND laptop.speed <= 500);

-- 6
-- SELECT DATE_FORMAT(date, '%Y.%m.%d') as date FROM battles;

-- 7 
-- SELECT country, battle, count(country) AS num_of_ships FROM 
-- ships JOIN classes ON ships.class = classes.class
-- JOIN outcomes ON ships.NAME = outcomes.ship
-- GROUP BY country, battle
-- HAVING num_of_ships >= 2;
 
 
-- 8
-- SELECT name, result, country, numGuns FROM 
-- (SELECT * from ships JOIN 
-- (SELECT * FROM outcomes where result = 'damaged')
-- ON ships.name = outcomes.ship) AS ships_result
-- JOIN classes ON classes.class = ships_result.class;

-- 9 
-- SELECT DISTINCT product.maker, 
-- CASE 
-- 	WHEN count IS NOT NULL THEN concat('Yes (', count, ')')
-- 	ELSE 'no'
-- END AS printer 
-- FROM product LEFT JOIN
-- (SELECT DISTINCT maker, count(maker) AS count FROM 
-- product WHERE TYPE = 'Printer' GROUP BY maker) AS tabl
-- ON product.maker = tabl.maker

-- 10
-- SELECT AVG(price) FROM
-- (SELECT price, model FROM pc 
-- UNION
-- SELECT price, model FROM laptop) AS pc_laptop
-- JOIN
-- (SELECT model FROM product
-- WHERE maker = 'A' AND (type = 'PC' OR type = 'Laptop')) AS product_model
-- ON pc_laptop.model = product_model.model;
































