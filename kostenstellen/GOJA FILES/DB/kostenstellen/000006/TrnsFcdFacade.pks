create or replace package TrnsFcdFacade is
    
    type TrnsFcdAll is record (
        id number,
        Cls number,
        TrnsFcdTrnsktns number,
        TrnsFcdTrnsktnsCls number,
        TrnsFcdSbSrvc number,
        TrnsFcdSbSrvcCls number,
        TrnsFcdThis number,
        TrnsFcdThisCls number
    );
    
    type TrnsFcdAllColl is ref cursor return TrnsFcdAll;
    
    
    type TrnsFcdInfo is record (
        id number,
        trnsktns number, 
        trnsktnsCls number,
        sbSrvc number, 
        sbSrvcCls number,
        This number, 
        ThisCls number        
    );
    
    type TrnsFcdInfoColl is ref cursor return TrnsFcdInfo;
    
    function getTrnsFcd(TrnsFcdId number) return TrnsFcdInfoColl;
    function newTrnsFcd(createMinusStorePlus number) return number;
    function newDelayedTrnsFcd return number;
    function getClass(objectId number) return number;
    procedure trnsktnsSet(TrnsFcdId number, trnsktnsVal number, trnsktnsCls number);
    procedure sbSrvcSet(TrnsFcdId number, sbSrvcVal number, sbSrvcCls number);
    procedure ThisSet(TrnsFcdId number, ThisVal number, ThisCls number);
    
end TrnsFcdFacade;
/

