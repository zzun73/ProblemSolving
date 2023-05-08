package leetcode.medium.Num0608;

class Solution {
/*
    # Write your MySQL query statement below
    SELECT id,
      case
        when p_id is null then 'Root'
        when id in (select distinct p_id from Tree) then 'Inner'
        else 'Leaf'
        end as type
    FROM Tree;
 */
}
