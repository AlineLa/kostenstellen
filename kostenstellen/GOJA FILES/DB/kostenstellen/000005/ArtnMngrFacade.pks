create or replace package ArtnMngrFacade is
    
    type ArtnMngrAll is record (
        id number,
        Cls number,
        ArtnMngrSbSrvc number,
        ArtnMngrSbSrvcCls number,
        ArtnMngrThis number,
        ArtnMngrThisCls number
    );
    
    type ArtnMngrAllColl is ref cursor return ArtnMngrAll;
    
    
    type ArtnMngrInfo is record (
        id number,
        sbSrvc number, 
        sbSrvcCls number,
        This number, 
        ThisCls number        
    );
    
    type ArtnMngrInfoColl is ref cursor return ArtnMngrInfo;
    
    function getTheArtnMngr return number;
    function getArtnMngr(ArtnMngrId number) return ArtnMngrInfoColl;
    function getClass(objectId number) return number;
    procedure sbSrvcSet(ArtnMngrId number, sbSrvcVal number, sbSrvcCls number);
    procedure ThisSet(ArtnMngrId number, ThisVal number, ThisCls number);
    function artnGet(ArtnMngrId number) return ManyServices.ManyInfoCollection;
    function artnAdd(ArtnMngrId number, artnVal number, artnCls number) return number;
    procedure artnRem(artnId number);
    
end ArtnMngrFacade;
/

