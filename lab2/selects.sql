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

-- 7 coming soon
 
 
-- 8
-- SELECT name, result, country, numGuns FROM 

-- (SELECT * from ships JOIN 
-- (SELECT * FROM outcomes where result = 'damaged')
-- ON ships.name = outcomes.ship) AS ships_result
-- JOIN classes ON classes.class = ships_result.class;

-- 9 coming soon
 

-- 10
-- SELECT AVG(price) FROM

-- (SELECT price, model FROM pc 
-- UNION
-- SELECT price, model FROM laptop) AS pc_laptop
-- JOIN
-- (SELECT model FROM product
-- WHERE maker = 'A' AND (type = 'PC' OR type = 'Laptop')) AS product_model
-- ON pc_laptop.model = product_model.model;





























