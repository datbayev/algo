def factor(n):
    p = 1
    i = 1
    while i <= n:
        p *= i
        i += 1
    return p

x = 100
res = str(factor(x))
sum_factor = 0
for digit in res:
    sum_factor += int(digit)

print(sum_factor)
