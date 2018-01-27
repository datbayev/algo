-- https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/description/
-- 586. Customer Placing the Largest Number of Orders

select `customer_number` from `orders` group by `customer_number` order by count(`customer_number`) desc limit 1
