--display all employees in ascending by name
select *
from EMP
order by ENAME

--display all employee in dept 10
select *
from EMP
where DEPTNO = 10

--display all employee whose commission is null
select *
from EMP
where COMM IS NULL

--display employee name starting with s
select *
from EMP
where ENAME LIKE 'S%'

--display employee who are managers
select *
from EMP
where JOB = 'MANAGER'

--display top 2 salaried employees


--display employee name in small letters
SELECT *, LOWER(ENAME) AS LowercaseENAME
FROM EMP

--display emp details with ctc coloumn
SELECT *, (SAL+COALESCE(COMM, 0))*12 AS CTC
FROM EMP

--disp all emp in dept 10 n 20
select *
from EMP
where DEPTNO = 10 or
DEPTNO = 20

--sum of salary of all employees
select SUM(SAL) AS totalSalary
from EMP

--avg salary of all employees
select AVG(SAL) AS avgSalary
from EMP

--all emp in same dept as smith
select *
from EMP
where DEPTNO in (select DEPTNO from EMP where ENAME = 'SMITH')

--emp having same salary as blake
select *
from EMP
where SAL in (select SAL from EMP where ENAME = 'BLAKE')