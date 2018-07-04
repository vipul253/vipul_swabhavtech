delimiter //
use test//
create table trigger_test
(
    id int not null
)//
drop trigger if exists trg_trigger_test_ins //
create trigger trg_trigger_test_ins before insert on trigger_test
for each row
begin
    declare msg varchar(128);
    if new.id < 0 then
        set msg = concat('MyTriggerError: Trying to insert a negative value in trigger_test: ', cast(new.id as char));
        signal sqlstate '45000' set message_text = msg;
    end if;
end
//

delimiter ;
-- run the following as seperate statements:
insert into trigger_test values (1), (-1), (2); -- everything fails as one row is bad
select * from trigger_test;
insert into trigger_test values (1); -- succeeds as expected
insert into trigger_test values (-1); -- fails as expected
select * from trigger_test;