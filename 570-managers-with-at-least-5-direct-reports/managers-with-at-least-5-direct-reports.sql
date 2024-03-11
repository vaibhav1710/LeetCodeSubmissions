# Write your MySQL query statement below
/* Write your T-SQL query statement below */

select e.name from Employee as e
join Employee as b on e.id=b.managerId
group by b.managerId having count(b.managerId) >=5 