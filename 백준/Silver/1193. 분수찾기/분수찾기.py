N = int(input())

line = 0
line_end_num = 0

while line_end_num < N: # 주어진 수가 몇 번째 라인에 속해있는지 확인
    line += 1
    line_end_num += line

K = line_end_num - N # 끝번째 수와 주어진 수의 차

if line % 2 == 0: # 짝수 라인일 때
    a = line - K
    b = K + 1
else:
    a = K + 1
    b = line - K

print(str(a) + '/' + str(b)) # 정수 형태인 a, b를 문자열로 바꾸어 출력