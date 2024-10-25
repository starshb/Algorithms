n = int(input())

dic = {}

MAX = 0
answer = ""

for _ in range(n):
    s = input()
    if s not in dic:
        dic[s] = 0
    dic[s] += 1


dic = sorted(dic.items())
dic = dict(dic)

for k,v in dic.items():
    if MAX < v:
        MAX = v
        answer = k


print(answer)