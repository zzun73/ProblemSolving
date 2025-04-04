SELECT FI.ID, FISH_NAME, LENGTH
FROM FISH_INFO FI
         JOIN FISH_NAME_INFO FNI
              ON FI.FISH_TYPE = FNI.FISH_TYPE
WHERE FI.LENGTH = (SELECT MAX(LENGTH)
                   FROM FISH_INFO
                   WHERE FISH_TYPE = FI.FISH_TYPE)
ORDER BY FI.ID ASC;