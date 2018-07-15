# Write your MySQL query statement below
SELECT MAX(Salary) as SecondHighestSalary from Employee where Salary < (SELECT MAX(Salary) from Employee)
