--all departments with employee if any
SELECT DEPT.DNAME,EMP.ENAME
FROM DEPT
left outer JOIN EMP ON EMP.DEPTNO=DEPT.DEPTNO