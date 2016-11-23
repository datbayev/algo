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
            if x % f == 0:
                return False

            if x % (f+2) == 0:
                return False

            f += 6

    return True

def get_nth_prime(n):
    count = 0
    cur = 1
    while count < n:
        if is_prime(cur):
            count += 1
        cur += 1
    return cur - 1


if __name__ == "__main__":
    print(get_nth_prime(10001))
