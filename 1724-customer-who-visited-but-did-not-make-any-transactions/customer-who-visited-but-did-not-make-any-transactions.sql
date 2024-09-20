# Write your MySQL query statement below
select customer_id,count(Visits.visit_id) AS count_no_trans 
from Visits 
left join Transactions on Visits.visit_id=Transactions.visit_id
where transaction_id is null
group by customer_id

# use left join bcz we want all the customer id who visited even if there transaction is null