# Write your MySQL query statement below
SELECT E.employee_id,E.name, Count(*) as reports_count, ROUND(AVG(B.age)) AS average_age from Employees as E 
join Employees as B 
where E.employee_id = B.reports_to
group by E.employee_id
Order by E.employee_id