--check constraint for salary to be between 500 to 15000
alter table emp
add check(sal>500 and sal<15000)

INSERT INTO EMP VALUES (7777,'abc','abc',NULL,'17-NOV-81',20000,NULL,10)