def is_pandigital(num_str, pan=9):
    s = ''
    for c in range(1, pan+1):
        s += str(c)

    sorted_str = ''.join(sorted(num_str))  # sort given string
    return s == sorted_str  # and compare to all numbers along from 1 to 9

products = set()

for i in range(2, 60):  # multiplicand
    start = 1234 if i < 10 else 123  # multiplier
    for j in range(start, 10000//i):
        if is_pandigital(str(i) + str(j) + str(i*j)):
            products.add(i*j)  # store products in set because we may have multiple ways to get pandigital

print(sum(products))
