import math

def get_num_of_factors(x):
    if x == 1:
        return 1

    if x < 4:
        return 2

    res = 2  # 1 and x itself
    root = int(math.sqrt(x)) + 1
    for i in range(2, root):
        if x % i == 0:
            res += 2

    if x == root*root:
        res -= 1
    return res

def highly_divisible_triangular_number(n):
    cur_sum = 1
    pos = 2
    num_factors = get_num_of_factors(cur_sum)
    while num_factors <= n:
        cur_sum += pos
        pos += 1
        num_factors = get_num_of_factors(cur_sum)

    return cur_sum

if __name__ == "__main__":
    print(highly_divisible_triangular_number(500))
    # print(get_num_of_factors(76576500))
