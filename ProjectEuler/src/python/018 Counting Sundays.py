from datetime import date
from datetime import timedelta

count = 0
cur_date = date(1901, 1, 1)
end = date(2000, 12, 31)

while cur_date <= end:
    if cur_date.weekday() == 6:  # if it's Sunday
        count += 1
    month_ahead = cur_date + timedelta(days=32)  # go 32 days ahead from current month's 1st day
    cur_date = month_ahead.replace(day=1)  # set day as 1st

print(count)
