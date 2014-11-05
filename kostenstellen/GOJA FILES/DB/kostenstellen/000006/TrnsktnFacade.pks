create or replace package TrnsktnFacade is
    
    type TrnsktnAll is record (
        id number,
        Cls number,
        TrnsktnSbSrvc number,
        TrnsktnSbSrvcCls number,
        TrnsktnThis number,
        TrnsktnThisCls number
    );
    
    type TrnsktnAllColl is ref cursor return TrnsktnAll;
    
    
    type TrnsktnInfo is record (
        id number,
        sbSrvc number, 
        sbSrvcCls number,
        This number, 
        ThisCls number        
    );
    
    type TrnsktnInfoColl is ref cursor return TrnsktnInfo;
    
    function getTrnsktn(TrnsktnId number) return TrnsktnInfoColl;
    function newTrnsktn(createMinusStorePlus number) return number;
    function newDelayedTrnsktn return number;
    function getClass(objectId number) return number;
    procedure sbSrvcSet(TrnsktnId number, sbSrvcVal number, sbSrvcCls number);
    procedure ThisSet(TrnsktnId number, ThisVal number, ThisCls number);
    function trnsfrsGet(TrnsktnId number) return ManyServices.ManyInfoCollection;
    function trnsfrsAdd(TrnsktnId number, trnsfrsVal number, trnsfrsCls number) return number;
    procedure trnsfrsRem(trnsfrsId number);
    
end TrnsktnFacade;
/

