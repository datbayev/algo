def solve(x):
    res = 0
    num = 1 << x
    while num > 0:
        res += num % 10
        num //= 10
    return res


n = 1000
print(int(solve(n)))
