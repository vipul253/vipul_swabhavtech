select deptno, COUNT(*) as NumberOfEmployees 
from emp
group by deptno

--if aggregate function folled by coloumns then use group by for coloums