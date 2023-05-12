package leetcode.easy.Num1731;

class Solution {
/*
    # Write your MySQL query statement below
    SELECT e1.employee_id, e1.name, count(*) as reports_count ,round(avg(e2.age)) as average_age
    FROM Employees e1 join Employees e2 on e1.employee_id = e2.reports_to
    GROUP BY e1.employee_id
    ORDER BY e1.employee_id
 */
}
