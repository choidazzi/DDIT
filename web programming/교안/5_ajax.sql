select * from lprod; 
-- parameter X / result O (java - list / type - vo)

select prod_id, prod_name from prod where prod_lgu = 'lprod_gu';
-- parameter = String / result = (java - list / type - vo)

select * from prod where prod_id = 'P101000001';
-- parameter = String / result = vo