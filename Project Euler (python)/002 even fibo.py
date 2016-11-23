def solve():
    max_fibo = 4000000
    a = 1
    b = 1
    c = a
    total = 0
    while c <= max_fibo:
        c = a + b
        if c % 2 == 0:
            total += c
        a = b
        b = c

    return total

if __name__ == "__main__":
    res = solve()
    print(res)
