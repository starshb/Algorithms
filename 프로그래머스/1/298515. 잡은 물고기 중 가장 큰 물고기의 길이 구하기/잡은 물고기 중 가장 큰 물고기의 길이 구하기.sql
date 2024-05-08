-- 코드를 작성해주세요
select concat(LENGTH, 'cm') as MAX_LENGTH
from FISH_INFO
order by LENGTH DESC
limit 1