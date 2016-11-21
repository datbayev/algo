# Coin Change problem
## Problem description
Given a value N, if we want to make change for N cents, and we have infinite supply of each of C = {c1, c2, ..., cm}
valued coins, how many ways can we make the change? The order of coins doesn’t matter.

## Dynamic programming solution
Let d[x] be the answer for some 'x'. We should next formula: d[x] = sum of all d[x - c[i]]
Overall answer will be d[n]
