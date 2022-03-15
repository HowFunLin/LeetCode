# 181. 超过经理收入的员工
SELECT a.name AS Employee
FROM Employee AS a
       JOIN Employee AS b ON a.managerId = b.id AND a.salary > b.salary;