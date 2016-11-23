def is_palindrome(x):
    n = x
    rev = 0
    while x > 0:
        dig = x % 10
        rev = rev * 10 + dig
        x //= 10
    return n == rev

def get_largest_palindrome_product():
    pal = 0
    for i in range(100, 1000):
        for j in range(100, 1000):
            if i != j:
                cur = i * j
                if is_palindrome(cur) and pal < cur:
                    pal = cur
    return pal

if __name__ == "__main__":
    res = get_largest_palindrome_product()
    print(res)
