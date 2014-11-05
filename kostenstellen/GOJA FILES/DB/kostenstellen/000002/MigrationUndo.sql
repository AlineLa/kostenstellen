drop table IntegerValue;
drop table FractionValue;
drop table StringValue;
drop table DateValue;
drop table TimestampValue;
drop table TextValue;
drop table Lnk;
drop table Lnk3;

alter table Association drop constraint AssPK;
alter table Association3 drop constraint Ass3PK;
drop table Obj;
drop sequence SObj;
drop sequence SLnk;
drop sequence SLnk3;

drop table DeletedObjects;

alter table DeletedObjects_Old rename to DeletedObjects;
alter table DeletedObjects add constraint FDeletedObjectsInstanceOf foreign key (instanceOf) references Cls(id);
create unique index DltdObjInx on DeletedObjects (id, instanceOf);
