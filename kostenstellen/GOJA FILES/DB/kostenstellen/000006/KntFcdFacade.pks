create or replace package KntFcdFacade is
    
    type KntFcdAll is record (
        id number,
        Cls number,
        KntFcdSbSrvc number,
        KntFcdSbSrvcCls number,
        KntFcdThis number,
        KntFcdThisCls number
    );
    
    type KntFcdAllColl is ref cursor return KntFcdAll;
    
    
    type KntFcdInfo is record (
        id number,
        sbSrvc number, 
        sbSrvcCls number,
        This number, 
        ThisCls number        
    );
    
    type KntFcdInfoColl is ref cursor return KntFcdInfo;
    
    function getKntFcd(KntFcdId number) return KntFcdInfoColl;
    function newKntFcd(createMinusStorePlus number) return number;
    function newDelayedKntFcd return number;
    function getClass(objectId number) return number;
    procedure sbSrvcSet(KntFcdId number, sbSrvcVal number, sbSrvcCls number);
    procedure ThisSet(KntFcdId number, ThisVal number, ThisCls number);
    function kntnGet(KntFcdId number) return ManyServices.ManyInfoCollection;
    function kntnAdd(KntFcdId number, kntnVal number, kntnCls number) return number;
    procedure kntnRem(kntnId number);
    
end KntFcdFacade;
/

