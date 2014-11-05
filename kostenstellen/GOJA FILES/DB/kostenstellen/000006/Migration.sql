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

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from CmmndExctr;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from Subj;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from AbsKstnArt;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from Trnsktn;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from ErzgTrnsktnCMD;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from FndKntCMD;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from TrnsFcdTrnsktns;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from Srvr;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from Trnsfr;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from ErzgKntCMD;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from BchKntCMD;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from ArtnMngr;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from CmmndCrdntr;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from CmmnDt;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from Knt;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from KntFcd;

insert into Obj (id,instanceOf,oldId)
select SObj.nextval, Cls, id
from TrnsFcd;

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

insert into Lnk(id, owner, target, instanceOf, oldId)
select SLnk.nextval, objOwner.id, objTarget.id, 10003, relation.id
from CmmndExctrCommands relation, CmmndExctr ownerTable, Obj objTarget, Obj objOwner
where relation.commands = objTarget.oldId
and   relation.Cls = objTarget.instanceOf
and   relation.frm = objOwner.oldId
and   relation.frm = ownerTable.id
and   ownerTable.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf, oldId)
select SLnk.nextval, objOwner.id, objTarget.id, 10004, relation.id
from SubjObs relation, Subj ownerTable, Obj objTarget, Obj objOwner
where relation.obs = objTarget.oldId
and   relation.Cls = objTarget.instanceOf
and   relation.frm = objOwner.oldId
and   relation.frm = ownerTable.id
and   ownerTable.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10005
from Subj t, Obj objTarget, Obj objOwner
where t.SubjThis is not null and t.SubjThis = objTarget.oldId and t.SubjThisCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10006
from AbsKstnArt t, Obj objTarget, Obj objOwner
where t.AbsKstnArtSbSrvc is not null and t.AbsKstnArtSbSrvc = objTarget.oldId and t.AbsKstnArtSbSrvcCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10007
from AbsKstnArt t, Obj objTarget, Obj objOwner
where t.AbsKstnArtThis is not null and t.AbsKstnArtThis = objTarget.oldId and t.AbsKstnArtThisCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10055
from AbsKstnArt t, Obj objTarget, Obj objOwner
where t.KnkrKstnArtSpzllrAls is not null and t.KnkrKstnArtSpzllrAls = objTarget.oldId and t.KnkrKstnArtSpzllrAlsCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf, oldId)
select SLnk.nextval, objOwner.id, objTarget.id, 10008, relation.id
from TrnsktnTrnsfrs relation, Trnsktn ownerTable, Obj objTarget, Obj objOwner
where relation.trnsfrs = objTarget.oldId
and   relation.Cls = objTarget.instanceOf
and   relation.frm = objOwner.oldId
and   relation.frm = ownerTable.id
and   ownerTable.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10009
from Trnsktn t, Obj objTarget, Obj objOwner
where t.TrnsktnSbSrvc is not null and t.TrnsktnSbSrvc = objTarget.oldId and t.TrnsktnSbSrvcCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10010
from Trnsktn t, Obj objTarget, Obj objOwner
where t.TrnsktnThis is not null and t.TrnsktnThis = objTarget.oldId and t.TrnsktnThisCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Obj(id, instanceOf, StringValue, OldOrNewEntry)
select SObj.nextval, 2, ErzgTrnsktnCMDKntID, 'n'
from (select distinct ErzgTrnsktnCMDKntID from ErzgTrnsktnCMD)
where ErzgTrnsktnCMDKntID not in (select StringValue from Obj where OldOrNewEntry = 'o' and StringValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10011
from ErzgTrnsktnCMD t, Obj objTarget, Obj objOwner
where t.ErzgTrnsktnCMDKntID is not null and t.ErzgTrnsktnCMDKntID = objTarget.StringValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10012
from ErzgTrnsktnCMD t, Obj objTarget, Obj objOwner
where t.ErzgTrnsktnCMDInvoker is not null and t.ErzgTrnsktnCMDInvoker = objTarget.oldId and t.ErzgTrnsktnCMDInvokerCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10013
from ErzgTrnsktnCMD t, Obj objTarget, Obj objOwner
where t.ErzgTrnsktnCMDCReceiver is not null and t.ErzgTrnsktnCMDCReceiver = objTarget.oldId and t.ErzgTrnsktnCMDCReceiverCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10014
from ErzgTrnsktnCMD t, Obj objTarget, Obj objOwner
where t.ErzgTrnsktnCMDMyCmmnDt is not null and t.ErzgTrnsktnCMDMyCmmnDt = objTarget.oldId and t.ErzgTrnsktnCMDMyCmmnDtCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Obj(id, instanceOf, StringValue, OldOrNewEntry)
select SObj.nextval, 2, FndKntCMDKntID, 'n'
from (select distinct FndKntCMDKntID from FndKntCMD)
where FndKntCMDKntID not in (select StringValue from Obj where OldOrNewEntry = 'o' and StringValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10015
from FndKntCMD t, Obj objTarget, Obj objOwner
where t.FndKntCMDKntID is not null and t.FndKntCMDKntID = objTarget.StringValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10016
from FndKntCMD t, Obj objTarget, Obj objOwner
where t.FndKntCMDInvoker is not null and t.FndKntCMDInvoker = objTarget.oldId and t.FndKntCMDInvokerCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10017
from FndKntCMD t, Obj objTarget, Obj objOwner
where t.FndKntCMDCReceiver is not null and t.FndKntCMDCReceiver = objTarget.oldId and t.FndKntCMDCReceiverCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10018
from FndKntCMD t, Obj objTarget, Obj objOwner
where t.FndKntCMDMyCmmnDt is not null and t.FndKntCMDMyCmmnDt = objTarget.oldId and t.FndKntCMDMyCmmnDtCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10020
from TrnsFcdTrnsktns t, Obj objTarget, Obj objOwner
where t.TrnsFcdTrnsktnsMstr is not null and t.TrnsFcdTrnsktnsMstr = objTarget.oldId and t.TrnsFcdTrnsktnsMstrCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf, oldId)
select SLnk.nextval, objOwner.id, objTarget.id, 10021, relation.id
from TrnsFcdTrnsktnsObs relation, TrnsFcdTrnsktns ownerTable, Obj objTarget, Obj objOwner
where relation.obs = objTarget.oldId
and   relation.Cls = objTarget.instanceOf
and   relation.frm = objOwner.oldId
and   relation.frm = ownerTable.id
and   ownerTable.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10022
from TrnsFcdTrnsktns t, Obj objTarget, Obj objOwner
where t.TrnsFcdTrnsktnsThis is not null and t.TrnsFcdTrnsktnsThis = objTarget.oldId and t.TrnsFcdTrnsktnsThisCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10023
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrArtn is not null and t.SrvrArtn = objTarget.oldId and t.SrvrArtnCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10024
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrMngr is not null and t.SrvrMngr = objTarget.oldId and t.SrvrMngrCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10025
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrTrnsktnMngr is not null and t.SrvrTrnsktnMngr = objTarget.oldId and t.SrvrTrnsktnMngrCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10026
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrSbSrvc is not null and t.SrvrSbSrvc = objTarget.oldId and t.SrvrSbSrvcCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10027
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrThis is not null and t.SrvrThis = objTarget.oldId and t.SrvrThisCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Obj(id, instanceOf, StringValue, OldOrNewEntry)
select SObj.nextval, 2, SrvrPassword, 'n'
from (select distinct SrvrPassword from Srvr)
where SrvrPassword not in (select StringValue from Obj where OldOrNewEntry = 'o' and StringValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10029
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrPassword is not null and t.SrvrPassword = objTarget.StringValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, StringValue, OldOrNewEntry)
select SObj.nextval, 2, SrvrUser, 'n'
from (select distinct SrvrUser from Srvr)
where SrvrUser not in (select StringValue from Obj where OldOrNewEntry = 'o' and StringValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10030
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrUser is not null and t.SrvrUser = objTarget.StringValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, IntegerValue, OldOrNewEntry)
select SObj.nextval, 1, SrvrHackCount, 'n'
from (select distinct SrvrHackCount from Srvr)
where SrvrHackCount not in (select IntegerValue from Obj where OldOrNewEntry = 'o' and IntegerValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10031
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrHackCount is not null and t.SrvrHackCount = objTarget.IntegerValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, TimestampValue, OldOrNewEntry)
select SObj.nextval, 5, SrvrHackDelay, 'n'
from (select distinct SrvrHackDelay from Srvr)
where SrvrHackDelay not in (select TimestampValue from Obj where OldOrNewEntry = 'o' and TimestampValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10032
from Srvr t, Obj objTarget, Obj objOwner
where t.SrvrHackDelay is not null and t.SrvrHackDelay = objTarget.TimestampValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10033
from Trnsfr t, Obj objTarget, Obj objOwner
where t.TrnsfrVnKnt is not null and t.TrnsfrVnKnt = objTarget.oldId and t.TrnsfrVnKntCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10034
from Trnsfr t, Obj objTarget, Obj objOwner
where t.TrnsfrZKnt is not null and t.TrnsfrZKnt = objTarget.oldId and t.TrnsfrZKntCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Obj(id, instanceOf, IntegerValue, OldOrNewEntry)
select SObj.nextval, 1, TrnsfrSmm, 'n'
from (select distinct TrnsfrSmm from Trnsfr)
where TrnsfrSmm not in (select IntegerValue from Obj where OldOrNewEntry = 'o' and IntegerValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10035
from Trnsfr t, Obj objTarget, Obj objOwner
where t.TrnsfrSmm is not null and t.TrnsfrSmm = objTarget.IntegerValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, StringValue, OldOrNewEntry)
select SObj.nextval, 2, TrnsfrKntID, 'n'
from (select distinct TrnsfrKntID from Trnsfr)
where TrnsfrKntID not in (select StringValue from Obj where OldOrNewEntry = 'o' and StringValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10036
from Trnsfr t, Obj objTarget, Obj objOwner
where t.TrnsfrKntID is not null and t.TrnsfrKntID = objTarget.StringValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10037
from Trnsfr t, Obj objTarget, Obj objOwner
where t.TrnsfrSbSrvc is not null and t.TrnsfrSbSrvc = objTarget.oldId and t.TrnsfrSbSrvcCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10038
from Trnsfr t, Obj objTarget, Obj objOwner
where t.TrnsfrThis is not null and t.TrnsfrThis = objTarget.oldId and t.TrnsfrThisCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Obj(id, instanceOf, StringValue, OldOrNewEntry)
select SObj.nextval, 2, ErzgKntCMDKntID, 'n'
from (select distinct ErzgKntCMDKntID from ErzgKntCMD)
where ErzgKntCMDKntID not in (select StringValue from Obj where OldOrNewEntry = 'o' and StringValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10039
from ErzgKntCMD t, Obj objTarget, Obj objOwner
where t.ErzgKntCMDKntID is not null and t.ErzgKntCMDKntID = objTarget.StringValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, IntegerValue, OldOrNewEntry)
select SObj.nextval, 1, ErzgKntCMDKntstnd, 'n'
from (select distinct ErzgKntCMDKntstnd from ErzgKntCMD)
where ErzgKntCMDKntstnd not in (select IntegerValue from Obj where OldOrNewEntry = 'o' and IntegerValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10040
from ErzgKntCMD t, Obj objTarget, Obj objOwner
where t.ErzgKntCMDKntstnd is not null and t.ErzgKntCMDKntstnd = objTarget.IntegerValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, IntegerValue, OldOrNewEntry)
select SObj.nextval, 1, ErzgKntCMDMnmm, 'n'
from (select distinct ErzgKntCMDMnmm from ErzgKntCMD)
where ErzgKntCMDMnmm not in (select IntegerValue from Obj where OldOrNewEntry = 'o' and IntegerValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10041
from ErzgKntCMD t, Obj objTarget, Obj objOwner
where t.ErzgKntCMDMnmm is not null and t.ErzgKntCMDMnmm = objTarget.IntegerValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, IntegerValue, OldOrNewEntry)
select SObj.nextval, 1, ErzgKntCMDGrnzwrt, 'n'
from (select distinct ErzgKntCMDGrnzwrt from ErzgKntCMD)
where ErzgKntCMDGrnzwrt not in (select IntegerValue from Obj where OldOrNewEntry = 'o' and IntegerValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10042
from ErzgKntCMD t, Obj objTarget, Obj objOwner
where t.ErzgKntCMDGrnzwrt is not null and t.ErzgKntCMDGrnzwrt = objTarget.IntegerValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10043
from ErzgKntCMD t, Obj objTarget, Obj objOwner
where t.ErzgKntCMDInvoker is not null and t.ErzgKntCMDInvoker = objTarget.oldId and t.ErzgKntCMDInvokerCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10044
from ErzgKntCMD t, Obj objTarget, Obj objOwner
where t.ErzgKntCMDCReceiver is not null and t.ErzgKntCMDCReceiver = objTarget.oldId and t.ErzgKntCMDCReceiverCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10045
from ErzgKntCMD t, Obj objTarget, Obj objOwner
where t.ErzgKntCMDMyCmmnDt is not null and t.ErzgKntCMDMyCmmnDt = objTarget.oldId and t.ErzgKntCMDMyCmmnDtCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10046
from BchKntCMD t, Obj objTarget, Obj objOwner
where t.BchKntCMDInvoker is not null and t.BchKntCMDInvoker = objTarget.oldId and t.BchKntCMDInvokerCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10047
from BchKntCMD t, Obj objTarget, Obj objOwner
where t.BchKntCMDCReceiver is not null and t.BchKntCMDCReceiver = objTarget.oldId and t.BchKntCMDCReceiverCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10048
from BchKntCMD t, Obj objTarget, Obj objOwner
where t.BchKntCMDMyCmmnDt is not null and t.BchKntCMDMyCmmnDt = objTarget.oldId and t.BchKntCMDMyCmmnDtCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf, oldId)
select SLnk.nextval, objOwner.id, objTarget.id, 10049, relation.id
from ArtnMngrArtn relation, ArtnMngr ownerTable, Obj objTarget, Obj objOwner
where relation.artn = objTarget.oldId
and   relation.Cls = objTarget.instanceOf
and   relation.frm = objOwner.oldId
and   relation.frm = ownerTable.id
and   ownerTable.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10050
from ArtnMngr t, Obj objTarget, Obj objOwner
where t.ArtnMngrSbSrvc is not null and t.ArtnMngrSbSrvc = objTarget.oldId and t.ArtnMngrSbSrvcCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10051
from ArtnMngr t, Obj objTarget, Obj objOwner
where t.ArtnMngrThis is not null and t.ArtnMngrThis = objTarget.oldId and t.ArtnMngrThisCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf, oldId)
select SLnk.nextval, objOwner.id, objTarget.id, 10052, relation.id
from CmmndCrdntrExctr relation, CmmndCrdntr ownerTable, Obj objTarget, Obj objOwner
where relation.exctr = objTarget.oldId
and   relation.Cls = objTarget.instanceOf
and   relation.frm = objOwner.oldId
and   relation.frm = ownerTable.id
and   ownerTable.Cls = objOwner.instanceOf;

insert into Obj(id, instanceOf, DateValue, OldOrNewEntry)
select SObj.nextval, 3, CmmnDtCrtdt, 'n'
from (select distinct CmmnDtCrtdt from CmmnDt)
where CmmnDtCrtdt not in (select DateValue from Obj where OldOrNewEntry = 'o' and DateValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10053
from CmmnDt t, Obj objTarget, Obj objOwner
where t.CmmnDtCrtdt is not null and t.CmmnDtCrtdt = objTarget.DateValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, DateValue, OldOrNewEntry)
select SObj.nextval, 3, CmmnDtCmmtdt, 'n'
from (select distinct CmmnDtCmmtdt from CmmnDt)
where CmmnDtCmmtdt not in (select DateValue from Obj where OldOrNewEntry = 'o' and DateValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10054
from CmmnDt t, Obj objTarget, Obj objOwner
where t.CmmnDtCmmtdt is not null and t.CmmnDtCmmtdt = objTarget.DateValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, StringValue, OldOrNewEntry)
select SObj.nextval, 2, KntKntID, 'n'
from (select distinct KntKntID from Knt)
where KntKntID not in (select StringValue from Obj where OldOrNewEntry = 'o' and StringValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10056
from Knt t, Obj objTarget, Obj objOwner
where t.KntKntID is not null and t.KntKntID = objTarget.StringValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, IntegerValue, OldOrNewEntry)
select SObj.nextval, 1, KntGrnzwrt, 'n'
from (select distinct KntGrnzwrt from Knt)
where KntGrnzwrt not in (select IntegerValue from Obj where OldOrNewEntry = 'o' and IntegerValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10057
from Knt t, Obj objTarget, Obj objOwner
where t.KntGrnzwrt is not null and t.KntGrnzwrt = objTarget.IntegerValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, IntegerValue, OldOrNewEntry)
select SObj.nextval, 1, KntKntstnd, 'n'
from (select distinct KntKntstnd from Knt)
where KntKntstnd not in (select IntegerValue from Obj where OldOrNewEntry = 'o' and IntegerValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10058
from Knt t, Obj objTarget, Obj objOwner
where t.KntKntstnd is not null and t.KntKntstnd = objTarget.IntegerValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Obj(id, instanceOf, IntegerValue, OldOrNewEntry)
select SObj.nextval, 1, KntMnmm, 'n'
from (select distinct KntMnmm from Knt)
where KntMnmm not in (select IntegerValue from Obj where OldOrNewEntry = 'o' and IntegerValue is not null);

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10059
from Knt t, Obj objTarget, Obj objOwner
where t.KntMnmm is not null and t.KntMnmm = objTarget.IntegerValue and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

update Obj set OldOrNewEntry = 'o' where OldOrNewEntry = 'n';

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10060
from Knt t, Obj objTarget, Obj objOwner
where t.KntSbSrvc is not null and t.KntSbSrvc = objTarget.oldId and t.KntSbSrvcCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10061
from Knt t, Obj objTarget, Obj objOwner
where t.KntThis is not null and t.KntThis = objTarget.oldId and t.KntThisCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf, oldId)
select SLnk.nextval, objOwner.id, objTarget.id, 10062, relation.id
from KntFcdKntn relation, KntFcd ownerTable, Obj objTarget, Obj objOwner
where relation.kntn = objTarget.oldId
and   relation.Cls = objTarget.instanceOf
and   relation.frm = objOwner.oldId
and   relation.frm = ownerTable.id
and   ownerTable.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10063
from KntFcd t, Obj objTarget, Obj objOwner
where t.KntFcdSbSrvc is not null and t.KntFcdSbSrvc = objTarget.oldId and t.KntFcdSbSrvcCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10064
from KntFcd t, Obj objTarget, Obj objOwner
where t.KntFcdThis is not null and t.KntFcdThis = objTarget.oldId and t.KntFcdThisCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10065
from TrnsFcd t, Obj objTarget, Obj objOwner
where t.TrnsFcdTrnsktns is not null and t.TrnsFcdTrnsktns = objTarget.oldId and t.TrnsFcdTrnsktnsCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10066
from TrnsFcd t, Obj objTarget, Obj objOwner
where t.TrnsFcdSbSrvc is not null and t.TrnsFcdSbSrvc = objTarget.oldId and t.TrnsFcdSbSrvcCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

insert into Lnk(id, owner, target, instanceOf)
select SLnk.nextval, objOwner.id, objTarget.id, 10067
from TrnsFcd t, Obj objTarget, Obj objOwner
where t.TrnsFcdThis is not null and t.TrnsFcdThis = objTarget.oldId and t.TrnsFcdThisCls = objTarget.instanceOf and t.id = objOwner.oldId and t.Cls = objOwner.instanceOf;

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


alter table CmmndExctr rename to CmmndExctr_Old;
create or replace view CmmndExctr as 
    select 
        o.id as id,
        o.instanceOf as Cls
    from
        Obj o,
        Specialization s
    where
        o.instanceOf = s.descendant and 
        s.ancestor = -109;
    
alter table Subj rename to Subj_Old;
create or replace view Subj as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        SubjThis.id as SubjThis,
        SubjThis.instanceOf as SubjThisCls
    from
        Obj o,
        Specialization s,
        Obj SubjThis, Lnk SubjThis_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 110 and 
        SubjThis_Lnk.instanceOf (+) = 10005 and o.id = SubjThis_Lnk.owner (+) and SubjThis_Lnk.target = SubjThis.id (+);
    
alter table AbsKstnArt rename to AbsKstnArt_Old;
create or replace view AbsKstnArt as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        AbsKstnArtSbSrvc.id as AbsKstnArtSbSrvc,
        AbsKstnArtSbSrvc.instanceOf as AbsKstnArtSbSrvcCls,
        AbsKstnArtThis.id as AbsKstnArtThis,
        AbsKstnArtThis.instanceOf as AbsKstnArtThisCls,
        KnkrKstnArtSpzllrAls.id as KnkrKstnArtSpzllrAls,
        KnkrKstnArtSpzllrAls.instanceOf as KnkrKstnArtSpzllrAlsCls
    from
        Obj o,
        Specialization s,
        Obj AbsKstnArtSbSrvc, Lnk AbsKstnArtSbSrvc_Lnk,
        Obj AbsKstnArtThis, Lnk AbsKstnArtThis_Lnk,
        Obj KnkrKstnArtSpzllrAls, Lnk KnkrKstnArtSpzllrAls_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 111 and 
        AbsKstnArtSbSrvc_Lnk.instanceOf (+) = 10006 and o.id = AbsKstnArtSbSrvc_Lnk.owner (+) and AbsKstnArtSbSrvc_Lnk.target = AbsKstnArtSbSrvc.id (+) and 
        AbsKstnArtThis_Lnk.instanceOf (+) = 10007 and o.id = AbsKstnArtThis_Lnk.owner (+) and AbsKstnArtThis_Lnk.target = AbsKstnArtThis.id (+) and 
        KnkrKstnArtSpzllrAls_Lnk.instanceOf (+) = 10055 and o.id = KnkrKstnArtSpzllrAls_Lnk.owner (+) and KnkrKstnArtSpzllrAls_Lnk.target = KnkrKstnArtSpzllrAls.id (+);
    
alter table Trnsktn rename to Trnsktn_Old;
create or replace view Trnsktn as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        TrnsktnSbSrvc.id as TrnsktnSbSrvc,
        TrnsktnSbSrvc.instanceOf as TrnsktnSbSrvcCls,
        TrnsktnThis.id as TrnsktnThis,
        TrnsktnThis.instanceOf as TrnsktnThisCls
    from
        Obj o,
        Specialization s,
        Obj TrnsktnSbSrvc, Lnk TrnsktnSbSrvc_Lnk,
        Obj TrnsktnThis, Lnk TrnsktnThis_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 112 and 
        TrnsktnSbSrvc_Lnk.instanceOf (+) = 10009 and o.id = TrnsktnSbSrvc_Lnk.owner (+) and TrnsktnSbSrvc_Lnk.target = TrnsktnSbSrvc.id (+) and 
        TrnsktnThis_Lnk.instanceOf (+) = 10010 and o.id = TrnsktnThis_Lnk.owner (+) and TrnsktnThis_Lnk.target = TrnsktnThis.id (+);
    
alter table ErzgTrnsktnCMD rename to ErzgTrnsktnCMD_Old;
create or replace view ErzgTrnsktnCMD as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        ErzgTrnsktnCMDKntID.value as ErzgTrnsktnCMDKntID,
        ErzgTrnsktnCMDInvoker.id as ErzgTrnsktnCMDInvoker,
        ErzgTrnsktnCMDInvoker.instanceOf as ErzgTrnsktnCMDInvokerCls,
        ErzgTrnsktnCMDCReceiver.id as ErzgTrnsktnCMDCReceiver,
        ErzgTrnsktnCMDCReceiver.instanceOf as ErzgTrnsktnCMDCReceiverCls,
        ErzgTrnsktnCMDMyCmmnDt.id as ErzgTrnsktnCMDMyCmmnDt,
        ErzgTrnsktnCMDMyCmmnDt.instanceOf as ErzgTrnsktnCMDMyCmmnDtCls
    from
        Obj o,
        Specialization s,
        StringValue ErzgTrnsktnCMDKntID, Lnk ErzgTrnsktnCMDKntID_Lnk,
        Obj ErzgTrnsktnCMDInvoker, Lnk ErzgTrnsktnCMDInvoker_Lnk,
        Obj ErzgTrnsktnCMDCReceiver, Lnk ErzgTrnsktnCMDCReceiver_Lnk,
        Obj ErzgTrnsktnCMDMyCmmnDt, Lnk ErzgTrnsktnCMDMyCmmnDt_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 113 and 
        ErzgTrnsktnCMDKntID_Lnk.instanceOf (+) = 10011 and o.id = ErzgTrnsktnCMDKntID_Lnk.owner (+) and ErzgTrnsktnCMDKntID_Lnk.target = ErzgTrnsktnCMDKntID.id (+) and 
        ErzgTrnsktnCMDInvoker_Lnk.instanceOf (+) = 10012 and o.id = ErzgTrnsktnCMDInvoker_Lnk.owner (+) and ErzgTrnsktnCMDInvoker_Lnk.target = ErzgTrnsktnCMDInvoker.id (+) and 
        ErzgTrnsktnCMDCReceiver_Lnk.instanceOf (+) = 10013 and o.id = ErzgTrnsktnCMDCReceiver_Lnk.owner (+) and ErzgTrnsktnCMDCReceiver_Lnk.target = ErzgTrnsktnCMDCReceiver.id (+) and 
        ErzgTrnsktnCMDMyCmmnDt_Lnk.instanceOf (+) = 10014 and o.id = ErzgTrnsktnCMDMyCmmnDt_Lnk.owner (+) and ErzgTrnsktnCMDMyCmmnDt_Lnk.target = ErzgTrnsktnCMDMyCmmnDt.id (+);
    
alter table FndKntCMD rename to FndKntCMD_Old;
create or replace view FndKntCMD as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        FndKntCMDKntID.value as FndKntCMDKntID,
        FndKntCMDInvoker.id as FndKntCMDInvoker,
        FndKntCMDInvoker.instanceOf as FndKntCMDInvokerCls,
        FndKntCMDCReceiver.id as FndKntCMDCReceiver,
        FndKntCMDCReceiver.instanceOf as FndKntCMDCReceiverCls,
        FndKntCMDMyCmmnDt.id as FndKntCMDMyCmmnDt,
        FndKntCMDMyCmmnDt.instanceOf as FndKntCMDMyCmmnDtCls
    from
        Obj o,
        Specialization s,
        StringValue FndKntCMDKntID, Lnk FndKntCMDKntID_Lnk,
        Obj FndKntCMDInvoker, Lnk FndKntCMDInvoker_Lnk,
        Obj FndKntCMDCReceiver, Lnk FndKntCMDCReceiver_Lnk,
        Obj FndKntCMDMyCmmnDt, Lnk FndKntCMDMyCmmnDt_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 114 and 
        FndKntCMDKntID_Lnk.instanceOf (+) = 10015 and o.id = FndKntCMDKntID_Lnk.owner (+) and FndKntCMDKntID_Lnk.target = FndKntCMDKntID.id (+) and 
        FndKntCMDInvoker_Lnk.instanceOf (+) = 10016 and o.id = FndKntCMDInvoker_Lnk.owner (+) and FndKntCMDInvoker_Lnk.target = FndKntCMDInvoker.id (+) and 
        FndKntCMDCReceiver_Lnk.instanceOf (+) = 10017 and o.id = FndKntCMDCReceiver_Lnk.owner (+) and FndKntCMDCReceiver_Lnk.target = FndKntCMDCReceiver.id (+) and 
        FndKntCMDMyCmmnDt_Lnk.instanceOf (+) = 10018 and o.id = FndKntCMDMyCmmnDt_Lnk.owner (+) and FndKntCMDMyCmmnDt_Lnk.target = FndKntCMDMyCmmnDt.id (+);
    
alter table TrnsFcdTrnsktns rename to TrnsFcdTrnsktns_Old;
create or replace view TrnsFcdTrnsktns as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        TrnsFcdTrnsktnsMstr.id as TrnsFcdTrnsktnsMstr,
        TrnsFcdTrnsktnsMstr.instanceOf as TrnsFcdTrnsktnsMstrCls,
        TrnsFcdTrnsktnsThis.id as TrnsFcdTrnsktnsThis,
        TrnsFcdTrnsktnsThis.instanceOf as TrnsFcdTrnsktnsThisCls
    from
        Obj o,
        Specialization s,
        Obj TrnsFcdTrnsktnsMstr, Lnk TrnsFcdTrnsktnsMstr_Lnk,
        Obj TrnsFcdTrnsktnsThis, Lnk TrnsFcdTrnsktnsThis_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 116 and 
        TrnsFcdTrnsktnsMstr_Lnk.instanceOf (+) = 10020 and o.id = TrnsFcdTrnsktnsMstr_Lnk.owner (+) and TrnsFcdTrnsktnsMstr_Lnk.target = TrnsFcdTrnsktnsMstr.id (+) and 
        TrnsFcdTrnsktnsThis_Lnk.instanceOf (+) = 10022 and o.id = TrnsFcdTrnsktnsThis_Lnk.owner (+) and TrnsFcdTrnsktnsThis_Lnk.target = TrnsFcdTrnsktnsThis.id (+);
    
alter table Srvr rename to Srvr_Old;
create or replace view Srvr as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        SrvrArtn.id as SrvrArtn,
        SrvrArtn.instanceOf as SrvrArtnCls,
        SrvrMngr.id as SrvrMngr,
        SrvrMngr.instanceOf as SrvrMngrCls,
        SrvrTrnsktnMngr.id as SrvrTrnsktnMngr,
        SrvrTrnsktnMngr.instanceOf as SrvrTrnsktnMngrCls,
        SrvrSbSrvc.id as SrvrSbSrvc,
        SrvrSbSrvc.instanceOf as SrvrSbSrvcCls,
        SrvrThis.id as SrvrThis,
        SrvrThis.instanceOf as SrvrThisCls,
        SrvrPassword.value as SrvrPassword,
        SrvrUser.value as SrvrUser,
        SrvrHackCount.value as SrvrHackCount,
        SrvrHackDelay.value as SrvrHackDelay
    from
        Obj o,
        Specialization s,
        Obj SrvrArtn, Lnk SrvrArtn_Lnk,
        Obj SrvrMngr, Lnk SrvrMngr_Lnk,
        Obj SrvrTrnsktnMngr, Lnk SrvrTrnsktnMngr_Lnk,
        Obj SrvrSbSrvc, Lnk SrvrSbSrvc_Lnk,
        Obj SrvrThis, Lnk SrvrThis_Lnk,
        StringValue SrvrPassword, Lnk SrvrPassword_Lnk,
        StringValue SrvrUser, Lnk SrvrUser_Lnk,
        IntegerValue SrvrHackCount, Lnk SrvrHackCount_Lnk,
        TimestampValue SrvrHackDelay, Lnk SrvrHackDelay_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = -117 and 
        SrvrArtn_Lnk.instanceOf (+) = 10023 and o.id = SrvrArtn_Lnk.owner (+) and SrvrArtn_Lnk.target = SrvrArtn.id (+) and 
        SrvrMngr_Lnk.instanceOf (+) = 10024 and o.id = SrvrMngr_Lnk.owner (+) and SrvrMngr_Lnk.target = SrvrMngr.id (+) and 
        SrvrTrnsktnMngr_Lnk.instanceOf (+) = 10025 and o.id = SrvrTrnsktnMngr_Lnk.owner (+) and SrvrTrnsktnMngr_Lnk.target = SrvrTrnsktnMngr.id (+) and 
        SrvrSbSrvc_Lnk.instanceOf (+) = 10026 and o.id = SrvrSbSrvc_Lnk.owner (+) and SrvrSbSrvc_Lnk.target = SrvrSbSrvc.id (+) and 
        SrvrThis_Lnk.instanceOf (+) = 10027 and o.id = SrvrThis_Lnk.owner (+) and SrvrThis_Lnk.target = SrvrThis.id (+) and 
        SrvrPassword_Lnk.instanceOf (+) = 10029 and o.id = SrvrPassword_Lnk.owner (+) and SrvrPassword_Lnk.target = SrvrPassword.id (+) and 
        SrvrUser_Lnk.instanceOf (+) = 10030 and o.id = SrvrUser_Lnk.owner (+) and SrvrUser_Lnk.target = SrvrUser.id (+) and 
        SrvrHackCount_Lnk.instanceOf (+) = 10031 and o.id = SrvrHackCount_Lnk.owner (+) and SrvrHackCount_Lnk.target = SrvrHackCount.id (+) and 
        SrvrHackDelay_Lnk.instanceOf (+) = 10032 and o.id = SrvrHackDelay_Lnk.owner (+) and SrvrHackDelay_Lnk.target = SrvrHackDelay.id (+);
    
alter table Trnsfr rename to Trnsfr_Old;
create or replace view Trnsfr as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        TrnsfrVnKnt.id as TrnsfrVnKnt,
        TrnsfrVnKnt.instanceOf as TrnsfrVnKntCls,
        TrnsfrZKnt.id as TrnsfrZKnt,
        TrnsfrZKnt.instanceOf as TrnsfrZKntCls,
        TrnsfrSmm.value as TrnsfrSmm,
        TrnsfrKntID.value as TrnsfrKntID,
        TrnsfrSbSrvc.id as TrnsfrSbSrvc,
        TrnsfrSbSrvc.instanceOf as TrnsfrSbSrvcCls,
        TrnsfrThis.id as TrnsfrThis,
        TrnsfrThis.instanceOf as TrnsfrThisCls
    from
        Obj o,
        Specialization s,
        Obj TrnsfrVnKnt, Lnk TrnsfrVnKnt_Lnk,
        Obj TrnsfrZKnt, Lnk TrnsfrZKnt_Lnk,
        IntegerValue TrnsfrSmm, Lnk TrnsfrSmm_Lnk,
        StringValue TrnsfrKntID, Lnk TrnsfrKntID_Lnk,
        Obj TrnsfrSbSrvc, Lnk TrnsfrSbSrvc_Lnk,
        Obj TrnsfrThis, Lnk TrnsfrThis_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 118 and 
        TrnsfrVnKnt_Lnk.instanceOf (+) = 10033 and o.id = TrnsfrVnKnt_Lnk.owner (+) and TrnsfrVnKnt_Lnk.target = TrnsfrVnKnt.id (+) and 
        TrnsfrZKnt_Lnk.instanceOf (+) = 10034 and o.id = TrnsfrZKnt_Lnk.owner (+) and TrnsfrZKnt_Lnk.target = TrnsfrZKnt.id (+) and 
        TrnsfrSmm_Lnk.instanceOf (+) = 10035 and o.id = TrnsfrSmm_Lnk.owner (+) and TrnsfrSmm_Lnk.target = TrnsfrSmm.id (+) and 
        TrnsfrKntID_Lnk.instanceOf (+) = 10036 and o.id = TrnsfrKntID_Lnk.owner (+) and TrnsfrKntID_Lnk.target = TrnsfrKntID.id (+) and 
        TrnsfrSbSrvc_Lnk.instanceOf (+) = 10037 and o.id = TrnsfrSbSrvc_Lnk.owner (+) and TrnsfrSbSrvc_Lnk.target = TrnsfrSbSrvc.id (+) and 
        TrnsfrThis_Lnk.instanceOf (+) = 10038 and o.id = TrnsfrThis_Lnk.owner (+) and TrnsfrThis_Lnk.target = TrnsfrThis.id (+);
    
alter table ErzgKntCMD rename to ErzgKntCMD_Old;
create or replace view ErzgKntCMD as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        ErzgKntCMDKntID.value as ErzgKntCMDKntID,
        ErzgKntCMDKntstnd.value as ErzgKntCMDKntstnd,
        ErzgKntCMDMnmm.value as ErzgKntCMDMnmm,
        ErzgKntCMDGrnzwrt.value as ErzgKntCMDGrnzwrt,
        ErzgKntCMDInvoker.id as ErzgKntCMDInvoker,
        ErzgKntCMDInvoker.instanceOf as ErzgKntCMDInvokerCls,
        ErzgKntCMDCReceiver.id as ErzgKntCMDCReceiver,
        ErzgKntCMDCReceiver.instanceOf as ErzgKntCMDCReceiverCls,
        ErzgKntCMDMyCmmnDt.id as ErzgKntCMDMyCmmnDt,
        ErzgKntCMDMyCmmnDt.instanceOf as ErzgKntCMDMyCmmnDtCls
    from
        Obj o,
        Specialization s,
        StringValue ErzgKntCMDKntID, Lnk ErzgKntCMDKntID_Lnk,
        IntegerValue ErzgKntCMDKntstnd, Lnk ErzgKntCMDKntstnd_Lnk,
        IntegerValue ErzgKntCMDMnmm, Lnk ErzgKntCMDMnmm_Lnk,
        IntegerValue ErzgKntCMDGrnzwrt, Lnk ErzgKntCMDGrnzwrt_Lnk,
        Obj ErzgKntCMDInvoker, Lnk ErzgKntCMDInvoker_Lnk,
        Obj ErzgKntCMDCReceiver, Lnk ErzgKntCMDCReceiver_Lnk,
        Obj ErzgKntCMDMyCmmnDt, Lnk ErzgKntCMDMyCmmnDt_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 119 and 
        ErzgKntCMDKntID_Lnk.instanceOf (+) = 10039 and o.id = ErzgKntCMDKntID_Lnk.owner (+) and ErzgKntCMDKntID_Lnk.target = ErzgKntCMDKntID.id (+) and 
        ErzgKntCMDKntstnd_Lnk.instanceOf (+) = 10040 and o.id = ErzgKntCMDKntstnd_Lnk.owner (+) and ErzgKntCMDKntstnd_Lnk.target = ErzgKntCMDKntstnd.id (+) and 
        ErzgKntCMDMnmm_Lnk.instanceOf (+) = 10041 and o.id = ErzgKntCMDMnmm_Lnk.owner (+) and ErzgKntCMDMnmm_Lnk.target = ErzgKntCMDMnmm.id (+) and 
        ErzgKntCMDGrnzwrt_Lnk.instanceOf (+) = 10042 and o.id = ErzgKntCMDGrnzwrt_Lnk.owner (+) and ErzgKntCMDGrnzwrt_Lnk.target = ErzgKntCMDGrnzwrt.id (+) and 
        ErzgKntCMDInvoker_Lnk.instanceOf (+) = 10043 and o.id = ErzgKntCMDInvoker_Lnk.owner (+) and ErzgKntCMDInvoker_Lnk.target = ErzgKntCMDInvoker.id (+) and 
        ErzgKntCMDCReceiver_Lnk.instanceOf (+) = 10044 and o.id = ErzgKntCMDCReceiver_Lnk.owner (+) and ErzgKntCMDCReceiver_Lnk.target = ErzgKntCMDCReceiver.id (+) and 
        ErzgKntCMDMyCmmnDt_Lnk.instanceOf (+) = 10045 and o.id = ErzgKntCMDMyCmmnDt_Lnk.owner (+) and ErzgKntCMDMyCmmnDt_Lnk.target = ErzgKntCMDMyCmmnDt.id (+);
    
alter table BchKntCMD rename to BchKntCMD_Old;
create or replace view BchKntCMD as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        BchKntCMDInvoker.id as BchKntCMDInvoker,
        BchKntCMDInvoker.instanceOf as BchKntCMDInvokerCls,
        BchKntCMDCReceiver.id as BchKntCMDCReceiver,
        BchKntCMDCReceiver.instanceOf as BchKntCMDCReceiverCls,
        BchKntCMDMyCmmnDt.id as BchKntCMDMyCmmnDt,
        BchKntCMDMyCmmnDt.instanceOf as BchKntCMDMyCmmnDtCls
    from
        Obj o,
        Specialization s,
        Obj BchKntCMDInvoker, Lnk BchKntCMDInvoker_Lnk,
        Obj BchKntCMDCReceiver, Lnk BchKntCMDCReceiver_Lnk,
        Obj BchKntCMDMyCmmnDt, Lnk BchKntCMDMyCmmnDt_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 120 and 
        BchKntCMDInvoker_Lnk.instanceOf (+) = 10046 and o.id = BchKntCMDInvoker_Lnk.owner (+) and BchKntCMDInvoker_Lnk.target = BchKntCMDInvoker.id (+) and 
        BchKntCMDCReceiver_Lnk.instanceOf (+) = 10047 and o.id = BchKntCMDCReceiver_Lnk.owner (+) and BchKntCMDCReceiver_Lnk.target = BchKntCMDCReceiver.id (+) and 
        BchKntCMDMyCmmnDt_Lnk.instanceOf (+) = 10048 and o.id = BchKntCMDMyCmmnDt_Lnk.owner (+) and BchKntCMDMyCmmnDt_Lnk.target = BchKntCMDMyCmmnDt.id (+);
    
alter table ArtnMngr rename to ArtnMngr_Old;
create or replace view ArtnMngr as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        ArtnMngrSbSrvc.id as ArtnMngrSbSrvc,
        ArtnMngrSbSrvc.instanceOf as ArtnMngrSbSrvcCls,
        ArtnMngrThis.id as ArtnMngrThis,
        ArtnMngrThis.instanceOf as ArtnMngrThisCls
    from
        Obj o,
        Specialization s,
        Obj ArtnMngrSbSrvc, Lnk ArtnMngrSbSrvc_Lnk,
        Obj ArtnMngrThis, Lnk ArtnMngrThis_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 121 and 
        ArtnMngrSbSrvc_Lnk.instanceOf (+) = 10050 and o.id = ArtnMngrSbSrvc_Lnk.owner (+) and ArtnMngrSbSrvc_Lnk.target = ArtnMngrSbSrvc.id (+) and 
        ArtnMngrThis_Lnk.instanceOf (+) = 10051 and o.id = ArtnMngrThis_Lnk.owner (+) and ArtnMngrThis_Lnk.target = ArtnMngrThis.id (+);
    
alter table CmmndCrdntr rename to CmmndCrdntr_Old;
create or replace view CmmndCrdntr as 
    select 
        o.id as id,
        o.instanceOf as Cls
    from
        Obj o,
        Specialization s
    where
        o.instanceOf = s.descendant and 
        s.ancestor = -123;
    
alter table CmmnDt rename to CmmnDt_Old;
create or replace view CmmnDt as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        CmmnDtCrtdt.value as CmmnDtCrtdt,
        CmmnDtCmmtdt.value as CmmnDtCmmtdt
    from
        Obj o,
        Specialization s,
        DateValue CmmnDtCrtdt, Lnk CmmnDtCrtdt_Lnk,
        DateValue CmmnDtCmmtdt, Lnk CmmnDtCmmtdt_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 124 and 
        CmmnDtCrtdt_Lnk.instanceOf (+) = 10053 and o.id = CmmnDtCrtdt_Lnk.owner (+) and CmmnDtCrtdt_Lnk.target = CmmnDtCrtdt.id (+) and 
        CmmnDtCmmtdt_Lnk.instanceOf (+) = 10054 and o.id = CmmnDtCmmtdt_Lnk.owner (+) and CmmnDtCmmtdt_Lnk.target = CmmnDtCmmtdt.id (+);
    
alter table Knt rename to Knt_Old;
create or replace view Knt as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        KntKntID.value as KntKntID,
        KntGrnzwrt.value as KntGrnzwrt,
        KntKntstnd.value as KntKntstnd,
        KntMnmm.value as KntMnmm,
        KntSbSrvc.id as KntSbSrvc,
        KntSbSrvc.instanceOf as KntSbSrvcCls,
        KntThis.id as KntThis,
        KntThis.instanceOf as KntThisCls
    from
        Obj o,
        Specialization s,
        StringValue KntKntID, Lnk KntKntID_Lnk,
        IntegerValue KntGrnzwrt, Lnk KntGrnzwrt_Lnk,
        IntegerValue KntKntstnd, Lnk KntKntstnd_Lnk,
        IntegerValue KntMnmm, Lnk KntMnmm_Lnk,
        Obj KntSbSrvc, Lnk KntSbSrvc_Lnk,
        Obj KntThis, Lnk KntThis_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 126 and 
        KntKntID_Lnk.instanceOf (+) = 10056 and o.id = KntKntID_Lnk.owner (+) and KntKntID_Lnk.target = KntKntID.id (+) and 
        KntGrnzwrt_Lnk.instanceOf (+) = 10057 and o.id = KntGrnzwrt_Lnk.owner (+) and KntGrnzwrt_Lnk.target = KntGrnzwrt.id (+) and 
        KntKntstnd_Lnk.instanceOf (+) = 10058 and o.id = KntKntstnd_Lnk.owner (+) and KntKntstnd_Lnk.target = KntKntstnd.id (+) and 
        KntMnmm_Lnk.instanceOf (+) = 10059 and o.id = KntMnmm_Lnk.owner (+) and KntMnmm_Lnk.target = KntMnmm.id (+) and 
        KntSbSrvc_Lnk.instanceOf (+) = 10060 and o.id = KntSbSrvc_Lnk.owner (+) and KntSbSrvc_Lnk.target = KntSbSrvc.id (+) and 
        KntThis_Lnk.instanceOf (+) = 10061 and o.id = KntThis_Lnk.owner (+) and KntThis_Lnk.target = KntThis.id (+);
    
alter table KntFcd rename to KntFcd_Old;
create or replace view KntFcd as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        KntFcdSbSrvc.id as KntFcdSbSrvc,
        KntFcdSbSrvc.instanceOf as KntFcdSbSrvcCls,
        KntFcdThis.id as KntFcdThis,
        KntFcdThis.instanceOf as KntFcdThisCls
    from
        Obj o,
        Specialization s,
        Obj KntFcdSbSrvc, Lnk KntFcdSbSrvc_Lnk,
        Obj KntFcdThis, Lnk KntFcdThis_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 127 and 
        KntFcdSbSrvc_Lnk.instanceOf (+) = 10063 and o.id = KntFcdSbSrvc_Lnk.owner (+) and KntFcdSbSrvc_Lnk.target = KntFcdSbSrvc.id (+) and 
        KntFcdThis_Lnk.instanceOf (+) = 10064 and o.id = KntFcdThis_Lnk.owner (+) and KntFcdThis_Lnk.target = KntFcdThis.id (+);
    
alter table TrnsFcd rename to TrnsFcd_Old;
create or replace view TrnsFcd as 
    select 
        o.id as id,
        o.instanceOf as Cls,
        TrnsFcdTrnsktns.id as TrnsFcdTrnsktns,
        TrnsFcdTrnsktns.instanceOf as TrnsFcdTrnsktnsCls,
        TrnsFcdSbSrvc.id as TrnsFcdSbSrvc,
        TrnsFcdSbSrvc.instanceOf as TrnsFcdSbSrvcCls,
        TrnsFcdThis.id as TrnsFcdThis,
        TrnsFcdThis.instanceOf as TrnsFcdThisCls
    from
        Obj o,
        Specialization s,
        Obj TrnsFcdTrnsktns, Lnk TrnsFcdTrnsktns_Lnk,
        Obj TrnsFcdSbSrvc, Lnk TrnsFcdSbSrvc_Lnk,
        Obj TrnsFcdThis, Lnk TrnsFcdThis_Lnk
    where
        o.instanceOf = s.descendant and 
        s.ancestor = 129 and 
        TrnsFcdTrnsktns_Lnk.instanceOf (+) = 10065 and o.id = TrnsFcdTrnsktns_Lnk.owner (+) and TrnsFcdTrnsktns_Lnk.target = TrnsFcdTrnsktns.id (+) and 
        TrnsFcdSbSrvc_Lnk.instanceOf (+) = 10066 and o.id = TrnsFcdSbSrvc_Lnk.owner (+) and TrnsFcdSbSrvc_Lnk.target = TrnsFcdSbSrvc.id (+) and 
        TrnsFcdThis_Lnk.instanceOf (+) = 10067 and o.id = TrnsFcdThis_Lnk.owner (+) and TrnsFcdThis_Lnk.target = TrnsFcdThis.id (+);
    


alter table CmmndExctrCommands rename to CmmndExctrCommands_Old;
create or replace view CmmndExctrCommands as 
    select 
        l.id as id, 
        l.owner as frm, 
        l.target as commands,
        t.instanceOf as Cls
    from Lnk l, Obj t
    where l.target = t.id and l.instanceOf = 10003;

alter table SubjObs rename to SubjObs_Old;
create or replace view SubjObs as 
    select 
        l.id as id, 
        l.owner as frm, 
        l.target as obs,
        t.instanceOf as Cls
    from Lnk l, Obj t
    where l.target = t.id and l.instanceOf = 10004;

alter table TrnsktnTrnsfrs rename to TrnsktnTrnsfrs_Old;
create or replace view TrnsktnTrnsfrs as 
    select 
        l.id as id, 
        l.owner as frm, 
        l.target as trnsfrs,
        t.instanceOf as Cls
    from Lnk l, Obj t
    where l.target = t.id and l.instanceOf = 10008;

alter table TrnsFcdTrnsktnsObs rename to TrnsFcdTrnsktnsObs_Old;
create or replace view TrnsFcdTrnsktnsObs as 
    select 
        l.id as id, 
        l.owner as frm, 
        l.target as obs,
        t.instanceOf as Cls
    from Lnk l, Obj t
    where l.target = t.id and l.instanceOf = 10021;

alter table ArtnMngrArtn rename to ArtnMngrArtn_Old;
create or replace view ArtnMngrArtn as 
    select 
        l.id as id, 
        l.owner as frm, 
        l.target as artn,
        t.instanceOf as Cls
    from Lnk l, Obj t
    where l.target = t.id and l.instanceOf = 10049;

alter table CmmndCrdntrExctr rename to CmmndCrdntrExctr_Old;
create or replace view CmmndCrdntrExctr as 
    select 
        l.id as id, 
        l.owner as frm, 
        l.target as exctr,
        t.instanceOf as Cls
    from Lnk l, Obj t
    where l.target = t.id and l.instanceOf = 10052;

alter table KntFcdKntn rename to KntFcdKntn_Old;
create or replace view KntFcdKntn as 
    select 
        l.id as id, 
        l.owner as frm, 
        l.target as kntn,
        t.instanceOf as Cls
    from Lnk l, Obj t
    where l.target = t.id and l.instanceOf = 10062;

