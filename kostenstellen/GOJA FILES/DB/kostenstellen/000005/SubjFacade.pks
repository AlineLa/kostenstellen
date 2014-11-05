create or replace package SubjFacade is
    
    type SubjAll is record (
        id number,
        Cls number,
        SubjThis number,
        SubjThisCls number
    );
    
    type SubjAllColl is ref cursor return SubjAll;
    
    
    type SubjInfo is record (
        id number,
        This number, 
        ThisCls number        
    );
    
    type SubjInfoColl is ref cursor return SubjInfo;
    
    function getSubj(SubjId number) return SubjInfoColl;
    function newSubj(createMinusStorePlus number) return number;
    function newDelayedSubj return number;
    function getClass(objectId number) return number;
    procedure ThisSet(SubjId number, ThisVal number, ThisCls number);
    function obsGet(SubjId number) return ManyServices.ManyInfoCollection;
    function obsAdd(SubjId number, obsVal number, obsCls number) return number;
    procedure obsRem(obsId number);
    
end SubjFacade;
/

