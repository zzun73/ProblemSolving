package leetcode.easy.Num0619;

class Solution {
/*
    # Write your MySQL query statement below
    SELECT ifnull(
        (
           SELECT num
            FROM MyNumbers
            GROUP BY num
            HAVING count(*) = 1
            ORDER BY num DESC
            LIMIT 1
        ),
        null
    ) as num
 */
}
