def is_prime(x):
    if x < 2:
        return False

    j = 2
    while j*j <= x:
        if x % j == 0:
            return False
        j += 1
    return True


def is_circular(x):
    arr = list(str(x))

    if len(arr) == 1:  # numbers under 10
        return is_prime(x)

    if not is_prime(x):
        return False

    result = True
    for k in range(1, len(arr)):
        arr.append(arr[0])
        arr.pop(0)
        num = int(''.join(arr))
        if not is_prime(num):
            result = False
            break

    return result


count = 0
n = 1000000
for i in range(2, n):
    if is_circular(i):
        count += 1

print(count)
