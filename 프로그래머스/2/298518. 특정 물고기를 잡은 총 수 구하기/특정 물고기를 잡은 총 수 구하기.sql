-- 코드를 작성해주세요
SELECT count(*) AS FISH_COUNT
FROM fish_info as f
INNER JOIN fish_name_info as n
ON f.fish_type = n.fish_type 
WHERE n.fish_name in ('BASS', 'SNAPPER');