--to make emp name upper case before insert
alter TRIGGER tr_toUPPER_emp 
ON dbo.emp
INSTEAD OF INSERT
AS
	BEGIN

		Insert into emp(empno, ename, job, mgr,hiredate,sal,comm,deptno)
		Select empno, upper(ename), job, mgr,hiredate,sal,comm,deptno
		from inserted
	
	END
GO




INSERT INTO EMP VALUES (7333,'vipul','DEV',NULL,'17-MAR-81',5000,NULL,10);

select * from emp

delete from EMP
where EMPNO = 7333