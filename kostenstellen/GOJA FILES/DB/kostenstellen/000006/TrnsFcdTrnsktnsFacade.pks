create or replace package TrnsFcdTrnsktnsFacade is
    
    type TrnsFcdTrnsktnsAll is record (
        id number,
        Cls number,
        TrnsFcdTrnsktnsMstr number,
        TrnsFcdTrnsktnsMstrCls number,
        TrnsFcdTrnsktnsThis number,
        TrnsFcdTrnsktnsThisCls number
    );
    
    type TrnsFcdTrnsktnsAllColl is ref cursor return TrnsFcdTrnsktnsAll;
    
    
    type TrnsFcdTrnsktnsInfo is record (
        id number,
        mstr number, 
        mstrCls number,
        This number, 
        ThisCls number        
    );
    
    type TrnsFcdTrnsktnsInfoColl is ref cursor return TrnsFcdTrnsktnsInfo;
    
    function getTrnsFcdTrnsktns(TrnsFcdTrnsktnsId number) return TrnsFcdTrnsktnsInfoColl;
    function newTrnsFcdTrnsktns(createMinusStorePlus number) return number;
    function newDelayedTrnsFcdTrnsktns return number;
    function getClass(objectId number) return number;
    procedure mstrSet(TrnsFcdTrnsktnsId number, mstrVal number, mstrCls number);
    procedure ThisSet(TrnsFcdTrnsktnsId number, ThisVal number, ThisCls number);
    function obsGet(TrnsFcdTrnsktnsId number) return ManyServices.ManyInfoCollection;
    function obsAdd(TrnsFcdTrnsktnsId number, obsVal number, obsCls number) return number;
    procedure obsRem(obsId number);
    
end TrnsFcdTrnsktnsFacade;
/

