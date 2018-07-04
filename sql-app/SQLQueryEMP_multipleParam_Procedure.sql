--to get emp by job and salary
CREATE PROCEDURE SelectByJobAndSal @JOB varchar(9), @SAL money
AS
SELECT *
FROM EMP
WHERE JOB = @JOB AND SAL > @SAL
GO