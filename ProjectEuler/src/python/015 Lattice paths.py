def solve(n, m):
    d = []
    for i in range(0, n):
        col = []
        for j in range(0, m):
            col.append(0)
        d.append(col)

    d[0][0] = 1
    for i in range(1, n):
        d[i][0] = 1

    for j in range(1, m):
        d[0][j] = 1

    for i in range(1, n):
        for j in range(1, m):
            d[i][j] = d[i-1][j] + d[i][j-1]

    return d[n-1][m-1]

if __name__ == "__main__":
    n = 20
    m = 20
    res = solve(n+1, m+1)
    print(res)
