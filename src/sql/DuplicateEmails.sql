# 182. 查找重复的电子邮箱
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(Email) > 1;