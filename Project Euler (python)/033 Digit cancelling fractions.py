from fractions import gcd

"""

10*n + i   n
-------- = -
10*i + d   d

"""

numerator = 1
denominator = 1

for i in range(1, 10):
    for n in range(1, 9):
        for d in range(n + 1, 10):
            if d * (10 * n + i) == n * (10 * i + d):
                numerator *= n
                denominator *= d

common = gcd(numerator, denominator)
print(denominator/common)
