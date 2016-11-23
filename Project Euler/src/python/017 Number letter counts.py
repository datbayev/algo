single = ['', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine', 'ten']

# first element is empty because array is 0-indexed
teen = ['', 'eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen']
tens = ['', 'ten', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']


def count_letters(num):
    if num <= 10:
        return len(single[num])
    elif 10 < num < 20:
        return len(teen[num % 10])
    elif num < 100:
        ten = num // 10
        unit = num % 10
        return len(tens[ten] + single[unit])
    elif 99 < num < 1000:
        hundreds = num // 100
        ten = num % 100
        cur_res = len('{0}hundred'.format(single[hundreds]))
        if ten > 0:
            cur_res += 3 + count_letters(ten)  # 3 means "and"
        return cur_res
    else:  # one thousand
        return 11

res = 0
n = 1000
for i in range(1, n+1):
    res += count_letters(i)
print(res)
