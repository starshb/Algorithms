-- 코드를 작성해주세요
SELECT
    it.ITEM_ID,
    ii.ITEM_NAME,
    ii.RARITY
FROM
    ITEM_INFO ii
    INNER JOIN ITEM_TREE it
        ON ii.ITEM_ID=it.ITEM_ID
WHERE 1=1
    AND it.PARENT_ITEM_ID IN (SELECT ITEM_ID
                              FROM ITEM_INFO
                              WHERE RARITY='RARE')
ORDER BY
    it.ITEM_ID DESC