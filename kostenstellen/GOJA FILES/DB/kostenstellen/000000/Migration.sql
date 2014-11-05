create sequence SObj nocache;
CREATE TABLE Obj (
    id NUMBER PRIMARY KEY,
    instanceOf NUMBER NOT NULL,
    oldId NUMBER,
    IntegerValue number,
    StringValue varchar2(2000),
    DateValue Date,
    TimestampValue Timestamp,
    FractionValue varchar2(2000),
    TextValue CLOB,
    OldOrNewEntry varchar(1)
    
);

alter table Obj add CONSTRAINT FObjCls FOREIGN KEY (instanceOf) REFERENCES Cls(id);
create index OldObjectIndex on Obj (oldId);

create index IntegerValueIndex on Obj (IntegerValue);

create index StringValueIndex on Obj (StringValue);

create index DateValueIndex on Obj (DateValue);

create index TimestampValueIndex on Obj (TimestampValue);

create index FractionValueIndex on Obj (FractionValue);

alter table Association add constraint AssPK primary key (id);
alter table Association3 add constraint Ass3PK primary key (id);
CREATE SEQUENCE SLnk NOCACHE;
CREATE SEQUENCE SLnk3 NOCACHE;
CREATE TABLE Lnk (
    id NUMBER PRIMARY KEY,
    owner NUMBER NOT NULL,
    target NUMBER,
    instanceOf NUMBER NOT NULL,
    oldId NUMBER
);

CREATE TABLE Lnk3 (
    id NUMBER PRIMARY KEY,
    owner NUMBER NOT NULL,
    indxx NUMBER NOT NULL,
    target NUMBER NOT NULL,
    instanceOf NUMBER NOT NULL,
    oldId NUMBER
);

create table TextValue(
    id number primary key,
    value CLOB
);

alter table Lnk add CONSTRAINT FLnkOwner FOREIGN KEY (owner) REFERENCES Obj(id);
alter table Lnk add CONSTRAINT FLnkAssociation FOREIGN KEY (instanceOf) REFERENCES Association(id);
alter table Lnk3 add CONSTRAINT FLnk3Owner FOREIGN KEY (owner) REFERENCES Obj(id);
alter table Lnk3 add CONSTRAINT FLnk3Association3 FOREIGN KEY (instanceOf) REFERENCES Association3(id);
CREATE INDEX ILnkOwner ON Lnk (owner);
CREATE INDEX ILnkTarget ON Lnk (target);
CREATE INDEX ILnk3OwnerKey ON Lnk3 (owner, indxx);
CREATE INDEX ILnk3Target ON Lnk3 (target);
create table IntegerValue(
    id number primary key,
    value number not null
);

create table StringValue(
    id number primary key,
    value varchar2(2000)
);

create table DateValue(
    id number primary key,
    value Date
);

create table TimestampValue(
    id number primary key,
    value Timestamp
);

create table FractionValue(
    id number primary key,
    value varchar2(2000)
);

insert into IntegerValue(id, value)
select id, IntegerValue
from Obj
where IntegerValue is not null;
create unique index IntegerValueUnique on IntegerValue(value);

insert into StringValue(id, value)
select id, StringValue
from Obj
where StringValue is not null;
create unique index StringValueUnique on StringValue(value);

insert into DateValue(id, value)
select id, DateValue
from Obj
where DateValue is not null;
create unique index DateValueUnique on DateValue(value);

insert into TimestampValue(id, value)
select id, TimestampValue
from Obj
where TimestampValue is not null;
create unique index TimestampValueUnique on TimestampValue(value);

insert into FractionValue(id, value)
select id, FractionValue
from Obj
where FractionValue is not null;
create unique index FractionValueUnique on FractionValue(value);

alter table DeletedObjects drop constraint FDeletedObjectsInstanceOf;
alter table DeletedObjects rename to DeletedObjects_Old;
create table DeletedObjects(
    id number,
    instanceOf number not null,
    constraint FDeletedObjectsInstanceOf foreign key (instanceOf) references Cls(id)
);

insert into DeletedObjects(id, instanceOf)
select o.id, o.instanceOf
from Obj o, DeletedObjects_Old d
where o.oldId = d.id and o.instanceOf = d.instanceOf;

drop index DltdObjInx;
create unique index DltdObjInx on DeletedObjects (id, instanceOf);




