--display deptwise jobwise sum of the salary of employees
-- whose sum of saary shoud be greater than 2000, display in order of sum of salary
select d.dname,e.job,sum(e.sal) as salary
from EMP e
join DEPT d
on e.DEPTNO=d.DEPTNO
group by d.DNAME,e.JOB
having sum(e.sal)>2000
order by sum(e.sal) desc