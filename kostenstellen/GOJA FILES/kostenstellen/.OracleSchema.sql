create table Cls(
    id number primary key,
    name varchar2(2000) not null,
    concrete number not null
);

create table DeletedObjects(
    id number,
    instanceOf number not null,
    constraint FDeletedObjectsInstanceOf foreign key (instanceOf) references Cls(id)
);
create unique index DltdObjInx on DeletedObjects (id, instanceOf);

create sequence SSpecialization nocache;

create table Specialization (
    id number primary key,
    ancestor number,
    constraint FSpecializationAncestor foreign key (ancestor) references Cls(id),
    descendant number,
    constraint FSpecializationDescendant foreign key (descendant) references Cls(id)
);

create table Association (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociationOwner foreign key (owner) references Cls(id),
    target number,
    constraint FAssociationTarget foreign key (target) references Cls(id),
    complexity number
);

create table Association3 (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociation3Owner foreign key (owner) references Cls(id),
    indxx number,
    constraint FAssociation3Indxx foreign key (indxx) references Cls(id),
    target number,
    constraint FAssociation3Target foreign key (target) references Cls(id)
);

create sequence SCmmndExctr nocache;

create table CmmndExctr(
    id number primary key,
    Cls number not null    
);

create sequence SSubj nocache;

create table Subj(
    id number primary key,
    Cls number not null,
    SubjThis number,
    SubjThisCls number,
    constraint FSubjThis foreign key (SubjThisCls) references Cls (id)    
);

create sequence SAbsKstnArt nocache;

create table AbsKstnArt(
    id number primary key,
    Cls number not null,
    AbsKstnArtSbSrvc number,
    AbsKstnArtSbSrvcCls number,
    constraint FAbsKstnArtSbSrvc foreign key (AbsKstnArtSbSrvcCls) references Cls (id),
    AbsKstnArtThis number,
    AbsKstnArtThisCls number,
    constraint FAbsKstnArtThis foreign key (AbsKstnArtThisCls) references Cls (id),
    KnkrKstnArtSpzllrAls number,
    KnkrKstnArtSpzllrAlsCls number,
    constraint FKnkrKstnArtSpzllrAls foreign key (KnkrKstnArtSpzllrAlsCls) references Cls (id)    
);

create sequence STrnsktn nocache;

create table Trnsktn(
    id number primary key,
    Cls number not null,
    TrnsktnSbSrvc number,
    TrnsktnSbSrvcCls number,
    constraint FTrnsktnSbSrvc foreign key (TrnsktnSbSrvcCls) references Cls (id),
    TrnsktnThis number,
    TrnsktnThisCls number,
    constraint FTrnsktnThis foreign key (TrnsktnThisCls) references Cls (id)    
);

create sequence SErzgTrnsktnCMD nocache;

create table ErzgTrnsktnCMD(
    id number primary key,
    Cls number not null,
    ErzgTrnsktnCMDKntID varchar2(2000),
    ErzgTrnsktnCMDInvoker number,
    ErzgTrnsktnCMDInvokerCls number,
    constraint FErzgTrnsktnCMDInvoker foreign key (ErzgTrnsktnCMDInvokerCls) references Cls (id),
    ErzgTrnsktnCMDCReceiver number,
    ErzgTrnsktnCMDCReceiverCls number,
    constraint FErzgTrnsktnCMDCReceiver foreign key (ErzgTrnsktnCMDCReceiverCls) references Cls (id),
    ErzgTrnsktnCMDMyCmmnDt number,
    ErzgTrnsktnCMDMyCmmnDtCls number,
    constraint FErzgTrnsktnCMDMyCmmnDt foreign key (ErzgTrnsktnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SFndKntCMD nocache;

create table FndKntCMD(
    id number primary key,
    Cls number not null,
    FndKntCMDKntID varchar2(2000),
    FndKntCMDInvoker number,
    FndKntCMDInvokerCls number,
    constraint FFndKntCMDInvoker foreign key (FndKntCMDInvokerCls) references Cls (id),
    FndKntCMDCReceiver number,
    FndKntCMDCReceiverCls number,
    constraint FFndKntCMDCReceiver foreign key (FndKntCMDCReceiverCls) references Cls (id),
    FndKntCMDMyCmmnDt number,
    FndKntCMDMyCmmnDtCls number,
    constraint FFndKntCMDMyCmmnDt foreign key (FndKntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence STrnsFcdTrnsktns nocache;

create table TrnsFcdTrnsktns(
    id number primary key,
    Cls number not null,
    TrnsFcdTrnsktnsMstr number,
    TrnsFcdTrnsktnsMstrCls number,
    constraint FTrnsFcdTrnsktnsMstr foreign key (TrnsFcdTrnsktnsMstrCls) references Cls (id),
    TrnsFcdTrnsktnsThis number,
    TrnsFcdTrnsktnsThisCls number,
    constraint FTrnsFcdTrnsktnsThis foreign key (TrnsFcdTrnsktnsThisCls) references Cls (id)    
);

create sequence SSrvr nocache;

create table Srvr(
    id number primary key,
    Cls number not null,
    SrvrArtn number,
    SrvrArtnCls number,
    constraint FSrvrArtn foreign key (SrvrArtnCls) references Cls (id),
    SrvrMngr number,
    SrvrMngrCls number,
    constraint FSrvrMngr foreign key (SrvrMngrCls) references Cls (id),
    SrvrTrnsktnMngr number,
    SrvrTrnsktnMngrCls number,
    constraint FSrvrTrnsktnMngr foreign key (SrvrTrnsktnMngrCls) references Cls (id),
    SrvrSbSrvc number,
    SrvrSbSrvcCls number,
    constraint FSrvrSbSrvc foreign key (SrvrSbSrvcCls) references Cls (id),
    SrvrThis number,
    SrvrThisCls number,
    constraint FSrvrThis foreign key (SrvrThisCls) references Cls (id),
    SrvrPassword varchar2(2000),
    SrvrUser varchar2(2000),
    SrvrHackCount number,
    SrvrHackDelay Timestamp    
);
create index IMngrSrvr on Srvr (SrvrMngr, SrvrMngrCls);
create index ITrnsktnMngrSrvr on Srvr (SrvrTrnsktnMngr, SrvrTrnsktnMngrCls);
create index IUserSrvr on Srvr (SrvrUser);


create sequence STrnsfr nocache;

create table Trnsfr(
    id number primary key,
    Cls number not null,
    TrnsfrVnKnt number,
    TrnsfrVnKntCls number,
    constraint FTrnsfrVnKnt foreign key (TrnsfrVnKntCls) references Cls (id),
    TrnsfrZKnt number,
    TrnsfrZKntCls number,
    constraint FTrnsfrZKnt foreign key (TrnsfrZKntCls) references Cls (id),
    TrnsfrSmm number,
    TrnsfrKntID varchar2(2000),
    TrnsfrSbSrvc number,
    TrnsfrSbSrvcCls number,
    constraint FTrnsfrSbSrvc foreign key (TrnsfrSbSrvcCls) references Cls (id),
    TrnsfrThis number,
    TrnsfrThisCls number,
    constraint FTrnsfrThis foreign key (TrnsfrThisCls) references Cls (id)    
);

create sequence SErzgKntCMD nocache;

create table ErzgKntCMD(
    id number primary key,
    Cls number not null,
    ErzgKntCMDKntID varchar2(2000),
    ErzgKntCMDKntstnd number,
    ErzgKntCMDMnmm number,
    ErzgKntCMDGrnzwrt number,
    ErzgKntCMDInvoker number,
    ErzgKntCMDInvokerCls number,
    constraint FErzgKntCMDInvoker foreign key (ErzgKntCMDInvokerCls) references Cls (id),
    ErzgKntCMDCReceiver number,
    ErzgKntCMDCReceiverCls number,
    constraint FErzgKntCMDCReceiver foreign key (ErzgKntCMDCReceiverCls) references Cls (id),
    ErzgKntCMDMyCmmnDt number,
    ErzgKntCMDMyCmmnDtCls number,
    constraint FErzgKntCMDMyCmmnDt foreign key (ErzgKntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SBchKntCMD nocache;

create table BchKntCMD(
    id number primary key,
    Cls number not null,
    BchKntCMDInvoker number,
    BchKntCMDInvokerCls number,
    constraint FBchKntCMDInvoker foreign key (BchKntCMDInvokerCls) references Cls (id),
    BchKntCMDCReceiver number,
    BchKntCMDCReceiverCls number,
    constraint FBchKntCMDCReceiver foreign key (BchKntCMDCReceiverCls) references Cls (id),
    BchKntCMDMyCmmnDt number,
    BchKntCMDMyCmmnDtCls number,
    constraint FBchKntCMDMyCmmnDt foreign key (BchKntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SArtnMngr nocache;

create table ArtnMngr(
    id number primary key,
    Cls number not null,
    ArtnMngrSbSrvc number,
    ArtnMngrSbSrvcCls number,
    constraint FArtnMngrSbSrvc foreign key (ArtnMngrSbSrvcCls) references Cls (id),
    ArtnMngrThis number,
    ArtnMngrThisCls number,
    constraint FArtnMngrThis foreign key (ArtnMngrThisCls) references Cls (id)    
);

create sequence SCmmndCrdntr nocache;

create table CmmndCrdntr(
    id number primary key,
    Cls number not null    
);

create sequence SCmmnDt nocache;

create table CmmnDt(
    id number primary key,
    Cls number not null,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create sequence SKnt nocache;

create table Knt(
    id number primary key,
    Cls number not null,
    KntKntID varchar2(2000),
    KntGrnzwrt number,
    KntKntstnd number,
    KntMnmm number,
    KntSbSrvc number,
    KntSbSrvcCls number,
    constraint FKntSbSrvc foreign key (KntSbSrvcCls) references Cls (id),
    KntThis number,
    KntThisCls number,
    constraint FKntThis foreign key (KntThisCls) references Cls (id)    
);
create index IKntIDKnt on Knt (KntKntID);


create sequence SKntFcd nocache;

create table KntFcd(
    id number primary key,
    Cls number not null,
    KntFcdSbSrvc number,
    KntFcdSbSrvcCls number,
    constraint FKntFcdSbSrvc foreign key (KntFcdSbSrvcCls) references Cls (id),
    KntFcdThis number,
    KntFcdThisCls number,
    constraint FKntFcdThis foreign key (KntFcdThisCls) references Cls (id)    
);

create sequence STrnsFcd nocache;

create table TrnsFcd(
    id number primary key,
    Cls number not null,
    TrnsFcdTrnsktns number,
    TrnsFcdTrnsktnsCls number,
    constraint FTrnsFcdTrnsktns foreign key (TrnsFcdTrnsktnsCls) references Cls (id),
    TrnsFcdSbSrvc number,
    TrnsFcdSbSrvcCls number,
    constraint FTrnsFcdSbSrvc foreign key (TrnsFcdSbSrvcCls) references Cls (id),
    TrnsFcdThis number,
    TrnsFcdThisCls number,
    constraint FTrnsFcdThis foreign key (TrnsFcdThisCls) references Cls (id)    
);

create sequence SCmmndExctrCommands nocache;

create table CmmndExctrCommands(
    id number primary key,
    frm number not null,
    commands number not null,
    Cls number not null,
    constraint FCmmndExctrCommandsCls foreign key(Cls) references Cls(id),
    constraint FCmmndExctrCommandsfrm foreign key(frm) references CmmndExctr(id)
);
create index IFrmCmmndExctrCommands on CmmndExctrCommands(frm);

create sequence SSubjObs nocache;

create table SubjObs(
    id number primary key,
    frm number not null,
    obs number not null,
    Cls number not null,
    constraint FSubjObsCls foreign key(Cls) references Cls(id),
    constraint FSubjObsfrm foreign key(frm) references Subj(id)
);
create index IFrmSubjObs on SubjObs(frm);

create sequence STrnsktnTrnsfrs nocache;

create table TrnsktnTrnsfrs(
    id number primary key,
    frm number not null,
    trnsfrs number not null,
    Cls number not null,
    constraint FTrnsktnTrnsfrsCls foreign key(Cls) references Cls(id),
    constraint FTrnsktnTrnsfrsfrm foreign key(frm) references Trnsktn(id)
);
create index IFrmTrnsktnTrnsfrs on TrnsktnTrnsfrs(frm);

create sequence STrnsFcdTrnsktnsObs nocache;

create table TrnsFcdTrnsktnsObs(
    id number primary key,
    frm number not null,
    obs number not null,
    Cls number not null,
    constraint FTrnsFcdTrnsktnsObsCls foreign key(Cls) references Cls(id),
    constraint FTrnsFcdTrnsktnsObsfrm foreign key(frm) references TrnsFcdTrnsktns(id)
);
create index IFrmTrnsFcdTrnsktnsObs on TrnsFcdTrnsktnsObs(frm);

create sequence SArtnMngrArtn nocache;

create table ArtnMngrArtn(
    id number primary key,
    frm number not null,
    artn number not null,
    Cls number not null,
    constraint FArtnMngrArtnCls foreign key(Cls) references Cls(id),
    constraint FArtnMngrArtnfrm foreign key(frm) references ArtnMngr(id)
);
create index IFrmArtnMngrArtn on ArtnMngrArtn(frm);

create sequence SCmmndCrdntrExctr nocache;

create table CmmndCrdntrExctr(
    id number primary key,
    frm number not null,
    exctr number not null,
    Cls number not null,
    constraint FCmmndCrdntrExctrCls foreign key(Cls) references Cls(id),
    constraint FCmmndCrdntrExctrfrm foreign key(frm) references CmmndCrdntr(id)
);
create index IFrmCmmndCrdntrExctr on CmmndCrdntrExctr(frm);

create sequence SKntFcdKntn nocache;

create table KntFcdKntn(
    id number primary key,
    frm number not null,
    kntn number not null,
    Cls number not null,
    constraint FKntFcdKntnCls foreign key(Cls) references Cls(id),
    constraint FKntFcdKntnfrm foreign key(frm) references KntFcd(id)
);
create index IFrmKntFcdKntn on KntFcdKntn(frm);

