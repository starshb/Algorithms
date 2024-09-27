N, M = map(int,input().split())
result = [0]* 26
for i in range(N):
    row = (i+1) * (2*N - i) + (i + N + 1) * (N - i)
    S = input()
    for j in range(M):
        col = (j + 1) * (2 * M - j) + (j + M + 1) * (M- j)
        result[ord(S[j]) - ord('A')] += row * col
for i in result:
    print(i)