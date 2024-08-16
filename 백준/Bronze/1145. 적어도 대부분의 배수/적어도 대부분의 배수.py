a = list(map(int, input().split()))
min = min(a)   # 최솟값을 찾은 뒤
while True:
    cnt = 0
    for i in a:
        if min % i == 0:   # 배수를 찾는 반복문
            cnt += 1
    if cnt > 2:   # 3개를 찾았다면 break
        break
    min += 1   # 3개를 찾을때까지 값을 올려준다.
print(min)