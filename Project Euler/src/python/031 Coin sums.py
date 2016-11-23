coins = [1, 2, 5, 10, 20, 50, 100, 200]
target = 200
d = {}  # d[x][y] - number of ways to get x coins using coins with index up to y from "coins" array

for i in range(0, target + 1):
    d[i, 0] = 1

for y in range(0, target + 1):
    for x in range(1, len(coins)):
        d[y, x] = 0

        if y >= coins[x]:
            d[y, x] += d[y, x - 1]  # same as previous number, +1 gives same amount of ways
            d[y, x] += d[y - coins[x], x]  # plus number of ways without current coin
        else:
            d[y, x] = d[y, x - 1]  # using current coin will overlap total

print(d[200, 7])
