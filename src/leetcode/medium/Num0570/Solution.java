package leetcode.medium.Num0570;

class Solution {
/*
    # Write your MySQL query statement below
    SELECT name
    FROM Employee
    WHERE id IN
        (SELECT managerId
        FROM Employee
        Group BY managerId
        HAVING count(*) >= 5);
 */
}
