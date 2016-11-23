filename = "names.txt"

with open(filename) as f:
    content = f.readlines()  # get all names

names = []
for name in content[0].split(","):
    names.append(name[1:-1])  # remove quotes

names = sorted(names)  # sort names

total = 0
for i, name in enumerate(names):
    cur_val = 0
    for x in name:
        cur_val += ord(x) - ord('A') + 1
    total += cur_val * (i+1)

print(total)
