import math

def is_prime(x):
    if x == 1:
        return False

    if x < 4:
        return True

    if x % 2 == 0:
        return False

    if x < 9:
        return True

    if x % 3 == 0:
        return False
    else:
        # all prime number can be written in the form of 6k+1 or 6k-1
        r = math.floor(math.sqrt(x))
        f = 5
        while f <= r:
            if x % f == 0:  # 6k-1
                return False

            if x % (f+2) == 0:  # 6k+1
                return False

            f += 6  # get next 6k

    return True


def summation_of_primes(x):
    total = 2
    if x < 3:
        return total

    cur = 3
    while cur < x:
        if is_prime(cur):
            total += cur
        cur += 2

    return total

if __name__ == "__main__":
    print(summation_of_primes(2000000))
