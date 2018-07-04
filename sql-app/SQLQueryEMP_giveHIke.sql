--giveHike procedure
Alter PROCEDURE giveHike @empno int, @hike float
as
	if exists (select * from EMP where EMPNO=@empno)
	begin
		update emp
		set sal = sal+sal*@hike
		where empno = @empno
	end
	else
	begin
		Print 'invalid id'  
	end
GO

select * from emp
exec giveHike 73369,1

update emp
set sal = 800
where empno = 7369