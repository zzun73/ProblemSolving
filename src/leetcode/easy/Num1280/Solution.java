package leetcode.easy.Num1280;

class Solution {
/*
    # Write your MySQL query statement below
    SELECT st.student_id, st.student_name, su.subject_name, count(ex.subject_name) as attended_exams
    from Students st CROSS JOIN Subjects su LEFT JOIN examinations ex
    ON st.student_id = ex.student_id AND su.subject_name = ex.subject_name
    GROUP BY st.student_id, su.subject_name
    ORDER BY st.student_id, su.subject_name
 */
}
