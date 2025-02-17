SELECT USER_ID, NICKNAME, SUM(PRICE) AS 'TOTAL_SALES'
FROM USED_GOODS_BOARD UGB
         JOIN USED_GOODS_USER UGU
              ON UGU.USER_ID = UGB.WRITER_ID
WHERE STATUS = 'DONE'
GROUP BY WRITER_ID
HAVING SUM(PRICE) >= 700000
ORDER BY SUM(PRICE) ASC;
