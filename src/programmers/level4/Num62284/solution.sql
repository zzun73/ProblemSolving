SELECT DISTINCT CART_ID
FROM CART_PRODUCTS
WHERE NAME = 'Yogurt'
  AND CART_ID IN (SELECT CART_ID FROM CART_PRODUCTS WHERE NAME LIKE 'Milk')
ORDER BY CART_ID ASC;