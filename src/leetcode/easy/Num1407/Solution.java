package leetcode.easy.Num1407;

class Solution {
/*
    # Write your MySQL query statement below
    SELECT U.name, ifnull(sum(R.distance),0) AS travelled_distance
    FROM Users U LEFT JOIN Rides R ON U.id = R.user_id
    GROUP BY U.id
    ORDER BY sum(R.distance) DESC, U.name ASC;
 */
}
