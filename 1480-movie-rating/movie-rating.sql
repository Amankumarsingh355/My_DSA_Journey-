(SELECT u.name AS results FROM Users u JOIN (SELECT user_id, COUNT(*) AS cnt FROM MovieRating GROUP BY user_id) uc ON u.user_id = uc.user_id WHERE uc.cnt = (SELECT MAX(cnt) FROM (SELECT user_id, COUNT(*) AS cnt FROM MovieRating GROUP BY user_id) AS tmp1) 
ORDER BY u.name LIMIT 1)
UNION ALL (SELECT m.title AS results FROM Movies m
JOIN (SELECT movie_id, AVG(rating) AS avg_r FROM MovieRating WHERE created_at BETWEEN '2020-02-01' AND '2020-02-29' GROUP BY movie_id) ma ON m.movie_id = ma.movie_id
WHERE ma.avg_r = (SELECT MAX(avg_r) FROM (SELECT movie_id, AVG(rating) AS avg_r FROM MovieRating WHERE created_at BETWEEN '2020-02-01' AND '2020-02-29' GROUP BY movie_id) AS tmp2)ORDER BY m.title LIMIT 1);