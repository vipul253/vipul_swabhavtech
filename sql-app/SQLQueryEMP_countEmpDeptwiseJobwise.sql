--if aggregate function follwed by coloumns then use group by for coloums
--display deptwise jobwise employee
select DEPTNO,JOB, COUNT(*) as numbeOfEmployees
from EMP
group by JOB,DEPTNO