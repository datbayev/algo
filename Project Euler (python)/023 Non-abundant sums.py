def div_sum(x):
    total = 0
    for i in range(2, int(x**0.5+1)):
        if x % i == 0:
            total += i
            if x // i != i:
                total += x // i
    return total


abundants = []
sums = set()

for n in range(1, 28124):
    cur_sum = div_sum(n)
    if cur_sum > n:
        abundants.append(n)
        for j in range(0, len(abundants)):
            sums.add(n + abundants[j])

total_sum = 0
for num in range(1, 28124):
    if num not in sums:
        print(num)
        total_sum += num

print(total_sum)
