def sum_of_divisors(x):
    if x == 1:
        return 1

    total = 1
    for i in range(2, int(x**0.5)+1):
        if x % i == 0:
            total += i
            if x // i != i:
                total += x // i
    return total

res = {}
n = 10000
for num in range(2, n+1):
    res[num] = sum_of_divisors(num)

total_sum = 0
for key, value in res.items():
    if value in res and key == res[value] and key != value:
        total_sum += key

print(total_sum)
