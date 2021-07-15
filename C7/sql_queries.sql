select * from products where price > 3500;

select * from products where stock = 0;

select o.status, c.username from orders o, customers c where o.customer_id = c.id and o.customer_id = 3;

select * from orders inner join customers on orders.customer_id = customers.id where customer_id = 3;