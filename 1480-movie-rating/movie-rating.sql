# Write your MySQL query statement below

(SELECT Users.name AS results
FROM Users
LEFT JOIN MovieRating ON Users.user_id = MovieRating.user_id
GROUP BY Users.user_id
ORDER BY COUNT(Users.user_id) DESC, Users.name ASC
LIMIT 1)
UNION ALL
(SELECT movies.title as results from 
movies LEFT JOIN MovieRating on movies.movie_id = MovieRating.movie_id 
WHERE CREATED_AT BETWEEN '2020-02-01' AND '2020-02-29'
Group By MovieRating.movie_id 
Order by Avg(MovieRating.rating) DESC, movies.title ASC
LIMIT 1)