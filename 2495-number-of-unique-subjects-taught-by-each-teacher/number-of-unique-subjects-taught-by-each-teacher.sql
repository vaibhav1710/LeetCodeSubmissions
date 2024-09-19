# Write your MySQL query statement below
SELECT teacher_Id, COUNT(DISTINCT subject_id) AS cnt
FROM Teacher
GROUP BY teacher_Id;

