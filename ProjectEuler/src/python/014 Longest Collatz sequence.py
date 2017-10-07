ans = {
    1: 1,
    2: 2,
    4: 3,
    8: 4,
    16: 5,
    5: 6,
    10: 7,
    20: 8,
    40: 9,
    13: 10
}


def rec(num):
    if ans.get(num) is None:  # need to calculate for current number
        cur_res = rec(num // 2) if num % 2 == 0 else rec(3*num + 1)
        ans[num] = cur_res + 1
        return cur_res + 1
    else:
        return ans.get(num)  # already calculated


def solve():
    limit = 1000000  # limit index
    cur_ind = 3
    ind = 13  # max index
    elems = 10

    while cur_ind < limit:
        cur_res = rec(cur_ind)
        if elems < cur_res:
            elems = cur_res
            ind = cur_ind
        cur_ind += 1

    return ind


if __name__ == "__main__":
    res = solve()
    print(res)
