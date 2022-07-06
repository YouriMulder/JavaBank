INSERT INTO customer (customer_id, first_name, last_name)
VALUES (nextval('customer_id_sequence'), 'Bank', 'Capgemini');

INSERT INTO credit_account (credit_account_id, customer, balance)
VALUES (nextval('credit_account_id_sequence'), (SELECT customer_id from customer where first_name='Bank' AND last_name='Capgemini'), 1000000);