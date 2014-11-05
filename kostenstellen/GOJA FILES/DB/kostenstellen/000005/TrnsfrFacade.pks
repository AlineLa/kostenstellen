create or replace package TrnsfrFacade is
    
    type TrnsfrAll is record (
        id number,
        Cls number,
        TrnsfrVnKnt number,
        TrnsfrVnKntCls number,
        TrnsfrZKnt number,
        TrnsfrZKntCls number,
        TrnsfrSmm number,
        TrnsfrKntID varchar2(2000),
        TrnsfrSbSrvc number,
        TrnsfrSbSrvcCls number,
        TrnsfrThis number,
        TrnsfrThisCls number
    );
    
    type TrnsfrAllColl is ref cursor return TrnsfrAll;
    
    
    type TrnsfrInfo is record (
        id number,
        vnKnt number, 
        vnKntCls number,
        zKnt number, 
        zKntCls number,
        Smm number,
        KntID varchar2(2000),
        sbSrvc number, 
        sbSrvcCls number,
        This number, 
        ThisCls number        
    );
    
    type TrnsfrInfoColl is ref cursor return TrnsfrInfo;
    
    function getTrnsfr(TrnsfrId number) return TrnsfrInfoColl;
    function newTrnsfr(SmmVal number,KntIDVal varchar2,createMinusStorePlus number) return number;
    function newDelayedTrnsfr return number;
    function getClass(objectId number) return number;
    procedure vnKntSet(TrnsfrId number, vnKntVal number, vnKntCls number);
    procedure zKntSet(TrnsfrId number, zKntVal number, zKntCls number);
    procedure SmmSet(TrnsfrId number, SmmVal number);
    procedure KntIDSet(TrnsfrId number, KntIDVal varchar2);
    procedure sbSrvcSet(TrnsfrId number, sbSrvcVal number, sbSrvcCls number);
    procedure ThisSet(TrnsfrId number, ThisVal number, ThisCls number);
    
end TrnsfrFacade;
/

