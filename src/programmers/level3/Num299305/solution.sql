SELECT MAIN.ID, COUNT(SUB.ID) AS 'CHILD_COUNT'
FROM ECOLI_DATA MAIN
         LEFT JOIN ECOLI_DATA SUB
                   ON MAIN.ID = SUB.PARENT_ID
GROUP BY MAIN.ID
ORDER BY MAIN.ID ASC;