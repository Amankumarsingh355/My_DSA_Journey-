# Write your MySQL query statement below
SELECT s.product_id,s.year AS first_year,s.quantity,s.price
FROM Sales s JOIN (SELECT product_id, MIN(year) AS first_year FROM Sales GROUP BY product_id
) firsts ON s.product_id = firsts.product_id AND s.year = firsts.first_year;
