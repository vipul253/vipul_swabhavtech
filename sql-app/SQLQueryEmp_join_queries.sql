--all dept which does not have an employee
SELECT DEPT.DNAME,EMP.ENAME
FROM DEPT
left outer join EMP ON EMP.DEPTNO=DEPT.DEPTNO
where EMP.DEPTNO is null

--all employee name and their boss name
select e.ename as EmpName,m.ename as MgrName
from EMP as e right outer join EMP as m
ON e.EMPNO=m.MGR

--display emp_name,dept_name emp_manager
select e.ename as EmpName,DEPT.DNAME,m.ename as MgrName
from EMP e 
join DEPT
on e.DEPTNO=DEPT.DEPTNO
left outer join EMP m
ON m.EMPNO=e.MGR