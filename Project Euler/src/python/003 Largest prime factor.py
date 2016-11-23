import math


def get_max_prime(x):
    i = 2
    while i < math.sqrt(x):
        while x % i == 0 and x != i:
            x //= i
        i += 1

    return x

if __name__ == "__main__":
    res = get_max_prime(600851475143)
    print(res)
