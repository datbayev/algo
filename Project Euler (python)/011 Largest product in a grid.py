from sys import stdin

def solve():
    pass

if __name__ == "__main__":
    a = []
    line = stdin.readline()
    n, m = int(line.split(" ")[0]), int(line.split(" ")[1])

    for i in range(n):
        line = stdin.readline().split(" ")
        a.append(list(map(int, line)))

    print(a)
