N, L, D = map(int, input().split())
res = ok = 0
i = 1
while i*D <= N*(L+5) - 5:
    if L <= i*D % (L+5) <= L+4:
        res = i*D
        ok = 1
        break
    i += 1
print(res if ok else ((N*(L+5) - 5)//D + 1) * D)