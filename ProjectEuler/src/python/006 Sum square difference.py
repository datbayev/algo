def sum_1_n(n):
    return n*(1+n)//2

def solve():
    s1 = sum_1_n(100)
    s2 = 0
    for i in range(101):
        s2 += i*i
    return s1*s1 - s2


if __name__ == "__main__":
    print(solve())
