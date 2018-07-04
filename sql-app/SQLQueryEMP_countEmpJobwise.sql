select JOB, COUNT(*) as NumberOfEmployees 
from emp
group by JOB

--if aggregate function folled by coloumns then use group by for coloums