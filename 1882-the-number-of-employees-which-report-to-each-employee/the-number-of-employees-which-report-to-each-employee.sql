# Write your MySQL query statement below
SELECT m.employee_id,m.name,COUNT(r.employee_id) AS reports_count,ROUND(AVG(r.age)) AS average_age FROM Employees m JOIN Employees r ON r.reports_to = m.employee_id
GROUP BY m.employee_id, m.name ORDER BY m.employee_id;