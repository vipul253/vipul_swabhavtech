--function to getcurrent date in format yyyymmdd

ALTER FUNCTION getCurrentDate()
RETURNS nvarchar(8)
AS 
BEGIN
	 RETURN convert(nvarchar(8), getdate(), 112)
END

PRINT dbo.getCurrentDate()

