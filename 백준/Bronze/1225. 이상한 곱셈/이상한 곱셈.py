num1, num2 = input().split()
num1, num2 = list(map(int, num1)), list(map(int, num2))

print(sum(num1) * sum(num2))