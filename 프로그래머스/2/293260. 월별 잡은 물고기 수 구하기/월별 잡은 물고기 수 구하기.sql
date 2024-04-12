-- 코드를 작성해주세요
select 
    count(date_format(TIME, '%c')) as FISH_COUNT,
    cast(date_format(TIME, '%c') as unsigned) as MONTH
from FISH_INFO
group by 2
order by 2