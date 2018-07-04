begin transaction abc
	INSERT INTO Persons VALUES( 6,'new', 'new', 21);
	select * from Persons
	rollback

select * from Persons